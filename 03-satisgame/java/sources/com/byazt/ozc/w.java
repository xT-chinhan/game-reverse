package com.byazt.ozc;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.byazt.gct.pk;
import com.byazt.prf.RecyclerView;
import com.byazt.vh.cd;
import com.byazt.vh.cy;
import com.byazt.vh.k;
import com.byazt.vh.sz;
import com.byazt.vh.tj;
import com.byazt.za.d;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FIRST_VIDEO_SEND_OUTLET_TIME, 13})
public class w implements cd {
    public com.byazt.gcl.s cp;
    public String d;
    public qg fs;
    public s l;
    public Context n;
    public int oa;
    public q q;
    public com.byazt.hm.q qg;
    public fs rv;
    public com.byazt.ih.s<View> s;
    public d tj;
    public pk w;
    public com.byazt.ih.s x;

    @Override // com.byazt.vh.cd
    public void n(com.byazt.ih.s sVar, String str, com.byazt.xz.x.n nVar) {
    }

    public w(Context context, com.byazt.hm.q qVar, pk pkVar, String str, int i) {
        this.n = context;
        this.qg = qVar;
        this.w = pkVar;
        this.d = str;
        this.oa = i;
    }

    public void n(q qVar) {
        this.q = qVar;
    }

    public void n(fs fsVar) {
        this.rv = fsVar;
    }

    public void n(s sVar) {
        this.l = sVar;
    }

    public void n(final JSONObject jSONObject, final List<com.byazt.mu.s> list, final x xVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            qg(jSONObject, list, xVar);
        } else {
            com.byazt.vyf.l.q().post(new Runnable() { // from class: com.byazt.ozc.w.1
                @Override // java.lang.Runnable
                public void run() {
                    w.this.qg(jSONObject, (List<com.byazt.mu.s>) list, xVar);
                }
            });
        }
    }

    public void n(d dVar) {
        this.tj = dVar;
    }

    public void n(qg qgVar) {
        this.fs = qgVar;
    }

    public com.byazt.ih.s n() {
        return this.x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(JSONObject jSONObject, List<com.byazt.mu.s> list, x xVar) {
        k kVar = new k(this.n);
        sz szVar = new sz();
        szVar.n(this.n);
        HashMap map = new HashMap();
        map.put("key_material", this.w);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size() && i <= 2; i++) {
            arrayList.add(list.get(i).n());
        }
        com.byazt.gcl.s sVar = new com.byazt.gcl.s(this.n);
        this.cp = sVar;
        sVar.n(this.tj);
        this.cp.n(this.fs);
        this.cp.n(this.d);
        this.cp.s(this.oa);
        map.put("key_data_list", arrayList);
        map.put("key_js_object", this.cp);
        szVar.qg(map);
        kVar.n("aggPage", szVar);
        com.byazt.ih.s<View> sVarN = kVar.n(jSONObject);
        this.s = sVarN;
        if (sVarN == null || list == null || list.size() <= 0) {
            com.byazt.hm.q qVar = this.qg;
            if (qVar != null) {
                qVar.n(-1, "ugeno render fail");
            }
            if (xVar != null) {
                xVar.n(-1, "");
                return;
            }
            return;
        }
        com.byazt.ih.s<T> sVarQ = this.s.q("recycler_layout");
        this.x = sVarQ;
        if (sVarQ instanceof com.byazt.mu.w) {
            ((com.byazt.mu.w) sVarQ).n(list);
            ((com.byazt.mu.w) this.x).n(new com.byazt.mu.w.qg() { // from class: com.byazt.ozc.w.2
                @Override // com.byazt.mu.w.qg
                public void n() {
                    if (w.this.q != null) {
                        w.this.q.q(w.this.x);
                    }
                }

                @Override // com.byazt.mu.w.qg
                public void n(int i2, int i3) {
                    if (w.this.q != null) {
                        w.this.q.qg(i2, i3);
                    }
                }

                @Override // com.byazt.mu.w.qg
                public void n(RecyclerView recyclerView, int i2) {
                    if (w.this.q != null) {
                        w.this.q.n(recyclerView, i2);
                    }
                }

                @Override // com.byazt.mu.w.qg
                public void n(int i2, View view, com.byazt.mu.s sVar2) {
                    if (w.this.q != null) {
                        w.this.q.n(w.this.x, i2, view, sVar2);
                    }
                }
            });
            ((com.byazt.mu.w) this.x).n(new com.byazt.mu.q() { // from class: com.byazt.ozc.w.3
                @Override // com.byazt.mu.q
                public void n(com.byazt.ih.s<View> sVar2) {
                    if (w.this.q != null) {
                        w.this.q.l(sVar2);
                    }
                }

                @Override // com.byazt.mu.q
                public void qg(com.byazt.ih.s<View> sVar2) {
                    if (w.this.q != null) {
                        w.this.q.w(sVar2);
                    }
                }
            });
        }
        kVar.n(new tj() { // from class: com.byazt.ozc.w.4
            @Override // com.byazt.vh.tj
            public void n(com.byazt.ih.s sVar2) {
                if (w.this.l != null) {
                    w.this.l.s(sVar2);
                }
            }
        });
        kVar.n(this);
        JSONObject jSONObjectPv = this.w.pv();
        if (list != null && list.size() > 0) {
            try {
                jSONObjectPv.put("ugen_sub_meta", list.get(0).n());
            } catch (JSONException unused) {
            }
        }
        kVar.qg(jSONObjectPv);
        this.qg.n(0L);
        if (xVar != null) {
            xVar.n(this.s);
        }
    }

    @Override // com.byazt.vh.cd
    public void n(cy cyVar, cd.qg qgVar, cd.n nVar) {
        fs fsVar;
        if (cyVar == null) {
            return;
        }
        if (cyVar.qg() == 1) {
            qg(cyVar, (cd.qg) null, (cd.n) null);
            return;
        }
        if (cyVar.qg() != 10 || (fsVar = this.rv) == null) {
            return;
        }
        fsVar.qg(cyVar.n());
        com.byazt.gcl.s sVar = this.cp;
        if (sVar != null) {
            sVar.qg("webviewVisible", (JSONObject) null);
        }
    }

    private void qg(cy cyVar, cd.qg qgVar, cd.n nVar) {
        if (cyVar == null || cyVar.n() == null) {
            return;
        }
        JSONObject jSONObjectS = cyVar.s();
        String strOptString = jSONObjectS.optString("type");
        String strOptString2 = jSONObjectS.optString("nodeId");
        strOptString.hashCode();
        if (strOptString.equals("onDismiss")) {
            com.byazt.ih.s<T> sVarQ = this.s.q(strOptString2);
            if (sVarQ != 0) {
                sVarQ.qg(8);
            }
        } else if (strOptString.equals("onShow")) {
            com.byazt.ih.s<T> sVarQ2 = this.s.q(strOptString2);
            if (sVarQ2 != 0) {
                sVarQ2.qg(0);
            }
        } else {
            s sVar = this.l;
            if (sVar != null) {
                sVar.s(cyVar.n());
            }
        }
        final String strOptString3 = jSONObjectS.optString("reportType");
        if (!TextUtils.isEmpty(strOptString3)) {
            com.byazt.eji.s.n().n("agg_click", new com.byazt.rs.n() { // from class: com.byazt.ozc.w.5
                @Override // com.byazt.rs.n
                public JSONObject n(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("type", strOptString3);
                    return jSONObject2;
                }
            });
        }
        if (qgVar == null || cyVar.q() == null) {
            return;
        }
        qgVar.n(cyVar.q());
    }
}
