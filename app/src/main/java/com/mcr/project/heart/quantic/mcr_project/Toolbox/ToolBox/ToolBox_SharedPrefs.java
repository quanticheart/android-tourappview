package com.mcr.project.heart.quantic.mcr_project.Toolbox.ToolBox;

import android.content.Context;
import android.content.SharedPreferences;

public class ToolBox_SharedPrefs {
    public static final String CONSTANTE_SHAREDPREFS_DO_PROJETO = "proj_mcr";
    private final SharedPreferences Prefs;

    public ToolBox_SharedPrefs(Context context) {
        Prefs = context.getSharedPreferences(CONSTANTE_SHAREDPREFS_DO_PROJETO, Context.MODE_PRIVATE);
    }

    //Função para Limpar Os dados do usuario completamente

    public void clear_inicial() {
        SharedPreferences.Editor editor = Prefs.edit();
        editor.clear();
        editor.commit();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    public static final String CONSTANTE_KEY_SHAREDPREFS_WIZARD = "Wizard";

    public void setWizard() {
        SharedPreferences.Editor editor = Prefs.edit();
        editor.putBoolean(CONSTANTE_KEY_SHAREDPREFS_WIZARD, true);
        editor.commit();
    }

    public void setCancelWizard() {
        SharedPreferences.Editor editor = Prefs.edit();
        editor.putBoolean(CONSTANTE_KEY_SHAREDPREFS_WIZARD, false);
        editor.commit();
    }

    public Boolean getWizard() {
        Boolean id = Prefs.getBoolean(CONSTANTE_KEY_SHAREDPREFS_WIZARD, false);
        return id;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    public static final String CONSTANTE_KEY_SHAREDPREFS_SPLASH = "Splash";

    public void setSplash() {
        SharedPreferences.Editor editor = Prefs.edit();
        editor.putBoolean(CONSTANTE_KEY_SHAREDPREFS_SPLASH, true);
        editor.commit();
    }

    public void setCancelSplash() {
        SharedPreferences.Editor editor = Prefs.edit();
        editor.putBoolean(CONSTANTE_KEY_SHAREDPREFS_SPLASH, false);
        editor.commit();
    }

    public Boolean getSplash() {
        Boolean id = Prefs.getBoolean(CONSTANTE_KEY_SHAREDPREFS_SPLASH, false);
        return id;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    public static final String CONSTANTE_KEY_SHAREDPREFS_TOURVIEW = "TourView";

    public void setTourView() {
        SharedPreferences.Editor editor = Prefs.edit();
        editor.putBoolean(CONSTANTE_KEY_SHAREDPREFS_TOURVIEW, true);
        editor.commit();
    }

    public void setCancelTourView() {
        SharedPreferences.Editor editor = Prefs.edit();
        editor.putBoolean(CONSTANTE_KEY_SHAREDPREFS_TOURVIEW, false);
        editor.commit();
    }

    public Boolean getTourView() {
        Boolean id = Prefs.getBoolean(CONSTANTE_KEY_SHAREDPREFS_TOURVIEW, false);
        return id;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final String CONSTANTE_KEY_SHAREDPREFS_DEBUG = "debug";

    public void setDegug() {
        SharedPreferences.Editor editor = Prefs.edit();
        editor.putBoolean(CONSTANTE_KEY_SHAREDPREFS_DEBUG, true);
        editor.commit();
    }

    public void setCancelDegug() {
        SharedPreferences.Editor editor = Prefs.edit();
        editor.putBoolean(CONSTANTE_KEY_SHAREDPREFS_DEBUG, false);
        editor.commit();
    }

    public Boolean getDebug() {
        Boolean id = Prefs.getBoolean(CONSTANTE_KEY_SHAREDPREFS_DEBUG, false);
        return id;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////
    public static final String CONSTANTE_KEY_SHAREDPREFS_PRIMEIRA_PERMISSOES = "permissoes";

    public void setPermicoes() {
        SharedPreferences.Editor editor = Prefs.edit();
        editor.putBoolean(CONSTANTE_KEY_SHAREDPREFS_PRIMEIRA_PERMISSOES, true);
        editor.commit();
    }

    public void setCancelPermicoes() {
        SharedPreferences.Editor editor = Prefs.edit();
        editor.putBoolean(CONSTANTE_KEY_SHAREDPREFS_PRIMEIRA_PERMISSOES, false);
        editor.commit();
    }

    public Boolean getPermicoes() {
        Boolean id = Prefs.getBoolean(CONSTANTE_KEY_SHAREDPREFS_PRIMEIRA_PERMISSOES, false);
        return id;
    }

}