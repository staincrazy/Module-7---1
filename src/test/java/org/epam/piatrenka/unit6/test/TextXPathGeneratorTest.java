package org.epam.piatrenka.unit6.test;

import org.epam.piatrenka.unit6.utils.TextXPathGenerator;
import org.testng.annotations.Test;

public class TextXPathGeneratorTest {
	
	@Test
	public void testMethod() {
		TextXPathGenerator tg = new TextXPathGenerator();
		tg.setVariablePart("what is the heck");
		String newText = tg.getFullPath();
		System.out.println(newText);
	}

}
