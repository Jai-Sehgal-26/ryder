package com.example.ryderr.ui.main.studentHome.live;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ryderr.R;
import com.example.ryderr.models.Cab;

import java.util.Collections;
import java.util.List;

public class LiveCabListAdapter extends RecyclerView.Adapter<LiveCabViewHolder> {

    List<Cab> list = Collections.emptyList();
    Context context;

    public LiveCabListAdapter(List<Cab> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public LiveCabViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.live_cab_card, parent, false);
        LiveCabViewHolder viewHolder = new LiveCabViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(LiveCabViewHolder holder, int position) {

        final int index = holder.getAdapterPosition();
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(
            RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
