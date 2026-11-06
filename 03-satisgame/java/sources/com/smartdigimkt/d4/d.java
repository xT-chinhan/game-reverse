package com.smartdigimkt.d4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public c a;
    public int b;
    public Throwable c;
    public com.smartdigimkt.e4.c d;
    public Map e;
    public List f;
    public long g = -1;
    public long h = -1;
    public long i = -1;
    public long j = -1;
    public boolean k;

    public final e a() {
        e eVar = new e();
        eVar.a = this.a;
        eVar.b = this.b;
        eVar.c = null;
        eVar.d = this.c;
        eVar.e = this.d;
        eVar.f = this.e;
        eVar.g = this.f == null ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(this.f));
        eVar.h = this.g;
        eVar.i = this.k;
        return eVar;
    }
}
