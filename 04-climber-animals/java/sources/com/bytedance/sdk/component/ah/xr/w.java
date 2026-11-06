package com.bytedance.sdk.component.ah.xr;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
final class w implements ka {
    final yu ah;
    private boolean c;
    final boolean d;
    private ao ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    final re f1143ms;
    final com.bytedance.sdk.component.ah.xr.ms.ah.ch xr;

    private w(re reVar, yu yuVar, boolean z) {
        this.f1143ms = reVar;
        this.ah = yuVar;
        this.d = z;
        this.xr = new com.bytedance.sdk.component.ah.xr.ms.ah.ch(reVar, z);
    }

    static w ms(re reVar, yu yuVar, boolean z) {
        w wVar = new w(reVar, yuVar, z);
        wVar.ka = reVar.i().ms(wVar);
        return wVar;
    }

    @Override // com.bytedance.sdk.component.ah.xr.ka
    public yu ms() {
        return this.ah;
    }

    @Override // com.bytedance.sdk.component.ah.xr.ka
    public cv xr() throws IOException {
        synchronized (this) {
            if (this.c) {
                throw new IllegalStateException("Already Executed");
            }
            this.c = true;
        }
        ch();
        try {
            try {
                if (this.ah.c != null) {
                    this.ah.c.ms();
                }
                this.f1143ms.y().ms(this);
                cv cvVarNy = ny();
                if (cvVarNy == null) {
                    throw new IOException("Canceled");
                }
                if (cvVarNy.ah == 0) {
                    throw new IOException(cvVarNy.d);
                }
                this.f1143ms.y().xr(this);
                return cvVarNy;
            } catch (IOException e) {
                this.ka.ms(this, e);
                this.f1143ms.y().xr(this);
                return null;
            } catch (Exception e2) {
                this.ka.ms(this, new IOException(e2));
                this.f1143ms.y().xr(this);
                return null;
            }
        } catch (Throwable th) {
            this.f1143ms.y().xr(this);
            throw th;
        }
    }

    private void ch() {
        this.xr.ms(com.bytedance.sdk.component.ah.xr.ms.ab.ka.xr().ms("response.body().close()"));
    }

    @Override // com.bytedance.sdk.component.ah.xr.ka
    public void ms(c cVar) {
        try {
            synchronized (this) {
                if (this.c) {
                    throw new IllegalStateException("Already Executed");
                }
                this.c = true;
            }
            ch();
            this.f1143ms.y().ms(new ms(cVar));
        } catch (Throwable th) {
            if (cVar != null) {
                cVar.ms(this, new IOException(th.getMessage()));
            }
        }
    }

    @Override // com.bytedance.sdk.component.ah.xr.ka
    public void ah() {
        this.xr.ms();
    }

    @Override // com.bytedance.sdk.component.ah.xr.ka
    public boolean d() {
        return this.xr.xr();
    }

    @Override // com.bytedance.sdk.component.ah.xr.ka
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public w ka() {
        return ms(this.f1143ms, this.ah, this.d);
    }

    final class ms extends com.bytedance.sdk.component.ah.xr.ms.xr {
        private final c ah;

        ms(c cVar) {
            super("OkHttp %s", w.this.x());
            this.ah = cVar;
        }

        String ms() {
            return w.this.ah.ms().ab();
        }

        public void xr() {
            if (w.this.ah == null || w.this.ah.c == null) {
                return;
            }
            w.this.ah.c.hi();
        }

        @Override // com.bytedance.sdk.component.ah.xr.ms.xr
        protected void ah() {
            boolean z = false;
            try {
                try {
                    try {
                        if (w.this.ah != null && w.this.ah.c != null) {
                            w.this.ah.c.ms();
                        }
                        cv cvVarNy = w.this.ny();
                        try {
                            if (w.this.xr.xr()) {
                                this.ah.ms(w.this, new IOException("Canceled"));
                            } else {
                                this.ah.ms(w.this, cvVarNy);
                            }
                            if (cvVarNy.ah == 0) {
                                throw new IOException(cvVarNy.d);
                            }
                        } catch (IOException e) {
                            e = e;
                            z = true;
                            if (!z) {
                                w.this.ka.ms(w.this, e);
                                this.ah.ms(w.this, e);
                            } else {
                                com.bytedance.sdk.component.ah.xr.ms.ab.ka.xr().ms(4, "Callback failure for " + w.this.ab(), e);
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                    }
                } catch (Exception e3) {
                    w.this.ka.ms(w.this, new IOException(e3));
                    this.ah.ms(w.this, new IOException(e3));
                }
                w.this.f1143ms.y().xr(this);
            } catch (Throwable th) {
                w.this.f1143ms.y().xr(this);
                throw th;
            }
        }
    }

    String ab() {
        return (d() ? "canceled " : "") + (this.d ? "web socket" : NotificationCompat.CATEGORY_CALL) + " to " + x();
    }

    String x() {
        return this.ah.ms().zb();
    }

    cv ny() throws IOException {
        ArrayList arrayList = new ArrayList(this.f1143ms.b());
        arrayList.add(this.xr);
        arrayList.add(new com.bytedance.sdk.component.ah.xr.ms.ah.ms(this.f1143ms.c()));
        arrayList.add(new com.bytedance.sdk.component.ah.xr.ms.ms.ms(this.f1143ms.ab()));
        arrayList.add(new com.bytedance.sdk.component.ah.xr.ms.xr.ms(this.f1143ms));
        if (!this.d) {
            arrayList.addAll(this.f1143ms.re());
        }
        arrayList.add(new com.bytedance.sdk.component.ah.xr.ms.ah.xr(this.d));
        return new com.bytedance.sdk.component.ah.xr.ms.ah.ab(arrayList, null, null, null, 0, this.ah, this, this.ka, this.f1143ms.ms(), this.f1143ms.xr(), this.f1143ms.ah()).ms(this.ah);
    }
}
