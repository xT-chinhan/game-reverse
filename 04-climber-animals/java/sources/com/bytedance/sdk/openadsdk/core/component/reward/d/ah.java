package com.bytedance.sdk.openadsdk.core.component.reward.d;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.nw.fm;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends com.bytedance.sdk.openadsdk.core.component.reward.d.ms {
    private int az;
    private final AtomicBoolean e;
    private int f;
    private int jw;
    private com.bytedance.sdk.openadsdk.core.component.reward.draw.ka k;
    private final AtomicBoolean lm;
    private int m;
    private final List<com.bytedance.sdk.openadsdk.core.component.reward.draw.xr> pc;
    private int ul;

    public interface ms {
        Map<String, Object> ah();

        void d();

        void ms();

        void ms(int i);

        void xr();
    }

    public static int xr(lm lmVar) {
        return 8;
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

    public ah(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar) {
        super(tTBaseVideoActivity, lmVar);
        this.pc = new ArrayList();
        this.jw = 0;
        this.f = 0;
        this.ul = 0;
        this.az = 0;
        this.m = 0;
        this.lm = new AtomicBoolean(false);
        this.e = new AtomicBoolean(false);
    }

    public static boolean ms(lm lmVar) {
        return (lmVar == null || !fm.ms(lmVar) || TextUtils.isEmpty(lmVar.sd())) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.xr ms(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.d dVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.d(this.f2142ms, this.xr, z);
        float f = this.c;
        float[] fArrY = {this.ka, f};
        if (fArrY[0] < 10.0f || f < 10.0f) {
            fArrY = y();
        }
        dVar.ms(fArrY);
        this.ny = dVar;
        return this.ny;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public View ny() {
        return com.bytedance.sdk.openadsdk.res.ka.ny(this.f2142ms);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.d zf() {
        if (this.ny instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.d) {
            return (com.bytedance.sdk.openadsdk.core.component.reward.layout.d) this.ny;
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void b() {
        if (this.nw.pc()) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.component.reward.draw.ka kaVar = (com.bytedance.sdk.openadsdk.core.component.reward.draw.ka) zf().xr().ah(this.az);
            if (kaVar != null) {
                kaVar.le();
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.xr("cubic  resume exception:" + e.getMessage());
        }
        super.b();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public boolean am() {
        return this.xr.qw() == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public void qk() {
        this.y.ms(true);
        this.y.xr(this.xr.rk());
        this.y.ah(true);
        this.y.ka(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void x() {
        super.x();
        this.pc.add(new com.bytedance.sdk.openadsdk.core.component.reward.draw.xr(this.f2142ms, this.xr, this.sl, am(), true));
        try {
            JSONArray jSONArray = new JSONArray(this.xr.sd());
            for (int i = 0; i < jSONArray.length(); i++) {
                this.pc.add(new com.bytedance.sdk.openadsdk.core.component.reward.draw.xr(this.f2142ms, com.bytedance.sdk.openadsdk.core.ms.ms(jSONArray.getJSONObject(i)), this.sl, am(), false));
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        Iterator<com.bytedance.sdk.openadsdk.core.component.reward.draw.xr> it = this.pc.iterator();
        while (it.hasNext()) {
            it.next().ms(this.zb);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms, com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    protected void ah() {
        this.ny.ah(true);
        if (zf() != null) {
            zf().ah().ms(this.pc);
            zf().d().ms(new com.bytedance.sdk.openadsdk.core.component.reward.draw.ah.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.d.ah.1
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.ah.ms
                public void ms() {
                    ah.this.ul = 0;
                    ms((com.bytedance.sdk.openadsdk.core.component.reward.draw.ka) ah.this.zf().xr().ah(0));
                    ah.this.gy();
                    if (ah.this.pc.size() > 0) {
                        ((com.bytedance.sdk.openadsdk.core.component.reward.draw.xr) ah.this.pc.get(1)).ab();
                    }
                    ah.this.f2142ms.xr(false, true);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.ah.ms
                public void ms(boolean z, int i, boolean z2) {
                    int i2 = ah.this.az;
                    if (ah.this.k != null) {
                        ah.this.f2142ms.am().ms(z, i2 + 1, ah.this.k.of());
                    }
                    ah.this.az = i;
                    ah ahVar = ah.this;
                    ahVar.m = Math.max(ahVar.m, i + 1);
                    ah ahVar2 = ah.this;
                    ahVar2.ul = i % ahVar2.pc.size();
                    ms((com.bytedance.sdk.openadsdk.core.component.reward.draw.ka) ah.this.zf().xr().ah(i));
                    ah.this.zf().c();
                    ah.this.e.set(true);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.ah.ms
                public void ms(boolean z, int i) {
                    com.bytedance.sdk.openadsdk.core.component.reward.draw.ka kaVar = (com.bytedance.sdk.openadsdk.core.component.reward.draw.ka) ah.this.zf().xr().ah(i);
                    if (kaVar != null) {
                        kaVar.xr(false);
                    }
                }

                private void ms(com.bytedance.sdk.openadsdk.core.component.reward.draw.ka kaVar) {
                    if (kaVar != null) {
                        ah.this.k = kaVar;
                        ah.this.k.xr(true);
                        ah.this.k.ms(new ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.d.ah.1.1
                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ah.ms
                            public void ms() {
                                ah.this.h = true;
                                ah.this.zf().ms(false);
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ah.ms
                            public void xr() {
                                ah.this.h = false;
                                ah.this.zf().ms(true);
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ah.ms
                            public void ms(int i) {
                                ah.this.jw += i;
                                ah.this.f += i;
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ah.ms
                            public Map<String, Object> ah() {
                                return ah.this.f2142ms.ab();
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ah.ms
                            public void d() {
                                if (!fm.c(ah.this.xr) || ah.this.zf() == null) {
                                    return;
                                }
                                ah.this.zf().xr().xr(ah.this.az + 1);
                            }
                        });
                        ah.this.h = kaVar.ul();
                        ah.this.zf().ms(!kaVar.az());
                    } else {
                        ah.this.h = false;
                    }
                    ah.this.gy();
                }
            });
        }
        yu();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void i() {
        super.i();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("visible", false);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        this.nw.ms(jSONObject);
        nw();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    protected int ul() {
        return fm.ah(this.xr) - this.f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    protected int ab(boolean z) {
        if (z) {
            return ul();
        }
        return fm.ab(this.xr) - this.f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    protected int m() {
        return this.f;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    protected void v() {
        vy();
        rt();
        sk();
    }

    private void rt() {
        com.bytedance.sdk.openadsdk.core.component.reward.draw.ka kaVar = this.k;
        if (kaVar == null || !kaVar.ul()) {
            int iD = this.pc.get(this.ul).d();
            if (iD > 0) {
                this.jw += iD;
            }
            if ((fm.ah(this.xr) <= this.f) && !this.lm.get()) {
                this.f2142ms.d(0);
                this.f2142ms.zb();
                this.lm.set(true);
            }
            int i = this.f;
            if (i < this.jw) {
                this.f = i + 1;
            }
        }
    }

    private void vy() {
        String str;
        boolean z;
        boolean z2 = Math.max(0, this.p.ka() - w()) == 0;
        int iD = fm.d(this.xr);
        int iKa = fm.ka(this.xr);
        int iC = c(false);
        if (iD == 0) {
            str = iC > 0 ? iC + "s后可领取奖励" : "领取成功";
            z = true;
        } else {
            str = iC > 0 ? iC + "s" : "领取成功";
            z = false;
        }
        xr(c(true));
        this.y.ms(z, str, (z2 && iKa == 1) ? "跳过" : null, z2 && iKa == 0, z2);
    }

    private void sk() {
        if (this.p.ah() <= fm.x(this.xr) || this.e.get() || zf() == null) {
            return;
        }
        zf().ka();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void ka(boolean z) {
        super.ka(z);
        com.bytedance.sdk.openadsdk.core.component.reward.draw.ka kaVar = this.k;
        if (kaVar != null) {
            kaVar.ah(z);
        }
        Iterator<com.bytedance.sdk.openadsdk.core.component.reward.draw.xr> it = this.pc.iterator();
        while (it.hasNext()) {
            it.next().ms(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public com.bytedance.sdk.openadsdk.core.component.reward.ah.xr.ms ms(final com.bytedance.sdk.openadsdk.core.component.reward.ah.ch chVar) {
        this.f2142ms.e();
        com.bytedance.sdk.openadsdk.core.component.reward.ah.ka kaVar = new com.bytedance.sdk.openadsdk.core.component.reward.ah.ka(this.f2142ms, this.xr);
        kaVar.ms(az());
        return kaVar.xr(new com.bytedance.sdk.openadsdk.core.component.reward.ah.ch() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.d.ah.2
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.ah.ch
            public void ms() {
                super.ms();
                com.bytedance.sdk.openadsdk.core.component.reward.ah.ch chVar2 = chVar;
                if (chVar2 != null) {
                    chVar2.ms();
                }
                ah.this.f2142ms.k();
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
                ah.this.f2142ms.k();
                if (ah.this.zf() != null) {
                    ah.this.zf().xr().xr(ah.this.az + 1);
                }
                ah.this.f2142ms.am().ms("reward_retain_dialog_next", 0, "");
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void ub() {
        super.ub();
        List<com.bytedance.sdk.openadsdk.core.component.reward.draw.xr> list = this.pc;
        if (list != null) {
            Iterator<com.bytedance.sdk.openadsdk.core.component.reward.draw.xr> it = list.iterator();
            while (it.hasNext()) {
                it.next().ny();
            }
        }
        if (zf() != null) {
            zf().ah().d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gy() {
        com.bykv.vk.openvk.component.video.api.ah.d dVarHi;
        com.bytedance.sdk.openadsdk.core.component.reward.draw.ka kaVar = this.k;
        lm lmVarMs = null;
        com.bykv.vk.openvk.component.video.api.d.ah ahVarF = kaVar != null ? kaVar.f() : null;
        com.bytedance.sdk.openadsdk.core.component.reward.draw.xr xrVar = this.pc.get(this.ul);
        if (xrVar != null) {
            lmVarMs = xrVar.ms();
            dVarHi = xrVar.hi();
        } else {
            dVarHi = null;
        }
        this.t.ms(lmVarMs, ahVarF, dVarHi);
        this.t.xr(this.f2142ms.ab());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public int cv() {
        return xr(this.xr);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void ms(Map<String, Object> map) {
        super.ms(map);
        map.put("group_pos", Integer.valueOf(this.az + 1));
        com.bytedance.sdk.openadsdk.core.component.reward.draw.ka kaVar = this.k;
        if (kaVar != null) {
            map.put("duration", Long.valueOf(kaVar.of()));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void ms(JSONObject jSONObject) {
        super.ms(jSONObject);
        try {
            jSONObject.put("group_pos", this.ul + 1);
            jSONObject.put("duration", this.k.of());
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void ms(View view) {
        super.ms(view);
        this.k.ms(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void nw() {
        super.nw();
        try {
            com.bytedance.sdk.openadsdk.core.component.reward.draw.ka kaVar = (com.bytedance.sdk.openadsdk.core.component.reward.draw.ka) zf().xr().ah(this.az);
            if (kaVar != null) {
                kaVar.op();
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.sl.xr("cubic pause exception:" + e.getMessage());
        }
    }
}
