package camping.domain;

import camping.domain.*;
import camping.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class SiteReserved extends AbstractEvent {

    private Long id;
    private String siteName;
    private String posting;
    private Long reserveId;
    private Long equipmentId;
    private Integer rentQty;
}


