package com.byazt.gx;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.js.fw;
import com.byazt.rk.zo;
import com.byazt.uko.w;
import com.umeng.analytics.pro.an;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 63, 2267})
public class DynamicTimeOuter extends DynamicButton implements com.byazt.imd.hn {
    public boolean a;
    public boolean hw;
    public boolean pr;

    public DynamicTimeOuter(Context context, DynamicRootView dynamicRootView, zo zoVar) {
        super(context, dynamicRootView, zoVar);
        dynamicRootView.setTimeOutListener(this);
        if ("timedown".equals(zoVar.vk().getType())) {
            dynamicRootView.setTimedown(this.zo);
        }
    }

    @Override // com.byazt.gx.DynamicButton, com.byazt.gx.DynamicBaseWidgetImp, com.byazt.gx.x
    public boolean zo() {
        super.zo();
        if (fw.hw(this.g.getRenderRequest().uc())) {
            setVisibility(8);
        }
        if ("timedown".equals(this.m.vk().getType())) {
            ((TextView) this.ho).setText(String.valueOf((int) Double.parseDouble(this.k.vk())));
            return true;
        }
        ((TextView) this.ho).setText(((int) Double.parseDouble(this.k.vk())) + an.aB);
        return true;
    }

    @Override // com.byazt.gx.DynamicBaseWidget
    public void c() {
        if (TextUtils.equals("skip-with-countdowns-video-countdown", this.m.vk().getType()) || TextUtils.equals("skip-with-time-countdown", this.m.vk().getType())) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.fw, this.zo);
            layoutParams.gravity = 8388627;
            if (com.byazt.dj.x.pr()) {
                layoutParams.leftMargin = this.aj;
            }
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
            }
            setLayoutParams(layoutParams);
            return;
        }
        super.c();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (TextUtils.isEmpty(((TextView) this.ho).getText())) {
            setMeasuredDimension(0, this.zo);
        }
    }

    @Override // com.byazt.imd.hn
    public void pr(CharSequence charSequence, boolean z, int i, boolean z2) {
        String string = "";
        if (z2 || this.a) {
            ((TextView) this.ho).setText("");
            setVisibility(8);
            return;
        }
        try {
            if (Integer.parseInt((String) charSequence) <= 0) {
                setVisibility(8);
                return;
            }
        } catch (Exception e) {
        }
        setVisibility(0);
        if (!z && this.g.getRenderRequest().hn() && fw.hw(this.g.getRenderRequest().uc())) {
            ((TextView) this.ho).setText(i + an.aB);
            this.pr = true;
            return;
        }
        if (com.byazt.dj.x.pr() && !"open_ad".equals(this.g.getRenderRequest().uc()) && this.g.getRenderRequest().hn()) {
            this.a = true;
            setVisibility(8);
            return;
        }
        if (!"timedown".equals(this.m.vk().getType())) {
            ((TextView) this.ho).setText(((Object) charSequence) + an.aB);
            this.hw = true;
            if (this.pr) {
                CharSequence text = ((TextView) this.ho).getText();
                if (text != null) {
                    string = text.toString();
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (w.hw(string, this.k.c(), true)[0] + com.byazt.js.zo.pr(com.byazt.dj.x.getContext(), this.k.hn() + this.k.x())), this.zo);
                layoutParams.gravity = 8388629;
                this.ho.setLayoutParams(layoutParams);
                this.pr = false;
                requestLayout();
                return;
            }
            return;
        }
        ((TextView) this.ho).setText(charSequence);
    }
}
