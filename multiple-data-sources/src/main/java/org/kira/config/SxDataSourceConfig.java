package org.kira.config;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.MybatisXMLLanguageDriver;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author zhang chaoqing
 * @date 2023/8/1 13:37
 */

@Configuration
@MapperScan(basePackages = "org.kira.dao.sx", sqlSessionTemplateRef = "sxSqlSessionTemplate")
public class SxDataSourceConfig {


    @Bean(name = "sxDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.sx")
    public HikariDataSource sx() {
        return new HikariDataSource();
    }

    @Primary
    @Bean("sxSqlSessionFactory")
    public SqlSessionFactory psiSqlSessionFactory(@Qualifier("sxDataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);

        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        factoryBean.setConfiguration(configuration);
        //指定xml路径.
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/sx/*.xml"));
        //这里可以设置MetaObjectHandler
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setMetaObjectHandler(new MetaObjectHandler() {
            @Override
            public void insertFill(MetaObject metaObject) {

            }

            @Override
            public void updateFill(MetaObject metaObject) {

            }
        });
        factoryBean.setGlobalConfig(globalConfig);
        return factoryBean.getObject();
    }

    @Primary
    @Bean("sxSqlSessionTemplate")
    public SqlSessionTemplate psiSqlSessionTemplate(@Qualifier("sxSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        // 使用上面配置的Factory
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean("sxTransactionManager")
    @Primary
    // 数据源事务管理器
    public DataSourceTransactionManager mybootTransactionManager(@Qualifier("sxDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


}
