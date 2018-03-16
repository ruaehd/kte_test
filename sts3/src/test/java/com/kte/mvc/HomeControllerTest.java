package com.kte.mvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.kte.mvc.controller.HomeController;

public class HomeControllerTest {
	private MockMvc mockMvc = null;
	
	//테스트 실핼전
	@Before
	public void setup() {
		//테스트 하고자 하는 controller 객체 만듬
		mockMvc = MockMvcBuilders.standaloneSetup(new HomeController()).build();
	}
	
	@Test	//테스트
	public void test() throws Exception{
		//실행할 requestmapping, param 설정
		MockHttpServletRequestBuilder msrb = post("/test_a.do").param("no", "1").param("no1", "2");
		//테스트 수향
		mockMvc.perform(msrb).andDo(print()).andExpect(status().is3xxRedirection());
	}
}
