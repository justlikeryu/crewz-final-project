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
public class SomoimSubDto {
    private Long somoimNo;
    private String memberId;
    private Date iDate;
    private String black;

    @Override
    public String toString() {
        return "SubSomoim{" +
                "somoimNo=" + somoimNo +
                ", memberId='" + memberId + '\'' +
                ", iDate=" + iDate +
                ", black='" + black + '\'' +
                '}';
    }
}
