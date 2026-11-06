package com.byazt.ri;

import android.app.Activity;
import android.content.Context;
import com.byazt.hg.of;
import com.byazt.sd.n;
import com.byazt.wt.ls;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 697, 20})
public abstract class hn implements com.byazt.nv.hn {
    public boolean a = true;
    public WeakReference<com.byazt.mm.pr.InterfaceC0136pr> cz;

    @Override // com.byazt.nv.hn
    public void pr(boolean z) {
        this.a = z;
    }

    @Override // com.byazt.nv.hn
    public void pr(com.byazt.mm.pr.InterfaceC0136pr interfaceC0136pr) {
        this.cz = new WeakReference<>(interfaceC0136pr);
    }

    public boolean pr(Context context, of ofVar, String str) {
        if (this.a && com.byazt.wt.c.pr(ofVar) && n.pr(context, ofVar, ls.x(str), str, fw())) {
            TTNativePageActivity.pr(this);
            return true;
        }
        return false;
    }

    private String fw() {
        com.byazt.mm.pr.InterfaceC0136pr interfaceC0136pr;
        com.byazt.mm.pr prVarQ_;
        WeakReference<com.byazt.mm.pr.InterfaceC0136pr> weakReference = this.cz;
        if (weakReference == null || (interfaceC0136pr = weakReference.get()) == null || (prVarQ_ = interfaceC0136pr.q_()) == null) {
            return null;
        }
        return prVarQ_.pr().toString();
    }

    public int g() {
        return hashCode();
    }

    @Override // com.byazt.nv.hn
    public void pr(Activity activity, boolean z) {
    }
}
