package com.byazt.rft;

import android.text.TextUtils;
import com.anythink.core.common.l.b;
import com.byazt.tbt.cp;
import com.byazt.tbt.cy;
import com.byazt.tbt.k;
import com.byazt.tbt.rv;
import com.byazt.tbt.sz;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVPH_PARAMS, 19})
public class n implements com.byazt.tbt.qg {
    public sz n;
    public q qg;
    public volatile boolean w;
    public AtomicBoolean l = new AtomicBoolean(false);
    public final String s = com.byazt.equ.q.n(UUID.randomUUID().toString()).n();
    public cp q = new cp();

    public n(sz szVar, q qVar) {
        this.n = szVar;
        this.qg = qVar;
    }

    @Override // com.byazt.tbt.qg
    public sz n() {
        return this.n;
    }

    @Override // com.byazt.tbt.qg
    public void n(com.byazt.tbt.s sVar) {
        try {
            synchronized (this) {
                if (this.w) {
                    throw new IllegalStateException("Already Executed");
                }
                this.w = true;
            }
            this.qg.n(new C0324n(sVar, this));
        } catch (Throwable th) {
            if (sVar != null) {
                sVar.onFailure(this, new IOException(th.getMessage()));
            }
        }
    }

    @Override // com.byazt.tbt.qg
    public cy qg() throws IOException {
        synchronized (this) {
            if (this.w) {
                throw new IllegalStateException("Already Executed");
            }
            this.w = true;
        }
        try {
            this.qg.n(this);
            return l();
        } finally {
            this.qg.qg(this);
        }
    }

    public cy l() {
        if (this.l.get()) {
            return null;
        }
        try {
            if (this.n.n != null && this.n.n.n != null && this.n.n.n.size() > 0) {
                ArrayList arrayList = new ArrayList(this.n.n.n);
                arrayList.add(new rv() { // from class: com.byazt.rft.n.1
                    @Override // com.byazt.tbt.rv
                    public cy n(rv.n nVar) throws IOException {
                        return n.this.n(nVar.n());
                    }
                });
                return ((rv) arrayList.get(0)).n(new qg(arrayList, this.n));
            }
            return n(this.n);
        } catch (Throwable unused) {
            return null;
        }
    }

