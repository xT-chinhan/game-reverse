package com.byazt.qvl;

import android.util.SparseArray;
import com.byazt.xjg.vk;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1416, 20})
public class hn implements Function<SparseArray<Object>, Object> {
    public final TTAdNative.FullScreenVideoAdListener pr;

    public hn(TTAdNative.FullScreenVideoAdListener fullScreenVideoAdListener) {
        this.pr = fullScreenVideoAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.pr == null) {
            return null;
        }
        ValueSet valueSetHw = com.byazt.ij.hn.pr(sparseArray).hw();
        switch (valueSetHw.intValue(-99999987)) {
            case 132101:
                this.pr.onError(valueSetHw.intValue(0), valueSetHw.stringValue(1));
                return null;
            case 132102:
                this.pr.onFullScreenVideoAdLoad(new vk((Function) valueSetHw.objectValue(0, Function.class)));
                return null;
            case 132103:
                this.pr.onFullScreenVideoCached(new vk((Function) valueSetHw.objectValue(0, Function.class)));
                return null;
            case 132104:
                this.pr.onFullScreenVideoCached();
                return null;
            default:
                return null;
        }
    }
}
