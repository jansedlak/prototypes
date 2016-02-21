package sk.sedlak.gfJerseySpring.conf.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jan.sedlak on 2/1/2016.
 */
@Service
public class EmployeeRepositoryImpl implements EmployeeRepository {
    public Map<String, String> getEmpDetail(String id) {
        Map<String,String> map = new HashMap<String, String>();
        map.put("Id", id);
        map.put("Name", "Jan Sedlak");
        map.put("Location", "Kosice");
        return map;
    }
}
