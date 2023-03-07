package camping.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import camping.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import camping.domain.*;

@Service
@Transactional
public class PolicyHandler{
    @Autowired RentRepository rentRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Reserved'")
    public void wheneverReserved_DecreaseEquipment(@Payload Reserved reserved){

        Reserved event = reserved;
        System.out.println("\n\n##### listener DecreaseEquipment : " + reserved + "\n\n");


        

        // Sample Logic //
        Rent.decreaseEquipment(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='SiteReserved'")
    public void wheneverSiteReserved_DecreaseEquipment(@Payload SiteReserved siteReserved){

        SiteReserved event = siteReserved;
        System.out.println("\n\n##### listener DecreaseEquipment : " + siteReserved + "\n\n");


        

        // Sample Logic //
        Rent.decreaseEquipment(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='EquipmentCanclled'")
    public void wheneverEquipmentCanclled_IncreaseEquipment(@Payload EquipmentCanclled equipmentCanclled){

        EquipmentCanclled event = equipmentCanclled;
        System.out.println("\n\n##### listener IncreaseEquipment : " + equipmentCanclled + "\n\n");


        

        // Sample Logic //
        Rent.increaseEquipment(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='SiteCancelled'")
    public void wheneverSiteCancelled_IncreaseEquipment(@Payload SiteCancelled siteCancelled){

        SiteCancelled event = siteCancelled;
        System.out.println("\n\n##### listener IncreaseEquipment : " + siteCancelled + "\n\n");


        

        // Sample Logic //
        Rent.increaseEquipment(event);
        

        

    }

}


