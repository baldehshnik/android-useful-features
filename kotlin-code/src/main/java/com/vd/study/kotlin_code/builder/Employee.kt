package com.vd.study.kotlin_code.builder

class Employee private constructor(
    firstname: String?,
    lastname: String?,
    patronymic: String?,
    position: Position?,
    experience: Double?,
    address: Address?,
    education: List<Education>?
) {

    val firstname: String
    val lastname: String
    val patronymic: String?
    val position: Position
    val experience: Double
    val address: Address?
    val education: List<Education>

    init {
        if (firstname.isNullOrBlank()) {
            throw IllegalArgumentException("Expected employee firstname")
        }
        if (lastname.isNullOrBlank()) {
            throw IllegalArgumentException("Expected employee lastname")
        }
        if (position == null) {
            throw IllegalArgumentException("Expected employee position")
        }
        if (experience == null) {
            throw IllegalArgumentException("Expected employee experience")
        }
        if (education == null) {
            throw IllegalArgumentException("Expected employee education")
        }

        this.firstname = firstname
        this.lastname = lastname
        this.patronymic = patronymic
        this.position = position
        this.experience = experience
        this.address = address
        this.education = education
    }

    class Builder {

        private var firstname: String? = null
        private var lastname: String? = null
        private var patronymic: String? = null
        private var position: Position? = null
        private var experience: Double? = null
        private var address: Address? = null
        private var education: MutableList<Education>? = null

        fun setFirstname(firstname: String): Builder {
            this.firstname = firstname
            return this
        }

        fun setLastname(lastname: String): Builder {
            this.lastname = lastname
            return this
        }

        fun setPatronymic(patronymic: String): Builder {
            this.patronymic = patronymic
            return this
        }

        fun setPosition(position: Position): Builder {
            this.position = position
            return this
        }

        fun setExperience(experience: Double): Builder {
            this.experience = experience
            return this
        }

        fun setAddress(address: Address): Builder {
            this.address = address
            return this
        }

        fun setEducation(education: List<Education>): Builder {
            if (this.education == null) {
                this.education = education.toMutableList()
            } else {
                this.education!!.clear()
                this.education!!.addAll(education)
            }

            return this
        }

        fun addEducation(education: Education): Builder {
            if (this.education == null) {
                this.education = mutableListOf(education)
            } else {
                this.education!!.add(education)
            }

            return this
        }

        fun build(): Employee {
            return Employee(
                firstname = firstname,
                lastname = lastname,
                patronymic = patronymic,
                position = position,
                experience = experience,
                address = address,
                education = education
            )
        }
    }
}