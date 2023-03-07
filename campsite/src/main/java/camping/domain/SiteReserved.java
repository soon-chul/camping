package camping.domain;

import camping.domain.*;
import camping.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class SiteReserved extends AbstractEvent {

    private Long id;
    private String siteName;
    private String posting;
    private Long reserveId;

    public SiteReserved(Site aggregate){
        super(aggregate);
    }
    public SiteReserved(){
        super();
    }
}
