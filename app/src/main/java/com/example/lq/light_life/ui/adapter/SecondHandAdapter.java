package com.example.lq.light_life.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lq.light_life.R;
import com.example.lq.light_life.classdefinition.SecondHandMsg;
import com.example.lq.light_life.ui.activity.SecondHandDetail;

import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by LQ on 2017/10/9.
 */

public class SecondHandAdapter extends RecyclerView.Adapter<SecondHandAdapter.ViewHolder> {

    private Context mContext;
    private List<SecondHandMsg> mSecondHandMsgList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardview;
        TextView messagePname;
        TextView messagePhone;
        TextView messageTname;
        ImageView messageImage;

        public ViewHolder(View view){
            super (view);
            cardview = (CardView) view;
            messagePname = (TextView) view.findViewById(R.id.message_pname);
            messagePhone = (TextView) view.findViewById(R.id.message_phone);
            messageTname = (TextView) view.findViewById(R.id.message_tname);
            messageImage = (ImageView) view.findViewById(R.id.message_image);
        }
    }

    public SecondHandAdapter(List<SecondHandMsg> secondHandMsgs){
        mSecondHandMsgList = secondHandMsgs;
    }
    //下面是每一条msg的点击进入详细信息业
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.secondhandmsg,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position= holder.getAdapterPosition();
                Log.e(TAG, "onClick: " + position);
                SecondHandMsg message = mSecondHandMsgList.get(position);
                Intent intent = new Intent(mContext,SecondHandDetail.class);
                intent.putExtra(SecondHandDetail.MESSAGE_NAME,message.getTname());
                intent.putExtra(SecondHandDetail.MESSAGE_IMAGE_ID,message.getImageId());
                intent.putExtra(SecondHandDetail.MESSAGE_PNAME_TEXT,message.getPname());
                intent.putExtra(SecondHandDetail.MESSAGE_PHONE_TEXT,message.getPhone());
                intent.putExtra(SecondHandDetail.MESSAGE_TNAME_TEXT,message.getTname());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }




    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SecondHandMsg message = mSecondHandMsgList.get(position);
        holder.messagePname.setText(message.getPname());
        holder.messagePhone.setText(message.getPhone());
        holder.messageTname.setText(message.getTname());
        holder.messageImage.setImageResource(message.getImageId());
    }

    @Override
    public int getItemCount() {
        return mSecondHandMsgList.size();
    }
}
