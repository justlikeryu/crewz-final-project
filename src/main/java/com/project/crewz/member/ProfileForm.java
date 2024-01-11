package com.project.crewz.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@AllArgsConstructor
public class ProfileForm {
    private String id;
    private MultipartFile mf;

    @Override
    public String toString() {
        return "ProfileForm{" +
                "id='" + id + '\'' +
                ", mf='" + mf +
                '}';
    }
}
