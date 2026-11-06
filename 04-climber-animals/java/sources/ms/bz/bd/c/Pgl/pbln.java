package ms.bz.bd.c.Pgl;

import com.bytedance.sdk.component.utils.sl;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class pbln {
    public static void ms(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                sl.ms(e);
            }
        }
    }
}
