/*
 * Ejercicios sobre testing automatizado: JUnit
 */
package testjava;

/**
 *
 * @author mcasatti
 */
public class Calculadora {
    public Calculadora (){
    
    }
    
    public int Sumar(int numero1, int numero2) {
        return numero1+numero1;
    }
    
    public int Restar(int numero1, int numero2) {
        return numero1-numero2;
    }
    
    public int Mayor (int numero1, int numero2) {
        if (numero1 > numero2)
            return numero1;
        else
            return numero2;
    }
    
    public int Absoluto (int numero1) {
        if (numero1 < 0) return (numero1);
        else return numero1;
    }
    
    public int Cuadrado (int numero) {
        return numero*numero;
    }
    
    public int Signo (int numero) {
        if (numero < 0) return -1;
        else if (numero > 0) return 1;
        else return 0;
    }
}
