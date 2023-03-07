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

    @PostUpdate
    public void onPostUpdate(){





/* 
        SiteCancelled siteCancelled = new SiteCancelled(this);
        siteCancelled.publishAfterCommit();
*/
    }

    public static SiteRepository repository(){
        SiteRepository siteRepository = CampsiteApplication.applicationContext.getBean(SiteRepository.class);
        return siteRepository;
    }




    public static void descreaseSite(Reserved reserved){

        /** Example 2:  finding and process */
        System.out.println("siteId1: ====================" + reserved.getSiteId());
        repository().findById(reserved.getSiteId()).ifPresent(site -> {
            System.out.println("siteId2:" + reserved.getSiteId());
            site.setSiteCnt(site.getSiteCnt() - reserved.getSiteCnt()); 
            repository().save(site);

            SiteReserved siteReserved = new SiteReserved(site);
            siteReserved.publishAfterCommit();
         });        
    }
    
    public static void increaseSite(Cancelled cancelled){

        /** Example 1:  new item 
        Site site = new Site();
        repository().save(site);

        */

        /** Example 2:  finding and process
        
        repository().findById(cancelled.get???()).ifPresent(site->{
            
            site // do something
            repository().save(site);


         });
        

        repository().findById(cancelled.getSiteId()).ifPresent(site->{
            
            site.setSiteCnt(site.getSiteCnt() + cancelled.getSiteCnt()); 
            repository().save(site);


         });
        */


        
    }


}
