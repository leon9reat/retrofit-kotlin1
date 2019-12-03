package com.medialink.retrokotlin1.networks

import com.medialink.retrokotlin1.models.WikiRespon
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiWiki {
    @GET("api.php")
    fun getWikiSearch(@Query("action") action: String,
                      @Query("format") format: String,
                      @Query("list") list: String,
                      @Query("srsearch") srsearch: String): Observable<WikiRespon>
}