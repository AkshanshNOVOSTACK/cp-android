package com.novostack.cp_android.ModelClasses;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class MyRides {

    String partnerName, timestamp, halfPrice, fullPrice, startingPoint, EndPoint1, EndPoint2, profilePicture;

    public MyRides(String partnerName, String timestamp, String halfPrice, String fullPrice, String startingPoint, String endPoint1, String endPoint2, String profilePicture) {
        this.partnerName = partnerName;
        this.timestamp = timestamp;
        this.halfPrice = halfPrice;
        this.fullPrice = fullPrice;
        this.startingPoint = startingPoint;
        EndPoint1 = endPoint1;
        EndPoint2 = endPoint2;
        this.profilePicture = profilePicture;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getHalfPrice() {
        return halfPrice;
    }

    public String getFullPrice() {
        return fullPrice;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public String getEndPoint1() {
        return EndPoint1;
    }

    public String getEndPoint2() {
        return EndPoint2;
    }

    public String getProfilePicture() {
        return profilePicture;
    }


}
