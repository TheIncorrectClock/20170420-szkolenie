package com.example.servlet.config;

import com.example.App;
import com.example.servlet.WebConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) {

        AnnotationConfigWebApplicationContext rootCtx =
                new AnnotationConfigWebApplicationContext();
        rootCtx.register(App.AppConfiguration.class);

        rootCtx.register(WebConfig.class);

        container.addListener(new ContextLoaderListener(rootCtx));

        ServletRegistration.Dynamic dispatcher =
                container.addServlet("dispatcher",
                        new DispatcherServlet(rootCtx));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
