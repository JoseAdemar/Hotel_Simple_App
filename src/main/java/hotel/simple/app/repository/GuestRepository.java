package hotel.simple.app.repository;

import hotel.simple.app.entity.Guest;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped

public class GuestRepository implements PanacheRepositoryBase<Guest,Long> {
}
