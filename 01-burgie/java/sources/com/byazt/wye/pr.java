package com.byazt.wye;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.byazt.nzn.aj;
import com.byazt.nzn.g;
import com.byazt.nzn.ho;
import com.byazt.nzn.nt;
import com.byazt.nzn.w;
import com.mar.sdk.MARCode;
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
@com.byazt.vzx.pr(pr = {0, 1, 1008, 37})
public class pr implements com.byazt.nzn.hw {
    public x hw;
    public g pr;
    public volatile boolean uc;
    public AtomicBoolean c = new AtomicBoolean(false);
    public final String hn = com.byazt.qm.x.pr(UUID.randomUUID().toString()).pr();
    public w x = new w();

    public pr(g gVar, x xVar) {
        this.pr = gVar;
        this.hw = xVar;
    }

    @Override // com.byazt.nzn.hw
    public g pr() {
        return this.pr;
    }

    @Override // com.byazt.nzn.hw
    public void pr(com.byazt.nzn.hn hnVar) {
        try {
            synchronized (this) {
                if (this.uc) {
                    throw new IllegalStateException("Already Executed");
                }
                this.uc = true;
            }
            this.hw.pr(new C0229pr(hnVar, this));
        } catch (Throwable th) {
            if (hnVar != null) {
                hnVar.onFailure(this, new IOException(th.getMessage()));
            }
        }
    }

    @Override // com.byazt.nzn.hw
    public nt hw() throws IOException {
        synchronized (this) {
            if (this.uc) {
                throw new IllegalStateException("Already Executed");
            }
            this.uc = true;
        }
        try {
            this.hw.pr(this);
            return c();
        } finally {
            this.hw.hw(this);
        }
    }

    public nt c() {
        if (this.c.get()) {
            return null;
        }
        try {
            if (this.pr.pr != null && this.pr.pr.pr != null && this.pr.pr.pr.size() > 0) {
                ArrayList arrayList = new ArrayList(this.pr.pr.pr);
                arrayList.add(new aj() { // from class: com.byazt.wye.pr.1
                    @Override // com.byazt.nzn.aj
                    public nt pr(aj.pr prVar) throws IOException {
                        return pr.this.pr(prVar.pr());
                    }
                });
                return ((aj) arrayList.get(0)).pr(new hw(arrayList, this.pr));
            }
            return pr(this.pr);
        } catch (Throwable th) {
            return null;
        }
    }

