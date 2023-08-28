package com.vd.study.kotlin_code.builder

import org.junit.Assert.assertEquals
import org.junit.Assert.assertSame
import org.junit.Assert.assertTrue
import org.junit.Test

class BuilderTest {

    @Test
    fun employeeCreation_AfterEmployeeCreationUsingBuilderOnlyWithImportantFields_ReturnCorrectEmployeeObject() {
        val position = Position("Position name", 2.2)
        val education = Education("Place", "Profession", 1.1)
        val builder = Employee.Builder()
            .setFirstname("Firstname")
            .setLastname("Lastname")
            .setPosition(position)
            .setExperience(5.4)
            .setEducation(listOf(education))

        val employee = builder.build()

        assertEquals("Firstname", employee.firstname)
        assertEquals("Lastname", employee.lastname)
        assertEquals(null, employee.patronymic)
        assertSame(position, employee.position)
        assertTrue(5.4 == employee.experience)
        assertSame(null, employee.address)
        assertEquals(1, employee.education.size)
        assertSame(education, employee.education[0])
    }

    @Test
    fun employeeCreation_AfterEmployeeCreationUsingBuilderAndSecondSetEducationFunctionInvoke_ReturnCorrectEducation() {
        val position = Position("Position name", 2.2)
        val address = Address("Area", "Street", "House number")
        val education1 = Education("Place1", "Profession1", 1.1)
        val education2 = Education("Place2", "Profession2", 2.2)
        val builder = Employee.Builder()
            .setFirstname("Firstname")
            .setLastname("Lastname")
            .setPatronymic("Patronymic")
            .setPosition(position)
            .setExperience(5.4)
            .setAddress(address)
            .setEducation(listOf(education1))
            .setEducation(listOf(education2))

        val employee = builder.build()

        assertEquals(1, employee.education.size)
        assertSame(education2, employee.education[0])
    }

    @Test
    fun employeeCreation_AfterEmployeeCreationUsingBuilderAndAddEducationFunction_ReturnCorrectEducation() {
        val position = Position("Position name", 2.2)
        val address = Address("Area", "Street", "House number")
        val education1 = Education("Place1", "Profession1", 1.1)
        val education2 = Education("Place2", "Profession2", 2.2)
        val builder = Employee.Builder()
            .setFirstname("Firstname")
            .setLastname("Lastname")
            .setPatronymic("Patronymic")
            .setPosition(position)
            .setExperience(5.4)
            .setAddress(address)
            .addEducation(education1)
            .addEducation(education2)

        val employee = builder.build()

        assertEquals(2, employee.education.size)
        assertSame(education1, employee.education[0])
        assertSame(education2, employee.education[1])
    }

    @Test
    fun employeeCreation_AfterEmployeeCreationUsingBuilder_ReturnCorrectEmployeeObject() {
        val position = Position("Position name", 2.2)
        val address = Address("Area", "Street", "House number")
        val education = Education("Place", "Profession", 1.1)
        val builder = Employee.Builder()
            .setFirstname("Firstname")
            .setLastname("Lastname")
            .setPatronymic("Patronymic")
            .setPosition(position)
            .setExperience(5.4)
            .setAddress(address)
            .setEducation(listOf(education))

        val employee = builder.build()

        assertEquals("Firstname", employee.firstname)
        assertEquals("Lastname", employee.lastname)
        assertEquals("Patronymic", employee.patronymic)
        assertSame(position, employee.position)
        assertTrue(5.4 == employee.experience)
        assertSame(address, employee.address)
        assertEquals(1, employee.education.size)
        assertSame(education, employee.education[0])
    }

    @Test(expected = IllegalArgumentException::class)
    fun employeeCreation_AfterEmployeeCreationUsingBuilderWithoutFirstname_ThrowIllegalArgumentException() {
        val builder = Employee.Builder()
            .setLastname("Lastname")
            .setPatronymic("Patronymic")
            .setPosition(Position("Position name", 2.2))
            .setExperience(5.4)
            .setAddress(Address("Area", "Street", "House number"))
            .setEducation(listOf(Education("Place", "Profession", 1.1)))

        builder.build()
    }

    @Test(expected = IllegalArgumentException::class)
    fun employeeCreation_AfterEmployeeCreationUsingBuilderWithoutLastname_ThrowIllegalArgumentException() {
        val builder = Employee.Builder()
            .setFirstname("Firstname")
            .setPatronymic("Patronymic")
            .setPosition(Position("Position name", 2.2))
            .setExperience(5.4)
            .setAddress(Address("Area", "Street", "House number"))
            .setEducation(listOf(Education("Place", "Profession", 1.1)))

        builder.build()
    }

    @Test(expected = IllegalArgumentException::class)
    fun employeeCreation_AfterEmployeeCreationUsingBuilderWithoutPosition_ThrowIllegalArgumentException() {
        val builder = Employee.Builder()
            .setFirstname("Firstname")
            .setLastname("Lastname")
            .setPatronymic("Patronymic")
            .setExperience(5.4)
            .setAddress(Address("Area", "Street", "House number"))
            .setEducation(listOf(Education("Place", "Profession", 1.1)))

        builder.build()
    }

    @Test(expected = IllegalArgumentException::class)
    fun employeeCreation_AfterEmployeeCreationUsingBuilderWithoutExperience_ThrowIllegalArgumentException() {
        val builder = Employee.Builder()
            .setFirstname("Firstname")
            .setLastname("Lastname")
            .setPatronymic("Patronymic")
            .setPosition(Position("Position name", 2.2))
            .setAddress(Address("Area", "Street", "House number"))
            .setEducation(listOf(Education("Place", "Profession", 1.1)))

        builder.build()
    }

    @Test(expected = IllegalArgumentException::class)
    fun employeeCreation_AfterEmployeeCreationUsingBuilderWithoutEducation_ThrowIllegalArgumentException() {
        val builder = Employee.Builder()
            .setFirstname("Firstname")
            .setLastname("Lastname")
            .setPatronymic("Patronymic")
            .setPosition(Position("Position name", 2.2))
            .setExperience(5.4)
            .setAddress(Address("Area", "Street", "House number"))

        builder.build()
    }
}