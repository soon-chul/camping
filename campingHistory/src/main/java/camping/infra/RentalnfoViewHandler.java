package camping.infra;

import camping.domain.*;
import camping.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class RentalnfoViewHandler {

    @Autowired
    private RentalnfoRepository rentalnfoRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenReserved_then_CREATE_1 (@Payload Reserved reserved) {
        try {

            if (!reserved.validate()) return;

            // view 객체 생성
            Rentalnfo rentalnfo = new Rentalnfo();
            // view 객체에 이벤트의 Value 를 set 함
            rentalnfo.setCustomerId(reserved.getCustomerId());
            rentalnfo.setReserveId(reserved.getId());
            // view 레파지 토리에 save
            rentalnfoRepository.save(rentalnfo);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenSiteReserved_then_UPDATE_1(@Payload SiteReserved siteReserved) {
        try {
            if (!siteReserved.validate()) return;
                // view 객체 조회

                List<Rentalnfo> rentalnfoList = rentalnfoRepository.findByReserveId(siteReserved.getReserveId());
                for(Rentalnfo rentalnfo : rentalnfoList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    rentalnfo.setSiteId(siteReserved.getId());
                    rentalnfo.setSiteName(siteReserved.getSiteName());
                    rentalnfo.setPosting(siteReserved.getPosting());
                // view 레파지 토리에 save
                rentalnfoRepository.save(rentalnfo);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenEquipmentPicked_then_UPDATE_2(@Payload EquipmentPicked equipmentPicked) {
        try {
            if (!equipmentPicked.validate()) return;
                // view 객체 조회

                List<Rentalnfo> rentalnfoList = rentalnfoRepository.findByReserveId(equipmentPicked.getReserveId());
                for(Rentalnfo rentalnfo : rentalnfoList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    rentalnfo.setEquipmentName(equipmentPicked.getEquipmentName());
                // view 레파지 토리에 save
                rentalnfoRepository.save(rentalnfo);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCancelled_then_DELETE_1(@Payload Cancelled cancelled) {
        try {
            if (!cancelled.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            rentalnfoRepository.deleteByReserveId(cancelled.getId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

