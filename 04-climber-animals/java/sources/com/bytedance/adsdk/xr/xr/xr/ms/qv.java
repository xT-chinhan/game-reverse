package com.bytedance.adsdk.xr.xr.xr.ms;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class qv extends h {
    private static final ThreadLocal<StringBuilder> d = new ThreadLocal<StringBuilder>() { // from class: com.bytedance.adsdk.xr.xr.xr.ms.qv.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public StringBuilder initialValue() {
            return new StringBuilder();
        }
    };

    public qv() {
        super(com.bytedance.adsdk.xr.xr.d.ah.PLUS);
    }

    @Override // com.bytedance.adsdk.xr.xr.xr.ms
    public Object ms(Map<String, JSONObject> map) {
        Object objMs;
        Object objMs2 = this.f470ms.ms(map);
        if (objMs2 == null || (objMs = this.xr.ms(map)) == null) {
            return null;
        }
        if ((objMs2 instanceof String) || (objMs instanceof String)) {
            StringBuilder sb = d.get();
            sb.append(objMs2).append(objMs);
            String string = sb.toString();
            sb.setLength(0);
            return string;
        }
        return com.bytedance.adsdk.xr.xr.ka.ms.x.ms((Number) objMs2, (Number) objMs);
    }
}
