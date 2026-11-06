package com.bytedance.sdk.component.panglearmor.ms.ms.xr.ms.ms;

import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.component.panglearmor.ms.xr.xr;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ms {
    public static List<com.bytedance.sdk.component.panglearmor.ms.xr.ms> ms(xr xrVar, com.bytedance.sdk.component.panglearmor.ms.ms.ah.xr xrVar2) throws Exception {
        return ms(com.bytedance.sdk.component.panglearmor.ms.ms.xr.ms.ms.ms(xrVar, xrVar2, 1896449818).f1314ms);
    }

    public static List<com.bytedance.sdk.component.panglearmor.ms.xr.ms> ms(ByteBuffer byteBuffer) {
        try {
            ByteBuffer byteBufferMs = com.bytedance.sdk.component.panglearmor.ms.ms.xr.ms.ms.ms(byteBuffer);
            if (!byteBufferMs.hasRemaining()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            while (byteBufferMs.hasRemaining()) {
                try {
                    arrayList.add(xr(com.bytedance.sdk.component.panglearmor.ms.ms.xr.ms.ms.ms(byteBufferMs)));
                } catch (Exception unused) {
                    return null;
                }
            }
            return arrayList;
        } catch (Exception unused2) {
            return null;
        }
    }

    @DungeonFlag
    private static com.bytedance.sdk.component.panglearmor.ms.xr.ms xr(ByteBuffer byteBuffer) throws Exception {
        ByteBuffer byteBufferMs = com.bytedance.sdk.component.panglearmor.ms.ms.xr.ms.ms.ms(byteBuffer);
        byteBufferMs.get(new byte[byteBufferMs.remaining()]);
        byteBufferMs.flip();
        byteBufferMs.position(0);
        com.bytedance.sdk.component.panglearmor.ms.ms.xr.ms.ms.ms(byteBufferMs);
        byte[] bArrXr = com.bytedance.sdk.component.panglearmor.ms.ms.xr.ms.ms.xr(com.bytedance.sdk.component.panglearmor.ms.ms.xr.ms.ms.ms(byteBufferMs));
        try {
            return new com.bytedance.sdk.component.panglearmor.ms.xr.ms(String.valueOf(((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArrXr))).getSubjectDN()), bArrXr);
        } catch (Exception unused) {
            return null;
        }
    }
}
