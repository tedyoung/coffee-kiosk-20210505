package com.welltestedlearning.coffeekiosk;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class Startup implements CommandLineRunner {

  private final ApplicationContext applicationContext;

  public Startup(ApplicationContext applicationContext) {
    this.applicationContext = applicationContext;
  }

  @Override
  public void run(String... args) throws Exception {
    BeanDefinitionRegistry beanDefinitionRegistry = (BeanDefinitionRegistry) this.applicationContext;
    String[] beans = applicationContext.getBeanDefinitionNames();
    Arrays.sort(beans);
    for (String bean : beans) {
      System.out.println("Bean name: " + bean);
      BeanDefinition beanDefinition = beanDefinitionRegistry.getBeanDefinition(bean);
      if (beanDefinition.getBeanClassName() != null) {
        if (beanDefinition.getBeanClassName().startsWith("com.welltestedlearning")) {
          System.out.println("  --> Class name: " + beanDefinition.getBeanClassName() + ", scope: " + beanDefinition.getScope());
        }
      }
    }
  }

}
