/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import gui.Menu;

/**
 *
 * @author ivanf
 */
public class Reto4 {
    public static void main(String[] args) {
      Menu objInterfaz = new Menu();
      CuerpoDeAgua ca = new CuerpoDeAgua();
      Consultas co = new Consultas();
     ControlGeneral general = new ControlGeneral(objInterfaz, ca, co);
    }
    
}
