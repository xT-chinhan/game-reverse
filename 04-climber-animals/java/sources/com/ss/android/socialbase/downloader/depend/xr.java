package com.ss.android.socialbase.downloader.depend;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class xr implements b {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private boolean f4651ms = false;

    @Override // com.ss.android.socialbase.downloader.depend.b
    public void ms(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f4651ms = true;
    }

    @Override // com.ss.android.socialbase.downloader.depend.b
    public boolean ms() {
        return this.f4651ms;
    }
}
