package searchengine.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import searchengine.model.Site;

@Repository
public interface SiteRepo extends CrudRepository<Site,Integer> {
}
