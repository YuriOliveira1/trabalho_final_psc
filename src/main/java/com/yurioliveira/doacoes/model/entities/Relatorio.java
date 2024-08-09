package com.yurioliveira.doacoes.model.entities;

import java.util.Objects;

public class Relatorio {

    private Integer qtdDoacaoNormais;

    private Integer qtdDoacaoEmDinheiro;

    private Integer qtdCartasEnviadas;

    private Integer qtdDoacaoTotais;

    private Float qtdValorEmDinheiroDoado;

    public Relatorio() {
    }

    public Relatorio(Integer qtdDoacaoNormais, Integer qtdDoacaoEmDinheiro, Integer qtdCartasEnviadas, Integer qtdDoacaoTotais, Float qtdValorEmDinheiroDoado) {
        this.qtdDoacaoNormais = qtdDoacaoNormais;
        this.qtdDoacaoEmDinheiro = qtdDoacaoEmDinheiro;
        this.qtdCartasEnviadas = qtdCartasEnviadas;
        this.qtdDoacaoTotais = qtdDoacaoTotais;
        this.qtdValorEmDinheiroDoado = qtdValorEmDinheiroDoado;
    }

    public Integer getQtdDoacaoNormais() {
        return qtdDoacaoNormais;
    }

    public void setQtdDoacaoNormais(Integer qtdDoacaoNormais) {
        this.qtdDoacaoNormais = qtdDoacaoNormais;
    }

    public Integer getQtdDoacaoEmDinheiro() {
        return qtdDoacaoEmDinheiro;
    }

    public void setQtdDoacaoEmDinheiro(Integer qtdDoacaoEmDinheiro) {
        this.qtdDoacaoEmDinheiro = qtdDoacaoEmDinheiro;
    }

    public Integer getQtdCartasEnviadas() {
        return qtdCartasEnviadas;
    }

    public void setQtdCartasEnviadas(Integer qtdCartasEnviadas) {
        this.qtdCartasEnviadas = qtdCartasEnviadas;
    }

    public Integer getQtdDoacaoTotais() {
        return qtdDoacaoTotais;
    }

    public void setQtdDoacaoTotais(Integer qtdDoacaoTotais) {
        this.qtdDoacaoTotais = qtdDoacaoTotais;
    }

    public Float getQtdValorEmDinheiroDoado() {
        return qtdValorEmDinheiroDoado;
    }

    public void setQtdValorEmDinheiroDoado(Float qtdValorEmDinheiroDoado) {
        this.qtdValorEmDinheiroDoado = qtdValorEmDinheiroDoado;
    }

    @Override
    public String toString() {
        return "Relatorio{" +
                "qtdDoacaoNormais=" + qtdDoacaoNormais +
                ", qtdDoacaoEmDinheiro=" + qtdDoacaoEmDinheiro +
                ", qtdCartasEnviadas=" + qtdCartasEnviadas +
                ", qtdDoacaoTotais=" + qtdDoacaoTotais +
                ", qtdValorEmDinheiroDoado=" + qtdValorEmDinheiroDoado +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Relatorio relatorio = (Relatorio) o;
        return Objects.equals(qtdDoacaoNormais, relatorio.qtdDoacaoNormais) && Objects.equals(qtdDoacaoEmDinheiro, relatorio.qtdDoacaoEmDinheiro) && Objects.equals(qtdCartasEnviadas, relatorio.qtdCartasEnviadas) && Objects.equals(qtdDoacaoTotais, relatorio.qtdDoacaoTotais) && Objects.equals(qtdValorEmDinheiroDoado, relatorio.qtdValorEmDinheiroDoado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qtdDoacaoNormais, qtdDoacaoEmDinheiro, qtdCartasEnviadas, qtdDoacaoTotais, qtdValorEmDinheiroDoado);
    }
}
