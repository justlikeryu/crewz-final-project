package com.project.crewz.common.db.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MoimSubDto {
    private Long moimNo;
    private String memberId;
    private String iDate;
    private String black;

    @Override
    public String toString() {
        return "SubMoim{" +
                "moimNo=" + moimNo +
                ", memberId='" + memberId + '\'' +
                ", iDate='" + iDate + '\'' +
                ", black='" + black + '\'' +
                '}';
    }
}
