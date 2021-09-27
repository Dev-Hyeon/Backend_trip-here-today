package com.devHyun.TodayTrip01.service;

import com.devHyun.TodayTrip01.domain.user.User;
import com.devHyun.TodayTrip01.domain.user.UserRepository;
import com.devHyun.TodayTrip01.web.dto.member.JoinDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    
    @DisplayName("username 중복확인")
    @Test
    public void duplicateUsernameTest() throws Exception{
        //given
        JoinDto joinDto1 = createJoinDto();
        JoinDto joinDto2 = createJoinDto();

        userRepository.save(joinDto1.toEntity());

        //when
        
        //then
        assertThatThrownBy(() -> userService.join(joinDto2))
                .isInstanceOf(Exception.class)
                .hasMessage("현재 사용중인 USERNAME 입니다.");

    }

    @DisplayName("비밀번호 암호화")
    @Test
    public void bcryptPwTest() throws Exception{
        //given
        JoinDto joinDto = createJoinDto();
        User user = joinDto.toEntity();

        //when
        userService.bcryptPw(user);

        //then
        Assertions.assertThat(user.getPassword()).isNotEqualTo("1234");
    }

    @DisplayName("회원가입")
    @Test
    public void joinUserTest() throws Exception{
        //given
        JoinDto joinDto = createJoinDto();


        //when
        userService.join(joinDto);

        //then
        Assertions.assertThat(userRepository.count()).isEqualTo(1l);

    }




    private JoinDto createJoinDto() {

        JoinDto joinDto = new JoinDto();
        joinDto.setName("이의현");
        joinDto.setPassword("1234");
        joinDto.setEmail("sdfds@naver.com");
        joinDto.setUsername("의현");

        return joinDto;
    }






}