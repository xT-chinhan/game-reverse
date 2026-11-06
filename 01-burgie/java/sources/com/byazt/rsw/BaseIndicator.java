package com.byazt.rsw;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.internal.view.SupportMenu;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.byazt.rij.hw;
import com.byazt.vzx.pr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 1, 842, 983})
public abstract class BaseIndicator extends LinearLayout {
    public int aj;
    public int c;
    public int fw;
    public int hn;
    public int hw;
    public String k;
    public Context pr;
    public int uc;
    public float vk;
    public float w;
    public List<View> x;
    public boolean zo;

    public abstract Drawable hw(int i);

    public BaseIndicator(Context context) {
        super(context);
        this.c = SupportMenu.CATEGORY_MASK;
        this.uc = -16776961;
        this.fw = 5;
        this.hw = 40;
        this.hn = 20;
        this.k = "row";
        this.pr = context;
        this.x = new ArrayList();
        setOrientation(0);
    }

    public void setIndicatorX(float f) {
        this.vk = f;
    }

    public void setIndicatorY(float f) {
        this.w = f;
    }

    public void setIndicatorDirection(String str) {
        this.k = str;
        if (TextUtils.equals(str, "column")) {
            setOrientation(1);
        } else {
            setOrientation(0);
        }
    }

    public void setIndicatorWidth(int i) {
        this.hw = i;
    }

    public void setIndicatorHeight(int i) {
        this.hn = i;
    }

    public void pr(int i, int i2) {
        Iterator<View> it = this.x.iterator();
        while (it.hasNext()) {
            it.next().setBackground(hw(this.uc));
        }
        if (i < 0 || i >= this.x.size()) {
            i = 0;
        }
        if (this.x.size() > 0) {
            this.x.get(i).setBackground(hw(this.c));
            this.aj = i2;
        }
    }

    public int getSize() {
        return this.x.size();
    }

    public void pr() {
        post(new Runnable() { // from class: com.byazt.rsw.BaseIndicator.1
            @Override // java.lang.Runnable
            public void run() {
                BaseIndicator.this.hn();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn() {
        FrameLayout frameLayout = (FrameLayout) getParent();
        if (frameLayout == null) {
            return;
        }
        float width = frameLayout.getWidth();
        float height = frameLayout.getHeight();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        float width2 = getWidth();
        float height2 = getHeight();
        float f = this.w;
        layoutParams.topMargin = (int) (((int) ((height * f) / 100.0f)) - ((height2 * f) / 100.0f));
        float f2 = this.vk;
        layoutParams.leftMargin = (int) (((int) ((width * f2) / 100.0f)) - ((width2 * f2) / 100.0f));
        setLayoutParams(layoutParams);
    }

    public void setSelectedColor(int i) {
        this.c = i;
    }

    public void setLoop(boolean z) {
        this.zo = z;
    }

    public void setUnSelectedColor(int i) {
        this.uc = i;
    }

    public void pr(int i) {
        if (this instanceof DotIndicator) {
            this.hn = this.hw;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.hw, this.hn);
        if (getOrientation() == 1) {
            layoutParams.topMargin = this.fw;
            layoutParams.bottomMargin = this.fw;
        } else {
            layoutParams.leftMargin = this.fw;
            layoutParams.rightMargin = this.fw;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.hw, this.hn);
        if (getOrientation() == 1) {
            layoutParams2.topMargin = this.fw;
            layoutParams2.bottomMargin = this.fw;
        } else {
            layoutParams2.leftMargin = this.fw;
            layoutParams2.rightMargin = this.fw;
        }
        int iPr = hw.pr(this.zo, this.aj, this.x.size());
        int iPr2 = hw.pr(this.zo, i, this.x.size());
        if (this.x.size() == 0) {
            iPr2 = 0;
        }
        if (!this.x.isEmpty() && hw.pr(iPr, this.x) && hw.pr(iPr2, this.x)) {
            this.x.get(iPr).setBackground(hw(this.uc));
            this.x.get(iPr).setLayoutParams(layoutParams2);
            this.x.get(iPr2).setBackground(hw(this.c));
            this.x.get(iPr2).setLayoutParams(layoutParams);
            this.aj = i;
        }
    }

    public void hw() {
        View view = new View(getContext());
        view.setClickable(false);
        if (this instanceof DotIndicator) {
            this.hn = this.hw;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.hw, this.hn);
        if (getOrientation() == 1) {
            layoutParams.topMargin = this.fw;
            layoutParams.bottomMargin = this.fw;
        } else {
            layoutParams.leftMargin = this.fw;
            layoutParams.rightMargin = this.fw;
        }
        addView(view, layoutParams);
        view.setBackground(hw(this.uc));
        this.x.add(view);
    }
}
