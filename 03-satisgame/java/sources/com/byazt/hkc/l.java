package com.byazt.hkc;

import android.text.TextUtils;
import com.anythink.core.common.d.i;
import com.byazt.udb.oa;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 46, 18})
public class l {
    public com.byazt.lh.qg n;
    public n q;
    public qg qg;
    public com.byazt.lh.fs s;

    @com.byazt.cp.n(n = {0, 1, 46, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    static class n {
        public float n;
        public float qg;
        public float s;
    }

    public l(double d, int i, double d2, String str, oa oaVar) {
        this.qg = new qg(d, i, d2, str, oaVar);
    }

    public void n(n nVar) {
        this.q = nVar;
    }

    public void n() {
        this.qg.n();
    }

    public void n(com.byazt.lh.fs fsVar, float f, float f2) {
        if (fsVar != null) {
            this.s = fsVar;
        }
        com.byazt.lh.fs fsVar2 = this.s;
        float fFs = fsVar2.fs();
        float fRv = fsVar2.rv();
        float f3 = TextUtils.equals(fsVar2.tj().l().t(), "fixed") ? fRv : 65536.0f;
        this.qg.n();
        this.qg.s(fsVar2, fFs, f3);
        qg.s sVarN = this.qg.n(fsVar2);
        com.byazt.lh.qg qgVar = new com.byazt.lh.qg();
        qgVar.n = f;
        qgVar.qg = f2;
        if (sVarN != null) {
            fFs = sVarN.n;
        }
        qgVar.s = fFs;
        if (sVarN != null) {
            fRv = sVarN.qg;
        }
        qgVar.q = fRv;
        qgVar.l = "root";
        qgVar.rv = 1280.0f;
        qgVar.w = fsVar2;
        qgVar.w.s(qgVar.n);
        qgVar.w.q(qgVar.qg);
        qgVar.w.l(qgVar.s);
        qgVar.w.w(qgVar.q);
        com.byazt.lh.qg qgVarN = n(qgVar, 0.0f);
        this.n = qgVarN;
        n(qgVarN);
    }

    public void n(com.byazt.lh.qg qgVar) {
        if (qgVar == null) {
            return;
        }
        qgVar.w.tj().getType();
        List<List<com.byazt.lh.qg>> list = qgVar.x;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (List<com.byazt.lh.qg> list2 : list) {
            if (list2 != null && list2.size() > 0) {
                Iterator<com.byazt.lh.qg> it = list2.iterator();
                while (it.hasNext()) {
                    n(it.next());
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:137:0x031c  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:87:0x01ed  */
    public com.byazt.lh.qg n(com.byazt.lh.qg qgVar, float f) {
        float fN;
        float fN2;
        float f2;
        float fN3;
        float fN4;
        com.byazt.lh.qg qgVar2;
        com.byazt.lh.rv rvVarN;
        float f3;
        com.byazt.lh.rv rvVar;
        qg.s sVarN;
        qg.s sVarN2;
        com.byazt.lh.qg qgVar3 = qgVar;
        com.byazt.lh.fs fsVar = qgVar3.w;
        if (fsVar == null) {
            return qgVar3;
        }
        fsVar.py();
        List<List<com.byazt.lh.fs>> listHd = fsVar.hd();
        if (listHd == null || listHd.size() <= 0) {
            return qgVar3;
        }
        com.byazt.lh.w wVarL = fsVar.tj().l();
        float fHd = wVarL.hd();
        float fCy = wVarL.cy();
        float fSz = wVarL.sz();
        float fK = wVarL.k();
        float fD = wVarL.d();
        String strOj = wVarL.oj();
        String strDg = wVarL.dg();
        float f4 = qgVar3.n + fK;
        float f5 = qgVar3.qg + fHd;
        float f6 = fD * 2.0f;
        float f7 = ((qgVar3.s - fK) - fCy) - f6;
        float f8 = ((qgVar3.q - fHd) - fSz) - f6;
        com.byazt.lh.rv rvVar2 = new com.byazt.lh.rv(f4, f5);
        if (qgVar3.x == null) {
            qgVar3.x = new ArrayList();
        }
        Iterator<List<com.byazt.lh.fs>> it = listHd.iterator();
        float f9 = 0.0f;
        while (it.hasNext()) {
            qg.s sVarN3 = this.qg.n(it.next());
            if (sVarN3 != null) {
                f9 += sVarN3.qg;
            }
        }
        String str = "space-between";
        String str2 = "space-around";
        if (f9 >= f8) {
            fN = 0.0f;
            fN2 = 0.0f;
        } else {
            if (TextUtils.equals(strDg, "center")) {
                fN2 = (f8 - f9) / 2.0f;
            } else if (TextUtils.equals(strDg, "flex-end")) {
                fN2 = f8 - f9;
            } else if (TextUtils.equals(strDg, "space-around")) {
                fN2 = tj.n((f8 - f9) / (listHd.size() + 1));
                fN = fN2;
            } else {
                if (!TextUtils.equals(strDg, "space-between") || listHd.size() <= 1) {
                    fN = 0.0f;
                } else {
                    fN = tj.n((f8 - f9) / (listHd.size() - 1));
                }
                fN2 = 0.0f;
            }
            fN = 0.0f;
        }
        rvVar2.qg += fN2;
        float f10 = f;
        int i = 0;
        while (i < listHd.size()) {
            List<com.byazt.lh.fs> list = listHd.get(i);
            i++;
            if (i >= qgVar3.x.size()) {
                int size = (i - qgVar3.x.size()) + 1;
                int i2 = 0;
                while (i2 < size) {
                    qgVar3.x.add(new ArrayList());
                    i2++;
                    size = size;
                    f10 = f10;
                }
            }
            float f11 = f10;
            Iterator<com.byazt.lh.fs> it2 = list.iterator();
            float f12 = 0.0f;
            while (true) {
                f2 = fN;
                if (!it2.hasNext()) {
                    break;
                }
                com.byazt.lh.fs next = it2.next();
                com.byazt.lh.w wVarL2 = next.tj().l();
                String strUr = wVarL2.ur();
                Iterator<com.byazt.lh.fs> it3 = it2;
                int iE = wVarL2.e();
                if (!TextUtils.equals(strUr, "flex") && iE != 1 && iE != 2 && (sVarN2 = this.qg.n(next)) != null) {
                    f12 += sVarN2.n;
                }
                fN = f2;
                it2 = it3;
            }
            float fMax = Math.max(f7 - f12, 0.0f);
            Iterator<com.byazt.lh.fs> it4 = list.iterator();
            float f13 = 0.0f;
            while (it4.hasNext()) {
                com.byazt.lh.fs next2 = it4.next();
                com.byazt.lh.w wVarL3 = next2.tj().l();
                Iterator<com.byazt.lh.fs> it5 = it4;
                if (wVarL3.e() != 1 && wVarL3.e() != 2 && (sVarN = this.qg.n(next2)) != null) {
                    f13 += sVarN.n;
                }
                it4 = it5;
            }
            if (f13 >= f7) {
                fN3 = 0.0f;
                fN4 = 0.0f;
            } else {
                if (TextUtils.equals(strOj, "center")) {
                    fN3 = (f7 - f13) / 2.0f;
                } else if (TextUtils.equals(strOj, "flex-end")) {
                    fN3 = f7 - f13;
                } else if (TextUtils.equals(strOj, str2)) {
                    fN3 = tj.n((f7 - f13) / (list.size() + 1));
                    fN4 = fN3;
                } else if (!TextUtils.equals(strOj, str) || list.size() <= 1) {
                    fN3 = 0.0f;
                } else {
                    fN4 = tj.n((f7 - f13) / (list.size() - 1.0f));
                    fN3 = 0.0f;
                }
                fN4 = 0.0f;
            }
            rvVar2.n += fN3;
            Iterator<com.byazt.lh.fs> it6 = list.iterator();
            float fMax2 = 0.0f;
            while (it6.hasNext()) {
                com.byazt.lh.fs next3 = it6.next();
                Iterator<com.byazt.lh.fs> it7 = it6;
                float f14 = this.qg.n(next3) != null ? this.qg.n(next3).qg : 0.0f;
                com.byazt.lh.w wVarL4 = next3.tj().l();
                String str3 = str;
                fMax2 = Math.max(fMax2, (wVarL4.e() == 1 || wVarL4.e() == 2) ? 0.0f : f14);
                it6 = it7;
                str = str3;
            }
            String str4 = str;
            Iterator<com.byazt.lh.fs> it8 = list.iterator();
            f10 = f11;
            while (it8.hasNext()) {
                com.byazt.lh.fs next4 = it8.next();
                Iterator<com.byazt.lh.fs> it9 = it8;
                qg.s sVarN4 = this.qg.n(next4);
                String str5 = strOj;
                com.byazt.lh.w wVarL5 = next4.tj().l();
                float f15 = f10;
                float fWo = wVarL5.wo();
                float f16 = f7;
                float fRf = wVarL5.rf();
                String str6 = str2;
                float fSh = wVarL5.sh();
                float f17 = fN4;
                float fY = wVarL5.y();
                com.byazt.lh.rv rvVar3 = rvVar2;
                float f18 = sVarN4 == null ? 0.0f : sVarN4.n;
                float f19 = sVarN4 == null ? 0.0f : sVarN4.qg;
                com.byazt.lh.fs fsVar2 = fsVar;
                float f20 = TextUtils.equals(fsVar.s(), "root") ? i : f15;
                int i3 = i;
                if (wVarL5.e() == 1) {
                    qgVar2 = qgVar;
                    rvVarN = n(qgVar2, wVarL5, (f18 - fRf) - fY, (f19 - fWo) - fSh);
                } else {
                    qgVar2 = qgVar;
                    rvVarN = rvVar3;
                }
                com.byazt.lh.rv rvVarN2 = wVarL5.e() == 2 ? n(wVarL5, this.qg.n(this.s), new qg.s((f18 - fRf) - fY, (f19 - fWo) - fSh)) : rvVarN;
                String strSu = wVarL.su();
                if (fMax2 <= f19 || TextUtils.equals(strSu, "flex-start")) {
                    f3 = 0.0f;
                } else {
                    strSu.hashCode();
                    if (strSu.equals("center")) {
                        f3 = (fMax2 - f19) / 2.0f;
                    } else if (strSu.equals("flex-end")) {
                        f3 = fMax2 - f19;
                    } else {
                        f3 = 0.0f;
                    }
                }
                com.byazt.lh.qg qgVar4 = new com.byazt.lh.qg();
                qgVar4.n = rvVarN2.n + fY;
                qgVar4.qg = rvVarN2.qg + fWo + f3;
                qgVar4.s = (f18 - fRf) - fY;
                qgVar4.q = (f19 - fWo) - fSh;
                qgVar4.l = qgVar2.l + i.E + next4.s();
                qgVar4.fs = qgVar2;
                qgVar4.w = next4;
                fMax = fMax;
                qgVar4.rv = fMax;
                list = list;
                qgVar4.tj = list;
                qgVar4.w.s(qgVar4.n);
                qgVar4.w.q(qgVar4.qg);
                qgVar4.w.l(qgVar4.s);
                qgVar4.w.w(qgVar4.q);
                float f21 = f20;
                com.byazt.lh.qg qgVarN = n(qgVar4, f21);
                i = i3;
                qgVar2.x.get(i).add(qgVarN);
                if (wVarL5.e() == 1) {
                    rvVar = rvVar3;
                } else if (wVarL5.e() != 2) {
                    rvVar = rvVar3;
                    rvVar.n += f18 + f17;
                } else {
                    rvVar = rvVar3;
                }
                f10 = f21;
                rvVar2 = rvVar;
                it8 = it9;
                strOj = str5;
                f7 = f16;
                str2 = str6;
                fN4 = f17;
                fsVar = fsVar2;
            }
            com.byazt.lh.rv rvVar4 = rvVar2;
            rvVar4.n = f4;
            rvVar4.qg += fMax2 + f2;
            qgVar3 = qgVar;
            listHd = listHd;
            fN = f2;
            str = str4;
            fsVar = fsVar;
        }
        return qgVar3;
    }

    private com.byazt.lh.rv n(com.byazt.lh.w wVar, qg.s sVar, qg.s sVar2) {
        float fVb = wVar.vb();
        float fI = wVar.i();
        float fFl = wVar.fl();
        float fDw = wVar.dw();
        boolean zCx = wVar.cx();
        boolean zLq = wVar.lq();
        boolean zIc = wVar.ic();
        boolean zCi = wVar.ci();
        if (!zCx) {
            if (zLq) {
                fVb = ((this.q.n != 0.0f ? Math.min(this.q.n, sVar.n) : sVar.n) - fFl) - sVar2.n;
            } else {
                fVb = 0.0f;
            }
        }
        if (!zIc) {
            if (zCi) {
                fI = ((this.q.qg != 0.0f ? this.q.qg : sVar.qg) - fDw) - sVar2.qg;
            } else {
                fI = 0.0f;
            }
        }
        return new com.byazt.lh.rv(fVb, fI);
    }

    private com.byazt.lh.rv n(com.byazt.lh.qg qgVar, com.byazt.lh.w wVar, float f, float f2) {
        float f3;
        float f4;
        float f5 = qgVar.n;
        float f6 = qgVar.qg;
        float fVb = wVar.vb();
        float fI = wVar.i();
        float fFl = wVar.fl();
        float fDw = wVar.dw();
        boolean zCx = wVar.cx();
        boolean zLq = wVar.lq();
        boolean zIc = wVar.ic();
        boolean zCi = wVar.ci();
        String strYw = wVar.yw();
        float f7 = qgVar.s;
        float f8 = qgVar.q;
        if (TextUtils.equals(strYw, "0")) {
            if (zCx) {
                f5 = qgVar.n + fVb;
            } else if (zLq) {
                f5 = ((qgVar.n + f7) - fFl) - f;
            }
            if (zIc) {
                f4 = qgVar.qg;
                f6 = f4 + fI;
            } else if (zCi) {
                f3 = qgVar.qg;
                f6 = ((f3 + f8) - fDw) - f2;
            }
        } else if (TextUtils.equals(strYw, "1")) {
            f5 = qgVar.n + ((f7 - f) / 2.0f);
            if (zIc) {
                f4 = qgVar.qg;
                f6 = f4 + fI;
            } else if (zCi) {
                f3 = qgVar.qg;
                f6 = ((f3 + f8) - fDw) - f2;
            }
        } else if (TextUtils.equals(strYw, "2")) {
            f6 = qgVar.qg + ((f8 - f2) / 2.0f);
            if (zCx) {
                f5 = qgVar.n + fVb;
            } else if (zLq) {
                f5 = ((qgVar.n + f7) - fFl) - f;
            }
        } else if (TextUtils.equals(strYw, "3")) {
            f5 = qgVar.n + ((f7 - f) / 2.0f);
            f6 = qgVar.qg + ((f8 - f2) / 2.0f);
        }
        return new com.byazt.lh.rv(f5, f6);
    }
}
