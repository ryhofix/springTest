package pl.mr.springTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTestApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println(02777 & 07777);
		System.out.println(0777 & 07777);
		System.out.println(02777);
	}

}
