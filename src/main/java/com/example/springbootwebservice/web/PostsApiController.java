package com.example.springbootwebservice.web;

import com.example.springbootwebservice.service.posts.PostsService;
import com.example.springbootwebservice.web.dto.PostsResponseDto;
import com.example.springbootwebservice.web.dto.PostsSaveRequestDto;
import com.example.springbootwebservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    /*
    RequestBody는 xml이나 json 기반의 메세지를 사용하는 요청의 경우 유용하다.

    클라이언트에서 서버로 필요한 데이터를 요청하기 위해
    JSON 데이터를 요청 본문에 담아서 서버로 보내면,
    서버에서는 @RequestBody 어노테이션을 사용하여 HTTP 요청 본문에 담긴 값들을
    자바객체로 변환시켜, 객체에 저장한다.

    서버에서 클라이언트로 응답 데이터를 전송하기 위해 @ResponseBody 어노테이션을 사용하여
    자바 객체를 HTTP 응답 본문의 객체로 변환하여 클라이언트로 전송한다.
     */

    public Long save(@RequestBody PostsSaveRequestDto requestDto) { //HTTP 요청 본문에 담긴 값들이 자바객체로 변환되어 requestDto 객체에 저장된다.
        return postsService.save(requestDto);   //Service로 넘겨주고, Service 의 save 메소드가 기능을 수행하게 된다.
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto); //dto 객체를 service 로 넘김
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id) {
        return postsService.findById(id);
    }
}
