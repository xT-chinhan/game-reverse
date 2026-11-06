package com.bytedance.adsdk.ugeno.ah;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class sl {
    private ao ab;
    private com.bytedance.adsdk.ugeno.xr.ah<View> ah;
    private List<String> ao;
    private qv c;
    private hi ch;
    private ny d;
    private ab h;
    private JSONObject hi;
    private ub ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f334ms;
    private String ny;
    private c qv;
    private com.bytedance.adsdk.ugeno.ka.ms.ms u;
    private boolean ub;
    private x x;
    private JSONObject xr;
    private boolean sl = true;
    private boolean zb = false;

    public sl(Context context) {
        this.f334ms = context;
    }

    public void ms(String str, hi hiVar) {
        this.ch = hiVar;
        this.ny = str;
        if (hiVar != null) {
            this.xr = hiVar.ms();
        }
    }

    public com.bytedance.adsdk.ugeno.xr.ah<View> ms(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        this.xr = jSONObject2;
        qv qvVar = this.c;
        if (qvVar != null) {
            qvVar.ms();
        }
        this.x = new x(jSONObject, jSONObject2, jSONObject3);
        this.u = new com.bytedance.adsdk.ugeno.ka.ms.ms();
        ub ubVar = this.ka;
        if (ubVar instanceof com.bytedance.adsdk.ugeno.ah.ms.xr) {
            ((com.bytedance.adsdk.ugeno.ah.ms.xr) ubVar).ms(this.x.xr());
        }
        this.ah = ms(this.x.ms(), (com.bytedance.adsdk.ugeno.xr.ah<View>) null);
        qv qvVar2 = this.c;
        if (qvVar2 != null) {
            qvVar2.xr();
            this.ah.ms(this.c);
        }
        xr(this.ah);
        return this.ah;
    }

    public com.bytedance.adsdk.ugeno.xr.ah<View> ms(x.ms msVar, com.bytedance.adsdk.ugeno.xr.ah<View> ahVar) {
        List<x.ms> listAh;
        com.bytedance.adsdk.ugeno.xr.ms.C0201ms c0201msX = null;
        if (!x.d(msVar)) {
            return null;
        }
        ab abVar = this.h;
        if (abVar != null) {
            abVar.ms(msVar);
        }
        String strAh = msVar.ah();
        xr xrVarMs = d.ms(strAh);
        xr xrVar = xrVarMs;
        if (xrVarMs == null) {
            this.ub = true;
            if (this.ao == null) {
                this.ao = new ArrayList();
            }
            this.ao.add(strAh);
            strAh = "View";
            msVar.ms("View");
            xr xrVarMs2 = d.ms("View");
            xrVar = xrVarMs2;
            if (xrVarMs2 == null) {
                return null;
            }
        }
        com.bytedance.adsdk.ugeno.xr.ah ahVarMs = xrVar.ms(this.f334ms);
        if (ahVarMs == null) {
            return null;
        }
        JSONObject jSONObjectD = msVar.d();
        ahVarMs.ka(com.bytedance.adsdk.ugeno.d.xr.ms(msVar.ms(), this.xr));
        ahVarMs.c(strAh);
        ahVarMs.ah(jSONObjectD);
        ahVarMs.ms(msVar);
        ahVarMs.xr(this.xr);
        x xVar = this.x;
        if (xVar == null) {
            ahVarMs.ah(true);
        } else {
            ahVarMs.ah(xVar.d());
        }
        ahVarMs.ms(this.ch);
        ahVarMs.ms(this.u);
        Iterator<String> itKeys = jSONObjectD.keys();
        if (ahVar instanceof com.bytedance.adsdk.ugeno.xr.ms) {
            com.bytedance.adsdk.ugeno.xr.ms msVar2 = (com.bytedance.adsdk.ugeno.xr.ms) ahVar;
            c0201msX = msVar2.x();
            ahVarMs.ms(msVar2);
        }
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strMs = com.bytedance.adsdk.ugeno.d.xr.ms(jSONObjectD.optString(next), this.xr);
            ahVarMs.ms(next, strMs);
            if (c0201msX != null) {
                c0201msX.ms(this.f334ms, next, strMs);
            }
        }
        if (c0201msX != null) {
            ahVarMs.ms(c0201msX.ms());
        }
        if (ahVarMs instanceof com.bytedance.adsdk.ugeno.xr.ms) {
            List<x.ms> listKa = msVar.ka();
            if (listKa == null || listKa.size() <= 0) {
                if (TextUtils.equals(ahVarMs.p(), "RecyclerLayout") && (listAh = this.x.ah()) != null && listAh.size() > 0) {
                    Iterator<x.ms> it = listAh.iterator();
                    while (it.hasNext()) {
                        com.bytedance.adsdk.ugeno.xr.ah<View> ahVarMs2 = ms(it.next(), (com.bytedance.adsdk.ugeno.xr.ah<View>) ahVarMs);
                        if (ahVarMs2 != null && ahVarMs2.ul()) {
                            ((com.bytedance.adsdk.ugeno.xr.ms) ahVarMs).ms(ahVarMs2);
                        }
                    }
                }
                return ahVarMs;
            }
            if (TextUtils.equals(ahVarMs.p(), "Swiper") && listKa.size() != 1) {
                com.bytedance.sdk.component.utils.sl.d("UGTemplateEngine", "Swiper must be only one widget");
            }
            try {
                Collections.sort(listKa, new Comparator<x.ms>() { // from class: com.bytedance.adsdk.ugeno.ah.sl.1
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
                    public int compare(x.ms msVar3, x.ms msVar4) {
                        return msVar3.d().optInt("order", 0) - msVar4.d().optInt("order", 0);
                    }
                });
            } catch (Throwable unused) {
            }
            Iterator<x.ms> it2 = listKa.iterator();
            while (it2.hasNext()) {
                com.bytedance.adsdk.ugeno.xr.ah<View> ahVarMs3 = ms(it2.next(), (com.bytedance.adsdk.ugeno.xr.ah<View>) ahVarMs);
                if (ahVarMs3 != null && !ahVarMs3.qf()) {
                    ((com.bytedance.adsdk.ugeno.xr.ms) ahVarMs).ms(ahVarMs3, ahVarMs3.yu());
                }
            }
        }
        this.ah = ahVarMs;
        return ahVarMs;
    }

    public com.bytedance.adsdk.ugeno.xr.ah<View> ms(JSONObject jSONObject) {
        qv qvVar = this.c;
        if (qvVar != null) {
            qvVar.ms();
        }
        x xVar = new x(jSONObject, this.xr);
        this.x = xVar;
        ub ubVar = this.ka;
        if (ubVar instanceof com.bytedance.adsdk.ugeno.ah.ms.xr) {
            ((com.bytedance.adsdk.ugeno.ah.ms.xr) ubVar).ms(xVar.xr());
        }
        this.ah = xr(this.x.ms(), null);
        qv qvVar2 = this.c;
        if (qvVar2 != null) {
            qvVar2.xr();
            this.ah.ms(this.c);
        }
        return this.ah;
    }

    public com.bytedance.adsdk.ugeno.xr.ah<View> ms(x.ms msVar) {
        com.bytedance.adsdk.ugeno.xr.ah<View> ahVarXr = xr(msVar, null);
        this.ah = ahVarXr;
        return ahVarXr;
    }

    public com.bytedance.adsdk.ugeno.xr.ah<View> xr(x.ms msVar, com.bytedance.adsdk.ugeno.xr.ah<View> ahVar) {
        List<x.ms> listAh;
        com.bytedance.adsdk.ugeno.xr.ms.C0201ms c0201msX = null;
        if (!x.d(msVar)) {
            return null;
        }
        ab abVar = this.h;
        if (abVar != null) {
            abVar.xr(msVar);
        }
        String strAh = msVar.ah();
        xr xrVarMs = d.ms(strAh);
        if (xrVarMs == null) {
            this.ub = true;
            if (this.ao == null) {
                this.ao = new ArrayList();
            }
            this.ao.add(strAh);
            return null;
        }
        com.bytedance.adsdk.ugeno.xr.ah ahVarMs = xrVarMs.ms(this.f334ms);
        if (ahVarMs == null) {
            return null;
        }
        ahVarMs.ka(com.bytedance.adsdk.ugeno.d.xr.ms(msVar.ms(), this.xr));
        ahVarMs.c(strAh);
        ahVarMs.ah(msVar.d());
        ahVarMs.ms(msVar);
        ahVarMs.ms(this.ch);
        if (ahVar instanceof com.bytedance.adsdk.ugeno.xr.ms) {
            com.bytedance.adsdk.ugeno.xr.ms msVar2 = (com.bytedance.adsdk.ugeno.xr.ms) ahVar;
            ahVarMs.ms(msVar2);
            c0201msX = msVar2.x();
        }
        Iterator<String> itKeys = msVar.d().keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strMs = com.bytedance.adsdk.ugeno.d.xr.ms(msVar.d().optString(next), this.xr);
            ahVarMs.ms(next, strMs);
            if (c0201msX != null) {
                c0201msX.ms(this.f334ms, next, strMs);
            }
        }
        if (ahVarMs instanceof com.bytedance.adsdk.ugeno.xr.ms) {
            List<x.ms> listKa = msVar.ka();
            if (listKa == null || listKa.size() <= 0) {
                if (TextUtils.equals(ahVarMs.p(), "RecyclerLayout") && (listAh = this.x.ah()) != null && listAh.size() > 0) {
                    Iterator<x.ms> it = listAh.iterator();
                    while (it.hasNext()) {
                        com.bytedance.adsdk.ugeno.xr.ah<View> ahVarXr = xr(it.next(), ahVarMs);
                        if (ahVarXr != null && ahVarXr.ul()) {
                            ((com.bytedance.adsdk.ugeno.xr.ms) ahVarMs).ms(ahVarXr);
                        }
                    }
                }
                return ahVarMs;
            }
            if (TextUtils.equals(ahVarMs.p(), "Swiper") && listKa.size() != 1) {
                com.bytedance.sdk.component.utils.sl.d("UGTemplateEngine", "Swiper must be only one widget");
            }
            Iterator<x.ms> it2 = listKa.iterator();
            while (it2.hasNext()) {
                com.bytedance.adsdk.ugeno.xr.ah<View> ahVarXr2 = xr(it2.next(), ahVarMs);
                if (ahVarXr2 != null && ahVarXr2.ul()) {
                    ((com.bytedance.adsdk.ugeno.xr.ms) ahVarMs).ms(ahVarXr2);
                }
            }
        }
        if (c0201msX != null) {
            ahVarMs.ms(c0201msX.ms());
        }
        this.ah = ahVarMs;
        return ahVarMs;
    }

    public void ms(com.bytedance.adsdk.ugeno.xr.ah ahVar) {
        List<com.bytedance.adsdk.ugeno.xr.ah<View>> listAb;
        if (ahVar == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.xr.ms msVarG = ahVar.g();
        if (msVarG != null) {
            com.bytedance.adsdk.ugeno.xr.ms.C0201ms c0201msX = msVarG.x();
            Iterator<String> itKeys = ahVar.re().keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String strMs = com.bytedance.adsdk.ugeno.d.xr.ms(ahVar.re().optString(next), this.xr);
                ahVar.ms(next, strMs);
                c0201msX.ms(this.f334ms, next, strMs);
            }
            ahVar.ms(c0201msX.ms());
        }
        if (!(ahVar instanceof com.bytedance.adsdk.ugeno.xr.ms) || (listAb = ((com.bytedance.adsdk.ugeno.xr.ms) ahVar).ab()) == null || listAb.size() <= 0) {
            return;
        }
        Iterator<com.bytedance.adsdk.ugeno.xr.ah<View>> it = listAb.iterator();
        while (it.hasNext()) {
            ms(it.next());
        }
    }

    public void xr(JSONObject jSONObject) {
        qv qvVar = this.c;
        if (qvVar != null) {
            qvVar.ah();
        }
        this.xr = jSONObject;
        ms(this.ah, jSONObject);
        xr(this.ah);
        if (this.c != null) {
            h hVar = new h();
            hVar.ms(0);
            hVar.ms(this.ah);
            this.c.ms(hVar);
        }
    }

    public void ms(com.bytedance.adsdk.ugeno.xr.ah ahVar, JSONObject jSONObject) {
        if (ahVar == null) {
            return;
        }
        if (ahVar instanceof com.bytedance.adsdk.ugeno.xr.ms) {
            ahVar.ms(jSONObject);
            List<com.bytedance.adsdk.ugeno.xr.ah<View>> listAb = ((com.bytedance.adsdk.ugeno.xr.ms) ahVar).ab();
            if (listAb == null || listAb.size() <= 0) {
                return;
            }
            Iterator<com.bytedance.adsdk.ugeno.xr.ah<View>> it = listAb.iterator();
            while (it.hasNext()) {
                ms(it.next(), jSONObject);
            }
            return;
        }
        ahVar.ms(jSONObject);
    }

    private void xr(com.bytedance.adsdk.ugeno.xr.ah<View> ahVar) {
        List<com.bytedance.adsdk.ugeno.xr.ah<View>> listAb;
        if (ahVar == null) {
            return;
        }
        JSONObject jSONObjectRe = ahVar.re();
        Iterator<String> itKeys = jSONObjectRe.keys();
        com.bytedance.adsdk.ugeno.xr.ms msVarG = ahVar.g();
        com.bytedance.adsdk.ugeno.xr.ms.C0201ms c0201msX = msVarG != null ? msVarG.x() : null;
        ah(ahVar);
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strMs = com.bytedance.adsdk.ugeno.d.xr.ms(jSONObjectRe.optString(next), this.xr);
            ahVar.ms(next, strMs);
            if (c0201msX != null) {
                c0201msX.ms(this.f334ms, next, strMs);
            }
        }
        ahVar.ms(this.d);
        ahVar.ms(this.ka);
        ahVar.ms(this.ab);
        c cVar = this.qv;
        if (cVar != null) {
            ahVar.ms(cVar);
        }
        if ((ahVar instanceof com.bytedance.adsdk.ugeno.xr.ms) && (listAb = ((com.bytedance.adsdk.ugeno.xr.ms) ahVar).ab()) != null && listAb.size() > 0) {
            Iterator<com.bytedance.adsdk.ugeno.xr.ah<View>> it = listAb.iterator();
            while (it.hasNext()) {
                xr(it.next());
            }
        }
        if (c0201msX != null) {
            ahVar.ms(c0201msX.ms());
        }
        ahVar.xr();
    }

    private void ah(com.bytedance.adsdk.ugeno.xr.ah ahVar) {
        try {
            if (!ahVar.cv() || ahVar.le() == null || ahVar.le().c() == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("i18n", ahVar.le().c());
            this.xr.put("xNode", jSONObject);
        } catch (Exception unused) {
        }
    }

    public void ms(ny nyVar) {
        this.d = nyVar;
    }

    public void ms(ub ubVar) {
        com.bytedance.adsdk.ugeno.ah.ms.ms msVarKa = com.bytedance.adsdk.ugeno.d.ms().ka();
        if (msVarKa == null) {
            this.ka = ubVar;
            return;
        }
        com.bytedance.adsdk.ugeno.ah.ms.xr xrVarMs = msVarKa.ms(ubVar);
        if (xrVarMs == null) {
            this.ka = ubVar;
            return;
        }
        xrVarMs.ms(this.hi);
        xrVarMs.ms(this.sl);
        xrVarMs.xr(this.zb);
        x xVar = this.x;
        if (xVar != null) {
            xrVarMs.ms(xVar.xr());
        }
        this.ka = xrVarMs;
    }

    public void ms(ao aoVar) {
        this.ab = aoVar;
    }

    public void ms(com.bytedance.adsdk.ugeno.xr.ah ahVar, String str, Object... objArr) {
        List<com.bytedance.adsdk.ugeno.xr.ah<View>> listAb;
        if (ahVar == null) {
            return;
        }
        ahVar.ms(str, objArr);
        if (!(ahVar instanceof com.bytedance.adsdk.ugeno.xr.ms) || (listAb = ((com.bytedance.adsdk.ugeno.xr.ms) ahVar).ab()) == null || listAb.isEmpty()) {
            return;
        }
        Iterator<com.bytedance.adsdk.ugeno.xr.ah<View>> it = listAb.iterator();
        while (it.hasNext()) {
            ms(it.next(), str, objArr);
        }
    }

    public boolean ms() {
        return this.ub;
    }

    public List<String> xr() {
        return this.ao;
    }

    public void ms(ab abVar) {
        this.h = abVar;
    }
}
