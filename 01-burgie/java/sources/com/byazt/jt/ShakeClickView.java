package com.byazt.jt;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.byazt.ca.ho;
import com.byazt.rk.vk;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 86, 2122})
public class ShakeClickView extends ShakeAnimationView {
    public TextView hw;

    public ShakeClickView(Context context, View view, vk vkVar, boolean z, int i) {
        super(context, view, vkVar, z, i);
    }

    @Override // com.byazt.jt.ShakeAnimationView
    public void pr(Context context, View view) {
        addView(view);
        this.hw = (TextView) findViewById(2097610747);
    }

    @Override // com.byazt.jt.ShakeAnimationView
    public void setShakeText(String str) {
        if (this.hw == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            try {
                this.hw.setText("摇一摇或点击了解更多");
                return;
            } catch (Exception e) {
                ho.hw("shakeClickView", e.getMessage());
                return;
            }
        }
        this.hw.setText(str);
    }
}
