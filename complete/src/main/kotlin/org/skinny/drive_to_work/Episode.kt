package org.skinny.drive_to_work;

data class Episode (val id: Int, val title: String,
                    val description: String, val url: String) {
    private constructor() : this(0, "", "", "")
}
