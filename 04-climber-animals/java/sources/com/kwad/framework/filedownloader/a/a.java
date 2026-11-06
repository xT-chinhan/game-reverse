package com.kwad.framework.filedownloader.a;

import com.ss.android.download.api.constant.BaseConstants;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.kwad.framework.filedownloader.f.c.a {
    @Override // com.kwad.framework.filedownloader.f.c.a
    public final int V(long j) {
        if (j < BaseConstants.MB_VALUE) {
            return 1;
        }
        if (j < 5242880) {
            return 2;
        }
        if (j < 52428800) {
            return 3;
        }
        return j < 104857600 ? 4 : 5;
    }
}
