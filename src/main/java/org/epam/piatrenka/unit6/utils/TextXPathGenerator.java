package org.epam.piatrenka.unit6.utils;

public class TextXPathGenerator {

	private String firstPatr = ".//*[text()='";
	private String lastPart = "']";
	private String variablePart;

	public void setVariablePart(String outterXpath) {
		variablePart = outterXpath;

	}

	public String getFullPath() {
		return firstPatr + variablePart + lastPart;

	}
}
