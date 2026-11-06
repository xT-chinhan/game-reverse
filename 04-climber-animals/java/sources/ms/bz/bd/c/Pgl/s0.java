package ms.bz.bd.c.Pgl;

import android.content.res.AssetManager;
import com.bytedance.sdk.component.utils.sl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
final class s0 extends pbly.pgla {
    s0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbly.pgla
    protected final Object ms(long j, String str, Object obj) throws Throwable {
        InputStream inputStreamOpen;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        String str2 = str;
        AssetManager assets = pblv.ms().xr().getAssets();
        int i = 0;
        if (!str2.startsWith((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5cbf99", new byte[]{106}))) {
            str2 = ((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "4759de", new byte[]{107})) + str2;
        }
        String str3 = str2;
        String[] list = assets.list("");
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < list.length) {
            if (list[i2].endsWith(str3)) {
                String str4 = list[i2];
                String absolutePath = File.createTempFile((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c0bf81", new byte[]{127, 33, 20, 10, 19}), "").getAbsolutePath();
                FileOutputStream fileOutputStream2 = null;
                try {
                    inputStreamOpen = assets.open(str4);
                    try {
                        fileOutputStream = new FileOutputStream(absolutePath);
                        try {
                            byte[] bArr = new byte[256];
                            long j2 = 0;
                            while (true) {
                                int i3 = inputStreamOpen.read(bArr);
                                if (i3 <= 0) {
                                    break;
                                }
                                fileOutputStream.write(bArr, i, i3);
                                j2 += (long) i3;
                                inputStreamOpen = inputStreamOpen;
                                i = 0;
                                inputStreamOpen = inputStream;
                                fileOutputStream2 = fileOutputStream;
                                try {
                                    sl.ms(e);
                                    pbln.ms(inputStreamOpen);
                                    pbln.ms(fileOutputStream2);
                                } catch (Throwable th) {
                                    th = th;
                                    fileOutputStream = fileOutputStream2;
                                    pbln.ms(inputStreamOpen);
                                    pbln.ms(fileOutputStream);
                                    throw th;
                                }
                            }
                            inputStream = inputStreamOpen;
                            try {
                                fileOutputStream.flush();
                                if (j2 > 0) {
                                    arrayList.add(absolutePath);
                                }
                                pbln.ms(inputStream);
                                pbln.ms(fileOutputStream);
                            } catch (IOException e) {
                                e = e;
                                inputStreamOpen = inputStream;
                                fileOutputStream2 = fileOutputStream;
                                sl.ms(e);
                                pbln.ms(inputStreamOpen);
                                pbln.ms(fileOutputStream2);
                            } catch (Throwable th2) {
                                th = th2;
                                inputStreamOpen = inputStream;
                                pbln.ms(inputStreamOpen);
                                pbln.ms(fileOutputStream);
                                throw th;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            inputStream = inputStreamOpen;
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = inputStreamOpen;
                        }
                    } catch (IOException e3) {
                        e = e3;
                    } catch (Throwable th4) {
                        th = th4;
                        fileOutputStream = fileOutputStream2;
                        pbln.ms(inputStreamOpen);
                        pbln.ms(fileOutputStream);
                        throw th;
                    }
                } catch (IOException e4) {
                    e = e4;
                    inputStreamOpen = null;
                } catch (Throwable th5) {
                    th = th5;
                    inputStreamOpen = null;
                }
            }
            i2++;
            i = 0;
        }
        return arrayList.toArray(new String[i]);
    }
}
