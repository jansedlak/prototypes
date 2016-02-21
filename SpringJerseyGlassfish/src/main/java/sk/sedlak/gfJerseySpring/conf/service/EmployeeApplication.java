package sk.sedlak.gfJerseySpring.conf.service;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jan.sedlak on 2/2/2016.
 */
public class EmployeeApplication extends Application {
    private Set<Object> singletons = new HashSet<Object>();
    public EmployeeApplication() {
        singletons.add(new EmployeeService());
    }
    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
