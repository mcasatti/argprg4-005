/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.miempresa.miappmaven;

import de.vandermeer.asciitable.AsciiTable;
import java.time.Month;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;
import org.beryx.textio.system.SystemTextTerminal;

/**
 *
 * @author mcasatti
 */
public class MiAppMaven {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        SystemTextTerminal systerm = new SystemTextTerminal();
        TextIO textIO = new TextIO (systerm);
        
        String user = textIO.newStringInputReader()
                .withDefaultValue("admin")
                .read("Usuario");

        String password = textIO.newStringInputReader()
                .withMinLength(6)
                .withInputMasking(true)
                .read("Contraseña");

        int age = textIO.newIntInputReader()
                .withMinVal(13)
                .read("Edad");

        Month month = textIO.newEnumInputReader(Month.class)
                .read("En qué mes naciste?");

        TextTerminal terminal = textIO.getTextTerminal();
        terminal.printf("\nEl usuario %s tiene %d años de edad, nació en %s y tiene la contraseña %s.\n",
                user, age, month, password);
        
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow("Número","Descripción");
        at.addRule();
        for (int i=0; i<10; i++) {
            at.addRow(i,"Número "+i);
        }
        at.addRule();
        String rend = at.render();
        terminal.print (rend);
    }
}
