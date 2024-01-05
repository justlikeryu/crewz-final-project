package com.project.crewz.common.db.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Date;

@Getter
@AllArgsConstructor
public class Moim {
    private Long no;
    private Long categoryNo;
    private String memberId;
    private String info;
    private String title;
    private String content;
    private String photo1;
    private String photo2;
    private String photo3;
    private Date mDate;

    @Override
    public String toString() {
        return "Moim{" +
                "no=" + no +
                ", categoryNo=" + categoryNo +
                ", memberId='" + memberId + '\'' +
                ", info='" + info + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", photo1='" + photo1 + '\'' +
                ", photo2='" + photo2 + '\'' +
                ", photo3='" + photo3 + '\'' +
                ", mDate=" + mDate +
                '}';
    }
}
