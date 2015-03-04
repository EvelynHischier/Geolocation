package ch.hevs.storage;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Evelyn on 04.03.2015.
 */
public class GPSPoint implements Serializable{

    private Long id;
    private double longitude;
    private double latitude;
    private double altitude;
    private float accuracy;
    private float speed;
    private float bearing;
    private int satellites;
    private Date timestamp;

    /* ************************************************************
	 * 					Constructors
	 **************************************************************/
    // Empty constructor
    public GPSPoint(){
        timestamp = new Date();
    }

    public GPSPoint(double longitude, double latitude, double altitude, float accuracy, float speed, float bearing, int satellites) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.altitude = altitude;
        this.accuracy = accuracy;
        this.speed = speed;
        this.bearing = bearing;
        this.satellites = satellites;
    }

     /* ************************************************************
	 * 					Getters and Setters
	 **************************************************************/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getBearing() {
        return bearing;
    }

    public void setBearing(float bearing) {
        this.bearing = bearing;
    }

    public int getSatellites() {
        return satellites;
    }

    public void setSatellites(int satellites) {
        this.satellites = satellites;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}

