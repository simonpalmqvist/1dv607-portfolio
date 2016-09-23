package com.boatclub.model;

import java.util.ArrayList;

public class BoatClub {
    private ArrayList<Member> members = new ArrayList<>();

    public void createMember (String name, String pno) {
        Member newMember = new Member(name, pno, members.size());
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

    public void deleteMember (int id) {
        try {
            Member member = findMember(id);
            members.remove(member);
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}
