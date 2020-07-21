package com.example.dashosample

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BookmarksApiResponse(

        @field:SerializedName("bookmarks")
        val bookmarks: List<BookmarksItem?>? = null
) : Parcelable

@Parcelize
data class BookmarksItem(

        @field:SerializedName("thumbnail")
        val thumbnail: String? = null,

        @field:SerializedName("time_seconds")
        val timeSeconds: Int? = null,

        @field:SerializedName("program_id")
        val programId: String? = null,

        @field:SerializedName("season_id")
        val seasonId: String? = null,

        @field:SerializedName("title")
        val title: String? = null,

        @field:SerializedName("type")
        val type: String? = null,

        @field:SerializedName("bookmark_type")
        val bookmarkType: String? = null,

        @field:SerializedName("is_adult")
        val isAdult: Boolean? = null,

        @field:SerializedName("cta")
        val cta: String? = null,

        @field:SerializedName("episode_number")
        val episodeNumber: String? = null,

        @field:SerializedName("content_type")
        val contentType: String? = null,

        @field:SerializedName("runtime_seconds")
        val runtimeSeconds: Int? = null,

        @field:SerializedName("ratings")
        val ratings: String? = null,

        @field:SerializedName("id")
        val id: String? = null
) : Parcelable
