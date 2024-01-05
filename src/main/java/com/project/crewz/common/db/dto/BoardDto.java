package com.project.crewz.common.db.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {
    private Long no;
    private Long moimNo;
    private String memberId;
    private String title;
    private String content;
    private Date mDate;

    @Override
    public String toString() {
        return "BoardDto{" +
                "no=" + no +
                ", moimNo=" + moimNo +
                ", memberId='" + memberId + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", mDate=" + mDate +
                '}';
    }
}
