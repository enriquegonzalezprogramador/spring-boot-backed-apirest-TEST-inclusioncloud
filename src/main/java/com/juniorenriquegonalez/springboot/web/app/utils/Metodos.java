package com.juniorenriquegonalez.springboot.web.app.utils;

import java.util.List;

import com.juniorenriquegonalez.springboot.web.app.models.entitys.Entrada;

public class Metodos {
	
	
	public static List<Entrada> caculo_entradas(List<Entrada> entradas) {
	
		   for (Entrada entrada : entradas) {
	            entrada.setCalculate_response(Metodos.findMaxK(
	            		entrada.getX(),
	            		entrada.getY(),
	            		entrada.getN()));
	        }
		
		return entradas;
	}
	
    public static int findMaxK(int x, int y, int n) {
    	int maxK = 0;
    	for (int k = 0; k <= n; k++) {
    	    if ((x == 0 && k == y) || (y == 0 && k == x) || (x != 0 && y != 0 && (k % x == y || k % y == x))
    	    	&& 2 <= x && x <= Math.pow(10, 9) && 0 <= y && y < x && y <= n && n <= Math.pow(10, 9)) {
    	        maxK = k;
    	    }
    	}

        return maxK;
    }

}
