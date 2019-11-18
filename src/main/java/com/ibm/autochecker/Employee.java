package com.ibm.autochecker;

class Employee {
    private final int id;
    private final String name;
    private final int age;
    private final String address;
    private final float salary;

    Employee(
            final int id,
            final String name,
            final int age,
            final String address,
            final float salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.salary = salary;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    String getAddress() {
        return address;
    }

    float getSalary() {
        return salary;
    }
}



