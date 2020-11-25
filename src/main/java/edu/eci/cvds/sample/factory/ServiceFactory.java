package edu.eci.cvds.sample.factory;

import static com.google.inject.Guice.createInjector;
import com.google.inject.Injector;

import edu.eci.cvds.sample.services.ServiceElemento;
import edu.eci.cvds.sample.services.ServiceEquipo;
import edu.eci.cvds.sample.services.ServiceHistorialEquipos;
import edu.eci.cvds.sample.services.impl.ServiceElementoImpl;
import edu.eci.cvds.sample.services.impl.ServiceEquipolmpl;
import edu.eci.cvds.sample.services.impl.ServiceHistorialEquiposImpl;

import edu.eci.cvds.sampleprj.dao.UsersDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBatisUsuarioDao;

import edu.eci.cvds.sampleprj.dao.EquipoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBatisEquipoDao;

import edu.eci.cvds.sampleprj.dao.ElementoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBatisElementoDao;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

public class ServiceFactory {

    private static ServiceFactory instance = new ServiceFactory();
    private static Injector injector;
    
    public ServiceFactory(){
        injector = createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize(){
                //install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");
                /**Servicios*/
                bind(ServiceHistorialEquipos.class).to(ServiceHistorialEquiposImpl.class);
                bind(ServiceEquipo.class).to(ServiceEquipolmpl.class);
                bind(ServiceElemento.class).to(ServiceElementoImpl.class);
                /**DAO*/
                bind(UsersDAO.class).to(MyBatisUsuarioDao.class);
                bind(EquipoDAO.class).to(MyBatisEquipoDao.class);
                bind(ElementoDAO.class).to(MyBatisElementoDao.class);
            }
        });
    }

    public ServiceHistorialEquipos getServiceHistorialEquipos(){
        return injector.getInstance(ServiceHistorialEquipos.class);
    }

    public  ServiceEquipo getServiceEquipo(){
        return  injector.getInstance(ServiceEquipo.class);
    }

    public ServiceElemento getServiceElemento(){
        return  injector.getInstance(ServiceElemento.class);
    }

    public static ServiceFactory getInstance(){
        return instance;
    }
}