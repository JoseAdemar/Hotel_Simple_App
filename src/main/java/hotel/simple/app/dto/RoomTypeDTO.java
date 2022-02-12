package hotel.simple.app.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class RoomTypeDTO {
	
    @EqualsAndHashCode.Include
	private Long id;

	@NotBlank(message = "this field can not be null")
	@Size(max = 50)
	private String name;
	
	@Size(max = 100)
	private String description;

}
