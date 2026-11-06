package com.ss.android.downloadlib.addownload.d;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class d {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static d f4408ms;
    private List<ab> xr;

    public static d ms() {
        if (f4408ms == null) {
            synchronized (hi.class) {
                if (f4408ms == null) {
                    f4408ms = new d();
                }
            }
        }
        return f4408ms;
    }

    private d() {
        ArrayList arrayList = new ArrayList();
        this.xr = arrayList;
        arrayList.add(new ka());
        this.xr.add(new xr());
        this.xr.add(new ah());
    }

    public void ms(com.ss.android.downloadad.api.ms.xr xrVar, int i, x xVar, com.ss.android.downloadlib.addownload.ms.ah ahVar) {
        DownloadInfo downloadInfoXr;
        List<ab> list = this.xr;
        if (list == null || list.size() == 0 || xrVar == null) {
            xVar.ms(xrVar);
        }
        if (!TextUtils.isEmpty(xrVar.vy())) {
            downloadInfoXr = com.ss.android.downloadlib.ch.ms(com.ss.android.downloadlib.addownload.hi.getContext()).ms(xrVar.vy(), null, true);
        } else {
            downloadInfoXr = com.ss.android.downloadlib.ch.ms(com.ss.android.downloadlib.addownload.hi.getContext()).xr(xrVar.ms());
        }
        if (downloadInfoXr == null) {
            downloadInfoXr = Downloader.getInstance(com.ss.android.downloadlib.addownload.hi.getContext()).getDownloadInfo(xrVar.y());
        }
        if (downloadInfoXr == null || !"application/vnd.android.package-archive".equals(downloadInfoXr.getMimeType())) {
            xVar.ms(xrVar);
            return;
        }
        if (new ch().ms(xrVar, i, xVar)) {
            return;
        }
        Iterator<ab> it = this.xr.iterator();
        while (it.hasNext()) {
            if (it.next().ms(xrVar, i, xVar, ahVar)) {
                return;
            }
        }
        xVar.ms(xrVar);
    }
}
