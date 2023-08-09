package com.juniorenriquegonalez.springboot.web.app.models.entitys;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.persistence.Transient;
import com.juniorenriquegonalez.springboot.web.app.utils.Metodos;


@Entity
@Table(name="entradas")
public class Entrada implements Serializable{	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;


	@Column(nullable=false)
	private int x;
	

	@Column(nullable=false)
	private int y;
	
	
	@Column(nullable=false)
	private int n;
	
	@Transient 
	private int calculate_response;
	
	 
	public int getCalculate_response() {
		return calculate_response;
	}

	public void setCalculate_response(int calculate_response) {
		this.calculate_response = calculate_response;
	}

	public Entrada () {}

	public Entrada( int x,
		int y,
		int n) {
		
		this.x = x;
		this.y = y;
		this.n = n;
	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	
	
	
}

