package org.codelogger.tutorial.jpa.repository;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author defei
 * @since 10/5/18.
 */
@EnableAutoConfiguration
@EnableJpaRepositories("org.codelogger.tutorial.jpa.repository")
@EntityScan("org.codelogger.tutorial.jpa.po")
@PropertySource("classpath:org/codelogger/tutorial/jpa/repository/application.properties")
@EnableTransactionManagement
public class CatRepositoryTestConfiguration {


}
