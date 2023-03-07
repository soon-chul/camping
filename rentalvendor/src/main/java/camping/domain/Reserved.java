package camping.domain;

import camping.domain.*;
import camping.infra.AbstractEvent;
import lombok.*;
import java.util.*;
@Data
@ToString
public class Reserved extends AbstractEvent {

    private Long id;
    private Long customerId;
    private Long siteId;
    private Long equipmentId; // 추가
    private Integer rentQty;  // 추가
}


