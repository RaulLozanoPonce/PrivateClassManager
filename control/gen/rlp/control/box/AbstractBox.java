package rlp.control.box;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import io.intino.alexandria.logger.Logger;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;

public abstract class AbstractBox extends io.intino.alexandria.core.Box {
	protected ControlConfiguration configuration;
	protected io.intino.alexandria.datalake.Datalake datalake;
	private io.intino.alexandria.scheduler.AlexandriaScheduler scheduler = new io.intino.alexandria.scheduler.AlexandriaScheduler();

	public AbstractBox(String[] args) {
		this(new ControlConfiguration(args));
	}

	public AbstractBox(ControlConfiguration configuration) {
		this.configuration = configuration;
		initJavaLogger();
		this.datalake = new io.intino.alexandria.datalake.file.FileDatalake(new java.io.File(configuration().get("datalake_path")));
	}

	public ControlConfiguration configuration() {
		return configuration;
	}

	@Override
	public io.intino.alexandria.core.Box put(Object o) {
		return this;
	}

	public abstract void beforeStart();

	public io.intino.alexandria.core.Box start() {
		if (owner != null) owner.beforeStart();
		beforeStart();
		if (owner != null) owner.start();
		initUI();
		initConnector();
		initRestServices();
		initSoapServices();
		initJmxServices();
		initDatalake();
		initTerminal();
		initMessagingServices();
		initSentinels();
		initSlackBots();
		initWorkflow();
		if (owner != null) owner.afterStart();
		afterStart();
		return this;
	}

	public abstract void afterStart();

	public abstract void beforeStop();

	public void stop() {
		if (owner != null) owner.beforeStop();
		beforeStop();
		if (owner != null) owner.stop();
		if (owner != null) owner.afterStop();
		afterStop();
	}

	public abstract void afterStop();

	public io.intino.alexandria.datalake.Datalake datalake() {
		return this.datalake;
	}

	public io.intino.alexandria.scheduler.AlexandriaScheduler scheduler() {
		return this.scheduler;
	}



	private void initRestServices() {

	}

	private void initSoapServices() {

	}

	private void initMessagingServices() {

	}

	private void initJmxServices() {

	}

	private void initSlackBots() {

	}

	private void initUI() {

	}

	private void initDatalake() {
	}

	private void initConnector() {
	}

	private void initTerminal() {
	}

	private void initSentinels() {
		Sentinels.init(this.scheduler, this.configuration.home(), (ControlBox) this);
	}

	private void initWorkflow() {
	}

	private void initJavaLogger() {
		final java.util.logging.Logger Logger = java.util.logging.Logger.getGlobal();
		final ConsoleHandler handler = new ConsoleHandler();
		handler.setLevel(Level.INFO);
		handler.setFormatter(new io.intino.alexandria.logger.Formatter());
		Logger.setUseParentHandlers(false);
		Logger.addHandler(handler);
	}

	protected java.net.URL url(String url) {
		try {
			return new java.net.URL(url);
		} catch (java.net.MalformedURLException e) {
			return null;
		}
	}
}