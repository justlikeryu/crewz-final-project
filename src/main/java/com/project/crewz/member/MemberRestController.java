package com.project.crewz.member;

import com.project.crewz.common.auth.JWTProvider;
import com.project.crewz.common.db.dto.MemberDto;
import com.project.crewz.common.db.form.MemberForm;
import com.project.crewz.common.s3.AwsS3;
import com.project.crewz.test.Msg;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberRestController {
    private final AwsS3 awsS3;
    private final MemberService memberService;
    private final ModelMapper modelMapper;
    private JWTProvider jwtProvider;
    private AuthenticationManagerBuilder authenticationManagerBuilder;

    //ResponseEntity: HttpHeader와 HttpBody를 포함하는 클래스
    @PostMapping("/join")
    public ResponseEntity<Msg> join(@ModelAttribute final MemberForm form) throws IOException {
        Msg msg = new Msg();

        if (form.getId() == null || form.getPwd() == null) {
            msg.setMsg("입력 오류");
            msg.setObj(null);

            return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            MemberDto d = modelMapper.map(form, MemberDto.class);
            MemberDto dto = memberService.add(d);

            msg.setMsg("가입이 완료되었습니다.");
            msg.setObj(dto);
        }

        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Msg> login(String id, String pwd) {
        Msg msg = new Msg();
        //User토큰 생성
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(id, pwd);
        //생성된 User토큰이 인증 메서드로 전달되어 authenticationManager는 해당 토큰으로 사용자 인증
        //사용자가 검증되면 인증 객체 생성
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(usernamePasswordAuthenticationToken);
        boolean flag = authentication.isAuthenticated();

        if (flag) {
            String token = jwtProvider.createJWT(new MemberDto(id, "", "", null, "", "", ""));
            //todo
        } else {
            msg.setMsg("인증 객체가 존재하지 않습니다.");
        }
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping("/mypage")
    public MemberDto mypage(@RequestHeader("Authorization") String token, MemberDto dto) {
        String id = jwtProvider.getUsernameFromToken(token);
        MemberDto memberDto = null;

        if (id.equals(dto.getId())) {
            memberDto = memberService.read(dto.getId());
        }
        return memberDto;
    }

    @PutMapping("/edit/info")//비밀번호랑 전화번호 수정
    public ResponseEntity<String> edit(@RequestHeader("Authorization") String token, String pwd, String tel) {
        String id = jwtProvider.getUsernameFromToken(token);
        MemberDto dto = memberService.read(id);

        if (pwd == null && tel == null) {
            return ResponseEntity.badRequest().body("수정할 회원정보 값을 확인해주세요.");
        } else if (pwd != null) {
            dto.setPwd(pwd);
        } else if( tel != null){
            dto.setTel(tel);
        }
        memberService.updatePwdByIdNTel(pwd, tel);
        return ResponseEntity.ok("회원 정보 수정이 정상적으로 완료되었습니다.");
    }

    @DeleteMapping("/del")
    public void delete(@RequestHeader("Authorization") String token, @RequestParam("id") String id) {
        memberService.delete(id);
    }

    @GetMapping("/profile/read")
    public ResponseEntity<byte[]> readProfile(String id, String photo) {
        File profile = null;
        String path = "/member/";

        if (!photo.equals("zero"))
            profile = new File(path + File.separator + id);
        else
            profile = new File(path);//todo default.png 저장 위치
        HttpHeaders header = new HttpHeaders();
        ResponseEntity<byte[]> result = null;
        try {
            header.add("Content-Type", Files.probeContentType(profile.toPath()));
            result = new ResponseEntity<byte[]>
                    (FileCopyUtils.copyToByteArray(profile), header, HttpStatus.OK);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @PutMapping("/edit/profile")
    public ResponseEntity<String> updateProfile(@ModelAttribute ProfileForm form) {
        if (form.getId() == null || form.getMf() == null) {
            System.out.println("프로필폼 입력값 확인이 필요합니다.");
        } else if (form.getId() != null && form.getMf() != null) {
            String profile = awsS3.upload(form.getMf(), "/member/" + form.getId());
            boolean flag = memberService.updateProfile(form.getId(), profile);

            if (!flag) {
                return new ResponseEntity<>("프로필 사진을 업로드 할 수 없습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>("프로필 사진 업로드가 완료되었습니다.", HttpStatus.OK);
    }


}
