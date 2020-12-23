package rlp.control.box;

import rlp.control.box.ControlBox;
import io.intino.alexandria.scheduler.AlexandriaScheduler;
import rlp.control.box.actions.*;
import org.quartz.*;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.time.ZoneId;
import java.util.TimeZone;
import io.intino.alexandria.logger.Logger;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.CronScheduleBuilder.*;
import static org.quartz.TriggerBuilder.newTrigger;

public class Sentinels {

	private Sentinels() {

	}

	public static void init(AlexandriaScheduler scheduler, java.io.File home, ControlBox box) {
		JobDetail job;
		try {
			job = newJob(rlp.control.box.scheduling.PendingEventCheckerListener.class).withIdentity("PendingEventChecker").build();
			job.getJobDataMap().put("box", box);
			scheduler.scheduleJob(job, newSet(newTrigger().withIdentity("Datahub#PendingEventChecker").withSchedule(cronSchedule("0 0/1 * 1/1 * ? *").inTimeZone(TimeZone.getTimeZone(ZoneId.of("Atlantic/Canary")))).build(), newTrigger().startNow().build()), true);
			scheduler.startSchedules();
		} catch (Exception e) {
			Logger.error(e.getMessage());
		}
	}



	private static Set<Trigger> newSet(Trigger... triggers) {
		LinkedHashSet<Trigger> set = new LinkedHashSet<>();
		java.util.Collections.addAll(set, triggers);
		return set;
	}
}