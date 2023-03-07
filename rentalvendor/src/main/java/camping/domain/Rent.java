package camping.domain;

import camping.domain.DeliveryConfirmed;
import camping.domain.EquipmentPicked;
import camping.domain.EquipmentCanclled;
import camping.RentalvendorApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Rent_table")
@Data

public class Rent  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String equipmentName;
    
    
    
    
    
    private Integer qty;
    
    
    
    
    
    private Long reserveId;
    
    
    
    
    
    private Integer duration;
    
    
    
    
    
    private String rentalStatus;

    @PostPersist
    public void onPostPersist(){


        DeliveryConfirmed deliveryConfirmed = new DeliveryConfirmed(this);
        deliveryConfirmed.publishAfterCommit();



        EquipmentPicked equipmentPicked = new EquipmentPicked(this);
        equipmentPicked.publishAfterCommit();



        EquipmentCanclled equipmentCanclled = new EquipmentCanclled(this);
        equipmentCanclled.publishAfterCommit();

    }

    public static RentRepository repository(){
        RentRepository rentRepository = RentalvendorApplication.applicationContext.getBean(RentRepository.class);
        return rentRepository;
    }




    public static void decreaseEquipment(Reserved reserved){

        /** Example 1:  new item 
        Rent rent = new Rent();
        repository().save(rent);
        */

        /** Example 2:  finding and process */     
        System.out.println("reserved.getId=========" + reserved.getId() + ", getEquipmentId:" + reserved.getEquipmentId() +"#######");
        repository().findById(reserved.getEquipmentId()).ifPresent(rent->{
            
            rent.setQty(rent.getQty() - reserved.getRentQty()); // do something
            rent.setReserveId(reserved.getId());
            rent.setId(reserved.getEquipmentId());
            repository().save(rent);
         });        
    }

    public static void decreaseEquipment(SiteReserved siteReserved){

        /** Example 1:  new item 
        Rent rent = new Rent();
        repository().save(rent);
        */

        /** Example 2:  finding and process */        
        System.out.println("siteReserved.getId=========" + siteReserved.getId() + ", getEquipmentId:" + siteReserved.getEquipmentId() +"#######");
        repository().findById(siteReserved.getEquipmentId()).ifPresent(rent->{            
            rent.setQty(rent.getQty() - siteReserved.getRentQty()); // do something
            rent.setReserveId(siteReserved.getId());
            rent.setId(siteReserved.getEquipmentId());
            repository().save(rent);
         });
    }
    public static void increaseEquipment(EquipmentCanclled equipmentCanclled){

        /** Example 1:  new item 
        Rent rent = new Rent();
        repository().save(rent);

        */

        /** Example 2:  finding and process    
        
        repository().findById(equipmentCanclled.get???()).ifPresent(rent->{
            
            rent // do something
            repository().save(rent);


         });
        */        
    }
    public static void increaseEquipment(SiteCancelled siteCancelled){

        /** Example 1:  new item 
        Rent rent = new Rent();
        repository().save(rent);

        */

        /** Example 2:  finding and process
        
        repository().findById(siteCancelled.get???()).ifPresent(rent->{
            
            rent // do something
            repository().save(rent);


         });
        */

        
    }


}
