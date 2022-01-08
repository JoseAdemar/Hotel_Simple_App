package hotel.simple.app.service;

import java.util.List;
import java.util.Optional;

import hotel.simple.app.dto.RoomTypeDTO;

public interface RoomTypeService {
	
	RoomTypeDTO create(RoomTypeDTO roomTypeDTO);
	
	RoomTypeDTO update(RoomTypeDTO roomTypeDTO);
	
	Optional<RoomTypeDTO> findOne(Long id);
	
	List<RoomTypeDTO> findAll();
	
	void delete(Long id);

}
