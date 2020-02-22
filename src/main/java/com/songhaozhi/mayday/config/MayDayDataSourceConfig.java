package com.songhaozhi.mayday.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.songhaozhi.mayday.annotation.MyBatisDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Auther: xuyang
 * @Date: 2019/10/5 09:22
 * @Description:
 */
@Slf4j
@Configuration
@MapperScan(value = "com.songhaozhi.mayday.mapper.mayDay",
        annotationClass = MyBatisDao.class,
        sqlSessionFactoryRef = "mayDayConfigSqlSessionFactory")
public class MayDayDataSourceConfig {

    private String url = "jdbc:mysql://127.0.0.1:3306/maydaytest?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";

    private String userName = "root";

    private String password = "1234qwer";

    private String driverClass = "com.mysql.cj.jdbc.Driver";

    private String mapperLocations = "classpath:/mapper/mayDay/*/*.xml";

    private String configLocation = "classpath:/mapper/mayDay/mybatis-config.xml";

    /**
     * 数据源：work
     * @return
     */
    @Bean(name = "mayDayDataSource")
    public DataSource primaryDataSource() {
        log.info("连接数据库");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;
    }

    /**
     * 指定mybatis中的xml路径
     * @param workDataSource
     * @return
     * @throws Exception
     */
    @Bean(name = "mayDayConfigSqlSessionFactory")
    public SqlSessionFactory mybatisSqlSessionFactory(
            @Qualifier("mayDayDataSource") DataSource workDataSource)
            throws Exception {
        log.info("spring和mybatis的整合，配置主从mapper");
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(workDataSource);
        //主mapper位置
        sessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver()
                .getResource(configLocation));
        //从mapper位置
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(mapperLocations));
        return sessionFactory.getObject();
    }

    /**
     * 事务管理：work
     * @param dataSource
     * @return
     */
    @Bean(name = "mayDayTransactional")
    public DataSourceTransactionManager workTransactional(
            @Qualifier("mayDayDataSource") DataSource dataSource){
        log.info("配置事务管理");
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * sqlsessionTemplate：file
     * @param sqlSessionFactory
     * @return
     */
    @Bean(name = "mayDaySqlSessionTemplate")
    public SqlSessionTemplate workSqlSessionTemplate(
            @Qualifier("mayDayConfigSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
