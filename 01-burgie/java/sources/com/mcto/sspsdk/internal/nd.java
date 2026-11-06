package com.mcto.sspsdk.internal;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;

/* JADX INFO: loaded from: classes2.dex */
public final class nd implements PopupWindow.OnDismissListener {
    public final /* synthetic */ View a;

    public nd(View view) {
        this.a = view;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        try {
            Activity activityE = hk.e(this.a.getContext());
            if (activityE == null) {
                return;
            }
            Window window = activityE.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = 1.0f;
            window.setAttributes(attributes);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
