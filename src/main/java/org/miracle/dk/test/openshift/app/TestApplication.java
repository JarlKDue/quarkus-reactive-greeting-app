package org.miracle.dk.test.openshift.app;


import io.quarkus.vertx.web.Route;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
public class TestApplication {

    @ConfigProperty(name = "greeting", defaultValue = "No One")
    String greeting;

    @Route(produces = MediaType.TEXT_PLAIN)
    public Uni<String> hello() {
        return Uni.createFrom().item("Hello " + greeting + " from Quarkus Native");
    }
}