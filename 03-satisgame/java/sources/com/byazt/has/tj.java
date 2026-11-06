package com.byazt.has;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.byazt.df.TTBaseVideoActivity;
import com.byazt.gct.pe;
import com.byazt.gct.pk;
import com.byazt.gct.ur;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 236, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT})
public class tj extends n {
    public int lh;
    public final List<com.byazt.bpa.n> ln;

    public static int qg(pk pkVar) {
        return 11;
    }

    @Override // com.byazt.has.qg
    public boolean cx() {
        return true;
    }

    @Override // com.byazt.has.qg
    public boolean lq() {
        return true;
    }

    @Override // com.byazt.has.n
    public boolean w() {
        return false;
    }

    @Override // com.byazt.has.qg
    public boolean yw() {
        return false;
    }

    public tj(TTBaseVideoActivity tTBaseVideoActivity, pk pkVar) {
        super(tTBaseVideoActivity, pkVar);
        this.ln = new ArrayList();
        this.lh = 0;
    }

    public static boolean n(pk pkVar) {
        if (pkVar == null) {
            return false;
        }
        return ur.n(pkVar);
    }

    @Override // com.byazt.has.n
    public com.byazt.tkz.qg n(boolean z) {
        com.byazt.tkz.tj tjVar = new com.byazt.tkz.tj(this.n, this.qg, z);
        tjVar.n(new float[]{this.l, this.w});
        this.rv = tjVar;
        return this.rv;
    }

    @Override // com.byazt.has.n
    public View rv() {
        FrameLayout frameLayout = new FrameLayout(this.n);
        frameLayout.setId(2114387959);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setBackgroundColor(0);
        return frameLayout;
    }

    private com.byazt.tkz.tj i() {
        if (this.rv instanceof com.byazt.tkz.tj) {
            return (com.byazt.tkz.tj) this.rv;
        }
        return null;
    }

    @Override // com.byazt.has.n
    public void m() {
        ((com.byazt.tkz.tj) this.rv).s();
    }

    @Override // com.byazt.has.qg
    public void dn() {
        this.cd.n(false);
        this.cd.qg(false);
        this.cd.l(false);
    }

    @Override // com.byazt.has.n
    public void k() {
        super.k();
        ((com.byazt.tkz.tj) this.rv).qg();
    }

    @Override // com.byazt.has.n
    public void qg(boolean z) {
        super.qg(z);
        ((com.byazt.tkz.tj) this.rv).s();
    }

    @Override // com.byazt.has.n
    public void fs() {
        super.fs();
        com.byazt.bpa.n nVar = new com.byazt.bpa.n(this.n, this.qg, this.d, cx(), true);
        nVar.n(this.oa);
        this.ln.add(nVar);
        if (ur.s(this.qg)) {
            try {
                JSONArray jSONArray = new JSONArray(this.qg.hj());
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(com.byazt.vgx.qg.n(jSONArray.getJSONObject(i)));
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(this.qg);
                arrayList2.addAll(arrayList);
                if (ur.n(arrayList2)) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        com.byazt.bpa.n nVar2 = new com.byazt.bpa.n(this.n, (pk) arrayList.get(i2), this.d, cx(), false);
                        nVar2.n(this.oa);
                        this.ln.add(nVar2);
                    }
                }
            } catch (JSONException unused) {
            }
        }
    }

    @Override // com.byazt.has.n, com.byazt.has.qg
    public void s() {
        this.rv.s(true);
        if (i() != null) {
            i().n(this.ln);
        }
        this.n.s(false, true);
    }

    @Override // com.byazt.has.n
    public void h() {
        super.h();
        if (this.rv instanceof com.byazt.tkz.tj) {
            ((com.byazt.tkz.tj) this.rv).tj();
        }
    }

    @Override // com.byazt.has.n
    public int fs(boolean z) {
        return pe.s(this.qg) - this.lh;
    }

    @Override // com.byazt.has.n
    public void ae() {
        super.ae();
        if (this.rv instanceof com.byazt.tkz.tj) {
            ((com.byazt.tkz.tj) this.rv).q();
        }
    }

    @Override // com.byazt.has.n
    public int x(boolean z) {
        if (z) {
            return fs(z);
        }
        return pe.x(this.qg) - this.lh;
    }

    @Override // com.byazt.has.n
    public int u() {
        return this.lh;
    }

    @Override // com.byazt.has.n
    public void l(boolean z) {
        super.l(z);
    }

    @Override // com.byazt.has.n
    public com.byazt.aqe.qg.n n(pk pkVar, final com.byazt.aqe.tj tjVar) {
        this.n.dg();
        com.byazt.aqe.l lVar = new com.byazt.aqe.l(this.n, pkVar);
        lVar.n(dg());
        return lVar.qg(new com.byazt.aqe.tj() { // from class: com.byazt.has.tj.1
            @Override // com.byazt.aqe.tj
            public void n() {
                super.n();
                com.byazt.aqe.tj tjVar2 = tjVar;
                if (tjVar2 != null) {
                    tjVar2.n();
                }
                tj.this.n.u();
            }

            @Override // com.byazt.aqe.tj
            public void qg() {
                com.byazt.aqe.tj tjVar2 = tjVar;
                if (tjVar2 != null) {
                    tjVar2.qg();
                }
            }

            @Override // com.byazt.aqe.tj
            public void s() {
                super.s();
                com.byazt.aqe.tj tjVar2 = tjVar;
                if (tjVar2 != null) {
                    tjVar2.s();
                }
                tj.this.n.u();
                tj.this.n.ri().n("reward_retain_dialog_next", 0, "");
            }
        });
    }

    @Override // com.byazt.has.n
    public void hd() {
        super.hd();
        this.rv.tj();
        List<com.byazt.bpa.n> list = this.ln;
        if (list != null) {
            Iterator<com.byazt.bpa.n> it = list.iterator();
            while (it.hasNext()) {
                it.next().fs();
            }
        }
    }

    @Override // com.byazt.has.n
    public int v() {
        return qg(this.qg);
    }

    @Override // com.byazt.has.n
    public void n(Map<String, Object> map) {
        super.n(map);
        map.put("refresh_num", Integer.valueOf(dw()));
    }

    @Override // com.byazt.has.n
    public void n(JSONObject jSONObject) {
        super.n(jSONObject);
        try {
            jSONObject.put("refresh_num", dw());
        } catch (JSONException unused) {
        }
    }

    @Override // com.byazt.has.n
    public void qg(Map<String, Object> map) {
        super.qg(map);
        map.put("refresh_num", Integer.valueOf(dw()));
    }

    @Override // com.byazt.has.n
    public void n(View view) {
        super.n(view);
    }

    @Override // com.byazt.has.n
    public void wm() {
        ((com.byazt.tkz.tj) this.rv).qg();
    }

    private int dw() {
        int iL;
        com.byazt.bpa.n nVar;
        pk pkVarN;
        ur urVarNq;
        com.byazt.tkz.tj tjVar = (com.byazt.tkz.tj) this.rv;
        if (tjVar == null || (iL = tjVar.l()) < 0 || iL >= this.ln.size() || (nVar = this.ln.get(iL)) == null || (pkVarN = nVar.n()) == null || (urVarNq = pkVarN.nq()) == null) {
            return 0;
        }
        return urVarNq.s();
    }

    public void vb() {
        ((com.byazt.tkz.tj) this.rv).q();
    }

    public void fl() {
        ((com.byazt.tkz.tj) this.rv).w();
    }
}
