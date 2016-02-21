package sk.sedlak.gfJerseySpring.conf.service;

import java.util.Map;

/**
 * Created by jan.sedlak on 2/1/2016.
 */
public interface EmployeeRepository {
    Map<String,String> getEmpDetail(String id);
}
