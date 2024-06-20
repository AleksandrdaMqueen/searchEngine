package searchengine.repository;

import org.springframework.data.repository.CrudRepository;
import searchengine.model.Index;

public interface  IndexRepo extends CrudRepository<Index, Integer> {
}
