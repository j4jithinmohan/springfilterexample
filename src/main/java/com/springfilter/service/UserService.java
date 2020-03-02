package com.springfilter.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class UserService {

	private String projectName;

	/**
	 * Bean constructor, property initialization
	 */
	public UserService() {
		System.out.println("Bean constructing... Property initialization...");
		this.projectName = "Spring Filter Demo";
	}

	/**
	 * some logic before ready to use
	 */
	@PostConstruct
	public void initUserService() {
		System.out.println("Before ready to use...");
		System.out.println("Project Name : " + this.projectName);
		System.out.println("Now it is ready to use...");
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * Remove bean from container
	 */
	@PreDestroy
	public void destroyUserService() {
		System.out.println("Removing UserService bean from the IOC container/context");
	}
}
