package com.byazt.ch;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OUTLET_CREATE_TIME, 19})
public class ho {
    public List<String> a;
    public com.byazt.dd.ho aj;
    public lb c;
    public zo cz;
    public float fo;
    public a fw;
    public JSONObject g;
    public com.byazt.ik.hn<View> hn;
    public JSONObject hw;
    public String k;
    public boolean lb;
    public g m;
    public uc ny;
    public Context pr;
    public boolean qa;
    public float rc;
    public ny uc;
    public com.byazt.dd.g vk;
    public aj w;
    public vk x;
    public com.byazt.mj.pr yb;
    public w z;
    public qa zo;
    public boolean ho = true;
    public boolean nt = false;

    public ho(Context context) {
        this.pr = context;
    }

    public void pr(String str, g gVar) {
        this.m = gVar;
        this.k = str;
        if (gVar != null) {
            this.hw = gVar.pr();
        }
    }

    public com.byazt.ik.hn<View> pr(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        this.hw = jSONObject2;
        ny nyVar = this.uc;
        if (nyVar != null) {
            nyVar.pr();
        }
        aj ajVar = new aj(jSONObject, jSONObject2, jSONObject3);
        this.w = ajVar;
        ajVar.pr(this.fo, this.rc);
        this.yb = new com.byazt.mj.pr();
        lb lbVar = this.c;
        if (lbVar instanceof com.byazt.ef.hw) {
            ((com.byazt.ef.hw) lbVar).pr(this.w.hw());
        }
        this.hn = pr(this.w.pr(), (com.byazt.ik.hn<View>) null);
        w wVar = this.z;
        if (wVar != null) {
            wVar.hw();
            if (this.z.hn()) {
                this.z.pr(this.zo);
            }
            this.z.pr(this.uc);
        }
        ny nyVar2 = this.uc;
        if (nyVar2 != null) {
            nyVar2.hw();
            this.hn.pr(this.uc);
            this.uc.hn();
        }
        hw(this.hn);
        if (this.uc != null) {
            cz czVar = new cz();
            czVar.pr(0);
            czVar.pr(this.hn);
            this.uc.pr(czVar);
        }
        return this.hn;
    }

    public com.byazt.ik.hn<View> pr(aj.pr prVar, JSONObject jSONObject, JSONObject jSONObject2) {
        this.hw = jSONObject;
        ny nyVar = this.uc;
        if (nyVar != null) {
            nyVar.pr();
        }
        this.yb = new com.byazt.mj.pr();
        lb lbVar = this.c;
        if (lbVar instanceof com.byazt.ef.hw) {
            ((com.byazt.ef.hw) lbVar).pr("3.0");
        }
        this.hn = pr(prVar, (com.byazt.ik.hn<View>) null);
        ny nyVar2 = this.uc;
        if (nyVar2 != null) {
            nyVar2.hw();
            this.hn.pr(this.uc);
        }
        hw(this.hn);
        return this.hn;
    }

