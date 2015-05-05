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

    public Victima() {
    }
    
    public Victima(ArrayList<String> a_victima) {
    }
    
    
    

    
    public String getS_edad() {
        return s_edad;
    }

    public String getS_ojos() {
        return s_ojos;
    }

    public void setS_ojos(String s_ojos) {
        this.s_ojos = s_ojos;
    }

    public void setS_edad(String s_edad) {
        this.s_edad = s_edad;
    }

    private String s_edad = "";
    private String s_ojos = "";
}
