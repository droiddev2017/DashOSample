package com.example.dashosample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by Vinit Saxena on 11/06/20.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val COMMON_PSSH_UUID = UUID(0x1077EFECC0B24D02L, -0x531cc3e1ad1d04b5L)
        val CLEARKEY_UUID = UUID(-0x1d8e62a7567a4c37L, 0x781AB030AF78D30EL)
        val WIDEVINE_UUID = UUID(-0x121074568629b532L, -0x5c37d8232ae2de13L)
        val PLAYREADY_UUID = UUID(-0x65fb0f8667bfbd7aL, -0x546d19a41f77a06bL)*/


        val books = mutableListOf<BookmarksItem>()
        val book = BookmarksItem("dvfj")
        books.add(book)
        val bookmark = BookmarksApiResponse(books)
        tv.text = bookmark.toString()

        /* val id = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
             MediaDrm(WIDEVINE_UUID)
                     .getPropertyByteArray(MediaDrm.PROPERTY_DEVICE_UNIQUE_ID)
         } else {
             TODO("VERSION.SDK_INT < JELLY_BEAN_MR2")
         }

         Log.i("------> Media Id -> ", id.toString())

         val retrofit = Retrofit.Builder()
                 .baseUrl("http://api.base.com/")
                 .addConverterFactory(GsonConverterFactory.create())
                 .build()
         val service = retrofit.create(GitHubService::class.java)

         val a = mutableListOf<AnalyticsEventVod>()
         a.add(AnalyticsEventVod("1", "hello"))
         val call = service.listRepos(a)

         val b = mutableListOf<AnalyticsEventCatchUp>()
         b.add(AnalyticsEventCatchUp("1", "hello", "world"))
         val call1 = service.listRepos(b)
         call?.enqueue(object : Callback<List<String?>?> {
             override fun onFailure(call: Call<List<String?>?>, t: Throwable) {
                 Log.e("--->", "onFail")
             }

             override fun onResponse(call: Call<List<String?>?>, response: Response<List<String?>?>) {
                 Log.e("--->", "onResponse")
             }

         })
         call1?.enqueue(object : Callback<List<String?>?> {
             override fun onFailure(call: Call<List<String?>?>, t: Throwable) {
                 Log.e("--->", "1 onFail")
             }

             override fun onResponse(call: Call<List<String?>?>, response: Response<List<String?>?>) {
                 Log.e("--->", "1 onResponse")
             }

         })*/
    }
}

interface GitHubService {
    @POST("users")
    @JvmSuppressWildcards
    fun listRepos(@Body user: List<BaseAnalyticsEvent>?): Call<List<String?>?>?
}

interface BaseAnalyticsEvent {

    val serialNo: String

}

interface BaseAnalyticsLiveAndCatchUp {

    val callLetter: String

}

data class AnalyticsEventVod(
        override val serialNo: String,
        val titleId: String) : BaseAnalyticsEvent


data class AnalyticsEventCatchUp(
        override val serialNo: String,
        override val callLetter: String,
        val providerId: String
) : BaseAnalyticsEvent, BaseAnalyticsLiveAndCatchUp