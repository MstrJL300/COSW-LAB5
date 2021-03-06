package edu.eci.cosw.samples.model;
// Generated Mar 9, 2016 7:01:57 AM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Embeddable;



/**
 * PacientesId generated by hbm2java
 */
@Embeddable
public class PacienteId  implements java.io.Serializable {


     private int id;
     private String tipoId;

    public PacienteId() {
    }

    public PacienteId(int id, String tipoId) {
       this.id = id;
       this.tipoId = tipoId;
    }
   
    @Column(name = "id")
    public int getId() {
        return this.id;
    }
        
    public void setId(int id) {
        this.id = id;
    }
    
    @Column(name = "tipo_id")
    public String getTipoId() {
        return this.tipoId;
    }
    
    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PacienteId) ) return false;
		 PacienteId castOther = ( PacienteId ) other; 
         
		 return (this.getId()==castOther.getId())
 && ( (this.getTipoId()==castOther.getTipoId()) || ( this.getTipoId()!=null && castOther.getTipoId()!=null && this.getTipoId().equals(castOther.getTipoId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getId();
         result = 37 * result + ( getTipoId() == null ? 0 : this.getTipoId().hashCode() );
         return result;
   }   


}


