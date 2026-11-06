package com.byazt.kg;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1238, 13})
public class w {
    public List<s> n;
    public com.byazt.ih.s q;
    public List<n> qg;
    public Context s;

    public w(Context context, com.byazt.ih.s sVar, List<s> list) {
        this.q = sVar;
        this.s = context;
        this.n = list;
        q();
    }

    private void q() {
        this.qg = new ArrayList();
        List<s> list = this.n;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.n.size(); i++) {
            s sVar = this.n.get(i);
            if (sVar != null) {
                this.qg.add(new n(this.s, this.q, sVar));
            }
        }
    }

    public void n() {
        List<n> list = this.qg;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (n nVar : this.qg) {
            if (nVar != null) {
                nVar.q();
            }
        }
    }

    public void qg() {
        List<n> list = this.qg;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (n nVar : this.qg) {
            if (nVar != null) {
                nVar.n();
            }
        }
    }

    public void s() {
        List<n> list = this.qg;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (n nVar : this.qg) {
            if (nVar != null) {
                nVar.s();
            }
        }
    }

    public void n(Canvas canvas) {
        List<n> list = this.qg;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (n nVar : this.qg) {
            if (nVar != null) {
                nVar.n(canvas);
            }
        }
    }

    public void qg(Canvas canvas) {
        List<n> list = this.qg;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (n nVar : this.qg) {
            if (nVar != null) {
                nVar.qg(canvas);
            }
        }
    }

    public void n(int i, int i2) {
        List<n> list = this.qg;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (n nVar : this.qg) {
            if (nVar != null) {
                nVar.n(i, i2);
            }
        }
    }

    public n n(String str) {
        List<n> list = this.qg;
        if (list != null && !list.isEmpty()) {
            for (n nVar : this.qg) {
                if (nVar != null && TextUtils.equals(nVar.l(), str)) {
                    return nVar;
                }
            }
        }
        return null;
    }
}
