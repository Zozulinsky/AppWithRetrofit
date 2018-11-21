package zo.den.myapplication.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import zo.den.myapplication.Controller;
import zo.den.myapplication.pojo.Payload;
import zo.den.myapplication.R;
import zo.den.myapplication.pojo.News;
import zo.den.myapplication.pojo.Title;
import zo.den.myapplication.service.NewsApi;

public class Fragment2 extends android.support.v4.app.Fragment{
    private NewsApi newsApi;
    String idNews;
    Payload payload;
    TextView title, publicationDate, content;

    public Fragment2() {
    }

    @SuppressLint("ValidFragment")
    public Fragment2(String idNews) {
        this.idNews = idNews;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fraginfo, container, false);
        title =(TextView) rootView.findViewById(R.id.titleInfo);
        publicationDate = rootView.findViewById(R.id.publicationDate);
        content = rootView.findViewById(R.id.contentNews);
        newsApi = Controller.getApi();
        Call<News> call = newsApi.getNewsById(idNews);
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                News news = response.body();
                payload = news.getPayload();
                content.setText(payload.getContent());

            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return rootView;
    }
}
