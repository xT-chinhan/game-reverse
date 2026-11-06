package com.smartdigimkt.s3;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements Runnable {
    @Override // java.lang.Runnable
    public final void run() {
        String string;
        try {
            String strA = j.a();
            if (TextUtils.isEmpty(strA)) {
                j.g.set(false);
                return;
            }
            synchronized (j.a) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                AtomicBoolean atomicBoolean = j.d;
                if (!atomicBoolean.get() && strA.equals(j.h) && j.a(j.b, j.c, jCurrentTimeMillis)) {
                    j.g.set(false);
                    return;
                }
                JSONObject jSONObjectB = j.b();
                if (!j.d(jSONObjectB)) {
                    j.g.set(false);
                    return;
                }
                j.a(com.smartdigimkt.r4.e.f(jSONObjectB.toString()));
                if (j.d(jSONObjectB)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(jSONObjectB.optString("oaid", "")).append('|');
                    sb.append(jSONObjectB.optJSONArray(com.anythink.core.common.l.f.am).toString()).append('|');
                    j.a(sb);
                    string = sb.toString();
                } else {
                    string = "";
                }
                j.h = string;
                atomicBoolean.set(false);
            }
        } catch (Throwable unused) {
        }
        j.g.set(false);
    }
}
