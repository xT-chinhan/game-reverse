package com.smartdigimkt.t;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.sdk.core.SDKContext;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.smartdigimkt.q.a {
    public final /* synthetic */ Context a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ boolean[] c;

    public b(Context context, Object obj, boolean[] zArr) {
        this.a = context;
        this.b = obj;
        this.c = zArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:?, code lost:
    
        return;
     */
    @Override // com.smartdigimkt.q.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.String r3) {
        /*
            r2 = this;
            boolean[] r3 = r2.c
            r0 = 0
            r1 = 1
            r3[r0] = r1
            java.lang.Object r3 = r2.b     // Catch: java.lang.Throwable -> L13
            monitor-enter(r3)     // Catch: java.lang.Throwable -> L13
            java.lang.Object r0 = r2.b     // Catch: java.lang.Throwable -> L10
            r0.notifyAll()     // Catch: java.lang.Throwable -> L10
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L10
            goto L13
        L10:
            r0 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L10
            throw r0     // Catch: java.lang.Throwable -> L13
        L13:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smartdigimkt.t.b.a(java.lang.String):void");
    }

    @Override // com.smartdigimkt.q.a
    public final void a(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && !Pattern.matches("^[0-]+$", str)) {
            f.a(this.a, str, true);
        }
        try {
            SDKContext sDKContext = SDKContext.getInstance();
            if (!TextUtils.isEmpty(sDKContext.z) && TextUtils.equals(str, sDKContext.z)) {
                sDKContext.B = true;
            }
            synchronized (this.b) {
                this.b.notifyAll();
            }
        } catch (Throwable unused) {
        }
        this.c[0] = true;
    }
}
