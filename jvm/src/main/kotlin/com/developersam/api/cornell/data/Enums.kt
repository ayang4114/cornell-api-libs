package com.developersam.api.cornell.data

/**
 * A simple [Bool] enum for Cornell APIs.
 */
enum class Bool {
    Y, N;

    /**
     * [toBoolean] converts the [Bool] value to a boolean.
     */
    fun toBoolean() = when (this) {
        Y -> true
        N -> false
    }
}

/**
 * [AcademicCareerValue] is a collection of supported academic career value.
 *
 * @param description a simple description of the code.
 */
enum class AcademicCareerValue(val description: String) {
    UG("Undergraduate"), GR("Graduate"), GM("Graduate Management"),
    LA("Law"), VM("Veterinary Medicine")
}

/**
 * [AcademicGroupValue] is a collection of supported academic group value.
 *
 * @param description a simple description of the code.
 */
enum class AcademicGroupValue(val description: String) {
    AG("Agriculture and Life Sciences"), AR("Architecture, Art and Planning"),
    AS("Arts and Sciences"), AT("Athletics"), BU("Business"),
    CT("Cornell Tech"), EN("Engineering"), GR("Graduate"),
    HE("Human Ecology"), IL("Industrial and Labor Relations"),
    LA("Law"), OT("Reserve Officer Training"), VM("Veterinary Medicine")
}
