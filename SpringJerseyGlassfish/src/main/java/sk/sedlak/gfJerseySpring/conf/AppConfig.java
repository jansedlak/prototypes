package sk.sedlak.gfJerseySpring.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

/**
 * Created by jan.sedlak on 2/1/2016.
 */
@Configuration
@EnableTransactionManagement
public class AppConfig {

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.driver}")
    private String jdbcDriver;

    @Value("${jdbc.username}")
    private String jdbcUsername;

    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Value("${hibernate.dialect}")
    private String hibernateDialect;

    @Value("${hibernate.database.platform}")
    private String hibernateDatabasePlatform;

    @Value("${packages.to.scan}")
    private  String packagesToScan;

    @Bean
    LocalContainerEntityManagerFactoryBean getLocalContainerEntityManagerFactoryBean(){
      LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(getDriverManagerDataSource());
        localContainerEntityManagerFactoryBean.setPersistenceUnitName("persistenceUnit");
        localContainerEntityManagerFactoryBean.setPackagesToScan(packagesToScan);

        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setDatabasePlatform(hibernateDatabasePlatform);

        final Properties props = new Properties();
        props.setProperty("hibernate.dialect", hibernateDialect);
        localContainerEntityManagerFactoryBean.setJpaProperties(props);

        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(hibernateJpaVendorAdapter);

        return localContainerEntityManagerFactoryBean;
    }

    @Bean
    DriverManagerDataSource getDriverManagerDataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(jdbcDriver);
        driverManagerDataSource.setUrl(jdbcUrl);
        driverManagerDataSource.setUsername(jdbcUsername);
        driverManagerDataSource.setPassword(jdbcPassword);

        return driverManagerDataSource;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(getLocalContainerEntityManagerFactoryBean().getObject());
        return transactionManager;
    }
}
