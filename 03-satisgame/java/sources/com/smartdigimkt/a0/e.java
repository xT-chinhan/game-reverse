package com.smartdigimkt.a0;

import com.smartdigimkt.sdk.api.IOfferClickHandler;
import com.smartdigimkt.z.z;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements z {
    public z a;
    public boolean b;
    public boolean c;
    public boolean d;
    public final AtomicBoolean e;
    public boolean f;

    public e() {
        this.b = false;
        this.c = false;
        this.d = false;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.e = atomicBoolean;
        this.f = false;
        atomicBoolean.set(false);
        this.f = false;
        this.b = false;
        this.c = false;
        this.d = false;
    }

    @Override // com.smartdigimkt.z.z
    public final void a() {
        if (this.f || this.b) {
            return;
        }
        this.b = true;
        z zVar = this.a;
        if (zVar != null) {
            zVar.a();
        }
    }

    @Override // com.smartdigimkt.z.z
    public final void b() {
        if (this.f || this.c) {
            return;
        }
        this.c = true;
        com.smartdigimkt.q3.f.a().a(new c(this));
    }

    @Override // com.smartdigimkt.z.z
    public final void c() {
        this.e.set(false);
        if (this.f || this.d) {
            return;
        }
        this.d = true;
        com.smartdigimkt.q3.f.a().a(new d(this));
    }

    @Override // com.smartdigimkt.z.z
    public final void a(boolean z) {
        z zVar;
        if (this.f || (zVar = this.a) == null) {
            return;
        }
        zVar.a(z);
    }

    @Override // com.smartdigimkt.z.z
    public final boolean a(String str, IOfferClickHandler iOfferClickHandler) {
        z zVar = this.a;
        if (zVar != null) {
            return zVar.a(str, iOfferClickHandler);
        }
        return false;
    }
}
