package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.dynamic.ah.ch;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.t;

/* JADX INFO: loaded from: classes2.dex */
public class ShakeClickView extends ShakeAnimationView {
    private TextView xr;

    public ShakeClickView(Context context, View view, ch chVar, boolean z, int i) {
        super(context, view, chVar, z, i);
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView
    protected void ms(Context context, View view) {
        addView(view);
        this.xr = (TextView) findViewById(2097610747);
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView
    public void setShakeText(String str) {
        if (this.xr == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            try {
                this.xr.setText(t.xr(this.xr.getContext(), "tt_splash_default_click_shake"));
                return;
            } catch (Exception e) {
                sl.d("shakeClickView", e.getMessage());
                return;
            }
        }
        this.xr.setText(str);
    }
}
