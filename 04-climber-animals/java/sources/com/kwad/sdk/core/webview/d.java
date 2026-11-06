package com.kwad.sdk.core.webview;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private long aMY;
    private boolean aMZ;

    public final void a(com.kwad.sdk.core.webview.a.c.a aVar) {
        if (aVar != null) {
            com.kwad.sdk.core.adlog.c.a(aVar.getAdTemplate(), aVar.pq());
        }
        if (aVar != null) {
            this.aMY = System.currentTimeMillis();
        }
    }

    public final void b(com.kwad.sdk.core.webview.a.c.a aVar) {
        if (aVar != null) {
            com.kwad.sdk.core.adlog.c.l(aVar.getAdTemplate(), System.currentTimeMillis() - this.aMY);
        }
    }

    public final void c(com.kwad.sdk.core.webview.a.c.a aVar) {
        if (aVar == null || this.aMZ) {
            return;
        }
        this.aMZ = true;
        long jCurrentTimeMillis = 0;
        if (this.aMY > 0) {
            jCurrentTimeMillis = System.currentTimeMillis() - this.aMY;
            this.aMY = -1L;
        }
        com.kwad.sdk.core.adlog.c.a(aVar.getAdTemplate(), aVar.pq(), jCurrentTimeMillis);
    }

    public static void d(com.kwad.sdk.core.webview.a.c.a aVar) {
        if (aVar != null) {
            com.kwad.sdk.core.adlog.c.b(aVar.getAdTemplate(), aVar.pq());
        }
    }
}
