package com.medialink.retrokotlin1.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class JsonMemberContinue(

	@field:SerializedName("sroffset")
	val sroffset: Int? = null,

	@field:SerializedName("continue")
	val jsonMemberContinue: String? = null
): Parcelable