package com.medialink.retrokotlin1.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchItem(

	@field:SerializedName("snippet")
	val snippet: String? = null,

	@field:SerializedName("wordcount")
	val wordcount: Int? = null,

	@field:SerializedName("size")
	val size: Int? = null,

	@field:SerializedName("ns")
	val ns: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("pageid")
	val pageid: Int? = null,

	@field:SerializedName("timestamp")
	val timestamp: String? = null
): Parcelable