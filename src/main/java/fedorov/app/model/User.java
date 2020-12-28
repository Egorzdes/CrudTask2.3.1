package fedorov.app.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue
   private Long id;

   @Column(name = "firstName")
   @NotEmpty(message = "firstName should not be empty")
   @Size(min = 2, max = 30, message = "firstName should be between 2 and 30 characters")
   private String firstName;


   @Column(name = "lastName")
   @NotEmpty(message = "lastName should not be empty")
   @Size(min = 2, max = 30, message = "lastName should be between 2 and 30 characters")
   private String lastName;

   @Column(name = "email")
   @NotEmpty(message = "email should not be empty")
   @Email(message = "email should be valid")
   private String email;

   public User() {
   }

   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public User(Long id, String firstName, String lastName) {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", email='" + email + '\'' +
              '}';
   }

   public void setEmail(String email) {
      this.email = email;
   }
}