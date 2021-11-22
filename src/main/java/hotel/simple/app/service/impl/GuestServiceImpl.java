package hotel.simple.app.service.impl;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

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

		Optional<Guest> guestOp = guestRepository.findByIdOptional(guest.getId());

		if (guestOp.isEmpty()) {

			throw new NotFoundException();
		}

		Guest getGuest = guestOp.get();

		getGuest.setFirstName(guest.getFirstName());
		getGuest.setLastName(guest.getLastName());
		getGuest.setDateOfBirth(guest.getDateOfBirth());
		getGuest.setEmail(guest.getEmail());
		getGuest.setPhoneNumber(guest.getPhoneNumber());
		
		guestRepository.persist(getGuest);
		
		return getGuest;
	}

	@Override
	public List<Guest> findAll() {
		LOG.debug("Request to get all Guests");

		return guestRepository.listAll();
	}

	@Override
	public Optional<Guest> findOne(Long id) {
		LOG.debugf("Request to get Guest with id : {}", id);

		Optional<Guest> guestOp = guestRepository.findByIdOptional(id);

		if (guestOp.isEmpty()) {

			throw new NotFoundException();
		}

		return guestOp;
	}

	@Override
	@Transactional
	public void delete(Long id) {
		LOG.debugf("Request to delete Guest with id : {}", id);

		Optional<Guest> guestOp = guestRepository.findByIdOptional(id);

		if (guestOp.isEmpty()) {
			throw new NotFoundException();
		}

		guestRepository.delete(guestOp.get());
	}

}
