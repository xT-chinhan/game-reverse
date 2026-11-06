package com.byazt.pd;

import com.byazt.ly.hw;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 549, 37})
public class pr {
    public static List<com.byazt.ly.pr> pr(hw hwVar, com.byazt.ff.hw hwVar2) throws Exception {
        return pr(com.byazt.rr.pr.pr(hwVar, hwVar2, 1896449818).pr);
    }

    public static List<com.byazt.ly.pr> pr(ByteBuffer byteBuffer) {
        try {
            ByteBuffer byteBufferPr = com.byazt.rr.pr.pr(byteBuffer);
            if (!byteBufferPr.hasRemaining()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            while (byteBufferPr.hasRemaining()) {
                try {
                    arrayList.add(hw(com.byazt.rr.pr.pr(byteBufferPr)));
                } catch (Exception e) {
                    return null;
                }
            }
            return arrayList;
        } catch (Exception e2) {
            return null;
        }
    }

    @DungeonFlag
    private static com.byazt.ly.pr hw(ByteBuffer byteBuffer) throws Exception {
        ByteBuffer byteBufferPr = com.byazt.rr.pr.pr(byteBuffer);
        byteBufferPr.get(new byte[byteBufferPr.remaining()]);
        byteBufferPr.flip();
        byteBufferPr.position(0);
        com.byazt.rr.pr.pr(byteBufferPr);
        byte[] bArrHw = com.byazt.rr.pr.hw(com.byazt.rr.pr.pr(byteBufferPr));
        try {
            return new com.byazt.ly.pr(String.valueOf(((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArrHw))).getSubjectDN()), bArrHw);
        } catch (Exception e) {
            return null;
        }
    }
}
