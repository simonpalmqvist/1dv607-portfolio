package com.boatclub.model;

public class Member {
    private String name;
    private String pno;
    private int id;

    public Member(String name, String pno, int id) {
        this.name = name;
        this.pno = pno;
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public String getPno () {
        return pno;
    }

    public int getId () {
        return id;
    }
}

