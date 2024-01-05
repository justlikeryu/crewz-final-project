package com.project.crewz.common.db.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Review {
    private Long no;
    private String memberId;
    private Long somoimNo;
    private String content;
    private String photo1;
    private String photo2;
    private String photo3;
    private String mDate;

    @Override
    public String toString() {
        return "Review{" +
                "no=" + no +
                ", memberId='" + memberId + '\'' +
                ", somoimNo=" + somoimNo +
                ", content='" + content + '\'' +
                ", photo1='" + photo1 + '\'' +
                ", photo2='" + photo2 + '\'' +
                ", photo3='" + photo3 + '\'' +
                ", mDate='" + mDate + '\'' +
                '}';
    }
}
