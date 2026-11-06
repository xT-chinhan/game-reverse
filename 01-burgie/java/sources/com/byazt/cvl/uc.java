package com.byazt.cvl;

import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.eld.k;
import com.byazt.fn.y;
import com.byazt.lj.Downloader;
import com.byazt.lj.DownloaderBuilder;
import com.byazt.mdu.DownloadHandlerService;
import com.byazt.zv.a;
import com.byazt.zv.lb;
import com.byazt.zv.m;
import com.byazt.zv.ny;
import com.byazt.zv.w;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CACHE_SEI, 5})
public class uc implements com.byazt.vb.pr {
    @Override // com.byazt.vb.pr
    public com.byazt.vb.pr pr(com.byazt.zv.aj ajVar) {
        k.pr(ajVar);
        return this;
    }

    @Override // com.byazt.vb.pr
    public com.byazt.vb.pr pr(com.byazt.zv.fw fwVar) {
        k.pr(fwVar);
        return this;
    }

    @Override // com.byazt.vb.pr
    public com.byazt.vb.pr pr(m mVar) {
        k.pr(mVar);
        return this;
    }

    @Override // com.byazt.vb.pr
    public com.byazt.vb.pr pr(com.byazt.zv.zo zoVar) {
        k.pr(zoVar);
        return this;
    }

    @Override // com.byazt.vb.pr
    public com.byazt.vb.pr pr(com.byazt.zv.hn hnVar) {
        k.pr(hnVar);
        return this;
    }

    @Override // com.byazt.vb.pr
    public com.byazt.vb.pr pr(w wVar) {
        k.pr(wVar);
        return this;
    }

    @Override // com.byazt.vb.pr
    public com.byazt.vb.pr pr(com.byazt.cxa.pr prVar) {
        k.pr(prVar);
        return this;
    }

    @Override // com.byazt.vb.pr
    public com.byazt.vb.pr pr(String str) {
        k.pr(str);
        return this;
    }

    @Override // com.byazt.vb.pr
    public com.byazt.vb.pr pr(com.byazt.zkm.hn hnVar) {
        k.pr(hnVar);
        return this;
    }

    @Override // com.byazt.vb.pr
    public com.byazt.vb.pr pr(final com.byazt.zv.hw hwVar) {
        k.pr(hwVar);
        com.byazt.wel.pr.pr().pr(new com.byazt.wel.pr.hn() { // from class: com.byazt.cvl.uc.1
        });
        return this;
    }

    @Override // com.byazt.vb.pr
    public com.byazt.vb.pr pr(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder.getNotificationClickCallback() == null) {
            downloaderBuilder.notificationClickCallback(new y() { // from class: com.byazt.cvl.uc.2
                @Override // com.byazt.fn.y
                public boolean pr(DownloadInfo downloadInfo) {
                    com.byazt.ew.pr prVarPr = com.byazt.ew.pr.pr(downloadInfo.getId());
                    if (prVarPr.hw("notification_opt_2") == 1) {
                        if (downloadInfo.getStatus() == -2) {
                            DownloadHandlerService.pr(k.getContext(), downloadInfo, com.byazt.mdu.x.w().hn(), Downloader.getInstance(k.getContext()).getDownloadNotificationEventListener(downloadInfo.getId()));
                        }
                        return true;
                    }
                    boolean zX = x(downloadInfo);
                    if (prVarPr.pr("disable_delete_dialog", 0) == 1) {
                        return true;
                    }
                    return zX;
                }

                private boolean x(DownloadInfo downloadInfo) {
                    String strPr;
                    ny nyVarQa = k.qa();
                    if (nyVarQa != null) {
                        com.byazt.tia.hw hwVarPr = com.byazt.shh.uc.pr().pr(downloadInfo);
                        if (hwVarPr != null && hwVarPr.hn()) {
                            strPr = com.byazt.ew.pr.pr(downloadInfo.getId()).pr("ad_notification_jump_url", (String) null);
                        } else {
                            strPr = com.byazt.eld.aj.pr(downloadInfo);
                        }
                        if (!TextUtils.isEmpty(strPr)) {
                            return nyVarQa.pr(k.getContext(), strPr);
                        }
                        return false;
                    }
                    return false;
                }

                @Override // com.byazt.fn.y
                public boolean hw(DownloadInfo downloadInfo) {
                    return false;
                }

                @Override // com.byazt.fn.y
                public boolean hn(DownloadInfo downloadInfo) {
                    if (downloadInfo == null) {
                        return false;
                    }
                    com.byazt.tia.hw hwVarPr = com.byazt.shh.uc.pr().pr(downloadInfo);
                    if (hwVarPr != null) {
                        com.byazt.ds.pr.pr(hwVarPr);
                    } else {
                        com.byazt.uk.aj.hw(k.getContext(), downloadInfo.getPackageName());
                    }
                    com.byazt.lxs.hw.pr().uc(downloadInfo.getId());
                    return true;
                }
            });
        }
        downloaderBuilder.addDownloadCompleteHandler(new com.byazt.sxm.hn());
        Downloader.initOrCover(downloaderBuilder, true);
        return this;
    }

    @Override // com.byazt.vb.pr
    public com.byazt.vb.pr pr(com.byazt.zkm.fw fwVar) {
        com.byazt.mdu.x.w().pr(fwVar);
        return this;
    }

    @Override // com.byazt.vb.pr
    public com.byazt.vb.pr pr(lb lbVar) {
        k.pr(lbVar);
        return this;
    }

    @Override // com.byazt.vb.pr
    public com.byazt.vb.pr pr(a aVar) {
        k.pr(aVar);
        return this;
    }

    @Override // com.byazt.vb.pr
    public com.byazt.vb.pr pr(com.byazt.zv.vk vkVar) {
        k.pr(vkVar);
        return this;
    }

    @Override // com.byazt.vb.pr
    public void pr() {
        if (!k.rc()) {
            com.byazt.vi.hn.pr().pr("ttdownloader init error");
        }
        k.pr(com.byazt.vi.hn.pr());
        try {
            com.byazt.mdu.x.w().hw(k.fo());
        } catch (Exception e) {
        }
        com.byazt.mdu.x.w().pr(pr.pr());
        c.pr().hw(new Runnable() { // from class: com.byazt.cvl.uc.3
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.now.c.pr("");
                if (com.byazt.now.c.ho()) {
                    com.byazt.lj.hn.pr(true);
                }
                if (com.byazt.ew.pr.hn().pr("disable_security_init", 1) == 1) {
                    com.byazt.now.uc.pr(k.getContext());
                }
            }
        });
    }
}
