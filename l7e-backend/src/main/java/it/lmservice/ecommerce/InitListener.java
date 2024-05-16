package it.lmservice.ecommerce;

import it.lmservice.ecommerce.service.InitService;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class InitListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private InitService initService;

    @Override
    public void onApplicationEvent(@NotNull ContextRefreshedEvent event) {
        System.out.println("INIT LISTENER STARTED");

        try{
            initService.initShopItems();
        } catch (Exception e) {
            log.error("Unable to init shop items", e);
        }

        System.out.println("INIT LISTENER FINISHED");
    }
}
