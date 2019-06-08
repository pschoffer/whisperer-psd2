package com.techsylvania.klarnauts.whisperer.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "postgresEntityManagerFactory",
    transactionManagerRef = "postgresTransactionManager",
    basePackages = {"com.techsylvania.klarnauts.whisperer.data.repo"})
// @PropertySource("classpath:postgresql-${spring.profiles.active}.properties")
// @ConditionalOnProperty("db.postgres.enabled")
public class PostgresDbConfig {

  private static final Logger LOGGER = LogManager.getLogger(PostgresDbConfig.class);

  @Autowired private Environment environment;

  @Primary
  @Bean(name = "postgresDataSource")
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource dataSource() {
    LOGGER.debug("Creating DataSource bean called postgresDataSource");
    return DataSourceBuilder.create()
        .driverClassName("org.postgresql.Driver")
        .url("jdbc:postgresql://localhost:5432/psd2")
        .username("psd2")
        .password("psd2")
        .build();
  }

  @Primary
  @Bean(name = "postgresEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(
      EntityManagerFactoryBuilder builder, @Qualifier("postgresDataSource") DataSource dataSource) {
    return builder
        .dataSource(dataSource)
        .packages("com.techsylvania.klarnauts.whisperer.data.domain")
        .persistenceUnit("postgresqldb")
        .properties(jpaProperties())
        .build();
  }

  @Primary
  @Bean(name = "postgresTransactionManager")
  public PlatformTransactionManager transactionManager(
      @Qualifier("postgresEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
    return new JpaTransactionManager(entityManagerFactory);
  }

  private Map<String, String> jpaProperties() {
    Map<String, String> jpaProperties = new HashMap<>();

    jpaProperties.put("hibernate.hbm2ddl.auto", "none");
    jpaProperties.put("hibernate.show_sql", "true");
    jpaProperties.put("hibernate.format_sql", "true");
    jpaProperties.put("hibernate.default_schema", "public");

    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("Creating jpaProperties...");
      jpaProperties.forEach(
          (key, value) -> LOGGER.debug("Property Key: {}, Value: {}", key, value));
    }

    return jpaProperties;
  }
}
