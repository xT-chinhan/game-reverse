package com.mcto.sspsdk.internal;

import android.view.View;
import com.mcto.sspsdk.IQyBanner;
import com.mcto.sspsdk.component.button.DownloadButtonView;
import com.mcto.unionsdk.QiNativeAd;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class k2 implements QiNativeAd.AdEventListener {
    public final /* synthetic */ l2 a;

    public k2(l2 l2Var) {
        this.a = l2Var;
    }

    public final void onAdButtonClick(View view, QiNativeAd qiNativeAd) {
        int i = this.a.a.a;
        HashMap map = new HashMap(1);
        map.put(v5.KEY_CLICK_AREA, z3.BUTTON);
        l lVarA = l.a();
        p pVar = this.a.a;
        lVarA.getClass();
        l.a(21, pVar, map);
        IQyBanner.IAdInteractionListener iAdInteractionListener = this.a.c;
        if (iAdInteractionListener != null) {
            iAdInteractionListener.onAdClick();
        }
    }

    public final void onAdClicked(View view, QiNativeAd qiNativeAd) {
        int i = this.a.a.a;
        HashMap map = new HashMap(1);
        map.put(v5.KEY_CLICK_AREA, z3.GRAPHIC);
        l lVarA = l.a();
        p pVar = this.a.a;
        lVarA.getClass();
        l.a(21, pVar, map);
        IQyBanner.IAdInteractionListener iAdInteractionListener = this.a.c;
        if (iAdInteractionListener != null) {
            iAdInteractionListener.onAdClick();
        }
    }

    public final void onAdShow(QiNativeAd qiNativeAd) {
        int i = this.a.a.a;
        l lVarA = l.a();
        p pVar = this.a.a;
        lVarA.getClass();
        l.a(12, pVar, null);
        IQyBanner.IAdInteractionListener iAdInteractionListener = this.a.c;
        if (iAdInteractionListener != null) {
            iAdInteractionListener.onAdShow();
        }
    }

    public final void onAdStatusChanged(int i, QiNativeAd qiNativeAd) {
        int i2;
        int i3 = this.a.a.a;
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
        y2 y2Var = this.a.b;
        int apkDownloadProgress = qiNativeAd.getApkDownloadProgress();
        DownloadButtonView downloadButtonView = y2Var.d;
        if (downloadButtonView == null) {
            return;
        }
        downloadButtonView.d(i2);
        if (i2 == 1) {
            y2Var.d.c(apkDownloadProgress);
        }
    }

    public final void onAdVideoStatusChanged(int i, long j, long j2, String str, QiNativeAd qiNativeAd) {
    }
}
