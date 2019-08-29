package co.app.disys.Listview.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import co.app.disys.Listview.model.Item;
import co.app.disys.R;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.ItemViewHolder> {
    private List<Item> itemList = new ArrayList<>();
    private Context mContext;
    public ListViewAdapter(Context mContext,List<Item> itemList) {
        this.mContext = mContext;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.list_item,viewGroup,false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        Item item = itemList.get(i);
        Glide.with(mContext).load(item.getImage()).into(itemViewHolder.image);

        itemViewHolder.textTitle.setText(item.getTitle().substring(0,25)+"...");
        itemViewHolder.textDesc.setText(item.getDescription());
        itemViewHolder.textDate.setText(item.getDate());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView textTitle;
        TextView textDesc;
        ImageView image;
        TextView textDate;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.text_title);
            textDesc = itemView.findViewById(R.id.text_desc);
            image = itemView.findViewById(R.id.image_view);
            textDate = itemView.findViewById(R.id.text_date);
        }
    }
}
