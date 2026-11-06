package com.varbto.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements Runnable {
    public final /* synthetic */ r a;
    public final /* synthetic */ w b;

    public u(w wVar, r rVar) {
        this.b = wVar;
        this.a = rVar;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x001e */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0060, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:?, code lost:
    
        return;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            r5 = this;
            java.lang.Object r0 = com.varbto.internal.w.d     // Catch: java.lang.Throwable -> L1e
            monitor-enter(r0)     // Catch: java.lang.Throwable -> L1e
            com.varbto.internal.w r1 = r5.b     // Catch: java.lang.Throwable -> L1b
            boolean r2 = r1.c     // Catch: java.lang.Throwable -> L1b
            if (r2 == 0) goto La
            goto L12
        La:
            java.lang.String r2 = "verbanr"
            java.lang.System.loadLibrary(r2)     // Catch: java.lang.Throwable -> L1b
            r2 = 1
            r1.c = r2     // Catch: java.lang.Throwable -> L1b
        L12:
            com.varbto.internal.w r1 = r5.b     // Catch: java.lang.Throwable -> L1b
            com.varbto.internal.r r2 = r5.a     // Catch: java.lang.Throwable -> L1b
            com.varbto.internal.w.a(r1, r2)     // Catch: java.lang.Throwable -> L1b
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1b
            goto L60
        L1b:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L1b
            throw r1     // Catch: java.lang.Throwable -> L1e
        L1e:
            r0 = move-exception
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = "w"
            java.lang.String r4 = "startVerb() >>> init verb anr failed. "
            com.varbto.internal.m.a(r3, r4, r0, r2)
            com.varbto.internal.w r2 = r5.b
            r2.b = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r1 = r1.append(r0)
            java.lang.String r2 = ":"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            boolean r1 = com.varbto.internal.f.a
            if (r1 == 0) goto L60
            java.lang.String r1 = "AnrHandler"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "VerbAnr failed: code=0, msg="
            r2.<init>(r3)
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r0 = r0.toString()
            android.util.Log.e(r1, r0)
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.varbto.internal.u.run():void");
    }
}
