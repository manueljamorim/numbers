package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter{
    int constante;

    public DivisibleByFilter(int constante){
        this.constante = constante;
    }

    public boolean accept(Integer number){
        if(constante==0) return false;
        if (number%constante==0) return true;
        return false;
    }

}
