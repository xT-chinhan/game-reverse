package com.bytedance.sdk.openadsdk.core.ugeno.ch;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.ah.sl;
import com.bytedance.adsdk.ugeno.xr.ah;
import com.bytedance.sdk.component.utils.le;
import com.bytedance.sdk.openadsdk.core.ugeno.component.skip.xr;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements le.ms {
    private ah ab;
    private ah ah;
    private boolean ao;
    private ah c;
    private int ch;
    private ah d;
    private int h;
    private int hi;
    private ah ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected final le f3424ms = new le(Looper.getMainLooper(), this);
    private int ny;
    private int qv;
    private int sl;
    private int u;
    private int ub;
    private ah x;
    private sl xr;
    private int zb;

    public ms(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("xCreative");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("xSetting");
            String strOptString = jSONObject.optString("dynamic_configs", "");
            if (jSONObjectOptJSONObject != null) {
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("video");
                if (jSONObjectOptJSONObject3 != null) {
                    this.ch = jSONObjectOptJSONObject3.optInt("video_duration");
                }
                int iOptInt = jSONObjectOptJSONObject.optInt("reward_full_time_type", 0);
                int iOptInt2 = jSONObjectOptJSONObject.optInt("reward_full_play_time", 0);
                if (iOptInt == 1) {
                    this.hi = iOptInt2;
                    this.ao = true;
                }
            }
            if (jSONObjectOptJSONObject2 != null) {
                if (jSONObjectOptJSONObject2.optInt("ad_slot_type", 0) == 8) {
                    this.ny = jSONObjectOptJSONObject2.optInt("iv_skip_time", 0);
                } else {
                    this.ny = jSONObjectOptJSONObject2.optInt("rv_skip_time", 0);
                }
            }
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            try {
                if (new JSONObject(strOptString).optBoolean("is_show_video_duration", false)) {
                    this.ao = false;
                }
            } catch (JSONException unused) {
            }
        }
    }

    public void ms(sl slVar, ah ahVar) {
        this.xr = slVar;
        this.ah = ahVar;
    }

    public void ms(ah ahVar, ah ahVar2, ah ahVar3, ah ahVar4, ah ahVar5) {
        this.d = ahVar;
        this.ka = ahVar2;
        this.ab = ahVar3;
        this.x = ahVar4;
        this.c = ahVar5;
    }

    private void ah() {
        int i;
        int i2;
        ah ahVar;
        if (this.ao) {
            i = this.hi;
            i2 = this.zb;
        } else {
            i = this.ch;
            i2 = this.sl;
        }
        sl slVar = this.xr;
        boolean z = true;
        if (slVar != null && (ahVar = this.ah) != null) {
            slVar.ms(ahVar, "videoProgress", Integer.valueOf(i2));
        }
        int i3 = i2 + this.u;
        int iMax = Math.max(0, i - i3);
        if (i3 < this.ny && iMax != 0) {
            z = false;
        }
        ah ahVar2 = this.d;
        if (ahVar2 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.ms) {
            ahVar2.xr(0);
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.ms) this.d).ms(iMax, i3, this.ub);
        }
        ah ahVar3 = this.ka;
        if (ahVar3 instanceof xr) {
            ((xr) ahVar3).d(z);
        }
        ah ahVar4 = this.ab;
        if (ahVar4 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.xr) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.xr) ahVar4).ms(i, i3, iMax, z);
        }
        ah ahVar5 = this.x;
        if (ahVar5 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.ah) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.ah) ahVar5).ms(iMax, i3, this.ub);
        }
        ah ahVar6 = this.ab;
        if (ahVar6 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.xr) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.xr) ahVar6).ms(i, i3, iMax, z);
        }
        ah ahVar7 = this.c;
        if (ahVar7 instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.skip.ms) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.skip.ms) ahVar7).xr(this.h, this.qv);
        }
    }

    @Override // com.bytedance.sdk.component.utils.le.ms
    public void ms(Message message) {
        if (message.what != 100) {
            return;
        }
        this.f3424ms.sendEmptyMessageDelayed(100, 200L);
        ah();
    }

    public void ms() {
        if (d()) {
            this.f3424ms.sendEmptyMessage(100);
        }
    }

    public void xr() {
        this.f3424ms.removeCallbacksAndMessages(null);
    }

    private boolean d() {
        return (this.d == null && this.ka == null && this.ab == null && this.c == null) ? false : true;
    }

    public void ms(int i, int i2, int i3, int i4) {
        this.sl = i;
        this.zb = i2;
        this.u = i3;
        this.ub = i4;
    }

    public void ms(int i, int i2) {
        this.h = i;
        this.qv = i2;
    }
}
