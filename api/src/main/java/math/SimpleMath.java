package math;


public class SimpleMath {

    public Double soma(Double numberOne, Double numberTwo){
        return numberOne + numberTwo;
    }

    public Double subtracao(Double numberOne, Double numberTwo){
        return numberOne - numberTwo;
    }

    public Double multiplicacao(Double numberOne,Double numberTwo){
        return numberOne * numberTwo;
    }

    public Double divisao(Double numberOne, Double numberTwo){
        return numberOne / numberTwo;
    }

    public Double media(Double numberOne, Double numberTwo){
        return (numberOne + numberTwo) / 2;
    }

    public Double raizquadrada(Double numberOne) {
        return Math.sqrt(numberOne);
    }
}
