package zo.den.myapplication.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;
import zo.den.myapplication.pojo.News;

public interface NewsApi {

    @GET("news")
    Call<News> getNews();

    @GET("news_content")
    Call<News> getNewsById(@Query("id") String id);
}
