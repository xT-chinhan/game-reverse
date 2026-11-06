package com.bytedance.sdk.openadsdk.core.ugeno.ab;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.adsdk.ugeno.ah.ny;
import com.bytedance.adsdk.ugeno.ah.sl;
import com.bytedance.adsdk.ugeno.ah.ub;
import com.bytedance.adsdk.ugeno.ah.zb;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.hi;
import com.bytedance.sdk.openadsdk.core.nw;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.pc;
import com.bytedance.sdk.openadsdk.core.t.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c implements ub {
    private com.bytedance.adsdk.ugeno.xr.ah ab;
    private com.bytedance.adsdk.ugeno.xr.ah<View> ah;
    private lm c;
    private hi ch;
    private d d;
    private pc hi;
    private ah ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Context f3380ms;
    private x ny;
    private String sl;
    private xr x;
    private com.bytedance.sdk.openadsdk.core.zb.ka xr;
    private int zb;

    @Override // com.bytedance.adsdk.ugeno.ah.ub
    public void ms(com.bytedance.adsdk.ugeno.xr.ah ahVar, String str, com.bytedance.adsdk.ugeno.ka.c.ms msVar) {
    }

    public c(Context context, com.bytedance.sdk.openadsdk.core.zb.ka kaVar, lm lmVar, String str, int i) {
        this.f3380ms = context;
        this.xr = kaVar;
        this.c = lmVar;
        this.sl = str;
        this.zb = i;
    }

    public void ms(d dVar) {
        this.d = dVar;
    }

    public void ms(x xVar) {
        this.ny = xVar;
    }

    public void ms(ah ahVar) {
        this.ka = ahVar;
    }

    public void ms(final JSONObject jSONObject, final List<com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ah> list, final ab abVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            xr(jSONObject, list, abVar);
        } else {
            nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ab.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.xr(jSONObject, (List<com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ah>) list, abVar);
                }
            });
        }
    }

    public void ms(hi hiVar) {
        this.ch = hiVar;
    }

    public void ms(xr xrVar) {
        this.x = xrVar;
    }

    public com.bytedance.adsdk.ugeno.xr.ah ms() {
        return this.ab;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(JSONObject jSONObject, List<com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ah> list, ab abVar) {
        sl slVar = new sl(this.f3380ms);
        com.bytedance.adsdk.ugeno.ah.hi hiVar = new com.bytedance.adsdk.ugeno.ah.hi();
        hiVar.ms(this.f3380ms);
        HashMap map = new HashMap();
        map.put("key_material", this.c);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size() && i <= 2; i++) {
            arrayList.add(list.get(i).ms());
        }
        pc pcVar = new pc(this.f3380ms);
        this.hi = pcVar;
        pcVar.ms(this.ch);
        this.hi.ms(this.x);
        this.hi.ms(this.sl);
        this.hi.ah(this.zb);
        map.put("key_data_list", arrayList);
        map.put("key_js_object", this.hi);
        hiVar.ms(map);
        slVar.ms("aggPage", hiVar);
        com.bytedance.adsdk.ugeno.xr.ah<View> ahVarMs = slVar.ms(jSONObject);
        this.ah = ahVarMs;
        if (ahVarMs == null || list == null || list.size() <= 0) {
            com.bytedance.sdk.openadsdk.core.zb.ka kaVar = this.xr;
            if (kaVar != null) {
                kaVar.ms(-1, "ugeno render fail");
            }
            if (abVar != null) {
                abVar.ms(-1, "");
                return;
            }
            return;
        }
        com.bytedance.adsdk.ugeno.xr.ah<T> ahVarAh = this.ah.ah("recycler_layout");
        this.ab = ahVarAh;
        if (ahVarAh instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.xr.c) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.xr.c) ahVarAh).ms(list);
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.xr.c) this.ab).ms(new com.bytedance.sdk.openadsdk.core.ugeno.component.xr.c.xr() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ab.c.2
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xr.c.xr
                public void ms() {
                    if (c.this.d != null) {
                        c.this.d.d(c.this.ab);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xr.c.xr
                public void ms(int i2, int i3) {
                    if (c.this.d != null) {
                        c.this.d.ms(i2, i3);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xr.c.xr
                public void ms(RecyclerView recyclerView, int i2) {
                    if (c.this.d != null) {
                        c.this.d.ms(recyclerView, i2);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xr.c.xr
                public void ms(int i2, View view, com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ah ahVar) {
                    if (c.this.d != null) {
                        c.this.d.ms(c.this.ab, i2, view, ahVar);
                    }
                }
            });
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.xr.c) this.ab).ms(new com.bytedance.sdk.openadsdk.core.ugeno.component.xr.d() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ab.c.3
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xr.d
                public void ms(com.bytedance.adsdk.ugeno.xr.ah<View> ahVar) {
                    if (c.this.d != null) {
                        c.this.d.ka(ahVar);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xr.d
                public void xr(com.bytedance.adsdk.ugeno.xr.ah<View> ahVar) {
                    if (c.this.d != null) {
                        c.this.d.c(ahVar);
                    }
                }
            });
        }
        slVar.ms(new ny() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ab.c.4
            @Override // com.bytedance.adsdk.ugeno.ah.ny
            public void ms(com.bytedance.adsdk.ugeno.xr.ah ahVar) {
                if (c.this.ka != null) {
                    c.this.ka.ah(ahVar);
                }
            }
        });
        slVar.ms(this);
        JSONObject jSONObjectRm = this.c.rm();
        if (list != null && list.size() > 0) {
            try {
                jSONObjectRm.put("ugen_sub_meta", list.get(0).ms());
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
            }
        }
        slVar.xr(jSONObjectRm);
        this.xr.ms(0L);
        if (abVar != null) {
            abVar.ms(this.ah);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ah.ub
    public void ms(zb zbVar, ub.xr xrVar, ub.ms msVar) {
        x xVar;
        if (zbVar == null) {
            return;
        }
        if (zbVar.xr() == 1) {
            xr(zbVar, (ub.xr) null, (ub.ms) null);
            return;
        }
        if (zbVar.xr() != 10 || (xVar = this.ny) == null) {
            return;
        }
        xVar.xr(zbVar.ms());
        pc pcVar = this.hi;
        if (pcVar != null) {
            pcVar.ms("webviewVisible", (JSONObject) null);
        }
    }

    private void xr(zb zbVar, ub.xr xrVar, ub.ms msVar) {
        if (zbVar == null || zbVar.ms() == null) {
            return;
        }
        JSONObject jSONObjectAh = zbVar.ah();
        String strOptString = jSONObjectAh.optString("type");
        String strOptString2 = jSONObjectAh.optString("nodeId");
        strOptString.hashCode();
        if (strOptString.equals("onDismiss")) {
            com.bytedance.adsdk.ugeno.xr.ah<T> ahVarAh = this.ah.ah(strOptString2);
            if (ahVarAh != 0) {
                ahVarAh.xr(8);
            }
        } else if (strOptString.equals("onShow")) {
            com.bytedance.adsdk.ugeno.xr.ah<T> ahVarAh2 = this.ah.ah(strOptString2);
            if (ahVarAh2 != 0) {
                ahVarAh2.xr(0);
            }
        } else {
            ah ahVar = this.ka;
            if (ahVar != null) {
                ahVar.ah(zbVar.ms());
            }
        }
        final String strOptString3 = jSONObjectAh.optString("reportType");
        if (!TextUtils.isEmpty(strOptString3)) {
            u.ms().xr(new com.bytedance.sdk.openadsdk.hi.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ab.c.5
                @Override // com.bytedance.sdk.openadsdk.hi.ms.ms
                public com.bytedance.sdk.openadsdk.core.t.ms.ms ms() throws Exception {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.putOpt("type", strOptString3);
                    return com.bytedance.sdk.openadsdk.core.t.ms.xr.xr().ms("agg_click").xr(jSONObject.toString());
                }
            }, "agg_click");
        }
        if (xrVar == null || zbVar.d() == null) {
            return;
        }
        xrVar.ms(zbVar.d());
    }
}