    public cy n(sz szVar) throws IOException {
        try {
            cp cpVar = this.q;
            if (cpVar != null) {
                cpVar.qg();
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(szVar.s()).openConnection();
            if (szVar.w() != null && szVar.w().size() > 0) {
                for (Map.Entry<String, List<String>> entry : szVar.w().entrySet()) {
                    Iterator<String> it = entry.getValue().iterator();
                    while (it.hasNext()) {
                        httpURLConnection.addRequestProperty(entry.getKey(), it.next());
                    }
                }
            }
            if (szVar.n != null) {
                if (szVar.n.s != null) {
                    httpURLConnection.setConnectTimeout((int) szVar.n.s.toMillis(szVar.n.qg));
                }
                if (szVar.n.l != null) {
                    httpURLConnection.setReadTimeout((int) szVar.n.l.toMillis(szVar.n.q));
                }
            }
            if (szVar.fs() == null) {
                httpURLConnection.setRequestMethod(TapHttp.METHOD_GET);
            } else {
                if (!x() && szVar.fs().s != null) {
                    httpURLConnection.addRequestProperty(b.g, szVar.fs().s.toString());
                }
                httpURLConnection.setRequestMethod(szVar.q());
                if (n(szVar.fs())) {
                    n(httpURLConnection);
                }
                if (TapHttp.METHOD_POST.equalsIgnoreCase(szVar.q())) {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    if (s(szVar.fs())) {
                        outputStream.write(szVar.fs().q.getBytes());
                    } else if (n(szVar.fs())) {
                        n(szVar.fs().l, outputStream, szVar.fs().qg(), szVar.fs().n());
                    } else if (qg(szVar.fs())) {
                        outputStream.write(szVar.fs().l);
                    }
                    outputStream.flush();
                    outputStream.close();
                }
            }
            httpURLConnection.connect();
            long jCurrentTimeMillis = System.currentTimeMillis();
            cp cpVar2 = this.q;
            if (cpVar2 != null) {
                cpVar2.s();
                this.q.n(jCurrentTimeMillis);
            }
            httpURLConnection.getResponseCode();
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (this.l.get()) {
                httpURLConnection.disconnect();
                return null;
            }
            w wVar = new w(httpURLConnection, szVar);
            wVar.q = jCurrentTimeMillis;
            wVar.s = jCurrentTimeMillis2;
            cp cpVar3 = this.q;
            if (cpVar3 != null) {
                cpVar3.qg(jCurrentTimeMillis2);
            }
            wVar.l = this.q;
            return wVar;
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private void n(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty(b.g, "multipart/form-data; boundary=" + this.s);
    }

    private void n(byte[] bArr, OutputStream outputStream, String str, String str2) throws IOException {
        if (bArr == null || outputStream == null) {
            return;
        }
        PrintWriter printWriter = new PrintWriter((Writer) new OutputStreamWriter(outputStream, "UTF-8"), true);
        printWriter.append((CharSequence) ("--" + this.s)).append((CharSequence) "\r\n");
        printWriter.append((CharSequence) ("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"")).append((CharSequence) "\r\n");
        printWriter.append((CharSequence) "Content-Type: multipart/form-data").append((CharSequence) "\r\n");
        printWriter.append((CharSequence) ("Content-Length: " + bArr.length)).append((CharSequence) "\r\n");
        printWriter.append((CharSequence) "\r\n");
        printWriter.flush();
        outputStream.write(bArr);
        printWriter.append((CharSequence) "\r\n");
        printWriter.append((CharSequence) ("--" + this.s + "--")).append((CharSequence) "\r\n");
        printWriter.flush();
        printWriter.close();
    }

    private boolean n(k kVar) {
        sz szVar;
        return kVar != null && (szVar = this.n) != null && TapHttp.METHOD_POST.equalsIgnoreCase(szVar.q()) && kVar.w == k.n.FILE_TYPE && kVar.l != null && kVar.l.length > 0;
    }

    private boolean qg(k kVar) {
        sz szVar;
        return kVar != null && (szVar = this.n) != null && TapHttp.METHOD_POST.equalsIgnoreCase(szVar.q()) && kVar.w == k.n.BYTE_ARRAY_TYPE && kVar.l != null && kVar.l.length > 0;
    }

    private boolean s(k kVar) {
        sz szVar;
        return (kVar == null || (szVar = this.n) == null || !TapHttp.METHOD_POST.equalsIgnoreCase(szVar.q()) || kVar.w != k.n.STRING_TYPE || TextUtils.isEmpty(kVar.q)) ? false : true;
    }

    private boolean x() {
        if (this.n.w() == null) {
            return false;
        }
        return this.n.w().containsKey(b.g);
    }

    @Override // com.byazt.tbt.qg
    public void s() {
        this.l.set(true);
    }

    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public com.byazt.tbt.qg clone() {
        return new n(this.n, this.qg);
    }

    @Override // com.byazt.tbt.qg
    public boolean q() {
        return this.l.get();
    }

    /* JADX INFO: renamed from: com.byazt.rft.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVPH_PARAMS, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    final class C0324n extends com.byazt.equ.l {
        public final n q;
        public final com.byazt.tbt.s s;

        public C0324n(com.byazt.tbt.s sVar, n nVar) {
            super("net-async-call", new Object[0]);
            this.s = sVar;
            this.q = nVar;
        }

        public n n() {
            return this.q;
        }

        public void qg() {
            n nVar = this.q;
            if (nVar == null || nVar.q == null) {
                return;
            }
            this.q.q.q();
        }

        public void s() {
            com.byazt.tbt.s sVar = this.s;
            if (sVar == null) {
                return;
            }
            try {
                sVar.onFailure(n.this, new IOException("ready queue max count exceeded"));
            } catch (Throwable unused) {
            }
        }

        @Override // com.byazt.equ.l
        public void q() {
            try {
                n nVar = this.q;
                if (nVar != null && nVar.q != null) {
                    this.q.q.n();
                }
                cy cyVarL = n.this.l();
                if (cyVarL == null) {
                    this.s.onFailure(n.this, new IOException("response is null"));
                } else {
                    this.s.onResponse(n.this, cyVarL);
                }
                try {
                    this.q.qg.qg(this);
                } catch (Throwable unused) {
                }
            } catch (Throwable th) {
                try {
                    if (th instanceof IOException) {
                        this.s.onFailure(n.this, th);
                    } else {
                        this.s.onFailure(n.this, new IOException(th));
                    }
                } finally {
                    try {
                        this.q.qg.qg(this);
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
    }
}
