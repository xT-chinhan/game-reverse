package com.byazt.gx;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.byazt.js.fw;
import com.byazt.rk.zo;
import com.uc.crashsdk.export.LogType;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 63, LogType.UNEXP_ANR})
public class DynamicTimeOuterContainerWidgetImp extends DynamicBaseWidgetImp implements com.byazt.imd.hn {
    public int a;
    public int cz;
    public boolean hw;
    public boolean ny;
    public int pr;

    public DynamicTimeOuterContainerWidgetImp(Context context, DynamicRootView dynamicRootView, zo zoVar) {
        super(context, dynamicRootView, zoVar);
        this.cz = 0;
        setTag(Integer.valueOf(getClickArea()));
        aj();
        dynamicRootView.setTimeOutListener(this);
        if (dynamicRootView.getRenderRequest() != null && !dynamicRootView.getRenderRequest().iu()) {
            if (this.ho != null) {
                this.ho.setVisibility(8);
            }
            setVisibility(8);
        }
    }

    @Override // com.byazt.gx.DynamicBaseWidgetImp
    public FrameLayout.LayoutParams getWidgetLayoutParams() {
        return new FrameLayout.LayoutParams(-2, -2);
    }

    @Override // com.byazt.gx.DynamicBaseWidget
    public void c() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.hw) {
            layoutParams.leftMargin = this.aj;
        } else {
            layoutParams.leftMargin = this.aj + this.cz;
        }
        if (this.ny && this.k != null) {
            layoutParams.leftMargin = ((this.aj + this.cz) - ((int) com.byazt.js.zo.pr(com.byazt.dj.x.getContext(), this.k.hn()))) - ((int) com.byazt.js.zo.pr(com.byazt.dj.x.getContext(), this.k.x()));
        }
        if (com.byazt.dj.x.pr()) {
            layoutParams.topMargin = this.vk - ((int) com.byazt.js.zo.pr(com.byazt.dj.x.getContext(), this.k.hw()));
        } else {
            layoutParams.topMargin = this.vk;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(layoutParams.leftMargin);
            layoutParams.setMarginEnd(layoutParams.rightMargin);
        }
        setLayoutParams(layoutParams);
    }

    @Override // com.byazt.gx.DynamicBaseWidgetImp, com.byazt.gx.x
    public boolean zo() {
        if (fw.hw(this.g.getRenderRequest().uc())) {
            return true;
        }
        super.zo();
        setPadding((int) com.byazt.js.zo.pr(com.byazt.dj.x.getContext(), this.k.hn()), (int) com.byazt.js.zo.pr(com.byazt.dj.x.getContext(), this.k.hw()), (int) com.byazt.js.zo.pr(com.byazt.dj.x.getContext(), this.k.x()), (int) com.byazt.js.zo.pr(com.byazt.dj.x.getContext(), this.k.pr()));
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.ny && this.k != null) {
            setMeasuredDimension(this.a + ((int) com.byazt.js.zo.pr(com.byazt.dj.x.getContext(), this.k.hn())) + ((int) com.byazt.js.zo.pr(com.byazt.dj.x.getContext(), this.k.x())), this.zo);
        } else if (this.hw) {
            setMeasuredDimension(this.fw, this.zo);
        } else {
            setMeasuredDimension(this.pr, this.zo);
        }
    }

    private void aj() {
        List<zo> listW = this.m.w();
        if (listW == null || listW.size() <= 0) {
            return;
        }
        for (zo zoVar : listW) {
            if (TextUtils.equals("skip-with-time-skip-btn", zoVar.vk().getType())) {
                int iM = 0;
                if (com.byazt.dj.x.pr()) {
                    iM = zoVar.m();
                }
                this.a = (int) com.byazt.js.zo.pr(this.w, zoVar.zo() + iM);
                this.pr = this.fw - this.a;
                break;
            }
        }
        this.cz = this.fw - this.pr;
    }

    @Override // com.byazt.imd.hn
    public void pr(CharSequence charSequence, boolean z, int i, boolean z2) {
        if (z2 && this.ny != z2) {
            this.ny = z2;
            c();
            return;
        }
        if (z && this.hw != z) {
            this.hw = z;
            c();
        }
        this.hw = z;
    }
}
