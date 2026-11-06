package com.mcto.sspsdk.internal;

import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes2.dex */
public final class cb implements View.OnClickListener {
    public final /* synthetic */ PopupWindow a;

    public cb(PopupWindow popupWindow) {
        this.a = popupWindow;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.a.isShowing()) {
            this.a.dismiss();
        }
    }
}
