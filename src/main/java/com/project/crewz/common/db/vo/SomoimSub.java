package com.project.crewz.common.db.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Date;

@Getter
@AllArgsConstructor
public class SomoimSub {
    private Long somoimNo;
    private String memberId;
    private Date iDate;

    @Override
    public String toString() {
        return "SomoimSub{" +
                "somoimNo=" + somoimNo +
                ", memberId='" + memberId + '\'' +
                ", iDate=" + iDate +
                '}';
    }
}
