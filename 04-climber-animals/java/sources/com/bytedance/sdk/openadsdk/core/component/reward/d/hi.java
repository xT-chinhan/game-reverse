package com.bytedance.sdk.openadsdk.core.component.reward.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.nw.fm;
import com.bytedance.sdk.openadsdk.core.nw.le;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.t.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class hi extends ms {
    private int jw;
    private final List<com.bytedance.sdk.openadsdk.core.component.reward.swiper.ms> pc;

    public static int xr(lm lmVar) {
        return 11;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public boolean am() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public boolean c() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public boolean l() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public boolean sa() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    protected void v() {
    }

    public hi(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar) {
        super(tTBaseVideoActivity, lmVar);
        this.pc = new ArrayList();
        this.jw = 0;
    }

    public static boolean ms(lm lmVar) {
        if (lmVar == null || !le.ms(lmVar)) {
            return false;
        }
        if (!com.bytedance.sdk.openadsdk.core.u.d.ms(String.valueOf(f.ny(lmVar)))) {
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cid", lmVar.cz());
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        u.ms().ms(lmVar, "refresh_max", jSONObject);
        com.bytedance.sdk.openadsdk.core.zb.ah.ab(lmVar, f.xr(lmVar), "refresh_max", null);
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.xr ms(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.ch chVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.ch(this.f2142ms, this.xr, z);
        chVar.ms(new float[]{this.ka, this.c});
        this.ny = chVar;
        return this.ny;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public View ny() {
        FrameLayout frameLayout = new FrameLayout(this.f2142ms);
        frameLayout.setId(2114387959);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setBackgroundColor(0);
        return frameLayout;
    }

    private com.bytedance.sdk.openadsdk.core.component.reward.layout.ch zf() {
        if (this.ny instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.ch) {
            return (com.bytedance.sdk.openadsdk.core.component.reward.layout.ch) this.ny;
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void b() {
        super.b();
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.ch) this.ny).ah();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public void qk() {
        this.y.ms(false);
        this.y.xr(false);
        this.y.ka(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void u() {
        super.u();
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.ch) this.ny).xr();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void xr(boolean z) {
        super.xr(z);
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.ch) this.ny).ah();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void x() {
        super.x();
        com.bytedance.sdk.openadsdk.core.component.reward.swiper.ms msVar = new com.bytedance.sdk.openadsdk.core.component.reward.swiper.ms(this.f2142ms, this.xr, this.sl, am(), true);
        msVar.ms(this.zb);
        this.pc.add(msVar);
        if (le.xr(this.xr)) {
            try {
                JSONArray jSONArray = new JSONArray(this.xr.sd());
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(com.bytedance.sdk.openadsdk.core.ms.ms(jSONArray.getJSONObject(i)));
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(this.xr);
                arrayList2.addAll(arrayList);
                if (le.ms(arrayList2)) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        com.bytedance.sdk.openadsdk.core.component.reward.swiper.ms msVar2 = new com.bytedance.sdk.openadsdk.core.component.reward.swiper.ms(this.f2142ms, (lm) arrayList.get(i2), this.sl, am(), false);
                        msVar2.ms(this.zb);
                        this.pc.add(msVar2);
                    }
                }
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms, com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    protected void ah() {
        this.ny.ah(true);
        if (zf() != null) {
            zf().ms(this.pc);
        }
        this.f2142ms.xr(false, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void i() {
        super.i();
        if (this.ny instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.ch) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.ch) this.ny).ch();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    protected int ul() {
        return fm.ah(this.xr) - this.jw;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void p() {
        super.p();
        if (this.ny instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.ch) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.ch) this.ny).d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    protected int ab(boolean z) {
        if (z) {
            return ul();
        }
        return fm.ab(this.xr) - this.jw;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    protected int m() {
        return this.jw;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void ka(boolean z) {
        super.ka(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public com.bytedance.sdk.openadsdk.core.component.reward.ah.xr.ms ms(final com.bytedance.sdk.openadsdk.core.component.reward.ah.ch chVar) {
        this.f2142ms.e();
        com.bytedance.sdk.openadsdk.core.component.reward.ah.ka kaVar = new com.bytedance.sdk.openadsdk.core.component.reward.ah.ka(this.f2142ms, this.xr);
        kaVar.ms(az());
        return kaVar.xr(new com.bytedance.sdk.openadsdk.core.component.reward.ah.ch() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.d.hi.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ch
            public void ms() {
                super.ms();
                com.bytedance.sdk.openadsdk.core.component.reward.ah.ch chVar2 = chVar;
                if (chVar2 != null) {
                    chVar2.ms();
                }
                hi.this.f2142ms.k();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ch
            public void xr() {
                com.bytedance.sdk.openadsdk.core.component.reward.ah.ch chVar2 = chVar;
                if (chVar2 != null) {
                    chVar2.xr();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ch
            public void ah() {
                super.ah();
                com.bytedance.sdk.openadsdk.core.component.reward.ah.ch chVar2 = chVar;
                if (chVar2 != null) {
                    chVar2.ah();
                }
                hi.this.f2142ms.k();
                hi.this.f2142ms.am().ms("reward_retain_dialog_next", 0, "");
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void ub() {
        super.ub();
        this.ny.ch();
        List<com.bytedance.sdk.openadsdk.core.component.reward.swiper.ms> list = this.pc;
        if (list != null) {
            Iterator<com.bytedance.sdk.openadsdk.core.component.reward.swiper.ms> it = list.iterator();
            while (it.hasNext()) {
                it.next().ny();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public int cv() {
        return xr(this.xr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void ms(Map<String, Object> map) {
        super.ms(map);
        map.put("refresh_num", Integer.valueOf(rt()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void ms(JSONObject jSONObject) {
        super.ms(jSONObject);
        try {
            jSONObject.put("refresh_num", rt());
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void xr(Map<String, Object> map) {
        super.xr(map);
        map.put("refresh_num", Integer.valueOf(rt()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void ms(View view) {
        super.ms(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void nw() {
        super.nw();
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.ch) this.ny).xr();
    }

    private int rt() {
        int iKa;
        com.bytedance.sdk.openadsdk.core.component.reward.swiper.ms msVar;
        lm lmVarMs;
        le leVarFi;
        com.bytedance.sdk.openadsdk.core.component.reward.layout.ch chVar = (com.bytedance.sdk.openadsdk.core.component.reward.layout.ch) this.ny;
        if (chVar == null || (iKa = chVar.ka()) < 0 || iKa >= this.pc.size() || (msVar = this.pc.get(iKa)) == null || (lmVarMs = msVar.ms()) == null || (leVarFi = lmVarMs.fi()) == null) {
            return 0;
        }
        return leVarFi.ah();
    }
}
