package com.smartdigimkt.f;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.smartdigimkt.sdk.core.SDKContext;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class r {
    public static volatile r f;
    public s a;
    public Context d;
    public int c = 0;
    public boolean e = false;
    public final ArrayList b = new ArrayList();

    public final void a(q qVar) {
        s sVar;
        if (qVar != null) {
            this.b.add(qVar);
        } else {
            this.c--;
        }
        if (this.b.size() != this.c || (sVar = this.a) == null) {
            return;
        }
        ArrayList arrayList = this.b;
        if (arrayList != null) {
            u.a(sVar.a, arrayList);
        } else {
            u.a(sVar.a, new ArrayList());
        }
    }

    public final synchronized void a() {
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (this.e) {
                return;
            }
            this.e = true;
            new k(new l(SDKContext.getInstance().a(), SDKContext.getInstance().b())).a(0, (com.smartdigimkt.a4.b) new o(this, jElapsedRealtime));
        } catch (Throwable unused) {
        }
    }

    public final void a(JSONObject jSONObject) {
        try {
            q qVar = new q(jSONObject);
            if (TextUtils.isEmpty(qVar.f) || !u.a().a.contains(qVar.f)) {
                qVar = null;
            }
            if (qVar != null && qVar.g == 2) {
                qVar.toString();
                File fileA = j.a(this.d, qVar.f);
                if (fileA != null) {
                    if (new File(fileA.getAbsolutePath(), qVar.a + ".jar").exists()) {
                        qVar.toString();
                        a(qVar);
                        return;
                    }
                    File file = new File(fileA.getAbsolutePath(), qVar.a + ".tmp");
                    if (file.exists()) {
                        file.getName();
                        file.delete();
                    }
                    try {
                        if (TextUtils.isEmpty(qVar.b)) {
                            return;
                        }
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        n nVar = new n(qVar.b, file, qVar);
                        nVar.l = new p(this, jElapsedRealtime);
                        nVar.c();
                        return;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return;
                    }
                }
            }
            a((q) null);
        } catch (Throwable unused) {
        }
    }
}
