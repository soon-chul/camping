package camping.domain;

import camping.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class EquipmentPicked extends AbstractEvent {

    private Long id;
    private String equipmentName;
    private Long reserveId;
}
