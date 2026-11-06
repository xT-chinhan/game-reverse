package com.anythink.core.common.r;

import android.os.Handler;
import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private static final String a = "e";
    private final Map<String, Integer> b = new ConcurrentHashMap();
    private final Map<String, f> c = new ConcurrentHashMap();
    private Handler d;

    public final void a(h hVar, Handler handler, a aVar) {
        Integer numValueOf;
        try {
            this.d = handler;
            g gVar = hVar != null ? hVar.j : null;
            if (gVar == null) {
                return;
            }
            if (!gVar.a(16)) {
                Object[] objArr = new Object[2];
                String str = hVar.b;
                Integer.valueOf(16);
                return;
            }
            String str2 = hVar.b;
            Integer num = this.b.get(str2);
            if (num != null) {
                numValueOf = Integer.valueOf(num.intValue() + 1);
            } else {
                numValueOf = 1;
            }
            hVar.i = numValueOf.intValue();
            this.b.put(str2, numValueOf);
            Object[] objArr2 = new Object[2];
            if (numValueOf.intValue() > gVar.g()) {
                Object[] objArr3 = new Object[2];
                return;
            }
            long jH = gVar.h() * ((long) numValueOf.intValue());
            Object[] objArr4 = new Object[3];
            Integer.valueOf(16);
            Long.valueOf(jH);
            f fVar = new f(hVar, aVar);
            this.c.put(str2, fVar);
            handler.postDelayed(fVar, jH);
        } catch (Throwable th) {
            Object[] objArr5 = new Object[2];
            th.getMessage();
            if (hVar != null) {
                String str3 = hVar.b;
            }
        }
    }

    public final void a(h hVar) {
        if (hVar == null) {
            return;
        }
        String str = hVar.b;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            hVar.i = 0;
            this.b.remove(str);
            if (this.d != null) {
                f fVarRemove = this.c.remove(str);
                Object[] objArr = new Object[2];
                if (fVarRemove != null) {
                    this.d.removeCallbacks(fVarRemove);
                }
            }
        } catch (Throwable th) {
            Object[] objArr2 = new Object[2];
            th.getMessage();
        }
    }
}
