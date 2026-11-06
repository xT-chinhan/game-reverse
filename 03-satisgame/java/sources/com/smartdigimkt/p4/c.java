package com.smartdigimkt.p4;

import com.smartdigimkt.f.i;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public String a;
    public String b;
    public String c;
    public int d;
    public int e;
    public String f;

    public final String toString() {
        return i.a(new StringBuilder("EcpmEncDecInfo{uniqueId='").append(this.a).append("', ecpmEncryptInfo='").append(this.b).append("', ecpmEncPubKey='").append(this.c).append("', ecpmDecPvtKeyServerId=").append(this.d).append(", ecpmDecPvtKeyClientId=").append(this.e).append(", ecpmRmbEncryptInfo='"), this.f, "'}");
    }
}
