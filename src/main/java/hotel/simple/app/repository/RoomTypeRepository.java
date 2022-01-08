package hotel.simple.app.repository;

import javax.enterprise.context.ApplicationScoped;

import hotel.simple.app.entity.RoomType;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class RoomTypeRepository implements PanacheRepositoryBase<RoomType, Long> {
	
}
