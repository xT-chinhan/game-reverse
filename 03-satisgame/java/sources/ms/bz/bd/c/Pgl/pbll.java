package ms.bz.bd.c.Pgl;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class pbll {
    public static void n(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
