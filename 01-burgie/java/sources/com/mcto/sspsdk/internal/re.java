package com.mcto.sspsdk.internal;

import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

/* JADX INFO: loaded from: classes2.dex */
public final class re {
    public final /* synthetic */ ve a;

    public re(ve veVar) {
        this.a = veVar;
    }

    public final void a(j7 j7Var) {
        j7 j7Var2;
        this.a.f(0);
        if (j7Var.g() == 1) {
            ve veVar = this.a;
            if (veVar.n != null && !veVar.Q.get() && !veVar.w && (((j7Var2 = veVar.D) == null || !j7Var2.c() || veVar.D.g() != 1) && veVar.R)) {
                gf gfVar = veVar.n;
                gfVar.c = false;
                gfVar.a(8);
                ImageView imageView = gfVar.y;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
                gfVar.c();
            }
            this.a.d();
        }
        ve veVar2 = this.a;
        if (veVar2.g == null || !veVar2.hasWindowFocus()) {
            return;
        }
        j7 j7Var3 = veVar2.D;
        if (j7Var3 == null || !j7Var3.c()) {
            veVar2.g.d();
        }
    }

    public final void b(j7 j7Var) {
        int i;
        ve veVar = this.a;
        veVar.i.bringToFront();
        ProgressBar progressBar = veVar.o;
        if (progressBar != null) {
            progressBar.bringToFront();
        }
        TextView textView = veVar.j;
        if (textView != null) {
            textView.bringToFront();
        }
        this.a.f(4);
        this.a.a(j7Var);
        if (j7Var.g() == 1) {
            gf gfVar = this.a.n;
            if (gfVar.s != null && (i = gfVar.a) != -1 && i != 0 && i != 1) {
                gfVar.c = true;
                gfVar.a();
            }
            le leVar = this.a.x;
            if (leVar != null) {
                leVar.a();
            }
        }
        cd cdVar = this.a.g;
        if (cdVar != null) {
            cdVar.e();
        }
    }
}
