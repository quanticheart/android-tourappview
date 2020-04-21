package com.mcr.project.heart.quantic.mcr_project.Toolbox.ToolBox;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by John on 09/12/2017.
 */

public class ToolBox_MSG {

    //
    // 1° Context
    // 2° MSG para o Toast
    //

    public static void Funcao_MSG(Context context, String texto) {
        Funcao_SNACKBAR(context, texto);
    }

    public static void Funcao_TOAST(Context context, String texto) {
        Toast.makeText(
                context,
                texto,
                Toast.LENGTH_LONG
        ).show();
    }

    public static void Funcao_SNACKBAR(Context context, String texto) {

        View rootView = ((Activity) context).getWindow().getDecorView().findViewById(android.R.id.content);

        Snackbar mSnackBar = Snackbar.make(rootView, texto, Snackbar.LENGTH_LONG);
        TextView mainTextView = (TextView) (mSnackBar.getView()).findViewById(android.support.design.R.id.snackbar_text);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
            mainTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        else
            mainTextView.setGravity(Gravity.CENTER_HORIZONTAL);
        mainTextView.setGravity(Gravity.CENTER_HORIZONTAL);
        mSnackBar.show();

    }

    public static void Funcao_SNACKBAR_Personalizado(View view, Context context, String texto) {

        Snackbar snackbar = Snackbar
                .make(view, "No internet connection!", Snackbar.LENGTH_LONG)
                .setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });

// Changing message text color
        snackbar.setActionTextColor(Color.RED);

        // Changing action button text color
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);
        snackbar.show();

    }

    //
    // 1° Activity a receber o Alert
    // 2° MSG para o Alert
    // 3° Evento de Click para receber no evento ok
    //
    public static void Funcao_Dialog_OK_CANCEL(Activity activity, String message, DialogInterface.OnClickListener okListener, DialogInterface.OnClickListener cancelListener) {
        new AlertDialog.Builder(activity)
                .setMessage(message)
                .setPositiveButton("Permitir", okListener)
                .setNegativeButton("Cancelar", cancelListener)
                .create()
                .show();
    }


}
