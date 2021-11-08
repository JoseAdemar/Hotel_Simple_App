package hotel.simple.app.repository;

import javax.enterprise.context.ApplicationScoped;

import hotel.simple.app.entity.Guest;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class GuestRepository implements PanacheRepositoryBase<Guest,Long> {
	
}
