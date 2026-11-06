package com.ss.android.socialbase.downloader.impls;

import com.ss.android.socialbase.downloader.downloader.y;
import com.tapsdk.tapad.e.a;

/* JADX INFO: loaded from: classes3.dex */
public class ch implements y {
    @Override // com.ss.android.socialbase.downloader.downloader.y
    public long ms(int i, int i2) {
        if (i == 1) {
            return a.f;
        }
        if (i == 2) {
            return 15000L;
        }
        if (i == 3) {
            return 30000L;
        }
        return i > 3 ? 300000L : 0L;
    }
}
