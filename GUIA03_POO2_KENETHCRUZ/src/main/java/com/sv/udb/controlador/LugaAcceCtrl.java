/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.LugaAcce;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Laboratorio
 */
public class LugaAcceCtrl {
    
     /** Metodo que funciona para guardar datos en la base
     * 
     * @param obje objeto para LugarAcce
     * @return boolean si guarda los datos
     * @exception si no guarda los datos activa la exception
     * @since 1.0
     */
    public boolean guar(LugaAcce obje)
    {
        boolean resp = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try
        {
            em.persist(obje);
            tx.commit();
            resp = true;
        }
        catch(Exception ex)
        {
            tx.rollback();
        }
        em.close();
        emf.close();
        return resp;
    }
    
    
    /** Metodo que funciona para modificar un registro LugaAcce de la base de datos
      * 
      * @param obje objeto para LugaAcce
      * @return boolean si modifica los datos
      * @exception  si no modifica los datos
      * @since 1.0
      */ 
    public boolean modificar(LugaAcce obje)
    {
        boolean resp = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try
        {
            em.merge(obje);
            tx.commit();
            resp = true;
        }
        catch(Exception ex)
        {
            tx.rollback();
        }
        em.close();
        emf.close();
        return resp;
    }
    
     /** Metodo que funciona para eliminar un registro LugaAcce de la base de datos
     * 
     * @param obje objeto para LugaAcce
     * @return boolean si elimina los datos
     * @exception si no elimina los datos
     * @since 1.0
     */
    public boolean eliminar(Long empId)
    {
        boolean resp = false;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        LugaAcce respo = null;
        try{
            respo = em.find(LugaAcce.class, empId);
            if(respo != null)
            {
                em.remove(respo);
                tx.commit();
                resp = true; 
            }
        }catch(Exception e){
            tx.rollback();
        }
        em.close();
        emf.close();
        return resp;
    }
    
    /** Metodo que sirve para consultar todos los datos de la base para LugaAcce
     * 
     * @return devuelve la lista LugaAcce
     * @exception los datos no se pudieron consultar
     * @since 1.0
     */
    
    public List<LugaAcce>  ConsTodo()
    {
        List<LugaAcce> resp = new ArrayList<>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        try
        {
          TypedQuery<LugaAcce> query =em.createNamedQuery("LugaAcce.findAll", LugaAcce.class);
           resp = query.getResultList();
        }
        catch(Exception ex)
        {
            
        }
        return resp;
       
    }
    
    /** Metodo que funciona para seleccionar un registro que se encuentra en la base
      * 
      * @param empId parametro de identificacion
      * @return devuelve la informacion del LugaAcce seleccionada
      * @exception error al consultar el dato seleccionado
      */
    public LugaAcce get(Long empId){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("POOPU");
        EntityManager em = emf.createEntityManager();
        LugaAcce resp = null;
        
        try{
            resp = em.find(LugaAcce.class, empId);
            
        }catch(Exception e){
            e.printStackTrace();
        }                
        return resp;
    }  
    
}
