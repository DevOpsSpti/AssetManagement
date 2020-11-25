/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.test;

import com.google.inject.Inject;
import edu.eci.cvds.sample.entities.Equipo;
import edu.eci.cvds.sample.factory.ServiceFactory;
import edu.eci.cvds.sample.services.ServiceEquipo;
import edu.eci.cvds.sample.services.ServiceHistorialEquipos;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ServiciosHistorialTest {

    @Inject
    private SqlSession sqlSession;

    private ServiceHistorialEquipos ServicioHE;
    private ServiceEquipo serviceEquipo;

    public ServiciosHistorialTest() {
        ServicioHE = ServiceFactory.getInstance().getServiceHistorialEquipos();
        serviceEquipo = ServiceFactory.getInstance().getServiceEquipo();
    }
/*
    @Test
    public void ConsultarEquipo (){
        try{
            ArrayList<Equipo> equipos = (ArrayList<Equipo>) serviceEquipo.consultarEquipos();
            System.out.println(equipos.get(0).getIdEquipo());
        }catch (Exception e){
            e.printStackTrace();
            Assert.assertTrue(false);
        }
    }*/
}

