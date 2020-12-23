package rlp.control.box;

import java.util.Map;
import java.util.HashMap;

public class ControlConfiguration extends io.intino.alexandria.core.BoxConfiguration {

	public ControlConfiguration(String[] args) {
		super(args);
	}

	public String datalakePath() {
		return get("datalake_path");
	}

	public String port() {
		return get("port");
	}
}