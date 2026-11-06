package com.kwad.sdk.utils.basesec;

import android.util.Base64;

/* JADX INFO: loaded from: classes3.dex */
public final class BasesecFragment1 {
    public static byte[] getAesFragment() {
        return Base64.decode(BuildConfig.BASESEC_KEY_FRAG_AES_P1, 0);
    }

    public static byte[] getRsaPubFragment() {
        return Base64.decode(BuildConfig.BASESEC_KEY_FRAG_PUB_P1, 0);
    }

    public static byte[] getRsaPrvFragment() {
        return Base64.decode(BuildConfig.BASESEC_KEY_FRAG_PRV_P1, 0);
    }

    private BasesecFragment1() {
    }
}
