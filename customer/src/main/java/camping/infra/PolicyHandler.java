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
    @Autowired ReserveRepository reserveRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='SiteReserved'")
    public void wheneverSiteReserved_Updatesiteinfo(@Payload SiteReserved siteReserved){

        SiteReserved event = siteReserved;
        System.out.println("\n\n##### listener Updatesiteinfo : " + siteReserved + "\n\n");


        

        // Sample Logic //
        Reserve.updatesiteinfo(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='EquipmentPicked'")
    public void wheneverEquipmentPicked_Updaterental(@Payload EquipmentPicked equipmentPicked){

        EquipmentPicked event = equipmentPicked;
        System.out.println("\n\n##### listener Updaterental : " + equipmentPicked + "\n\n");


        

        // Sample Logic //
        Reserve.updaterental(event);
        

        

    }

}


