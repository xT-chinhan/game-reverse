package com.byazt.lbp;

import android.app.Dialog;
import android.content.Context;
import com.byazt.gct.pk;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.phr.qg
@com.byazt.cp.n(n = {0, 1, 579, 13})
public class w implements com.byazt.jjq.s {

    @com.byazt.phr.n(n = "outer_dislike", qg = "ALL")
    public Dialog n;

    @com.byazt.phr.n(n = "material_meta", qg = "ALL")
    public pk q;

    @com.byazt.phr.n(n = "ad_dislike", qg = "ALL")
    public com.byazt.wg.qg qg;

    @com.byazt.phr.n(n = "context", qg = "ALL")
    public Context s;

    @Override // com.byazt.jjq.s
    public boolean n(Map<String, Object> map, Map<String, Object> map2, com.byazt.dm.n nVar) {
        Dialog dialog = this.n;
        if (dialog != null) {
            dialog.show();
            nVar.n(map2);
            return true;
        }
        com.byazt.wg.qg qgVar = this.qg;
        if (qgVar != null) {
            qgVar.n();
            nVar.n(map2);
            return true;
        }
        TTDelegateActivity.n(this.s, this.q);
        nVar.n(map2);
        return true;
    }
}
