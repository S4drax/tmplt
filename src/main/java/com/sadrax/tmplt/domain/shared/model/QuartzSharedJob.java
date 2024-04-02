package com.sadrax.tmplt.domain.shared.model;

import org.quartz.Job;

public interface QuartzSharedJob extends Job {
  String getJobIdentity();

  String getJobCronSchedule();

  String getDescription();

  default String getTriggerIdentity() {
    return getJobIdentity() + "-trigger";
  }
}
