package Server.Server.Service.configura;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;

@Configuration
@EnableScheduling
public class Configurat {
//    @Scheduled(cron = "*/2 * * * *")
//    public void def(){
//        System.out.println("kk");
//    }

    @Scheduled(fixedRate = 1000*3)
    public void nimadur(){
        System.out.println(new SimpleDateFormat("dd-yy-mm"));
    }
    @Scheduled(fixedDelay = 1000*1)
    public void hh(){
        System.out.println("keli");
    }
}