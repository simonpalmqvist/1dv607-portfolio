package com.boatclub.model;

import java.util.*;

public class BoatClub {
    private ArrayList<Member> members = new ArrayList<>();

    public void createMember (String name, String pno) {
        Member newMember = new Member(name, pno, getNextId());
        members.add(newMember);
    }

    public Member findMember (int id) throws Exception {
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        throw new Exception("Member not found");
    }

    public void deleteMember (int id) throws Exception {
        Member member = findMember(id);
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
