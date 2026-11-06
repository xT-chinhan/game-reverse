package com.mcto.sspsdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.mcto.sspsdk.IQyRewardVideoAd;
import com.mcto.sspsdk.QyRewardProperty;
import com.mcto.unionsdk.QiAd;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class fg implements QiAd.InteractionListener {
    public final /* synthetic */ ig a;

    public fg(ig igVar) {
        this.a = igVar;
    }

    public final void onAdClick() {
        if (this.a.b != null) {
            HashMap map = new HashMap(1);
            map.put(v5.KEY_CLICK_AREA, z3.GRAPHIC);
            l lVarA = l.a();
            p pVar = this.a.b;
            lVarA.getClass();
            l.a(21, pVar, map);
        }
        IQyRewardVideoAd.IAdInteractionListener iAdInteractionListener = this.a.d;
        if (iAdInteractionListener != null) {
            iAdInteractionListener.onAdClick();
        }
    }

    public final void onAdClose() {
        p9.a.a(Integer.valueOf(this.a.b.a), "onAdClose()");
        IQyRewardVideoAd.IAdInteractionListener iAdInteractionListener = this.a.d;
        if (iAdInteractionListener != null) {
            iAdInteractionListener.onAdClose();
        }
        q9.a(22, this.a.b, null);
    }

    public final void onAdShow() {
        ig igVar = this.a;
        if (igVar.b != null) {
            igVar.f.set(true);
            int i = this.a.b.a;
            l lVarA = l.a();
            p pVar = this.a.b;
            lVarA.getClass();
            l.a(12, pVar, null);
            l lVarA2 = l.a();
            p pVar2 = this.a.b;
            lVarA2.getClass();
            l.a(13, pVar2, null);
            p9.a.a(Integer.valueOf(this.a.b.a), "onAdShow()");
        }
        IQyRewardVideoAd.IAdInteractionListener iAdInteractionListener = this.a.d;
        if (iAdInteractionListener != null) {
            iAdInteractionListener.onAdShow();
        }
    }

    public final void onDownloadStatusChanged(int i, int i2) {
        if (i == 0) {
            return;
        }
        if (i == 7) {
            q9 q9Var = p9.a;
            p pVar = this.a.b;
            q9Var.getClass();
            q9.a(35, pVar, null);
            return;
        }
        if (i == 5) {
            q9 q9Var2 = p9.a;
            p pVar2 = this.a.b;
            q9Var2.getClass();
            q9.a(34, pVar2, null);
            return;
        }
        q9 q9Var3 = p9.a;
        q9Var3.getClass();
        q9.a(33, this.a.b, "status:" + i + ";progress:" + i2);
    }

    public final void onRewardVerify(boolean z, int i, String str, int i2, String str2) {
        ig igVar = this.a;
        if (igVar.b != null && igVar.f.get()) {
            ig igVar2 = this.a;
            if (igVar2.d != null) {
                p pVar = igVar2.b;
                int i3 = pVar.a;
                if (pVar.q0 != 1) {
                    p9.a.a(Integer.valueOf(i3), "onRewardVerify()");
                    ig igVar3 = this.a;
                    if (igVar3.d != null && igVar3.h.compareAndSet(false, true)) {
                        HashMap<String, Object> map = new HashMap<>(4);
                        if (this.a.b.V > 0) {
                            map.put(QyRewardProperty.VERIFY_REWARD_AMOUNT, "" + this.a.b.V);
                        }
                        if (!TextUtils.isEmpty(this.a.b.K0)) {
                            map.put(QyRewardProperty.VERIFY_REWARD_MESSAGE, this.a.b.K0);
                        }
                        map.put(QyRewardProperty.RISK_LEVEL, Integer.valueOf(ug.a().a));
                        this.a.d.onRewardVerify(map);
                    }
                } else if (igVar2.g.compareAndSet(false, true)) {
                    l lVarA = l.a();
                    p pVar2 = this.a.b;
                    lVarA.getClass();
                    l.a(26, pVar2, null);
                    HashMap<String, Object> map2 = new HashMap<>(2);
                    map2.put(QyRewardProperty.VERIFY_TYPE, QyRewardProperty.VERIFY_TYPE_PRE);
                    HashMap map3 = this.a.b.i0;
                    Object obj = map3 != null ? map3.get(ak.a(14)) : null;
                    map2.put(QyRewardProperty.VERIFY_CHECK_INFO, obj);
                    map2.put(QyRewardProperty.VERIFY_IMPRESSIONID, this.a.b.n0);
                    if (this.a.b.V > 0) {
                        map2.put(QyRewardProperty.VERIFY_REWARD_AMOUNT, "" + this.a.b.V);
                    }
                    if (!TextUtils.isEmpty(this.a.b.K0)) {
                        map2.put(QyRewardProperty.VERIFY_REWARD_MESSAGE, this.a.b.K0);
                    }
                    map2.put(QyRewardProperty.RISK_LEVEL, Integer.valueOf(ug.a().a));
                    p9.a.a(Integer.valueOf(this.a.b.a), "onRewardVerify() pre", obj);
                    IQyRewardVideoAd.IAdInteractionListener iAdInteractionListener = this.a.d;
                    if (iAdInteractionListener != null) {
                        iAdInteractionListener.onRewardVerify(map2);
                    }
                    new Handler(Looper.getMainLooper()).postDelayed(new eg(this), this.a.b.r0);
                }
                za zaVarD = za.d();
                zaVarD.c();
                zaVarD.a();
                zaVarD.b();
                q9 q9Var = p9.a;
                p pVar3 = this.a.b;
                q9Var.getClass();
                q9.a(26, pVar3, null);
                return;
            }
        }
        this.a.f.get();
        p9.a.a(Integer.valueOf(this.a.b.a), "onRewardVerify() err", Boolean.valueOf(this.a.f.get()));
    }

    public final void onSkippedVideo() {
        p9.a.a(Integer.valueOf(this.a.b.a), "onAdSkip()");
        q9.a(24, this.a.b, null);
    }

    public final void onVideoComplete() {
        if (this.a.b != null) {
            l lVarA = l.a();
            p pVar = this.a.b;
            lVarA.getClass();
            l.a(18, pVar, null);
            p9.a.a(Integer.valueOf(this.a.b.a), "onVideoComplete()");
        }
        IQyRewardVideoAd.IAdInteractionListener iAdInteractionListener = this.a.d;
        if (iAdInteractionListener != null) {
            iAdInteractionListener.onVideoComplete();
        }
    }

    public final void onVideoError(int i, String str) {
        p9.a.a(Integer.valueOf(this.a.b.a), "onVideoError()", Integer.valueOf(i), str);
        ig igVar = this.a;
        IQyRewardVideoAd.IAdInteractionListener iAdInteractionListener = igVar.d;
        if (iAdInteractionListener != null) {
            iAdInteractionListener.onVideoError(13, gj.a(str, igVar.b.g, i));
        }
        q9.a(6, this.a.b, "code:" + i + ";msg:" + str);
    }
}
