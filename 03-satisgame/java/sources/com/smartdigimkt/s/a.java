package com.smartdigimkt.s;

import com.smartdigimkt.n3.k;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.smartdigimkt.q.a {
    public final /* synthetic */ com.smartdigimkt.q.a a;
    public final /* synthetic */ b b;

    public a(b bVar, com.smartdigimkt.q.a aVar) {
        this.b = bVar;
        this.a = aVar;
    }

    @Override // com.smartdigimkt.q.a
    public final void a(String str, boolean z) {
        String str2 = this.b.a;
        com.smartdigimkt.q.a aVar = this.a;
        if (aVar != null) {
            aVar.a(str, z);
        }
        k.a(str, "");
    }

    @Override // com.smartdigimkt.q.a
    public final void a(String str) {
        String str2 = this.b.a;
        com.smartdigimkt.q.a aVar = this.a;
        if (aVar != null) {
            aVar.a(str);
        }
        k.a("", str);
    }
}
