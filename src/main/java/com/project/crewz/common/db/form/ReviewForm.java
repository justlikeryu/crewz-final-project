package com.project.crewz.common.db.form;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
public class ReviewForm {
    private String memberId;
    private Long somoimNo;
    private String content;
    private MultipartFile[] photo;


}
