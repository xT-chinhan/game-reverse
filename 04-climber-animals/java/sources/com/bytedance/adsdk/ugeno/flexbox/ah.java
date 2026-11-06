package com.bytedance.adsdk.ugeno.flexbox;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ah {
    int ab;
    int ao;
    int c;
    float ch;
    boolean h;
    float hi;
    int ka;
    int ny;
    boolean qv;
    int sl;
    int ub;
    int x;
    int zb;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    int f355ms = Integer.MAX_VALUE;
    int xr = Integer.MAX_VALUE;
    int ah = Integer.MIN_VALUE;
    int d = Integer.MIN_VALUE;
    List<Integer> u = new ArrayList();

    ah() {
    }

    public int ms() {
        return this.ab;
    }

    public int xr() {
        return this.x - this.ny;
    }

    void ms(View view, int i, int i2, int i3, int i4) {
        xr xrVar = (xr) view.getLayoutParams();
        this.f355ms = Math.min(this.f355ms, (view.getLeft() - xrVar.zb()) - i);
        this.xr = Math.min(this.xr, (view.getTop() - xrVar.u()) - i2);
        this.ah = Math.max(this.ah, view.getRight() + xrVar.ub() + i3);
        this.d = Math.max(this.d, view.getBottom() + xrVar.ao() + i4);
    }
}
