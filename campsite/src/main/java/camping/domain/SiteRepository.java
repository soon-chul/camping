package camping.domain;

import camping.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="sites", path="sites")
public interface SiteRepository extends PagingAndSortingRepository<Site, Long>{

}