    public nt pr(g gVar) throws IOException {
        try {
            w wVar = this.x;
            if (wVar != null) {
                wVar.hw();
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(gVar.hw().toString()).openConnection();
            if (gVar.x() != null && gVar.x().size() > 0) {
                for (Map.Entry<String, List<String>> entry : gVar.x().entrySet()) {
                    Iterator<String> it = entry.getValue().iterator();
                    while (it.hasNext()) {
                        httpURLConnection.addRequestProperty(entry.getKey(), it.next());
                    }
                }
            }
            if (gVar.pr != null) {
                if (gVar.pr.hn != null) {
                    httpURLConnection.setConnectTimeout((int) gVar.pr.hn.toMillis(gVar.pr.hw));
                }
                if (gVar.pr.c != null) {
                    httpURLConnection.setReadTimeout((int) gVar.pr.c.toMillis(gVar.pr.x));
                }
            }
            if (gVar.uc() == null) {
                httpURLConnection.setRequestMethod(TapHttp.METHOD_GET);
            } else {
                if (!fw() && gVar.uc().hn != null) {
                    httpURLConnection.addRequestProperty("Content-Type", gVar.uc().hn.toString());
                }
                httpURLConnection.setRequestMethod(gVar.hn());
                if (pr(gVar.uc())) {
                    pr(httpURLConnection);
                }
                if (TapHttp.METHOD_POST.equalsIgnoreCase(gVar.hn())) {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    if (hn(gVar.uc())) {
                        outputStream.write(gVar.uc().x.getBytes());
                    } else if (pr(gVar.uc())) {
                        pr(gVar.uc().c, outputStream, gVar.uc().hw(), gVar.uc().pr());
                    } else if (hw(gVar.uc())) {
                        outputStream.write(gVar.uc().c);
                    }
                    outputStream.flush();
                    outputStream.close();
                }
            }
            httpURLConnection.connect();
            long jCurrentTimeMillis = System.currentTimeMillis();
            w wVar2 = this.x;
            if (wVar2 != null) {
                wVar2.hn();
                this.x.pr(jCurrentTimeMillis);
            }
            httpURLConnection.getResponseCode();
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (this.c.get()) {
                httpURLConnection.disconnect();
                return null;
            }
            uc ucVar = new uc(httpURLConnection, gVar);
            ucVar.x = jCurrentTimeMillis;
            ucVar.hn = jCurrentTimeMillis2;
            w wVar3 = this.x;
            if (wVar3 != null) {
                wVar3.hw(jCurrentTimeMillis2);
            }
            ucVar.c = this.x;
            return ucVar;
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private void pr(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.hn);
    }

    private void pr(byte[] bArr, OutputStream outputStream, String str, String str2) throws IOException {
        if (bArr == null || outputStream == null) {
            return;
        }
        PrintWriter printWriter = new PrintWriter((Writer) new OutputStreamWriter(outputStream, Key.STRING_CHARSET_NAME), true);
        printWriter.append((CharSequence) ("--" + this.hn)).append((CharSequence) "\r\n");
        printWriter.append((CharSequence) ("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"")).append((CharSequence) "\r\n");
        printWriter.append((CharSequence) "Content-Type: multipart/form-data").append((CharSequence) "\r\n");
        printWriter.append((CharSequence) ("Content-Length: " + bArr.length)).append((CharSequence) "\r\n");
        printWriter.append((CharSequence) "\r\n");
        printWriter.flush();
        outputStream.write(bArr);
        printWriter.append((CharSequence) "\r\n");
        printWriter.append((CharSequence) ("--" + this.hn + "--")).append((CharSequence) "\r\n");
        printWriter.flush();
        printWriter.close();
    }

    private boolean pr(ho hoVar) {
        g gVar;
        if (hoVar == null || (gVar = this.pr) == null || !TapHttp.METHOD_POST.equalsIgnoreCase(gVar.hn()) || hoVar.uc != ho.pr.FILE_TYPE || hoVar.c == null || hoVar.c.length <= 0) {
            return false;
        }
        return true;
    }

    private boolean hw(ho hoVar) {
        g gVar;
        if (hoVar == null || (gVar = this.pr) == null || !TapHttp.METHOD_POST.equalsIgnoreCase(gVar.hn()) || hoVar.uc != ho.pr.BYTE_ARRAY_TYPE || hoVar.c == null || hoVar.c.length <= 0) {
            return false;
        }
        return true;
    }

    private boolean hn(ho hoVar) {
        g gVar;
        if (hoVar == null || (gVar = this.pr) == null || !TapHttp.METHOD_POST.equalsIgnoreCase(gVar.hn()) || hoVar.uc != ho.pr.STRING_TYPE || TextUtils.isEmpty(hoVar.x)) {
            return false;
        }
        return true;
    }

    private boolean fw() {
        if (this.pr.x() == null) {
            return false;
        }
        return this.pr.x().containsKey("Content-Type");
    }

    @Override // com.byazt.nzn.hw
    public void hn() {
        this.c.set(true);
    }

    /* JADX INFO: renamed from: uc, reason: merged with bridge method [inline-methods] */
    public com.byazt.nzn.hw clone() {
        return new pr(this.pr, this.hw);
    }

    @Override // com.byazt.nzn.hw
    public boolean x() {
        return this.c.get();
    }

    /* JADX INFO: renamed from: com.byazt.wye.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 1008, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    final class C0229pr extends com.byazt.qm.c {
        public final com.byazt.nzn.hn hn;
        public final pr x;

        public C0229pr(com.byazt.nzn.hn hnVar, pr prVar) {
            super("net-async-call", new Object[0]);
            this.hn = hnVar;
            this.x = prVar;
        }

        public pr pr() {
            return this.x;
        }

        public void hw() {
            pr prVar = this.x;
            if (prVar != null && prVar.x != null) {
                this.x.x.x();
            }
        }

        @Override // com.byazt.qm.c
        public void hn() {
            try {
                try {
                    pr prVar = this.x;
                    if (prVar != null && prVar.x != null) {
                        this.x.x.pr();
                    }
                    nt ntVarC = pr.this.c();
                    if (ntVarC == null) {
                        this.hn.onFailure(pr.this, new IOException("response is null"));
                    } else {
                        this.hn.onResponse(pr.this, ntVarC);
                    }
                    this.x.hw.hw(this);
                } catch (Throwable th) {
                    try {
                        if (th instanceof IOException) {
                            this.hn.onFailure(pr.this, th);
                        } else {
                            this.hn.onFailure(pr.this, new IOException(th));
                        }
                        this.x.hw.hw(this);
                    } catch (Throwable th2) {
                        try {
                            this.x.hw.hw(this);
                        } catch (Throwable th3) {
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
            }
        }
    }
}
