package com.project.crewz.common.db.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Date;

@Getter
@AllArgsConstructor
public class Board {
    private Long no;
    private Long moimNo;
    private String memberId;
    private String title;
    private String content;
    private Date mDate;

    @Override
    public String toString() {
        return "Board{" +
                "no=" + no +
                ", moimNo=" + moimNo +
                ", memberId='" + memberId + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", mDate=" + mDate +
                '}';
    }
}
