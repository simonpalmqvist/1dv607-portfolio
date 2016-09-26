package com.boatclub.model;

public class Boat {

    public enum BoatType {
        Sailboat,
        Motorsailer,
        KayakOrCanoe,
        Other
    }

    private BoatType type;
    private float length;

    public Boat (BoatType type, float length) {
        this.type = type;
        this.length = length;
    }
}
