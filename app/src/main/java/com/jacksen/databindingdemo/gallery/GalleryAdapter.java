package com.jacksen.databindingdemo.gallery;


import android.content.Context;
import android.databinding.OnRebindCallback;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jacksen.databindingdemo.databinding.ItemGalleryBinding;

import java.util.List;

/**
 * Created by Admin on 2016/10/13.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {

    static Object DATA_INVALIDATION = new Object();

    private LayoutInflater layoutInflater;

    private RecyclerView recyclerView;

    private List<Pic> pics;

    private OnItemListener onItemListener;

    public void setOnItemListener(OnItemListener onItemListener) {
        this.onItemListener = onItemListener;
    }

    public GalleryAdapter(Context context, RecyclerView recyclerView, List<Pic> pics) {
        this.layoutInflater = LayoutInflater.from(context);
        this.recyclerView = recyclerView;
        this.pics = pics;
    }

    @Override
    public GalleryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final GalleryViewHolder holder = GalleryViewHolder.create(layoutInflater, parent);
        holder.getBinding().addOnRebindCallback(new OnRebindCallback() {
            @Override
            public boolean onPreBind(ViewDataBinding binding) {
                return recyclerView != null && recyclerView.isComputingLayout();
            }

            @Override
            public void onCanceled(ViewDataBinding binding) {
                if (recyclerView == null || recyclerView.isComputingLayout()) {
                    return;
                }
                int position = holder.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    notifyItemChanged(position, DATA_INVALIDATION);
                }
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(GalleryViewHolder holder, int position, List<Object> payloads) {
        if (isForDataBinding(payloads)) {
            holder.getBinding().executePendingBindings();
        } else {
            onBindViewHolder(holder, position);
        }
    }

    private boolean isForDataBinding(List<Object> payloads) {
        if (payloads == null || payloads.size() == 0) {
            return false;
        }
        for (Object obj : payloads) {
            if (obj != DATA_INVALIDATION) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void onBindViewHolder(final GalleryViewHolder holder, final int position) {
        holder.bindTo(pics.get(position));

        if (onItemListener != null) {
            holder.getBinding().getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemListener.onItemClick(holder.getBinding().picIv, position);
                }
            });
            holder.getBinding().getRoot().setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    onItemListener.onItemLongClick(position);
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return pics == null ? 0 : pics.size();
    }

    static class GalleryViewHolder extends RecyclerView.ViewHolder {

        static GalleryViewHolder create(LayoutInflater inflater, ViewGroup parent) {
            ItemGalleryBinding binding = ItemGalleryBinding.inflate(inflater, parent, false);
            return new GalleryViewHolder(binding);
        }

        private ItemGalleryBinding binding;

        public ItemGalleryBinding getBinding() {
            return binding;
        }

        public GalleryViewHolder(ItemGalleryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindTo(Pic pic) {
            binding.setPic(pic);
            binding.executePendingBindings();
        }

    }

}
