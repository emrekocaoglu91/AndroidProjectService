package com.deneme.Korku.Hikayeleri.repository;

import com.deneme.Korku.Hikayeleri.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    //@Query("update User u set u.IS_ACTIVE ='N' where ")
    public void delete(User user);

    public List<User> findAllByIsActive(char c);
}
