package com.example.springbootwebservice;

import com.example.springbootwebservice.web.HelloController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//@SpringBootTest
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloController.class)
class SpringbootWebserviceApplicationTests {

	@Autowired
	private MockMvc mvc;	//HTTP, GET, POST 등에 대한 API 테스트를 할 수 있다.
	@Test
	public void hello가_리턴된다() throws Exception {
		String hello = "hello";

		mvc.perform(get("/hello"))
				.andExpect(status().isOk())
				.andExpect(content().string(hello));
	}

	@Test
	public void helloDto가_리턴된다() throws Exception {
		String name = "hello";
		int amount = 1000;

		mvc.perform(
				get("/hello/dto")
						.param("name", name)	//API테스트할 때 사용될 요청 파라미터 설정
						.param("amount", String.valueOf(amount)))	//값은 String만 허용
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", is(name)))	//JSON 응답값을 필드별로 검증할 수 있는 메소드 ($를 기준으로 필드명을 명시)
				.andExpect(jsonPath("$.amount", is(amount)));
	}

}
