package com.mcr.project.heart.quantic.mcr_project.Toolbox.ToolBox;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.Target;
import com.github.amlcurran.showcaseview.targets.ViewTarget;
import com.mcr.project.heart.quantic.mcr_project.R;

import java.lang.reflect.Field;

public class ToolBox_TourView implements View.OnClickListener {

    private ShowcaseView showcaseView;
    private int counter = 0;
    private static RelativeLayout.LayoutParams lps;
    private static RelativeLayout.LayoutParams lps_e;

    private Activity activity;

    private TextView textView;
    private FloatingActionButton fab;
    private Toolbar toolbar;
    private ToolBox_SharedPrefs prefs;

    public ToolBox_TourView(Activity activity, TextView textView, FloatingActionButton fab, Toolbar toolbar) {

        prefs = new ToolBox_SharedPrefs(activity);
        if (!prefs.getTourView()) {

            this.activity = activity;
            this.textView = textView;
            this.fab = fab;
            this.toolbar = toolbar;

            int margin = ((Number) (activity.getResources().getDisplayMetrics().density * 12)).intValue();

            lps = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lps.setMargins(margin, margin, margin, margin);
            lps.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            lps.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

            lps_e = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            lps_e.setMargins(margin, margin, margin, margin);
            lps_e.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            lps_e.addRule(RelativeLayout.ALIGN_PARENT_LEFT);

            TextPaint paint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
            paint.setTextSize(activity.getResources().getDimension(R.dimen.abc_text_size_body_1_material));
            paint.setColor(Color.BLACK);

            showcaseView = new ShowcaseView.Builder(activity)
                    .withMaterialShowcase()
                    .setContentTitle("Ola!")
                    .setContentText("Click em próximo para conhecer o app")
                    .setStyle(R.style.CustomShowcaseTheme2)
                    .replaceEndButton(R.layout._01_view_custom_button)
                    .setOnClickListener(this)
                    .build();

//        showcaseView.setContentTitle("Ola!");
//        showcaseView.setContentText("Click em próximo para conhecer o app");

//        showcaseView.setStyle(activity.getResources().getColor(R.color.colorPrimary));
            showcaseView.setButtonText(activity.getString(R.string.w_proximo));
        }
    }

    private void setAlpha(float alpha, View... views) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            for (View view : views) {
                view.setAlpha(alpha);
            }
        }
    }

    @Override
    public void onClick(View v) {

        switch (counter) {

            case 0:

                showcaseView.setShowcase(new ViewTarget(textView), true);
                showcaseView.setContentTitle("Hello!");
                showcaseView.setContentText("Bem Vindo ao APP!");

                showcaseView.setButtonText(activity.getString(R.string.w_proximo));
                showcaseView.setButtonPosition(lps);
                break;

            case 1:

                showcaseView.setShowcase(new ViewTarget(fab), true);
                showcaseView.setContentTitle("ADD!");
                showcaseView.setContentText("Adicione mais itens a sua lista!");

                showcaseView.setButtonText(activity.getString(R.string.w_proximo));
                showcaseView.setButtonPosition(lps_e);
                break;
            case 2:

                View navigationButtonViewTarget = null;
                try {
                    navigationButtonViewTarget = navigationButtonViewTarget(toolbar);
                } catch (MissingViewException e) {
                    e.printStackTrace();
                }

                showcaseView.setShowcase(new ViewTarget(navigationButtonViewTarget), true);
                showcaseView.setContentTitle("Seu Menu!");
                showcaseView.setContentText("Click para abrir o menu");

                showcaseView.setButtonText(activity.getString(R.string.w_proximo));
                showcaseView.setButtonPosition(lps);
                break;
            case 3:

                showcaseView.setTarget(Target.NONE);
                showcaseView.setContentTitle("Finalizando");
                showcaseView.setContentText("Utilize seu App!");
                showcaseView.setButtonText(activity.getString(R.string.w_terminar));
                showcaseView.setButtonPosition(lps);
                setAlpha(0.4f, textView, fab, toolbar);
                break;

            case 4:

                ToolBox_SharedPrefs prefs = new ToolBox_SharedPrefs(activity);
                prefs.setTourView();
                showcaseView.hide();
                setAlpha(1.0f, textView, fab, toolbar);
                break;
        }
        counter++;
    }

    /**
     * Highlight the navigation button (the Up or Navigation drawer button) in a Toolbar
     *
     * @param toolbar The toolbar to search for the view in
     * @return the {@link ViewTarget} to supply to a {@link com.github.amlcurran.showcaseview.ShowcaseView}
     * @throws MissingViewException when the view couldn't be found. Raise an issue on Github if you get this!
     */
    public static View navigationButtonViewTarget(Toolbar toolbar) throws MissingViewException {
        try {
            Field field = Toolbar.class.getDeclaredField("mNavButtonView");
            field.setAccessible(true);
            View navigationView = (View) field.get(toolbar);
            return
                    navigationView;
        } catch (NoSuchFieldException e) {
            throw new MissingViewException(e);
        } catch (IllegalAccessException e) {
            throw new MissingViewException(e);
        }
    }

    public static class MissingViewException extends Exception {

        public MissingViewException(Throwable throwable) {
            super(throwable);
        }
    }
}