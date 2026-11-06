package com.taptap.sdk.okhttp3;

import java.io.IOException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface Authenticator {
    public static final Authenticator NONE = new Authenticator() { // from class: com.taptap.sdk.okhttp3.Authenticator.1
        @Override // com.taptap.sdk.okhttp3.Authenticator
        public Request authenticate(@Nullable Route route, Response response) {
            return null;
        }
    };

    @Nullable
    Request authenticate(@Nullable Route route, Response response) throws IOException;
}
