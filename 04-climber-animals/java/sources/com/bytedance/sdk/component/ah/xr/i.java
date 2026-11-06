package com.bytedance.sdk.component.ah.xr;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public enum i {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");

    private final String ka;

    i(String str) {
        this.ka = str;
    }

    public static i ms(String str) throws IOException {
        i iVar = HTTP_1_0;
        if (str.equals(iVar.ka)) {
            return iVar;
        }
        i iVar2 = HTTP_1_1;
        if (str.equals(iVar2.ka)) {
            return iVar2;
        }
        i iVar3 = HTTP_2;
        if (str.equals(iVar3.ka)) {
            return iVar3;
        }
        i iVar4 = SPDY_3;
        if (str.equals(iVar4.ka)) {
            return iVar4;
        }
        throw new IOException("Unexpected protocol: ".concat(String.valueOf(str)));
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.ka;
    }
}
