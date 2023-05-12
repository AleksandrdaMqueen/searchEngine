package repository;



import model.Site;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepo extends CrudRepository<Site,Integer> {
}
