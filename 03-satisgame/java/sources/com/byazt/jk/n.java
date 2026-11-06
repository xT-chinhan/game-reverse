package com.byazt.jk;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.widget.Toast;
import com.byazt.hj.DownloadModel;
import com.byazt.ky.oa;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1563, 19})
public class n implements oa {
    @Override // com.byazt.ky.oa
    public void n(int i, Context context, DownloadModel downloadModel, String str, Drawable drawable, int i2) {
        Toast.makeText(context, str, 0).show();
    }

    @Override // com.byazt.ky.oa
    public Dialog qg(com.byazt.os.qg qgVar) {
        return n(qgVar);
    }

    private static Dialog n(final com.byazt.os.qg qgVar) {
        if (qgVar == null) {
            return null;
        }
        AlertDialog alertDialogShow = new AlertDialog.Builder(qgVar.n).setTitle(qgVar.qg).setMessage(qgVar.s).setPositiveButton(qgVar.q, new DialogInterface.OnClickListener() { // from class: com.byazt.jk.n.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (qgVar.fs != null) {
                    qgVar.fs.n(dialogInterface);
                }
            }
        }).setNegativeButton(qgVar.l, new DialogInterface.OnClickListener() { // from class: com.byazt.jk.n.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (qgVar.fs != null) {
                    qgVar.fs.qg(dialogInterface);
                }
            }
        }).show();
        alertDialogShow.setCanceledOnTouchOutside(qgVar.w);
        alertDialogShow.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.byazt.jk.n.3
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (qgVar.fs != null) {
                    qgVar.fs.s(dialogInterface);
                }
            }
        });
        if (qgVar.x != null) {
            alertDialogShow.setIcon(qgVar.x);
        }
        return alertDialogShow;
    }
}
