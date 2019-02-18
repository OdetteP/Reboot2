package nl.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class PositiveThoughtsDatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Positive Thoughts";
    private static final String TABLE_NAME = "PT";
    private static final String COLUMN_ID = "idp";
    private static final String COLUMN_PT = "positiveThoughts";
    private static final String COLUMN_GOAL_ID = "goalId";

    PositiveThoughtsDatabaseHelper(Context context) {super(context, DATABASE_NAME, null, 1);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PT + " STRING, " +
                COLUMN_GOAL_ID + " INTEGER);";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public long insertData (String positiveThoughts, Long goalId) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_PT, positiveThoughts);
        contentValues.put(COLUMN_GOAL_ID, goalId);

        long id = db.insert(TABLE_NAME, null, contentValues);

        return id;
    }

    public List<String> getPositiveThoughtsFor(long goalId) {
        final SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> arrayOfPositiveThoughtForGoal = new ArrayList<>();
            db.beginTransaction();
            try {
                String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_GOAL_ID + " = " + goalId;
                Cursor cursor = db.rawQuery(selectQuery, null);

                    if (cursor.getCount() > 0) {
                        while (cursor.moveToNext()) {
                            String positiveThoughts = cursor.getString(cursor.getColumnIndex("positiveThoughts"));
                            arrayOfPositiveThoughtForGoal.add(positiveThoughts);
                        }
                    }

                db.setTransactionSuccessful();
            } catch (SQLiteException e) {
                e.printStackTrace();

            } finally {
                db.endTransaction();
                // End the transaction.
                db.close();
                // Close database

            }return arrayOfPositiveThoughtForGoal;
    }

//    public String[] getPositiveThoughtsFor(Long mgoalId) {
//        final SQLiteDatabase db = this.getReadableDatabase();
//        ArrayList<String> arrayOfPositiveThoughtForGoal = new ArrayList<>();
//        db.beginTransaction();
//        try {
//            String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_GOAL_ID + " = " + mgoalId;
//            Cursor cursor = db.rawQuery(selectQuery, null);
//
//            if (cursor.getCount() > 0) {
//            while (cursor.moveToNext()) {
//                    String positiveThought = cursor.getColumnName(1);
//                    arrayOfPositiveThoughtForGoal.add(positiveThought);
//                }
//            }
//
//            db.setTransactionSuccessful();
//        } catch (SQLiteException e) {
//            e.printStackTrace();
//
//        } finally {
//            db.endTransaction();
//            // End the transaction.
//            db.close();
//            // Close database
//        }
//        return arrayOfPositiveThoughtForGoal.toArray(new String[0]);
//    }


}