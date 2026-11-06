package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes3.dex */
public class ny implements com.ss.android.socialbase.downloader.downloader.hi {
    @Override // com.ss.android.socialbase.downloader.downloader.hi
    public int ms(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        String strKa = com.ss.android.socialbase.downloader.ny.c.ka(String.format("%s_%s", str, str2));
        if (TextUtils.isEmpty(strKa)) {
            return 0;
        }
        return strKa.hashCode();
    }
}
