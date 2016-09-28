package com.boatclub.model;

import com.boatclub.persistence.Storage;

import java.util.ArrayList;

public class BoatClub extends PersistenceModel {
    private ArrayList<Member> members;
    private Storage storage = new Storage("BoatClub");

    public BoatClub () {
        try {
            if (storage.exists()) {
                members = (ArrayList<Member>) storage.read();
            } else {
                members = new ArrayList<>();
                storage.save(members);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addMember(String name, String pno) throws Exception {
        Member newMember = new Member(name, pno, getNextId());
        members.add(newMember);
        storage.save(members);
    }

    public Member getMember(int id) throws Exception {
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        throw new Exception("Member not found");
    }

    public void deleteMember (int id) throws Exception {
        Member member = getMember(id);
        members.remove(member);
    }

    private int getNextId () {
        int maxId = members
                .stream()
                .mapToInt(Member::getId)
                .max()
                .orElse(0);

        return maxId + 1;
    }
}
