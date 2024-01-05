package com.project.crewz.common.db.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Date;

@Getter
@AllArgsConstructor
public class MoimSub {
    private Long moimNo;
    private String memberId;
    private Date iDate;

    @Override
    public String toString() {
        return "MoimSub{" +
                "moimNo=" + moimNo +
                ", memberId='" + memberId + '\'' +
                ", iDate=" + iDate +
                '}';
    }
}
