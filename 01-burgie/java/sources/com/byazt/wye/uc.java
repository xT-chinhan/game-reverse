package com.byazt.wye;

import android.text.TextUtils;
import com.byazt.nzn.g;
import com.byazt.nzn.nt;
import com.byazt.nzn.w;
import com.byazt.nzn.yb;
import com.taptap.sdk.update.download.core.Util;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1008, 5})
public class uc extends nt {
    public w c = null;
    public long hn;
    public g hw;
    public HttpURLConnection pr;
    public long x;

    public uc(HttpURLConnection httpURLConnection, g gVar) {
        this.pr = httpURLConnection;
        this.hw = gVar;
    }

    @Override // com.byazt.nzn.nt
    public long pr() {
        return this.hn;
    }

    @Override // com.byazt.nzn.nt
    public long hw() {
        return this.x;
    }

    @Override // com.byazt.nzn.nt
    public int hn() {
        try {
            return this.pr.getResponseCode();
        } catch (Exception e) {
            return -1;
        }
    }

    @Override // com.byazt.nzn.nt
    public boolean x() {
        return hn() >= 200 && hn() < 300;
    }

    @Override // com.byazt.nzn.nt
    public String c() throws IOException {
        return this.pr.getResponseMessage();
    }

    @Override // com.byazt.nzn.nt
    public yb uc() {
        try {
            return new fw(this.pr);
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.byazt.nzn.nt
    public com.byazt.nzn.uc fw() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<String>> entry : this.pr.getHeaderFields().entrySet()) {
            for (String str : entry.getValue()) {
                if (!Util.CONTENT_RANGE.equalsIgnoreCase(entry.getKey()) || hn() != 206) {
                    arrayList.add(entry.getKey());
                    arrayList.add(str);
                }
            }
        }
        return new com.byazt.nzn.uc((String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    @Override // com.byazt.nzn.nt
    public String pr(String str) {
        return this.pr.getHeaderField(str);
    }

    @Override // com.byazt.nzn.nt
    public String pr(String str, String str2) {
        if (!TextUtils.isEmpty(pr(str))) {
            return pr(str);
        }
        return str2;
    }

    @Override // com.byazt.nzn.nt, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            uc().close();
        } catch (Exception e) {
        }
    }

    public String toString() {
        return "";
    }

    @Override // com.byazt.nzn.nt
    public w zo() {
        return this.c;
    }
}
