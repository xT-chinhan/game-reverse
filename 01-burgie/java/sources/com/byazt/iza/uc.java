package com.byazt.iza;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 124, 5})
public class uc {
    public Context hn;
    public List<pr> hw;
    public List<hn> pr;
    public com.byazt.ik.hn x;

    public uc(Context context, com.byazt.ik.hn hnVar, List<hn> list) {
        this.x = hnVar;
        this.hn = context;
        this.pr = list;
        x();
    }

    private void x() {
        this.hw = new ArrayList();
        List<hn> list = this.pr;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.pr.size(); i++) {
            hn hnVar = this.pr.get(i);
            if (hnVar != null) {
                this.hw.add(new pr(this.hn, this.x, hnVar));
            }
        }
    }

    public void pr() {
        List<pr> list = this.hw;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (pr prVar : this.hw) {
            if (prVar != null) {
                prVar.x();
            }
        }
    }

    public void hw() {
        List<pr> list = this.hw;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (pr prVar : this.hw) {
            if (prVar != null) {
                prVar.pr();
            }
        }
    }

    public void hn() {
        List<pr> list = this.hw;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (pr prVar : this.hw) {
            if (prVar != null) {
                prVar.hn();
            }
        }
    }

    public void pr(Canvas canvas) {
        List<pr> list = this.hw;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (pr prVar : this.hw) {
            if (prVar != null) {
                prVar.pr(canvas);
            }
        }
    }

    public void hw(Canvas canvas) {
        List<pr> list = this.hw;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (pr prVar : this.hw) {
            if (prVar != null) {
                prVar.hw(canvas);
            }
        }
    }

    public void pr(int i, int i2) {
        List<pr> list = this.hw;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (pr prVar : this.hw) {
            if (prVar != null) {
                prVar.pr(i, i2);
            }
        }
    }

    public pr pr(String str) {
        List<pr> list = this.hw;
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (pr prVar : this.hw) {
            if (prVar != null && TextUtils.equals(prVar.c(), str)) {
                return prVar;
            }
        }
        return null;
    }
}
