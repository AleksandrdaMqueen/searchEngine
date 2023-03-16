package searcheng.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import searcheng.model.Site;
import searcheng.model.Site;

@Repository
public interface SiteRepo extends CrudRepository<Site,Integer> {
}
