package com.deneme.Korku.Hikayeleri.repository;

import com.deneme.Korku.Hikayeleri.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    UserEntity findByEmail(String email);


    //Find by username eklenecek.

}
