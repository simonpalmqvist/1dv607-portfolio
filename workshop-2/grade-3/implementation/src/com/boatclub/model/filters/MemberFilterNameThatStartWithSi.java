package com.boatclub.model.filters;

import com.boatclub.model.Member;

class MemberFilterNameThatStartWithSi implements MemberFilter  {

    public boolean pass (Member member) {
        return member.getName().toLowerCase().startsWith("si");
    }
}
