package camping.domain;

import camping.domain.*;
import camping.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class EquipmentCanclled extends AbstractEvent {

    private Long id;

    public EquipmentCanclled(Rent aggregate){
        super(aggregate);
    }
    public EquipmentCanclled(){
        super();
    }
}
