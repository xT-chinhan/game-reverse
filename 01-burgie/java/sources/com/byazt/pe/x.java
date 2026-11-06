package com.byazt.pe;

import android.os.Bundle;
import android.text.TextUtils;
import com.byazt.ca.ho;
import com.byazt.ca.yb;
import com.byazt.hg.i;
import com.byazt.hg.of;
import com.byazt.sd.a;
import com.byazt.sd.fo;
import com.byazt.zp.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA, 121})
public class x<T> extends hw {
    public final long hw;

    private interface pr {
        void pr(boolean z);
    }

    public x(int i) {
        super(i);
        this.hw = System.currentTimeMillis();
    }

    public void pr(final com.byazt.qe.hw hwVar, final i iVar, final c<T> cVar) {
        zo.c(new Runnable() { // from class: com.byazt.pe.x.1
            @Override // java.lang.Runnable
            public void run() {
                x.this.hw(hwVar, iVar, new uc(cVar));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(com.byazt.qe.hw hwVar, i iVar, c<T> cVar) {
        if (hwVar == null) {
        }
        int iHn = hn();
        if (iVar.a) {
            iHn = 0;
        }
        int i = com.byazt.hg.zo.pr(this.pr).pr("load_only_online", new com.byazt.hg.zo.hw.pr().pr(hwVar).pr()) ? 0 : iHn;
        hwVar.x();
        switch (i) {
            case 0:
                x(hwVar, cVar, iVar);
                break;
            case 1:
                pr(hwVar, cVar, iVar);
                break;
            case 2:
                hw(hwVar, cVar, iVar);
                break;
            case 3:
                hn(hwVar, cVar, iVar);
                break;
            case 4:
                c(hwVar, cVar, iVar);
                break;
            case 5:
                fw(hwVar, cVar, iVar);
                break;
            default:
                ho.hw("cache_tag", "仅实时：走到了兜底逻辑，预期不会走到！！！");
                x(hwVar, cVar, iVar);
                break;
        }
    }

    private void pr(final com.byazt.qe.hw hwVar, final c<T> cVar, final i iVar) {
        final com.byazt.eb.pr prVar = new com.byazt.eb.pr(cVar, pr()) { // from class: com.byazt.pe.x.6
            @Override // com.byazt.eb.pr
            public void pr() {
                x.this.pr(hwVar, cVar, iVar, this);
            }
        };
        pr(hwVar, cVar, iVar.fw == 2, prVar, 0L, new pr() { // from class: com.byazt.pe.x.7
            @Override // com.byazt.pe.x.pr
            public void pr(boolean z) {
                if (!z) {
                    prVar.pr(false);
                }
            }
        });
    }

    private void hw(com.byazt.qe.hw hwVar, c<T> cVar, i iVar) {
        final com.byazt.eb.x xVar = new com.byazt.eb.x(cVar, pr(), this.pr, hwVar.x());
        xVar.pr();
        pr(hwVar, cVar, iVar, xVar);
        pr(hwVar, cVar, iVar.fw == 2, xVar, 0L, new pr() { // from class: com.byazt.pe.x.8
            @Override // com.byazt.pe.x.pr
            public void pr(boolean z) {
                xVar.pr(true);
            }
        });
    }

    private void hn(com.byazt.qe.hw hwVar, c<T> cVar, i iVar) {
        final com.byazt.eb.hn hnVar = new com.byazt.eb.hn(cVar, pr());
        pr(hwVar, cVar, iVar, hnVar);
        pr(hwVar, cVar, iVar.fw == 2, hnVar, 0L, new pr() { // from class: com.byazt.pe.x.9
            @Override // com.byazt.pe.x.pr
            public void pr(boolean z) {
                if (!z) {
                    hnVar.pr(false);
                }
            }
        });
    }

    private void x(com.byazt.qe.hw hwVar, c<T> cVar, i iVar) {
        pr(hwVar, cVar, iVar, (com.byazt.eb.hw) null);
    }

    private void c(com.byazt.qe.hw hwVar, final c<T> cVar, i iVar) {
        pr(hwVar, cVar, iVar.fw == 2, (com.byazt.eb.hw) null, 0L, new pr() { // from class: com.byazt.pe.x.10
            @Override // com.byazt.pe.x.pr
            public void pr(boolean z) {
                if (!z) {
                    cVar.pr(-3, "no cache");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uc(final com.byazt.qe.hw hwVar, c<T> cVar, i iVar) {
        long j;
        final com.byazt.hg.zo.x xVarW = pr().w();
        final com.byazt.ra.uc.pr prVarPr = com.byazt.ra.uc.pr(hwVar.x(), xVarW);
        final com.byazt.eb.x xVar = new com.byazt.eb.x(cVar, pr(), this.pr, hwVar.x());
        xVar.pr();
        pr(hwVar, cVar, iVar, xVar);
        hwVar.x();
        final int iPr = prVarPr.pr(xVarW.c(), xVarW);
        if (iPr < 0) {
            hwVar.x();
            xVar.pr(false);
            return;
        }
        if (iPr <= 0) {
            j = 0;
        } else {
            long jCurrentTimeMillis = System.currentTimeMillis() - ((((long) iPr) * 60) * 1000);
            hwVar.x();
            j = jCurrentTimeMillis;
        }
        pr(hwVar, cVar, iVar.fw == 2, xVar, j, new pr() { // from class: com.byazt.pe.x.11
            @Override // com.byazt.pe.x.pr
            public void pr(boolean z) {
                hwVar.x();
                xVar.pr(z);
                if (z) {
                    prVarPr.pr(x.this.pr, hwVar, xVarW, "backup_cache", new StringBuilder().append(iPr).toString());
                }
            }
        });
    }

    private void fw(com.byazt.qe.hw hwVar, c<T> cVar, i iVar) {
        double d;
        com.byazt.hg.zo.x xVarW = pr().w();
        com.byazt.ra.uc.pr prVarPr = com.byazt.ra.uc.pr(hwVar.x(), xVarW);
        if (xVarW.hw() > 0) {
            hwVar.x();
            try {
                d = Double.parseDouble(com.byazt.ba.pr.pr().pr("DeviceRate", "bytebench_value", hwVar.gz()));
            } catch (Exception e) {
                d = 0.0d;
            }
            if (d > 0.0d && d < xVarW.hw()) {
                hwVar.x();
                pr(hwVar, (c) cVar, iVar, true, 0L, "device_score", String.valueOf(d));
                return;
            }
        }
        if (xVarW.hn() > 0) {
            hwVar.x();
            int iHn = yb.hn(a.getContext());
            boolean z = false;
            switch (iHn) {
                case 2:
                    if ((xVarW.hn() & 1) != 0) {
                        z = true;
                    }
                    break;
                case 3:
                    if ((xVarW.hn() & 2) != 0) {
                        z = true;
                    }
                    break;
                case 4:
                    if ((xVarW.hn() & 16) != 0) {
                        z = true;
                    }
                    break;
                case 5:
                    if ((xVarW.hn() & 4) != 0) {
                        z = true;
                    }
                    break;
                case 6:
                    if ((xVarW.hn() & 8) != 0) {
                        z = true;
                    }
                    break;
            }
            if (z) {
                hwVar.x();
                pr(hwVar, (c) cVar, iVar, true, 0L, "net_type", String.valueOf(iHn));
                return;
            }
        }
        if (xVarW.x() > 0) {
            hwVar.x();
            int iPr = prVarPr.pr(xVarW.x(), xVarW);
            if (iPr > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis() - ((((long) iPr) * 60) * 1000);
                hwVar.x();
                pr(hwVar, (c) cVar, iVar, true, jCurrentTimeMillis, "good_cache", String.valueOf(iPr));
                return;
            } else if (iPr == 0) {
                hwVar.x();
                pr(hwVar, (c) cVar, iVar, true, 0L, "behavior_score", String.valueOf(iPr));
                return;
            }
        }
        hwVar.x();
        pr(hwVar, (c) cVar, iVar, false, 0L, "", "");
    }

    private void pr(final com.byazt.qe.hw hwVar, final c<T> cVar, final i iVar, boolean z, long j, final String str, final String str2) {
        final com.byazt.hg.zo.x xVarW = pr().w();
        final com.byazt.ra.uc.pr prVarPr = com.byazt.ra.uc.pr(hwVar.x(), xVarW);
        if (z) {
            hwVar.x();
            final com.byazt.eb.pr prVar = new com.byazt.eb.pr(cVar, pr()) { // from class: com.byazt.pe.x.12
                @Override // com.byazt.eb.pr
                public void pr() {
                    hwVar.x();
                    x.this.uc(hwVar, cVar, iVar);
                }
            };
            pr(hwVar, cVar, iVar.fw == 2, prVar, j, new pr() { // from class: com.byazt.pe.x.13
                @Override // com.byazt.pe.x.pr
                public void pr(boolean z2) {
                    hwVar.x();
                    if (!z2) {
                        prVar.pr(false);
                    } else {
                        prVarPr.pr(x.this.pr, hwVar, xVarW, str, str2);
                    }
                }
            });
        } else {
            hwVar.x();
            uc(hwVar, cVar, iVar);
        }
    }

    private void pr(final com.byazt.qe.hw hwVar, final c<T> cVar, final boolean z, final com.byazt.eb.hw hwVar2, long j, final pr prVar) {
        List<of> listPr;
        hwVar.x();
        if (!TextUtils.isEmpty(hwVar.cz())) {
            prVar.pr(false);
            hwVar.x();
            return;
        }
        if (pr(z) == null) {
            ho.hw("cache_tag", "广告类型 " + this.pr + " ---缓存请求结束--- rit: " + hwVar.x() + " 无配置");
            prVar.pr(false);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iMin = Math.min(com.byazt.hg.zo.pr(this.pr).k(), hwVar.k());
        double dNt = com.byazt.hg.zo.pr(this.pr).nt();
        if (hw() != null) {
            hw().hw(hwVar.x());
            listPr = hw().pr(hwVar.x(), j, iMin, dNt);
        } else {
            listPr = null;
        }
        if (listPr == null || listPr.isEmpty()) {
            prVar.pr(false);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (of ofVar : listPr) {
            if (pr(ofVar)) {
                arrayList.add(ofVar);
            }
        }
        if (arrayList.isEmpty()) {
            prVar.pr(false);
            return;
        }
        if (!pr(z).pr(hwVar, arrayList)) {
            prVar.pr(false);
            return;
        }
        hwVar.x();
        arrayList.size();
        com.byazt.xe.pr prVar2 = new com.byazt.xe.pr(this.pr);
        prVar2.pr(jCurrentTimeMillis);
        prVar2.hw(System.currentTimeMillis());
        prVar2.pr(arrayList, new com.byazt.xe.uc() { // from class: com.byazt.pe.x.2
            @Override // com.byazt.xe.uc
            public void pr(List<of> list) {
                x.this.pr(list, hwVar, z, hwVar2, cVar, prVar);
            }

            @Override // com.byazt.xe.uc
            public void hw(List<of> list) {
                hwVar.x();
                list.size();
                if (!list.isEmpty()) {
                    x.this.pr(list, hwVar, z, hwVar2, cVar, prVar);
                } else {
                    prVar.pr(false);
                }
            }

            @Override // com.byazt.xe.uc
            public void hn(List<of> list) {
                Iterator<of> it = list.iterator();
                while (it.hasNext()) {
                    x.this.hw().pr(hwVar.x(), it.next());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final com.byazt.qe.hw hwVar, final c<T> cVar, final i iVar, final com.byazt.eb.hw hwVar2) {
        hwVar.x();
        a.pr().pr(hwVar, iVar, this.pr, new fo.hw() { // from class: com.byazt.pe.x.3
            @Override // com.byazt.sd.fo.hw
            public void pr(int i, String str, com.byazt.hg.hw hwVar3) {
                hwVar.x();
                if (x.this.pr(iVar.fw == 2) != null) {
                    x.this.pr(iVar.fw == 2).pr(hwVar, i, str, hwVar3);
                }
                com.byazt.eb.hw hwVar4 = hwVar2;
                if (hwVar4 != null) {
                    hwVar4.pr(i, str);
                    return;
                }
                c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.pr(i, str);
                }
            }

            @Override // com.byazt.sd.fo.hw
            public void pr(final com.byazt.hg.pr prVar, final com.byazt.hg.hw hwVar3) {
                hwVar.x();
                com.byazt.ci.pr prVarPr = x.this.pr(iVar.fw == 2);
                if (prVarPr == null) {
                    return;
                }
                prVarPr.pr(x.this.pr, prVar, hwVar3, iVar, hwVar, cVar, new fw() { // from class: com.byazt.pe.x.3.1
                    @Override // com.byazt.pe.fw
                    public void pr(hn hnVar) {
                        hwVar.x();
                        if (x.this.pr(x.this.pr(hwVar, prVar, hwVar2))) {
                            hwVar.x();
                            if (hnVar != null) {
                                hnVar.hn();
                            }
                            if (hwVar2 == null) {
                                if (cVar != null) {
                                    cVar.pr(-3, com.byazt.sd.fw.pr(-3));
                                    return;
                                }
                                return;
                            } else {
                                hwVar2.hw(-3, com.byazt.sd.fw.pr(-3));
                                hwVar2.hn();
                                return;
                            }
                        }
                        if (hnVar != null) {
                            if (hwVar2 == null) {
                                hnVar.pr();
                            } else {
                                hwVar2.pr(hnVar);
                            }
                        }
                        if (hwVar2 != null) {
                            hwVar2.hn();
                        }
                    }

                    @Override // com.byazt.pe.fw
                    public void pr(int i) {
                        if (cVar != null) {
                            cVar.pr(i, com.byazt.sd.fw.pr(i));
                        }
                        hwVar3.pr(i);
                        com.byazt.hg.hw.pr(hwVar3);
                        if (hwVar2 != null) {
                            hwVar2.hn();
                        }
                    }
                });
            }
        });
    }

    public void pr(final com.byazt.qe.hw hwVar, final i iVar) {
        if (hwVar == null) {
            return;
        }
        hwVar.a();
        if (!com.byazt.dz.x.pr(hwVar.ny())) {
            hwVar.a();
            return;
        }
        if (com.byazt.hg.zo.pr(this.pr).pr("forbid_preload", new com.byazt.hg.zo.hw.pr().pr(hwVar).pr())) {
            hwVar.a();
            hwVar.x();
            return;
        }
        if (hn() == 0) {
            hwVar.a();
            return;
        }
        if (!hw().pr(hwVar.x())) {
            hwVar.a();
            return;
        }
        if (!TextUtils.isEmpty(hwVar.cz())) {
            hwVar.a();
            if (pr(iVar.fw == 2) != null) {
                pr(iVar.fw == 2).pr(hwVar);
                return;
            }
            return;
        }
        zo.c(new Runnable() { // from class: com.byazt.pe.x.4
            @Override // java.lang.Runnable
            public void run() {
                hwVar.a();
                x.this.pr(hwVar, (c) null, iVar, (com.byazt.eb.hw) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final List<of> list, final com.byazt.qe.hw hwVar, boolean z, final com.byazt.eb.hw hwVar2, c<T> cVar, final pr prVar) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_playAgain", false);
        bundle.putBoolean("is_cache", true);
        bundle.putLong(d.p, this.hw);
        pr(z).pr(this.pr, list, hwVar, cVar, bundle, new fw() { // from class: com.byazt.pe.x.5
            @Override // com.byazt.pe.fw
            public void pr(hn hnVar) {
                com.byazt.eb.hw hwVar3 = hwVar2;
                if (hwVar3 != null) {
                    hwVar3.hw(hnVar);
                    hwVar2.pr(true);
                    list.size();
                    hwVar.x();
                } else {
                    hnVar.pr();
                    list.size();
                    hwVar.x();
                }
                prVar.pr(true);
            }

            @Override // com.byazt.pe.fw
            public void pr(int i) {
            }
        });
    }

    private int hn() {
        if (pr() == null) {
            return com.byazt.pe.pr.pr(this.pr);
        }
        if (pr().aj() < 0 || pr().aj() > 5) {
            return com.byazt.pe.pr.pr(this.pr);
        }
        return pr().aj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.hg.zo.hw pr(com.byazt.qe.hw hwVar, com.byazt.hg.pr prVar, com.byazt.eb.hw hwVar2) {
        com.byazt.hg.zo.hw.pr prVarPr = new com.byazt.hg.zo.hw.pr().pr(hwVar).pr(hwVar2 != null && hwVar2.x());
        of ofVarPr = pr(prVar);
        if (ofVarPr != null) {
            prVarPr.pr(ofVarPr);
        }
        return prVarPr.pr();
    }

    private of pr(com.byazt.hg.pr prVar) {
        if (prVar == null || prVar.hw() == null || prVar.hw().isEmpty()) {
            return null;
        }
        return prVar.hw().get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pr(com.byazt.hg.zo.hw hwVar) {
        return com.byazt.hg.zo.pr(this.pr).pr("forbid_realtime", hwVar);
    }
}
