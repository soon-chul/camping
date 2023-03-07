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

    @PostPersist
    public void onPostPersist(){


        SiteReserved siteReserved = new SiteReserved(this);
        siteReserved.publishAfterCommit();



        SiteCancelled siteCancelled = new SiteCancelled(this);
        siteCancelled.publishAfterCommit();

    }

    public static SiteRepository repository(){
        SiteRepository siteRepository = CampsiteApplication.applicationContext.getBean(SiteRepository.class);
        return siteRepository;
    }




    public static void descreaseSite(Reserved reserved){

        /** Example 1:  new item 
        Site site = new Site();
        repository().save(site);

        */

        /** Example 2:  finding and process
        
        repository().findById(reserved.get???()).ifPresent(site->{
            
            site // do something
            repository().save(site);


         });
        */

        
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
        */

        
    }


}
