package com.lxcecho.conf;

import com.lxcecho.entity.Eman;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lxcecho 909231497@qq.com
 * @since 21:54 15-01-2023
 */
@Configuration
public class EmanConfig {

    @Bean(name="eman")
    public Eman getEman() {
        Eman eman = new Eman();
        eman.setAge(1);
        eman.setName("eman");
        return eman;
    }

}
