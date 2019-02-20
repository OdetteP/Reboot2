package nl.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MeDatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Photo";
    private static final String TABLE_NAME = "Photo";
    private static final String COLUMN_IMAGE_URL = "img_url";
    private static final String COLUMN_ID = "id";

    public MeDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_IMAGE = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_IMAGE_URL + " STRING );";
        Log.i("Table..", "Created");
        db.execSQL(CREATE_TABLE_IMAGE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public long insertDestinationURLForPhoto(String img_url) {
        SQLiteDatabase db = this.getWritableDatabase();
//        db.beginTransaction();
        ContentValues values = new ContentValues();
        values.put(COLUMN_IMAGE_URL, img_url);

        long id = db.insert(TABLE_NAME, null, values);
//        db.setTransactionSuccessful();
        Log.i("Image..", "Inserted..");
        db.close();

        return id;

    }


    public List<String> getImageUrlsForPhoto() {
        final SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> arrayOfUrlsForGoal = new ArrayList<>();
        db.beginTransaction();
        try {
            String selectQuery = "SELECT * FROM " + TABLE_NAME;
            Cursor cursor = db.rawQuery(selectQuery, null);

            if (cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    String imageURL = cursor.getString(cursor.getColumnIndex("img_url"));
                    arrayOfUrlsForGoal.add(imageURL);
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
        }
        return arrayOfUrlsForGoal;
    }
}
