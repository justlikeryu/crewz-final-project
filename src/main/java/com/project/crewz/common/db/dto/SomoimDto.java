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
public class SomoimDto {
    private int no;
    private String memberId;
    private int moimNo;
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
