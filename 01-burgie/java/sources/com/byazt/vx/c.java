package com.byazt.vx;

import android.text.TextUtils;
import com.byazt.hg.i;
import com.byazt.zn.fw;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1155, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public com.byazt.ks.pr aj;
    public com.byazt.zn.c c;
    public fw fw;
    public volatile boolean hn;
    public volatile boolean hw;
    public volatile boolean pr;
    public hw<com.byazt.zn.uc, fw> uc;
    public com.byazt.jm.hw vk;
    public volatile boolean x;
    public com.byazt.zn.uc zo;

    public c(com.byazt.zn.c cVar, hw<com.byazt.zn.uc, fw> hwVar, com.byazt.ks.pr prVar, com.byazt.jm.hw hwVar2) {
        if (cVar == null || hwVar == null) {
            return;
        }
        this.c = cVar;
        this.uc = hwVar;
        this.aj = prVar;
        this.vk = hwVar2;
    }

    public void pr(final int i) {
        if (this.c == null || this.uc == null) {
            return;
        }
        com.byazt.nz.pr.pr("Splash_FullLink", "loadAd Type ".concat(String.valueOf(i)));
        switch (i) {
            case 0:
                new com.byazt.gj.hn().pr(this.c, this.uc);
                break;
            case 1:
                new com.byazt.gj.pr(this.aj).pr(this.c, new hw<com.byazt.zn.uc, fw>() { // from class: com.byazt.vx.c.1
                    @Override // com.byazt.vx.hw
                    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
                    public void hw(com.byazt.zn.uc ucVar) {
                        c.this.uc.hw(ucVar);
                        if (com.byazt.ks.pr.pr(i) && c.this.aj != null && c.this.c != null) {
                            c.this.aj.hw(c.this.c.x(), c.this.c.c());
                        }
                    }

                    @Override // com.byazt.vx.hw
                    public void pr(fw fwVar) {
                        if (fwVar != null && c.this.c != null) {
                            c.this.c.pr(fwVar.x());
                            c.this.c.pr(fwVar.hn());
                        }
                        if (c.this.vk == null || !c.this.vk.hw()) {
                            new com.byazt.gj.hn().pr(c.this.c, new hw<com.byazt.zn.uc, fw>() { // from class: com.byazt.vx.c.1.1
                                @Override // com.byazt.vx.hw
                                /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
                                public void hw(com.byazt.zn.uc ucVar) {
                                    if (c.this.x) {
                                        if (c.this.aj != null && c.this.c != null) {
                                            c.this.aj.pr(ucVar, c.this.c.x(), true, 1);
                                            return;
                                        }
                                        return;
                                    }
                                    c.this.uc.hw(ucVar);
                                }

                                @Override // com.byazt.vx.hw
                                public void pr(fw fwVar2) {
                                    c.this.uc.pr(fwVar2);
                                    if (com.byazt.ks.pr.pr(i) && c.this.aj != null && c.this.c != null) {
                                        c.this.aj.hw(c.this.c.x(), c.this.c.c());
                                    }
                                }
                            });
                        } else {
                            c.this.uc.pr(fwVar);
                        }
                    }
                });
                break;
            case 2:
                new com.byazt.gj.hn().pr(this.c, new hw<com.byazt.zn.uc, fw>() { // from class: com.byazt.vx.c.2
                    @Override // com.byazt.vx.hw
                    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
                    public void hw(com.byazt.zn.uc ucVar) {
                        c.this.zo = ucVar;
                        if (c.this.fw != null && ucVar != null) {
                            ucVar.pr(c.this.fw.x());
                            ucVar.pr(c.this.fw.hn());
                        }
                        com.byazt.nz.pr.pr("Splash_FullLink", "实时物料加载成功 isCache " + ucVar.c());
                        c.this.uc.hw(ucVar);
                    }

                    @Override // com.byazt.vx.hw
                    public void pr(fw fwVar) {
                        com.byazt.nz.pr.pr("Splash_FullLink", "实时物料加载失败 ");
                        c.this.uc.pr(fwVar);
                    }
                });
                new com.byazt.gj.pr(this.aj).pr(this.c, new hw<com.byazt.zn.uc, fw>() { // from class: com.byazt.vx.c.3
                    @Override // com.byazt.vx.hw
                    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
                    public void hw(com.byazt.zn.uc ucVar) {
                        com.byazt.nz.pr.pr("Splash_FullLink", "缓存物料加载成功 isCache " + ucVar.c());
                        c.this.uc.hw(ucVar);
                    }

                    @Override // com.byazt.vx.hw
                    public void pr(fw fwVar) {
                        c.this.fw = fwVar;
                        com.byazt.nz.pr.pr("Splash_FullLink", "缓存物料加载失败  ");
                        if (c.this.zo != null && fwVar != null) {
                            c.this.zo.pr(fwVar.x());
                            c.this.zo.pr(fwVar.hn());
                        }
                        c.this.uc.pr(fwVar);
                    }
                });
                break;
            case 3:
                new com.byazt.gj.hn().pr(this.c, new hw<com.byazt.zn.uc, fw>() { // from class: com.byazt.vx.c.4
                    @Override // com.byazt.vx.hw
                    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
                    public void hw(com.byazt.zn.uc ucVar) {
                        c.this.zo = ucVar;
                        if (c.this.hn || c.this.x) {
                            if (c.this.aj != null && c.this.c != null) {
                                c.this.aj.pr(ucVar, c.this.c.x(), true, 3);
                                return;
                            }
                            return;
                        }
                        if (c.this.fw != null && ucVar != null) {
                            ucVar.pr(c.this.fw.x());
                            ucVar.pr(c.this.fw.hn());
                        }
                        c.this.hn = true;
                        c.this.uc.hw(ucVar);
                    }

                    @Override // com.byazt.vx.hw
                    public void pr(fw fwVar) {
                        c.this.pr = true;
                        if (c.this.hw) {
                            c.this.uc.pr(fwVar);
                        }
                        if (com.byazt.ks.pr.pr(i) && c.this.aj != null && c.this.c != null) {
                            c.this.aj.hw(c.this.c.x(), c.this.c.c());
                        }
                    }
                });
                new com.byazt.gj.pr(this.aj).pr(this.c, new hw<com.byazt.zn.uc, fw>() { // from class: com.byazt.vx.c.5
                    @Override // com.byazt.vx.hw
                    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
                    public void hw(com.byazt.zn.uc ucVar) {
                        if (c.this.hn) {
                            return;
                        }
                        c.this.hn = true;
                        c.this.uc.hw(ucVar);
                    }

                    @Override // com.byazt.vx.hw
                    public void pr(fw fwVar) {
                        c.this.fw = fwVar;
                        if (c.this.zo != null && fwVar != null) {
                            c.this.zo.pr(fwVar.x());
                            c.this.zo.pr(fwVar.hn());
                        }
                        c.this.hw = true;
                        if (c.this.pr) {
                            c.this.uc.pr(fwVar);
                        }
                    }
                });
                break;
            case 4:
                new com.byazt.gj.pr(this.aj).pr(this.c, new hw<com.byazt.zn.uc, fw>() { // from class: com.byazt.vx.c.6
                    @Override // com.byazt.vx.hw
                    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
                    public void hw(com.byazt.zn.uc ucVar) {
                        c.this.uc.hw(ucVar);
                    }

                    @Override // com.byazt.vx.hw
                    public void pr(fw fwVar) {
                        c.this.uc.pr(fwVar);
                    }
                });
                break;
        }
    }

    public void pr() {
        this.x = true;
    }

    public static boolean pr(com.byazt.qe.hw hwVar, i iVar) {
        if (hwVar == null || iVar == null || TextUtils.isEmpty(hwVar.cz()) || iVar.c > 0) {
            return false;
        }
        return true;
    }
}
