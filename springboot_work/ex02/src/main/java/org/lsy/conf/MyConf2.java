package org.lsy.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.lsy.components")
// 어떤 디렉토리를 읽어서 객체 DI 해라
public class MyConf2 {
}
