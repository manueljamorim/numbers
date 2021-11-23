package com.aor.numbers;

public class DivisibleByFilter {
    int constante;

    public DivisibleByFilter(int constante){
        this.constante = constante;
    }

    public boolean accept(Integer number){
        if (number%constante==0) return true;
        return false;
    }

}
