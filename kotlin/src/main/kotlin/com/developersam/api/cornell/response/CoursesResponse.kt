package com.developersam.api.cornell.response

import com.developersam.api.cornell.data.Course

/**
 * [CoursesResponse] is the response of a Classes request.
 */
internal class CoursesResponse private constructor() {

    /**
     * Main data of response.
     */
    private val data: Data? = null
    /**
     * Obtain the academic groups information.
     */
    val courses: List<Course>?
        get() = data?.courses

    /**
     * [Data] is an uninteresting class that just holds an array of [Course].
     */
    private inner class Data private constructor() {
        val courses: List<Course>? = null
    }

}