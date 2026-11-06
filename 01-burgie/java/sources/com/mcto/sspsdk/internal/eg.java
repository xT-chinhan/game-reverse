package com.mcto.sspsdk.internal;

import android.text.TextUtils;
import com.mcto.sspsdk.IQyRewardVideoAd;
import com.mcto.sspsdk.QyRewardProperty;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class eg implements Runnable {
    public final /* synthetic */ fg a;

    public eg(fg fgVar) {
        this.a = fgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ig igVar = this.a.a;
        if (igVar.h.compareAndSet(false, true)) {
            HashMap<String, Object> map = new HashMap<>(4);
            map.put(QyRewardProperty.VERIFY_TYPE, QyRewardProperty.VERIFY_TYPE_REAL);
            map.put(QyRewardProperty.VERIFY_IMPRESSIONID, igVar.b.n0);
            map.put(QyRewardProperty.VERIFY_VIDEOID, igVar.a.getVideoId());
            map.put(QyRewardProperty.VERIFY_ALBUMID, igVar.a.getAlbumId());
            if (igVar.b.V > 0) {
                map.put(QyRewardProperty.VERIFY_REWARD_AMOUNT, "" + igVar.b.V);
            }
            if (!TextUtils.isEmpty(igVar.b.K0)) {
                map.put(QyRewardProperty.VERIFY_REWARD_MESSAGE, igVar.b.K0);
            }
            map.put(QyRewardProperty.RISK_LEVEL, Integer.valueOf(ug.a().a));
            r9.a("ssp_reward", "onRewardVerify", null);
            p9.a.a(Integer.valueOf(igVar.b.a), "onRewardVerify()");
            IQyRewardVideoAd.IAdInteractionListener iAdInteractionListener = igVar.d;
            if (iAdInteractionListener != null) {
                iAdInteractionListener.onRewardVerify(map);
            }
        }
    }
}
