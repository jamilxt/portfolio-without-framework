package com.pondit.portfolio;

import com.pondit.portfolio.controller.RootController;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

public class PortfolioApplication {
    public static void main(String[] args) throws LifecycleException {
        // prepare the Tomcat server
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();

        // add the context
        Context ctx = tomcat.addContext("", null);

        // add the servlet
        Wrapper servlet = Tomcat.addServlet(ctx, "rootController", new RootController());
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/*");

        // start the Tomcat server
        tomcat.start();
    }
}
