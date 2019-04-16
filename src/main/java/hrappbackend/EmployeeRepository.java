package hrappbackend;
 
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
  
@Repository
public class EmployeeRepository
{
    private static List<Employee> list = new ArrayList<Employee>();
     
    static
    {
        list.add(new Employee(1, "Jonathan", "Carter", "joncart@microsoft.com"));
        list.add(new Employee(2, "Scott", "Hanselman", "scottha@microsoft.com"));
        list.add(new Employee(3, "PJ", "Meyer", "pymeyer@micrsoft.com"));
        list.add(new Employee(4, "Amanda", "Silver", "amandas@micrsoft.com"));
        list.add(new Employee(5, "Scott", "Guthrie", "scottgu@micrsoft.com"));
    }
     
    public List<Employee> getAllEmployees()
    {
        return list;
    }
     
    public void addEmployee(Employee employee) {
        list.add(employee);
    }
}