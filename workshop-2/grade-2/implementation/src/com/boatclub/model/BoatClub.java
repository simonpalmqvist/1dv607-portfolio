package com.boatclub.model;

import java.util.ArrayList;

public class BoatClub {
    private ArrayList<Member> members = new ArrayList<>();

    public void addMember(String name, String pno) {
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

    private int getNextId () {
        int maxId = members
                .stream()
                .mapToInt(Member::getId)
                .max()
                .orElse(0);

        return maxId + 1;
    }
}
