package com.mcto.sspsdk.internal;

import android.app.Activity;
import com.mcto.sspsdk.IQyFullScreenAd;
import com.mcto.unionsdk.QiAd;
import com.mcto.unionsdk.QiAdnAd;
import com.qq.e.comm.pi.IBidding;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class uk implements IQyFullScreenAd {
    public final bl a;
    public final vh b;
    public IQyFullScreenAd.AdInteractionListener c;

    public uk(bl blVar, vh vhVar) {
        this.a = blVar;
        this.b = vhVar;
        blVar.a.setInteractionListener(new tk(this));
    }

    @Override // com.mcto.sspsdk.IQyFullScreenAd
    public final void destroy() {
        bl blVar = this.a;
        if (blVar != null) {
            blVar.a.destroy();
        }
    }

    @Override // com.mcto.sspsdk.IQyFullScreenAd, com.mcto.sspsdk.internal.l7
    public final Map getAdExtra() {
        if (this.b == null || !rd.a()) {
            return this.a.i;
        }
        HashMap map = this.a.i;
        map.put("tunnel", this.b.p);
        return map;
    }

    @Override // com.mcto.sspsdk.IQyFullScreenAd
    public final boolean isValid() {
        QiAdnAd qiAdnAd;
        bl blVar = this.a;
        if (blVar == null || (qiAdnAd = blVar.a) == null) {
            return false;
        }
        return qiAdnAd.isValid();
    }

    @Override // com.mcto.sspsdk.IQyFullScreenAd, com.mcto.sspsdk.internal.l7
    public final void loss(Map map) {
        if (this.b != null) {
            zj zjVarA = zj.a();
            vh vhVar = this.b;
            zjVarA.getClass();
            ArrayList<p> arrayList = vhVar.c;
            if (arrayList == null) {
                return;
            }
            Object obj = map.get(IBidding.ADN_ID);
            AtomicInteger atomicInteger = gj.a;
            boolean z = !(obj == null ? true : lj.b(String.valueOf(obj)));
            for (p pVar : arrayList) {
                if (pVar.e(1)) {
                    pVar.O0 = z;
                    zjVarA.a(1, pVar, "cupidTracking");
                }
            }
        }
    }

    @Override // com.mcto.sspsdk.IQyFullScreenAd
    public final void setAdInteractionListener(IQyFullScreenAd.AdInteractionListener adInteractionListener) {
        this.c = adInteractionListener;
    }

    @Override // com.mcto.sspsdk.IQyFullScreenAd
    public final void showAd(Activity activity) {
        QiAd qiAd = this.a.a;
        if (qiAd == null || !qiAd.isValid()) {
            r9.a("ssp_sdk", "ad is invalid!!!!", null);
            za zaVarD = za.d();
            String str = this.a.n;
            String str2 = "adt:7;" + this.a.b();
            zaVarD.getClass();
            za.a(41, (p) null, str, "show_invalid", str2);
            return;
        }
        qiAd.show(activity);
        za zaVarD2 = za.d();
        String str3 = this.a.n;
        String str4 = "adt:7;" + this.a.b();
        zaVarD2.getClass();
        za.a(41, (p) null, str3, "show", str4);
    }

    @Override // com.mcto.sspsdk.IQyFullScreenAd
    public final void win(Map map) {
    }
}
