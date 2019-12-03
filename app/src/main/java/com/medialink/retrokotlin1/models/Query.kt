package com.medialink.retrokotlin1.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Query(

	@field:SerializedName("search")
	val search: List<SearchItem?>? = null,

	@field:SerializedName("searchinfo")
	val searchinfo: Searchinfo? = null
) : Parcelable