package com.dd;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import com.dd.configuration.ApplicationConfiguration;
import com.dd.services.TestService;


public class ApplicationService extends Application<ApplicationConfiguration> {

	public static void main(String[] args) throws Exception {
		new ApplicationService().run(args);
	}

	@Override
	public void initialize(Bootstrap<ApplicationConfiguration> bootstrap) {
		// bootstrap.addBundle(new ViewBundle());
		
		// Static Resource URLS
		// bootstrap.addBundle(new RedirectBundle(new PathRedirect("/", "/web")));
		// bootstrap.addBundle(new AssetsBundle("/web", "/app"));
		// bootstrap.addBundle(new AssetsBundle("/web/index.html", "/", "index.html"));
		
	}

	@Override
	public void run(ApplicationConfiguration configuration, Environment environment) throws Exception {
		TestService testService = new TestService();
		environment.jersey().register(testService);
	}
}
