package com.bytedance.sdk.openadsdk.core.component.reward.top;

import android.view.View;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qf;
import com.bytedance.sdk.openadsdk.core.nw.t;
import com.bytedance.sdk.openadsdk.core.t.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ah implements xr {
    protected com.bytedance.sdk.openadsdk.core.component.reward.xr.xr ah;
    protected int c = 0;
    protected com.bytedance.sdk.openadsdk.core.component.reward.xr.ka d;
    protected TTBaseVideoActivity ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected boolean f2252ms;
    protected lm xr;

    public ah(TTBaseVideoActivity tTBaseVideoActivity, lm lmVar, com.bytedance.sdk.openadsdk.core.component.reward.xr.xr xrVar, com.bytedance.sdk.openadsdk.core.component.reward.xr.ka kaVar, boolean z) {
        this.ka = tTBaseVideoActivity;
        this.xr = lmVar;
        this.ah = xrVar;
        this.d = kaVar;
        this.f2252ms = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xr
    public void ah(View view) {
        ms(1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xr
    public void ms(View view) {
        ms(2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xr
    public void xr(View view) {
        ms(3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xr
    public void d(View view) {
        ms(4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xr
    public void ka(View view) {
        ms(5);
        this.ka.x(3);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.top.xr
    public void c(View view) {
        ms(6);
    }

    protected boolean ms() {
        if (t.hi(this.xr)) {
            return false;
        }
        int i = this.c;
        this.c = i + 1;
        if (i < qf.xr()) {
            return false;
        }
        u.ms().ms(this.xr, "stats_reward_full_close_force", this.ka.am().ms(new JSONObject()));
        this.ka.finish();
        return true;
    }

    protected void ms(int i) {
        this.ka.v();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("topImpl", getClass().getName());
            jSONObject.put("topType", i);
        } catch (Throwable unused) {
        }
        u.ms().ms(this.xr, "stats_reward_full_top_handle", jSONObject);
    }
}
