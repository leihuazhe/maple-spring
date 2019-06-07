package com.hzways.spring.pvs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author maple 2018.09.10 下午10:27
 */
public class Manager {
    private String name;

    private String gender;
    private int age;

    @Autowired
    @Qualifier("money1")
    private Money money;

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public Manager() {
        System.out.println("Manager");
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", money=" + money.getMoney() +
                '}';
    }
}
