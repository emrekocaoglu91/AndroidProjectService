package com.deneme.Korku.Hikayeleri.repository;

import com.deneme.Korku.Hikayeleri.entity.StoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryRepository extends JpaRepository<StoryEntity, Long> {
}
