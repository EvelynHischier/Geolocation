package ch.hevs.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Evelyn on 04.03.2015.
 */
public class LocalDatabaseAccess {

    private static SQLHelper helper;
    private static SQLiteDatabase database;

    /* ************************************************************
	 * 					Connection
	 **************************************************************/

    // open writable connection
    private static void openConnection(Context context){
        helper = new SQLHelper(context);
        database = helper.getWritableDatabase();
    }

    // close connection
    public static void closeConnection(){
        database.close();
        helper.close();
    }

     /* ************************************************************
	 * 					Save objects local on the phone
	 **************************************************************/
     public static long writeGPSPoint(Context context, GPSPoint point) {
         long state;
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

         openConnection(context);

         ContentValues values = new ContentValues();
         values.put(SQLHelper.GPSPoint_ACCURACY, point.getAccuracy());
         values.put(SQLHelper.GPSPoint_ALTITUDE, point.getAltitude());
         values.put(SQLHelper.GPSPoint_BEARING, point.getBearing());
         values.put(SQLHelper.GPSPoint_LATITUDE, point.getLatitude());
         values.put(SQLHelper.GPSPoint_LONGITUDE, point.getLongitude());
         values.put(SQLHelper.GPSPoint_SATELLITES, point.getSatellites());
         values.put(SQLHelper.GPSPoint_SPEED, point.getSpeed());
         values.put(SQLHelper.GPSPoint_TIMESTAMP,
                 dateFormat.format(Calendar.getInstance().getTime()));

         state = database.insert(SQLHelper.TABLE_NAME_GPSPoint, null, values);
         closeConnection();
         return state;
     }

    public static List<GPSPoint> readGPSPoint(Context context) {
        List<GPSPoint> points = new ArrayList<>();
        GPSPoint point;
        Cursor cursor;
        String dateText;

        openConnection(context);
        String sql = "SELECT * FROM "+SQLHelper.TABLE_NAME_GPSPoint;
        cursor = database.rawQuery(sql, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            point = new GPSPoint();
            point.setAccuracy(cursor.getFloat(cursor.getColumnIndex(SQLHelper.GPSPoint_ACCURACY)));
            point.setAltitude(cursor.getDouble(cursor.getColumnIndex(SQLHelper.GPSPoint_ALTITUDE)));
            point.setBearing(cursor.getFloat(cursor.getColumnIndex(SQLHelper.GPSPoint_BEARING)));
            point.setId(cursor.getLong(cursor.getColumnIndex(SQLHelper.GPSPoint_ID)));
            point.setLatitude(cursor.getDouble(cursor.getColumnIndex(SQLHelper.GPSPoint_LATITUDE)));
            point.setLongitude(cursor.getDouble(cursor.getColumnIndex(SQLHelper.GPSPoint_LONGITUDE)));
            point.setSatellites(cursor.getInt(cursor.getColumnIndex(SQLHelper.GPSPoint_SATELLITES)));
            point.setTimestamp(cursor.getString(cursor.getColumnIndex(SQLHelper.GPSPoint_TIMESTAMP)));

            points.add(point);
            cursor.moveToNext();
        }
        cursor.close();
        closeConnection();
        return points;
    }

}
