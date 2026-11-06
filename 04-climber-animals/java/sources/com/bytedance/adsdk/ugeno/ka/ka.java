package com.bytedance.adsdk.ugeno.ka;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ka implements ah {
    @Override // com.bytedance.adsdk.ugeno.ka.ah
    public List<xr> ms() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new xr("update") { // from class: com.bytedance.adsdk.ugeno.ka.ka.1
            @Override // com.bytedance.adsdk.ugeno.ka.xr
            public com.bytedance.adsdk.ugeno.ka.xr.ms ms(com.bytedance.adsdk.ugeno.xr.ah ahVar, String str, c.ms msVar) {
                return new com.bytedance.adsdk.ugeno.ka.xr.d(ahVar, str, msVar);
            }
        });
        arrayList.add(new xr("emit") { // from class: com.bytedance.adsdk.ugeno.ka.ka.2
            @Override // com.bytedance.adsdk.ugeno.ka.xr
            public com.bytedance.adsdk.ugeno.ka.xr.ms ms(com.bytedance.adsdk.ugeno.xr.ah ahVar, String str, c.ms msVar) {
                return new com.bytedance.adsdk.ugeno.ka.xr.xr(ahVar, str, msVar);
            }
        });
        return arrayList;
    }
}
