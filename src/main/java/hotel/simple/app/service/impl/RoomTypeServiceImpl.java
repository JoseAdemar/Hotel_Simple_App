package hotel.simple.app.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.jboss.logging.Logger;

import hotel.simple.app.dto.RoomTypeDTO;
import hotel.simple.app.entity.RoomType;
import hotel.simple.app.mapper.RoomTypeMapper;
import hotel.simple.app.repository.RoomTypeRepository;
import hotel.simple.app.service.RoomTypeService;

@ApplicationScoped
public class RoomTypeServiceImpl implements RoomTypeService {
	
	private static final Logger LOG = Logger.getLogger(RoomTypeServiceImpl.class);

	private final RoomTypeRepository roomTypeRepository;
	
	private final RoomTypeMapper roomTypeMapper;
	
	public RoomTypeServiceImpl(RoomTypeRepository roomTypeRepository, RoomTypeMapper roomTypeMapper) {
		this.roomTypeRepository = roomTypeRepository;
		this.roomTypeMapper = roomTypeMapper;
	}

	/**
	 * Create a new RoomType
	 */
	@Override
	@Transactional
	public RoomTypeDTO create(RoomTypeDTO roomTypeDTO) {
		LOG.debugf("Request to create RoomType : {}", roomTypeDTO);
		
		RoomType roomType = roomTypeMapper.toEntity(roomTypeDTO);
		roomTypeRepository.persist(roomType);
		RoomTypeDTO result = roomTypeMapper.toDto(roomType);
		
		return result;
	}

	/**
	 * Update an existing RoomType
	 */
	@Override
	public RoomTypeDTO update(RoomTypeDTO roomTypeDTO) {
		LOG.debugf("Request to update RoomType : {}", roomTypeDTO);
		
		RoomType roomType = roomTypeMapper.toEntity(roomTypeDTO);
		roomTypeRepository.persist(roomType);
		RoomTypeDTO result = roomTypeMapper.toDto(roomType);
		
		return result;
	}

	/**
	 * Find a RoomType with a given id
	 */
	@Override
	@Transactional
	public Optional<RoomTypeDTO> findOne(Long id) {
		LOG.debugf("Request to get RoomType : {}", id);
		
		RoomType roomType = roomTypeRepository.findById(id);
		RoomTypeDTO roomTypeDTO = roomTypeMapper.toDto(roomType);
		
		return Optional.of(roomTypeDTO);
	}

	/**
	 * Find all RoomTypes
	 */
	@Override
	@Transactional
	public List<RoomTypeDTO> findAll() {
		LOG.debugf("Request to get all RoomTypes");
		
		List<RoomType> roomTypes = roomTypeRepository.listAll();
		
		if(roomTypes.isEmpty()) {
			return Collections.emptyList();
		}
		
		return roomTypes.stream().map(roomType -> roomTypeMapper.toDto(roomType)).collect(Collectors.toList());
	}

	/**
	 * Delete a RoomType with a given id
	 */
	@Override
	@Transactional
	public void delete(Long id) {
		LOG.debugf("Request to delete RoomType : {}", id);
		
		roomTypeRepository.deleteById(id);
	}

}
