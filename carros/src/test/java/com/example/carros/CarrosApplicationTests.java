package com.example.carros;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import com.example.carros.domain.Carro;
import com.example.carros.domain.CarroService;
import com.example.carros.domain.dto.CarroDTO;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CarrosApplicationTests {

	@Autowired
	private CarroService carroService;


	@Test
	public void teste(){

		Carro carro = new Carro();
		carro.setNome("Ferrari");
		carro.setTipo("esportivos");

		CarroDTO c = carroService.insert(carro);

		assertNotNull(c);

		Long id = c.getId();
		assertNotNull(id);

		// buscar o objeto
		Optional<CarroDTO> op = carroService.getCarrosById(id);
		assertTrue(op.isPresent());

		c = op.get();
		assertEquals("Ferrari", c.getNome());
		assertEquals("esportivos", c.getTipo());

		// deletar objeto
		carroService.delete(id);


		//verificar se deletou
		assertFalse(carroService.getCarrosById(id).isPresent());
		


	}
	@Test
    public void testLista() {

        List<CarroDTO> carros = carroService.getCarros();

        assertEquals(30, carros.size());
    }

	@Test
    public void testGet() {

        Optional<CarroDTO> op = carroService.getCarrosById(11L);

        assertTrue(op.isPresent());

        CarroDTO c = op.get();

        assertEquals("Ferrari FF", c.getNome());
    }

	@Test
    public void testListaPorTipo() {

        assertEquals(10, carroService.getCarrosByTipo("classicos").size());
        assertEquals(10, carroService.getCarrosByTipo("esportivos").size());
        assertEquals(10, carroService.getCarrosByTipo("luxo").size());

        assertEquals(0, carroService.getCarrosByTipo("x").size());
    }




	@Test
	void contextLoads() {
	}

}
