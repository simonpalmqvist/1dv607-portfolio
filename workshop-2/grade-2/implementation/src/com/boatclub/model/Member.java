package com.boatclub.model;

public class Member {
    private String name;
    private String pno;
    private int id;

    Member(String name, String pno, int id) {
        this.name = name;
        this.pno = pno;
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String newName) {
        name = newName;
    }

    public String getPno () {
        return pno;
    }

    public void setPno (String newPno) {
        pno = newPno;
    }

    public int getId () {
        return id;
    }
}

