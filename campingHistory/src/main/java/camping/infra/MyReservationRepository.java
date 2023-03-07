package camping.infra;

import camping.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="rentalnfos", path="rentalnfos")
public interface MyReservationRepository extends PagingAndSortingRepository<MyReservation, Long> {

    List<MyReservation> findByReserveId(Long reserveId);


    void deleteByReserveId(Long reserveId);

}
