package camping.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;


@Entity
@Table(name="Rentalnfo_table")
@Data
public class Rentalnfo {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long customerId;
        private Long siteId;
        private String siteName;
        private String posting;
        private String equipmentName;
        private Long reserveId;


}
