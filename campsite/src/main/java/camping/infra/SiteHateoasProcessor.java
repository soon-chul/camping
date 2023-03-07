package camping.infra;
import camping.domain.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.hateoas.EntityModel;

@Component
public class SiteHateoasProcessor implements RepresentationModelProcessor<EntityModel<Site>>  {

    @Override
    public EntityModel<Site> process(EntityModel<Site> model) {

        
        return model;
    }
    
}
