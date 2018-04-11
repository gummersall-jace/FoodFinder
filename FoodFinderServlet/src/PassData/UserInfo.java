package PassData;

import java.time.LocalDateTime;
import java.util.Date;

public class UserInfo {
	   private int id;
	   private String firstName; 
	   private String lastName;   
	   private String email; 
	   private String city;
	   private LocalDateTime date;

	   public UserInfo() {}
	   public UserInfo(String fname, String lname, String email, String city, LocalDateTime date) {
	      this.firstName = fname;
	      this.lastName = lname;
	      this.email = email;
	      this.city = city;
	      this.date = date;
	   }
	   
	   public int getId() {
	      return id;
	   }
	   
	   public void setId( int id ) {
	      this.id = id;
	   }
	   
	   public String getFirstName() {
	      return firstName;
	   }
	   
	   public void setFirstName( String first_name ) {
	      this.firstName = first_name;
	   }
	   
	   public String getLastName() {
	      return lastName;
	   }
	   
	   public void setLastName( String last_name ) {
	      this.lastName = last_name;
	   }
	   
	   public String getEmail() {
	      return email;
	   }
	   
	   public void setEmail( String email ) {
	      this.email = email;
	   }
	   
	   public String getCity() {
		      return city;
	   }
	   
	   public void setCity( String city ) {
	      this.city = city;
	   }
	   
	   public LocalDateTime getDate() {
		      return date;
	   }
	   
	   public void setDate( LocalDateTime date ) {
	      this.date = date;
	   }

}
