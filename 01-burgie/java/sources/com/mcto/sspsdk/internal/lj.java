package com.mcto.sspsdk.internal;

import java.nio.charset.StandardCharsets;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class lj {
    public static byte[] a(String str) {
        return str.getBytes(StandardCharsets.UTF_8);
    }

    public static boolean b(String str) {
        return str == null || str.trim().isEmpty() || AbstractJsonLexerKt.NULL.equalsIgnoreCase(str.trim());
    }

    public static String a(byte[] bArr) {
        return bArr == null ? "nil" : new String(bArr, StandardCharsets.UTF_8);
    }
}
