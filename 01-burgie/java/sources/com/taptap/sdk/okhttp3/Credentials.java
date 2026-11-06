package com.taptap.sdk.okhttp3;

import com.taptap.sdk.okhttp3.internal.Util;
import com.taptap.sdk.okio.ByteString;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public final class Credentials {
    private Credentials() {
    }

    public static String basic(String username, String password) {
        return basic(username, password, Util.ISO_8859_1);
    }

    public static String basic(String username, String password, Charset charset) {
        String usernameAndPassword = username + ":" + password;
        String encoded = ByteString.encodeString(usernameAndPassword, charset).base64();
        return "Basic " + encoded;
    }
}
