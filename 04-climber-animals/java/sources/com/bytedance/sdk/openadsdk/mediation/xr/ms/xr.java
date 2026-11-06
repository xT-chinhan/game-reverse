package com.bytedance.sdk.openadsdk.mediation.xr.ms;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.ao.ms.ms.ao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends com.bytedance.sdk.openadsdk.t.ms.ms.ms.ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final TTAdNative.DrawFeedAdListener f4051ms;

    public xr(TTAdNative.DrawFeedAdListener drawFeedAdListener) {
        super(drawFeedAdListener);
        this.f4051ms = drawFeedAdListener;
    }

    @Override // com.bytedance.sdk.openadsdk.t.ms.ms.ms.ms, java.util.function.Function
    /* JADX INFO: renamed from: ms */
    public Object apply(SparseArray<Object> sparseArray) {
        if (((Integer) sparseArray.get(-99999987)).intValue() == 172102) {
            List arrayList = (List) sparseArray.get(0);
            if (arrayList == null) {
                arrayList = new ArrayList(0);
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(new hi(ao.ms(it.next())));
            }
            TTAdNative.DrawFeedAdListener drawFeedAdListener = this.f4051ms;
            if (drawFeedAdListener == null) {
                return null;
            }
            drawFeedAdListener.onDrawFeedAdLoad(arrayList2);
            return null;
        }
        return super.apply(sparseArray);
    }
}
