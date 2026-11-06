package com.smartdigimkt.b3;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Serializable {
    public long a;
    public String b = "";

    public final void a(long j) {
        this.a = j;
    }

    public final String a() {
        String str = this.b;
        return str == null ? "" : str;
    }
}
