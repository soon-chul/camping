package camping.domain;

import camping.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class Cancelled extends AbstractEvent {

    private Long id;
}
