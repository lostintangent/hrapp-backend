package hrappbackend;
 
public class Employee {
    public Integer id;
    public String firstName;
    public String lastName;
    public String email;
 
    public Employee(Integer id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}