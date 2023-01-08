package com.xc.joy;

import com.xc.joy.model.People;
import com.xc.joy.service.PeopleService;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author lxcecho 909231497@qq.com
 * @since 20:20 08-01-2023
 */
public class SpringTransactionTest {
    public static void main(String[] args) {
        Resource resource = new ClassPathResource("");
        DefaultListableBeanFactory listableBeanFactory = new DefaultListableBeanFactory();
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(listableBeanFactory);
        beanDefinitionReader.loadBeanDefinitions(resource);
        // todo 断点处
        PeopleService peopleService = (PeopleService) listableBeanFactory.getBean("peopleServiceProxy");

        People people = new People();
        people.setUsername("lxcecho");
        people.setAge(110);

        peopleService.savePeople(people);

    }
}
