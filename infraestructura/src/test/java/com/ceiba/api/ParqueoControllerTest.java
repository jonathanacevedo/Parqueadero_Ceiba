package com.ceiba.api;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.modelo.Vehiculo;
import com.ceiba.testdatabuilder.VehiculoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ParqueoControllerTest {
	
	private static final String PLACA_A_INGRESAR = "BGQ782D";
	private static final String PLACA_A_CONSULTAR = "JDAH85";
	private static final String PLACA_MOTO_SIN_CUPO = "UDA125";
	private static final String PLACA_A_REPETIR_INGRESO = "KYQ25J";
	private static final String PLACA__DE_VEHICULO_INEXISTENTE = "KYQ414";
	private static final int CILINDRAJE_A_INGRESAR = 560;
	private static final String URL_API = "/vehiculos";
	
	@Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;
   
    @Test
    public void ingresarVehiculoTest() throws Exception {
        //Arrange
    	
        Vehiculo vehiculo = new VehiculoTestDataBuilder()
        		.conPlaca(PLACA_A_INGRESAR).buildCarro();

        //Act - Assert
        mocMvc.perform(post(URL_API)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(vehiculo)))
        		.andExpect(status().isOk());
    }
    
    @Test
    public void consultarVehiculoIngresadoTest() throws Exception {
        //Arrange
    	
        Vehiculo vehiculo = new VehiculoTestDataBuilder()
        		.conPlaca(PLACA_A_CONSULTAR)
        		.conCilindraje(CILINDRAJE_A_INGRESAR)
        		.buildMoto();
        
        mocMvc.perform(post(URL_API)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(vehiculo)))
        		.andExpect(status().isOk());

        //Act - Assert

        
        mocMvc.perform(get(URL_API).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(jsonPath("$[2].placa", is(PLACA_A_CONSULTAR)));
    }
    
    @Test
    public void retirarVehiculoTest() throws Exception {
        //Arrange
    	
        mocMvc.perform(put(URL_API+"/"+PLACA_A_INGRESAR)
                .contentType(MediaType.APPLICATION_JSON))
        		.andExpect(status().isOk())
        		.andExpect(jsonPath("$.valorAPagar", is(1000.0)));
        
    }
    
    @Test
    public void ingresarVehiculoExistenteTest() throws Exception {
        //Arrange
    	
        Vehiculo vehiculo = new VehiculoTestDataBuilder()
        		.conPlaca(PLACA_A_REPETIR_INGRESO).buildCarro();

        //Act - Assert
        mocMvc.perform(post(URL_API)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(vehiculo)))
        		.andExpect(status().isOk());
        
        mocMvc.perform(post(URL_API)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(vehiculo)))
        		.andExpect(status().isBadRequest());
    }
    
    @Test
    public void retirarVehiculoInexistenteTest() throws Exception {
        //Arrange
    	
        mocMvc.perform(put(URL_API+"/"+PLACA__DE_VEHICULO_INEXISTENTE)
                .contentType(MediaType.APPLICATION_JSON))
        		.andExpect(status().isNotFound());
        
    }
    
    @Test
    public void ingresarMasDe10VehiculosMotoTest() throws Exception {
        //Arrange
    	
    	for (int i = 0; i < 9; i++) {
    		Vehiculo vehiculo = new VehiculoTestDataBuilder()
            		.conPlaca(PLACA_A_INGRESAR+i)
            		.conCilindraje(180)
            		.buildMoto();

            //Act - Assert
            mocMvc.perform(post(URL_API)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(vehiculo)))
            		.andExpect(status().isOk());
		}
    	
		Vehiculo vehiculo = new VehiculoTestDataBuilder()
        		.conPlaca(PLACA_MOTO_SIN_CUPO)
        		.conCilindraje(180)
        		.buildMoto();

        //Act - Assert
        mocMvc.perform(post(URL_API)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(vehiculo)))
        		.andExpect(status().isInsufficientStorage());
    	
    }

}
