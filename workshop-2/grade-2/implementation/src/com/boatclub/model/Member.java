package com.boatclub.model;

import java.util.ArrayList;

public class Member extends PersistenceModel {
    private String name;
    private String pno;
    private int id;
    private ArrayList<Boat> boats = new ArrayList<>();

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

    public Boat getBoat (int index) {
        return boats.get(index);
    }

    public void addBoat (Boat.BoatType type, float length) {
        Boat newBoat = new Boat(type, length);
        boats.add(newBoat);
    }

    public void deleteBoat (int index) {
        Boat boatToRemove = boats.get(index);
        boats.remove(boatToRemove);
    }
}

