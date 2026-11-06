package com.byazt.jv;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public enum rc {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");

    public final String c;

    rc(String str) {
        this.c = str;
    }

    public static rc pr(String str) throws IOException {
        rc rcVar = HTTP_1_0;
        if (str.equals(rcVar.c)) {
            return rcVar;
        }
        rc rcVar2 = HTTP_1_1;
        if (str.equals(rcVar2.c)) {
            return rcVar2;
        }
        rc rcVar3 = HTTP_2;
        if (str.equals(rcVar3.c)) {
            return rcVar3;
        }
        rc rcVar4 = SPDY_3;
        if (str.equals(rcVar4.c)) {
            return rcVar4;
        }
        throw new IOException("Unexpected protocol: ".concat(String.valueOf(str)));
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.c;
    }
}
