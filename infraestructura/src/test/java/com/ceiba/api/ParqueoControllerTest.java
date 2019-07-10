package com.ceiba.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.modelo.Moto;
import com.ceiba.modelo.Vehiculo;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(ParqueaderoController.class)
@ComponentScan("com.ceiba")
public class ParqueoControllerTest {
	
	@Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;
    
    @Ignore
    @Test
    public void crear() throws Exception{
        //Arrange
    	
        Vehiculo vehiculo = new Moto("BGG418",100, "Moto");

        //Act - Assert
        mocMvc.perform(post("/ingresar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(vehiculo)))
        		.andExpect(status().isOk());
    }	
        
}
