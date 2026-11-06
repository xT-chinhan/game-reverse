package com.bytedance.adsdk.ugeno.swiper.indicator;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.adsdk.ugeno.swiper.xr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseIndicator extends LinearLayout {
    private int ab;
    protected int ah;
    private int c;
    private float ch;
    private List<View> d;
    private float hi;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected Context f394ms;
    private int ny;
    private String sl;
    private boolean x;
    protected int xr;

    public abstract Drawable xr(int i);

    public BaseIndicator(Context context) {
        super(context);
        this.ka = SupportMenu.CATEGORY_MASK;
        this.c = -16776961;
        this.ab = 5;
        this.xr = 40;
        this.ah = 20;
        this.sl = "row";
        this.f394ms = context;
        this.d = new ArrayList();
        setOrientation(0);
    }

    public void setIndicatorX(float f) {
        this.ch = f;
    }

    public void setIndicatorY(float f) {
        this.hi = f;
    }

    public void setIndicatorDirection(String str) {
        this.sl = str;
        if (TextUtils.equals(str, "column")) {
            setOrientation(1);
        } else {
            setOrientation(0);
        }
    }

    public void setIndicatorWidth(int i) {
        this.xr = i;
    }

    public void setIndicatorHeight(int i) {
        this.ah = i;
    }

    public void ms(int i, int i2) {
        Iterator<View> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().setBackground(xr(this.c));
        }
        if (i < 0 || i >= this.d.size()) {
            i = 0;
        }
        if (this.d.size() > 0) {
            this.d.get(i).setBackground(xr(this.ka));
            this.ny = i2;
        }
    }

    public int getSize() {
        return this.d.size();
    }

    public void setSelectedColor(int i) {
        this.ka = i;
    }

    public void setLoop(boolean z) {
        this.x = z;
    }

    public void setUnSelectedColor(int i) {
        this.c = i;
    }

    public void ms(int i) {
        if (this instanceof DotIndicator) {
            this.ah = this.xr;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.xr, this.ah);
        if (getOrientation() == 1) {
            layoutParams.topMargin = this.ab;
            layoutParams.bottomMargin = this.ab;
        } else {
            layoutParams.leftMargin = this.ab;
            layoutParams.rightMargin = this.ab;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.xr, this.ah);
        if (getOrientation() == 1) {
            layoutParams2.topMargin = this.ab;
            layoutParams2.bottomMargin = this.ab;
        } else {
            layoutParams2.leftMargin = this.ab;
            layoutParams2.rightMargin = this.ab;
        }
        int iMs = xr.ms(this.x, this.ny, this.d.size());
        int iMs2 = xr.ms(this.x, i, this.d.size());
        if (this.d.size() == 0) {
            iMs2 = 0;
        }
        if (!this.d.isEmpty() && xr.ms(iMs, this.d) && xr.ms(iMs2, this.d)) {
            this.d.get(iMs).setBackground(xr(this.c));
            this.d.get(iMs).setLayoutParams(layoutParams2);
            this.d.get(iMs2).setBackground(xr(this.ka));
            this.d.get(iMs2).setLayoutParams(layoutParams);
            this.ny = i;
        }
    }

    public void ms() {
        View view = new View(getContext());
        view.setClickable(false);
        if (this instanceof DotIndicator) {
            this.ah = this.xr;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.xr, this.ah);
        if (getOrientation() == 1) {
            layoutParams.topMargin = this.ab;
            layoutParams.bottomMargin = this.ab;
        } else {
            layoutParams.leftMargin = this.ab;
            layoutParams.rightMargin = this.ab;
        }
        addView(view, layoutParams);
        view.setBackground(xr(this.c));
        this.d.add(view);
    }
}
