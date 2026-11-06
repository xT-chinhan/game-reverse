package com.byazt.gqi;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 600, 20})
public class hn {
    public int aj;
    public int c;
    public int fw;
    public int ho;
    public int k;
    public boolean lb;
    public int m;
    public int nt;
    public int uc;
    public float vk;
    public float w;
    public boolean yb;
    public int zo;
    public int pr = Integer.MAX_VALUE;
    public int hw = Integer.MAX_VALUE;
    public int hn = Integer.MIN_VALUE;
    public int x = Integer.MIN_VALUE;
    public List<Integer> g = new ArrayList();

    public int pr() {
        return this.fw;
    }

    public int hw() {
        return this.zo - this.aj;
    }

    public void pr(View view, int i, int i2, int i3, int i4) {
        hw hwVar = (hw) view.getLayoutParams();
        this.pr = Math.min(this.pr, (view.getLeft() - hwVar.m()) - i);
        this.hw = Math.min(this.hw, (view.getTop() - hwVar.g()) - i2);
        this.hn = Math.max(this.hn, view.getRight() + hwVar.ho() + i3);
        this.x = Math.max(this.x, view.getBottom() + hwVar.nt() + i4);
    }
}
