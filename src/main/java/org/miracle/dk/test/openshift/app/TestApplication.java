package org.miracle.dk.test.openshift.app;


import io.quarkus.vertx.web.Route;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.MediaType;
import java.sql.Timestamp;
import java.util.logging.Logger;

@ApplicationScoped
public class TestApplication {

    private final Logger LOGGER = Logger.getLogger("TestApplication");

    @ConfigProperty(name = "greeting", defaultValue = "No One")
    String greeting;

    @Route(produces = MediaType.TEXT_PLAIN)
    public Uni<String> hello() {
        LOGGER.info(new Timestamp(System.currentTimeMillis()).toString());
        calc();
        return Uni.createFrom().item("Hello " + greeting + " from Quarkus Native");
    }

    public void calc() {
            for (int y = 0; y < 50; y++) {
                for (int i = 0; i < 100000; i++) {
                    double result = Math.atan(Math.tan(Math.atan(Math.tan(Math.atan(Math.tan(Math.tan(Math.tan(i))))))));
                }
            }
        LOGGER.info(new Timestamp(System.currentTimeMillis()).toString());

    }
}