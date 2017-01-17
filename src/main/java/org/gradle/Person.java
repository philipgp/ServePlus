package org.gradle;

import org.apache.commons.collections.list.GrowthList;

public class Person {
    private  String name;
    private Integer age;
public Person(){
	
}
    public Person(String name) {
        this.name = name;
        new GrowthList();
    }

    public String getName() {
        return name;
    }

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
