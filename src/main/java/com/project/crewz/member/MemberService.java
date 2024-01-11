package com.project.crewz.member;

import com.project.crewz.common.db.dto.MemberDto;
import com.project.crewz.common.db.vo.Member;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberDao memberDao;
    private PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    public MemberDto add(MemberDto dto) {
        MemberDto memberDto = null;

        dto.setPwd(passwordEncoder.encode(dto.getPwd()));

        Member member = modelMapper.map(dto, Member.class);

        try {
            int cnt = memberDao.insert(member);
            if (cnt > 0) {
                memberDto = modelMapper.map(memberDao.select(dto.getId()), MemberDto.class);
            }
        } catch (DataAccessException e) {
            System.out.println("CategoryService::add -> " + e.getCause());
        }
        return memberDto;
    }

//    public MemberDto read(String id, String pwd) {
//        MemberDto memberDto = null;
//
//        try {
//            Member member = memberDao.selectByMember(id, pwd);
//            if (passwordEncoder.matches(pwd, member.getPwd())) {
//                memberDto = modelMapper.map(member, MemberDto.class);
//            } else {
//                System.out.println("회원정보를 찾을 수 없습니다.");
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return memberDto;
//    }

    public MemberDto read(String id) {
        MemberDto memberDto = null;

        Member member = memberDao.select(id);
        if (member != null) {
            memberDto = modelMapper.map(member, MemberDto.class);
        } else {
            System.out.println("회원을 찾을 수 없습니다.");
        }
        return memberDto;
    }

    public MemberDto edit(MemberDto dto, String pwd, String tel) {
        MemberDto updatedMemberDto = null;

        Member member = memberDao.select(dto.getId());
        if (pwd != null && tel != null) {
            dto.setPwd(passwordEncoder.encode(pwd));
            dto.setTel(tel);
        } else if (pwd != null) {
            dto.setPwd(passwordEncoder.encode(pwd));
        } else if (tel != null) {
            dto.setTel(tel);
        }

        memberDao.update(member);
        updatedMemberDto = modelMapper.map(member, MemberDto.class);
        return updatedMemberDto;
    }

    public void delete(String id) {
        memberDao.delete(id);
    }

    public int checkIdDuplicated(String id) {
        return memberDao.selectCountById(id);
    }

    public String findIdByNameNTel(String name, String tel) {
        return memberDao.selectIdByNameNTel(name, tel);
    }

    public String updatePwdByIdNTel(String id, String tel) {
        return memberDao.updatePwdByIdNTel(id, tel);
    }

    public boolean updateProfile(String id, String profile) {
        boolean flag = false;

        try {
            int cnt = memberDao.updateProfile(id, profile);
            if (cnt > 0) flag = true;
        } catch (DataAccessException e) {
            System.out.println("MemberService::updateProfile -> " + e.getCause());
        }
        return flag;
    }

}
