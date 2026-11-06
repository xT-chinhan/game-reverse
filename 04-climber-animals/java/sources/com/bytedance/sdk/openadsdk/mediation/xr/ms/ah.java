package com.bytedance.sdk.openadsdk.mediation.xr.ms;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.ao.ms.ms.ao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends com.bytedance.sdk.openadsdk.t.ms.ms.ms.xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final TTAdNative.FeedAdListener f4039ms;

    public ah(TTAdNative.FeedAdListener feedAdListener) {
        super(feedAdListener);
        this.f4039ms = feedAdListener;
    }

    @Override // com.bytedance.sdk.openadsdk.t.ms.ms.ms.xr, java.util.function.Function
    /* JADX INFO: renamed from: ms */
    public Object apply(SparseArray<Object> sparseArray) {
        if (((Integer) sparseArray.get(-99999987)).intValue() == 164102) {
            List arrayList = (List) sparseArray.get(0);
            if (arrayList == null) {
                arrayList = new ArrayList(0);
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(new sl(ao.ms(it.next())));
            }
            TTAdNative.FeedAdListener feedAdListener = this.f4039ms;
            if (feedAdListener == null) {
                return null;
            }
            feedAdListener.onFeedAdLoad(arrayList2);
            return null;
        }
        return super.apply(sparseArray);
    }
}
