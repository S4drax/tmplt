package com.sadrax.tmplt.infrastructure.config;

import com.sadrax.tmplt.domain.shared.model.QuartzSharedJob;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

import java.text.ParseException;
import java.util.List;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class QuartzConfig {

  private final List<QuartzSharedJob> sharedJobs;

  @Autowired
  private ApplicationContext applicationContext;

  @Bean
  public JobFactory jobFactory() {
    SpringBeanJobFactory jobFactory = new SpringBeanJobFactory();
    jobFactory.setApplicationContext(applicationContext);
    return jobFactory;
  }

  @Bean
  public SchedulerFactoryBean schedulerFactoryBean() {
    SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
    factoryBean.setJobFactory(jobFactory());
    factoryBean.setTriggers(createTriggers());
    return factoryBean;
  }

  private Trigger[] createTriggers() {
    return sharedJobs.stream()
        .map(this::createTrigger)
        .toArray(Trigger[]::new);
  }

  private CronTrigger createTrigger(QuartzSharedJob importerJob) {
    CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
    try {
      factoryBean.setJobDetail(createJobDetail(importerJob));
      factoryBean.setCronExpression(importerJob.getJobCronSchedule());
      factoryBean.setMisfireInstruction(SimpleTrigger.MISFIRE_INSTRUCTION_FIRE_NOW);
      factoryBean.setName(importerJob.getTriggerIdentity());
      factoryBean.afterPropertiesSet();
    } catch (ParseException e) {
      log.error("Error while parsing trigger: {}. {}", importerJob.getTriggerIdentity(), e.getMessage(), e);
    }
    return factoryBean.getObject();
  }

  private JobDetail createJobDetail(QuartzSharedJob importerJob) {
    JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
    factoryBean.setJobClass(importerJob.getClass());
    factoryBean.setDurability(true);
    factoryBean.setName(importerJob.getJobIdentity());
    factoryBean.afterPropertiesSet();
    return factoryBean.getObject();
  }
}


