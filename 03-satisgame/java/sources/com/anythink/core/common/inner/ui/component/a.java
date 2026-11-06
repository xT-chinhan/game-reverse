package com.anythink.core.common.inner.ui.component;

import android.view.View;
import com.anythink.core.basead.ui.web.WebProgressBarView;
import com.anythink.core.common.h.y;
import com.anythink.core.common.inner.ui.CountDownView;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    CountDownView a;
    WebProgressBarView b;
    int c = 4;
    private y d;
    private long e;

    public a(y yVar, CountDownView countDownView, WebProgressBarView webProgressBarView) {
        this.d = yVar;
        this.a = countDownView;
        this.b = webProgressBarView;
    }

    public final void a(long j) {
        this.e = j;
        CountDownView countDownView = this.a;
        if (countDownView != null) {
            countDownView.setDuration(j);
        }
    }

    public final void b(long j) {
        CountDownView countDownView = this.a;
        if (countDownView != null) {
            countDownView.refresh(j);
        }
        WebProgressBarView webProgressBarView = this.b;
        if (webProgressBarView != null) {
            long j2 = this.e;
            if (j2 > 0) {
                webProgressBarView.setProgress((int) ((j * 100.0d) / j2));
            } else {
                webProgressBarView.setProgress(100);
            }
        }
    }

    public final void a() {
        CountDownView countDownView = this.a;
        if (countDownView != null) {
            countDownView.refreshToEnd();
        }
        WebProgressBarView webProgressBarView = this.b;
        if (webProgressBarView != null) {
            webProgressBarView.setProgress(100);
        }
    }

    public final void a(int i) {
        this.c = i;
        if (this.d.N() == 1 || this.d.N() == 4) {
            a(this.a, i);
        } else {
            a(this.a, 8);
        }
        if (this.d.N() == 2 || this.d.N() == 4) {
            a(this.b, i);
        } else {
            a(this.b, 8);
        }
    }

    private boolean b() {
        return this.d.N() == 1 || this.d.N() == 4;
    }

    private boolean c() {
        return this.d.N() == 2 || this.d.N() == 4;
    }

    private static void a(View view, int i) {
        if (view == null || view.getVisibility() == i) {
            return;
        }
        view.setVisibility(i);
    }
}
