package com.songhaozhi.mayday.model.domain;

import java.io.Serializable;

public class Options implements Serializable {
	private static final long serialVersionUID = 9106758767364963417L;
	private String optionName;

	private String optionValue;

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName == null ? null : optionName.trim();
	}

	public String getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue == null ? null : optionValue.trim();
	}
}