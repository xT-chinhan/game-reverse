package ms.bz.bd.c.Pgl;

import com.umeng.analytics.pro.cc;
import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class pblr extends pbls.pgla {
    protected static void pr(BufferedInputStream bufferedInputStream) {
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException e) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1cc299", new byte[]{45, 98, 47, 69, cc.m});
            }
        }
    }

    protected static void pr(DataOutputStream dataOutputStream) {
        if (dataOutputStream != null) {
            try {
                dataOutputStream.close();
            } catch (IOException e) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "819d9c", new byte[]{36, 48, 117, 19, 9});
            }
        }
    }

    public abstract Object[] hw(String str, String str2, String str3);

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    public final Object pr(int i, int i2, long j, String str, Object obj) throws Throwable {
        if (!v0.pr((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ee9ee2", new byte[]{117, 105, 78, 3, 85, 44, 98, 10, 120, 48, 102, 106, 67, 2, 73, 44, 105, 74, 38, 28, 90, 83, 111, 35, 116, 0, 82}))) {
            return null;
        }
        switch (i) {
            case 196609:
                Object[] objArr = (Object[]) obj;
                return pr(str, (byte[]) objArr[0], (String) objArr[1], (String) objArr[2]);
            case 196610:
                Object[] objArr2 = (Object[]) obj;
                return pr(str, (String) objArr2[0], (String) objArr2[1]);
            case 196611:
                Object[] objArr3 = (Object[]) obj;
                return hw(str, (String) objArr3[0], (String) objArr3[1]);
            default:
                return super.pr(i, i2, j, str, obj);
        }
    }

    public abstract Object[] pr(String str, String str2, String str3);

    public abstract Object[] pr(String str, byte[] bArr, String str2, String str3);
}
