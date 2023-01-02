package kata.task.SpringBootCRUD.model;


import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "lastName")
    String lastName;
    @Column(name = "age")
    int age;

    public User(){

    }

    public User(String name, String lastName, int age){
        this.age = age;
        this.name = name;
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setName(String name) {
        this.name = name;
    }
}
