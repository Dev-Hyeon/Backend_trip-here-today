package com.devHyun.TodayTrip01.service;


import com.devHyun.TodayTrip01.domain.user.User;
import com.devHyun.TodayTrip01.domain.user.UserRepository;
import com.devHyun.TodayTrip01.web.dto.member.JoinDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;



    /**
     * 회원가입
     * 1. 중복확인(username)
     * 2. 비밀번호 암호화
     *
     *
     * @param joinDto
     */
    @Transactional
    public void join(JoinDto joinDto) throws Exception {

        User user = joinDto.toEntity();

        
        // 1. 중복확인
        duplicateUsername(user);

    }

    
    private void duplicateUsername(User user) throws Exception {

        if (userRepository.existsByUsername(user.getUsername())) {
            throw new Exception("현재 사용중인 USERNAME 입니다.");
        }
    }

}
