package com.bytedance.sdk.openadsdk.core.hi;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public class x {
    private static AlertDialog ms(Activity activity, final DialogBuilder dialogBuilder) {
        return new com.bytedance.sdk.openadsdk.core.widget.ch(activity).ms(dialogBuilder.title).xr(dialogBuilder.message).ah(dialogBuilder.positiveBtnText).d(dialogBuilder.negativeBtnText).ms(dialogBuilder.icon).ms(new com.bytedance.sdk.openadsdk.core.widget.ch.ms() { // from class: com.bytedance.sdk.openadsdk.core.hi.x.2
            @Override // com.bytedance.sdk.openadsdk.core.widget.ch.ms
            public void ms(Dialog dialog) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onPositiveBtnClick(dialog);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.widget.ch.ms
            public void xr(Dialog dialog) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onNegativeBtnClick(dialog);
                }
            }
        }).ms(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.hi.x.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onCancel(dialogInterface);
                }
            }
        });
    }

    public static void ms(WeakReference<Context> weakReference, boolean z, final DialogBuilder dialogBuilder) {
        com.bytedance.sdk.openadsdk.core.jw.c.ms msVar = new com.bytedance.sdk.openadsdk.core.jw.c.ms() { // from class: com.bytedance.sdk.openadsdk.core.hi.x.3
            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ms() {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onPositiveBtnClick(new ms());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void xr() {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onNegativeBtnClick(new ms());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.jw.c.ms
            public void ah() {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onCancel(new ms());
                }
            }
        };
        if (z) {
            com.bytedance.sdk.openadsdk.core.jw.c.ms(weakReference.get(), String.valueOf(dialogBuilder.hashCode()), dialogBuilder.title, dialogBuilder.message, dialogBuilder.positiveBtnText, dialogBuilder.negativeBtnText, msVar);
        } else {
            com.bytedance.sdk.openadsdk.core.jw.c.ms(weakReference.get(), String.valueOf(dialogBuilder.hashCode()), dialogBuilder.title, dialogBuilder.message, msVar);
        }
    }

    private static class ms implements DialogInterface {
        @Override // android.content.DialogInterface
        public void cancel() {
        }

        @Override // android.content.DialogInterface
        public void dismiss() {
        }

        private ms() {
        }
    }

    public static AlertDialog ms(Activity activity, boolean z, DialogBuilder dialogBuilder) {
        if (z) {
            AlertDialog alertDialogMs = ms(activity, dialogBuilder);
            if (activity != null && !activity.isFinishing()) {
                alertDialogMs.show();
            }
            return alertDialogMs;
        }
        return ms(activity, t.ab(activity, "Theme.Dialog.TTDownload"), dialogBuilder);
    }

    private static AlertDialog ms(Activity activity, int i, final DialogBuilder dialogBuilder) {
        AlertDialog.Builder onCancelListener = new AlertDialog.Builder(activity, i).setTitle(dialogBuilder.title).setMessage(dialogBuilder.message).setPositiveButton(dialogBuilder.positiveBtnText, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.hi.x.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onPositiveBtnClick(dialogInterface);
                }
            }
        }).setNegativeButton(dialogBuilder.negativeBtnText, new DialogInterface.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.hi.x.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (dialogBuilder.dialogStatusChangedListener != null) {
                    dialogBuilder.dialogStatusChangedListener.onNegativeBtnClick(dialogInterface);
                }
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.core.hi.x.4
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
        if (activity != null && !activity.isFinishing()) {
            alertDialogCreate.show();
        }
        return alertDialogCreate;
    }
}
