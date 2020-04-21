package com.mcr.project.heart.quantic.mcr_project.Toolbox.ToolBox;

import android.content.Context;
import android.content.SharedPreferences;

public class ToolBox_SharedPrefs_Usuario {

    public static final String CONSTANTE_SHAREDPREFS_DO_USUARIO = ToolBox_SharedPrefs.CONSTANTE_SHAREDPREFS_DO_PROJETO;
    private final SharedPreferences Prefs;

    public ToolBox_SharedPrefs_Usuario(Context context) {
        Prefs = context.getSharedPreferences(CONSTANTE_SHAREDPREFS_DO_USUARIO, Context.MODE_PRIVATE);
    }

    //Função para Limpar Os dados do usuario completamente

    public void clear() {
        SharedPreferences.Editor editor = Prefs.edit();
        editor.clear();
        editor.commit();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////

    public static final String CONSTANTE_KEY_SHAREDPREFS_LOGADO = "Logado";

    //////////////////////////////////////////////////////////////////////////////////////////////////////

    public void setLOGADO() {
        SharedPreferences.Editor editor = Prefs.edit();
        editor.putBoolean(CONSTANTE_KEY_SHAREDPREFS_LOGADO, true);
        editor.commit();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////

    public Boolean getLOGADO() {
        Boolean raw_string = Prefs.getBoolean(CONSTANTE_KEY_SHAREDPREFS_LOGADO, false);
        return raw_string;
    }

}