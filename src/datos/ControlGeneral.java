/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import gui.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ivanf
 */
public class ControlGeneral implements ActionListener{
   
    private Menu obMenu;
    private CuerpoDeAgua obCuerpo;
    private Consultas obConsulta;
    ArrayList<CuerpoDeAgua> objLista;
    
    
      
    public ControlGeneral(Menu obMenu, CuerpoDeAgua obCuerpo, Consultas obConsulta) {
        this.obMenu = obMenu;
        this.obCuerpo = obCuerpo;
        this.obConsulta = obConsulta;
        
        inicarapp();
        deshabilita(false);
        
    }
    
    
    public void inicarapp(){
        obMenu.setVisible(true);
        obMenu.btnIngresar.addActionListener(this);
        obMenu.btnObtenerDatos.addActionListener(this);
        obMenu.btnProcesar.addActionListener(this);
        obMenu.btnBuscar.addActionListener(this);
        obMenu.btnEditar.addActionListener(this);
        obMenu.btnEliminar.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
		if(e.getSource() == obMenu.btnIngresar){

			obCuerpo.setIdCuerpoDeAgua(Integer.parseInt(obMenu.txtID.getText()));
			obCuerpo.setNombre(obMenu.txtNombre.getText());
                        obCuerpo.setMunicipio(obMenu.txtMunicipio.getText());
                        obCuerpo.setTipoCuerpoAgua(obMenu.txtTipoCuerpoAgua.getText());
                        obCuerpo.setTipoAgua(obMenu.txtTipoAgua.getText());
			obCuerpo.setIrca(Double.parseDouble(obMenu.txtIRCA.getText()));
			obCuerpo.setNivel(Double.parseDouble(obMenu.txtIRCA.getText()));

			if(obConsulta.ingresar(obCuerpo)){

				JOptionPane.showMessageDialog(null, "Registro Guardado");
				limpiar();

			} else {
				JOptionPane.showMessageDialog(null, "Error al Guardar");	
				limpiar();
			}
		}
               
 
		if(e.getSource() == obMenu.btnEditar){
                        
                        obCuerpo.setIdCuerpoDeAgua(Integer.parseInt(obMenu.txtID_Buscar_Rest.getText()));
			obCuerpo.setNombre(obMenu.txtNombre_Buscar_Rest.getText());
                        obCuerpo.setMunicipio(obMenu.txtMunicipio_Buscar_Rest.getText());
                        obCuerpo.setTipoCuerpoAgua(obMenu.txtTipoCuerpoAgua_Buscar_Rest.getText());
                        obCuerpo.setTipoAgua(obMenu.txtTipoAgua_Buscar_Rest.getText());
			obCuerpo.setIrca(Double.parseDouble(obMenu.txtIRCA_Rest.getText()));
                        
                        
			
			if(obConsulta.editar(obCuerpo)){

				JOptionPane.showMessageDialog(null, "Registro Modificado");

			} else {
				JOptionPane.showMessageDialog(null, "Error al Modificar");	
			}
		}
                
		if(e.getSource() == obMenu.btnEliminar){

			obCuerpo.setIdCuerpoDeAgua(Integer.parseInt(obMenu.txtID_Buscar.getText()));

			if(obConsulta.eliminar(obCuerpo)){

				JOptionPane.showMessageDialog(null, "Registro Eliminado");
				limpiar();

			} else {
				JOptionPane.showMessageDialog(null, "Error al Eliminar");	
				limpiar();
			}
		}
               

		if(e.getSource() == obMenu.btnBuscar){

			obCuerpo.setIdCuerpoDeAgua(Integer.parseInt(obMenu.txtID_Buscar.getText()));

			if(obConsulta.buscar(obCuerpo)){
                                deshabilita(true);
                                obMenu.txtNombre_Buscar_Rest.setText(obCuerpo.getNombre());
				obMenu.txtID_Buscar_Rest.setText(String.valueOf(obCuerpo.getIdCuerpoDeAgua()));
				obMenu.txtMunicipio_Buscar_Rest.setText(obCuerpo.getMunicipio());
				obMenu.txtTipoCuerpoAgua_Buscar_Rest.setText(obCuerpo.getTipoCuerpoAgua());
                                obMenu.txtTipoAgua_Buscar_Rest.setText(obCuerpo.getTipoAgua());
                                obMenu.txtIRCA_Rest.setText(String.valueOf(obCuerpo.getIrca()));
                                obMenu.txtID_Buscar_Rest.setEnabled(false);
			} else {
				JOptionPane.showMessageDialog(null, "No se encontro registro");	
				limpiar();
			}
		}
                

		if(e.getSource() == obMenu.btnObtenerDatos){
                    
                        objLista = obConsulta.consulta();
                         System.out.println(objLista.size());
			if(objLista != null || objLista.size()>0){
                            for (CuerpoDeAgua cuerpoDeAgua : objLista) {
                                obMenu.txtaEntrada.append(cuerpoDeAgua.getNombre() + " " + cuerpoDeAgua.getIdCuerpoDeAgua()+ " " + cuerpoDeAgua.getMunicipio() + " " +cuerpoDeAgua.getTipoCuerpoAgua() + " " + cuerpoDeAgua.getTipoAgua() + " " + cuerpoDeAgua.getIrca() + "\n");  
                            }
                            
			} else {
				JOptionPane.showMessageDialog(null, "No se encontro registro");	
			}
		}
                
    
                if(e.getSource() == obMenu.btnProcesar){
                    
                        objLista = obConsulta.consulta();
                         System.out.println(objLista.size());
			if(objLista != null || objLista.size()>0){
                            
                            procesar(objLista);
                            
			} else {
				JOptionPane.showMessageDialog(null, "No se encontro registro");	
			}
		}
			
		}
  
   
    
