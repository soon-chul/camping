package camping.domain;

import camping.domain.*;
import camping.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class Cancelled extends AbstractEvent {

    private Long id;
    private Long customerId;
    private Long siteId;
    private Integer siteCnt;
}


