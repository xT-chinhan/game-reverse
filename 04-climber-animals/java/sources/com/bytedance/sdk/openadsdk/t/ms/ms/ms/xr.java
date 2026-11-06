package com.bytedance.sdk.openadsdk.t.ms.ms.ms;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.ao.ms.ms.ao;
import com.bytedance.sdk.openadsdk.ao.ms.ms.ny;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final TTAdNative.FeedAdListener f4113ms;

    public xr(TTAdNative.FeedAdListener feedAdListener) {
        this.f4113ms = feedAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.f4113ms == null) {
            return null;
        }
        ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr();
        switch (valueSetXr.intValue(-99999987)) {
            case 164101:
                this.f4113ms.onError(valueSetXr.intValue(0), valueSetXr.stringValue(1));
                return null;
            case 164102:
                List arrayList = (List) valueSetXr.objectValue(0, List.class);
                if (arrayList == null) {
                    arrayList = new ArrayList(0);
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new ny(ao.ms(it.next())));
                }
                this.f4113ms.onFeedAdLoad(arrayList2);
                return null;
            default:
                return null;
        }
    }
}
