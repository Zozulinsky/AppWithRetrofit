package zo.den.myapplication.service;

import retrofit2.Call;
import retrofit2.http.GET;
import zo.den.myapplication.pojo.News;

public interface NewsApi {

    @GET("news")
    Call<News> getNews();
}
