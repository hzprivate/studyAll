package com.springboot.springbootehcache.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@MapperScan(basePackages = "com.springboot.springbootehcache.dao")
public class MybatisConfig {
    @Autowired
    private Environment environment;


    /**
     * durid日志后台
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/durid/*");
//        //设置IP白名单
//        servletRegistrationBean.addInitParameter("allow","127.0.0.1");
//        //设置IP黑名单，deny优先于allow
//        servletRegistrationBean.addInitParameter("deny","150.0.4.1");
        //登陆账号
        servletRegistrationBean.addInitParameter("loginUsername","durid");
        servletRegistrationBean.addInitParameter("loginPassword","123456");
        //是否可以重置数据
        servletRegistrationBean.addInitParameter("resetEnable","false");
        return servletRegistrationBean;
    }

    /**
     * durid过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean statFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //设置过滤器路径
        filterRegistrationBean.addUrlPatterns("/*");
        //忽略过滤的形式
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

    /**
     * 获取数据源DataSource
     * @return
     */
    @Bean
    public DataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(environment.getProperty("spring.datasource.url"));
        druidDataSource.setUsername(environment.getProperty("spring.datasource.username"));
        druidDataSource.setPassword(environment.getProperty("spring.datasource.password"));
        druidDataSource.setDriverClassName(environment.getProperty("spring.datasource.driverClassName"));
        druidDataSource.setMaxActive(Integer.parseInt(environment.getProperty("spring.datasource.maxActive")));
        druidDataSource.setInitialSize(Integer.parseInt(environment.getProperty("spring.datasource.initialSize")));
        druidDataSource.setMaxWait(Long.parseLong(environment.getProperty("spring.datasource.maxWait")));
        druidDataSource.setMinIdle(Integer.parseInt(environment.getProperty("spring.datasource.minIdle")));
        druidDataSource.setTimeBetweenEvictionRunsMillis(Long.parseLong(environment.getProperty("spring.datasource.timeBetweenEvictionRunsMillis")));
        druidDataSource.setMinEvictableIdleTimeMillis(Long.parseLong(environment.getProperty("spring.datasource.minEvictableIdleTimeMillis")));
        druidDataSource.setValidationQuery(environment.getProperty("spring.datasource.validationQuery"));
        druidDataSource.setTestWhileIdle(Boolean.parseBoolean(environment.getProperty("spring.datasource.testWhileIdle")));
        druidDataSource.setTestOnBorrow(Boolean.parseBoolean(environment.getProperty("spring.datasource.testOnBorrow")));
        druidDataSource.setTestOnReturn(Boolean.parseBoolean(environment.getProperty("spring.datasource.testOnReturn")));
        druidDataSource.setPoolPreparedStatements(Boolean.parseBoolean(environment.getProperty("spring.datasource.poolPreparedStatements")));
        druidDataSource.setMaxOpenPreparedStatements(Integer.parseInt(environment.getProperty("spring.datasource.maxOpenPreparedStatements")));
        try {
            druidDataSource.setFilters(environment.getProperty("spring.datasource.filters"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return druidDataSource;
    }

    /**
     * 获取sqlSessionFactory
     * @param druidDataSource
     * @return
     */
    @Bean(name="sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(DataSource druidDataSource){
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(druidDataSource);
        bean.setTypeAliasesPackage(environment.getProperty("mybatis.typeAliasesPackage"));

//        LogFactory.useLog4JLogging();    //日志文件报错
        //添加XML目录
//        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        String xmlPath = environment.getProperty("mybatis.mapperLocations");
        try {
//            bean.setMapperLocations(resolver.getResources(xmlPath));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param sqlSessionFactory
     * @return
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * 增加事务
     * @param druidDataSource
     * @return
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource druidDataSource) {
        return new DataSourceTransactionManager(druidDataSource);
    }
}
