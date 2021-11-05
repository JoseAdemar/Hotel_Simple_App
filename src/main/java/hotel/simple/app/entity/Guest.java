package hotel.simple.app.entity;

import java.time.LocalDate;

// TODO: @Entity
// TODO: @Table(name = "guest")
public class Guest {
	
	// TODO: @Id
	// TODO: @GeneratedValue
	private Long id;
	
	// TODO: @NotBlank
	// TODO: @Size(max = ??)
	// TODO: @Column(name = "first_name")
	private String firstName;
	
	// TODO: @NotBlank
	// TODO: @Size(max = ??)
	// TODO: @Column(name = "last_name")
	private String lastName;
	
	// TODO: @Past
	// TODO: @Column(name = "date_of_birth")
	private LocalDate dateOfBirth;
	
	// TODO: @Column(name = "phone_number")
	private String phoneNumber;
	
	// TODO: @Email
	// TODO: @Column(name = "email")
	private String email;

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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (!(o instanceof Guest))
            return false;
 
        Guest other = (Guest) o;
 
        return id != null && id.equals(other.getId());
    }
 
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

	@Override
	public String toString() {
		return "Guest ["
				+ "id=" + id + ", "
				+ "firstName=" + firstName + ", "
				+ "lastName=" + lastName + ", "
				+ "dateOfBirth=" + dateOfBirth + ", "
				+ "phoneNumber=" + phoneNumber + ", "
				+ "email=" + email
				+ "]";
	}
	
}
