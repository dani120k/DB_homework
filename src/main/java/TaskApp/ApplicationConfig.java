package TaskApp;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import java.util.Properties;

@Configuration
public class ApplicationConfig {
    @Bean
    public JpaTransactionManager jpaTransactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){
        return jpaTransactionManager();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(dataSource());
        localContainerEntityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        localContainerEntityManagerFactoryBean.setJpaProperties(properties);
        localContainerEntityManagerFactoryBean.setPackagesToScan("TaskApp.model");
        return  localContainerEntityManagerFactoryBean;
    }

    @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName("org.postgresql.Driver");
        source.setUrl("jdbc:postgresql://localhost:5432/task_manager");
        source.setUsername("admin");
        source.setPassword("password");
        return source;

    }
}
