package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.y;

/* JADX INFO: loaded from: classes3.dex */
public class h implements y {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final long[] f4686ms;

    public h(String str) {
        this.f4686ms = ms(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.y
    public long ms(int i, int i2) {
        long[] jArr = this.f4686ms;
        if (jArr == null || jArr.length <= 0) {
            return 0L;
        }
        int length = i - 1;
        if (length < 0) {
            length = 0;
        }
        if (length > jArr.length - 1) {
            length = jArr.length - 1;
        }
        return jArr[length];
    }

    private long[] ms(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] strArrSplit = str.split(",");
            if (strArrSplit.length == 0) {
                return null;
            }
            long[] jArr = new long[strArrSplit.length];
            for (int i = 0; i < strArrSplit.length; i++) {
                jArr[i] = Long.parseLong(strArrSplit[i]);
            }
            return jArr;
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.api.ab.ms(th);
            return null;
        }
    }
}
