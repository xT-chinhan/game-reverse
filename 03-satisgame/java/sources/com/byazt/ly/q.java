package com.byazt.ly;

import android.content.Context;
import android.view.ViewGroup;
import com.byazt.gct.pk;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 119, 5})
public class q extends com.byazt.qs.qg {
    public boolean f;

    @Override // com.byazt.qs.qg, com.byazt.zx.n
    public int m() {
        return 4;
    }

    public q(Context context, ViewGroup viewGroup, pk pkVar) {
        super(context, viewGroup, pkVar, null);
        n(false);
    }

    @Override // com.byazt.zx.n
    public void w(boolean z) {
        super.w(z);
    }

    public boolean hu() {
        return hd() != null && hd().d();
    }

    public boolean h() {
        return this.f;
    }

    public void x(boolean z) {
        this.f = z;
    }

    @Override // com.byazt.qs.qg, com.byazt.zx.n, com.byazt.iag.s
    public void fs() {
        if (this.f) {
            return;
        }
        super.fs();
    }

    @Override // com.byazt.zx.n, com.byazt.iag.s
    public void tj() {
        this.f = false;
        super.tj();
    }
}
