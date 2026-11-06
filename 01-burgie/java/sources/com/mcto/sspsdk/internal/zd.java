package com.mcto.sspsdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.mcto.sspsdk.IQYNative;
import com.mcto.sspsdk.QyAdSlot;
import com.mcto.sspsdk.ssp.callback.AdErrorCallback;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zd implements IQYNative {
    public final Context a;

    public zd(Context context) {
        this.a = context;
    }

    public static boolean a(String str, AdErrorCallback adErrorCallback) {
        if (!lj.b(str) || adErrorCallback == null) {
            return false;
        }
        adErrorCallback.onError(6, "code id or load callback is null");
        return true;
    }

    @Override // com.mcto.sspsdk.IQYNative
    public final void loadBannerAd(QyAdSlot qyAdSlot, IQYNative.BannerAdListener bannerAdListener) {
        if (a(qyAdSlot.getCodeId(), bannerAdListener)) {
            return;
        }
        qyAdSlot.getCodeId();
        Context context = this.a;
        yd ydVar = new yd(bannerAdListener);
        HashMap map = c0.k;
        b0 b0Var = new b0();
        b0Var.d = 2;
        b0Var.h = true;
        b0Var.a = qyAdSlot;
        b0Var.c = gj.a(qyAdSlot.h());
        b0Var.b = new b2(ydVar, context, qyAdSlot);
        new c0(b0Var).b();
    }

    @Override // com.mcto.sspsdk.IQYNative
    public final void loadFullScreenAd(QyAdSlot qyAdSlot, IQYNative.FullScreenAdListener fullScreenAdListener) {
        if (a(qyAdSlot.getCodeId(), fullScreenAdListener)) {
            return;
        }
        qyAdSlot.getCodeId();
        if (!rd.a()) {
            Context context = this.a;
            t6 t6Var = new t6(fullScreenAdListener);
            HashMap map = c0.k;
            b0 b0Var = new b0();
            b0Var.d = 8;
            b0Var.h = true;
            b0Var.a = qyAdSlot;
            b0Var.c = gj.a(qyAdSlot.h());
            b0Var.b = new i6(qyAdSlot, context, t6Var);
            new c0(b0Var).b();
            return;
        }
        Context context2 = this.a;
        t6 t6Var2 = new t6(fullScreenAdListener);
        if (!(context2 instanceof Activity)) {
            throw new IllegalArgumentException("For full-screen ads, when calling QyClient.createAdNative to get IQYNative, the context parameter needs to use activity");
        }
        lk lkVar = new lk(new j6(qyAdSlot, context2, t6Var2));
        lkVar.k = qyAdSlot;
        lkVar.l = 8;
        HashMap map2 = c0.k;
        b0 b0Var2 = new b0();
        b0Var2.d = 8;
        b0Var2.h = true;
        b0Var2.a = qyAdSlot;
        b0Var2.c = gj.a(qyAdSlot.h());
        b0Var2.b = new jk(lkVar);
        new c0(b0Var2).b();
        xk xkVarA = xk.a();
        kk kkVar = new kk(lkVar);
        xkVarA.getClass();
        zg.a.a(new wk(xkVarA, kkVar));
    }

    @Override // com.mcto.sspsdk.IQYNative
    public final void loadNativeAd(QyAdSlot qyAdSlot, IQYNative.QYNativeAdListener qYNativeAdListener) {
        if (rd.a() || !a(qyAdSlot.getCodeId(), qYNativeAdListener)) {
            Context context = this.a;
            int adType = qyAdSlot.getAdType();
            if (adType != 2) {
                if (adType != 3) {
                    qYNativeAdListener.onError(10, "ad type is not support.");
                    return;
                }
                ki kiVar = new ki(context, qyAdSlot, qYNativeAdListener);
                kiVar.e.postDelayed(kiVar.g, Math.max(kiVar.a.getTimeOut(), 1380));
                new fi().a(kiVar.a, 100, kiVar);
                return;
            }
            m2 m2Var = new m2(context, qyAdSlot, qYNativeAdListener);
            HashMap map = c0.k;
            b0 b0Var = new b0();
            QyAdSlot qyAdSlot2 = m2Var.a;
            b0Var.a = qyAdSlot2;
            b0Var.c = gj.a(qyAdSlot2.h());
            b0Var.f = 100;
            b0Var.d = 2;
            b0Var.b = m2Var;
            new c0(b0Var).b();
        }
    }

    @Override // com.mcto.sspsdk.IQYNative
    public final void loadRewardVideoAd(QyAdSlot qyAdSlot, IQYNative.RewardVideoAdListener rewardVideoAdListener) {
        if (a(qyAdSlot.getCodeId(), rewardVideoAdListener)) {
            return;
        }
        qyAdSlot.getCodeId();
        q9 q9Var = p9.a;
        synchronized (q9Var) {
            q9Var.a = new StringBuilder();
        }
        Context context = this.a;
        ng ngVar = new ng(rewardVideoAdListener);
        String mediaExtra = qyAdSlot.getMediaExtra();
        boolean z = true;
        if (!TextUtils.isEmpty(mediaExtra)) {
            try {
                if (new JSONObject(mediaExtra).optInt("funType", 1) != 1) {
                    z = false;
                }
            } catch (Exception e) {
            }
        }
        HashMap map = c0.k;
        b0 b0Var = new b0();
        b0Var.a = qyAdSlot;
        b0Var.c = gj.a(qyAdSlot.h());
        b0Var.d = z ? 4 : 5;
        b0Var.h = rd.a();
        b0Var.b = new kg(ngVar, z, context, qyAdSlot);
        new c0(b0Var).b();
    }

    @Override // com.mcto.sspsdk.IQYNative
    public final void loadSplashAd(QyAdSlot qyAdSlot, IQYNative.SplashAdListener splashAdListener) {
        if (rd.a() || !a(qyAdSlot.getCodeId(), splashAdListener)) {
            qyAdSlot.getCodeId();
            di diVar = new di(this.a);
            diVar.a = splashAdListener;
            diVar.b = qyAdSlot;
            diVar.d.postDelayed(diVar.f, Math.max(qyAdSlot.getTimeOut(), 1380));
            new fi().a(qyAdSlot, 0, diVar);
        }
    }
}
