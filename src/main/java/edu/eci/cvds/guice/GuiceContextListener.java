package edu.eci.cvds.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import edu.eci.cvds.sample.services.ServiceElemento;
import edu.eci.cvds.sample.services.ServiceEquipo;
import edu.eci.cvds.sample.services.impl.ServiceElementoImpl;
import edu.eci.cvds.sample.services.impl.ServiceEquipolmpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.cvds.sample.services.ServiceHistorialEquipos;
import edu.eci.cvds.sample.services.impl.ServiceHistorialEquiposImpl;

import edu.eci.cvds.sampleprj.dao.UsersDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBatisUsuarioDao;

import edu.eci.cvds.sampleprj.dao.EquipoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBatisEquipoDao;

import edu.eci.cvds.sampleprj.dao.ElementoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.MyBatisElementoDao;

public class GuiceContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.removeAttribute(Injector.class.getName());
	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		Injector injector = Guice.createInjector(new XMLMyBatisModule() {
			@Override
			protected void initialize() {
				install(JdbcHelper.PostgreSQL);
				setEnvironmentId("development");
				setClassPathResource("mybatis-config.xml");

				bind(ServiceHistorialEquipos.class).to(ServiceHistorialEquiposImpl.class);
				bind(ServiceEquipo.class).to(ServiceEquipolmpl.class);
				bind(ServiceElemento.class).to(ServiceElementoImpl.class);
				/**Usuario*/
				bind(UsersDAO.class).to(MyBatisUsuarioDao.class);
				/**Elemento*/
				bind(EquipoDAO.class).to(MyBatisEquipoDao.class);
				/**Equipo*/
				bind(ElementoDAO.class).to(MyBatisElementoDao.class);
			}
		});
		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.setAttribute(Injector.class.getName(), injector);
	}
}