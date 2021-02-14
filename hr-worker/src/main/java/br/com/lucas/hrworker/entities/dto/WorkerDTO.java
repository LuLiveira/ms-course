package br.com.lucas.hrworker.entities.dto;

import java.io.Serializable;

public class WorkerDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
    private Double dailyIncome;

    public WorkerDTO(String name, Double dailyIncome) {
        this.name = name;
        this.dailyIncome = dailyIncome;
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
