package camping.domain;

import camping.domain.*;
import camping.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class SiteCancelled extends AbstractEvent {

    private Long id;

    public SiteCancelled(Site aggregate){
        super(aggregate);
    }
    public SiteCancelled(){
        super();
    }
}
