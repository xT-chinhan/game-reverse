package com.byazt.uko;

import android.text.TextUtils;
import com.byazt.mq.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 931, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class c {
    public com.byazt.rk.zo hn;
    public hw hw;
    public com.byazt.rk.hw pr;
    public pr x;

    @com.byazt.vzx.pr(pr = {0, 1, 931, 169})
    static class pr {
        public float hn;
        public float hw;
        public float pr;
    }

    public c(double d, int i, double d2, String str, m mVar) {
        this.hw = new hw(d, i, d2, str, mVar);
    }

    public void pr(pr prVar) {
        this.x = prVar;
    }

    public void pr() {
        this.hw.pr();
    }

    public void pr(com.byazt.rk.zo zoVar, float f, float f2) {
        if (zoVar != null) {
            this.hn = zoVar;
        }
        com.byazt.rk.zo zoVar2 = this.hn;
        float fZo = zoVar2.zo();
        float fAj = zoVar2.aj();
        float f3 = TextUtils.equals(zoVar2.vk().c().iu(), "fixed") ? fAj : 65536.0f;
        this.hw.pr();
        this.hw.hn(zoVar2, fZo, f3);
        hw.hn hnVarPr = this.hw.pr(zoVar2);
        com.byazt.rk.hw hwVar = new com.byazt.rk.hw();
        hwVar.pr = f;
        hwVar.hw = f2;
        if (hnVarPr != null) {
            fZo = hnVarPr.pr;
        }
        hwVar.hn = fZo;
        if (hnVarPr != null) {
            fAj = hnVarPr.hw;
        }
        hwVar.x = fAj;
        hwVar.c = "root";
        hwVar.aj = 1280.0f;
        hwVar.uc = zoVar2;
        hwVar.uc.hn(hwVar.pr);
        hwVar.uc.x(hwVar.hw);
        hwVar.uc.c(hwVar.hn);
        hwVar.uc.uc(hwVar.x);
        com.byazt.rk.hw hwVarPr = pr(hwVar, 0.0f);
        this.pr = hwVarPr;
        pr(hwVarPr);
    }

    public void pr(com.byazt.rk.hw hwVar) {
        if (hwVar == null) {
            return;
        }
        hwVar.uc.vk().getType();
        List<List<com.byazt.rk.hw>> list = hwVar.fw;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (List<com.byazt.rk.hw> list2 : list) {
            if (list2 != null && list2.size() > 0) {
                Iterator<com.byazt.rk.hw> it = list2.iterator();
                while (it.hasNext()) {
                    pr(it.next());
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:148:0x03c5  */
    /* JADX WARN: Code duplicated, block: B:150:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:151:0x03d6  */
    /* JADX WARN: Code duplicated, block: B:152:0x03d9  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:89:0x0207  */
    public com.byazt.rk.hw pr(com.byazt.rk.hw hwVar, float f) {
        float fPr;
        float fPr2;
        float f2;
        float fPr3;
        float fPr4;
        float f3;
        com.byazt.rk.hw hwVar2;
        com.byazt.rk.aj ajVarPr;
        float f4;
        com.byazt.rk.aj ajVar;
        float f5;
        com.byazt.rk.hw hwVar3 = hwVar;
        com.byazt.rk.zo zoVar = hwVar3.uc;
        if (zoVar == null) {
            return hwVar3;
        }
        zoVar.cz();
        List<List<com.byazt.rk.zo>> listYb = zoVar.yb();
        if (listYb == null) {
            return hwVar3;
        }
        if (listYb.size() <= 0) {
            return hwVar3;
        }
        com.byazt.rk.uc ucVarC = zoVar.vk().c();
        float fYb = ucVarC.yb();
        float fNt = ucVarC.nt();
        float fG = ucVarC.g();
        float fHo = ucVarC.ho();
        float fK = ucVarC.k();
        String strQi = ucVarC.qi();
        String strQn = ucVarC.qn();
        float f6 = hwVar3.pr + fHo;
        float f7 = hwVar3.hw + fYb;
        float f8 = fK * 2.0f;
        float f9 = ((hwVar3.hn - fHo) - fNt) - f8;
        float f10 = ((hwVar3.x - fYb) - fG) - f8;
        com.byazt.rk.aj ajVar2 = new com.byazt.rk.aj(f6, f7);
        if (hwVar3.fw == null) {
            hwVar3.fw = new ArrayList();
        }
        Iterator<List<com.byazt.rk.zo>> it = listYb.iterator();
        float f11 = 0.0f;
        while (it.hasNext()) {
            hw.hn hnVarPr = this.hw.pr(it.next());
            if (hnVarPr != null) {
                f11 += hnVarPr.hw;
            }
        }
        String str = "space-between";
        String str2 = "space-around";
        if (f11 < f10) {
            if (TextUtils.equals(strQn, "center")) {
                fPr2 = (f10 - f11) / 2.0f;
                fPr = 0.0f;
            } else if (TextUtils.equals(strQn, "flex-end")) {
                fPr2 = f10 - f11;
                fPr = 0.0f;
            } else if (TextUtils.equals(strQn, "space-around")) {
                fPr2 = vk.pr((f10 - f11) / (listYb.size() + 1));
                fPr = fPr2;
            } else if (TextUtils.equals(strQn, "space-between") && listYb.size() > 1) {
                fPr = vk.pr((f10 - f11) / (listYb.size() - 1));
                fPr2 = 0.0f;
            } else {
                fPr = 0.0f;
                fPr2 = 0.0f;
            }
        } else {
            fPr = 0.0f;
            fPr2 = 0.0f;
        }
        ajVar2.hw += fPr2;
        float f12 = f;
        int i = 0;
        while (i < listYb.size()) {
            List<com.byazt.rk.zo> list = listYb.get(i);
            i++;
            if (i >= hwVar3.fw.size()) {
                int size = (i - hwVar3.fw.size()) + 1;
                int i2 = 0;
                while (i2 < size) {
                    hwVar3.fw.add(new ArrayList());
                    i2++;
                    size = size;
                    f12 = f12;
                }
                f2 = f12;
            } else {
                f2 = f12;
            }
            Iterator<com.byazt.rk.zo> it2 = list.iterator();
            float f13 = 0.0f;
            while (true) {
                fPr = fPr;
                if (it2.hasNext()) {
                    com.byazt.rk.zo next = it2.next();
                    com.byazt.rk.uc ucVarC2 = next.vk().c();
                    String strVe = ucVarC2.ve();
                    it2 = it2;
                    int iL = ucVarC2.l();
                    if (!TextUtils.equals(strVe, "flex") && iL != 1 && iL != 2) {
                        hw.hn hnVarPr2 = this.hw.pr(next);
                        if (hnVarPr2 != null) {
                            f13 += hnVarPr2.pr;
                        }
                    }
                } else {
                    float fMax = Math.max(f9 - f13, 0.0f);
                    Iterator<com.byazt.rk.zo> it3 = list.iterator();
                    float f14 = 0.0f;
                    while (it3.hasNext()) {
                        com.byazt.rk.zo next2 = it3.next();
                        com.byazt.rk.uc ucVarC3 = next2.vk().c();
                        it3 = it3;
                        if (ucVarC3.l() != 1 && ucVarC3.l() != 2) {
                            hw.hn hnVarPr3 = this.hw.pr(next2);
                            if (hnVarPr3 != null) {
                                f14 += hnVarPr3.pr;
                            }
                        }
                    }
                    if (f14 < f9) {
                        if (TextUtils.equals(strQi, "center")) {
                            fPr3 = (f9 - f14) / 2.0f;
                            fPr4 = 0.0f;
                        } else if (TextUtils.equals(strQi, "flex-end")) {
                            fPr3 = f9 - f14;
                            fPr4 = 0.0f;
                        } else if (TextUtils.equals(strQi, str2)) {
                            fPr3 = vk.pr((f9 - f14) / (list.size() + 1));
                            fPr4 = fPr3;
                        } else if (TextUtils.equals(strQi, str) && list.size() > 1) {
                            fPr4 = vk.pr((f9 - f14) / (list.size() - 1.0f));
                            fPr3 = 0.0f;
                        } else {
                            fPr3 = 0.0f;
                            fPr4 = 0.0f;
                        }
                    } else {
                        fPr3 = 0.0f;
                        fPr4 = 0.0f;
                    }
                    ajVar2.pr += fPr3;
                    Iterator<com.byazt.rk.zo> it4 = list.iterator();
                    float fMax2 = 0.0f;
                    while (it4.hasNext()) {
                        com.byazt.rk.zo next3 = it4.next();
                        Iterator<com.byazt.rk.zo> it5 = it4;
                        if (this.hw.pr(next3) == null) {
                            f5 = 0.0f;
                        } else {
                            f5 = this.hw.pr(next3).hw;
                        }
                        com.byazt.rk.uc ucVarC4 = next3.vk().c();
                        String str3 = str;
                        fMax2 = Math.max(fMax2, (ucVarC4.l() == 1 || ucVarC4.l() == 2) ? 0.0f : f5);
                        it4 = it5;
                        str = str3;
                    }
                    String str4 = str;
                    Iterator<com.byazt.rk.zo> it6 = list.iterator();
                    f12 = f2;
                    while (it6.hasNext()) {
                        com.byazt.rk.zo next4 = it6.next();
                        Iterator<com.byazt.rk.zo> it7 = it6;
                        hw.hn hnVarPr4 = this.hw.pr(next4);
                        String str5 = strQi;
                        com.byazt.rk.uc ucVarC5 = next4.vk().c();
                        float f15 = f12;
                        float fI = ucVarC5.i();
                        float f16 = f9;
                        float fNw = ucVarC5.nw();
                        String str6 = str2;
                        float fR = ucVarC5.r();
                        float f17 = fPr4;
                        float fHs = ucVarC5.hs();
                        com.byazt.rk.aj ajVar3 = ajVar2;
                        float f18 = hnVarPr4 == null ? 0.0f : hnVarPr4.pr;
                        float f19 = hnVarPr4 == null ? 0.0f : hnVarPr4.hw;
                        List<com.byazt.rk.zo> list2 = list;
                        com.byazt.rk.zo zoVar2 = zoVar;
                        if (!TextUtils.equals(zoVar.hn(), "root")) {
                            f3 = f15;
                        } else {
                            f3 = i;
                        }
                        int i3 = i;
                        if (ucVarC5.l() == 1) {
                            hwVar2 = hwVar;
                            ajVarPr = pr(hwVar2, ucVarC5, (f18 - fNw) - fHs, (f19 - fI) - fR);
                        } else {
                            hwVar2 = hwVar;
                            ajVarPr = ajVar3;
                        }
                        com.byazt.rk.aj ajVarPr2 = ucVarC5.l() == 2 ? pr(ucVarC5, this.hw.pr(this.hn), new hw.hn((f18 - fNw) - fHs, (f19 - fI) - fR)) : ajVarPr;
                        String strBh = ucVarC.bh();
                        if (fMax2 > f19 && !TextUtils.equals(strBh, "flex-start")) {
                            switch (strBh) {
                                case "center":
                                    f4 = (fMax2 - f19) / 2.0f;
                                    break;
                                case "flex-end":
                                    f4 = fMax2 - f19;
                                    break;
                                default:
                                    break;
                            }
                            com.byazt.rk.hw hwVar4 = new com.byazt.rk.hw();
                            hwVar4.pr = ajVarPr2.pr + fHs;
                            hwVar4.hw = ajVarPr2.hw + fI + f4;
                            hwVar4.hn = (f18 - fNw) - fHs;
                            hwVar4.x = (f19 - fI) - fR;
                            hwVar4.c = hwVar2.c + "." + next4.hn();
                            hwVar4.zo = hwVar2;
                            hwVar4.uc = next4;
                            fMax = fMax;
                            hwVar4.aj = fMax;
                            list = list2;
                            hwVar4.vk = list;
                            hwVar4.uc.hn(hwVar4.pr);
                            hwVar4.uc.x(hwVar4.hw);
                            hwVar4.uc.c(hwVar4.hn);
                            hwVar4.uc.uc(hwVar4.x);
                            float f20 = f3;
                            com.byazt.rk.hw hwVarPr = pr(hwVar4, f20);
                            i = i3;
                            hwVar2.fw.get(i).add(hwVarPr);
                            if (ucVarC5.l() != 1) {
                                ajVar = ajVar3;
                            } else if (ucVarC5.l() != 2) {
                                ajVar = ajVar3;
                            } else {
                                ajVar = ajVar3;
                                ajVar.pr += f18 + f17;
                            }
                            f12 = f20;
                            ajVar2 = ajVar;
                            it6 = it7;
                            strQi = str5;
                            f9 = f16;
                            str2 = str6;
                            fPr4 = f17;
                            zoVar = zoVar2;
                        }
                        f4 = 0.0f;
                        com.byazt.rk.hw hwVar5 = new com.byazt.rk.hw();
                        hwVar5.pr = ajVarPr2.pr + fHs;
                        hwVar5.hw = ajVarPr2.hw + fI + f4;
                        hwVar5.hn = (f18 - fNw) - fHs;
                        hwVar5.x = (f19 - fI) - fR;
                        hwVar5.c = hwVar2.c + "." + next4.hn();
                        hwVar5.zo = hwVar2;
                        hwVar5.uc = next4;
                        fMax = fMax;
                        hwVar5.aj = fMax;
                        list = list2;
                        hwVar5.vk = list;
                        hwVar5.uc.hn(hwVar5.pr);
                        hwVar5.uc.x(hwVar5.hw);
                        hwVar5.uc.c(hwVar5.hn);
                        hwVar5.uc.uc(hwVar5.x);
                        float f21 = f3;
                        com.byazt.rk.hw hwVarPr2 = pr(hwVar5, f21);
                        i = i3;
                        hwVar2.fw.get(i).add(hwVarPr2);
                        if (ucVarC5.l() != 1) {
                            ajVar = ajVar3;
                        } else if (ucVarC5.l() != 2) {
                            ajVar = ajVar3;
                        } else {
                            ajVar = ajVar3;
                            ajVar.pr += f18 + f17;
                        }
                        f12 = f21;
                        ajVar2 = ajVar;
                        it6 = it7;
                        strQi = str5;
                        f9 = f16;
                        str2 = str6;
                        fPr4 = f17;
                        zoVar = zoVar2;
                    }
                    com.byazt.rk.aj ajVar4 = ajVar2;
                    ajVar4.pr = f6;
                    ajVar4.hw += fMax2 + fPr;
                    hwVar3 = hwVar;
                    listYb = listYb;
                    fPr = fPr;
                    str = str4;
                    zoVar = zoVar;
                }
            }
        }
        return hwVar3;
    }

    private com.byazt.rk.aj pr(com.byazt.rk.uc ucVar, hw.hn hnVar, hw.hn hnVar2) {
        float fIy = ucVar.iy();
        float fJ = ucVar.j();
        float fCr = ucVar.cr();
        float fQo = ucVar.qo();
        boolean zOd = ucVar.od();
        boolean zVj = ucVar.vj();
        boolean zMw = ucVar.mw();
        boolean zSv = ucVar.sv();
        if (!zOd) {
            if (!zVj) {
                fIy = 0.0f;
            } else {
                fIy = ((this.x.pr != 0.0f ? Math.min(this.x.pr, hnVar.pr) : hnVar.pr) - fCr) - hnVar2.pr;
            }
        }
        if (!zMw) {
            if (!zSv) {
                fJ = 0.0f;
            } else {
                fJ = ((this.x.hw != 0.0f ? this.x.hw : hnVar.hw) - fQo) - hnVar2.hw;
            }
        }
        return new com.byazt.rk.aj(fIy, fJ);
    }

    private com.byazt.rk.aj pr(com.byazt.rk.hw hwVar, com.byazt.rk.uc ucVar, float f, float f2) {
        float f3 = hwVar.pr;
        float f4 = hwVar.hw;
        float fIy = ucVar.iy();
        float fJ = ucVar.j();
        float fCr = ucVar.cr();
        float fQo = ucVar.qo();
        boolean zOd = ucVar.od();
        boolean zVj = ucVar.vj();
        boolean zMw = ucVar.mw();
        boolean zSv = ucVar.sv();
        String strLv = ucVar.lv();
        float f5 = hwVar.hn;
        float f6 = hwVar.x;
        if (TextUtils.equals(strLv, "0")) {
            if (zOd) {
                f3 = hwVar.pr + fIy;
            } else if (zVj) {
                f3 = ((hwVar.pr + f5) - fCr) - f;
            }
            if (zMw) {
                f4 = hwVar.hw + fJ;
            } else if (zSv) {
                f4 = ((hwVar.hw + f6) - fQo) - f2;
            }
        } else if (TextUtils.equals(strLv, "1")) {
            f3 = hwVar.pr + ((f5 - f) / 2.0f);
            if (zMw) {
                f4 = hwVar.hw + fJ;
            } else if (zSv) {
                f4 = ((hwVar.hw + f6) - fQo) - f2;
            }
        } else if (TextUtils.equals(strLv, "2")) {
            f4 = hwVar.hw + ((f6 - f2) / 2.0f);
            if (zOd) {
                f3 = hwVar.pr + fIy;
            } else if (zVj) {
                f3 = ((hwVar.pr + f5) - fCr) - f;
            }
        } else if (TextUtils.equals(strLv, GlobalSetting.SPLASH_AD)) {
            f3 = hwVar.pr + ((f5 - f) / 2.0f);
            f4 = hwVar.hw + ((f6 - f2) / 2.0f);
        }
        return new com.byazt.rk.aj(f3, f4);
    }
}
