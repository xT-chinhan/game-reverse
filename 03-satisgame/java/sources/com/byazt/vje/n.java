package com.byazt.vje;

import android.content.Context;
import android.media.MediaDataSource;
import android.text.TextUtils;
import com.byazt.ej.oa;
import com.byazt.ryy.qg;
import com.byazt.ryy.s;
import com.byazt.zsl.l;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 2034, 19})
public class n extends MediaDataSource {
    public static final ConcurrentHashMap<String, n> n = new ConcurrentHashMap<>();
    public final l l;
    public final Context q;
    public final s qg;
    public long s = -2147483648L;

    public n(Context context, oa oaVar, l lVar) {
        this.q = context;
        this.l = lVar;
        this.qg = new qg(context, oaVar, lVar);
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
        return this.qg.n(j, bArr, i, i2);
    }

    @Override // android.media.MediaDataSource
    public long getSize() throws IOException {
        if (this.s == -2147483648L) {
            if (this.q == null || TextUtils.isEmpty(this.l.ou())) {
                return -1L;
            }
            this.s = this.qg.s();
        }
        return this.s;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Object[] objArr = new Object[2];
        this.l.ou();
        s sVar = this.qg;
        if (sVar != null) {
            sVar.qg();
        }
        n.remove(this.l.wm());
    }

    public l n() {
        return this.l;
    }

    public static n n(Context context, oa oaVar, l lVar) {
        n nVar = new n(context, oaVar, lVar);
        n.put(lVar.wm(), nVar);
        return nVar;
    }
}
