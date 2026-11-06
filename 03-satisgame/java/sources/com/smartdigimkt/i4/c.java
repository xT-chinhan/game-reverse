package com.smartdigimkt.i4;

import com.smartdigimkt.q3.h;
import java.net.Socket;
import java.net.SocketException;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends h {
    public final /* synthetic */ com.smartdigimkt.h4.d b;
    public final /* synthetic */ com.smartdigimkt.h4.c c;
    public final /* synthetic */ d d;

    public c(d dVar, com.smartdigimkt.h4.d dVar2, com.smartdigimkt.h4.c cVar) {
        this.d = dVar;
        this.b = dVar2;
        this.c = cVar;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0079  */
    /* JADX WARN: Code duplicated, block: B:34:? A[RETURN, SYNTHETIC] */
    @Override // com.smartdigimkt.q3.h
    public final void b() {
        com.smartdigimkt.h4.c cVar;
        try {
            d.a(this.d, this.b);
            this.d.a(this.b, this.c);
        } catch (SocketException e) {
            String str = this.d.a;
            e.getMessage();
            this.b.toString();
            d dVar = this.d;
            synchronized (dVar) {
                try {
                    Socket socket = dVar.d;
                    if (socket != null) {
                        socket.close();
                        dVar.d = null;
                    }
                } catch (Exception unused) {
                }
                try {
                    d.a(this.d, this.b);
                    this.d.a(this.b, this.c);
                } catch (Throwable th) {
                    String str2 = this.d.a;
                    e.getMessage();
                    this.b.toString();
                    th = th;
                    String str3 = this.d.a;
                    th.toString();
                    d dVar2 = this.d;
                    this.b.a(dVar2.c, th + "", dVar2.b);
                    cVar = this.c;
                    if (cVar != null) {
                        cVar.a(th);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            String str4 = this.d.a;
            th.toString();
            d dVar3 = this.d;
            this.b.a(dVar3.c, th + "", dVar3.b);
            cVar = this.c;
            if (cVar != null) {
                cVar.a(th);
            }
        }
    }
}
