package searcheng.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import searcheng.model.Page;


@Repository
public interface PageRepo extends CrudRepository<Page, Integer> {
}
