package com.ss.android.downloadlib.addownload.d;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class hi {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static hi f4409ms;
    private List<ny> xr;

    public static hi ms() {
        if (f4409ms == null) {
            synchronized (hi.class) {
                if (f4409ms == null) {
                    f4409ms = new hi();
                }
            }
        }
        return f4409ms;
    }

    private hi() {
        ArrayList arrayList = new ArrayList();
        this.xr = arrayList;
        arrayList.add(new ch());
        this.xr.add(new sl());
        this.xr.add(new c());
        this.xr.add(new ms());
    }

    public void ms(com.ss.android.downloadad.api.ms.xr xrVar, int i, x xVar) {
        DownloadInfo downloadInfoXr;
        List<ny> list = this.xr;
        if (list == null || list.size() == 0 || xrVar == null) {
            xVar.ms(xrVar);
            return;
        }
        if (!TextUtils.isEmpty(xrVar.vy())) {
            downloadInfoXr = com.ss.android.downloadlib.ch.ms((Context) null).ms(xrVar.vy(), null, true);
        } else {
            downloadInfoXr = com.ss.android.downloadlib.ch.ms((Context) null).xr(xrVar.ms());
        }
        if (downloadInfoXr == null || !"application/vnd.android.package-archive".equals(downloadInfoXr.getMimeType())) {
            xVar.ms(xrVar);
            return;
        }
        boolean z = com.ss.android.socialbase.downloader.ab.ms.ms(xrVar.y()).ms("pause_optimise_switch", 0) == 1;
        for (ny nyVar : this.xr) {
            if (z || (nyVar instanceof sl)) {
                if (nyVar.ms(xrVar, i, xVar)) {
                    return;
                }
            }
        }
        xVar.ms(xrVar);
    }
}
