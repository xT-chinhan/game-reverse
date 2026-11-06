package ms.bz.bd.c.Pgl;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class pblr extends pbls.pgla {
    protected static void n(BufferedInputStream bufferedInputStream) {
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException unused) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1cc299", new byte[]{45, 98, 47, 69, 15});
            }
        }
    }

    protected static void n(DataOutputStream dataOutputStream) {
        if (dataOutputStream != null) {
            try {
                dataOutputStream.close();
            } catch (IOException unused) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "819d9c", new byte[]{36, 48, 117, 19, 9});
            }
        }
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    public final Object n(int i, int i2, long j, String str, Object obj) throws Throwable {
        if (!v0.n((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ee9ee2", new byte[]{117, 105, 78, 3, 85, 44, 98, 10, 120, 48, 102, 106, 67, 2, 73, 44, 105, 74, 38, 28, 90, 83, 111, 35, 116, 0, 82}))) {
            return null;
        }
        switch (i) {
            case 196609:
                Object[] objArr = (Object[]) obj;
                return n(str, (byte[]) objArr[0], (String) objArr[1], (String) objArr[2]);
            case 196610:
                Object[] objArr2 = (Object[]) obj;
                return n(str, (String) objArr2[0], (String) objArr2[1]);
            case 196611:
                Object[] objArr3 = (Object[]) obj;
                return qg(str, (String) objArr3[0], (String) objArr3[1]);
            default:
                return super.n(i, i2, j, str, obj);
        }
    }

    public abstract Object[] n(String str, String str2, String str3);

    public abstract Object[] n(String str, byte[] bArr, String str2, String str3);

    public abstract Object[] qg(String str, String str2, String str3);
}
