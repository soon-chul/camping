package camping.domain;

import camping.domain.*;
import camping.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class Cancelled extends AbstractEvent {

    private Long id;

    public Cancelled(Reserve aggregate){
        super(aggregate);
    }
    public Cancelled(){
        super();
    }
}
