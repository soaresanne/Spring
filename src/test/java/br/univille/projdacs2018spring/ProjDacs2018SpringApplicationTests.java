package br.univille.projdacs2018spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.univille.projdacs2018spring.controller.HomeController;
import br.univille.projdacs2018spring.controller.PacienteController;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProjDacs2018SpringApplicationTests {

	@Autowired
	private HomeController homeController;
	
	@Autowired
	private PacienteController pacienteController;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void contextLoads() {
		assertThat(homeController).isNotNull();
		assertThat(pacienteController).isNotNull();
	}
	
	@Test
	public void homeControllerTest() throws Exception {
		this.mockMvc.perform(get("/"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(content().string(containsString("ありえない")));
	}
	
	@Test
	public void pacienteControllerTest() throws Exception {
		this.mockMvc.perform(get("/paciente"))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(xpath("//table").exists())
					.andExpect(xpath("//td[contains(., 'Zezinho')]").exists());
	}

}
