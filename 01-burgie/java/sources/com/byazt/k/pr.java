package com.byazt.k;

import android.content.Context;
import android.media.MediaDataSource;
import android.text.TextUtils;
import com.byazt.g.hn;
import com.byazt.n.hw;
import com.byazt.n.uc;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 250, 37})
public class pr extends MediaDataSource {
    public static final ConcurrentHashMap<String, pr> pr = new ConcurrentHashMap<>();
    public final uc c;
    public long hn = -2147483648L;
    public final hn hw;
    public final Context x;

    public pr(Context context, hw hwVar, uc ucVar) {
        this.x = context;
        this.c = ucVar;
        this.hw = new com.byazt.g.hw(context, hwVar, ucVar);
    }

    @Override // android.media.MediaDataSource
    public int readAt(long j, byte[] bArr, int i, int i2) throws IOException {
        return this.hw.pr(j, bArr, i, i2);
    }

    @Override // android.media.MediaDataSource
    public long getSize() throws IOException {
        if (this.hn == -2147483648L) {
            if (this.x == null || TextUtils.isEmpty(this.c.ny())) {
                return -1L;
            }
            this.hn = this.hw.hn();
        }
        return this.hn;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Object[] objArr = {"close: ", this.c.ny()};
        hn hnVar = this.hw;
        if (hnVar != null) {
            hnVar.hw();
        }
        pr.remove(this.c.fo());
    }

    public uc pr() {
        return this.c;
    }

    public static pr pr(Context context, hw hwVar, uc ucVar) {
        pr prVar = new pr(context, hwVar, ucVar);
        pr.put(ucVar.fo(), prVar);
        return prVar;
    }
}
