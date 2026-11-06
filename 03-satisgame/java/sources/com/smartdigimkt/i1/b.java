package com.smartdigimkt.i1;

import android.content.Context;
import com.smartdigimkt.b3.m;
import com.smartdigimkt.r4.y;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {
    public final /* synthetic */ com.smartdigimkt.b3.e a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ com.smartdigimkt.b3.c d;
    public final /* synthetic */ c e;

    public b(c cVar, m mVar, String str, Context context, com.smartdigimkt.b3.c cVar2) {
        this.e = cVar;
        this.a = mVar;
        this.b = str;
        this.c = context;
        this.d = cVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.e.b) {
            m mVar = (m) this.a;
            ArrayList arrayList = (ArrayList) this.e.a.get(this.b);
            if (arrayList == null) {
                arrayList = new ArrayList();
                try {
                    JSONArray jSONArray = new JSONArray(y.c(this.c, "sdm_adx_rpown_offerid_impression", this.b));
                    if (jSONArray.length() > 0) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            arrayList.add(jSONArray.optString(i));
                        }
                    }
                } catch (Exception unused) {
                }
                this.e.a.put(this.b, arrayList);
            }
            if (arrayList.size() >= mVar.Y1) {
                arrayList.remove(arrayList.size() - 1);
            }
            arrayList.add(0, this.d.a);
            y.a(this.c, "sdm_adx_rpown_offerid_impression", this.b, new JSONArray((Collection) arrayList).toString());
        }
    }
}
