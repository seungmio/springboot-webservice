package com.example.springbootwebservice.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostsRepositoryTest {  //save, findAll 기능 테스트

    @Autowired
    PostsRepository postsRepository;

    @AfterEach  //테스트가 끝날 때마다 수행하는 메소드, 테스트 간 데이터 침범을 막기 위해 사용
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";
        
        //insert, ip
        postsRepository.save(Posts.builder()    //id 값이 있으면 update, 없으면 insert 쿼리 실행
                .title(title)
                .content(content)
                .author("jojoldu@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();  //모든 데이터를 조회

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
