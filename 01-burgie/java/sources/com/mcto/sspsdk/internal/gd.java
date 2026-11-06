package com.mcto.sspsdk.internal;

import android.animation.ValueAnimator;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.component.button.DownloadButtonView;
import com.mcto.sspsdk.component.webview.QyWebViewDataBean;
import com.mcto.sspsdk.component.webview.QyWebViewPanel;

/* JADX INFO: loaded from: classes2.dex */
public final class gd extends cd implements of {
    public final String g;
    public final int h;
    public final String i;
    public final p j;
    public QyWebViewPanel k;
    public int[] l;
    public me m;
    public final long[] n;

    public gd(AppCompatActivity appCompatActivity, p pVar, e eVar) {
        super(appCompatActivity, eVar);
        this.n = new long[2];
        setId(R.id.qy_card_view);
        this.j = pVar;
        this.i = pVar.i().optString("apkName");
        this.g = pVar.E;
        this.h = pVar.S0;
    }

    @Override // com.mcto.sspsdk.internal.cd
    public final void a(int i, int i2) {
        if (i != 4) {
            if (i != 8) {
                return;
            }
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(getMeasuredHeight(), hk.b(this.a) - hk.a(this.a));
            valueAnimatorOfFloat.setDuration(500L);
            valueAnimatorOfFloat.addUpdateListener(new fd(this));
            valueAnimatorOfFloat.start();
            a(this.c.a(-1));
            return;
        }
        pf pfVar = new pf(this.a);
        pfVar.setId(R.id.qy_card_webview_container);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, 0);
        int i3 = R.id.qy_card_view;
        layoutParams.topToTop = i3;
        if (this.h == 3) {
            layoutParams.bottomToTop = R.id.qy_card_download_btn;
        } else {
            layoutParams.bottomToBottom = i3;
        }
        addView(pfVar, layoutParams);
        p pVar = this.j;
        QyWebViewDataBean qyWebViewDataBeanA = QyWebViewDataBean.a(pVar.f0, pVar);
        qyWebViewDataBeanA.p();
        qyWebViewDataBeanA.q();
        qyWebViewDataBeanA.r();
        QyWebViewPanel qyWebViewPanel = new QyWebViewPanel(this.a);
        this.k = qyWebViewPanel;
        qyWebViewPanel.a(qyWebViewDataBeanA);
        this.k.a(this);
        pfVar.addView(this.k);
        if (this.h == 3) {
            int iMin = Math.min(this.a.getResources().getDisplayMetrics().widthPixels, this.a.getResources().getDisplayMetrics().heightPixels) - hk.a(this.a, 20.0f);
            int iA = hk.a(this.a, 42.0f);
            DownloadButtonView downloadButtonView = new DownloadButtonView(getContext());
            this.b = downloadButtonView;
            downloadButtonView.setId(R.id.qy_card_download_btn);
            this.b.setWidth(iMin);
            this.b.setHeight(iA);
            this.b.setTextSize(1, 20.0f);
            this.b.b(hk.a(getContext(), 4.0f));
            if (this.h == 3) {
                h hVar = new h(this.b);
                hVar.a(this.g, this.i);
                this.b.a(hVar);
            }
            ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
            int i4 = R.id.qy_card_view;
            layoutParams2.bottomToBottom = i4;
            layoutParams2.topToBottom = R.id.qy_card_webview_container;
            layoutParams2.rightToRight = i4;
            layoutParams2.leftToLeft = i4;
            layoutParams2.bottomMargin = hk.a(this.a, 20.0f);
            layoutParams2.topMargin = hk.a(this.a, 10.0f);
            addView(this.b, layoutParams2);
        }
        int iB = hk.b(this.a) - hk.a(this.a);
        int i5 = iB - ((this.a.getResources().getDisplayMetrics().widthPixels * 9) / 16);
        if (i2 == 10) {
            this.l = new int[]{(iB * 4) / 10, i5};
            pfVar.a = true;
            pfVar.c = new dd(this);
        } else {
            this.l = new int[]{i5, i5};
        }
        pfVar.b.add(new ed(this));
        a(this.c.a(0));
    }

    @Override // com.mcto.sspsdk.internal.cd
    public final void b() {
        a();
        QyWebViewPanel qyWebViewPanel = this.k;
        if (qyWebViewPanel != null) {
            qyWebViewPanel.c();
        }
    }

    @Override // com.mcto.sspsdk.internal.cd
    public final boolean c() {
        QyWebViewPanel qyWebViewPanel = this.k;
        if (qyWebViewPanel == null || !qyWebViewPanel.b()) {
            return false;
        }
        this.k.e();
        return true;
    }

    public final void f() {
        z3 z3Var = z3.HALF_WEBVIEW;
        a4 a4Var = new a4();
        a4Var.b = z3Var;
        QyWebViewPanel qyWebViewPanel = this.k;
        a4Var.a = qyWebViewPanel;
        a4Var.e = gj.a(qyWebViewPanel);
        this.m.a.b(new b4(a4Var));
    }

    @Override // com.mcto.sspsdk.internal.cd
    public final void a(me meVar) {
        this.m = meVar;
    }
}
