package crudproject.models;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "The name cannot be empty")
    @Size(min = 2, max = 15, message = "The name must be more than 2 and less than 15 characters")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "The lastname cannot be empty")
    @Size(min = 2, max = 15, message = "The lastname must be more than 2 and less than 15 characters")
   @Column(name = "lastname")
    private String lastname;

    @Min(value = 0, message = "The age must be more than 18 years old")
    @Column(name = "age")
    private int age;

    @NotEmpty(message = "The email cannot be empty")
    @Email(message = "invalid email format")
    @Column(name = "email")
    private String email;

    public User() {
    }

    public User(int id, String name, String lastname, int age, String email) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}

