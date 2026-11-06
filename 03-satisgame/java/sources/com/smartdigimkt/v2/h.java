package com.smartdigimkt.v2;

import android.content.Context;
import com.smartdigimkt.r4.y;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements Runnable {
    public final /* synthetic */ List a;
    public final /* synthetic */ p b;

    public h(p pVar, ArrayList arrayList) {
        this.b = pVar;
        this.a = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context contextD;
        List list = this.a;
        if (list == null || list.size() <= 0 || (contextD = SDKContext.getInstance().d()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.a.size(); i++) {
            a aVar = (a) this.a.get(i);
            if (aVar != null) {
                arrayList.add(new e(contextD, aVar.a, aVar.b, y.b(contextD, "sdm_adx_rp_sdk", "det_time_" + aVar.b)));
            }
        }
        if (arrayList.size() > 0) {
            p.a(this.b, arrayList, false);
        }
    }
}
