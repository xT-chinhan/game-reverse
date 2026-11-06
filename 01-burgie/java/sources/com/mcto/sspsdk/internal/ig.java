package com.mcto.sspsdk.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.mcto.sspsdk.IQyRewardVideoAd;
import com.mcto.sspsdk.QyAdSlot;
import com.mcto.unionsdk.QiAd;
import com.mcto.unionsdk.QiClient;
import com.mcto.unionsdk.QiClientFactory;
import com.mcto.unionsdk.QiSlot;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class ig extends jg {
    public QiAd e;
    public final AtomicBoolean f;
    public final AtomicBoolean g;
    public final AtomicBoolean h;
    public final fg i;

    public ig(Context context, QyAdSlot qyAdSlot, p pVar, ng ngVar) {
        super(qyAdSlot, pVar);
        this.f = new AtomicBoolean(false);
        this.g = new AtomicBoolean(false);
        this.h = new AtomicBoolean(false);
        this.i = new fg(this);
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            QiClient qiClient = QiClientFactory.getQiClient(pVar.g, context);
            QiSlot qiSlotBuild = new QiSlot.Builder().codeId(pVar.u0).count(1).adType(4).orientation(qyAdSlot.getVideoAdOrientation() == 1 ? 1 : 2).token(pVar.e()).build();
            qiSlotBuild.setMute(qyAdSlot.isMute());
            r9.a("ssp_reward", "loadTemplateAd(): loading:" + pVar.n0 + ", adn :" + pVar.g, null);
            qiClient.loadTemplateAd(qiSlotBuild, new gg(this, pVar, ngVar, jCurrentTimeMillis));
        } catch (Throwable th) {
            r9.a("ssp_reward", "load():", th);
            ngVar.a(12, gj.a("adn type not support!", pVar.g, -999));
            za zaVarD = za.d();
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            zaVarD.getClass();
            za.a(pVar, jCurrentTimeMillis2, "adn type not support!", -999, false);
        }
    }

    @Override // com.mcto.sspsdk.IQyRewardVideoAd
    public final void destroy() {
        QiAd qiAd = this.e;
        if (qiAd != null) {
            qiAd.destroy();
            this.e = null;
        }
    }

    @Override // com.mcto.sspsdk.IQyRewardVideoAd
    public final boolean isValid() {
        if (this.c.get()) {
            return false;
        }
        p pVar = this.b;
        if (pVar.g == 5) {
            return this.e != null && pVar.E0 >= System.currentTimeMillis();
        }
        QiAd qiAd = this.e;
        return qiAd != null && qiAd.isValid();
    }

    @Override // com.mcto.sspsdk.IQyRewardVideoAd
    public final boolean showRewardVideoAd(Activity activity) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.e.show(activity);
            } else {
                kh.a.a(new hg(this, activity));
            }
            this.c.set(true);
            return true;
        } catch (Exception e) {
            r9.a("ssp_sdk", "showRewardVideoAd(): ", e);
            IQyRewardVideoAd.IAdInteractionListener iAdInteractionListener = this.d;
            if (iAdInteractionListener == null) {
                return false;
            }
            iAdInteractionListener.onVideoError(13, gj.a(e.getMessage(), this.b.g, -999));
            return false;
        }
    }
}
