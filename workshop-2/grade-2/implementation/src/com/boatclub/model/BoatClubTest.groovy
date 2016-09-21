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
        assert(club.members.get(0).name == name);
        // Member should have correct pno
        assert(club.members.get(0).pno == pno);
        // Member should have correct memberId
        assert(club.members.get(0).memberId == 0);
    }
}
