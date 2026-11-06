package com.byazt.ef;

import com.byazt.ch.lb;
import com.byazt.ch.nt;
import com.byazt.dd.fw;
import com.byazt.ik.hn;
import com.qq.e.comm.managers.setting.GlobalSetting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2324, 13})
public abstract class hw implements lb {
    public String hw;
    public lb pr;
    public JSONObject x;
    public boolean hn = true;
    public boolean c = false;

    public abstract void hn(nt ntVar, lb.hw hwVar, lb.pr prVar);

    public hw(lb lbVar) {
        this.pr = lbVar;
    }

    public void pr(JSONObject jSONObject) {
        this.x = jSONObject;
    }

    public void pr(String str) {
        this.hw = str;
    }

    public void pr(boolean z) {
        this.hn = z;
    }

    public boolean pr() {
        String str;
        return this.hn && (str = this.hw) != null && GlobalSetting.SPLASH_AD.compareTo(str) <= 0 && this.x != null;
    }

    public void hw(boolean z) {
        this.c = z;
    }

    @Override // com.byazt.ch.lb
    public void pr(nt ntVar, lb.hw hwVar, lb.pr prVar) {
        if (pr()) {
            hn(ntVar, hwVar, prVar);
        } else {
            hw(ntVar, hwVar, prVar);
        }
    }

    @Override // com.byazt.ch.lb
    public void pr(hn hnVar, String str, fw.pr prVar) {
        lb lbVar = this.pr;
        if (lbVar == null) {
            return;
        }
        lbVar.pr(hnVar, str, prVar);
    }

    public void hw(nt ntVar, lb.hw hwVar, lb.pr prVar) {
        lb lbVar = this.pr;
        if (lbVar == null) {
            return;
        }
        lbVar.pr(ntVar, hwVar, prVar);
    }
}
