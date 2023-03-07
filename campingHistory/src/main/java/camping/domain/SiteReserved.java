package camping.domain;

import camping.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class SiteReserved extends AbstractEvent {

    private Long id;
    private String siteName;
    private String posting;
    private Long reserveId;
}
