package com.test;

import com.deneme.Korku.Hikayeleri.KorkuHikayeleriApplication;
import com.deneme.Korku.Hikayeleri.entity.CommentEntity;
import com.deneme.Korku.Hikayeleri.entity.UserEntity;
import com.deneme.Korku.Hikayeleri.repository.CommentRepository;
import com.deneme.Korku.Hikayeleri.repository.UserRepository;
import com.deneme.Korku.Hikayeleri.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = KorkuHikayeleriApplication.class)
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @BeforeEach
    void setup()throws Exception{

//        UserEntity userEntity = new UserEntity();
//        userEntity.setActiveUser(true);
//        userEntity.setEmailVerificationStatus(true);
//        userEntity.setEmail("halilcorak22@gmail.com");
//        userEntity.setFirstName("halil");
//        userEntity.setLastName("corak");
//        userEntity.setUserName("hmc22");
//        userEntity.setUserId("hmc");
//        userEntity.setEncryptedPassword("$10$tH0VGiNSYXVoyL5PAC6QO./mMmy7NvQnXV5VLZzawcpl3w0xjJ.6.");
//        userRepository.save(userEntity);

//        CommentEntity commentEntity = new CommentEntity();
//        commentEntity.setStoryID(1L);
//        commentEntity.setDeleted(true);
//        commentEntity.setIsActive("Y");
//        commentEntity.setCommentText("bok gibi");
//        commentEntity.setUserID("hmc");
//        commentEntity.setUserName("hmc22");
//
//        commentRepository.save(commentEntity);

        userService.deleteUser("hmc22");
    }

    @Test
    final void testGetActiveComments(){
        Long storyId = 1L;
        List<CommentEntity> commentEntityList= commentRepository.getUserCommentsByStoryIDAndIsActiveAndDeleted(storyId);
        System.out.println(commentEntityList.size());
        Assertions.assertNotNull(commentEntityList);

    }

    @Test
    final void  testUserLogin(){
        String userName="emre";
        UserEntity userEntity = userRepository.findByUserName(userName);
        System.out.println(userEntity.getActiveUser());
    }

}
