package com.byazt.thx;

import android.util.SparseArray;
import com.byazt.mo.k;
import com.byazt.qvu.s;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1380, 26})
public class qg implements Function<SparseArray<Object>, Object> {
    public final TTAdNative.CSJSplashAdListener n;

    public qg(TTAdNative.CSJSplashAdListener cSJSplashAdListener) {
        this.n = cSJSplashAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.n == null) {
            return null;
        }
        ValueSet valueSetQg = s.n(sparseArray).qg();
        switch (valueSetQg.intValue(-99999987)) {
            case 114102:
                this.n.onSplashLoadSuccess(new com.byazt.mo.qg(k.n(valueSetQg.objectValue(0, Object.class))));
                return null;
            case 114103:
                this.n.onSplashLoadFail(new com.byazt.mo.n(k.n(valueSetQg.objectValue(0, Object.class))));
                return null;
            case 114104:
                this.n.onSplashRenderSuccess(new com.byazt.mo.qg((Function) valueSetQg.objectValue(0, Function.class)));
                return null;
            case 114105:
                this.n.onSplashRenderFail(new com.byazt.mo.qg(k.n(valueSetQg.objectValue(0, Object.class))), new com.byazt.mo.n(k.n(valueSetQg.objectValue(1, Object.class))));
                return null;
            default:
                return null;
        }
    }
}
