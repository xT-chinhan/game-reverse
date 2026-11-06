package com.bytedance.adsdk.ugeno.ka;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements x {
    @Override // com.bytedance.adsdk.ugeno.ka.x
    public List<ab> ms() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ab("slide") { // from class: com.bytedance.adsdk.ugeno.ka.ms.1
            @Override // com.bytedance.adsdk.ugeno.ka.ab
            public com.bytedance.adsdk.ugeno.ka.ah.ms ms(Context context) {
                return new com.bytedance.adsdk.ugeno.ka.ah.ah(context);
            }
        });
        arrayList.add(new ab("tap") { // from class: com.bytedance.adsdk.ugeno.ka.ms.2
            @Override // com.bytedance.adsdk.ugeno.ka.ab
            public com.bytedance.adsdk.ugeno.ka.ah.ms ms(Context context) {
                return new com.bytedance.adsdk.ugeno.ka.ah.d(context);
            }
        });
        arrayList.add(new ab("timer") { // from class: com.bytedance.adsdk.ugeno.ka.ms.3
            @Override // com.bytedance.adsdk.ugeno.ka.ab
            public com.bytedance.adsdk.ugeno.ka.ah.ms ms(Context context) {
                return new com.bytedance.adsdk.ugeno.ka.ah.ka(context);
            }
        });
        arrayList.add(new ab("videoProgress") { // from class: com.bytedance.adsdk.ugeno.ka.ms.4
            @Override // com.bytedance.adsdk.ugeno.ka.ab
            public com.bytedance.adsdk.ugeno.ka.ah.ms ms(Context context) {
                return new com.bytedance.adsdk.ugeno.ka.ah.x(context);
            }
        });
        arrayList.add(new ab("touchStart") { // from class: com.bytedance.adsdk.ugeno.ka.ms.5
            @Override // com.bytedance.adsdk.ugeno.ka.ab
            public com.bytedance.adsdk.ugeno.ka.ah.ms ms(Context context) {
                return new com.bytedance.adsdk.ugeno.ka.ah.ab(context);
            }
        });
        arrayList.add(new ab("touchEnd") { // from class: com.bytedance.adsdk.ugeno.ka.ms.6
            @Override // com.bytedance.adsdk.ugeno.ka.ab
            public com.bytedance.adsdk.ugeno.ka.ah.ms ms(Context context) {
                return new com.bytedance.adsdk.ugeno.ka.ah.c(context);
            }
        });
        return arrayList;
    }
}
