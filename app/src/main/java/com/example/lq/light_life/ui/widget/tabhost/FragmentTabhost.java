package com.example.lq.light_life.ui.widget.tabhost;

import android.content.Context;
import android.support.v4.app.FragmentTabHost;
import android.util.AttributeSet;

/**
 * Created by LQ on 2017/10/24.
 */

public class FragmentTabhost extends FragmentTabHost {
    public FragmentTabhost(Context context) {
        super(context);
    }

    public static class FragmentTabHost extends android.support.v4.app.FragmentTabHost {

        private OnTabClickListener mOnTabClickListener = null;
        private boolean isClickLinstener = false;


        public FragmentTabHost(Context context) {
            super(context);
        }


        public FragmentTabHost(Context context, AttributeSet attrs) {
            super(context, attrs);
        }


        @Override
        public void onTabChanged(String tabId) {
            if (null != mOnTabClickListener) {
                isClickLinstener = mOnTabClickListener.onTabClick(tabId);
            }

            if (!isClickLinstener) {
                super.onTabChanged(tabId);
            }
        }


        public void setOnTabClickListener(OnTabClickListener mOnTabClickListener) {
            this.mOnTabClickListener = mOnTabClickListener;
        }


        public interface OnTabClickListener {
            /**
             * If you set the click event, according to the return value of the click event to determine whether to continue to perform
             *
             * @param tabId tabId
             * @return true：Interception event；false：Superclass continue
             */
            boolean onTabClick(String tabId);
        }
    }

}