    void procesar( ArrayList<CuerpoDeAgua> objLista){
        
        try {
            
       
     
        for (CuerpoDeAgua cuerpoDeAgua : objLista) {
                obMenu.txtaSalidas.append(cuerpoDeAgua.getNivel() + "\n");  
              }
         
         int contador = 0; 
         String listaNombres = ""; 
         double minIRCA = 100; 
         int posicion = 0; 
         String nombre = "";
         
        
         for (CuerpoDeAgua cuerpoDeAgua : objLista) {
             
             Double nivelRiesgo = cuerpoDeAgua.getIrca();
          
             if (nivelRiesgo <= 35){
   
                  contador = contador + 1;  
      
                 if (cuerpoDeAgua.getNivel().equals("MEDIO")) {
                    
                    listaNombres = listaNombres + cuerpoDeAgua.getNombre()+ "\n" ;  
                    }
                
             } 
             
            
             if (cuerpoDeAgua.getIrca() < minIRCA ){
                  minIRCA = cuerpoDeAgua.getIrca();
                  posicion = cuerpoDeAgua.getIdCuerpoDeAgua();
                  nombre = cuerpoDeAgua.getNombre();
             }  
        }
       
         obMenu.txtaSalidas.append("" + contador + "\n");
        
        
        if (listaNombres.equals("")){
            obMenu.txtaSalidas.append("NA" + "\n");   
        }else{
         
         obMenu.txtaSalidas.append(listaNombres);    
           
        }
        
        obMenu.txtaSalidas.append(nombre + " " + posicion + "\n");
        
        
    } catch (Exception e) {
        }
    }
    
    private void deshabilita(boolean estado){
      obMenu.txtNombre_Buscar_Rest.setEnabled(estado);
      obMenu.txtID_Buscar_Rest.setEnabled(estado);
      obMenu.txtMunicipio_Buscar_Rest.setEnabled(estado);
      obMenu.txtTipoCuerpoAgua_Buscar_Rest.setEnabled(estado);
      obMenu.txtTipoAgua_Buscar_Rest.setEnabled(estado);
      obMenu.txtIRCA_Rest.setEnabled(estado);
    }
    
    private void limpiar(){
      obMenu.txtNombre.setText(null);
      obMenu.txtID.setText(null);
      obMenu.txtMunicipio.setText(null);
      obMenu.txtTipoCuerpoAgua.setText(null);
      obMenu.txtTipoAgua.setText(null);
      obMenu.txtIRCA.setText(null);
    }
    
    
}
