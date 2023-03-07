package camping.domain;

import camping.domain.*;
import camping.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class Reserved extends AbstractEvent {

    private Long id;
    private Long customerId;
    private Long siteId;
    private Integer siteCnt;

    public Reserved(Reserve aggregate){
        super(aggregate);
    }
    public Reserved(){
        super();
    }
}
