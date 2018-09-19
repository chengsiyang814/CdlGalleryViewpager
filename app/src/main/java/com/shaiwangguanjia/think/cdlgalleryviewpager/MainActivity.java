package com.shaiwangguanjia.think.cdlgalleryviewpager;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.shaiwangguanjia.think.cdlgalleryviewpager.util.ImageUtil;
import com.shaiwangguanjia.think.cdlgalleryviewpager.viewpager.MyTransformation;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private List<ImageView> imageViewList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ViewPager viewPager=  findViewById(R.id.viewPager);
        imageViewList=new ArrayList<>();
        ImageView first=new ImageView(MainActivity.this);
        /**
         * 为imageview生成的带犹豫倒影的bitmap
         */
        first.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.first,MainActivity.this));
        ImageView second=new ImageView(MainActivity.this);
        second.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.second,MainActivity.this));
        ImageView third=new ImageView(MainActivity.this);
        third.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.third,MainActivity.this));
        ImageView fourth=new ImageView(MainActivity.this);
        fourth.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.fourth,MainActivity.this));
        ImageView fifth=new ImageView(MainActivity.this);
        fifth.setImageBitmap(ImageUtil.getReverseBitmapById(R.mipmap.fifth,MainActivity.this));
        imageViewList.add(first);
        imageViewList.add(second);
        imageViewList.add(third);
        imageViewList.add(fourth);
        imageViewList.add(fifth);
        viewPager.setOffscreenPageLimit(3);
        int pagerWidth = (int) (getResources().getDisplayMetrics().widthPixels * 3.0f / 5.0f);
        ViewGroup.LayoutParams lp=viewPager.getLayoutParams();
        if (lp==null){
            lp=new ViewGroup.LayoutParams(pagerWidth, ViewGroup.LayoutParams.MATCH_PARENT);
        }else {
            lp.width= pagerWidth;
        }
        viewPager.setLayoutParams(lp);
        viewPager.setPageMargin(-50);
        findViewById(R.id.activity_main).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return viewPager.dispatchTouchEvent(motionEvent);
            }
        });
        viewPager.setPageTransformer(true,new MyTransformation());
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imageViewList.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view==object;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView(imageViewList.get(position));
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                ImageView imageView=imageViewList.get(position);
                container.addView(imageView,position);
                return imageView;
            }
        });

    }
}
