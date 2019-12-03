package com.medialink.retrokotlin1.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Searchinfo(

	@field:SerializedName("totalhits")
	val totalhits: Int? = null
): Parcelable