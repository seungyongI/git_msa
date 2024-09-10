package org.lsy.conf;

import org.lsy.components.AA;
import org.lsy.components.BB;
import org.lsy.components.CC;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConf {

    @Bean
    public AA aa(){
        return new AA();
    }
    @Bean
    public BB bb(){
        return new BB();
    }

    @Bean
    public CC cc(){
        return new CC();
    }

}
