package ms.bz.bd.c.Pgl;

import android.content.Context;
import com.bytedance.sdk.openadsdk.api.plugin.xr;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public final class pblf {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f4848ms = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "76fb3a", new byte[]{40, 53, 91, 21, 22, 122});

    /* JADX WARN: Code duplicated, block: B:49:0x00bf A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x00ba A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    public static int ms(Context context) {
        InputStream inputStreamOpen;
        int i = 3;
        int i2 = 255;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            StringBuilder sbAppend = new StringBuilder().append(xr.ms(context).getAbsolutePath()).append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d54981", new byte[]{58}));
            String str = f4848ms;
            String string = sbAppend.append(str).toString();
            File file = new File(string);
            if (file.exists()) {
                try {
                    file.delete();
                    i2 = 2;
                } catch (Throwable unused) {
                    i2 = 2;
                    inputStreamOpen = null;
                    try {
                        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1c2871", new byte[]{33, 98, 126, 75});
                        return i2;
                    } finally {
                        if (inputStreamOpen != null) {
                            try {
                                inputStreamOpen.close();
                            } catch (Throwable unused2) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable unused3) {
                            }
                        }
                    }
                }
            }
            inputStreamOpen = context.getResources().getAssets().open(str);
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i3 = inputStreamOpen.read(bArr, 0, 4096);
                        if (i3 == -1) {
                            break;
                        }
                        byteArrayOutputStream2.write(bArr, 0, i3);
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(string);
                    fileOutputStream.write(byteArrayOutputStream2.toByteArray());
                    fileOutputStream.close();
                    if (byteArrayOutputStream2.size() > 0) {
                        i = new File(string).exists() ? 0 : i2;
                    }
                    try {
                        inputStreamOpen.close();
                    } catch (Throwable unused4) {
                    }
                    try {
                        byteArrayOutputStream2.close();
                        return i;
                    } catch (Throwable unused5) {
                        return i;
                    }
                } catch (Throwable unused6) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1c2871", new byte[]{33, 98, 126, 75});
                    return i2;
                }
            } catch (Throwable unused7) {
            }
        } catch (Throwable unused8) {
        }
    }
}
