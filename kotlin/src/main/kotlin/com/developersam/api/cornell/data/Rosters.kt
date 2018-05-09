package com.developersam.api.cornell.data

import com.google.gson.annotations.SerializedName

/**
 * [RostersResponse] is the response of a Rosters request.
 */
internal class RostersResponse private constructor() {

    /**
     * Main data of response.
     */
    private val data: Data? = null
    /**
     * Obtain the rosters information.
     */
    val rosters: List<Roster>?
        get() = data?.rosters

    /**
     * [Data] is an uninteresting class that just holds an array of [Roster].
     */
    private inner class Data private constructor() {
        val rosters: List<Roster>? = null
    }

}

/**
 * [Roster] contains all the useful information about Cornell Roster.
 *
 * @param semester semester of the roster.
 * @param isDefaultRoster whether the roster is the default one.
 * @param semesterCode code of the semester.
 * @param description a description of the semester.
 * @param shortDescription a short description of the semester.
 * @param defaultSessionCode the default session code.
 * @param defaultCampus the default campus.
 * @param defaultLocation the default location.
 * @param sharing whether you can share.
 * @param isInArchiveMode whether the semester's info is in archive move.
 * @param lastModifiedDatetime a datetime stamp of the last modified date time.
 */
data class Roster(
        @SerializedName(value = "slug") val semester: String,
        val isDefaultRoster: Bool,
        @SerializedName(value = "strm") val semesterCode: String,
        @SerializedName(value = "descr") val description: String,
        @SerializedName(value = "descrshort") val shortDescription: String,
        val defaultSessionCode: String,
        val defaultCampus: Campus,
        val defaultLocation: CampusLocation,
        val sharing: Bool,
        @SerializedName(value = "archiveMode") val isInArchiveMode: Bool,
        @SerializedName(value = "lastModifiedDttm") val lastModifiedDatetime: String
)
