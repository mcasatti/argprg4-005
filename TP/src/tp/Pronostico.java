/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp;

/**
 *
 * @author mcasatti
 */
public class Pronostico {
    private Equipo equipo;
    private Partido partido;
    private char Resultado;
    
    public Pronostico() {
        
    }

    public Pronostico(Equipo equipo, Partido partido, char Resultado) {
        this.equipo = equipo;
        this.partido = partido;
        this.Resultado = Resultado;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public char getResultado() {
        return Resultado;
    }

    public void setResultado(char Resultado) {
        this.Resultado = Resultado;
    }
    
    public String toString() {
        String res = "\nApuesto a que en el partido:\n"+
                this.getPartido()+
                this.getEquipo().getNombre()+" obtiene el siguiente Resultado: "+
                this.getResultado()+"\n";
        return res;
    }
    
}
