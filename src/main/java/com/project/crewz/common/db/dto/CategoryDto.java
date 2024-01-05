package com.project.crewz.common.db.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Long no;
    private String name;
    private String photo;
    private Long total;

    @Override
    public String toString() {
        return "CategoryDto{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                ", total=" + total +
                '}';
    }
}
