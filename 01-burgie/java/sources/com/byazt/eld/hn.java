package com.byazt.eld;

import com.byazt.auw.DownloadInfo;
import com.byazt.bek.DownloadModel;
import com.byazt.km.AdDownloadModel;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 128, 20})
public class hn {
    public static volatile hn hw;
    public static String pr = hn.class.getSimpleName();
    public ConcurrentHashMap<Long, Runnable> hn;

    public hn() {
        this.hn = null;
        this.hn = new ConcurrentHashMap<>();
    }

    public static hn pr() {
        if (hw == null) {
            synchronized (hn.class) {
                if (hw == null) {
                    hw = new hn();
                }
            }
        }
        return hw;
    }

    public void pr(c cVar, boolean z, int i, DownloadModel downloadModel) {
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        long id = downloadModel.getId();
        switch (i) {
            case 4:
                if (!z) {
                    pr(id, false, 2);
                    cVar.hw(false);
                } else {
                    pr(id, true, 2);
                }
                break;
            case 5:
                if (!z) {
                    pr(id, false, 1);
                    cVar.hn(false);
                } else {
                    pr(id, true, 1);
                }
                break;
            case 7:
                Runnable runnableRemove = this.hn.remove(Long.valueOf(id));
                if (z) {
                    com.byazt.mf.pr.pr().pr(id, 1);
                    pr(id, true, 1);
                } else {
                    if (runnableRemove != null) {
                        com.byazt.cvl.zo.pr().hw().post(runnableRemove);
                    }
                    pr(id, false, 1);
                }
                break;
        }
    }

    private void pr(long j, boolean z, int i) {
        com.byazt.mf.pr.pr().pr(j, z, i);
        if (z) {
            k.cz().pr(null, null, null, null, null, 3);
        }
    }

    public void pr(final c cVar, final int i, final DownloadModel downloadModel) {
        com.byazt.ds.c.pr().pr(new com.byazt.ds.x() { // from class: com.byazt.eld.hn.1
            @Override // com.byazt.ds.x
            public void pr(boolean z) {
                hn.this.pr(cVar, z, i, downloadModel);
            }
        }, hw());
    }

    public long hw() {
        return k.aj().optLong("quick_app_check_internal", 1200L);
    }

    public static boolean pr(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.getStatus() == 0 || downloadInfo.getStatus() == -4) {
            return true;
        }
        return false;
    }
}
