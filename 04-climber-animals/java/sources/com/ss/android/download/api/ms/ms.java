package com.ss.android.download.api.ms;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import com.ss.android.download.api.config.sl;
import com.ss.android.download.api.download.DownloadModel;

/* JADX INFO: loaded from: classes3.dex */
public class ms implements sl {
    @Override // com.ss.android.download.api.config.sl
    public void ms(int i, Context context, DownloadModel downloadModel, String str, Drawable drawable, int i2) {
        Toast.makeText(context, str, 0).show();
    }

    @Override // com.ss.android.download.api.config.sl
    public Dialog xr(com.ss.android.download.api.model.xr xrVar) {
        return ms(xrVar);
    }

    private static Dialog ms(final com.ss.android.download.api.model.xr xrVar) {
        if (xrVar == null) {
            return null;
        }
        AlertDialog alertDialogShow = new AlertDialog.Builder(xrVar.f4329ms).setTitle(xrVar.xr).setMessage(xrVar.ah).setPositiveButton(xrVar.d, new DialogInterface.OnClickListener() { // from class: com.ss.android.download.api.ms.ms.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (xrVar.x != null) {
                    xrVar.x.ms(dialogInterface);
                }
            }
        }).setNegativeButton(xrVar.ka, new DialogInterface.OnClickListener() { // from class: com.ss.android.download.api.ms.ms.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (xrVar.x != null) {
                    xrVar.x.xr(dialogInterface);
                }
            }
        }).show();
        alertDialogShow.setCanceledOnTouchOutside(xrVar.c);
        alertDialogShow.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.ss.android.download.api.ms.ms.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (xrVar.x != null) {
                    xrVar.x.ah(dialogInterface);
                }
            }
        });
        if (xrVar.ab != null) {
            alertDialogShow.setIcon(xrVar.ab);
        }
        return alertDialogShow;
    }
}
