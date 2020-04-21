//package com.brasil.naville.materialdesigntemplates.Wizards;
//
//import android.content.Context;
//import android.graphics.Color;
//import android.support.annotation.NonNull;
//import android.support.v4.view.PagerAdapter;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.LinearLayout;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import com.brasil.naville.materialdesigntemplates.R;
//
//import de.hdodenhof.circleimageview.CircleImageView;
//
//
//public class SlideAdapter extends PagerAdapter {
//
//    Context context;
//    LayoutInflater layoutInflater;
//
//    //Arrays
//    public int[] slideImages = {R.drawable.bee, R.drawable.carrot, R.drawable.ladybird};
//
//    public int[] slideBackground = {
//            Color.rgb(55, 55, 55),
//            Color.rgb(239, 85, 85),
//            Color.rgb(110, 49, 89),
//            Color.rgb(1, 188, 212),
//    };
//
//    public String[] slideHeadings = {"Bee", "Carrot", "Ladybird"};
//
//    public String[] slideDescriptions = {"Bzzzzzzzzzzzzzz", "Nhac?", "zzzzzzzzzuuuuummmmm"};
//
//
//    public SlideAdapter(Context context) {
//        this.context = context;
//    }
//
//
//    @Override
//    public int getCount() {
//        return slideHeadings.length;
//    }
//
//    @Override
//    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
//        return view == (RelativeLayout) object;
//    }
//
//    @NonNull
//    @Override
//    public Object instantiateItem(@NonNull ViewGroup container, int position) {
//        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        assert layoutInflater != null;
//        View view = layoutInflater.inflate(R.layout.activity_slide_itens, container, false);
//        LinearLayout linearLayout
//
//        CircleImageView circleImageViewSlide = view.findViewById(R.id.slideImage);
//        TextView txtHeadingsSlide = view.findViewById(R.id.txtHeadings);
//        TextView txtDescriptionsSlide = view.findViewById(R.id.txtDescriptions);
//
//        circleImageViewSlide.setImageResource(slideImages[position]);
//        txtHeadingsSlide.setText(slideHeadings[position]);
//        txtDescriptionsSlide.setText(slideDescriptions[position]);
//
//        container.addView(view);
//        return view;
//
//    }
//
//    @Override
//    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//
//        container.removeView((RelativeLayout) object);
//
//
//    }
//}

package com.mcr.project.heart.quantic.mcr_project.Wizard;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mcr.project.heart.quantic.mcr_project.R;

public class SlideAdapter extends PagerAdapter {

    public Context context;
    public int pageLenght;
    public LayoutInflater inflater;

    // list of images
    public int[] lst_images = {
            R.drawable.ic_3,
            R.drawable.ic_2,
            R.drawable.ic_3
    };
    // list of titles
    public String[] lst_title = {
            "COSMONAUT",
            "SATELITE",
            "ROCKET"
    };
    // list of descriptions
    public String[] lst_description = {
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,"
    };
    // list of background colors
    public int[] lst_backgroundcolor = {
            Color.rgb(55, 55, 55),
            Color.rgb(110, 49, 89),
            Color.rgb(1, 188, 212)
    };


    public SlideAdapter(Context context, int pageLenght) {
        this.context = context;
        this.pageLenght = pageLenght;
    }

    @Override
    public int getCount() {
        return lst_title.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    @NonNull
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        View view = inflater.inflate(R.layout._01_activity_wizard_itens, container, false);
        LinearLayout slideLinearLayout = view.findViewById(R.id.slideLinearLayout);

        ImageView slideImage = view.findViewById(R.id.slideImage);
        TextView txtHeadings = view.findViewById(R.id.txtHeadings);
        TextView txtDescriptions = view.findViewById(R.id.txtDescriptions);

        slideLinearLayout.setBackgroundColor(lst_backgroundcolor[position]);
        slideImage.setImageResource(lst_images[position]);
        txtHeadings.setText(lst_title[position]);
        txtDescriptions.setText(lst_description[position]);


        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}