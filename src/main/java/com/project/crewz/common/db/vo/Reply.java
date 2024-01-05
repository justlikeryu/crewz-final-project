package com.project.crewz.common.db.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Date;

@Getter
@AllArgsConstructor
public class Reply {
    private Long no;
    private Long reviewNo;
    private String memberId;
    private String content;
    private Date mDate;

    @Override
    public String toString() {
        return "Comment{" +
                "no=" + no +
                ", reviewNo=" + reviewNo +
                ", memberId='" + memberId + '\'' +
                ", content='" + content + '\'' +
                ", mDate=" + mDate +
                '}';
    }
}
