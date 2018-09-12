package com.shushper.loftmoneyaug18;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class ConfirmDeleteDialog extends DialogFragment {

    private Listener listener;

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog alertDialog = new AlertDialog.Builder(requireContext())
                .setMessage("Вы действиетельно хотите удалить выбранные элементы?")
                .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       if (listener != null) {
                           listener.onDeleteConfirmed();
                       }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create();

        return alertDialog;
    }

    interface Listener {
        void onDeleteConfirmed();
    }
}
