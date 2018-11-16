package zo.den.myapplication;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>  {

    private List<Payload> newsList;

    public NewsAdapter(List<Payload> news) {
        this.newsList = news;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Payload news = newsList.get(position);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            if (news.getText()!=null)
            holder.text.setText(Html.fromHtml(news.getText(), Html.FROM_HTML_MODE_LEGACY));
        } else {
            holder.text.setText(Html.fromHtml(news.getText()));
        }
        holder.name.setText(news.getName());
    }

    @Override
    public int getItemCount() {
        if (newsList == null)
            return 0;
        return newsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
            name = (TextView) itemView.findViewById(R.id.name);
        }
    }
}
