/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;

/**
 *
 * @author DELL
 */
@Entity
@NamedQuery(name = "findAllSalles", query = "from Salle") //HQL
@NamedNativeQuery(name = "findAllSallesNative", query = "select * from salle", resultClass = Salle.class) 
public class Salle implements Serializable{
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     private String ref;
     private int etage;
     
     public Salle(){
         
     }
     public Salle(String ref,int etage){
         this.ref=ref;
         this.etage=etage;
     }

    public int getId() {
        return id;
    }

    public String getRef() {
        return ref;
    }

    public int getEtage() {
        return etage;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    @Override
    public String toString() {
        return "Salle{" + "id=" + id + ", ref=" + ref + ", etage=" + etage + '}';
    }
     
}
