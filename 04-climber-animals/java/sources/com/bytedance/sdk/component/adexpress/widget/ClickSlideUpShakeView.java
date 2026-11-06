package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.adexpress.dynamic.ah.ch;

/* JADX INFO: loaded from: classes2.dex */
public class ClickSlideUpShakeView extends SlideUpView {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private ShakeClickView f918ms;

    public ClickSlideUpShakeView(Context context, ch chVar, boolean z, int i) {
        super(context);
        ms(context, chVar, z, i);
    }

    private void ms(Context context, ch chVar, boolean z, int i) {
        ShakeClickView shakeClickView = new ShakeClickView(context, com.bytedance.sdk.component.adexpress.ah.ms.ah(context), chVar, z, i);
        this.f918ms = shakeClickView;
        addView(shakeClickView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.f918ms.setLayoutParams(layoutParams);
    }

    public ShakeClickView getShakeView() {
        return this.f918ms;
    }

    public void setShakeText(String str) {
        if (this.f918ms == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.f918ms.setShakeText("");
        } else {
            this.f918ms.setShakeText(str);
        }
    }
}
