package com.lgk.myspringboot.config;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.jdbctemplate.JdbcTemplateLockProvider;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

@EnableSchedulerLock(defaultLockAtMostFor = "10m")
@Configuration
public class ShedLockConfig {
	
	@Resource
	private DataSource dataSource;
	
	@Bean
	public LockProvider lockProvider() {
		return new JdbcTemplateLockProvider(dataSource);
	}
}
