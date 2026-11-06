package com.ss.android.downloadlib.addownload.d;

import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.u;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
public class ka implements ab {
    @Override // com.ss.android.downloadlib.addownload.d.ab
    public boolean ms(com.ss.android.downloadad.api.ms.xr xrVar, int i, x xVar, com.ss.android.downloadlib.addownload.ms.ah ahVar) {
        DownloadInfo downloadInfoXr;
        if (xrVar == null) {
            return false;
        }
        if (!TextUtils.isEmpty(xrVar.vy())) {
            downloadInfoXr = com.ss.android.downloadlib.ch.ms(com.ss.android.downloadlib.addownload.hi.getContext()).ms(xrVar.vy(), null, true);
        } else {
            downloadInfoXr = com.ss.android.downloadlib.ch.ms(com.ss.android.downloadlib.addownload.hi.getContext()).xr(xrVar.ms());
        }
        return u.ms(xrVar, downloadInfoXr, i, xVar, true, ahVar);
    }
}
