package com.bytedance.sdk.component.ah.xr.ms.ka;

import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface zb {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final zb f1105ms = new zb() { // from class: com.bytedance.sdk.component.ah.xr.ms.ka.zb.1
        @Override // com.bytedance.sdk.component.ah.xr.ms.ka.zb
        public boolean ms(int i, List<ah> list) {
            return true;
        }

        @Override // com.bytedance.sdk.component.ah.xr.ms.ka.zb
        public boolean ms(int i, List<ah> list, boolean z) {
            return true;
        }

        @Override // com.bytedance.sdk.component.ah.xr.ms.ka.zb
        public boolean ms(int i, com.bytedance.sdk.component.ah.ms.ka kaVar, int i2, boolean z) throws IOException {
            kaVar.x(i2);
            return true;
        }
    };

    boolean ms(int i, com.bytedance.sdk.component.ah.ms.ka kaVar, int i2, boolean z) throws IOException;

    boolean ms(int i, List<ah> list);

    boolean ms(int i, List<ah> list, boolean z);
}
