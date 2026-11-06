package com.byazt.gj;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1253, 26})
public class qg implements Function<SparseArray<Object>, Object> {
    public final TTNativeAd.EasyPlayWidgetListener n;

    public qg(TTNativeAd.EasyPlayWidgetListener easyPlayWidgetListener) {
        this.n = easyPlayWidgetListener;
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
            case 144101:
                this.n.onInfo((JSONObject) valueSetQg.objectValue(0, JSONObject.class));
                return null;
            case 144102:
                return this.n.getEstimatedInteractionArea();
            case 144103:
                this.n.onCanRenderSuccess((JSONObject) valueSetQg.objectValue(0, JSONObject.class));
                return null;
            case 144104:
                this.n.onCanRenderFail((JSONObject) valueSetQg.objectValue(0, JSONObject.class));
                return null;
            case 144105:
                this.n.onClose();
                return null;
            default:
                return null;
        }
    }
}
