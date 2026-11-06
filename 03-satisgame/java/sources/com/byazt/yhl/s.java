package com.byazt.yhl;

import android.util.SparseArray;
import com.byazt.mo.tj;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 466, 8})
public class s implements Function<SparseArray<Object>, Object> {
    public final TTAdNative.FullScreenVideoAdListener n;

    public s(TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        this.n = fullScreenVideoAdListener;
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
            case 132101:
                this.n.onError(valueSetQg.intValue(0), valueSetQg.stringValue(1));
                return null;
            case 132102:
                this.n.onFullScreenVideoAdLoad(new tj((Function) valueSetQg.objectValue(0, Function.class)));
                return null;
            case 132103:
                this.n.onFullScreenVideoCached(new tj((Function) valueSetQg.objectValue(0, Function.class)));
                return null;
            case 132104:
                this.n.onFullScreenVideoCached();
                return null;
            default:
                return null;
        }
    }
}
