package com.kwad.sdk.crash.utils;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final Charset US_ASCII = Charset.forName(com.anythink.basead.exoplayer.b.i);
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    public static Charset a(Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }
}
