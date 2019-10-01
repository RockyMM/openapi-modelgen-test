package com.modelgen.test;

import com.dto.test.ValidTakeoverProfiles;
import com.dto.test.ValidTakeoverProfilesProfiles;
import com.helper.XmlHelper;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class MarshallingTest {

	@Test
	public void testSimpleUnmarshalling() {

		// given
		ValidTakeoverProfiles underTest =
				new ValidTakeoverProfiles()
					.addProfilesItem(
							new ValidTakeoverProfilesProfiles()
								.profileName("abc")
					);

		// when
		String unmarshalledContent = XmlHelper.toXml(underTest);

		// then
		System.out.println(unmarshalledContent);
		assertThat(unmarshalledContent, containsString("<profileName>abc</profileName>"));
		assertThat(unmarshalledContent, not(containsString("<profileName>profileName</profileName>")));

	}
}