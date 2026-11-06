package com.byazt.xv;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.dd.nt;
import com.taptap.sdk.db.constant.Common;
import com.taptap.sdk.kit.internal.p001const.TrackAction;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 793, 37})
public class pr extends hw implements com.byazt.iza.hw {
    public String w;

    public pr(Context context) {
        super(context);
    }

    @Override // com.byazt.xv.hw
    public boolean pr(Object... objArr) {
        Object obj;
        com.byazt.ik.hn hnVarUc;
        com.byazt.iza.pr prVarVk;
        if (this.c == null || this.c.size() <= 0 || (obj = this.c.get(Common.System.NAME)) == null) {
            return false;
        }
        String strValueOf = String.valueOf(obj);
        if (TextUtils.isEmpty(strValueOf)) {
            return false;
        }
        Object obj2 = this.c.get("state");
        if (obj2 != null) {
            this.w = String.valueOf(obj2);
        }
        com.byazt.ik.hn hnVarHw = this.hw.hw(this.hw);
        if (hnVarHw != null && (hnVarUc = hnVarHw.uc(strValueOf)) != null && (prVarVk = hnVarUc.vk(strValueOf)) != null) {
            prVarVk.pr(this);
        }
        return false;
    }

    @Override // com.byazt.iza.hw
    public void pr() {
        if (hn()) {
            return;
        }
        if ((TextUtils.equals(this.w, TrackAction.START) || TextUtils.isEmpty(this.w)) && this.pr != null) {
            this.pr.pr(this.hw, this.uc, this.hn.hw(), this.hn);
        }
    }

    @Override // com.byazt.iza.hw
    public void hw() {
        if (hn()) {
            return;
        }
        if ((TextUtils.equals(this.w, "complete") || TextUtils.isEmpty(this.w)) && this.pr != null) {
            this.pr.pr(this.hw, this.uc, this.hn.hw(), this.hn);
        }
    }

    private boolean hn() {
        nt ntVarHn;
        return (this.hw == null || this.hw.ls() == null || (ntVarHn = this.hw.ls().hn()) == null || !ntVarHn.pr("animateState", "")) ? false : true;
    }
}
