package com.boatclub.model.filters;

public class MemberFilters {

    public MemberFilter memberWithNameThatStartWithSi () {
        return new MemberFilterNameThatStartWithSi();
    }

    public MemberFilter memberWithFiveBoats () {
        return new MemberFilterWithFiveBoats();
    }
}
