package com.tapsdk.tapad.internal.t;

import com.anythink.core.common.d.j;
import com.tapsdk.tapad.model.entities.TapAdReq;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    private final long a;
    private final String b;
    private final String c;
    private final String d;

    public a(long j, String str, String str2, String str3) {
        this.a = j;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    public String a(TapAdReq.d dVar) throws Exception {
        return b.b().a((this.a + j.z + b.b().a((this.c + j.z + this.d).getBytes()) + j.z + com.tapsdk.tapad.internal.t.f.b.a(dVar.toByteArray(), this.b)).getBytes());
    }

    public byte[] a(String str) throws Exception {
        String str2 = new String(b.b().a(str), StandardCharsets.UTF_8);
        return com.tapsdk.tapad.internal.t.f.b.a(str2.substring(str2.lastIndexOf(46) + 1), this.b);
    }

    public String b(String str) throws Exception {
        return b.b().a((this.a + j.z + b.b().a((this.c + j.z + this.d).getBytes()) + j.z + com.tapsdk.tapad.internal.t.f.b.b(str, this.b)).getBytes());
    }
}
