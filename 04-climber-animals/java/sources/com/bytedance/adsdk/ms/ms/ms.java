package com.bytedance.adsdk.ms.ms;

import com.bytedance.adsdk.ms.ms.ms.ny;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends ah<com.bytedance.adsdk.ms.ms.ms.xr> {
    public ms(com.bytedance.adsdk.ms.ms.ah.xr xrVar) {
        super(xrVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.adsdk.ms.ms.ah
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.ms.ms.ms.xr xr(com.bytedance.adsdk.ms.ms.ah.xr xrVar, ny.ms msVar) {
        return new com.bytedance.adsdk.ms.ms.ms.xr(xrVar, msVar);
    }

    public static ms ms(final ByteBuffer byteBuffer) {
        return new ms(new com.bytedance.adsdk.ms.ms.ah.ms() { // from class: com.bytedance.adsdk.ms.ms.ms.1
            @Override // com.bytedance.adsdk.ms.ms.ah.ms
            public ByteBuffer ms() {
                byteBuffer.position(0);
                return byteBuffer;
            }
        });
    }
}
