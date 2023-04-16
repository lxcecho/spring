package com.xc.joy;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lxcecho 909231497@qq.com
 * @since 03.05.2022
 */
@RunWith(MockitoJUnitRunner.class)
public class SimpleSpringApplicationTest {
	/*@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Rule
	public MockitoRule initRule = MockitoJUnit.rule();*/

	@Test
	public void whenNotUseMockAnnotationThenCorrect() {
		List list = Mockito.mock(ArrayList.class);

		list.add("one");
		Mockito.verify(list.add("one"));
		Assert.assertEquals(0, list.size());

		Mockito.when(list.size()).thenReturn(100);
		Assert.assertEquals(100, list.size());
	}
}
