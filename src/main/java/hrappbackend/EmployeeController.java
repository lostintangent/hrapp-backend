package hrappbackend;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController
{
    @Autowired
    private EmployeeRepository employeeRepository;
     
    @GetMapping(produces="application/json")
    public List<Employee> getEmployees(@RequestParam Optional<String> name)
    {
        List<Employee> employees = employeeRepository.getAllEmployees();
    
        if (name.isPresent()) {
            Stream<Employee> stream = employees.stream().filter((Employee employee) -> {
                boolean isMatch = name.get() == employee.firstName;
                return isMatch;
            });

            return stream.collect(Collectors.toList());
        } else {
            return employees;
        }
    }
     
    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee)
    {
        Integer id = employeeRepository.getAllEmployees().size() + 1;
        employee.id = id;
         
        employeeRepository.addEmployee(employee);
         
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(employee.id)
                                    .toUri();
         
        return ResponseEntity.created(location).build();
    }
}