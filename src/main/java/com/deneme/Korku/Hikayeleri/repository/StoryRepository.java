package com.deneme.Korku.Hikayeleri.repository;

import com.deneme.Korku.Hikayeleri.model.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story, Long> {
}
