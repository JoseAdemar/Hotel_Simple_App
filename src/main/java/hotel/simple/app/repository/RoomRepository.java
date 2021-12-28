package hotel.simple.app.repository;

import javax.enterprise.context.ApplicationScoped;

import hotel.simple.app.entity.Room;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class RoomRepository implements PanacheRepositoryBase<Room, Long> {
	
}
