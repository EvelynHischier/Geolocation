package ch.hevs.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Evelyn on 04.03.2015.
 */
public class SQLHelper extends SQLiteOpenHelper {

    /* ************************************************************
	 * 					Database settings
	 **************************************************************/
    private static final String DATABASE_NAME = "geolocation.db";
    private static final int DATABASE_VERSION = 1;

    /* ************************************************************
	 * 					Title of the tables
	 **************************************************************/
    public static final String TABLE_NAME_GPSPoint = "GPSPoint";

    /* ************************************************************
	 * 					Column titles
	 **************************************************************/
    // Title of Columns of GPSData
    public static final String GPSPoint_ID          =  "id";
    public static final String GPSPoint_LONGITUDE   = "longitude";
    public static final String GPSPoint_LATITUDE    = "latitude";
    public static final String GPSPoint_ALTITUDE    = "altitude";
    public static final String GPSPoint_ACCURACY    = "accuracy";
    public static final String GPSPoint_SATELLITES  = "satellites";
    public static final String GPSPoint_TIMESTAMP   = "timestamp";
    public static final String GPSPoint_SPEED       = "speed";
    public static final String GPSPoint_BEARING     = "bearing";

    /* ************************************************************
	 * 					Create statement
	 **************************************************************/
    public static final String TABLE_CREATE_GPSPoint = "CREATE TABLE IF NOT EXISTS "
            + TABLE_NAME_GPSPoint + "(" +
            GPSPoint_ID + " INTEGER PRIMARY KEY," +
            GPSPoint_LONGITUDE + " DOUBLE, " +
            GPSPoint_LATITUDE + " DOUBLE, " +
            GPSPoint_ALTITUDE + " DOUBLE, " +
            GPSPoint_ACCURACY + " FLOAT, " +
            GPSPoint_SATELLITES + " INTEGER, " +
            GPSPoint_TIMESTAMP + " DATE, " +
            GPSPoint_SPEED + " FLOAT, " +
            GPSPoint_BEARING + " FLOAT, "
            + ")";

    /* ************************************************************
	 * 					Constructors
	 **************************************************************/
    public SQLHelper(Context context, SQLiteDatabase.CursorFactory factory) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    public SQLHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    /* ************************************************************
	 * 					Methods
	 **************************************************************/
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_GPSPoint);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Delete the old table
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_GPSPoint);

        // create a fresh table
        onCreate(db);
    }
}
