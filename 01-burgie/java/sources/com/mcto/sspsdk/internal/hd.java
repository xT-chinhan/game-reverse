package com.mcto.sspsdk.internal;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.ssp.taskpage.QyTaskPageActivity;

/* JADX INFO: loaded from: classes2.dex */
public abstract class hd extends Dialog {
    public hd(QyTaskPageActivity qyTaskPageActivity) {
        super(qyTaskPageActivity, R.style.qy_custom_dialog_style);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 17;
            attributes.width = -1;
            attributes.height = -1;
            attributes.dimAmount = 0.6f;
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.qy_full_screen_dialog_animation);
            window.addFlags(2);
            window.getDecorView().setPadding(0, 0, 0, 0);
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        Window window;
        super.onWindowFocusChanged(z);
        if (!z || (window = getWindow()) == null) {
            return;
        }
        window.getDecorView().setSystemUiVisibility(com.umeng.analytics.pro.o.a.f);
    }
}
