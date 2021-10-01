package model;

public enum Operation {

    SUM('+'),SUBTRACT('-'),MULTIPLY('*'), DIVIDE('/'),RESULT('=');

    private char symbol;

    private Operation (char symbol){
        this.symbol = symbol;
    }

    public char getSymbol(){
        return symbol;
    }
}
