package zo.den.myapplication.adapter;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import zo.den.myapplication.R;
import zo.den.myapplication.pojo.Payload;

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private List<Payload> newsList;

    public NewsAdapter() {
        this.newsList = Collections.emptyList();
    }

    public void setNewsList(List<Payload> newsList) {
        this.newsList = newsList;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==0){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder0(v);}
        else {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item1, parent, false);
            return new ViewHolder1(v);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ViewHolder0){
            ViewHolder0 v0 = (ViewHolder0)viewHolder;
            v0.bind(newsList.get(i));
        }
        else if (viewHolder instanceof ViewHolder1){
            ViewHolder1 v1 = (ViewHolder1)viewHolder;
            v1.bind(newsList.get(i));
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position%2==0? 1 : 0;
    }


    @Override
    public int getItemCount() {
        if (newsList == null)
            return 0;
        return newsList.size();
    }

    class ViewHolder0 extends RecyclerView.ViewHolder {
        TextView text;
        TextView name;

        void bind(Payload payload){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                if (payload.getText()!=null)
                    text.setText(Html.fromHtml(payload.getText(), Html.FROM_HTML_MODE_LEGACY));
            } else {
                text.setText(Html.fromHtml(payload.getText()));
            }
            name.setText(payload.getName());
        }

        public ViewHolder0(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
            name = (TextView) itemView.findViewById(R.id.name);
        }
    }
    class ViewHolder1 extends RecyclerView.ViewHolder {
        TextView text;
        TextView name;

        void bind(Payload payload){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                if (payload.getText()!=null)
                    text.setText(Html.fromHtml(payload.getText(), Html.FROM_HTML_MODE_LEGACY));
            } else {
                text.setText(Html.fromHtml(payload.getText()));
            }
            name.setText(payload.getName());
        }

        public ViewHolder1(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
            name = (TextView) itemView.findViewById(R.id.name);
        }
    }
}
