package com.byazt.lm;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Window;
import android.view.WindowManager;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 572, 109})
public class w {
    private static AlertDialog pr(Activity activity, final com.byazt.lm.pr prVar) {
        return new com.byazt.nc.vk(activity).pr(prVar.pr).hw(prVar.hw).hn(prVar.hn).x(prVar.x).pr(prVar.c).pr(new com.byazt.nc.vk.pr() { // from class: com.byazt.lm.w.2
            @Override // com.byazt.nc.vk.pr
            public void pr(Dialog dialog) {
                if (prVar.uc != null) {
                    prVar.uc.pr(dialog);
                }
            }

            @Override // com.byazt.nc.vk.pr
            public void hw(Dialog dialog) {
                if (prVar.uc != null) {
                    prVar.uc.hw(dialog);
                }
            }
        }).pr(new DialogInterface.OnCancelListener() { // from class: com.byazt.lm.w.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (prVar.uc != null) {
                    prVar.uc.hn(dialogInterface);
                }
            }
        });
    }

    public static void pr(WeakReference<Context> weakReference, boolean z, final com.byazt.lm.pr prVar) {
        com.byazt.wt.c.pr prVar2 = new com.byazt.wt.c.pr() { // from class: com.byazt.lm.w.3
            @Override // com.byazt.wt.c.pr
            public void pr() {
                if (prVar.uc != null) {
                    prVar.uc.pr(new pr());
                }
            }

            @Override // com.byazt.wt.c.pr
            public void hw() {
                if (prVar.uc != null) {
                    prVar.uc.hw(new pr());
                }
            }

            @Override // com.byazt.wt.c.pr
            public void hn() {
                if (prVar.uc != null) {
                    prVar.uc.hn(new pr());
                }
            }
        };
        if (z) {
            com.byazt.wt.c.pr(weakReference.get(), String.valueOf(prVar.hashCode()), prVar.pr, prVar.hw, prVar.hn, prVar.x, prVar2);
        } else {
            com.byazt.wt.c.pr(weakReference.get(), String.valueOf(prVar.hashCode()), prVar.pr, prVar.hw, prVar2);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 572, 1272})
    private static class pr implements DialogInterface {
        private pr() {
        }

        @Override // android.content.DialogInterface
        public void cancel() {
        }

        @Override // android.content.DialogInterface
        public void dismiss() {
        }
    }

    public static AlertDialog pr(Activity activity, boolean z, com.byazt.lm.pr prVar) {
        if (z) {
            AlertDialog alertDialogPr = pr(activity, prVar);
            if (activity != null && !activity.isFinishing()) {
                alertDialogPr.show();
            }
            return alertDialogPr;
        }
        return pr(activity, R.style.Theme.DeviceDefault.Light.Dialog, prVar);
    }

    private static AlertDialog pr(Activity activity, int i, final com.byazt.lm.pr prVar) {
        AlertDialog.Builder onCancelListener = new AlertDialog.Builder(activity, i).setTitle(prVar.pr).setMessage(prVar.hw).setPositiveButton(prVar.hn, new DialogInterface.OnClickListener() { // from class: com.byazt.lm.w.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (prVar.uc != null) {
                    prVar.uc.pr(dialogInterface);
                }
            }
        }).setNegativeButton(prVar.x, new DialogInterface.OnClickListener() { // from class: com.byazt.lm.w.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (prVar.uc != null) {
                    prVar.uc.hw(dialogInterface);
                }
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.byazt.lm.w.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (prVar.uc != null) {
                    prVar.uc.hn(dialogInterface);
                }
            }
        });
        if (prVar.c != null) {
            onCancelListener.setIcon(prVar.c);
        }
        AlertDialog alertDialogCreate = onCancelListener.create();
        Window window = alertDialogCreate.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 17;
            window.setAttributes(attributes);
        }
        if (activity != null && !activity.isFinishing()) {
            alertDialogCreate.show();
        }
        return alertDialogCreate;
    }
}
