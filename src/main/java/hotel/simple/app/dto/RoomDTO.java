package hotel.simple.app.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class RoomDTO {
	
	@EqualsAndHashCode.Include
	private Long id;
	
	@NotNull
	@Min(value = 0)
	private Integer number;

}
