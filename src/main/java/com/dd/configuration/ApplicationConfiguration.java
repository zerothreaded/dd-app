package com.dd.configuration;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class ApplicationConfiguration extends Configuration  {

	@NotEmpty
	@JsonProperty
	private String dataFolder = "\\sandbox\\data";
	
	public String getDataFolder() {
		return dataFolder;
	}

}
