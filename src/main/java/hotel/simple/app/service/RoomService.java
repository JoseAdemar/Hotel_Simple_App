package hotel.simple.app.service;

import java.util.List;
import java.util.Optional;

import hotel.simple.app.dto.RoomDTO;

public interface RoomService {
	
	RoomDTO create(RoomDTO roomDTO);
	
	RoomDTO update(RoomDTO roomDTO);
	
	Optional<RoomDTO> findOne(Long id);
	
	List<RoomDTO> findAll();
	
	void delete(Long id);

}
