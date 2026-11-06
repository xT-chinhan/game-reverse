package com.mcto.sspsdk.internal;

import android.content.Context;
import com.mcto.sspsdk.IQYNative;
import com.mcto.sspsdk.QyAdSlot;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class m2 extends e3 {
    public m2(Context context, QyAdSlot qyAdSlot, IQYNative.QYNativeAdListener qYNativeAdListener) {
        super(context, qyAdSlot, qYNativeAdListener);
    }

    @Override // com.mcto.sspsdk.internal.f7
    public final void a(vh vhVar) {
        ArrayList arrayList = vhVar.b;
        if (arrayList == null) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(new p2(this.b, this.a, (p) it.next()));
        }
        if (this.c != null) {
            this.d.post(new c3(this, arrayList2));
        }
    }
}
