package com.bytedance.adsdk.xr.xr.xr.ms;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ch implements com.bytedance.adsdk.xr.xr.xr.ms {
    private com.bytedance.adsdk.xr.xr.ms.ms ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private com.bytedance.adsdk.xr.xr.xr.ms[] f469ms;
    private String xr;

    public ch(String str) {
        this.xr = str;
    }

    public void ms(com.bytedance.adsdk.xr.xr.xr.ms[] msVarArr) {
        this.f469ms = msVarArr;
    }

    @Override // com.bytedance.adsdk.xr.xr.xr.ms
    public Object ms(Map<String, JSONObject> map) {
        com.bytedance.adsdk.xr.xr.ms.ms msVar = new com.bytedance.adsdk.xr.xr.ms.ms();
        this.ah = msVar;
        msVar.ms(this.xr);
        Object[] objArr = new Object[this.f469ms.length];
        int i = 0;
        while (true) {
            com.bytedance.adsdk.xr.xr.xr.ms[] msVarArr = this.f469ms;
            if (i < msVarArr.length) {
                com.bytedance.adsdk.xr.xr.xr.ms msVar2 = msVarArr[i];
                if (msVar2 != null) {
                    objArr[i] = msVar2.ms(map);
                }
                i++;
            } else {
                this.ah.ms(objArr);
                return com.bytedance.adsdk.xr.ny.ms(this.xr).ms(map.get("default_key"), objArr);
            }
        }
    }

    @Override // com.bytedance.adsdk.xr.xr.xr.ms
    public com.bytedance.adsdk.xr.xr.d.ka ms() {
        return com.bytedance.adsdk.xr.xr.d.xr.METHOD;
    }

    @Override // com.bytedance.adsdk.xr.xr.xr.ms
    public String xr() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.xr).append("(");
        com.bytedance.adsdk.xr.xr.xr.ms[] msVarArr = this.f469ms;
        if (msVarArr != null && msVarArr.length > 0) {
            int i = 0;
            while (true) {
                com.bytedance.adsdk.xr.xr.xr.ms[] msVarArr2 = this.f469ms;
                if (i >= msVarArr2.length) {
                    break;
                }
                sb.append(msVarArr2[i].xr()).append(",");
                i++;
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
