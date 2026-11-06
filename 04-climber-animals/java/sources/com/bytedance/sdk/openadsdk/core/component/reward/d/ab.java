package com.bytedance.sdk.openadsdk.core.component.reward.d;

import android.app.Dialog;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.nw.f;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.xn;
import com.bytedance.sdk.openadsdk.core.op;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.yu;
import com.umeng.ccg.a;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ab extends ms {
    private com.bytedance.sdk.openadsdk.core.xr.ms az;
    private boolean f;
    protected final AtomicBoolean jw;
    protected boolean pc;
    private com.bytedance.sdk.openadsdk.core.component.reward.view.xr ul;

    public static int xr(lm lmVar) {
        return 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public boolean am() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public boolean sa() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    protected boolean ti() {
        return true;
    }

    public ab(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar) {
        super(tTBaseVideoActivity, lmVar);
        this.pc = false;
        this.jw = new AtomicBoolean(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public boolean l() {
        return am() && this.xr.fm() == 1;
    }

    public static boolean ms(lm lmVar) {
        return com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(lmVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.xr
    public void qk() {
        if (c()) {
            this.y.xr(false);
            this.y.ka(false);
            this.ny.c(8);
            this.ny.ka(8);
            this.ny.ah(8);
            return;
        }
        this.y.xr(this.xr.rk());
        this.y.ka(true);
        this.ny.c(0);
        this.ny.ka(0);
        this.ny.ah(0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public View ny() {
        if (this.ah == 2) {
            return com.bytedance.sdk.openadsdk.res.ka.u(this.f2142ms);
        }
        return com.bytedance.sdk.openadsdk.res.ka.ub(this.f2142ms);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.xr ms(boolean z) {
        this.ny = new com.bytedance.sdk.openadsdk.core.component.reward.layout.x(this.f2142ms, this.xr, z);
        return this.ny;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void ao() {
        super.ao();
        this.y.xr(this.xr.rk());
        this.y.ka(true);
        this.ny.c(0);
        this.ny.ka(0);
        this.ny.ah(0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public boolean h() {
        if (this.f) {
            return true;
        }
        return (com.bytedance.sdk.openadsdk.core.live.xr.ms().xr(this.xr) || xn.ah(this.xr)) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void ms(int i, int i2, Intent intent) {
        super.ms(i, i2, intent);
        if (xn.ah(this.xr) || i != 1 || intent == null || intent.getExtras() == null || this.f) {
            return;
        }
        long j = intent.getExtras().getLong("csj.reward_countdown_duration_ms");
        int iF = (int) (((long) f()) - j);
        this.f2142ms.ms(iF, false);
        if (j <= 0) {
            x(true);
            ka(0);
            this.f = true;
            return;
        }
        ms(iF);
    }

    private void ms(long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showTime", j);
            if (this.ch == null || !this.ch.c()) {
                return;
            }
            this.ch.ms("rewardInnerLiveShowTime", jSONObject);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void xr(boolean z) {
        super.xr(z);
        if (!com.bytedance.sdk.openadsdk.core.xr.ms().xr("is_reward_deep_link_to_live", false) || xn.ah(this.xr) || z) {
            return;
        }
        re.ms().ms(rt(), new yu.d() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.d.ab.1
            @Override // com.bytedance.sdk.openadsdk.core.yu.d
            public void ms(int i, String str) {
                ab.this.x(false);
            }

            @Override // com.bytedance.sdk.openadsdk.core.yu.d
            public void ms(op.ah ahVar) {
                if (ahVar.ah == null) {
                    return;
                }
                boolean zMs = ahVar.ah.ms();
                ab.this.x(zMs);
                if (zMs) {
                    ab.this.f2142ms.d(0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("showSkip", z);
            if (this.ch != null) {
                this.ch.ms("showSkipInLiveScene", jSONObject);
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
    }

    private JSONObject rt() {
        JSONObject jSONObject = new JSONObject();
        f fVarDm = this.xr.dm();
        if (fVarDm == null) {
            return jSONObject;
        }
        String strD = fVarDm.d();
        if (TextUtils.isEmpty(strD)) {
            return jSONObject;
        }
        try {
            String strOptString = new JSONObject(strD).optString("token");
            jSONObject.put("req_id", fVarDm.c());
            jSONObject.put("token", strOptString);
            jSONObject.put(a.z, "query_box");
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.sl.ms(e);
        }
        return jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public void t() {
        super.t();
        zf();
        if (this.ch.c()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.live.xr.ms().xr(this.xr)) {
            vy();
            return;
        }
        if (xn.ms(this.xr) && this.ul == null && !com.bytedance.sdk.openadsdk.core.xr.ms().xr("is_reward_deep_link_to_live", false) && xn.ka(this.xr) != 1 && this.t.g() >= ((long) xn.ab(this.xr)) * 1000) {
            this.jw.set(true);
            if (this.t != null && this.t.xr()) {
                this.f2142ms.e();
            }
            this.ul = new com.bytedance.sdk.openadsdk.core.component.reward.view.xr(this.f2142ms, this.xr, new com.bytedance.sdk.openadsdk.core.component.reward.view.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.d.ab.2
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.xr.ms
                public void ms(Dialog dialog) {
                    ab.this.ul.dismiss();
                    ab.this.f2142ms.k();
                    ab.this.jw.set(false);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.view.xr.ms
                public void xr(Dialog dialog) {
                    if (ab.this.az != null) {
                        HashMap map = new HashMap();
                        map.put("is_auto_click", Boolean.TRUE);
                        ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) ab.this.az.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ms(map);
                        ab.this.az.ms(null, new com.bytedance.sdk.openadsdk.core.nw.hi());
                    }
                }
            });
            com.bytedance.sdk.openadsdk.core.xr.ms msVar = new com.bytedance.sdk.openadsdk.core.xr.ms(this.f2142ms, this.xr, this.sl, 7) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.d.ab.3
                @Override // com.bytedance.sdk.openadsdk.core.xr.xr, com.bytedance.sdk.openadsdk.core.xr.d
                public void ms(View view, com.bytedance.sdk.openadsdk.core.nw.hi hiVar) {
                    super.ms(view, hiVar);
                    ab.this.ul.dismiss();
                }
            };
            this.az = msVar;
            this.f2142ms.ms((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah) msVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.class));
            this.ul.ms(this.az);
            if (this.f2142ms.isFinishing()) {
                return;
            }
            this.ul.show();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public boolean g() {
        return this.jw.get();
    }

    private void vy() {
        if (this.pc || this.x == null) {
            return;
        }
        if (((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.x.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).xr().ao()) {
            this.pc = true;
            xr(8, 0);
            return;
        }
        if (xn.ms(this.xr)) {
            int iKa = xn.ka(this.xr);
            if (this.xr.od() == 2) {
                xr(0, -1);
            }
            if (iKa != 3) {
                return;
            }
            long jAb = ((long) xn.ab(this.xr)) * 1000;
            if (this.t.g() >= jAb) {
                xr(8, 0);
                sk();
                this.pc = true;
                return;
            }
            xr(0, (int) ((jAb - this.t.g()) / 1000));
        }
    }

    private void xr(int i, int i2) {
        if (this.ny != null && (this.ny instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.x)) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.x) this.ny).ms(i, i2);
        }
    }

    private void sk() {
        if (this.x == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("is_auto_click", Boolean.TRUE);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) this.x.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ms(map);
        this.x.ms(null, new com.bytedance.sdk.openadsdk.core.nw.hi());
    }

    public void zf() {
        if (xn.ms(this.xr)) {
            f fVarDm = this.xr.dm();
            if (fVarDm != null || com.bytedance.sdk.openadsdk.core.live.xr.ms().xr(this.xr)) {
                int iF = f();
                if (fVarDm != null) {
                    fVarDm.ms(iF);
                }
                ka(iF);
            }
        }
    }

    private void ka(int i) {
        if (this.x != null) {
            ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.x.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(i);
        }
        if (this.i != null) {
            ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.i.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(i);
        }
        if (this.re != null) {
            ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.re.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.d.ms
    public int cv() {
        return xr(this.xr);
    }
}
