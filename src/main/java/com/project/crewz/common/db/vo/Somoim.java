package com.project.crewz.common.db.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Date;

@Getter
@AllArgsConstructor
public class Somoim {
    private Long no;
    private String memberId;
    private Long moimNo;
    private String title;
    private String content;
    private Date mDate;
    private String loc;
    private String total;
    private String photo1;
    private String photo2;
    private String photo3;

    @Override
    public String toString() {
        return "Somoim{" +
                "no=" + no +
                ", memberId='" + memberId + '\'' +
                ", moimNo=" + moimNo +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", mDate=" + mDate +
                ", loc='" + loc + '\'' +
                ", total='" + total + '\'' +
                ", photo1='" + photo1 + '\'' +
                ", photo2='" + photo2 + '\'' +
                ", photo3='" + photo3 + '\'' +
                '}';
    }
}
