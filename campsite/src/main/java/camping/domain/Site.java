package camping.domain;

import camping.domain.SiteReserved;
import camping.domain.SiteCancelled;
import camping.CampsiteApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Site_table")
@Data

public class Site  {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    private Long id;    
    private String siteName;
    private Long customerId;
    private Integer siteCnt;
    private String address;    
    private Integer siteNo;
    private String siteStatus;
    private String posting;    
    private Long reserveId;
    private Long equipmentId;
    private Integer rentQty;

    @PostUpdate
    public void onPostUpdate(){
        // SiteCancelled siteCancelled = new SiteCancelled(this);
        // siteCancelled.publishAfterCommit();
    }

    public static SiteRepository repository(){
        SiteRepository siteRepository = CampsiteApplication.applicationContext.getBean(SiteRepository.class);
        return siteRepository;
    }

    public static void descreaseSite(Reserved reserved){

        /** Example 2:  finding and process */
        repository().findById(reserved.getSiteId()).ifPresent(site -> {
            site.setSiteCnt(site.getSiteCnt() - reserved.getSiteCnt()); 
            
            site.setReserveId(reserved.getId());
            site.setCustomerId(reserved.getCustomerId());
            site.setEquipmentId(reserved.getEquipmentId());
            site.setRentQty(reserved.getRentQty());
            repository().save(site);

            SiteReserved siteReserved = new SiteReserved(site);
            siteReserved.publishAfterCommit();
         });        
    }
    
    public static void increaseSite(Cancelled cancelled){
        /** Example 2:  finding and process */
        repository().findById(cancelled.getSiteId()).ifPresent(site->{
            
            site.setSiteCnt(site.getSiteCnt() + cancelled.getSiteCnt()); 
            site.setReserveId(cancelled.getId());
            site.setCustomerId(cancelled.getCustomerId());
            site.setEquipmentId(cancelled.getEquipmentId());
            site.setRentQty(cancelled.getRentQty());
            repository().save(site);
            SiteCancelled siteCancelled = new SiteCancelled(site);
            siteCancelled.publishAfterCommit();
        });        
    }


}
