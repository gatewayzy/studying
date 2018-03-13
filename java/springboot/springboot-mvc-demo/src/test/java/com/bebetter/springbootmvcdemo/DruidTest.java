package com.bebetter.springbootmvcdemo;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DruidTest {
    @Resource
    DruidDataSource druidDataSource;

    @Test
    public void testDruidDS() {
        Assert.assertNotNull(druidDataSource);
        System.out.println(druidDataSource.getActiveCount());
    }
    @Test
    public void testDataSourcePropertiesOverridden() throws Exception {
        assertThat(druidDataSource.getUrl()).isEqualTo("jdbc:h2:file:./demo-db");
        assertThat(druidDataSource.getInitialSize()).isEqualTo(2);
        assertThat(druidDataSource.getMaxActive()).isEqualTo(30);
        assertThat(druidDataSource.getMinIdle()).isEqualTo(2);
        assertThat(druidDataSource.getMaxWait()).isEqualTo(1234);
        assertThat(druidDataSource.isPoolPreparedStatements()).isTrue();
        //assertThat(druidDataSource.getMaxOpenPreparedStatements()).isEqualTo(5); //Duplicated with following
        assertThat(druidDataSource.getMaxPoolPreparedStatementPerConnectionSize()).isEqualTo(5);
        assertThat(druidDataSource.getValidationQuery()).isEqualTo("select 1");
        assertThat(druidDataSource.getValidationQueryTimeout()).isEqualTo(1);
        assertThat(druidDataSource.isTestWhileIdle()).isTrue();
        assertThat(druidDataSource.isTestOnBorrow()).isTrue();
        assertThat(druidDataSource.isTestOnReturn()).isTrue();
        assertThat(druidDataSource.getTimeBetweenEvictionRunsMillis()).isEqualTo(10000);
        assertThat(druidDataSource.getMinEvictableIdleTimeMillis()).isEqualTo(30001);
        assertThat(druidDataSource.isAsyncCloseConnectionEnable()).isEqualTo(true);
    }
}
