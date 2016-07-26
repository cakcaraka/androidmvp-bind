package org.greenfroyo.baseapp_mvp_bind.view.recyclerview;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import org.greenfroyo.baseapp_mvp_bind.BR;

import java.util.List;

/**
 * Created by fchristysen on 6/24/16.
 */

public abstract class BindAdapter<T, B extends ViewDataBinding> extends RecyclerView.Adapter<BindAdapter.BindViewHolder<B>>{
    private Context mContext;
    private List<T> mDataSet;
    private OnRecyclerItemClickListener<T> mListener;

    public BindAdapter(Context context) {
        this.mContext = context;
    }

    public Context getContext(){
        return mContext;
    }

    @Override
    public int getItemCount() {
        return mDataSet != null ? mDataSet.size() : 0;
    }

    public void setDataSet(List<T> dataSet){
        mDataSet = dataSet;
        notifyDataSetChanged();
    }

    public List getDataSet(){
        return mDataSet;
    }

    public void addItem(T item){
        mDataSet.add(item);
    }

    public T getItem(int position){
        return mDataSet.get(position);
    }

    public void setOnItemClickListener(OnRecyclerItemClickListener<T> listener) {
        mListener = listener;
    }

    public OnRecyclerItemClickListener<T> getOnItemClickListener() {
        return mListener;
    }

    @Override
    public void onBindViewHolder(BindAdapter.BindViewHolder<B> holder, int position) {
        holder.getBinding().setVariable(BR.viewModel, mDataSet.get(position));
        holder.getBinding().executePendingBindings();
        if(mListener!=null){
            holder.getBinding().getRoot().setOnClickListener(v -> {
                mListener.onItemClick(position, mDataSet.get(position));
            });
        }else{
            holder.getBinding().getRoot().setOnClickListener(null);
        }
    }

    protected static class BindViewHolder<B extends ViewDataBinding> extends RecyclerView.ViewHolder{
        public BindViewHolder(View itemView){
            super(itemView);
        }

        public B getBinding(){
            return DataBindingUtil.getBinding(itemView);
        }
    }
}
