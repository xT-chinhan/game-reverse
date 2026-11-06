package com.bytedance.sdk.component.c.ms;

import com.bytedance.sdk.component.c.ny;
import com.bytedance.sdk.component.c.sl;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    public static sl ms() {
        return new sl() { // from class: com.bytedance.sdk.component.c.ms.xr.1

            /* JADX INFO: renamed from: ms, reason: collision with root package name */
            private WeakHashMap<String, String> f1192ms = new WeakHashMap<>();

            @Override // com.bytedance.sdk.component.c.sl
            public String ms(ny nyVar) {
                return ms(nyVar.xr() + "#width=" + nyVar.ah() + "#height=" + nyVar.d() + "#scaletype=" + nyVar.ka() + "#bitmapConfig=" + nyVar.x());
            }

            @Override // com.bytedance.sdk.component.c.sl
            public String xr(ny nyVar) {
                return ms(nyVar.xr());
            }

            private String ms(String str) {
                String str2 = this.f1192ms.get(str);
                if (str2 != null) {
                    return str2;
                }
                String strMs = com.bytedance.sdk.component.c.ah.ah.ah.ms(str);
                this.f1192ms.put(str, strMs);
                return strMs;
            }
        };
    }
}
