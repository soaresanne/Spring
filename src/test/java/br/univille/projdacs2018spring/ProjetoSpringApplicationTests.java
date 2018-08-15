package br.univille.projdacs2018spring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.univille.projdacs2018spring.controller.HomeController;

@RunWith(SpringRunner.class)
@SpringBootTest
	public class ProjetoSpringApplicationTests {

	@Autowired
	private HomeController controller;
	@Autowired
	private PacienteController pacienteController;
	private MockMvc mockMvc;

	@Test
	public void contextLoads() {
		//Verifica a existência da instância do controlador
		assertThat(controller).isNotNull();
		assertThat(pacienteController).isNotNull();
	}
	@Test
	public void homeControllerTest() throws Exception {
	//Teste do método index
	this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
	.andExpect(content().string(containsString("eu não acredito")));
	}
	
	@Test
	public void pacienteControllerTest() throws Exception {
	//Teste do método index
	this.mockMvc.perform(get("/paciente")).andDo(print()).andExpect(status().isOk())
	.andExpect(xpath("//table").exists())
	.andExpect(xpath("//td[contains(., 'Zezinho')]").exists());
	}

}
