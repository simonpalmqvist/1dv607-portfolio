package com.boatclub.controller;

import com.boatclub.model.Member;
import com.boatclub.view.ConsoleMember;

public class MemberController {

    private ConsoleMember ui = new ConsoleMember();

    public void showMember(Member member) {
        ui.displayMember(member.getName(), member.getPno(), member.getId());
    }
}
