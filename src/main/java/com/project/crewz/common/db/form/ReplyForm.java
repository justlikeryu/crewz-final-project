package com.project.crewz.common.db.form;

import lombok.Getter;

@Getter
public class ReplyForm {
    private Long reviewNo;
    private String memberId;
    private String content;

    @Override
    public String toString() {
        return "CommentForm{" +
                "reviewNo=" + reviewNo +
                ", memberId='" + memberId + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
