package camping.domain;

import camping.domain.*;
import camping.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class EquipmentPicked extends AbstractEvent {

    private Long id;
    private String equipmentName;
    private Long reserveId;

    public EquipmentPicked(Rent aggregate){
        super(aggregate);
    }
    public EquipmentPicked(){
        super();
    }
}
