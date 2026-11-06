package com.smartdigimkt.k3;

import android.os.SystemClock;
import com.smartdigimkt.q3.h;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends h {
    public final /* synthetic */ long b = -1;
    public final /* synthetic */ d c;

    public c(d dVar) {
        this.c = dVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x01fd, code lost:
    
        if (r0 != null) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0213, code lost:
    
        if (r0 != null) goto L78;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.String r6) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 560
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smartdigimkt.k3.c.a(java.lang.String):void");
    }

    @Override // com.smartdigimkt.q3.h
    public final void b() {
        this.c.h = SystemClock.elapsedRealtime();
        this.c.getClass();
        this.c.getClass();
        d dVar = this.c;
        long j = this.b;
        dVar.getClass();
        if (j >= 0 && -1 >= j) {
            Iterator it = dVar.c.iterator();
            if (it.hasNext()) {
                throw com.smartdigimkt.x.d.a(it);
            }
        }
        this.c.getClass();
        try {
            try {
                a(this.c.b);
            } catch (Exception e) {
                String str = this.c.a;
                e.getMessage();
                this.c.a(e.getMessage());
            } catch (OutOfMemoryError e2) {
                e = e2;
                System.gc();
                this.c.a(e.getMessage());
            } catch (StackOverflowError e3) {
                e = e3;
                System.gc();
                this.c.a(e.getMessage());
            }
        } finally {
            this.c.getClass();
        }
    }
}
