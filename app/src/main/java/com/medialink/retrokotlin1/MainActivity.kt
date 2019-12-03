package com.medialink.retrokotlin1

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.medialink.retrokotlin1.models.SearchItem
import com.medialink.retrokotlin1.models.WikiRespon
import com.medialink.retrokotlin1.networks.ApiFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var disposable: Disposable? = null
    private lateinit var mainAdapter: MainAdapter

    private val wikiApiService by lazy { ApiFactory.apiWiki }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_search.setOnClickListener {
            if (edt_search.text.toString().isNotEmpty()) {
                beginSearch(edt_search.text.toString().trim())
            }
        }

        mainAdapter = MainAdapter(this)
        rv_search_item.setHasFixedSize(true)
        rv_search_item.layoutManager = LinearLayoutManager(this)
        rv_search_item.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))
        rv_search_item.adapter = mainAdapter
    }

    private fun beginSearch(searchText: String) {
        disposable = wikiApiService.getWikiSearch(
            "query", "json",
            "search", searchText
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::testOk, this::testError)
    }

    private fun testOk(respon: WikiRespon) {
        txt_search_result.text = "${respon.query?.searchinfo?.totalhits} result found"
        mainAdapter.setData(respon.query?.search as List<SearchItem>)
    }

    private fun testError(error: Throwable) {
        Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }
}
