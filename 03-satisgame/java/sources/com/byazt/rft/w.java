package com.byazt.rft;

import android.text.TextUtils;
import com.byazt.tbt.cp;
import com.byazt.tbt.cy;
import com.byazt.tbt.hd;
import com.byazt.tbt.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVPH_PARAMS, 13})
public class w extends cy {
    public cp l = null;
    public HttpURLConnection n;
    public long q;
    public sz qg;
    public long s;

    public String toString() {
        return "";
    }

    public w(HttpURLConnection httpURLConnection, sz szVar) {
        this.n = httpURLConnection;
        this.qg = szVar;
    }

    @Override // com.byazt.tbt.cy
    public long n() {
        return this.s;
    }

    @Override // com.byazt.tbt.cy
    public long qg() {
        return this.q;
    }

    @Override // com.byazt.tbt.cy
    public sz s() {
        return this.qg;
    }

    @Override // com.byazt.tbt.cy
    public int q() {
        try {
            return this.n.getResponseCode();
        } catch (Exception unused) {
            return -1;
        }
    }

    @Override // com.byazt.tbt.cy
    public boolean l() {
        return q() >= 200 && q() < 300;
    }

    @Override // com.byazt.tbt.cy
    public String w() throws IOException {
        return this.n.getResponseMessage();
    }

    @Override // com.byazt.tbt.cy
    public hd x() {
        try {
            return new x(this.n);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.byazt.tbt.cy
    public com.byazt.tbt.w fs() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<String>> entry : this.n.getHeaderFields().entrySet()) {
            for (String str : entry.getValue()) {
                if (!"Content-Range".equalsIgnoreCase(entry.getKey()) || q() != 206) {
                    arrayList.add(entry.getKey());
                    arrayList.add(str);
                }
            }
        }
        return new com.byazt.tbt.w((String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    @Override // com.byazt.tbt.cy
    public String n(String str) {
        return this.n.getHeaderField(str);
    }

    @Override // com.byazt.tbt.cy
    public String n(String str, String str2) {
        return !TextUtils.isEmpty(n(str)) ? n(str) : str2;
    }

    @Override // com.byazt.tbt.cy, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            x().close();
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.tbt.cy
    public cp rv() {
        return this.l;
    }
}
