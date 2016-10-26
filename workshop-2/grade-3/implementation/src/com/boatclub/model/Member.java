package com.boatclub.model;

import com.boatclub.exception.BoatNotFoundException;

import java.io.Serializable;
import java.util.ArrayList;

public class Member implements Serializable {
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

    public int getNumberOfBoats () {
        return boats.size();
    }

    public Boat getBoat (int index) throws BoatNotFoundException {
        boatExists(index);

        return boats.get(index);
    }

    public Boat[] getBoats () {
        Boat[] allBoats = new Boat[boats.size()];

        return boats.toArray(allBoats);
    }

    public void addBoat (Boat.Type type, float length) {
        Boat newBoat = new Boat(type, length);
        boats.add(newBoat);
    }

    public void deleteBoat (int index) throws BoatNotFoundException {
        boatExists(index);

        boats.remove(index);
    }

    private void boatExists (int index) throws BoatNotFoundException {
        if (boats.size() <= index) {
            throw new BoatNotFoundException();
        }
    }
}

