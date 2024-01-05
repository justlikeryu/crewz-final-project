package com.project.crewz.common.db.form;

import lombok.Getter;

@Getter
public class MoimSubForm {
    private Long moimNo;
    private String memberId;

    @Override
    public String toString() {
        return "SubMoimForm{" +
                "moimNo=" + moimNo +
                ", memberId='" + memberId + '\'' +
                '}';
    }
}
