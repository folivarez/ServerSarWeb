/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.util.ArrayList;

/**
 *
 * @author fede
 */
public class Victima {

    public String getS_edad() {
        return s_edad;
    }

    public void setS_edad(String s_edad) {
        this.s_edad = s_edad;
    }

    public String s_edad = "";

    public void datosVictima(Object oVictima) {

        ArrayList<String> aVictima = new ArrayList<String>();

        aVictima = ((ArrayList<String>) oVictima);

        s_edad = aVictima.get(1);
        System.out.println("victima " + aVictima.get(1));

    }

}
