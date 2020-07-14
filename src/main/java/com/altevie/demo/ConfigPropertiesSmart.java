package com.altevie.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "smart")
public class ConfigPropertiesSmart {

	static String outputPath;
	static String invioPath;
	static String modificaPath;
	static String annullaPath;
	static String sourceFile;
	
	public String getOutputPath() {
		return outputPath;
	}
	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
	}
	public String getInvioPath() {
		return invioPath;
	}
	public void setInvioPath(String invioPath) {
		this.invioPath = invioPath;
	}
	public String getModificaPath() {
		return modificaPath;
	}
	public void setModificaPath(String modificaPath) {
		this.modificaPath = modificaPath;
	}
	public String getAnnullaPath() {
		return annullaPath;
	}
	public void setAnnullaPath(String annullaPath) {
		this.annullaPath = annullaPath;
	}
	public String getSourceFile() {
		return sourceFile;
	}
	public void setSourceFile(String sourceFile) {
		ConfigPropertiesSmart.sourceFile = sourceFile;
	}

	
}
