package ms.bz.bd.c.Pgl;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class t0 extends RuntimeException {
    public t0(String str, String[] strArr, String[] strArr2) {
        super("Could not find '" + str + "'. Looked for: " + Arrays.toString(strArr) + ", but only found: " + Arrays.toString(strArr2) + com.anythink.core.common.d.i.E);
    }
}
