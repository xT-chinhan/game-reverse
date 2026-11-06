package com.bytedance.sdk.component.adexpress.dynamic.animation.ms;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ka {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    List<d> f779ms = new ArrayList();

    public xr(View view, List<com.bytedance.sdk.component.adexpress.dynamic.ah.ms> list) {
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.ah.ms> it = list.iterator();
        while (it.hasNext()) {
            d dVarMs = ah.ms().ms(view, it.next());
            if (dVarMs != null) {
                this.f779ms.add(dVarMs);
            }
        }
    }

    public void ms() {
        Iterator<d> it = this.f779ms.iterator();
        while (it.hasNext()) {
            try {
                it.next().ah();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.ka
    public void xr() {
        Iterator<d> it = this.f779ms.iterator();
        while (it.hasNext()) {
            try {
                it.next().xr();
            } catch (Exception unused) {
            }
        }
    }
}
