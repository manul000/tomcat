package com.study.tomcat;

import org.apache.catalina.servlets.DefaultServlet;
import org.apache.catalina.startup.Tomcat;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws Exception {
        int port = Integer.parseInt(System.getProperty("port", "8080"));
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir("target/tomcat");
        tomcat.setPort(port);
        tomcat.getConnector();
        var context =
                tomcat.addContext("/my-site", Path.of("src/main/webapp").toAbsolutePath().toString());
        Tomcat.addServlet(context, "static", new DefaultServlet());
        context.addServletMappingDecoded("/", "static");
        context.addWelcomeFile("index.html");
        context.addMimeMapping("html", "text/html");
        context.addMimeMapping("css", "text/css");
        context.addMimeMapping("js", "text/javascript");
        tomcat.start();
        System.out.println("http://localhost:" + port + "/my-site/");
        tomcat.getServer().await();
    }
}
