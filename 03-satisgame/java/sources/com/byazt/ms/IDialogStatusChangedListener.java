package com.byazt.ms;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes2.dex */
public interface IDialogStatusChangedListener {
    void onCancel(DialogInterface dialogInterface);

    void onNegativeBtnClick(DialogInterface dialogInterface);

    void onPositiveBtnClick(DialogInterface dialogInterface);
}
