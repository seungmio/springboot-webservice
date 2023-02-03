package com.example.springbootwebservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
//DAO class
//Entity class 와 Entity Repository class 는 함께 위치해야 한다.
public interface PostsRepository extends JpaRepository<Posts, Long> {   //Posts 클래스로 Database 를 접근하게 해줄 클래스
}
