package com.mcto.sspsdk.internal;

import android.view.View;
import com.mcto.unionsdk.QiNativeAd;

/* JADX INFO: loaded from: classes2.dex */
public final class mc implements QiNativeAd.AdEventListener {
    public final /* synthetic */ pc a;

    public mc(pc pcVar) {
        this.a = pcVar;
    }

    public final void onAdButtonClick(View view, QiNativeAd qiNativeAd) {
        p pVar = this.a.c;
        a4 a4Var = new a4();
        a4Var.a = view;
        a4Var.b = z3.GRAPHIC;
        a4Var.e = gj.a(view);
        this.a.b(new b4(a4Var));
    }

    public final void onAdClicked(View view, QiNativeAd qiNativeAd) {
        p pVar = this.a.c;
        a4 a4Var = new a4();
        a4Var.a = view;
        a4Var.b = z3.GRAPHIC;
        a4Var.e = gj.a(view);
        this.a.b(new b4(a4Var));
    }

    public final void onAdShow(QiNativeAd qiNativeAd) {
        pc pcVar = this.a;
        p pVar = pcVar.c;
        pcVar.j();
    }

    public final void onAdStatusChanged(int i, QiNativeAd qiNativeAd) {
    }

    public final void onAdVideoStatusChanged(int i, long j, long j2, String str, QiNativeAd qiNativeAd) {
    }
}
