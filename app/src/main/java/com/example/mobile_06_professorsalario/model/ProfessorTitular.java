package com.example.mobile_06_professorsalario.model;

public class ProfessorTitular extends Professor{

    private int anosInstituicao;
    private final double salario = 8000;
    @Override
    public double calcSalario() {
        return salario+(salario * (0.05 * anosInstituicao));
    }

    public int getAnosInstituicao() {
        return anosInstituicao;
    }

    public void setAnosInstituicao(int anosInstituicao) {
        this.anosInstituicao = anosInstituicao;
    }

    public double getSalario() {
        return salario;
    }

}
