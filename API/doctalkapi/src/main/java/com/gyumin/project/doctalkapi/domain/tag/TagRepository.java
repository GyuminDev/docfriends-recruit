package com.gyumin.project.doctalkapi.domain.tag;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

@Mapper
public interface TagRepository extends JpaRepository<Tag, Long> {
}
