package com.test;

import com.deneme.Korku.Hikayeleri.KorkuHikayeleriApplication;
import com.deneme.Korku.Hikayeleri.service.UserServiceImpl;
import com.deneme.Korku.Hikayeleri.shared.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = KorkuHikayeleriApplication.class)
public class StoryRepositoryTest {

    @Autowired
    UserServiceImpl userService;

//    @Autowired
//    StoryRepository storyRepository;

//    @Test
//    public void getStories(){
//        List<StoryEntity> storyEntities =storyRepository.getAllByIsActive("Y");
//
//        for (StoryEntity s:storyEntities
//             ) {
//            System.out.println(s.getId());
//        }
//
//    }

//    @BeforeEach
//    void setup()throws Exception {
//
//    }


    @Test
    public void getVerification(){
        UserDto userDto = new UserDto();
        userDto.setFirstName("Halil");
        userDto.setLastName("Corak");
        userDto.setPassword("123");
        userDto.setUserName("hmc22");
        userDto.setEmail("halilcorak22@gmail.com");


        userService.createUser(userDto);


    }


    @Test
    public void getPasswordReset(){
        String email = "halilcorak22@gmail.com";
        userService.requestPasswordReset(email);
    }



}
