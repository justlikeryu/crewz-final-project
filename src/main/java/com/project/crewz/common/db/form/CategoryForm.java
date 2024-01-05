package com.project.crewz.common.db.form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter
public class CategoryForm {
    private String name;
    private MultipartFile mf;

    @Override
    public String toString() {
        return "CategoryForm{" +
                "name='" + name + '\'' +
                ", mf=" + mf +
                '}';
    }
}