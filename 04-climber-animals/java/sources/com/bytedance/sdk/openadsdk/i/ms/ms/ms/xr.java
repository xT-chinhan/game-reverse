package com.bytedance.sdk.openadsdk.i.ms.ms.ms;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements Bridge, Function<SparseArray<Object>, Object> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ValueSet f3920ms = com.bykv.ms.ms.ms.ms.xr.f12ms;
    private final TTNativeAd.EasyPlayWidgetListener xr;

    public xr(TTNativeAd.EasyPlayWidgetListener easyPlayWidgetListener) {
        this.xr = easyPlayWidgetListener;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return this.f3920ms;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        if (this.xr == null) {
            return null;
        }
        SparseArray<Object> sparseArray = valueSet != null ? valueSet.sparseArray() : new SparseArray<>();
        sparseArray.put(-99999987, Integer.valueOf(i));
        sparseArray.put(-99999985, cls);
        T t = (T) apply(sparseArray);
        if (t != null) {
            return t;
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.xr == null) {
            return null;
        }
        ValueSet valueSetXr = com.bykv.ms.ms.ms.ms.xr.ms(sparseArray).xr();
        switch (valueSetXr.intValue(-99999987)) {
            case 144101:
                this.xr.onInfo((JSONObject) valueSetXr.objectValue(0, JSONObject.class));
                return null;
            case 144102:
                return this.xr.getEstimatedInteractionArea();
            case 144103:
                this.xr.onCanRenderSuccess((JSONObject) valueSetXr.objectValue(0, JSONObject.class));
                return null;
            case 144104:
                this.xr.onCanRenderFail((JSONObject) valueSetXr.objectValue(0, JSONObject.class));
                return null;
            case 144105:
                this.xr.onClose();
                return null;
            default:
                return null;
        }
    }
}
