package com.byazt.nx;

import android.util.SparseArray;
import com.byazt.ij.hn;
import com.byazt.xjg.ho;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTAdNative;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1122, 13})
public class hw implements Function<SparseArray<Object>, Object> {
    public final TTAdNative.CSJSplashAdListener pr;

    public hw(TTAdNative.CSJSplashAdListener cSJSplashAdListener) {
        this.pr = cSJSplashAdListener;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.pr == null) {
            return null;
        }
        ValueSet valueSetHw = hn.pr(sparseArray).hw();
        switch (valueSetHw.intValue(-99999987)) {
            case 114102:
                this.pr.onSplashLoadSuccess(new com.byazt.xjg.hw(ho.pr(valueSetHw.objectValue(0, Object.class))));
                return null;
            case 114103:
                this.pr.onSplashLoadFail(new com.byazt.xjg.pr(ho.pr(valueSetHw.objectValue(0, Object.class))));
                return null;
            case 114104:
                this.pr.onSplashRenderSuccess(new com.byazt.xjg.hw((Function) valueSetHw.objectValue(0, Function.class)));
                return null;
            case 114105:
                this.pr.onSplashRenderFail(new com.byazt.xjg.hw(ho.pr(valueSetHw.objectValue(0, Object.class))), new com.byazt.xjg.pr(ho.pr(valueSetHw.objectValue(1, Object.class))));
                return null;
            default:
                return null;
        }
    }
}
