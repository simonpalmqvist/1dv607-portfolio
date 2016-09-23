package com.boatclub.model;

import java.util.ArrayList;

public class BoatClub {
    private ArrayList<Member> members = new ArrayList<>();

    public void createMember (String name, String pno) {
        Member newMember = new Member(name, pno, members.size());
        members.add(newMember);
    }

    public Member findMember (int id) {
        return members.get(id);
    }
}
