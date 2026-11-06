package com.byazt.iy;

import android.text.TextUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1124, 18})
public class l {
    public int l;
    public int q;
    public int w;
    public int x;

    public void n(com.byazt.gq.n nVar) throws IOException {
    }

    public static int n(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return -1159790593;
        }
        return ((str.charAt(3) & 255) << 24) | (str.charAt(0) & 255) | ((str.charAt(1) & 255) << 8) | ((str.charAt(2) & 255) << 16);
    }

    public void qg(com.byazt.gq.n nVar) throws IOException {
        int iQ = nVar.q();
        n(nVar);
        int iQ2 = iQ - nVar.q();
        int i = this.q;
        if (iQ2 > i) {
            throw new IOException("Out of chunk area");
        }
        if (iQ2 < i) {
            nVar.n(i - iQ2);
        }
    }
}
