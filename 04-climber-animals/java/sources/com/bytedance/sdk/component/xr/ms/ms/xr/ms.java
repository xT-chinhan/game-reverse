package com.bytedance.sdk.component.xr.ms.ms.xr;

import android.text.TextUtils;
import com.bytedance.sdk.component.ah.xr.le;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.xr.ms.ao;
import com.bytedance.sdk.component.xr.ms.ny;
import com.bytedance.sdk.component.xr.ms.u;
import com.bytedance.sdk.component.xr.ms.ub;
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
public class ms implements com.bytedance.sdk.component.xr.ms.xr {
    private volatile boolean c;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    u f1614ms;
    d xr;
    private AtomicBoolean ka = new AtomicBoolean(false);
    final String ah = com.bytedance.sdk.component.xr.ms.xr.d.ms(UUID.randomUUID().toString()).ms();
    le d = new le();

    ms(u uVar, d dVar) {
        this.f1614ms = uVar;
        this.xr = dVar;
    }

    @Override // com.bytedance.sdk.component.xr.ms.xr
    public void ms(com.bytedance.sdk.component.xr.ms.ah ahVar) {
        try {
            synchronized (this) {
                if (this.c) {
                    throw new IllegalStateException("Already Executed");
                }
                this.c = true;
            }
            this.xr.ms(new C0258ms(ahVar, this));
        } catch (Throwable th) {
            if (ahVar != null) {
                ahVar.onFailure(this, new IOException(th.getMessage()));
            }
        }
    }

    @Override // com.bytedance.sdk.component.xr.ms.xr
    public ao ms() throws IOException {
        synchronized (this) {
            if (this.c) {
                throw new IllegalStateException("Already Executed");
            }
            this.c = true;
        }
        try {
            this.xr.ms(this);
            return d();
        } finally {
            this.xr.xr(this);
        }
    }

    public ao d() {
        if (this.ka.get()) {
            return null;
        }
        try {
            if (this.f1614ms.f1621ms != null && this.f1614ms.f1621ms.f1618ms != null && this.f1614ms.f1621ms.f1618ms.size() > 0) {
                ArrayList arrayList = new ArrayList(this.f1614ms.f1621ms.f1618ms);
                arrayList.add(new ny() { // from class: com.bytedance.sdk.component.xr.ms.ms.xr.ms.1
                    @Override // com.bytedance.sdk.component.xr.ms.ny
                    public ao ms(ny.ms msVar) throws IOException {
                        return ms.this.ms(msVar.ms());
                    }
                });
                return ((ny) arrayList.get(0)).ms(new xr(arrayList, this.f1614ms));
            }
            return ms(this.f1614ms);
        } catch (Throwable unused) {
            return null;
        }
    }

