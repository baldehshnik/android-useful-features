package com.vd.study.java_code.builder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class BuilderTest {

    @Test
    public void employeeCreation_AfterEmployeeCreationUsingBuilderOnlyWithImportantFields_ReturnCorrectEmployeeObject() {
        Position position = new Position("Position name", 2.2);
        Education education = new Education("Place", "Profession", 1.1);
        Employee.Builder builder = new Employee.Builder()
                .setFirstname("Firstname")
                .setLastname("Lastname")
                .setPosition(position)
                .setExperience(5.4)
                .setEducation(new ArrayList<>(Collections.singletonList(education)));

        Employee employee = builder.build();

        Assert.assertEquals("Firstname", employee.firstname);
        Assert.assertEquals("Lastname", employee.lastname);
        Assert.assertNull(employee.patronymic);
        Assert.assertSame(position, employee.position);
        Assert.assertEquals(5.4, employee.experience, 0.0);
        Assert.assertSame(null, employee.address);
        Assert.assertEquals(1, employee.education.size());
        Assert.assertSame(education, employee.education.get(0));
    }

    @Test
    public void employeeCreation_AfterEmployeeCreationUsingBuilderAndSecondSetEducationFunctionInvoke_ReturnCorrectEducation() {
        Position position = new Position("Position name", 2.2);
        Address address = new Address("Area", "Street", "House number");
        Education education1 = new Education("Place1", "Profession1", 1.1);
        Education education2 = new Education("Place2", "Profession2", 2.2);
        Employee.Builder builder = new Employee.Builder()
                .setFirstname("Firstname")
                .setLastname("Lastname")
                .setPatronymic("Patronymic")
                .setPosition(position)
                .setExperience(5.4)
                .setAddress(address)
                .setEducation(new ArrayList<>(Collections.singletonList(education1)))
                .setEducation(new ArrayList<>(Collections.singletonList(education2)));

        Employee employee = builder.build();

        Assert.assertEquals(1, employee.education.size());
        Assert.assertSame(education2, employee.education.get(0));
    }

    @Test
    public void employeeCreation_AfterEmployeeCreationUsingBuilderAndAddEducationFunction_ReturnCorrectEducation() {
        Position position = new Position("Position name", 2.2);
        Address address = new Address("Area", "Street", "House number");
        Education education1 = new Education("Place1", "Profession1", 1.1);
        Education education2 = new Education("Place2", "Profession2", 2.2);
        Employee.Builder builder = new Employee.Builder()
                .setFirstname("Firstname")
                .setLastname("Lastname")
                .setPatronymic("Patronymic")
                .setPosition(position)
                .setExperience(5.4)
                .setAddress(address)
                .addEducation(education1)
                .addEducation(education2);

        Employee employee = builder.build();

        Assert.assertEquals(2, employee.education.size());
        Assert.assertSame(education1, employee.education.get(0));
        Assert.assertSame(education2, employee.education.get(1));
    }

    @Test
    public void employeeCreation_AfterEmployeeCreationUsingBuilder_ReturnCorrectEmployeeObject() {
        Position position = new Position("Position name", 2.2);
        Address address = new Address("Area", "Street", "House number");
        Education education = new Education("Place", "Profession", 1.1);
        Employee.Builder builder = new Employee.Builder()
                .setFirstname("Firstname")
                .setLastname("Lastname")
                .setPatronymic("Patronymic")
                .setPosition(position)
                .setExperience(5.4)
                .setAddress(address)
                .setEducation(new ArrayList<>(Collections.singletonList(education)));

        Employee employee = builder.build();

        Assert.assertEquals("Firstname", employee.firstname);
        Assert.assertEquals("Lastname", employee.lastname);
        Assert.assertEquals("Patronymic", employee.patronymic);
        Assert.assertSame(position, employee.position);
        Assert.assertEquals(5.4, employee.experience, 0.0);
        Assert.assertSame(address, employee.address);
        Assert.assertEquals(1, employee.education.size());
        Assert.assertSame(education, employee.education.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void employeeCreation_AfterEmployeeCreationUsingBuilderWithoutFirstname_ThrowIllegalArgumentException() {
        Employee.Builder builder = new Employee.Builder()
                .setLastname("Lastname")
                .setPatronymic("Patronymic")
                .setPosition(new Position("Position name", 2.2))
                .setExperience(5.4)
                .setAddress(new Address("Area", "Street", "House number"))
                .setEducation(new ArrayList<>(Collections.singletonList(new Education("Place", "Profession", 1.1))));

        builder.build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void employeeCreation_AfterEmployeeCreationUsingBuilderWithoutLastname_ThrowIllegalArgumentException() {
        Employee.Builder builder = new Employee.Builder()
                .setFirstname("Firstname")
                .setPatronymic("Patronymic")
                .setPosition(new Position("Position name", 2.2))
                .setExperience(5.4)
                .setAddress(new Address("Area", "Street", "House number"))
                .setEducation(new ArrayList<>(Collections.singletonList(new Education("Place", "Profession", 1.1))));

        builder.build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void employeeCreation_AfterEmployeeCreationUsingBuilderWithoutPosition_ThrowIllegalArgumentException() {
        Employee.Builder builder = new Employee.Builder()
                .setFirstname("Firstname")
                .setLastname("Lastname")
                .setPatronymic("Patronymic")
                .setExperience(5.4)
                .setAddress(new Address("Area", "Street", "House number"))
                .setEducation(new ArrayList<>(Collections.singletonList(new Education("Place", "Profession", 1.1))));

        builder.build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void employeeCreation_AfterEmployeeCreationUsingBuilderWithoutExperience_ThrowIllegalArgumentException() {
        Employee.Builder builder = new Employee.Builder()
                .setFirstname("Firstname")
                .setLastname("Lastname")
                .setPatronymic("Patronymic")
                .setPosition(new Position("Position name", 2.2))
                .setAddress(new Address("Area", "Street", "House number"))
                .setEducation(new ArrayList<>(Collections.singletonList(new Education("Place", "Profession", 1.1))));

        builder.build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void employeeCreation_AfterEmployeeCreationUsingBuilderWithoutEducation_ThrowIllegalArgumentException() {
        Employee.Builder builder = new Employee.Builder()
                .setFirstname("Firstname")
                .setLastname("Lastname")
                .setPatronymic("Patronymic")
                .setPosition(new Position("Position name", 2.2))
                .setExperience(5.4)
                .setAddress(new Address("Area", "Street", "House number"));

        builder.build();
    }
}