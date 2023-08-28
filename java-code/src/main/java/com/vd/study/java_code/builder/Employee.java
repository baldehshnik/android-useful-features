package com.vd.study.java_code.builder;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    public String firstname;
    public String lastname;
    public String patronymic;
    public Position position;
    public Double experience;
    public Address address;
    public List<Education> education;

    private Employee(
            String firstname, String lastname, String patronymic,
            Position position, Double experience, Address address,
            List<Education> education
    ) {
        if (firstname == null || firstname.isEmpty()) {
            throw new IllegalArgumentException("Expected employee firstname");
        }
        if (lastname == null || lastname.isEmpty()) {
            throw new IllegalArgumentException("Expected employee lastname");
        }
        if (position == null) {
            throw new IllegalArgumentException("Expected employee position");
        }
        if (experience == null) {
            throw new IllegalArgumentException("Expected employee experience");
        }
        if (education == null) {
            throw new IllegalArgumentException("Expected employee education");
        }

        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.position = position;
        this.experience = experience;
        this.address = address;
        this.education = education;
    }

    static class Builder {

        public String firstname;
        public String lastname;
        public String patronymic;
        public Position position;
        public Double experience;
        public Address address;
        public List<Education> education;

        public Builder setFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Builder setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Builder setPatronymic(String patronymic) {
            this.patronymic = patronymic;
            return this;
        }

        public Builder setPosition(Position position) {
            this.position = position;
            return this;
        }

        public Builder setExperience(Double experience) {
            this.experience = experience;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder setEducation(List<Education> education) {
            if (this.education == null) {
                this.education = education;
            } else {
                this.education.clear();
                this.education.addAll(education);
            }

            return this;
        }

        public Builder addEducation(Education education) {
            if (this.education == null) {
                this.education = new ArrayList<>();
                this.education.add(education);
            } else {
                this.education.add(education);
            }

            return this;
        }

        public Employee build() {
            return new Employee(firstname, lastname, patronymic, position, experience, address, education);
        }
    }
}