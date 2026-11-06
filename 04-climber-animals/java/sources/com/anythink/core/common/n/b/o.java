package com.anythink.core.common.n.b;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes.dex */
public final class o {
    private o() {
    }

    private static String a(String str, String str2) {
        return "Basic ".concat(String.valueOf(com.anythink.core.common.n.c.f.a(str + ":" + str2, StandardCharsets.ISO_8859_1).b()));
    }

    private static String a(String str, String str2, Charset charset) {
        return "Basic ".concat(String.valueOf(com.anythink.core.common.n.c.f.a(str + ":" + str2, charset).b()));
    }
}
