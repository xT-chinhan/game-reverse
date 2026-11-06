package com.byazt.yhl;

import android.util.SparseArray;
import com.byazt.mo.d;
import com.byazt.mo.k;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 466, 5})
public class q implements Function<SparseArray<Object>, Object> {
    public final TTAdNative.NativeAdListener n;

    public q(TTAdNative.NativeAdListener nativeAdListener) {
        this.n = nativeAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.n == null) {
            return null;
        }
        ValueSet valueSetQg = com.byazt.qvu.s.n(sparseArray).qg();
        switch (valueSetQg.intValue(-99999987)) {
            case 143101:
                this.n.onError(valueSetQg.intValue(0), valueSetQg.stringValue(1));
                return null;
            case 143102:
                List arrayList = (List) valueSetQg.objectValue(0, List.class);
                if (arrayList == null) {
                    arrayList = new ArrayList(0);
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new d(k.n(it.next())));
                }
                this.n.onNativeAdLoad(arrayList2);
                return null;
            default:
                return null;
        }
    }
}
