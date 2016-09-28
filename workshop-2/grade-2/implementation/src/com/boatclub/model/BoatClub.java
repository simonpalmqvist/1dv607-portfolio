package com.boatclub.model;

import com.boatclub.data.Storage;

import java.util.ArrayList;

public class BoatClub {
    private ArrayList<Member> members;
    private Storage storage = new Storage("BoatClub");

    public BoatClub () throws Exception {
        initMemberList();
    }

    public void saveMemberData () throws Exception {
        storage.save(members);
    }

    public void addMember(String name, String pno) throws Exception {
        Member newMember = new Member(name, pno, getNextId());
        members.add(newMember);
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


    private void initMemberList () throws Exception {
        if (storage.exists()) {
            members = (ArrayList<Member>) storage.read();
        } else {
            members = new ArrayList<>();
            storage.save(members);
        }
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