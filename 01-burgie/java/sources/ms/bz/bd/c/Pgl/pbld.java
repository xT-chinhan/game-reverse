package ms.bz.bd.c.Pgl;

import android.content.Context;
import com.byazt.mg.hw;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class pbld {
    private static final String pr = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "81f2ba", new byte[]{39, 50, 91, 69, 71, 122});

    /* JADX WARN: Code duplicated, block: B:64:0x00c3 A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:0x00ca A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    public static int pr(Context context) {
        InputStream inputStreamOpen;
        int i = 3;
        ByteArrayOutputStream byteArrayOutputStream = null;
        int i2 = 255;
        try {
            StringBuilder sbAppend = new StringBuilder().append(hw.pr(context).getAbsolutePath()).append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0340e8", new byte[]{110}));
            String str = pr;
            String string = sbAppend.append(str).toString();
            File file = new File(string);
            if (file.exists()) {
                try {
                    file.delete();
                    i2 = 2;
                } catch (Throwable th) {
                    i2 = 2;
                    inputStreamOpen = null;
                    try {
                        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ebbb11", new byte[]{117, 99, 46, 17});
                        return i2;
                    } finally {
                        if (inputStreamOpen != null) {
                            try {
                                inputStreamOpen.close();
                            } catch (Throwable th2) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable th3) {
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
                    } catch (Throwable th4) {
                    }
                    try {
                        byteArrayOutputStream2.close();
                        return i;
                    } catch (Throwable th5) {
                        return i;
                    }
                } catch (Throwable th6) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ebbb11", new byte[]{117, 99, 46, 17});
                    return i2;
                }
            } catch (Throwable th7) {
            }
        } catch (Throwable th8) {
        }
    }
}
