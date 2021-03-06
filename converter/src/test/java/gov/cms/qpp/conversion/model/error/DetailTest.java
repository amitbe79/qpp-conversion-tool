package gov.cms.qpp.conversion.model.error;


import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;

import static com.google.common.truth.Truth.assertWithMessage;

public class DetailTest {
	@Test
	public void stringRepresentation() {
		Detail objectUnderTest = new Detail("text", "path");

		assertWithMessage("toString representation")
				.that(objectUnderTest.toString())
				.isEqualTo("Detail{message='text', path='path', value='null', type='null'}");
	}

	@Test
	public void stringRepresentationWithValueAndType() {
		Detail objectUnderTest = new Detail("text", "path", "value", "type");

		assertWithMessage("toString representation")
				.that(objectUnderTest.toString())
				.isEqualTo("Detail{message='text', path='path', value='value', type='type'}");
	}

	@Test
	public void equalsContract() {
		EqualsVerifier.forClass(Detail.class).usingGetClass().suppress(Warning.NONFINAL_FIELDS).verify();
	}
}