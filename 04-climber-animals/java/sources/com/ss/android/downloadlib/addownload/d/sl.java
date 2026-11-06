package com.ss.android.downloadlib.addownload.d;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.u;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
public class sl implements ny {
    @Override // com.ss.android.downloadlib.addownload.d.ny
    public boolean ms(com.ss.android.downloadad.api.ms.xr xrVar, int i, x xVar) {
        DownloadInfo downloadInfoXr;
        if (xrVar == null) {
            return false;
        }
        if (!TextUtils.isEmpty(xrVar.vy())) {
            downloadInfoXr = com.ss.android.downloadlib.ch.ms((Context) null).ms(xrVar.vy(), null, true);
        } else {
            downloadInfoXr = com.ss.android.downloadlib.ch.ms((Context) null).xr(xrVar.ms());
        }
        return u.ms(xrVar, downloadInfoXr, i, xVar, false, null);
    }
}
