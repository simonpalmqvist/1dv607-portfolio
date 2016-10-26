package com.boatclub.model.filters;

import com.boatclub.model.Member;

class MemberFilterWithFiveBoats implements MemberFilter  {

    public boolean pass (Member member) {
        return member.getBoats().length == 5;
    }
}
