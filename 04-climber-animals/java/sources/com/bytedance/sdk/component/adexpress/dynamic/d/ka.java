package com.bytedance.sdk.component.adexpress.dynamic.d;

import android.text.TextUtils;
import com.anythink.core.common.d.j;
import com.bytedance.sdk.component.adexpress.xr.zb;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ka {
    private com.bytedance.sdk.component.adexpress.dynamic.ah.x ah;
    private ms d;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public com.bytedance.sdk.component.adexpress.dynamic.ah.xr f788ms;
    protected xr xr;

    static class ms {
        float ah;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        float f789ms;
        float xr;

        ms() {
        }
    }

    public ka(double d, int i, double d2, String str, zb zbVar) {
        this.xr = new xr(d, i, d2, str, zbVar);
    }

    public void ms(ms msVar) {
        this.d = msVar;
    }

    public void ms() {
        this.xr.ms();
    }

    public void ms(com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar, float f, float f2) {
        if (xVar != null) {
            this.ah = xVar;
        }
        com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar2 = this.ah;
        float fX = xVar2.x();
        float fNy = xVar2.ny();
        float f3 = TextUtils.equals(xVar2.ch().ka().op(), "fixed") ? fNy : 65536.0f;
        this.xr.ms();
        this.xr.ah(xVar2, fX, f3);
        xr.ah ahVarMs = this.xr.ms(xVar2);
        com.bytedance.sdk.component.adexpress.dynamic.ah.xr xrVar = new com.bytedance.sdk.component.adexpress.dynamic.ah.xr();
        xrVar.f768ms = f;
        xrVar.xr = f2;
        if (ahVarMs != null) {
            fX = ahVarMs.f791ms;
        }
        xrVar.ah = fX;
        if (ahVarMs != null) {
            fNy = ahVarMs.xr;
        }
        xrVar.d = fNy;
        xrVar.ka = "root";
        xrVar.ny = 1280.0f;
        xrVar.c = xVar2;
        xrVar.c.ah(xrVar.f768ms);
        xrVar.c.d(xrVar.xr);
        xrVar.c.ka(xrVar.ah);
        xrVar.c.c(xrVar.d);
        com.bytedance.sdk.component.adexpress.dynamic.ah.xr xrVarMs = ms(xrVar, 0.0f);
        this.f788ms = xrVarMs;
        ms(xrVarMs);
    }

    public void ms(com.bytedance.sdk.component.adexpress.dynamic.ah.xr xrVar) {
        if (xrVar == null) {
            return;
        }
        xrVar.c.ch().getType();
        List<List<com.bytedance.sdk.component.adexpress.dynamic.ah.xr>> list = xrVar.ab;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (List<com.bytedance.sdk.component.adexpress.dynamic.ah.xr> list2 : list) {
            if (list2 != null && list2.size() > 0) {
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.ah.xr> it = list2.iterator();
                while (it.hasNext()) {
                    ms(it.next());
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:137:0x031c  */
    /* JADX WARN: Code duplicated, block: B:36:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:87:0x01ed  */
    public com.bytedance.sdk.component.adexpress.dynamic.ah.xr ms(com.bytedance.sdk.component.adexpress.dynamic.ah.xr xrVar, float f) {
        float fMs;
        float fMs2;
        float f2;
        float fMs3;
        float fMs4;
        com.bytedance.sdk.component.adexpress.dynamic.ah.xr xrVar2;
        com.bytedance.sdk.component.adexpress.dynamic.ah.ny nyVarMs;
        float f3;
        com.bytedance.sdk.component.adexpress.dynamic.ah.ny nyVar;
        xr.ah ahVarMs;
        xr.ah ahVarMs2;
        com.bytedance.sdk.component.adexpress.dynamic.ah.xr xrVar3 = xrVar;
        com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar = xrVar3.c;
        if (xVar == null) {
            return xrVar3;
        }
        xVar.nw();
        List<List<com.bytedance.sdk.component.adexpress.dynamic.ah.x>> listH = xVar.h();
        if (listH == null || listH.size() <= 0) {
            return xrVar3;
        }
        com.bytedance.sdk.component.adexpress.dynamic.ah.c cVarKa = xVar.ch().ka();
        float fH = cVarKa.h();
        float fAo = cVarKa.ao();
        float fU = cVarKa.u();
        float fUb = cVarKa.ub();
        float fSl = cVarKa.sl();
        String strLm = cVarKa.lm();
        String strE = cVarKa.e();
        float f4 = xrVar3.f768ms + fUb;
        float f5 = xrVar3.xr + fH;
        float f6 = fSl * 2.0f;
        float f7 = ((xrVar3.ah - fUb) - fAo) - f6;
        float f8 = ((xrVar3.d - fH) - fU) - f6;
        com.bytedance.sdk.component.adexpress.dynamic.ah.ny nyVar2 = new com.bytedance.sdk.component.adexpress.dynamic.ah.ny(f4, f5);
        if (xrVar3.ab == null) {
            xrVar3.ab = new ArrayList();
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.ah.x>> it = listH.iterator();
        float f9 = 0.0f;
        while (it.hasNext()) {
            xr.ah ahVarMs3 = this.xr.ms(it.next());
            if (ahVarMs3 != null) {
                f9 += ahVarMs3.xr;
            }
        }
        String str = "space-between";
        String str2 = "space-around";
        if (f9 >= f8) {
            fMs = 0.0f;
            fMs2 = 0.0f;
        } else {
            if (TextUtils.equals(strE, "center")) {
                fMs2 = (f8 - f9) / 2.0f;
            } else if (TextUtils.equals(strE, "flex-end")) {
                fMs2 = f8 - f9;
            } else if (TextUtils.equals(strE, "space-around")) {
                fMs2 = ch.ms((f8 - f9) / (listH.size() + 1));
                fMs = fMs2;
            } else {
                if (!TextUtils.equals(strE, "space-between") || listH.size() <= 1) {
                    fMs = 0.0f;
                } else {
                    fMs = ch.ms((f8 - f9) / (listH.size() - 1));
                }
                fMs2 = 0.0f;
            }
            fMs = 0.0f;
        }
        nyVar2.xr += fMs2;
        float f10 = f;
        int i = 0;
        while (i < listH.size()) {
            List<com.bytedance.sdk.component.adexpress.dynamic.ah.x> list = listH.get(i);
            i++;
            if (i >= xrVar3.ab.size()) {
                int size = (i - xrVar3.ab.size()) + 1;
                int i2 = 0;
                while (i2 < size) {
                    xrVar3.ab.add(new ArrayList());
                    i2++;
                    size = size;
                    f10 = f10;
                }
            }
            float f11 = f10;
            Iterator<com.bytedance.sdk.component.adexpress.dynamic.ah.x> it2 = list.iterator();
            float f12 = 0.0f;
            while (true) {
                f2 = fMs;
                if (!it2.hasNext()) {
                    break;
                }
                com.bytedance.sdk.component.adexpress.dynamic.ah.x next = it2.next();
                com.bytedance.sdk.component.adexpress.dynamic.ah.c cVarKa2 = next.ch().ka();
                String strLe = cVarKa2.le();
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.ah.x> it3 = it2;
                int iS = cVarKa2.s();
                if (!TextUtils.equals(strLe, "flex") && iS != 1 && iS != 2 && (ahVarMs2 = this.xr.ms(next)) != null) {
                    f12 += ahVarMs2.f791ms;
                }
                fMs = f2;
                it2 = it3;
            }
            float fMax = Math.max(f7 - f12, 0.0f);
            Iterator<com.bytedance.sdk.component.adexpress.dynamic.ah.x> it4 = list.iterator();
            float f13 = 0.0f;
            while (it4.hasNext()) {
                com.bytedance.sdk.component.adexpress.dynamic.ah.x next2 = it4.next();
                com.bytedance.sdk.component.adexpress.dynamic.ah.c cVarKa3 = next2.ch().ka();
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.ah.x> it5 = it4;
                if (cVarKa3.s() != 1 && cVarKa3.s() != 2 && (ahVarMs = this.xr.ms(next2)) != null) {
                    f13 += ahVarMs.f791ms;
                }
                it4 = it5;
            }
            if (f13 >= f7) {
                fMs3 = 0.0f;
                fMs4 = 0.0f;
            } else {
                if (TextUtils.equals(strLm, "center")) {
                    fMs3 = (f7 - f13) / 2.0f;
                } else if (TextUtils.equals(strLm, "flex-end")) {
                    fMs3 = f7 - f13;
                } else if (TextUtils.equals(strLm, str2)) {
                    fMs3 = ch.ms((f7 - f13) / (list.size() + 1));
                    fMs4 = fMs3;
                } else if (!TextUtils.equals(strLm, str) || list.size() <= 1) {
                    fMs3 = 0.0f;
                } else {
                    fMs4 = ch.ms((f7 - f13) / (list.size() - 1.0f));
                    fMs3 = 0.0f;
                }
                fMs4 = 0.0f;
            }
            nyVar2.f766ms += fMs3;
            Iterator<com.bytedance.sdk.component.adexpress.dynamic.ah.x> it6 = list.iterator();
            float fMax2 = 0.0f;
            while (it6.hasNext()) {
                com.bytedance.sdk.component.adexpress.dynamic.ah.x next3 = it6.next();
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.ah.x> it7 = it6;
                float f14 = this.xr.ms(next3) != null ? this.xr.ms(next3).xr : 0.0f;
                com.bytedance.sdk.component.adexpress.dynamic.ah.c cVarKa4 = next3.ch().ka();
                String str3 = str;
                fMax2 = Math.max(fMax2, (cVarKa4.s() == 1 || cVarKa4.s() == 2) ? 0.0f : f14);
                it6 = it7;
                str = str3;
            }
            String str4 = str;
            Iterator<com.bytedance.sdk.component.adexpress.dynamic.ah.x> it8 = list.iterator();
            f10 = f11;
            while (it8.hasNext()) {
                com.bytedance.sdk.component.adexpress.dynamic.ah.x next4 = it8.next();
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.ah.x> it9 = it8;
                xr.ah ahVarMs4 = this.xr.ms(next4);
                String str5 = strLm;
                com.bytedance.sdk.component.adexpress.dynamic.ah.c cVarKa5 = next4.ch().ka();
                float f15 = f10;
                float fFm = cVarKa5.fm();
                float f16 = f7;
                float fQf = cVarKa5.qf();
                String str6 = str2;
                float fXn = cVarKa5.xn();
                float f17 = fMs4;
                float fIl = cVarKa5.il();
                com.bytedance.sdk.component.adexpress.dynamic.ah.ny nyVar3 = nyVar2;
                float f18 = ahVarMs4 == null ? 0.0f : ahVarMs4.f791ms;
                float f19 = ahVarMs4 == null ? 0.0f : ahVarMs4.xr;
                com.bytedance.sdk.component.adexpress.dynamic.ah.x xVar2 = xVar;
                float f20 = TextUtils.equals(xVar.ah(), "root") ? i : f15;
                int i3 = i;
                if (cVarKa5.s() == 1) {
                    xrVar2 = xrVar;
                    nyVarMs = ms(xrVar2, cVarKa5, (f18 - fQf) - fIl, (f19 - fFm) - fXn);
                } else {
                    xrVar2 = xrVar;
                    nyVarMs = nyVar3;
                }
                com.bytedance.sdk.component.adexpress.dynamic.ah.ny nyVarMs2 = cVarKa5.s() == 2 ? ms(cVarKa5, this.xr.ms(this.ah), new xr.ah((f18 - fQf) - fIl, (f19 - fFm) - fXn)) : nyVarMs;
                String strIh = cVarKa.ih();
                if (fMax2 <= f19 || TextUtils.equals(strIh, "flex-start")) {
                    f3 = 0.0f;
                } else {
                    strIh.hashCode();
                    if (strIh.equals("center")) {
                        f3 = (fMax2 - f19) / 2.0f;
                    } else if (strIh.equals("flex-end")) {
                        f3 = fMax2 - f19;
                    } else {
                        f3 = 0.0f;
                    }
                }
                com.bytedance.sdk.component.adexpress.dynamic.ah.xr xrVar4 = new com.bytedance.sdk.component.adexpress.dynamic.ah.xr();
                xrVar4.f768ms = nyVarMs2.f766ms + fIl;
                xrVar4.xr = nyVarMs2.xr + fFm + f3;
                xrVar4.ah = (f18 - fQf) - fIl;
                xrVar4.d = (f19 - fFm) - fXn;
                xrVar4.ka = xrVar2.ka + j.z + next4.ah();
                xrVar4.x = xrVar2;
                xrVar4.c = next4;
                fMax = fMax;
                xrVar4.ny = fMax;
                list = list;
                xrVar4.ch = list;
                xrVar4.c.ah(xrVar4.f768ms);
                xrVar4.c.d(xrVar4.xr);
                xrVar4.c.ka(xrVar4.ah);
                xrVar4.c.c(xrVar4.d);
                float f21 = f20;
                com.bytedance.sdk.component.adexpress.dynamic.ah.xr xrVarMs = ms(xrVar4, f21);
                i = i3;
                xrVar2.ab.get(i).add(xrVarMs);
                if (cVarKa5.s() == 1) {
                    nyVar = nyVar3;
                } else if (cVarKa5.s() != 2) {
                    nyVar = nyVar3;
                    nyVar.f766ms += f18 + f17;
                } else {
                    nyVar = nyVar3;
                }
                f10 = f21;
                nyVar2 = nyVar;
                it8 = it9;
                strLm = str5;
                f7 = f16;
                str2 = str6;
                fMs4 = f17;
                xVar = xVar2;
            }
            com.bytedance.sdk.component.adexpress.dynamic.ah.ny nyVar4 = nyVar2;
            nyVar4.f766ms = f4;
            nyVar4.xr += fMax2 + f2;
            xrVar3 = xrVar;
            listH = listH;
            fMs = f2;
            str = str4;
            xVar = xVar;
        }
        return xrVar3;
    }

    private com.bytedance.sdk.component.adexpress.dynamic.ah.ny ms(com.bytedance.sdk.component.adexpress.dynamic.ah.c cVar, xr.ah ahVar, xr.ah ahVar2) {
        float fJm = cVar.jm();
        float fJy = cVar.jy();
        float fBz = cVar.bz();
        float fJ = cVar.j();
        boolean zQk = cVar.qk();
        boolean zVm = cVar.vm();
        boolean zZf = cVar.zf();
        boolean zRt = cVar.rt();
        if (!zQk) {
            if (zVm) {
                fJm = ((this.d.f789ms != 0.0f ? Math.min(this.d.f789ms, ahVar.f791ms) : ahVar.f791ms) - fBz) - ahVar2.f791ms;
            } else {
                fJm = 0.0f;
            }
        }
        if (!zZf) {
            if (zRt) {
                fJy = ((this.d.xr != 0.0f ? this.d.xr : ahVar.xr) - fJ) - ahVar2.xr;
            } else {
                fJy = 0.0f;
            }
        }
        return new com.bytedance.sdk.component.adexpress.dynamic.ah.ny(fJm, fJy);
    }

    private com.bytedance.sdk.component.adexpress.dynamic.ah.ny ms(com.bytedance.sdk.component.adexpress.dynamic.ah.xr xrVar, com.bytedance.sdk.component.adexpress.dynamic.ah.c cVar, float f, float f2) {
        float f3;
        float f4;
        float f5 = xrVar.f768ms;
        float f6 = xrVar.xr;
        float fJm = cVar.jm();
        float fJy = cVar.jy();
        float fBz = cVar.bz();
        float fJ = cVar.j();
        boolean zQk = cVar.qk();
        boolean zVm = cVar.vm();
        boolean zZf = cVar.zf();
        boolean zRt = cVar.rt();
        String strV = cVar.v();
        float f7 = xrVar.ah;
        float f8 = xrVar.d;
        if (TextUtils.equals(strV, "0")) {
            if (zQk) {
                f5 = xrVar.f768ms + fJm;
            } else if (zVm) {
                f5 = ((xrVar.f768ms + f7) - fBz) - f;
            }
            if (zZf) {
                f4 = xrVar.xr;
                f6 = f4 + fJy;
            } else if (zRt) {
                f3 = xrVar.xr;
                f6 = ((f3 + f8) - fJ) - f2;
            }
        } else if (TextUtils.equals(strV, "1")) {
            f5 = xrVar.f768ms + ((f7 - f) / 2.0f);
            if (zZf) {
                f4 = xrVar.xr;
                f6 = f4 + fJy;
            } else if (zRt) {
                f3 = xrVar.xr;
                f6 = ((f3 + f8) - fJ) - f2;
            }
        } else if (TextUtils.equals(strV, "2")) {
            f6 = xrVar.xr + ((f8 - f2) / 2.0f);
            if (zQk) {
                f5 = xrVar.f768ms + fJm;
            } else if (zVm) {
                f5 = ((xrVar.f768ms + f7) - fBz) - f;
            }
        } else if (TextUtils.equals(strV, "3")) {
            f5 = xrVar.f768ms + ((f7 - f) / 2.0f);
            f6 = xrVar.xr + ((f8 - f2) / 2.0f);
        }
        return new com.bytedance.sdk.component.adexpress.dynamic.ah.ny(f5, f6);
    }
}
