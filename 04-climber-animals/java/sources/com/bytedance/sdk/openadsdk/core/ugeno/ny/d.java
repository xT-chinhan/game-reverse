package com.bytedance.sdk.openadsdk.core.ugeno.ny;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.ah.ub;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.nw;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.ugeno.component.xr.c;
import com.bytedance.sdk.openadsdk.core.zb.ka;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d extends com.bytedance.sdk.openadsdk.core.ugeno.ab.ms {
    private List<com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ah> b;
    private boolean i;
    private int re;

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ab() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public int ah() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void c() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ch() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void d() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public long getActualPlayDuration() {
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void hi() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ka() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public long ms() {
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ms(float f) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ms(float f, float f2, float f3, float f4, int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ms(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ms(int i, String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.d
    public void ms(RecyclerView recyclerView, int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ms(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void ny() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void setPauseFromExpressView(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void x() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public int xr() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.hi
    public void xr(int i) {
    }

    public d(Context context, ViewGroup viewGroup, ka kaVar, lm lmVar, String str, int i) {
        super(context, viewGroup, kaVar, lmVar, str, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.ms
    public List<com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ah> sl() {
        this.b = new ArrayList();
        JSONObject jSONObjectRm = this.ka.rm();
        this.b.add(0, new com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ah(jSONObjectRm, -1221270899));
        this.b.add(new com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ah(jSONObjectRm, -2134548432));
        return this.b;
    }

    public void ah(int i) {
        this.re = i;
        if (i < 0) {
            return;
        }
        final String str = String.format("浏览%d秒可领金币", Integer.valueOf(i));
        if (this.ab instanceof c) {
            nw.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ny.d.1
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.ab != null) {
                        try {
                            RecyclerView recyclerView = (RecyclerView) ((c) d.this.ab).ms();
                            if (recyclerView.getScrollState() != 0 || recyclerView.u()) {
                                return;
                            }
                            ((c) d.this.ab).ms(0, "header");
                        } catch (Exception unused) {
                        }
                    }
                }
            });
            ((c) this.ab).ms(new com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ka.d() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.ny.d.2
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ka.d
                public void ms(RecyclerView.re reVar, int i2) {
                    com.bytedance.adsdk.ugeno.xr.ah ahVarAh = ((com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ka.C0319ka) reVar).op().ah("count_down");
                    if (ahVarAh instanceof com.bytedance.adsdk.ugeno.widget.text.xr) {
                        ((com.bytedance.adsdk.ugeno.widget.text.xr) ahVarAh).x(str);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.d
    public void d(com.bytedance.adsdk.ugeno.xr.ah<View> ahVar) {
        ms(ahVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.d
    public void ms(int i, int i2) {
        if (i2 > 0) {
            this.ch.set(1);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.d
    public void ms(com.bytedance.adsdk.ugeno.xr.ah ahVar, int i, View view, com.bytedance.sdk.openadsdk.core.ugeno.component.xr.ah ahVar2) {
        if (ahVar2 == null || ahVar2.ms() == null) {
            return;
        }
        int iHashCode = ahVar2.ms().hashCode();
        if (this.hi.get(Integer.valueOf(iHashCode)) != null && this.hi.containsKey(Integer.valueOf(iHashCode)) && this.hi.get(Integer.valueOf(iHashCode)).booleanValue()) {
            return;
        }
        ms(ahVar2.ms());
        this.hi.put(Integer.valueOf(iHashCode), Boolean.TRUE);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.d
    public void ka(com.bytedance.adsdk.ugeno.xr.ah<View> ahVar) {
        if (ahVar == null) {
            return;
        }
        if (this.re <= 0 && !this.i && TextUtils.equals(ahVar.of(), "header")) {
            ah(0);
            this.i = true;
        }
        JSONObject jSONObjectCh = ahVar.ch();
        if (jSONObjectCh == null) {
            return;
        }
        ub.xr xrVarAh = ahVar.ah("video_".concat(String.valueOf(jSONObjectCh.optInt("image_mode"))));
        if (xrVarAh instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.xr) {
            com.bytedance.sdk.openadsdk.core.ugeno.component.video.xr xrVar = (com.bytedance.sdk.openadsdk.core.ugeno.component.video.xr) xrVarAh;
            xrVar.ms(this.zb);
            xrVar.am();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.d
    public void c(com.bytedance.adsdk.ugeno.xr.ah<View> ahVar) {
        JSONObject jSONObjectCh;
        if (ahVar == null || (jSONObjectCh = ahVar.ch()) == null) {
            return;
        }
        ub.xr xrVarAh = ahVar.ah("video_".concat(String.valueOf(jSONObjectCh.optInt("image_mode"))));
        if (xrVarAh instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.xr) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.video.xr) xrVarAh).ti();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.ah
    public void ah(com.bytedance.adsdk.ugeno.xr.ah ahVar) {
        lm lmVarMs;
        if (ahVar == null || (lmVarMs = com.bytedance.sdk.openadsdk.core.ms.ms(ahVar.ch())) == null) {
            return;
        }
        ms(lmVarMs, ahVar);
    }
}
