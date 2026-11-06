package com.bytedance.sdk.component.xr.ms;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public enum zb {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");

    private final String ka;

    zb(String str) {
        this.ka = str;
    }

    public static zb ms(String str) throws IOException {
        zb zbVar = HTTP_1_0;
        if (str.equals(zbVar.ka)) {
            return zbVar;
        }
        zb zbVar2 = HTTP_1_1;
        if (str.equals(zbVar2.ka)) {
            return zbVar2;
        }
        zb zbVar3 = HTTP_2;
        if (str.equals(zbVar3.ka)) {
            return zbVar3;
        }
        zb zbVar4 = SPDY_3;
        if (str.equals(zbVar4.ka)) {
            return zbVar4;
        }
        throw new IOException("Unexpected protocol: ".concat(String.valueOf(str)));
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.ka;
    }
}
