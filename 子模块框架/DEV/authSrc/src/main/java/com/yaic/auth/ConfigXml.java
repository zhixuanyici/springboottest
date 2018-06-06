package com.yaic.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations={"classpath:spring-config-shiro.xml"})
public class ConfigXml {

}
