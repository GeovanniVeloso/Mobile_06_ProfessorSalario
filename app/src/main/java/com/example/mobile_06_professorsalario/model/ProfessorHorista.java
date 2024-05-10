package com.example.mobile_06_professorsalario.model;

public class ProfessorHorista extends Professor {

    private int horasAula;
    private final double valorHoraAula = 30;

    public ProfessorHorista(){
        super();
    }

    @Override
    public double calcSalario() {
        return (valorHoraAula * horasAula);
    }

    public int getHorasAula() {
        return horasAula;
    }

    public void setHorasAula(int horasAula) {
        this.horasAula = horasAula;
    }

    public double getValorHoraAula() {
        return valorHoraAula;
    }

}
