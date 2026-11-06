package com.byazt.qe;

import com.byazt.iip.qg;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1107, 19})
public class n {
    public static List<com.byazt.iip.n> n(qg qgVar, com.byazt.ujk.qg qgVar2) throws Exception {
        return n(com.byazt.jvf.n.n(qgVar, qgVar2, 1896449818).n);
    }

    public static List<com.byazt.iip.n> n(ByteBuffer byteBuffer) {
        try {
            ByteBuffer byteBufferN = com.byazt.jvf.n.n(byteBuffer);
            if (!byteBufferN.hasRemaining()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            while (byteBufferN.hasRemaining()) {
                try {
                    arrayList.add(qg(com.byazt.jvf.n.n(byteBufferN)));
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
    private static com.byazt.iip.n qg(ByteBuffer byteBuffer) throws Exception {
        ByteBuffer byteBufferN = com.byazt.jvf.n.n(byteBuffer);
        byteBufferN.get(new byte[byteBufferN.remaining()]);
        byteBufferN.flip();
        byteBufferN.position(0);
        com.byazt.jvf.n.n(byteBufferN);
        byte[] bArrQg = com.byazt.jvf.n.qg(com.byazt.jvf.n.n(byteBufferN));
        try {
            return new com.byazt.iip.n(String.valueOf(((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArrQg))).getSubjectDN()), bArrQg);
        } catch (Exception unused) {
            return null;
        }
    }
}
