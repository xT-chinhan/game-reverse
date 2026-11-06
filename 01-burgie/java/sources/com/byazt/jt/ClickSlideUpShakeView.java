package com.byazt.jt;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.byazt.rk.vk;
import com.byazt.uz.hw;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 86, 1961})
public class ClickSlideUpShakeView extends SlideUpView {
    public ShakeClickView pr;

    public ClickSlideUpShakeView(Context context, vk vkVar, boolean z, int i) {
        super(context);
        pr(context, vkVar, z, i);
    }

    private void pr(Context context, vk vkVar, boolean z, int i) {
        ShakeClickView shakeClickView = new ShakeClickView(context, hw.hn(context), vkVar, z, i);
        this.pr = shakeClickView;
        addView(shakeClickView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.pr.setLayoutParams(layoutParams);
    }

    public ShakeClickView getShakeView() {
        return this.pr;
    }

    public void setShakeText(String str) {
        if (this.pr == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.pr.setShakeText("");
        } else {
            this.pr.setShakeText(str);
        }
    }
}
