package camping.infra;
import camping.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class ReserveHateoasProcessor implements RepresentationModelProcessor<EntityModel<Reserve>>  {

    @Override
    public EntityModel<Reserve> process(EntityModel<Reserve> model) {

        
        return model;
    }
    
}
