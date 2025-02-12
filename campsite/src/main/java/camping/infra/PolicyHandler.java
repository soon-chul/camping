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
    @Autowired SiteRepository siteRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Reserved'")
    public void wheneverReserved_DescreaseSite(@Payload Reserved reserved){

        Reserved event = reserved;
        System.out.println("\n\n##### listener DescreaseSite : " + reserved + "\n\n");

        // Sample Logic //
        Site.descreaseSite(event);
    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='Cancelled'")
    public void wheneverCancelled_IncreaseSite(@Payload Cancelled cancelled){

        Cancelled event = cancelled;
        System.out.println("\n\n##### listener IncreaseSite : " + cancelled + "\n\n");

        // Sample Logic //
        Site.increaseSite(event);
    }

}


