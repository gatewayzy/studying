package com.bebetter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 若maven将junit设置为test阶段，只能在test包中使用junit
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    /**
     * Test注解会先加载Springboot的微服务，包括@bean等提供的bean。再运行Test注解。
     */
    @Test
    public void contextLoads() {
        System.out.println("\n==========================================");
        System.out.println("Test注解会先加载Springboot的微服务，包括@bean等提供的bean。再运行Test注解");
		assert 1==1;
        System.out.println("【@Test测试完毕】\n");
    }

}
