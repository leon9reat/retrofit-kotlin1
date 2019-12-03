package com.medialink.retrokotlin1.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WikiRespon(

	@field:SerializedName("batchcomplete")
	val batchcomplete: String? = null,

	@field:SerializedName("continue")
	val jsonMemberContinue: JsonMemberContinue? = null,

	@field:SerializedName("query")
	val query: Query? = null
) : Parcelable