package com.mangooa.tools.core.lang;

import com.mangooa.tools.core.util.IdUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Weimin Gao
 * @since 1.0.0
 **/
public class ObjectIdTests {

	@Test
	public void testGet() {
		long s = System.currentTimeMillis();
		String id = IdUtils.objectId();
		long e = System.currentTimeMillis();
		System.out.println(e-s);
		assertAll("ObjectId.get()",
			() -> assertNotNull(id),
			() -> assertEquals(24, id.length())
		);
	}
}
