package com.project.crewz.member;

import com.project.crewz.common.db.vo.Member;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository//명시적으로 확인하기 위함.
public interface MemberDao {
    //회원 가입 시 profile은 null로 처리함.
    @Insert("INSERT INTO member VALUES(#{id}, #{pwd}, #{name}, #{birth}, #{tel}, #{profile, jdbcType=VARCHAR}, default)")
    int insert(Member m);//입력된 레코드의 수를 반환함.

    @Select("SELECT id, pwd FROM member WHERE id = #{id} AND pwd = #{pwd}")
    Member selectByMember(@Param("id") String id, @Param("pwd") String pwd);

    @Select("SELECT * FROM member WHERE id=#{id}")
    Member select(@Param("id") String id);

    @Update("UPDATE member SET pwd=#{pwd}, tel = #{tel} WHERE id=#{id}")
    void update(Member m);

    @Delete("DELETE FROM member WHERE id=#{id}")
    void delete(@Param("id") String id);

    @Select("SELECT count(*) FROM member WHERE id=#{id}")
    int selectCountById(@Param("id") String id);

    @Select("SELECT id FROM member WHERE name=#{name} AND tel=#{tel}")
    String selectIdByNameNTel(@Param("name") String name, @Param("tel") String tel);

    @Select("UPDATE member SET pwd=#{pwd} FROM member WHERE id=#{id} AND tel=#{tel}")
    String updatePwdByIdNTel(@Param("id") String id, @Param("tel") String tel);

    @Update("UPDATE member SET profile=#{profile} WHERE id=#{id}")
    int updateProfile(@Param("id") String id, @Param("profile") String profile);
}
