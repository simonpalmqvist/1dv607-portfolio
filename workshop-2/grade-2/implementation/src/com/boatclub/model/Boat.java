package com.boatclub.model;

import java.io.Serializable;

public class Boat implements Serializable {

    public enum Type {
        Sailboat,
        Motorsailer,
        KayakOrCanoe,
        Other
    }

    private Type type;
    private float length;

    public Boat (Type type, float length) {
        this.type = type;
        this.length = length;
    }

    public Type getType() {
        return type;
    }

    public float getLength() {
        return length;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setLength(float length) {
        this.length = length;
    }
}
