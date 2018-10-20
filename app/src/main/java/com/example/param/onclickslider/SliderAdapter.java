package com.example.param.onclickslider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {
   Context context;
   LayoutInflater layoutInflater;
   public SliderAdapter(Context context){
       this.context=context;

    }
    public int[] slide_images={
           R.drawable.eat_icon,
            R.drawable.sleep_icon,
            R.drawable.code_icon,
            R.drawable.cof_icon
    };
   public String[] slide_headings={
           "EAT",
           "SLEEP",
           "CODE",
           "COFFEE"

   };
   public String[] slide_descs={
           "Eating is the ingestion of food,typically to provide a heterotropic organism with energy and to allow for growth",
           "Sleep is naturally recurring state of mind and body,characterized by altered consciousness",
           "One reason for coding is to enable communication in places where ordinary plain language spoken is difficult",
           "Coffee is tbrewed drink prepared from roasted coffee beans,the seeds of berries from certain coffee species"

   };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }
    @Override
    public Object instantiateItem(ViewGroup  container,int position){
        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view =layoutInflater.inflate(R.layout.slide_layout,container,false);
        ImageView slideImageView =(ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading =(TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);
        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);
         container.addView(view);
         return view;



    }
    @Override
    public void destroyItem(ViewGroup container,int position,Object object){
        container.removeView((RelativeLayout)object);

    }
}
