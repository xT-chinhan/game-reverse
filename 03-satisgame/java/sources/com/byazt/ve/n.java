package com.byazt.ve;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.byazt.ih.s;
import com.byazt.jx.q;
import com.byazt.tk.t;
import com.byazt.uo.qg;
import com.byazt.vf.wo;
import com.byazt.vh.k;
import com.byazt.vh.sz;
import com.bykv.vk.component.ttvideo.player.MediaFormat;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1768, 19})
public class n implements wo.n {
    public int a;
    public s cp;
    public int cy;
    public int d;
    public s fs;
    public int h;
    public int hd;
    public boolean hu;
    public int k;
    public s l;
    public InterfaceC0369n ln;
    public boolean m;
    public int oa;
    public int ou;
    public int py;
    public s q;
    public k qg;
    public s rv;
    public s s;
    public int sz;
    public int t;
    public s tj;
    public boolean um;
    public boolean ur;
    public s w;
    public boolean wm;
    public s x;
    public final t n = new t(Looper.getMainLooper(), this);
    public int cd = Integer.MIN_VALUE;
    public int bb = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: com.byazt.ve.n$n, reason: collision with other inner class name */
    public interface InterfaceC0369n {
        boolean n();
    }

    public n(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("xCreative");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("xSetting");
            String strOptString = jSONObject.optString("dynamic_configs", "");
            if (jSONObjectOptJSONObject != null) {
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(MediaFormat.KEY_VIDEO);
                if (jSONObjectOptJSONObject3 != null) {
                    this.oa = jSONObjectOptJSONObject3.optInt("video_duration");
                }
                int iOptInt = jSONObjectOptJSONObject.optInt("reward_full_time_type", 0);
                int iOptInt2 = jSONObjectOptJSONObject.optInt("reward_full_play_time", 0);
                if (iOptInt == 1) {
                    this.sz = iOptInt2;
                    this.um = true;
                }
            }
            if (jSONObjectOptJSONObject2 != null) {
                if (jSONObjectOptJSONObject2.optInt("ad_slot_type", 0) == 8) {
                    this.d = jSONObjectOptJSONObject2.optInt("iv_skip_time", 0);
                } else {
                    this.d = jSONObjectOptJSONObject2.optInt("rv_skip_time", 0);
                }
            }
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            try {
                if (new JSONObject(strOptString).optBoolean("is_show_video_duration", false)) {
                    this.um = false;
                }
            } catch (JSONException unused) {
            }
        }
    }

    public void n(k kVar, s sVar) {
        this.qg = kVar;
        this.s = sVar;
        s sVarL = sVar.l("RVCountdown");
        this.q = sVarL;
        if (sVarL == null) {
            this.q = this.s.l("FVCountdown");
        }
        s sVarL2 = this.s.l("RVSkip");
        this.w = sVarL2;
        if (sVarL2 == null) {
            this.w = this.s.l("FVSkip");
        }
        this.l = this.s.l("CycleCountDownView");
        this.x = this.s.l("RewardClickCountdown");
        this.fs = this.s.l("CycleSkip");
        this.tj = this.s.l("CsjRefreshTip");
        this.rv = this.s.q("CsjRefreshTipContainer");
        this.cp = this.s.q("CsjRefreshTipCancel");
        q();
    }

    public void n(InterfaceC0369n interfaceC0369n) {
        this.ln = interfaceC0369n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        int i;
        int i2;
        int i3;
        s sVar;
        if (this.um) {
            i = this.sz;
            i2 = this.cy;
        } else {
            i = this.oa;
            i2 = this.k;
        }
        k kVar = this.qg;
        boolean z = true;
        if (kVar != null && (sVar = this.s) != null) {
            kVar.n(sVar, "videoProgress", Integer.valueOf(i2));
        }
        int i4 = this.hd + i2;
        int iMax = Math.max(0, i - i4);
        if (i4 < this.d && iMax != 0 && this.cd > 0) {
            z = false;
        }
        s sVar2 = this.q;
        if ((sVar2 instanceof com.byazt.jx.n) && this.cd != Integer.MIN_VALUE) {
            sVar2.qg(0);
            ((com.byazt.jx.n) this.q).n(iMax, i4, this.cd);
        }
        s sVar3 = this.w;
        if (sVar3 instanceof qg) {
            ((qg) sVar3).q(z);
        }
        s sVar4 = this.x;
        if ((sVar4 instanceof q) && (i3 = this.cd) != Integer.MIN_VALUE) {
            ((q) sVar4).n(iMax, i4, i3);
        }
        s sVar5 = this.l;
        if (sVar5 instanceof com.byazt.jx.qg) {
            ((com.byazt.jx.qg) sVar5).n(i, i4, iMax, z);
        }
        s sVar6 = this.fs;
        if (sVar6 instanceof com.byazt.uo.n) {
            ((com.byazt.uo.n) sVar6).qg(this.a, this.py);
        }
        s sVar7 = this.rv;
        if (sVar7 != null) {
            sVar7.qg(this.wm ? 0 : 8);
        }
        s sVar8 = this.cp;
        if (sVar8 != null) {
            sVar8.qg(this.hu ? 0 : 8);
        }
        s sVar9 = this.tj;
        if (sVar9 instanceof com.byazt.jx.s) {
            ((com.byazt.jx.s) sVar9).n(this.ou, this.h, this.t, this.m, this.ur);
        }
        if (i2 != this.bb) {
            this.bb = i2;
            n("builtin_video_duration", Integer.valueOf(i));
            n("builtin_play_time", Integer.valueOf(i2));
            l();
        }
    }

    public void n() {
        l();
    }

    private void l() {
        InterfaceC0369n interfaceC0369n = this.ln;
        n("builtin_reward_state", interfaceC0369n != null && interfaceC0369n.n() ? "send" : null);
    }

    @Override // com.byazt.vf.wo.n
    public void n(Message message) {
        if (message.what != 100) {
            return;
        }
        this.n.sendEmptyMessageDelayed(100, 200L);
        q();
    }

    public void qg() {
        if (w()) {
            q();
            this.n.sendEmptyMessageDelayed(100, 200L);
        }
    }

    public void s() {
        this.n.removeCallbacksAndMessages(null);
    }

    private boolean w() {
        k kVar = this.qg;
        return ((kVar == null || this.s == null || !kVar.q()) && this.q == null && this.w == null && this.l == null && this.fs == null && this.tj == null) ? false : true;
    }

    public void n(int i, int i2, int i3, int i4) {
        boolean z = this.cd == Integer.MIN_VALUE && i4 != Integer.MIN_VALUE;
        this.k = i;
        this.cy = i2;
        this.hd = i3;
        this.cd = i4;
        if (z) {
            x();
        }
    }

    private void x() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            q();
        } else {
            this.n.post(new Runnable() { // from class: com.byazt.ve.n.1
                @Override // java.lang.Runnable
                public void run() {
                    n.this.q();
                }
            });
        }
    }

    public void n(int i, int i2) {
        this.a = i;
        this.py = i2;
    }

    public void n(int i, boolean z, int i2, int i3, boolean z2, boolean z3, boolean z4) {
        this.ou = i;
        this.h = i2;
        this.t = i3;
        this.wm = z2;
        this.m = z3;
        this.hu = z4;
        this.ur = z;
    }

    public void n(final String str, final Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (obj == null) {
            obj = "";
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            qg(str, obj);
        } else {
            this.n.post(new Runnable() { // from class: com.byazt.ve.n.2
                @Override // java.lang.Runnable
                public void run() {
                    n.this.qg(str, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(String str, Object obj) {
        s sVar = this.s;
        sz szVarF = sVar == null ? null : sVar.f();
        if (szVarF == null) {
            return;
        }
        HashMap map = new HashMap(1);
        map.put(str, obj);
        szVarF.n(szVarF.n((Map<String, Object>) map));
    }
}
