package ms.bz.bd.c.Pgl;

import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class y0 extends RuntimeException {
    public y0(String str, String[] strArr, String[] strArr2) {
        super("Could not find '" + str + "'. Looked for: " + Arrays.toString(strArr) + ", but only found: " + Arrays.toString(strArr2) + com.anythink.core.common.d.j.z);
    }
}
