package com.boatclub.model.filters;

import com.boatclub.model.Member;

public interface MemberFilter {
    boolean pass (Member member);
}
