package camping.domain;

import camping.domain.Reserved;
import camping.domain.Cancelled;
import camping.CustomerApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Reserve_table")
@Data

public class Reserve  {
 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String region;
    private Long customerId;
    private Integer duration;
    private Long siteId;
    private String reserveStatus;
    private Long equipmentId;
    private Integer siteCnt;
    private Integer rentQty;

    @PostPersist
    public void onPostPersist(){
        Reserved reserved = new Reserved(this);
        reserved.publishAfterCommit();
    }


    @PostUpdate
    public void onPostUpdate(){
        Cancelled cancelled = new Cancelled(this);
        cancelled.publishAfterCommit();
    }
    
    public static ReserveRepository repository(){
        ReserveRepository reserveRepository = CustomerApplication.applicationContext.getBean(ReserveRepository.class);
        return reserveRepository;
    }




    public static void updatesiteinfo(SiteReserved siteReserved){

        /** Example 1:  new item 
        Reserve reserve = new Reserve();
        repository().save(reserve);

        */

        /** Example 2:  finding and process
        
        repository().findById(siteReserved.get???()).ifPresent(reserve->{
            
            reserve // do something
            repository().save(reserve);


         });
        */

        
    }
    public static void updaterental(EquipmentPicked equipmentPicked){

        /** Example 1:  new item 
        Reserve reserve = new Reserve();
        repository().save(reserve);

        */

        /** Example 2:  finding and process
        
        repository().findById(equipmentPicked.get???()).ifPresent(reserve->{
            
            reserve // do something
            repository().save(reserve);


         });
        */

        
    }


}
