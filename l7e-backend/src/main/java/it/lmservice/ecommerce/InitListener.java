package it.lmservice.ecommerce;

import it.lmservice.ecommerce.service.InitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class InitListener{

    @Autowired
    private InitService initService;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReadyEvent() {
        System.out.println("INIT LISTENER STARTED");

        try{
            initService.initShopItems();
        } catch (Exception e) {
            log.error("Unable to init shop items", e);
        }

        System.out.println("INIT LISTENER FINISHED");
    }
}
