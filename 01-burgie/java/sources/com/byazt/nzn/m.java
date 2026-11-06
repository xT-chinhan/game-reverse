package com.byazt.nzn;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public enum m {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");

    public final String c;

    m(String str) {
        this.c = str;
    }

    public static m pr(String str) throws IOException {
        m mVar = HTTP_1_0;
        if (str.equals(mVar.c)) {
            return mVar;
        }
        m mVar2 = HTTP_1_1;
        if (str.equals(mVar2.c)) {
            return mVar2;
        }
        m mVar3 = HTTP_2;
        if (str.equals(mVar3.c)) {
            return mVar3;
        }
        m mVar4 = SPDY_3;
        if (str.equals(mVar4.c)) {
            return mVar4;
        }
        throw new IOException("Unexpected protocol: ".concat(String.valueOf(str)));
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.c;
    }
}
