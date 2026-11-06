package com.ss.android.downloadlib.addownload;

import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class ah {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static String f4355ms = "ah";
    private static volatile ah xr;
    private ConcurrentHashMap<Long, Runnable> ah;

    public ah() {
        this.ah = null;
        this.ah = new ConcurrentHashMap<>();
    }

    public static ah ms() {
        if (xr == null) {
            synchronized (ah.class) {
                if (xr == null) {
                    xr = new ah();
                }
            }
        }
        return xr;
    }

    public void ms(ka kaVar, boolean z, int i, DownloadModel downloadModel) {
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        long id = downloadModel.getId();
        if (i == 4) {
            if (!z) {
                ms(id, false, 2);
                kaVar.xr(false);
                return;
            } else {
                ms(id, true, 2);
                return;
            }
        }
        if (i == 5) {
            if (!z) {
                ms(id, false, 1);
                kaVar.ah(false);
                return;
            } else {
                ms(id, true, 1);
                return;
            }
        }
        if (i != 7) {
            return;
        }
        Runnable runnableRemove = this.ah.remove(Long.valueOf(id));
        if (z) {
            com.ss.android.downloadlib.d.ms.ms().ms(id, 1);
            ms(id, true, 1);
        } else {
            if (runnableRemove != null) {
                com.ss.android.downloadlib.x.ms().xr().post(runnableRemove);
            }
            ms(id, false, 1);
        }
    }

    private void ms(long j, boolean z, int i) {
        com.ss.android.downloadlib.d.ms.ms().ms(j, z, i);
        if (z) {
            hi.nw();
        }
    }

    public void ms(final ka kaVar, final int i, final DownloadModel downloadModel) {
        com.ss.android.downloadlib.xr.ka.ms().ms(new com.ss.android.downloadlib.xr.d() { // from class: com.ss.android.downloadlib.addownload.ah.1
            @Override // com.ss.android.downloadlib.xr.d
            public void ms(boolean z) {
                ah.this.ms(kaVar, z, i, downloadModel);
            }
        }, xr());
    }

    public long xr() {
        return hi.ny().optLong("quick_app_check_internal", 1200L);
    }

    public static boolean ms(DownloadInfo downloadInfo) {
        return downloadInfo == null || downloadInfo.getStatus() == 0 || downloadInfo.getStatus() == -4;
    }
}
