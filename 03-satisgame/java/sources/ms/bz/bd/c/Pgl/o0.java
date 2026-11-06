package ms.bz.bd.c.Pgl;

import android.content.res.AssetManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
final class o0 extends pbls.pgla {
    o0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    protected final Object n(long j, String str, Object obj) throws Throwable {
        InputStream inputStreamOpen;
        String str2 = str;
        AssetManager assets = pblp.n().qg().getAssets();
        if (!str2.startsWith((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c82faa", new byte[]{60}))) {
            str2 = ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fff9ad", new byte[]{57})) + str2;
        }
        String[] list = assets.list("");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.length; i++) {
            if (list[i].endsWith(str2)) {
                String str3 = list[i];
                String absolutePath = File.createTempFile((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c6f0dd", new byte[]{127, 39, 16, 92, 79}), "").getAbsolutePath();
                FileOutputStream fileOutputStream = null;
                try {
                    inputStreamOpen = assets.open(str3);
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(absolutePath);
                        try {
                            byte[] bArr = new byte[256];
                            long j2 = 0;
                            while (true) {
                                int i2 = inputStreamOpen.read(bArr);
                                if (i2 <= 0) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, 0, i2);
                                j2 += (long) i2;
                            }
                            fileOutputStream2.flush();
                            if (j2 > 0) {
                                arrayList.add(absolutePath);
                            }
                            pbll.n(inputStreamOpen);
                            pbll.n(fileOutputStream2);
                        } catch (IOException unused) {
                            fileOutputStream = fileOutputStream2;
                            pbll.n(inputStreamOpen);
                            pbll.n(fileOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            pbll.n(inputStreamOpen);
                            pbll.n(fileOutputStream);
                            throw th;
                        }
                    } catch (IOException unused2) {
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IOException unused3) {
                    inputStreamOpen = null;
                } catch (Throwable th3) {
                    th = th3;
                    inputStreamOpen = null;
                }
            }
        }
        return arrayList.toArray(new String[0]);
    }
}
