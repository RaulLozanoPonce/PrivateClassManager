package rlp.control.box.scheduling;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import rlp.control.box.ControlBox;
import io.intino.alexandria.scheduler.ScheduledTrigger;

public class PendingEventCheckerListener implements ScheduledTrigger {

	public void execute(JobExecutionContext context) throws JobExecutionException {
		ControlBox box = (ControlBox) context.getMergedJobDataMap().get("box");
		rlp.control.box.actions.PendingEventCheckerAction action = new rlp.control.box.actions.PendingEventCheckerAction();
		action.box = box;
		action.execute();
	}
}