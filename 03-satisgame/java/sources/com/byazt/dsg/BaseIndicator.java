package com.byazt.dsg;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.internal.view.SupportMenu;
import com.byazt.cp.n;
import com.byazt.lb.qg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@n(n = {0, 1, 902, 1071})
public abstract class BaseIndicator extends LinearLayout {
    public float cp;
    public String d;
    public boolean fs;
    public int l;
    public Context n;
    public List<View> q;
    public int qg;
    public int rv;
    public int s;
    public float tj;
    public int w;
    public int x;

    public abstract Drawable qg(int i);

    public BaseIndicator(Context context) {
        super(context);
        this.l = SupportMenu.CATEGORY_MASK;
        this.w = -16776961;
        this.x = 5;
        this.qg = 40;
        this.s = 20;
        this.d = "row";
        this.n = context;
        this.q = new ArrayList();
        setOrientation(0);
    }

    public void setIndicatorX(float f) {
        this.tj = f;
    }

    public void setIndicatorY(float f) {
        this.cp = f;
    }

    public void setIndicatorDirection(String str) {
        this.d = str;
        if (TextUtils.equals(str, "column")) {
            setOrientation(1);
        } else {
            setOrientation(0);
        }
    }

    public void setIndicatorWidth(int i) {
        this.qg = i;
    }

    public void setIndicatorHeight(int i) {
        this.s = i;
    }

    public void n(int i, int i2) {
        Iterator<View> it = this.q.iterator();
        while (it.hasNext()) {
            it.next().setBackground(qg(this.w));
        }
        if (i < 0 || i >= this.q.size()) {
            i = 0;
        }
        if (this.q.size() > 0) {
            this.q.get(i).setBackground(qg(this.l));
            this.rv = i2;
        }
    }

    public int getSize() {
        return this.q.size();
    }

    public void n() {
        post(new Runnable() { // from class: com.byazt.dsg.BaseIndicator.1
            @Override // java.lang.Runnable
            public void run() {
                BaseIndicator.this.s();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        FrameLayout frameLayout = (FrameLayout) getParent();
        if (frameLayout == null) {
            return;
        }
        float width = frameLayout.getWidth();
        float height = frameLayout.getHeight();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        float width2 = getWidth();
        float height2 = getHeight();
        float f = this.cp;
        layoutParams.topMargin = (int) (((int) ((height * f) / 100.0f)) - ((height2 * f) / 100.0f));
        float f2 = this.tj;
        layoutParams.leftMargin = (int) (((int) ((width * f2) / 100.0f)) - ((width2 * f2) / 100.0f));
        setLayoutParams(layoutParams);
    }

    public void setSelectedColor(int i) {
        this.l = i;
    }

    public void setLoop(boolean z) {
        this.fs = z;
    }

    public void setUnSelectedColor(int i) {
        this.w = i;
    }

    public void n(int i) {
        if (this instanceof DotIndicator) {
            this.s = this.qg;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.qg, this.s);
        if (getOrientation() == 1) {
            layoutParams.topMargin = this.x;
            layoutParams.bottomMargin = this.x;
        } else {
            layoutParams.leftMargin = this.x;
            layoutParams.rightMargin = this.x;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.qg, this.s);
        if (getOrientation() == 1) {
            layoutParams2.topMargin = this.x;
            layoutParams2.bottomMargin = this.x;
        } else {
            layoutParams2.leftMargin = this.x;
            layoutParams2.rightMargin = this.x;
        }
        int iN = qg.n(this.fs, this.rv, this.q.size());
        int iN2 = qg.n(this.fs, i, this.q.size());
        if (this.q.size() == 0) {
            iN2 = 0;
        }
        if (!this.q.isEmpty() && qg.n(iN, this.q) && qg.n(iN2, this.q)) {
            this.q.get(iN).setBackground(qg(this.w));
            this.q.get(iN).setLayoutParams(layoutParams2);
            this.q.get(iN2).setBackground(qg(this.l));
            this.q.get(iN2).setLayoutParams(layoutParams);
            this.rv = i;
        }
    }

    public void qg() {
        View view = new View(getContext());
        view.setClickable(false);
        if (this instanceof DotIndicator) {
            this.s = this.qg;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.qg, this.s);
        if (getOrientation() == 1) {
            layoutParams.topMargin = this.x;
            layoutParams.bottomMargin = this.x;
        } else {
            layoutParams.leftMargin = this.x;
            layoutParams.rightMargin = this.x;
        }
        addView(view, layoutParams);
        view.setBackground(qg(this.w));
        this.q.add(view);
    }
}
