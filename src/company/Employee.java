package company;

public class Employee {
    private String name;
    private Integer id;
    private Integer managerId;

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public Employee(String name, Integer id, Integer managerId) {
        this.name = name;
        this.id = id;
        this.managerId = managerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + id + ", managerId: " + managerId;
    }
}
