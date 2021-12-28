package hotel.simple.app.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.jboss.logging.Logger;

import hotel.simple.app.dto.RoomDTO;
import hotel.simple.app.entity.Room;
import hotel.simple.app.mapper.RoomMapper;
import hotel.simple.app.repository.RoomRepository;
import hotel.simple.app.service.RoomService;

@ApplicationScoped
public class RoomServiceImpl implements RoomService {
	
	private static final Logger LOG = Logger.getLogger(RoomServiceImpl.class);

	private final RoomRepository roomRepository;
	
	private final RoomMapper roomMapper;
	
	public RoomServiceImpl(RoomRepository roomRepository, RoomMapper roomMapper) {
		this.roomRepository = roomRepository;
		this.roomMapper = roomMapper;
	}

	/**
	 * Create a new Room
	 */
	@Override
	@Transactional
	public RoomDTO create(RoomDTO roomDTO) {
		LOG.debugf("Request to create Room : {}", roomDTO);
		
		Room room = roomMapper.toEntity(roomDTO);
		roomRepository.persist(room);
		RoomDTO result = roomMapper.toDto(room);
		
		return result;
	}

	/**
	 * Update an existing Room
	 */
	@Override
	public RoomDTO update(RoomDTO roomDTO) {
		LOG.debugf("Request to update Room : {}", roomDTO);
		
		Room room = roomMapper.toEntity(roomDTO);
		roomRepository.persist(room);
		RoomDTO result = roomMapper.toDto(room);
		
		return result;
	}

	/**
	 * Find a Room with a given id
	 */
	@Override
	@Transactional
	public Optional<RoomDTO> findOne(Long id) {
		LOG.debugf("Request to get Room : {}", id);
		
		Room room = roomRepository.findById(id);
		RoomDTO roomDTO = roomMapper.toDto(room);
		
		return Optional.of(roomDTO);
	}

	/**
	 * Find all Rooms
	 */
	@Override
	@Transactional
	public List<RoomDTO> findAll() {
		LOG.debugf("Request to get all Rooms");
		
		List<Room> rooms = roomRepository.listAll();
		
		if(rooms.isEmpty()) {
			return Collections.emptyList();
		}
		
		return rooms.stream().map(room -> roomMapper.toDto(room)).collect(Collectors.toList());
	}

	/**
	 * Delete a Room with a given id
	 */
	@Override
	@Transactional
	public void delete(Long id) {
		LOG.debugf("Request to delete Room : {}", id);
		
		roomRepository.deleteById(id);
	}

}
