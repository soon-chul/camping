package camping.domain;

import camping.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class Reserved extends AbstractEvent {

    private Long id;
    private Long customerId;
    private Long siteId;
}
