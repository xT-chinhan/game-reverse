package com.byazt.yyh;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import com.byazt.bek.DownloadModel;
import com.byazt.zv.m;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1562, 37})
public class pr implements m {
    @Override // com.byazt.zv.m
    public void pr(int i, Context context, DownloadModel downloadModel, String str, Drawable drawable, int i2) {
        Toast.makeText(context, str, 0).show();
    }

    @Override // com.byazt.zv.m
    public Dialog hw(com.byazt.cxa.hw hwVar) {
        return pr(hwVar);
    }

    private static Dialog pr(final com.byazt.cxa.hw hwVar) {
        if (hwVar == null) {
            return null;
        }
        AlertDialog alertDialogShow = new AlertDialog.Builder(hwVar.pr).setTitle(hwVar.hw).setMessage(hwVar.hn).setPositiveButton(hwVar.x, new DialogInterface.OnClickListener() { // from class: com.byazt.yyh.pr.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (hwVar.zo != null) {
                    hwVar.zo.pr(dialogInterface);
                }
            }
        }).setNegativeButton(hwVar.c, new DialogInterface.OnClickListener() { // from class: com.byazt.yyh.pr.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (hwVar.zo != null) {
                    hwVar.zo.hw(dialogInterface);
                }
            }
        }).show();
        alertDialogShow.setCanceledOnTouchOutside(hwVar.uc);
        alertDialogShow.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.byazt.yyh.pr.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (hwVar.zo != null) {
                    hwVar.zo.hn(dialogInterface);
                }
            }
        });
        if (hwVar.fw != null) {
            alertDialogShow.setIcon(hwVar.fw);
        }
        return alertDialogShow;
    }
}
