package com.boatclub.model;

import com.boatclub.data.Storage;
import com.boatclub.exception.MemberNotFoundException;
import com.boatclub.exception.WrongCredentialsException;

import java.util.ArrayList;

public class BoatClub {
    private ArrayList<Member> members;
    private Storage storage = new Storage("BoatClub");
    private boolean isAuthenticated = false;

    public BoatClub () throws Exception {
        initMemberList();
    }

    public void saveMemberData () throws Exception {
        storage.save(members);
    }

    public void addMember(String name, String pno) {
        Member newMember = new Member(name, pno, getNextId());
        members.add(newMember);
    }

    public Member getMember(int id) throws MemberNotFoundException {
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        throw new MemberNotFoundException();
    }

    public Member[] getAllMembers () {
        Member[] allMembers = new Member[members.size()];

        return members.toArray(allMembers);
    }

    public void deleteMember (int id) throws MemberNotFoundException {
        Member member = getMember(id);
        members.remove(member);
    }

    public boolean getIsAuthenticated () {
        return isAuthenticated;
    }

    public void authenticate (String name, String password) throws WrongCredentialsException {
        if (!(name.equals("admin") && password.equals("pass"))) {
            throw new WrongCredentialsException();
        }
        isAuthenticated = true;
    }

    public void unAuthenticate () {
        isAuthenticated = false;
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
