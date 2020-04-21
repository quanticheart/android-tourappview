package com.mcr.project.heart.quantic.mcr_project.Toolbox.ToolBox;

import android.Manifest;
import android.app.Activity;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import java.io.File;

/**
 * Created by John on 09/12/2017.
 */

public class ToolBox_Config_Inicial {

    public static void Funcao_Verifica_Funcoes(Activity activity) {

        Funcao_Verifica_Pastas();
        Funcao_Verifica_Permicoes_Do_APP(activity);

    }


    //////////////////////////////////////////////////////////////////////////////////////
    /*  Valor Nome Do SharedPrefs Principal do Projeto
     *  valores iniciais para criar o caminho das pastas do projeto
     *
     */

    private static String PASTA_LOCAL_PROJETO = String.valueOf(Environment.getExternalStoragePublicDirectory("MCR"));
    public static final String CONSTANTE_PASTA_IMAGENS = PASTA_LOCAL_PROJETO + "/media/Images/";
    public static final String CONSTANTE_PASTA_DOCUMENTOS = PASTA_LOCAL_PROJETO + "/media/Documents/";


    //////////////////////////////////////////////////////////////////////////////////////
    /*
     *  Verifica as Pastas a serem criadas para o projeto
     *  como pasta para imagem , documentos ou outros que podem ser compartilhados
     *
     */
    public static void Funcao_Verifica_Pastas() {

        // cria os diretoris nessesarios para o projeto
        File Diretorio_Imagens = new File(CONSTANTE_PASTA_IMAGENS);
        File Diretorio_Documentos = new File(CONSTANTE_PASTA_DOCUMENTOS);

        Diretorio_Imagens.mkdirs();
        Diretorio_Documentos.mkdirs();

        Log.w("Pastas do Projeto", "Verificadas");
    }


    //////////////////////////////////////////////////////////////////////////////////////
    /*
     *  Função para Chamar as Permiçoes que o app Nessecita
     *
     */
    public static void Funcao_Verifica_Permicoes_Do_APP(Activity activity) {

        ToolBox_SharedPrefs prefs = new ToolBox_SharedPrefs(activity);
        Boolean perm = prefs.getPermicoes();

        if (!perm) {
            Manda_Permicoes(activity);
            prefs.setPermicoes();
        }

    }

    //////
    ////// complmento da função a cima
    ////// Aqui é Colocado todas as permiçoes que o app nessecita
    //////
    private static void Manda_Permicoes(Activity activity) {
        ActivityCompat.requestPermissions(activity,
                new String[]{
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.CAMERA
                },
                0);
    }


//
//    //////////////////////////////////////////////////////////////////////////////////////
//        /*
//         *  Função para setar a cor do Status bar Manualmente
//         *
//         */
//    public static void Funcao_Set_StatusBar_Color(Context context, Window window) {
//        // clear FLAG_TRANSLUCENT_STATUS flag:
//        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//        // finally change the color
//        window.setStatusBarColor(context.getResources().getColor(R.color.ColorSupremeBlack));
//    }


}
