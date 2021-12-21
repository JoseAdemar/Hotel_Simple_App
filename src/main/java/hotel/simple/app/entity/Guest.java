package hotel.simple.app.entity;

import java.time.LocalDate;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "guest")
public class Guest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@NotBlank
	@Size(max = 50)
	@Column(name = "first_name")
	private String firstName;

	@NotBlank
	@Size(max = 50)
	@Column(name = "last_name")
	private String lastName;

	@Past
	@NotBlank
	@JsonbDateFormat(value = "yyyy/MM/dd")
	@Column(name = "date_of_birth")
	private LocalDate dateOfBirth;

	@Email
	@Column(unique = true)
	private String email;
	
	@Column(name = "phone_number")
	private String phoneNumber;

}