package com.byazt.bk;

import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.byazt.ca.iu;
import com.byazt.ch.ho;
import com.byazt.ik.hn;
import com.byazt.jd.x;
import com.byazt.vkw.qi;
import com.byazt.yw.hw;
import com.tapsdk.tapad.group.constants.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1279, 37})
public class pr implements qi.pr {
    public int a;
    public hn aj;
    public int b;
    public hn c;
    public int cz;
    public boolean fo;
    public hn fw;
    public int g;
    public hn hn;
    public int ho;
    public ho hw;
    public int iu;
    public int k;
    public int m;
    public int nt;
    public int ny;
    public boolean qa;
    public boolean rc;
    public hn uc;
    public boolean ve;
    public hn vk;
    public hn w;
    public hn x;
    public int yb;
    public boolean z;
    public hn zo;
    public final iu pr = new iu(Looper.getMainLooper(), this);
    public int lb = Integer.MIN_VALUE;

    public pr(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("xCreative");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("xSetting");
            String strOptString = jSONObject.optString("dynamic_configs", "");
            if (jSONObjectOptJSONObject != null) {
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("video");
                if (jSONObjectOptJSONObject3 != null) {
                    this.m = jSONObjectOptJSONObject3.optInt(Constants.VIDEO_DURATION_FIELD);
                }
                int iOptInt = jSONObjectOptJSONObject.optInt("reward_full_time_type", 0);
                int iOptInt2 = jSONObjectOptJSONObject.optInt("reward_full_play_time", 0);
                if (iOptInt == 1) {
                    this.g = iOptInt2;
                    this.qa = true;
                }
            }
            if (jSONObjectOptJSONObject2 != null) {
                if (jSONObjectOptJSONObject2.optInt("ad_slot_type", 0) == 8) {
                    this.k = jSONObjectOptJSONObject2.optInt("iv_skip_time", 0);
                } else {
                    this.k = jSONObjectOptJSONObject2.optInt("rv_skip_time", 0);
                }
            }
            if (!TextUtils.isEmpty(strOptString)) {
                try {
                    if (new JSONObject(strOptString).optBoolean("is_show_video_duration", false)) {
                        this.qa = false;
                    }
                } catch (JSONException e) {
                }
            }
        }
    }

    public void pr(ho hoVar, hn hnVar) {
        this.hw = hoVar;
        this.hn = hnVar;
        hn hnVarC = hnVar.c("RVCountdown");
        this.x = hnVarC;
        if (hnVarC == null) {
            this.x = this.hn.c("FVCountdown");
        }
        hn hnVarC2 = this.hn.c("RVSkip");
        this.uc = hnVarC2;
        if (hnVarC2 == null) {
            this.uc = this.hn.c("FVSkip");
        }
        this.c = this.hn.c("CycleCountDownView");
        this.fw = this.hn.c("RewardClickCountdown");
        this.zo = this.hn.c("CycleSkip");
        this.vk = this.hn.c("CsjRefreshTip");
        this.aj = this.hn.x("CsjRefreshTipContainer");
        this.w = this.hn.x("CsjRefreshTipCancel");
    }

    private void hn() {
        int i;
        int i2;
        int i3;
        hn hnVar;
        if (this.qa) {
            i = this.g;
            i2 = this.nt;
        } else {
            i = this.m;
            i2 = this.ho;
        }
        ho hoVar = this.hw;
        boolean z = true;
        if (hoVar != null && (hnVar = this.hn) != null) {
            hoVar.pr(hnVar, "videoProgress", Integer.valueOf(i2));
        }
        int i4 = i2 + this.yb;
        int iMax = Math.max(0, i - i4);
        if (i4 < this.k && iMax != 0 && this.lb > 0) {
            z = false;
        }
        hn hnVar2 = this.x;
        if ((hnVar2 instanceof com.byazt.jd.pr) && this.lb != Integer.MIN_VALUE) {
            hnVar2.hw(0);
            ((com.byazt.jd.pr) this.x).pr(iMax, i4, this.lb);
        }
        hn hnVar3 = this.uc;
        if (hnVar3 instanceof hw) {
            ((hw) hnVar3).x(z);
        }
        hn hnVar4 = this.fw;
        if ((hnVar4 instanceof x) && (i3 = this.lb) != Integer.MIN_VALUE) {
            ((x) hnVar4).pr(iMax, i4, i3);
        }
        hn hnVar5 = this.c;
        if (hnVar5 instanceof com.byazt.jd.hw) {
            ((com.byazt.jd.hw) hnVar5).pr(i, i4, iMax, z);
        }
        hn hnVar6 = this.zo;
        if (hnVar6 instanceof com.byazt.yw.pr) {
            ((com.byazt.yw.pr) hnVar6).hw(this.a, this.cz);
        }
        hn hnVar7 = this.aj;
        if (hnVar7 != null) {
            hnVar7.hw(this.fo ? 0 : 8);
        }
        hn hnVar8 = this.w;
        if (hnVar8 != null) {
            hnVar8.hw(this.z ? 0 : 8);
        }
        hn hnVar9 = this.vk;
        if (hnVar9 instanceof com.byazt.jd.hn) {
            ((com.byazt.jd.hn) hnVar9).pr(this.ny, this.b, this.iu, this.rc, this.ve);
        }
    }

    @Override // com.byazt.vkw.qi.pr
    public void pr(Message message) {
        switch (message.what) {
            case 100:
                this.pr.sendEmptyMessageDelayed(100, 200L);
                hn();
                break;
        }
    }

    public void pr() {
        if (x()) {
            this.pr.sendEmptyMessage(100);
        }
    }

    public void hw() {
        this.pr.removeCallbacksAndMessages(null);
    }

    private boolean x() {
        ho hoVar = this.hw;
        return ((hoVar == null || this.hn == null || !hoVar.x()) && this.x == null && this.uc == null && this.c == null && this.zo == null && this.vk == null) ? false : true;
    }

    public void pr(int i, int i2, int i3, int i4) {
        this.ho = i;
        this.nt = i2;
        this.yb = i3;
        this.lb = i4;
    }

    public void pr(int i, int i2) {
        this.a = i;
        this.cz = i2;
    }

    public void pr(int i, boolean z, int i2, int i3, boolean z2, boolean z3, boolean z4) {
        this.ny = i;
        this.b = i2;
        this.iu = i3;
        this.fo = z2;
        this.rc = z3;
        this.z = z4;
        this.ve = z;
    }
}
