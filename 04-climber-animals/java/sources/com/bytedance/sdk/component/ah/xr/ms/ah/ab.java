package com.bytedance.sdk.component.ah.xr.ms.ah;

import com.bytedance.sdk.component.ah.xr.ao;
import com.bytedance.sdk.component.ah.xr.cv;
import com.bytedance.sdk.component.ah.xr.t;
import com.bytedance.sdk.component.ah.xr.yu;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class ab implements t.ms {
    private final com.bytedance.sdk.component.ah.xr.ka ab;
    private final ah ah;
    private final yu c;
    private final int ch;
    private final com.bytedance.sdk.component.ah.xr.ms.xr.ah d;
    private final int hi;
    private final int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final List<t> f1059ms;
    private final int ny;
    private int sl;
    private final ao x;
    private final com.bytedance.sdk.component.ah.xr.ms.xr.ab xr;

    public ab(List<t> list, com.bytedance.sdk.component.ah.xr.ms.xr.ab abVar, ah ahVar, com.bytedance.sdk.component.ah.xr.ms.xr.ah ahVar2, int i, yu yuVar, com.bytedance.sdk.component.ah.xr.ka kaVar, ao aoVar, int i2, int i3, int i4) {
        this.f1059ms = list;
        this.d = ahVar2;
        this.xr = abVar;
        this.ah = ahVar;
        this.ka = i;
        this.c = yuVar;
        this.ab = kaVar;
        this.x = aoVar;
        this.ny = i2;
        this.ch = i3;
        this.hi = i4;
    }

    public com.bytedance.sdk.component.ah.xr.ny ka() {
        return this.d;
    }

    @Override // com.bytedance.sdk.component.ah.xr.t.ms
    public int xr() {
        return this.ny;
    }

    @Override // com.bytedance.sdk.component.ah.xr.t.ms
    public int ah() {
        return this.ch;
    }

    @Override // com.bytedance.sdk.component.ah.xr.t.ms
    public int d() {
        return this.hi;
    }

    public com.bytedance.sdk.component.ah.xr.ms.xr.ab c() {
        return this.xr;
    }

    public ah ab() {
        return this.ah;
    }

    @Override // com.bytedance.sdk.component.ah.xr.t.ms
    public com.bytedance.sdk.component.ah.xr.ka call() {
        return this.ab;
    }

    public ao x() {
        return this.x;
    }

    @Override // com.bytedance.sdk.component.ah.xr.t.ms
    public yu ms() {
        return this.c;
    }

    @Override // com.bytedance.sdk.component.ah.xr.t.ms
    public cv ms(yu yuVar) throws IOException {
        return ms(yuVar, this.xr, this.ah, this.d);
    }

    public cv ms(yu yuVar, com.bytedance.sdk.component.ah.xr.ms.xr.ab abVar, ah ahVar, com.bytedance.sdk.component.ah.xr.ms.xr.ah ahVar2) throws Exception {
        if (this.ka >= this.f1059ms.size()) {
            throw new AssertionError();
        }
        this.sl++;
        if (this.ah != null && !this.d.ms(yuVar.ms())) {
            throw new IllegalStateException("network interceptor " + this.f1059ms.get(this.ka - 1) + " must retain the same host and port");
        }
        if (this.ah != null && this.sl > 1) {
            throw new IllegalStateException("network interceptor " + this.f1059ms.get(this.ka - 1) + " must call proceed() exactly once");
        }
        ab abVar2 = new ab(this.f1059ms, abVar, ahVar, ahVar2, this.ka + 1, yuVar, this.ab, this.x, this.ny, this.ch, this.hi);
        t tVar = this.f1059ms.get(this.ka);
        try {
            cv cvVarMs = tVar.ms(abVar2);
            if (ahVar != null && this.ka + 1 < this.f1059ms.size() && abVar2.sl != 1) {
                throw new IllegalStateException("network interceptor " + tVar + " must call proceed() exactly once");
            }
            if (cvVarMs == null) {
                throw new NullPointerException("interceptor " + tVar + " returned a null response");
            }
            if (cvVarMs.x() != null) {
                return cvVarMs;
            }
            throw new IllegalStateException("interceptor " + tVar + " returned a response with no body");
        } catch (Exception e) {
            throw e;
        }
    }
}
