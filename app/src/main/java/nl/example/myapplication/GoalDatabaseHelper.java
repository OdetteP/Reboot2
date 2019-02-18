package nl.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GoalDatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Goals";
    private static final String TABLE_NAME = "G";
    private static final String COLUMN_GOAL = "goal";
    private static final String COLUMN_WHERE = "mWhere";
    private static final String COLUMN_WHEN = "mWhen";
    private static final String COLUMN_HOW = "how";
//    private static final String COLUMN_PRECISE = "precise";
    private static final String COLUMN_MORE = "more";
    private static final String COLUMN_ID = "id";


    GoalDatabaseHelper(Context context) {super(context, DATABASE_NAME, null, 1);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_GOAL + " STRING, " +
                COLUMN_WHERE + " STRING, " +
                COLUMN_WHEN + " STRING, " +
                COLUMN_HOW + " STRING, " +
//                COLUMN_PRECISE + " STRING, " +
                COLUMN_MORE + " STRING);";
        db.execSQL(CREATE_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public long insertData (String goal, String mWhere, String mWhen, String how, String more) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_GOAL, goal);
        contentValues.put(COLUMN_WHERE, mWhere);
        contentValues.put(COLUMN_WHEN, mWhen);
        contentValues.put(COLUMN_HOW, how);
//        contentValues.put(COLUMN_PRECISE, precise);
        contentValues.put(COLUMN_MORE, more);

        long id = db.insert(TABLE_NAME, null, contentValues);

        return id;
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data  = db.rawQuery(query, null);
        return data;
    }


}
