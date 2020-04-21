package com.mcr.project.heart.quantic.mcr_project.Wizard;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mcr.project.heart.quantic.mcr_project.R;
import com.mcr.project.heart.quantic.mcr_project.Toolbox.ToolBox.ToolBox_MSG;
import com.mcr.project.heart.quantic.mcr_project.Toolbox.ToolBox.ToolBox_SharedPrefs;
import com.mcr.project.heart.quantic.mcr_project.User.UserMain;

public class Wizard extends AppCompatActivity {

    private Context context;
    private Activity activity;
    private ViewPager viewPager;
    private LinearLayout dotsLinearLayout, ll_linha;
    private Button btnNextPage, btnBackPage, btnJump, btnJump2;
    private static int currentPage, pageLenght;
    private TextView[] dots;
    private SlideAdapter slideAdapter;

    int tipo = 1; // tema primario
//    int tipo = 2; // tema secundario

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout._01_activity_wizard);

        context = getBaseContext();
        activity = Wizard.this;

        initViews();
        initActions();

    }

    private void initViews() {

        viewPager = findViewById(R.id.viewPagerSlide);
        dotsLinearLayout = findViewById(R.id.dotLinearLayout);

        // tipo 1
        btnBackPage = findViewById(R.id.btnBackPage);
        btnNextPage = findViewById(R.id.btnNextPage);
        btnJump = findViewById(R.id.btnJump);

        // tipo 2
        ll_linha = findViewById(R.id.ll_linha);
        btnJump2 = findViewById(R.id.btnJump2);

        Funcao_Pular(btnJump);
        Funcao_Pular(btnJump2);

    }

    private void initActions() {

        addDotsIndicator(0);

        slideAdapter = new SlideAdapter(this, pageLenght);
        viewPager.setAdapter(slideAdapter);

        viewPager.addOnPageChangeListener(onPageChangeListener);

        SetClickListener(btnBackPage, -1);
        SetClickListener(btnNextPage, 1);

    }

    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDotsIndicator(position);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private void addDotsIndicator(int pos) {

        dots = new TextView[3];
        pageLenght = dots.length;
        currentPage = pos;

        dotsLinearLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {

            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.gray_light));

            dotsLinearLayout.addView(dots[i]);

        }

        if (dots.length > 0) {
            dots[pos].setTextColor(getResources().getColor(R.color.white));
        }

        Funcao_SetTheme(tipo, pos);


    }

    private void Funcao_SetTheme(int tipo, int pos) {

        btnBackPage.setVisibility(View.GONE);
        btnNextPage.setVisibility(View.GONE);
        btnJump.setVisibility(View.GONE);

        ll_linha.setVisibility(View.GONE);
        btnJump2.setVisibility(View.GONE);

        switch (tipo) {
            case 1:

                btnJump.setVisibility(View.VISIBLE);

                if (pos == 0) {

                    btnBackPage.setEnabled(false);
                    btnBackPage.setText(getResources().getString(R.string.w_anterior));
                    btnBackPage.setVisibility(View.GONE);

                    btnNextPage.setEnabled(true);
                    btnNextPage.setText(getResources().getString(R.string.w_proximo));
                    btnNextPage.setVisibility(View.VISIBLE);


                } else if (pos == dots.length - 1) {

                    btnBackPage.setEnabled(true);
                    btnBackPage.setText(getResources().getString(R.string.w_anterior));
                    btnBackPage.setVisibility(View.VISIBLE);

                    btnNextPage.setEnabled(true);
                    btnNextPage.setText(getResources().getString(R.string.w_terminar));
                    btnNextPage.setVisibility(View.VISIBLE);


                } else {

                    btnBackPage.setEnabled(true);
                    btnBackPage.setText(getResources().getString(R.string.w_anterior));
                    btnBackPage.setVisibility(View.VISIBLE);

                    btnNextPage.setEnabled(true);
                    btnNextPage.setText(getResources().getString(R.string.w_proximo));
                    btnNextPage.setVisibility(View.VISIBLE);

                }

                break;

            case 2:

                ll_linha.setVisibility(View.VISIBLE);

                if (pos == 0) {

                    btnJump2.setEnabled(true);
                    btnJump2.setText(getResources().getString(R.string.w_pular));
                    btnJump2.setVisibility(View.VISIBLE);

                    btnNextPage.setEnabled(true);
                    btnNextPage.setText(getResources().getString(R.string.w_proximo));
                    btnNextPage.setVisibility(View.VISIBLE);


                } else if (pos == dots.length - 1) {

                    btnJump2.setEnabled(true);
                    btnJump2.setText(getResources().getString(R.string.w_terminar));
                    btnJump2.setVisibility(View.VISIBLE);

                    btnNextPage.setEnabled(false);
                    btnNextPage.setText(getResources().getString(R.string.w_terminar));
                    btnNextPage.setVisibility(View.GONE);

                } else {

                    btnJump2.setEnabled(true);
                    btnJump2.setText(getResources().getString(R.string.w_pular));
                    btnJump2.setVisibility(View.VISIBLE);

                    btnNextPage.setEnabled(true);
                    btnNextPage.setText(getResources().getString(R.string.w_proximo));
                    btnNextPage.setVisibility(View.VISIBLE);
                }

                break;
        }

    }

    private void SetClickListener(Button btn, final int pos) {

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (pos == -1) {
                    viewPager.setCurrentItem(currentPage - 1);
                } else {

                    if (currentPage == dots.length - 1) {
                        Funcao_FinalizaPagina();
                    }

                    viewPager.setCurrentItem(currentPage + 1);
                }

            }
        });

    }

    private void Funcao_Pular(Button btn) {

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Funcao_FinalizaPagina();
            }
        });

    }

    private void Funcao_FinalizaPagina() {
//        ToolBox_MSG.Funcao_MSG(activity, "pulando");

        ToolBox_SharedPrefs prefs = new ToolBox_SharedPrefs(activity);
        prefs.setWizard();
        Intent intent = new Intent(activity , UserMain.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

