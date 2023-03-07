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
    @Autowired PaymentRepository paymentRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Cancelled'")
    public void wheneverCancelled_PaymentCancelled(@Payload Cancelled cancelled){

        Cancelled event = cancelled;
        System.out.println("\n\n##### listener PaymentCancelled : " + cancelled + "\n\n");


        

        // Sample Logic //
        Payment.paymentCancelled(event);
        

        

    }
    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='EquipmentCanclled'")
    public void wheneverEquipmentCanclled_PaymentCancelled(@Payload EquipmentCanclled equipmentCanclled){

        EquipmentCanclled event = equipmentCanclled;
        System.out.println("\n\n##### listener PaymentCancelled : " + equipmentCanclled + "\n\n");


        

        // Sample Logic //
        Payment.paymentCancelled(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Reserved'")
    public void wheneverReserved_PaymentStart(@Payload Reserved reserved){

        Reserved event = reserved;
        System.out.println("\n\n##### listener PaymentStart : " + reserved + "\n\n");


        

        // Sample Logic //
        Payment.paymentStart(event);
        

        

    }

}


