package com.bytedance.sdk.openadsdk.core.w;

import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ab implements EventListener {
    protected ValueSet ms(int i, Result result) {
        return null;
    }

    protected ValueSet ms(int i, d dVar) {
        return null;
    }

    protected ValueSet ms(int i, x xVar) {
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.EventListener
    public ValueSet onEvent(int i, Result result) {
        if (i == 1) {
            return ms(i);
        }
        if (i == 6) {
            return ms(i, new d(result, i));
        }
        if (i == 3) {
            return xr(i, result);
        }
        if (i == 4) {
            return xr(i);
        }
        switch (i) {
            case 8:
                return ms(i, new x(result, i));
            case 9:
                return ms(i, result);
            case 10:
                ms(result);
                return null;
            default:
                return null;
        }
    }

    private void ms(Result result) {
        if (result != null) {
            try {
                ValueSet valueSetValues = result.values();
                if (valueSetValues != null) {
                    String strStringValue = valueSetValues.stringValue(6);
                    JSONObject jSONObject = (JSONObject) valueSetValues.objectValue(7, JSONObject.class);
                    jSONObject.put(TTDownloadField.TT_LABEL, strStringValue);
                    com.bytedance.sdk.component.x.xr.d.ms.ms msVar = new com.bytedance.sdk.component.x.xr.d.ms.ms(UUID.randomUUID().toString(), jSONObject);
                    msVar.ms((byte) 0);
                    msVar.xr((byte) 2);
                    com.bytedance.sdk.component.x.xr.ms.ms(msVar, "csj");
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.sl.ms(e);
            }
        }
    }

    public ValueSet ms(int i) {
        return com.bykv.ms.ms.ms.ms.xr.ms().ms(31, t.ah()).xr();
    }

    public ValueSet xr(int i) {
        return com.bykv.ms.ms.ms.ms.xr.ms().ms(32, String.valueOf(f.ka())).xr();
    }

    public ValueSet xr(int i, Result result) {
        JSONObject jSONObjectSk = re.xr().sk();
        if (jSONObjectSk != null) {
            return com.bykv.ms.ms.ms.ms.xr.ms().ms(33, jSONObjectSk).xr();
        }
        return null;
    }
}
