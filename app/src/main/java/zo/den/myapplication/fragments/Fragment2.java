package zo.den.myapplication.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import zo.den.myapplication.Controller;
import zo.den.myapplication.R;
import zo.den.myapplication.pojo.CreationDate;
import zo.den.myapplication.pojo.News2;
import zo.den.myapplication.pojo.Payload;
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
        Call<News2> call = newsApi.getNewsById(idNews);
        call.enqueue(new Callback<News2>() {
            @Override
            public void onResponse(Call<News2> call, Response<News2> response) {
                News2 news = response.body();
                payload = news.getPayload();
                content.setText(android.text.Html.fromHtml(payload.getContent()).toString());
                Title titleObject = payload.getTitle();
                title.setText(titleObject.getText());
                CreationDate publicationDateObject = payload.getCreationDate();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/YYYY");
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(publicationDateObject.getMilliseconds());
                publicationDate.setText(formatter.format(calendar.getTime()).toString());
            }

            @Override
            public void onFailure(Call<News2> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return rootView;
    }
}
