package zo.den.myapplication.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import zo.den.myapplication.Controller;
import zo.den.myapplication.R;
import zo.den.myapplication.adapter.NewsAdapter;
import zo.den.myapplication.pojo.News;
import zo.den.myapplication.pojo.Payload;
import zo.den.myapplication.service.NewsApi;

public class Fragment1 extends android.support.v4.app.Fragment {

    RecyclerView recyclerView;
    List<Payload> newsList;
    private NewsApi newsApi;
    NewsAdapter adapter = new NewsAdapter(this);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment, container, false);

        newsList = new ArrayList<>();
        recyclerView = (RecyclerView) rootView.findViewById(R.id.posts_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        newsApi = Controller.getApi();
        Call<News> call = newsApi.getNews();
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                News news = response.body();
                for (int i = 0; i < news.getPayloadList().size(); i++) {
                    newsList.add(news.getPayloadList().get(i));

                }
                adapter.setNewsList(newsList);
            }
            @Override
            public void onFailure(Call <News > call, Throwable t) {
                Log.i("TAG", "ERROR");
                t.printStackTrace();
            }
        });
        isStateSaved();
        return rootView;
    }

    public interface OnTouchListener{
        //TODO
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }




}
