package ms.bz.bd.c.Pgl;

import com.umeng.analytics.pro.ek;
import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public abstract class pblx extends pbly.pgla {
    protected static void ms(BufferedInputStream bufferedInputStream) {
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException unused) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ca0295", new byte[]{127, 96, 124, 69, ek.m});
            }
        }
    }

    protected static void ms(DataOutputStream dataOutputStream) {
        if (dataOutputStream != null) {
            try {
                dataOutputStream.close();
            } catch (IOException unused) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "169531", new byte[]{45, 55, 117, 66, 3});
            }
        }
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    public final Object ms(int i, int i2, long j, String str, Object obj) throws Throwable {
        if (!d1.ms((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "26ce8e", new byte[]{34, 58, 20, 3, 8, 123, 53, 89, 34, 48, 49, 57, 25, 2, 20, 123, 62, 25, 124, 28, ek.k, 0, 53, 35, 41, 87, 5}))) {
            return null;
        }
        switch (i) {
            case 196609:
                Object[] objArr = (Object[]) obj;
                return ms(str, (byte[]) objArr[0], (String) objArr[1], (String) objArr[2]);
            case 196610:
                Object[] objArr2 = (Object[]) obj;
                return ms(str, (String) objArr2[0], (String) objArr2[1]);
            case 196611:
                Object[] objArr3 = (Object[]) obj;
                return xr(str, (String) objArr3[0], (String) objArr3[1]);
            default:
                return super.ms(i, i2, j, str, obj);
        }
    }

    public abstract Object[] ms(String str, String str2, String str3);

    public abstract Object[] ms(String str, byte[] bArr, String str2, String str3);

    public abstract Object[] xr(String str, String str2, String str3);
}
