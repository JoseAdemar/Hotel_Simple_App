package hotel.simple.app.service;

import java.util.List;
import java.util.Optional;

import hotel.simple.app.entity.Guest;

public interface GuestService {
	
	Guest create(Guest guest);
	
	Guest update(Guest guest);
	
	List<Guest> findAll();
	
	Optional<Guest> findOne(Long id);
	
	void delete(Long id);

}
