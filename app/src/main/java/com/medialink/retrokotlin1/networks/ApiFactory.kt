package com.medialink.retrokotlin1.networks

import com.medialink.retrokotlin1.Const

object ApiFactory {
    val apiWiki: ApiWiki = RetrofitClient.retrofit(Const.WIKI_URL)
        .create(ApiWiki::class.java)
}