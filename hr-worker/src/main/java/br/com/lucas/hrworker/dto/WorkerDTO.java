package br.com.lucas.hrworker.dto;

import java.io.Serializable;

import br.com.lucas.hrworker.functions.MinhaFunction;
import br.com.lucas.hrworker.functions.MinhaFunction2;

public class WorkerDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private Double dailyIncome;

	public WorkerDTO(String name, Double dailyIncome) {
		this.name = name;
		this.dailyIncome = dailyIncome;
	}
	
	public WorkerDTO(MinhaFunction minhaFunction, MinhaFunction2 minhaFunction2) {
		this.name = minhaFunction.execute();
		this.dailyIncome = minhaFunction2.execute();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDailyIncome() {
		return dailyIncome;
	}

	public void setDailyIncome(Double dailyIncome) {
		this.dailyIncome = dailyIncome;
	}
}
