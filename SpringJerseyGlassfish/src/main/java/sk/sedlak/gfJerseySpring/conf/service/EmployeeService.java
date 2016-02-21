package sk.sedlak.gfJerseySpring.conf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Map;

/**
 * Created by jan.sedlak on 2/1/2016.
 */
    @Path("/manage" )
    @Component
    public class EmployeeService {
        @Autowired
        private EmployeeRepository employeeRepository;

        @GET
        @Path("/{id}")
        @Produces("application/json")
        public Response getEmp(@PathParam("id") String id) {
            Map<String,String> map = employeeRepository.getEmpDetail(id);
            return Response.ok(map).build();
        }
}
