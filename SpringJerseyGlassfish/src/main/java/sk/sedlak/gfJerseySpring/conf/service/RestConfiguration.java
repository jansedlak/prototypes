package sk.sedlak.gfJerseySpring.conf.service;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.jsonp.JsonProcessingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import sk.sedlak.gfJerseySpring.conf.BasePackageMarkup;

import javax.json.stream.JsonGenerator;

/**
 * gfJerseySpring
 * Created by his majesty jansedlakMBp on 20/02/16.
 */
public class RestConfiguration  extends ResourceConfig{

//    private static final Logger log = LoggerFactory.getLogger(RestConfiguration.class);

    public RestConfiguration() {

        register(RequestContextFilter.class);
        register(JacksonFeature.class);
//        register(RestObjectMapperProvider.class);
//        register(RestResponseFilter.class);
        register(JsonProcessingFeature.class);
//        register(MultiPartFeature.class);
        property(JsonGenerator.PRETTY_PRINTING, true);
        packages(true, BasePackageMarkup.class.getPackage().getName());

//        log.debug("Rest configuration initialized.");
    }
}
