package web.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String surName;
    @Column
    private String department;
    @Column
    private int salary;

    public Users(String name, String surName, String department, int salary) {
        this.name = name;
        this.surName = surName;
        this.department = department;
        this.salary = salary;
    }

    public Users() {}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getSurName() {return surName;}

    public void setSurName(String surName) {this.surName = surName;}

    public String getDepartment() {return department;}

    public void setDepartment(String department) {this.department = department;}

    public int getSalary() {return salary;}

    public void setSalary(int salary) {this.salary = salary;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id && salary == users.salary && Objects.equals(name, users.name) && Objects.equals(surName, users.surName) && Objects.equals(department, users.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surName, department, salary);
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
