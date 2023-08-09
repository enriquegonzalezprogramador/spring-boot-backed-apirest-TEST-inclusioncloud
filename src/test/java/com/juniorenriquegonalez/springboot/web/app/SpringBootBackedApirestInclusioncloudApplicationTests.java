package com.juniorenriquegonalez.springboot.web.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.juniorenriquegonalez.springboot.web.app.models.entitys.Entrada;
import com.juniorenriquegonalez.springboot.web.app.utils.Metodos;

@SpringBootTest
class SpringBootBackedApirestInclusioncloudApplicationTests {

	   @Test
	    public void testCaculoEntradas() {
	        List<Entrada> entradas = new CopyOnWriteArrayList<>();
	        entradas.add(new Entrada(7, 5, 12345));
	        entradas.add(new Entrada(5, 0, 4));
	        entradas.add(new Entrada(10, 5, 15));
	        entradas.add(new Entrada(17, 8, 54321));

	        List<Entrada> resultado = Metodos.caculo_entradas(entradas);

	        assertEquals(4, resultado.size());

	        assertEquals(12339, resultado.get(0).getCalculate_response());
	        assertEquals(0, resultado.get(1).getCalculate_response());
	        assertEquals(15, resultado.get(2).getCalculate_response());
	        assertEquals(54306, resultado.get(3).getCalculate_response());
	    }

}
