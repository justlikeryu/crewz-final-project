package com.project.crewz.common.db.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Date;

@Getter
@AllArgsConstructor
public class Member {
    private String id;
    private String pwd;
    private String name;
    private Date birth;
    private String tel;
    private String profile;
    private String site;
    private String role;

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", tel='" + tel + '\'' +
                ", profile='" + profile + '\'' +
                ", site='" + site + '\'' +
                '}';
    }
}
