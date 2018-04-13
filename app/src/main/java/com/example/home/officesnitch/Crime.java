package com.example.home.officesnitch;

import android.location.Location;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Home on 4/3/18.
 */

public class Crime {

    private UUID mID;
    private String mTitle;
    private Date mDate;
    private Location mLocation;
    private boolean mSolved;
    private int mSeverity;

    public Crime() {
        mID = UUID.randomUUID();
        mTitle = "";
        mDate = new Date();
        mSolved = false;
        mSeverity = 0;
    }

    public UUID getID() {
        return mID;
    }

    public void setID(UUID ID) {
        mID = ID;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public Location getLocation() {
        return mLocation;
    }

    public void setLocation(Location location) {
        mLocation = location;
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public int getSeverity() {
        return mSeverity;
    }

    public void setSeverity(int severity) {
        mSeverity = severity;
    }
}