    public com.byazt.ik.hn<View> pr(aj.pr prVar, com.byazt.ik.hn<View> hnVar) {
        List<aj.pr> listHn;
        com.byazt.ik.pr.C0097pr c0097pr = null;
        if (!aj.x(prVar)) {
            return null;
        }
        zo zoVar = this.cz;
        if (zoVar != null) {
            zoVar.pr(prVar);
        }
        String strX = prVar.x();
        hw hwVarPr = x.pr(strX);
        hw hwVar = hwVarPr;
        if (hwVarPr == null) {
            this.lb = true;
            if (this.a == null) {
                this.a = new ArrayList();
            }
            this.a.add(strX);
            prVar.pr("View");
            hw hwVarPr2 = x.pr("View");
            if (hwVarPr2 == null) {
                return null;
            }
            strX = "View";
            hwVar = hwVarPr2;
        }
        com.byazt.ik.hn hnVarPr = hwVar.pr(this.pr);
        if (hnVarPr == null) {
            return null;
        }
        JSONObject jSONObjectC = prVar.c();
        hnVarPr.fw(com.byazt.tn.hw.pr(prVar.pr(), this.hw));
        hnVarPr.zo(strX);
        hnVarPr.hn(jSONObjectC);
        hnVarPr.pr(prVar);
        hnVarPr.hw(this.hw);
        aj ajVar = this.w;
        if (ajVar == null) {
            hnVarPr.hn(true);
        } else {
            hnVarPr.hn(ajVar.x());
        }
        hnVarPr.pr(this.m);
        hnVarPr.pr(this.yb);
        Iterator<String> itKeys = jSONObjectC.keys();
        if (hnVar instanceof com.byazt.ik.pr) {
            com.byazt.ik.pr prVar2 = (com.byazt.ik.pr) hnVar;
            com.byazt.ik.pr.C0097pr c0097prZo = prVar2.zo();
            hnVarPr.pr(prVar2);
            c0097pr = c0097prZo;
        }
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strPr = com.byazt.tn.hw.pr(jSONObjectC.optString(next), this.hw);
            hnVarPr.pr(next, strPr);
            w wVar = this.z;
            if (wVar != null) {
                wVar.pr(next, strPr);
            }
            if (c0097pr != null) {
                c0097pr.pr(this.pr, next, strPr);
            }
        }
        if (c0097pr != null) {
            hnVarPr.pr(c0097pr.pr());
        }
        if (hnVar != null && TextUtils.equals("virtualNode", hnVar.ww()) && hnVarPr.o()) {
            this.qa = true;
        }
        if (hnVarPr instanceof com.byazt.ik.pr) {
            List<aj.pr> listUc = prVar.uc();
            if (listUc == null || listUc.size() <= 0) {
                if (TextUtils.equals(hnVarPr.n(), "RecyclerLayout") && (listHn = this.w.hn()) != null && listHn.size() > 0) {
                    Iterator<aj.pr> it = listHn.iterator();
                    while (it.hasNext()) {
                        com.byazt.ik.hn<View> hnVarPr2 = pr(it.next(), (com.byazt.ik.hn<View>) hnVarPr);
                        if (hnVarPr2 != null && hnVarPr2.er()) {
                            ((com.byazt.ik.pr) hnVarPr).pr(hnVarPr2);
                        }
                    }
                }
                return hnVarPr;
            }
            if (TextUtils.equals(hnVarPr.n(), "Swiper") && listUc.size() != 1) {
                com.byazt.ca.ho.hw("UGTemplateEngine", "Swiper must be only one widget");
            }
            try {
                Collections.sort(listUc, new Comparator<aj.pr>() { // from class: com.byazt.ch.ho.1
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
                    public int compare(aj.pr prVar3, aj.pr prVar4) {
                        return prVar3.c().optInt("order", 0) - prVar4.c().optInt("order", 0);
                    }
                });
            } catch (Throwable th) {
            }
            Iterator<aj.pr> it2 = listUc.iterator();
            while (it2.hasNext()) {
                com.byazt.ik.hn<View> hnVarPr3 = pr(it2.next(), (com.byazt.ik.hn<View>) hnVarPr);
                if (hnVarPr3 != null && !hnVarPr3.o()) {
                    ((com.byazt.ik.pr) hnVarPr).pr(hnVarPr3, hnVarPr3.iu());
                }
            }
        }
        this.hn = hnVarPr;
        return hnVarPr;
    }

    public com.byazt.ik.hn<View> pr(JSONObject jSONObject) {
        ny nyVar = this.uc;
        if (nyVar != null) {
            nyVar.pr();
        }
        if (this.m == null) {
            this.m = new g();
        }
        aj ajVar = new aj(jSONObject, this.hw);
        this.w = ajVar;
        lb lbVar = this.c;
        if (lbVar instanceof com.byazt.ef.hw) {
            ((com.byazt.ef.hw) lbVar).pr(ajVar.hw());
        }
        this.hn = hw(this.w.pr(), null);
        ny nyVar2 = this.uc;
        if (nyVar2 != null) {
            nyVar2.hw();
            this.hn.pr(this.uc);
        }
        return this.hn;
    }

    public com.byazt.ik.hn<View> pr(aj.pr prVar) {
        com.byazt.ik.hn<View> hnVarHw = hw(prVar, null);
        this.hn = hnVarHw;
        return hnVarHw;
    }

    public com.byazt.ik.hn<View> hw(aj.pr prVar, com.byazt.ik.hn<View> hnVar) {
        List<aj.pr> listHn;
        com.byazt.ik.pr.C0097pr c0097prZo = null;
        if (!aj.x(prVar)) {
            return null;
        }
        zo zoVar = this.cz;
        if (zoVar != null) {
            zoVar.hw(prVar);
        }
        String strX = prVar.x();
        hw hwVarPr = x.pr(strX);
        if (hwVarPr == null) {
            this.lb = true;
            if (this.a == null) {
                this.a = new ArrayList();
            }
            this.a.add(strX);
            return null;
        }
        com.byazt.ik.hn hnVarPr = hwVarPr.pr(this.pr);
        if (hnVarPr == null) {
            return null;
        }
        hnVarPr.fw(com.byazt.tn.hw.pr(prVar.pr(), this.hw));
        hnVarPr.zo(strX);
        hnVarPr.hn(prVar.c());
        hnVarPr.pr(prVar);
        hnVarPr.pr(this.m);
        if (hnVar instanceof com.byazt.ik.pr) {
            com.byazt.ik.pr prVar2 = (com.byazt.ik.pr) hnVar;
            hnVarPr.pr(prVar2);
            c0097prZo = prVar2.zo();
        }
        Iterator<String> itKeys = prVar.c().keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strPr = com.byazt.tn.hw.pr(prVar.c().optString(next), this.hw);
            hnVarPr.pr(next, strPr);
            if (c0097prZo != null) {
                c0097prZo.pr(this.pr, next, strPr);
            }
        }
        if (hnVarPr instanceof com.byazt.ik.pr) {
            List<aj.pr> listUc = prVar.uc();
            if (listUc == null || listUc.size() <= 0) {
                if (TextUtils.equals(hnVarPr.n(), "RecyclerLayout") && (listHn = this.w.hn()) != null && listHn.size() > 0) {
                    Iterator<aj.pr> it = listHn.iterator();
                    while (it.hasNext()) {
                        com.byazt.ik.hn<View> hnVarHw = hw(it.next(), hnVarPr);
                        if (hnVarHw != null && hnVarHw.er()) {
                            ((com.byazt.ik.pr) hnVarPr).pr(hnVarHw);
                        }
                    }
                }
                return hnVarPr;
            }
            if (TextUtils.equals(hnVarPr.n(), "Swiper") && listUc.size() != 1) {
                com.byazt.ca.ho.hw("UGTemplateEngine", "Swiper must be only one widget");
            }
            Iterator<aj.pr> it2 = listUc.iterator();
            while (it2.hasNext()) {
                com.byazt.ik.hn<View> hnVarHw2 = hw(it2.next(), hnVarPr);
                if (hnVarHw2 != null && hnVarHw2.er()) {
                    ((com.byazt.ik.pr) hnVarPr).pr(hnVarHw2);
                }
            }
        }
        if (c0097prZo != null) {
            hnVarPr.pr(c0097prZo.pr());
        }
        this.hn = hnVarPr;
        return hnVarPr;
    }

    public void pr(com.byazt.ik.hn hnVar) {
        List<com.byazt.ik.hn<View>> listFw;
        if (hnVar == null) {
            return;
        }
        com.byazt.ik.pr prVarY = hnVar.y();
        if (prVarY != null) {
            com.byazt.ik.pr.C0097pr c0097prZo = prVarY.zo();
            Iterator<String> itKeys = hnVar.rc().keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String strPr = com.byazt.tn.hw.pr(hnVar.rc().optString(next), this.hw);
                hnVar.pr(next, strPr);
                c0097prZo.pr(this.pr, next, strPr);
            }
            hnVar.pr(c0097prZo.pr());
        }
        if (!(hnVar instanceof com.byazt.ik.pr) || (listFw = ((com.byazt.ik.pr) hnVar).fw()) == null || listFw.size() <= 0) {
            return;
        }
        Iterator<com.byazt.ik.hn<View>> it = listFw.iterator();
        while (it.hasNext()) {
            pr(it.next());
        }
    }

    public void hw(JSONObject jSONObject) {
        ny nyVar = this.uc;
        if (nyVar != null) {
            nyVar.hn();
        }
        this.hw = jSONObject;
        pr(this.hn, jSONObject);
        hw(this.hn);
        if (this.uc != null) {
            cz czVar = new cz();
            czVar.pr(0);
            czVar.pr(this.hn);
            this.uc.pr(czVar);
        }
    }

    public void pr(com.byazt.ik.hn hnVar, JSONObject jSONObject) {
        if (hnVar == null) {
            return;
        }
        if (hnVar instanceof com.byazt.ik.pr) {
            hnVar.pr(jSONObject);
            List<com.byazt.ik.hn<View>> listFw = ((com.byazt.ik.pr) hnVar).fw();
            if (listFw == null || listFw.size() <= 0) {
                return;
            }
            Iterator<com.byazt.ik.hn<View>> it = listFw.iterator();
            while (it.hasNext()) {
                pr(it.next(), jSONObject);
            }
            return;
        }
        hnVar.pr(jSONObject);
    }

    private void hw(com.byazt.ik.hn<View> hnVar) {
        List<com.byazt.ik.hn<View>> listFw;
        if (hnVar == null) {
            return;
        }
        JSONObject jSONObjectRc = hnVar.rc();
        Iterator<String> itKeys = jSONObjectRc.keys();
        com.byazt.ik.pr prVarY = hnVar.y();
        com.byazt.ik.pr.C0097pr c0097prZo = null;
        if (prVarY != null) {
            c0097prZo = prVarY.zo();
        }
        hn(hnVar);
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strPr = com.byazt.tn.hw.pr(jSONObjectRc.optString(next), this.hw);
            hnVar.pr(next, strPr);
            if (c0097prZo != null) {
                c0097prZo.pr(this.pr, next, strPr);
            }
        }
        hnVar.pr(this.x);
        hnVar.pr(this.c);
        hnVar.pr(this.fw);
        w wVar = this.z;
        if (wVar != null) {
            hnVar.pr(wVar);
        }
        uc ucVar = this.ny;
        if (ucVar != null) {
            hnVar.pr(ucVar);
        }
        com.byazt.dd.ho hoVar = this.aj;
        if (hoVar != null) {
            hnVar.pr(hoVar);
        }
        com.byazt.dd.g gVar = this.vk;
        if (gVar != null) {
            hnVar.pr(gVar);
        }
        if ((hnVar instanceof com.byazt.ik.pr) && (listFw = ((com.byazt.ik.pr) hnVar).fw()) != null && listFw.size() > 0) {
            Iterator<com.byazt.ik.hn<View>> it = listFw.iterator();
            while (it.hasNext()) {
                hw(it.next());
            }
        }
        if (c0097prZo != null) {
            hnVar.pr(c0097prZo.pr());
        }
        hnVar.hw();
    }

    private void hn(com.byazt.ik.hn hnVar) {
        try {
            if (hnVar.nl() && hnVar.ve() != null && hnVar.ve().fw() != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("i18n", hnVar.ve().fw());
                this.hw.put("xNode", jSONObject);
            }
        } catch (Exception e) {
        }
    }

    public void pr(vk vkVar) {
        this.x = vkVar;
    }

    public void pr(lb lbVar) {
        com.byazt.ef.pr prVarUc = com.byazt.llk.uc.pr().uc();
        if (prVarUc == null) {
            this.c = lbVar;
            return;
        }
        com.byazt.ef.hw hwVarPr = prVarUc.pr(lbVar);
        if (hwVarPr == null) {
            this.c = lbVar;
            return;
        }
        hwVarPr.pr(this.g);
        hwVarPr.pr(this.ho);
        hwVarPr.hw(this.nt);
        aj ajVar = this.w;
        if (ajVar != null) {
            hwVarPr.pr(ajVar.hw());
        }
        this.c = hwVarPr;
    }

    public void pr(a aVar) {
        this.fw = aVar;
    }

    public void pr(com.byazt.ik.hn hnVar, String str, Object... objArr) {
        List<com.byazt.ik.hn<View>> listFw;
        if (hnVar == null) {
            return;
        }
        hnVar.pr(str, objArr);
        if (!(hnVar instanceof com.byazt.ik.pr) || (listFw = ((com.byazt.ik.pr) hnVar).fw()) == null || listFw.isEmpty()) {
            return;
        }
        Iterator<com.byazt.ik.hn<View>> it = listFw.iterator();
        while (it.hasNext()) {
            pr(it.next(), str, objArr);
        }
    }

    public boolean pr() {
        return this.lb;
    }

    public List<String> hw() {
        return this.a;
    }

    public boolean hn() {
        return this.qa;
    }

    public void pr(zo zoVar) {
        this.cz = zoVar;
    }

    public void pr(uc ucVar) {
        this.ny = ucVar;
    }

    public void pr(com.byazt.dd.ho hoVar) {
        this.aj = hoVar;
    }

    public void pr(com.byazt.dd.g gVar) {
        this.vk = gVar;
    }

    public boolean x() {
        g gVar = this.m;
        return (gVar == null || gVar.hn() == null) ? false : true;
    }
}
