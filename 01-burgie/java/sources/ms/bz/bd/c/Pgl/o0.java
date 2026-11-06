package ms.bz.bd.c.Pgl;

import android.content.res.AssetManager;
import com.umeng.analytics.pro.cc;
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
    protected final Object pr(long j, String str, Object obj) throws Throwable {
        InputStream inputStreamOpen;
        InputStream inputStream;
        InputStream inputStream2;
        String str2 = str;
        AssetManager assets = pblp.pr().hw().getAssets();
        int i = 0;
        if (!str2.startsWith((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c82faa", new byte[]{60}))) {
            str2 = ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fff9ad", new byte[]{57})) + str2;
        }
        String str3 = str2;
        String[] list = assets.list("");
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < list.length) {
            if (list[i2].endsWith(str3)) {
                String str4 = list[i2];
                String absolutePath = File.createTempFile((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c6f0dd", new byte[]{127, 39, cc.n, 92, 79}), "").getAbsolutePath();
                FileOutputStream fileOutputStream = null;
                try {
                    inputStreamOpen = assets.open(str4);
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(absolutePath);
                        try {
                            byte[] bArr = new byte[256];
                            long j2 = 0;
                            while (true) {
                                int i3 = inputStreamOpen.read(bArr);
                                if (i3 <= 0) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, i, i3);
                                j2 += (long) i3;
                                inputStreamOpen = inputStreamOpen;
                                i = 0;
                                inputStream = inputStream2;
                                fileOutputStream = fileOutputStream2;
                                pbll.pr(inputStream);
                                pbll.pr(fileOutputStream);
                            }
                            inputStream2 = inputStreamOpen;
                            try {
                                fileOutputStream2.flush();
                                if (j2 > 0) {
                                    arrayList.add(absolutePath);
                                }
                                pbll.pr(inputStream2);
                                pbll.pr(fileOutputStream2);
                            } catch (IOException e) {
                                inputStream = inputStream2;
                                fileOutputStream = fileOutputStream2;
                                pbll.pr(inputStream);
                                pbll.pr(fileOutputStream);
                            } catch (Throwable th) {
                                th = th;
                                inputStreamOpen = inputStream2;
                                fileOutputStream = fileOutputStream2;
                                pbll.pr(inputStreamOpen);
                                pbll.pr(fileOutputStream);
                                throw th;
                            }
                        } catch (IOException e2) {
                            inputStream2 = inputStreamOpen;
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream2 = inputStreamOpen;
                        }
                    } catch (IOException e3) {
                        inputStream = inputStreamOpen;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (IOException e4) {
                    inputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    inputStreamOpen = null;
                }
            }
            i2++;
            i = 0;
        }
        return arrayList.toArray(new String[0]);
    }
}
