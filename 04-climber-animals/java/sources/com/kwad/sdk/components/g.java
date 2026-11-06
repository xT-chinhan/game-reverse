package com.kwad.sdk.components;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public static boolean encryptDisable() {
        return df("KEY_HOST_ENCRYPT_DISABLE");
    }

    public static boolean df(String str) {
        DevelopMangerComponents.DevelopValue developValueDe = d.de(str);
        return developValueDe != null && ((Boolean) developValueDe.getValue()).booleanValue();
    }
}
