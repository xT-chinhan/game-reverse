package com.byazt.s;

import android.text.TextUtils;
import com.byazt.e.DownloadHandlerService;
import com.byazt.je.lh;
import com.byazt.ky.a;
import com.byazt.ky.cd;
import com.byazt.ky.cp;
import com.byazt.ky.oa;
import com.byazt.ky.ou;
import com.byazt.ug.d;
import com.byazt.wm.DownloadInfo;
import com.byazt.xv.Downloader;
import com.byazt.xv.DownloaderBuilder;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 8, 13})
public class w implements com.byazt.cc.n {
    @Override // com.byazt.cc.n
    public com.byazt.cc.n n(com.byazt.ky.rv rvVar) {
        d.n(rvVar);
        return this;
    }

    @Override // com.byazt.cc.n
    public com.byazt.cc.n n(com.byazt.ky.x xVar) {
        d.n(xVar);
        return this;
    }

    @Override // com.byazt.cc.n
    public com.byazt.cc.n n(oa oaVar) {
        d.n(oaVar);
        return this;
    }

    @Override // com.byazt.cc.n
    public com.byazt.cc.n n(com.byazt.ky.fs fsVar) {
        d.n(fsVar);
        return this;
    }

    @Override // com.byazt.cc.n
    public com.byazt.cc.n n(com.byazt.ky.s sVar) {
        d.n(sVar);
        return this;
    }

    @Override // com.byazt.cc.n
    public com.byazt.cc.n n(cp cpVar) {
        d.n(cpVar);
        return this;
    }

    @Override // com.byazt.cc.n
    public com.byazt.cc.n n(com.byazt.os.n nVar) {
        d.n(nVar);
        return this;
    }

    @Override // com.byazt.cc.n
    public com.byazt.cc.n n(String str) {
        d.n(str);
        return this;
    }

    @Override // com.byazt.cc.n
    public com.byazt.cc.n n(com.byazt.z.s sVar) {
        d.n(sVar);
        return this;
    }

    @Override // com.byazt.cc.n
    public com.byazt.cc.n n(final com.byazt.ky.qg qgVar) {
        d.n(qgVar);
        com.byazt.b.n.n().n(new com.byazt.b.n.s() { // from class: com.byazt.s.w.1
        });
        return this;
    }

    @Override // com.byazt.cc.n
    public com.byazt.cc.n n(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder.getNotificationClickCallback() == null) {
            downloaderBuilder.notificationClickCallback(new lh() { // from class: com.byazt.s.w.2
                @Override // com.byazt.je.lh
                public boolean qg(DownloadInfo downloadInfo) {
                    return false;
                }

                @Override // com.byazt.je.lh
                public boolean n(DownloadInfo downloadInfo) {
                    com.byazt.f.n nVarN = com.byazt.f.n.n(downloadInfo.getId());
                    if (nVarN.qg("notification_opt_2") == 1) {
                        if (downloadInfo.getStatus() == -2) {
                            DownloadHandlerService.n(d.getContext(), downloadInfo, com.byazt.e.q.cp().s(), Downloader.getInstance(d.getContext()).getDownloadNotificationEventListener(downloadInfo.getId()));
                        }
                        return true;
                    }
                    boolean zQ = q(downloadInfo);
                    if (nVarN.n("disable_delete_dialog", 0) == 1) {
                        return true;
                    }
                    return zQ;
                }

                private boolean q(DownloadInfo downloadInfo) {
                    String strN;
                    ou ouVarUm = d.um();
                    if (ouVarUm == null) {
                        return false;
                    }
                    com.byazt.h.qg qgVarN = com.byazt.vl.w.n().n(downloadInfo);
                    if (qgVarN != null && qgVarN.s()) {
                        strN = com.byazt.f.n.n(downloadInfo.getId()).n("ad_notification_jump_url", (String) null);
                    } else {
                        strN = com.byazt.ug.rv.n(downloadInfo);
                    }
                    if (TextUtils.isEmpty(strN)) {
                        return false;
                    }
                    return ouVarUm.n(d.getContext(), strN);
                }

                @Override // com.byazt.je.lh
                public boolean s(DownloadInfo downloadInfo) {
                    if (downloadInfo == null) {
                        return false;
                    }
                    com.byazt.h.qg qgVarN = com.byazt.vl.w.n().n(downloadInfo);
                    if (qgVarN != null) {
                        com.byazt.t.n.n(qgVarN);
                    } else {
                        com.byazt.rz.rv.qg(d.getContext(), downloadInfo.getPackageName());
                    }
                    com.byazt.av.qg.n().w(downloadInfo.getId());
                    return true;
                }
            });
        }
        downloaderBuilder.addDownloadCompleteHandler(new com.byazt.ht.s());
        Downloader.initOrCover(downloaderBuilder, true);
        return this;
    }

    @Override // com.byazt.cc.n
    public com.byazt.cc.n n(com.byazt.z.x xVar) {
        com.byazt.e.q.cp().n(xVar);
        return this;
    }

    @Override // com.byazt.cc.n
    public com.byazt.cc.n n(cd cdVar) {
        d.n(cdVar);
        return this;
    }

    @Override // com.byazt.cc.n
    public com.byazt.cc.n n(a aVar) {
        d.n(aVar);
        return this;
    }

    @Override // com.byazt.cc.n
    public com.byazt.cc.n n(com.byazt.ky.tj tjVar) {
        d.n(tjVar);
        return this;
    }

    @Override // com.byazt.cc.n
    public void n() {
        if (!d.m()) {
            com.byazt.ch.s.n().n("ttdownloader init error");
        }
        d.n(com.byazt.ch.s.n());
        try {
            com.byazt.e.q.cp().qg(d.wm());
        } catch (Exception unused) {
        }
        com.byazt.e.q.cp().n(n.n());
        l.n().qg(new Runnable() { // from class: com.byazt.s.w.3
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.bk.l.n("");
                if (com.byazt.bk.l.k()) {
                    com.byazt.xv.s.n(true);
                }
                if (com.byazt.f.n.s().n("disable_security_init", 1) == 1) {
                    com.byazt.bk.w.n(d.getContext());
                }
            }
        });
    }
}
