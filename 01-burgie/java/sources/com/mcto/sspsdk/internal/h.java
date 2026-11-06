package com.mcto.sspsdk.internal;

import android.text.TextUtils;
import android.view.View;
import com.mcto.sspsdk.component.button.DownloadButtonView;

/* JADX INFO: loaded from: classes2.dex */
public final class h {
    public final DownloadButtonView a;
    public c1 b;
    public u0 c = null;
    public final g d;
    public yc e;
    public String f;
    public String g;

    public h(DownloadButtonView downloadButtonView) {
        this.b = null;
        this.a = downloadButtonView;
        if (downloadButtonView == null) {
            throw new NullPointerException("DownloadButtonView can not be NULL!");
        }
        downloadButtonView.a(this);
        this.b = c1.a();
        this.d = new g(this);
    }

    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            this.a.setVisibility(8);
            return;
        }
        this.f = str;
        this.g = str2;
        this.a.setVisibility(0);
        if (!TextUtils.isEmpty(this.g)) {
            this.a.a(this.g);
        }
        this.a.d(0);
    }

    public final void b(s0 s0Var) {
        try {
            int i = s0Var.a;
            this.a.d(i);
            if (i == 1) {
                this.a.c((int) s0Var.b);
            } else if (i == 5) {
                this.a.a(s0Var.c);
            }
            a(s0Var);
        } catch (Exception e) {
            r9.a("ssp_sdk", "updateDownloadButton", e);
        }
    }

    public final void a() {
        u0 u0Var = this.c;
        if (u0Var != null && u0Var != null) {
            if (this.b == null) {
                this.b = c1.a();
            }
            c1 c1Var = this.b;
            if (c1Var != null) {
                c1Var.b(this.c, this.d);
            }
            this.c = null;
        }
        if (this.f == null) {
            return;
        }
        if (this.b == null) {
            this.b = c1.a();
        }
        c1 c1Var2 = this.b;
        if (c1Var2 != null) {
            t0 t0Var = new t0();
            t0Var.i = this.g;
            t0Var.d = this.f;
            u0 u0Var2 = new u0(t0Var);
            this.c = u0Var2;
            s0 s0VarA = c1Var2.a(u0Var2, this.d);
            if (s0VarA != null) {
                b(s0VarA);
            }
        }
    }

    public final void a(s0 s0Var) {
        yc ycVar = this.e;
        if (ycVar != null) {
            bd bdVar = ycVar.a;
            if (bdVar.v == null) {
                return;
            }
            if (s0Var.a == 1) {
                bdVar.b.a(false);
                ycVar.a.v.setVisibility(4);
                View view = ycVar.a.x;
                if (view != null) {
                    view.setVisibility(4);
                    return;
                }
                return;
            }
            bdVar.b.a(true);
            ycVar.a.v.setVisibility(0);
            View view2 = ycVar.a.x;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            bd bdVar2 = ycVar.a;
            bdVar2.v.setText(String.format("%s%s", bdVar2.l, bdVar2.b.b()));
        }
    }
}
