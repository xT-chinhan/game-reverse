package com.byazt.tby;

import android.text.TextUtils;
import com.byazt.dd.fw;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 225, 5})
public class uc extends pr {
    public uc(com.byazt.ik.hn hnVar, String str, fw.pr prVar) {
        super(hnVar, str, prVar);
    }

    @Override // com.byazt.tby.pr
    public void pr() {
        if (this.uc == null || this.uc.size() <= 0) {
            return;
        }
        Object obj = this.uc.get("id");
        if (obj == null) {
            pr(this.hn);
            return;
        }
        String strValueOf = String.valueOf(obj);
        if (TextUtils.isEmpty(strValueOf)) {
            pr(this.hn);
            return;
        }
        com.byazt.ik.hn hnVarHw = this.hn.hw(this.hn);
        if (hnVarHw == null) {
            return;
        }
        pr(hnVarHw.x(strValueOf));
    }

    private void pr(com.byazt.ik.hn hnVar) {
        Object obj;
        if (hnVar == null) {
            return;
        }
        for (String str : this.uc.keySet()) {
            if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "id") && (obj = this.uc.get(str)) != null) {
                hnVar.pr(str, String.valueOf(obj));
            }
        }
        hnVar.pr(this.uc.containsKey("width"), this.uc.containsKey("height"));
        hnVar.hw();
    }
}
