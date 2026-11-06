package com.byazt.lbp;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.phr.qg
@com.byazt.cp.n(n = {0, 1, 579, 19})
public class n implements com.byazt.jjq.s {

    @com.byazt.phr.n(n = ImagesContract.URL, qg = "ALL")
    public String n;

    @com.byazt.phr.n(n = "title", qg = "ALL")
    public String qg;

    @com.byazt.phr.n(n = "context", qg = "ALL")
    public Context s;

    @Override // com.byazt.jjq.s
    public boolean n(Map<String, Object> map, Map<String, Object> map2, com.byazt.dm.n nVar) {
        TTDelegateActivity.q(this.s, this.n, this.qg);
        nVar.n(map2);
        return true;
    }
}
