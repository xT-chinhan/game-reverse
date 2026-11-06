package com.byazt.ms;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Window;
import android.view.WindowManager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 238, 18})
public class l {
    private static AlertDialog n(Activity activity, final DialogBuilder dialogBuilder) {
        return new com.byazt.mr.tj(activity).n(dialogBuilder.title).qg(dialogBuilder.message).s(dialogBuilder.positiveBtnText).q(dialogBuilder.negativeBtnText).n(dialogBuilder.icon).n(new com.byazt.mr.tj.n() { // from class: com.byazt.ms.l.2
            @Override // com.byazt.mr.tj.n
            public void n(Dialog dialog) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onPositiveBtnClick(dialog);
                }
            }

            @Override // com.byazt.mr.tj.n
            public void qg(Dialog dialog) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onNegativeBtnClick(dialog);
                }
            }
        }).n(new DialogInterface.OnCancelListener() { // from class: com.byazt.ms.l.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onCancel(dialogInterface);
                }
            }
        });
    }

    public static void n(WeakReference<Context> weakReference, boolean z, final DialogBuilder dialogBuilder) {
        com.byazt.okk.n.InterfaceC0282n interfaceC0282n = new com.byazt.okk.n.InterfaceC0282n() { // from class: com.byazt.ms.l.3
            @Override // com.byazt.okk.n.InterfaceC0282n
            public void n() {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onPositiveBtnClick(new n());
                }
            }

            @Override // com.byazt.okk.n.InterfaceC0282n
            public void qg() {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onNegativeBtnClick(new n());
                }
            }

            @Override // com.byazt.okk.n.InterfaceC0282n
            public void s() {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onCancel(new n());
                }
            }
        };
        if (z) {
            com.byazt.okk.n.n(weakReference.get(), String.valueOf(dialogBuilder.hashCode()), dialogBuilder.title, dialogBuilder.message, dialogBuilder.positiveBtnText, dialogBuilder.negativeBtnText, interfaceC0282n);
        } else {
            com.byazt.okk.n.n(weakReference.get(), String.valueOf(dialogBuilder.hashCode()), dialogBuilder.title, dialogBuilder.message, interfaceC0282n);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 238, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    private static class n implements DialogInterface {
        @Override // android.content.DialogInterface
        public void cancel() {
        }

        @Override // android.content.DialogInterface
        public void dismiss() {
        }

        private n() {
        }
    }

    public static AlertDialog n(Activity activity, boolean z, DialogBuilder dialogBuilder) {
        if (z) {
            AlertDialog alertDialogN = n(activity, dialogBuilder);
            if (activity != null && !activity.isFinishing()) {
                alertDialogN.show();
            }
            return alertDialogN;
        }
        return n(activity, R.style.Theme.DeviceDefault.Light.Dialog, dialogBuilder);
    }

    private static AlertDialog n(Activity activity, int i, final DialogBuilder dialogBuilder) {
        AlertDialog.Builder onCancelListener = new AlertDialog.Builder(activity, i).setTitle(dialogBuilder.title).setMessage(dialogBuilder.message).setPositiveButton(dialogBuilder.positiveBtnText, new DialogInterface.OnClickListener() { // from class: com.byazt.ms.l.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onPositiveBtnClick(dialogInterface);
                }
            }
        }).setNegativeButton(dialogBuilder.negativeBtnText, new DialogInterface.OnClickListener() { // from class: com.byazt.ms.l.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onNegativeBtnClick(dialogInterface);
                }
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.byazt.ms.l.4
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onCancel(dialogInterface);
                }
            }
        });
        if (dialogBuilder.icon != null) {
            onCancelListener.setIcon(dialogBuilder.icon);
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
