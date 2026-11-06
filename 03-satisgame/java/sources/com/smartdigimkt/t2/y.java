package com.smartdigimkt.t2;

import android.content.ContentValues;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class y implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;
    public final /* synthetic */ int e;
    public final /* synthetic */ z f;

    public y(z zVar, String str, String str2, long j, long j2, int i) {
        this.f = zVar;
        this.a = str;
        this.b = str2;
        this.c = j;
        this.d = j2;
        this.e = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.smartdigimkt.z2.r rVar = this.f.b;
        String str = this.a;
        String str2 = this.b;
        long j = this.c;
        long j2 = this.d;
        int i = this.e;
        synchronized (rVar) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("video_url", str);
                contentValues.put(com.anythink.core.common.f.k.a.c, str2);
                contentValues.put(com.anythink.core.common.f.k.a.d, Integer.valueOf(i));
                contentValues.put(com.anythink.core.common.f.k.a.e, Long.valueOf(j2));
                contentValues.put(com.anythink.core.common.f.k.a.f, Long.valueOf(j));
                contentValues.put(com.anythink.core.common.f.k.a.g, Long.valueOf(System.currentTimeMillis()));
                if (rVar.b(str)) {
                    rVar.b().update(com.anythink.core.common.f.k.a.a, contentValues, "video_url = ? ", new String[]{str});
                } else {
                    rVar.b().insert(com.anythink.core.common.f.k.a.a, null, contentValues);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
