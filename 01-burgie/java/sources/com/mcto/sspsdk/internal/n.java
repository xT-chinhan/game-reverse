package com.mcto.sspsdk.internal;

import android.view.View;
import com.mcto.sspsdk.component.button.DownloadButtonView;
import com.mcto.unionsdk.QiNativeAd;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements QiNativeAd.AdEventListener {
    public final /* synthetic */ o a;

    public n(o oVar) {
        this.a = oVar;
    }

    public final void onAdButtonClick(View view, QiNativeAd qiNativeAd) {
        onAdClicked(view, qiNativeAd);
    }

    public final void onAdClicked(View view, QiNativeAd qiNativeAd) {
        a4 a4Var = new a4();
        a4Var.b = z3.GRAPHIC;
        this.a.a(new b4(a4Var));
    }

    public final void onAdShow(QiNativeAd qiNativeAd) {
        this.a.b();
    }

    public final void onAdStatusChanged(int i, QiNativeAd qiNativeAd) {
        int i2;
        o oVar = this.a;
        int apkDownloadProgress = qiNativeAd.getApkDownloadProgress();
        DownloadButtonView downloadButtonView = oVar.d;
        if (downloadButtonView == null) {
            return;
        }
        switch (i) {
            case 1:
                i2 = 1;
                break;
            case 2:
                i2 = 2;
                break;
            case 3:
            case 4:
            default:
                i2 = 0;
                break;
            case 5:
                i2 = 5;
                break;
            case 6:
                i2 = 6;
                break;
            case 7:
                i2 = 7;
                break;
        }
        downloadButtonView.d(i2);
        if (i2 == 1) {
            oVar.d.c(apkDownloadProgress);
        }
    }

    public final void onAdVideoStatusChanged(int i, long j, long j2, String str, QiNativeAd qiNativeAd) {
    }
}
