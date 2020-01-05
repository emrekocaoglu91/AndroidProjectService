package com.deneme.Korku.Hikayeleri.repository;

import com.deneme.Korku.Hikayeleri.model.response.StoryRest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepository extends JpaRepository<StoryRest, Long> {
}
