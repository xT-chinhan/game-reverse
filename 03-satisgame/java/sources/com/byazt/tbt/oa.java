package com.byazt.tbt;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public enum oa {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");

    public final String l;

    oa(String str) {
        this.l = str;
    }

    public static oa n(String str) throws IOException {
        oa oaVar = HTTP_1_0;
        if (str.equals(oaVar.l)) {
            return oaVar;
        }
        oa oaVar2 = HTTP_1_1;
        if (str.equals(oaVar2.l)) {
            return oaVar2;
        }
        oa oaVar3 = HTTP_2;
        if (str.equals(oaVar3.l)) {
            return oaVar3;
        }
        oa oaVar4 = SPDY_3;
        if (str.equals(oaVar4.l)) {
            return oaVar4;
        }
        throw new IOException("Unexpected protocol: ".concat(String.valueOf(str)));
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.l;
    }
}
