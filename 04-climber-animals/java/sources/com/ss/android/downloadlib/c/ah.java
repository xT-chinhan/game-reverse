package com.ss.android.downloadlib.c;

import com.ss.android.socialbase.appdownloader.ah.ch;
import com.ss.android.socialbase.appdownloader.ah.ny;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ah implements ch {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static volatile ah f4479ms;
    private List<ch> xr;

    public static ah ms() {
        if (f4479ms == null) {
            synchronized (ah.class) {
                if (f4479ms == null) {
                    f4479ms = new ah();
                }
            }
        }
        return f4479ms;
    }

    private ah() {
        ArrayList arrayList = new ArrayList();
        this.xr = arrayList;
        arrayList.add(new xr());
        this.xr.add(new ms());
    }

    @Override // com.ss.android.socialbase.appdownloader.ah.ch
    public void ms(DownloadInfo downloadInfo, ny nyVar) {
        if (downloadInfo != null && this.xr.size() != 0) {
            ms(downloadInfo, 0, nyVar);
        } else if (nyVar != null) {
            nyVar.ms();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final DownloadInfo downloadInfo, final int i, final ny nyVar) {
        if (i == this.xr.size() || i < 0) {
            nyVar.ms();
        } else {
            this.xr.get(i).ms(downloadInfo, new ny() { // from class: com.ss.android.downloadlib.c.ah.1
                @Override // com.ss.android.socialbase.appdownloader.ah.ny
                public void ms() {
                    ah.this.ms(downloadInfo, i + 1, nyVar);
                }
            });
        }
    }
}
