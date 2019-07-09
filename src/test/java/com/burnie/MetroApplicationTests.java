package com.burnie;

import com.burnie.entity.Volume;
import com.burnie.mapper.MetroMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MetroApplicationTests {

	private MetroMapper metroMapper;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testSelect() {
		List<Volume> volumeList = metroMapper.selectList(null);
		Assert.assertEquals(2, volumeList.size());
		volumeList.forEach(System.out::println);
	}

}
