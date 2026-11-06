package com.smartdigimkt.l2;

import androidx.core.app.NotificationCompat;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Runnable {
    public final /* synthetic */ Object a;
    public final /* synthetic */ f b;

    public d(f fVar, Object obj) {
        this.b = fVar;
        this.a = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.smartdigimkt.u1.d dVar = this.b.b;
        if (dVar == null || dVar.h == null) {
            com.smartdigimkt.k2.a.a(this.a, "videoComponent empty");
            return;
        }
        long jA = dVar.a();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NotificationCompat.CATEGORY_PROGRESS, jA);
            com.smartdigimkt.k2.a.a(this.a, jSONObject);
        } catch (Throwable th) {
            f fVar = this.b;
            Object obj = this.a;
            fVar.getClass();
            f.a(obj, "playerViewGetProgress", th);
        }
    }
}
