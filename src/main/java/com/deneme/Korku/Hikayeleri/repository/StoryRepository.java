package com.deneme.Korku.Hikayeleri.repository;

import com.deneme.Korku.Hikayeleri.model.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryRepository extends JpaRepository<Story,Long> {

    public List<Story> findAllByIsActive(char c);



}
