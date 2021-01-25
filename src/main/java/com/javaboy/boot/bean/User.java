package com.javaboy.boot.bean;

import lombok.*;

/**
 * @author liuchen
 * @date 2021/1/25
 */
@Data
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class User {

    private String name;
    private Integer age;
    private Pet pet;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
