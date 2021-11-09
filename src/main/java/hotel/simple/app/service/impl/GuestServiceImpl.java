package hotel.simple.app.service.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.jboss.logging.Logger;

import hotel.simple.app.entity.Guest;
import hotel.simple.app.repository.GuestRepository;
import hotel.simple.app.service.GuestService;

@ApplicationScoped
public class GuestServiceImpl implements GuestService {
	
	private static final Logger LOG = Logger.getLogger(GuestServiceImpl.class);
	
	private final GuestRepository guestRepository;
	
	public GuestServiceImpl(GuestRepository guestRepository) {
		this.guestRepository = guestRepository;
	}

	@Override
	@Transactional
	public Guest create(Guest guest) {
		LOG.debugf("Request to create Guest : {}", guest);
		
		guestRepository.persist(guest);
		
		return guest;
	}

	@Override
	@Transactional
	public Guest update(Guest guest) {
		LOG.debugf("Request to update Guest : {}", guest);
		
		// TODO: to implements
		
		return null;
	}

	@Override
	public List<Guest> findAll() {
		LOG.debug("Request to get all Guests");
		
		return guestRepository.listAll();
	}

	@Override
	public Optional<Guest> findOne(Long id) {
		LOG.debugf("Request to get Guest with id : {}", id);
		
		return guestRepository.findByIdOptional(id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		LOG.debugf("Request to delete Guest with id : {}", id);
		
		// TODO: to implements
	}

}
