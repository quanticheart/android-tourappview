package com.mcr.project.heart.quantic.mcr_project.Splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mcr.project.heart.quantic.mcr_project.Login.LoginMain;
import com.mcr.project.heart.quantic.mcr_project.R;
import com.mcr.project.heart.quantic.mcr_project.Toolbox.ToolBox.ToolBox_SharedPrefs;
import com.mcr.project.heart.quantic.mcr_project.Toolbox.ToolBox.ToolBox_SharedPrefs_Usuario;
import com.mcr.project.heart.quantic.mcr_project.User.UserMain;
import com.mcr.project.heart.quantic.mcr_project.Wizard.Wizard;

/**
 * Created by John on 01/12/2017.
 */

public class Splash extends AppCompatActivity {

    private Context context;
    private ToolBox_SharedPrefs prefs = null;
    private ToolBox_SharedPrefs_Usuario prefs_user = null;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout._00_splash);
        context = getApplicationContext();
        prefs = new ToolBox_SharedPrefs(context);
        prefs_user = new ToolBox_SharedPrefs_Usuario(context);

        Verifica_Usuario_Esta_Logado();//Pega do prefs se já está criado

    }

    private void Verifica_Usuario_Esta_Logado() {

        ToolBox_SharedPrefs_Usuario pres = new ToolBox_SharedPrefs_Usuario(context);
        Boolean splash = pres.getLOGADO();

        if (splash) {

            final Intent Pagina_Inicio = new Intent(this, UserMain.class);
            startActivity(Pagina_Inicio);
            finish();

        } else {

            Verifica_Splash();

        }
    }

    private void Verifica_Splash() {

        if (prefs.getSplash()) {

            startActivity(getIntent_Type());
            finish();

        } else {

            new Handler().postDelayed(
                    new Runnable() {
                        @Override
                        public void run() {

                            prefs.setSplash();
                            startActivity(getIntent_Type());
                            finish();

                        }
                    },
                    5000
            );

        }
    }

    private Intent getIntent_Type() {
        Intent intent = null;

        if (!prefs.getWizard()) {
            intent = new Intent(this, Wizard.class);
        } else {
//         if (!prefs_user.getLOGADO()) {
//            intent = new Intent(this, LoginMain.class);
//        } else {
            intent = new Intent(this, UserMain.class);
//        }
        }

        return intent;
    }

}
