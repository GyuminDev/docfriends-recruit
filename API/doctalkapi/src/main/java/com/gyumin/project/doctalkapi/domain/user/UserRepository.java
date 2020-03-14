package com.gyumin.project.doctalkapi.domain.user;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

@Mapper
public interface UserRepository extends JpaRepository<User, Long> {
}
