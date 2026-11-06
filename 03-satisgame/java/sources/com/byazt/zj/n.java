package com.byazt.zj;

import android.app.Activity;
import com.byazt.jp.x;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, TTAdConstant.IMAGE_LIST_SIZE_CODE, 19})
public class n extends com.byazt.suf.s {
    public com.byazt.jp.qg n;

    public n(Activity activity, Map<String, Object> map, com.byazt.gl.s sVar) {
        if (sVar == null || activity == null) {
            return;
        }
        if (map != null) {
            this.n = sVar.n(activity, map);
        } else {
            this.n = sVar.n(activity);
        }
    }

    public n(com.byazt.jp.qg qgVar) {
        this.n = qgVar;
    }

    @Override // com.byazt.suf.s
    public void n() {
        com.byazt.jp.qg qgVar = this.n;
        if (qgVar != null) {
            qgVar.n();
        }
    }

    @Override // com.byazt.suf.s
    public void n(final com.byazt.he.n nVar) {
        com.byazt.jp.qg qgVar = this.n;
        if (qgVar != null) {
            qgVar.n(new x() { // from class: com.byazt.zj.n.1
                @Override // com.byazt.jp.x
                public void n(int i, String str) {
                    com.byazt.he.n nVar2 = nVar;
                    if (nVar2 != null) {
                        nVar2.n(i, str);
                    }
                }

                @Override // com.byazt.jp.x
                public void n() {
                    com.byazt.he.n nVar2 = nVar;
                    if (nVar2 != null) {
                        nVar2.n();
                    }
                }

                @Override // com.byazt.jp.x
                public void qg() {
                    com.byazt.he.n nVar2 = nVar;
                    if (nVar2 != null) {
                        nVar2.qg();
                    }
                }
            });
        }
    }
}
