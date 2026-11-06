package com.mcto.sspsdk.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.bykv.vk.component.ttvideo.player.C;
import com.mcto.sspsdk.IQyRewardVideoAd;
import com.mcto.sspsdk.QyAdSlot;
import com.mcto.sspsdk.ssp.activity.QyRewardActivity;
import com.mcto.sspsdk.ssp.activity.QyTrueViewActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class dg extends jg {
    public final pg e;
    public final boolean f;

    public dg(Context context, QyAdSlot qyAdSlot, p pVar, boolean z) {
        super(qyAdSlot, pVar);
        this.f = z;
        if (z) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(pVar);
            this.e = new pg(arrayList, qyAdSlot);
        } else {
            ArrayList arrayList2 = pVar.c.b;
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(new rg(context, qyAdSlot, (p) it.next()));
            }
            this.e = new pg(arrayList3, qyAdSlot);
        }
        HashMap map = this.b.i0;
        Object obj = map != null ? map.get(ak.a(5)) : null;
        if (obj != null) {
            p9.a.a(Integer.valueOf(pVar.a), obj);
        } else {
            p9.a.a(Integer.valueOf(pVar.a), "st_url_nil");
        }
    }

    @Override // com.mcto.sspsdk.IQyRewardVideoAd
    public final void destroy() {
        this.d = null;
    }

    @Override // com.mcto.sspsdk.IQyRewardVideoAd
    public final boolean isValid() {
        p pVar;
        return (this.c.get() || (pVar = this.b) == null || pVar.E0 < System.currentTimeMillis()) ? false : true;
    }

    @Override // com.mcto.sspsdk.IQyRewardVideoAd
    public final boolean showRewardVideoAd(Activity activity) {
        Intent intent;
        if (activity == null) {
            IQyRewardVideoAd.IAdInteractionListener iAdInteractionListener = this.d;
            if (iAdInteractionListener != null) {
                iAdInteractionListener.onVideoError(2, "context or ad info is error when render");
            }
            return false;
        }
        try {
            pg pgVar = this.e;
            pgVar.c = this.d;
            og.a.set(pgVar);
            if (this.f) {
                intent = new Intent(activity, (Class<?>) QyTrueViewActivity.class);
            } else {
                intent = new Intent(activity, (Class<?>) QyRewardActivity.class);
                intent.putExtra("orientation", activity.getResources().getConfiguration().orientation);
            }
            intent.addFlags(C.ENCODING_PCM_MU_LAW);
            activity.startActivity(intent);
            this.c.set(true);
            p9.a.a(Integer.valueOf(this.b.a), "renderTrueView()");
            return true;
        } catch (Exception e) {
            r9.a("ssp_reward", "render trueView:", e);
            IQyRewardVideoAd.IAdInteractionListener iAdInteractionListener2 = this.d;
            if (iAdInteractionListener2 != null) {
                iAdInteractionListener2.onVideoError(14, e.getMessage());
            }
            return false;
        }
    }
}
