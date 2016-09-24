package com.boatclub.model

import org.junit.Test

class BoatClubTest {
    @Test
    public void shouldBeAbleToCreateMember () {
        BoatClub club = new BoatClub();
        String name = "Test";
        String pno = "440101-4545";

        club.createMember(name, pno);

        // Member should be added
        assert(club.members.size() == 1);

        // Member should have correct name
        assert(club.members.first().name == name);
        // Member should have correct pno
        assert(club.members.first().pno == pno);
        // Member should have correct memberId
        assert(club.members.first().id == 1);
    }

    @Test
    public void ShouldBeAbleToDeleteMember () {
        BoatClub club = new BoatClub();
        String name = "Test";
        String pno = "440101-4545";

        club.createMember(name, pno);
        club.deleteMember(club.members.first().id);

        // Member should be added
        assert(club.members.size() == 0);
    }

    @Test
    public void ShouldNotGiveNewMemberConflictingId () {
        BoatClub club = new BoatClub();
        String name = "Test";
        String pno = "440101-4545";

        club.createMember(name, pno); // id 1
        club.createMember(name, pno); // id 2

        club.deleteMember(1);

        club.createMember(name, pno); // id 3

        assert(club.members.last().id == 3);
    }
}
