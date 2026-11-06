package com.byazt.ael;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2250, 13})
public class hw implements Function<SparseArray<Object>, Object> {
    public final TTNativeAd.EasyPlayWidgetListener pr;

    public hw(TTNativeAd.EasyPlayWidgetListener easyPlayWidgetListener) {
        this.pr = easyPlayWidgetListener;
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
            case 144101:
                this.pr.onInfo((JSONObject) valueSetHw.objectValue(0, JSONObject.class));
                return null;
            case 144102:
                return this.pr.getEstimatedInteractionArea();
            case 144103:
                this.pr.onCanRenderSuccess((JSONObject) valueSetHw.objectValue(0, JSONObject.class));
                return null;
            case 144104:
                this.pr.onCanRenderFail((JSONObject) valueSetHw.objectValue(0, JSONObject.class));
                return null;
            case 144105:
                this.pr.onClose();
                return null;
            default:
                return null;
        }
    }
}
