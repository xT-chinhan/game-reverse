package com.byazt.sa;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.byazt.ch.g;
import com.byazt.ch.ho;
import com.byazt.ch.lb;
import com.byazt.ch.nt;
import com.byazt.ch.vk;
import com.byazt.hg.of;
import com.byazt.hr.RecyclerView;
import com.byazt.qx.w;
import com.byazt.sd.nl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 158, 5})
public class uc implements lb {
    public zo aj;
    public hn c;
    public com.byazt.ik.hn fw;
    public com.byazt.ik.hn<View> hn;
    public com.byazt.pj.x hw;
    public String k;
    public int m;
    public Context pr;
    public of uc;
    public w vk;
    public nl w;
    public x x;
    public hw zo;

    public uc(Context context, com.byazt.pj.x xVar, of ofVar, String str, int i) {
        this.pr = context;
        this.hw = xVar;
        this.uc = ofVar;
        this.k = str;
        this.m = i;
    }

    public void pr(x xVar) {
        this.x = xVar;
    }

    public void pr(zo zoVar) {
        this.aj = zoVar;
    }

    public void pr(hn hnVar) {
        this.c = hnVar;
    }

    public void pr(final JSONObject jSONObject, final List<com.byazt.um.hn> list, final fw fwVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            hw(jSONObject, list, fwVar);
        } else {
            com.byazt.sd.lb.uc().post(new Runnable() { // from class: com.byazt.sa.uc.1
                @Override // java.lang.Runnable
                public void run() {
                    uc.this.hw(jSONObject, (List<com.byazt.um.hn>) list, fwVar);
                }
            });
        }
    }

    public void pr(w wVar) {
        this.vk = wVar;
    }

    public void pr(hw hwVar) {
        this.zo = hwVar;
    }

    public com.byazt.ik.hn pr() {
        return this.fw;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(JSONObject jSONObject, List<com.byazt.um.hn> list, fw fwVar) {
        ho hoVar = new ho(this.pr);
        g gVar = new g();
        gVar.pr(this.pr);
        HashMap map = new HashMap();
        map.put("key_material", this.uc);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size() && i <= 2; i++) {
            arrayList.add(list.get(i).pr());
        }
        nl nlVar = new nl(this.pr);
        this.w = nlVar;
        nlVar.pr(this.vk);
        this.w.pr(this.zo);
        this.w.pr(this.k);
        this.w.hn(this.m);
        map.put("key_data_list", arrayList);
        map.put("key_js_object", this.w);
        gVar.pr(map);
        hoVar.pr("aggPage", gVar);
        com.byazt.ik.hn<View> hnVarPr = hoVar.pr(jSONObject);
        this.hn = hnVarPr;
        if (hnVarPr == null || list == null || list.size() <= 0) {
            com.byazt.pj.x xVar = this.hw;
            if (xVar != null) {
                xVar.pr(-1, "ugeno render fail");
            }
            if (fwVar != null) {
                fwVar.pr(-1, "");
                return;
            }
            return;
        }
        com.byazt.ik.hn<T> hnVarX = this.hn.x("recycler_layout");
        this.fw = hnVarX;
        if (hnVarX instanceof com.byazt.um.uc) {
            ((com.byazt.um.uc) hnVarX).pr(list);
            ((com.byazt.um.uc) this.fw).pr(new com.byazt.um.uc.hw() { // from class: com.byazt.sa.uc.2
                @Override // com.byazt.um.uc.hw
                public void pr() {
                    if (uc.this.x != null) {
                        uc.this.x.x(uc.this.fw);
                    }
                }

                @Override // com.byazt.um.uc.hw
                public void pr(int i2, int i3) {
                    if (uc.this.x != null) {
                        uc.this.x.hw(i2, i3);
                    }
                }

                @Override // com.byazt.um.uc.hw
                public void pr(RecyclerView recyclerView, int i2) {
                    if (uc.this.x != null) {
                        uc.this.x.pr(recyclerView, i2);
                    }
                }

                @Override // com.byazt.um.uc.hw
                public void pr(int i2, View view, com.byazt.um.hn hnVar) {
                    if (uc.this.x != null) {
                        uc.this.x.pr(uc.this.fw, i2, view, hnVar);
                    }
                }
            });
            ((com.byazt.um.uc) this.fw).pr(new com.byazt.um.x() { // from class: com.byazt.sa.uc.3
                @Override // com.byazt.um.x
                public void pr(com.byazt.ik.hn<View> hnVar) {
                    if (uc.this.x != null) {
                        uc.this.x.c(hnVar);
                    }
                }

                @Override // com.byazt.um.x
                public void hw(com.byazt.ik.hn<View> hnVar) {
                    if (uc.this.x != null) {
                        uc.this.x.uc(hnVar);
                    }
                }
            });
        }
        hoVar.pr(new vk() { // from class: com.byazt.sa.uc.4
            @Override // com.byazt.ch.vk
            public void pr(com.byazt.ik.hn hnVar) {
                if (uc.this.c != null) {
                    uc.this.c.hn(hnVar);
                }
            }
        });
        hoVar.pr(this);
        JSONObject jSONObject2 = this.uc.to();
        if (list != null && list.size() > 0) {
            try {
                jSONObject2.put("ugen_sub_meta", list.get(0).pr());
            } catch (JSONException e) {
            }
        }
        hoVar.hw(jSONObject2);
        this.hw.pr(0L);
        if (fwVar != null) {
            fwVar.pr(this.hn);
        }
    }

    @Override // com.byazt.ch.lb
    public void pr(nt ntVar, lb.hw hwVar, lb.pr prVar) {
        zo zoVar;
        if (ntVar == null) {
            return;
        }
        if (ntVar.hw() == 1) {
            hw(ntVar, (lb.hw) null, (lb.pr) null);
            return;
        }
        if (ntVar.hw() == 10 && (zoVar = this.aj) != null) {
            zoVar.hw(ntVar.pr());
            nl nlVar = this.w;
            if (nlVar != null) {
                nlVar.hw("webviewVisible", (JSONObject) null);
            }
        }
    }

    @Override // com.byazt.ch.lb
    public void pr(com.byazt.ik.hn hnVar, String str, com.byazt.dd.fw.pr prVar) {
    }

    private void hw(nt ntVar, lb.hw hwVar, lb.pr prVar) {
        if (ntVar == null || ntVar.pr() == null) {
            return;
        }
        JSONObject jSONObjectHn = ntVar.hn();
        String strOptString = jSONObjectHn.optString("type");
        String strOptString2 = jSONObjectHn.optString("nodeId");
        switch (strOptString) {
            case "onDismiss":
                com.byazt.ik.hn<T> hnVarX = this.hn.x(strOptString2);
                if (hnVarX != 0) {
                    hnVarX.hw(8);
                    break;
                }
                break;
            case "onShow":
                com.byazt.ik.hn<T> hnVarX2 = this.hn.x(strOptString2);
                if (hnVarX2 != 0) {
                    hnVarX2.hw(0);
                    break;
                }
                break;
            default:
                hn hnVar = this.c;
                if (hnVar != null) {
                    hnVar.hn(ntVar.pr());
                    break;
                }
                break;
        }
        final String strOptString3 = jSONObjectHn.optString("reportType");
        if (!TextUtils.isEmpty(strOptString3)) {
            com.byazt.xk.hw.pr().pr("agg_click", new com.byazt.ttf.pr() { // from class: com.byazt.sa.uc.5
                @Override // com.byazt.ttf.pr
                public JSONObject pr(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("type", strOptString3);
                    return jSONObject2;
                }
            });
        }
        if (hwVar != null && ntVar.x() != null) {
            hwVar.pr(ntVar.x());
        }
    }
}