    public ao ms(u uVar) throws IOException {
        try {
            le leVar = this.d;
            if (leVar != null) {
                leVar.xr();
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(uVar.xr().ms().toString()).openConnection();
            if (uVar.d() != null && uVar.d().size() > 0) {
                for (Map.Entry<String, List<String>> entry : uVar.d().entrySet()) {
                    Iterator<String> it = entry.getValue().iterator();
                    while (it.hasNext()) {
                        httpURLConnection.addRequestProperty(entry.getKey(), it.next());
                    }
                }
            }
            if (uVar.f1621ms != null) {
                if (uVar.f1621ms.ah != null) {
                    httpURLConnection.setConnectTimeout((int) uVar.f1621ms.ah.toMillis(uVar.f1621ms.xr));
                }
                if (uVar.f1621ms.ka != null) {
                    httpURLConnection.setReadTimeout((int) uVar.f1621ms.ka.toMillis(uVar.f1621ms.d));
                }
            }
            if (uVar.c() == null) {
                httpURLConnection.setRequestMethod("GET");
            } else {
                if (!c() && uVar.c().ah != null) {
                    httpURLConnection.addRequestProperty("Content-Type", uVar.c().ah.toString());
                }
                httpURLConnection.setRequestMethod(uVar.ah());
                if (ms(uVar.c())) {
                    ms(httpURLConnection);
                }
                if ("POST".equalsIgnoreCase(uVar.ah())) {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    if (ah(uVar.c())) {
                        outputStream.write(uVar.c().d.getBytes());
                    } else if (ms(uVar.c())) {
                        ms(uVar.c().ka, outputStream, uVar.c().xr(), uVar.c().ms());
                    } else if (xr(uVar.c())) {
                        outputStream.write(uVar.c().ka);
                    }
                    outputStream.flush();
                    outputStream.close();
                }
            }
            httpURLConnection.connect();
            long jCurrentTimeMillis = System.currentTimeMillis();
            le leVar2 = this.d;
            if (leVar2 != null) {
                leVar2.ah();
                this.d.ms(jCurrentTimeMillis);
            }
            httpURLConnection.getResponseCode();
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            if (this.ka.get()) {
                httpURLConnection.disconnect();
                return null;
            }
            c cVar = new c(httpURLConnection, uVar);
            cVar.d = jCurrentTimeMillis;
            cVar.ah = jCurrentTimeMillis2;
            le leVar3 = this.d;
            if (leVar3 != null) {
                leVar3.xr(jCurrentTimeMillis2);
            }
            cVar.ka = this.d;
            return cVar;
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private void ms(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + this.ah);
    }

    private void ms(byte[] bArr, OutputStream outputStream, String str, String str2) throws IOException {
        if (bArr == null || outputStream == null) {
            return;
        }
        PrintWriter printWriter = new PrintWriter((Writer) new OutputStreamWriter(outputStream, "UTF-8"), true);
        printWriter.append((CharSequence) ("--" + this.ah)).append((CharSequence) "\r\n");
        printWriter.append((CharSequence) ("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"")).append((CharSequence) "\r\n");
        printWriter.append((CharSequence) "Content-Type: multipart/form-data").append((CharSequence) "\r\n");
        printWriter.append((CharSequence) ("Content-Length: " + bArr.length)).append((CharSequence) "\r\n");
        printWriter.append((CharSequence) "\r\n");
        printWriter.flush();
        outputStream.write(bArr);
        printWriter.append((CharSequence) "\r\n");
        printWriter.append((CharSequence) ("--" + this.ah + "--")).append((CharSequence) "\r\n");
        printWriter.flush();
        printWriter.close();
    }

    private boolean ms(ub ubVar) {
        u uVar;
        return ubVar != null && (uVar = this.f1614ms) != null && "POST".equalsIgnoreCase(uVar.ah()) && ubVar.c == ub.ms.FILE_TYPE && ubVar.ka != null && ubVar.ka.length > 0;
    }

    private boolean xr(ub ubVar) {
        u uVar;
        return ubVar != null && (uVar = this.f1614ms) != null && "POST".equalsIgnoreCase(uVar.ah()) && ubVar.c == ub.ms.BYTE_ARRAY_TYPE && ubVar.ka != null && ubVar.ka.length > 0;
    }

    private boolean ah(ub ubVar) {
        u uVar;
        return (ubVar == null || (uVar = this.f1614ms) == null || !"POST".equalsIgnoreCase(uVar.ah()) || ubVar.c != ub.ms.STRING_TYPE || TextUtils.isEmpty(ubVar.d)) ? false : true;
    }

    private boolean c() {
        if (this.f1614ms.d() == null) {
            return false;
        }
        return this.f1614ms.d().containsKey("Content-Type");
    }

    @Override // com.bytedance.sdk.component.xr.ms.xr
    public void xr() {
        this.ka.set(true);
    }

    /* JADX INFO: renamed from: ka, reason: merged with bridge method [inline-methods] */
    public com.bytedance.sdk.component.xr.ms.xr clone() {
        return new ms(this.f1614ms, this.xr);
    }

    @Override // com.bytedance.sdk.component.xr.ms.xr
    public boolean ah() {
        return this.ka.get();
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.xr.ms.ms.xr.ms$ms, reason: collision with other inner class name */
    final class C0258ms extends com.bytedance.sdk.component.xr.ms.xr.ka {
        private final com.bytedance.sdk.component.xr.ms.ah ah;
        private final ms d;

        C0258ms(com.bytedance.sdk.component.xr.ms.ah ahVar, ms msVar) {
            super("net-async-call", new Object[0]);
            this.ah = ahVar;
            this.d = msVar;
        }

        public void ms() {
            ms msVar = this.d;
            if (msVar == null || msVar.d == null) {
                return;
            }
            this.d.d.hi();
        }

        @Override // com.bytedance.sdk.component.xr.ms.xr.ka
        protected void xr() {
            try {
                ms msVar = this.d;
                if (msVar != null && msVar.d != null) {
                    this.d.d.ms();
                }
                ao aoVarD = ms.this.d();
                if (aoVarD == null) {
                    this.ah.onFailure(ms.this, new IOException("response is null"));
                } else {
                    this.ah.onResponse(ms.this, aoVarD);
                }
                try {
                    this.d.xr.xr(this);
                } catch (Throwable th) {
                    sl.ms(th);
                }
            } catch (Throwable th2) {
                try {
                    if (th2 instanceof IOException) {
                        this.ah.onFailure(ms.this, th2);
                    } else {
                        this.ah.onFailure(ms.this, new IOException(th2));
                    }
                } finally {
                    try {
                        this.d.xr.xr(this);
                    } catch (Throwable th3) {
                        sl.ms(th3);
                    }
                }
            }
        }
    }
}
