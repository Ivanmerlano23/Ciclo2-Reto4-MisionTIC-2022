/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author ivanf
 */
public class CuerpoDeAgua extends ObjetoGeografico{
    private String tipoCuerpoAgua;
    private String tipoAgua;
    private double irca;
    private String nivel;

    public CuerpoDeAgua() {
    }

    @Override
    public String toString() {
        return "CuerpoDeAgua{" + "tipoCuerpoAgua=" + tipoCuerpoAgua + ", tipoAgua=" + tipoAgua + ", irca=" + irca + ", nivel=" + nivel + '}';
    }

    public CuerpoDeAgua(String tipoCuerpoAgua, String tipoAgua, double irca, String nombre, int idCuerpoDeAgua, String municipio) {
        super.setNombre(nombre);
        super.setIdCuerpoDeAgua(idCuerpoDeAgua);
        super.setMunicipio(municipio);
        this.tipoCuerpoAgua = tipoCuerpoAgua;
        this.tipoAgua = tipoAgua;
        this.irca = irca;
        this.nivel = nivel(irca);
    }
    
    private String nivel(Double valor_irca){
        String nivel = "";
         if(valor_irca >= 0 && valor_irca <= 5){
              nivel = "SIN RIESGO";
         }else{
             if(valor_irca > 5 && valor_irca <= 14){
                 nivel = "BAJO";
             }else{
                 if(valor_irca > 14 && valor_irca <= 35){
                     nivel = "MEDIO";
                 }else{
                     if(valor_irca > 35 && valor_irca <= 80){
                         nivel = "ALTO";
                     }else{
                         if(valor_irca > 80 && valor_irca <= 100){
                            nivel = "INVIABLE SANITARIAMENTE"; 
                         }
                     }
                 }
             }
         }
         return nivel;
    } 
    /**
     * @return the tipoCuerpoAgua
     */
    public String getTipoCuerpoAgua() {
        return tipoCuerpoAgua;
    }

    /**
     * @param tipoCuerpoAgua the tipoCuerpoAgua to set
     */
    public void setTipoCuerpoAgua(String tipoCuerpoAgua) {
        this.tipoCuerpoAgua = tipoCuerpoAgua;
    }

    /**
     * @return the tipoAgua
     */
    public String getTipoAgua() {
        return tipoAgua;
    }

    /**
     * @param tipoAgua the tipoAgua to set
     */
    public void setTipoAgua(String tipoAgua) {
        this.tipoAgua = tipoAgua;
    }

    /**
     * @return the irca
     */
    public double getIrca() {
        return irca;
    }

    /**
     * @param irca the irca to set
     */
    public void setIrca(double irca) {
        this.irca = irca;
    }

    /**
     * @return the nivel
     */
    public String getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(Double irca) {
        this.nivel = nivel(irca);
    }

  
}
