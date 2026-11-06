package com.anythink.core.common.m.a.a;

import android.text.TextUtils;
import com.anythink.core.common.m.a.i;
import com.anythink.core.common.m.a.j;
import com.efs.sdk.base.Constants;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes.dex */
public final class b extends com.anythink.core.common.m.a.a {
    private static final String b = "POST";
    private static final String c = "GET";
    private boolean d;

    @Override // com.anythink.core.common.m.a.b
    public final void a(i iVar, com.anythink.core.common.m.a.c cVar) {
    }

    public b(com.anythink.core.common.m.a.f fVar) {
        super(fVar);
    }

    @Override // com.anythink.core.common.m.a.b
    public final j a(i iVar) {
        return b(iVar);
    }

    @Override // com.anythink.core.common.m.a.b
    public final void a() {
        this.d = true;
    }

    /* JADX WARN: Code duplicated, block: B:66:0x012f A[Catch: all -> 0x0132, TRY_LEAVE, TryCatch #0 {all -> 0x0132, blocks: (B:64:0x012a, B:66:0x012f), top: B:71:0x012a }] */
    private j b(i iVar) {
        HttpURLConnection httpURLConnection;
        byte[] bArr;
        j.a aVarA = new j.a().a(iVar);
        InputStream inputStream = null;
        try {
            if (this.d) {
                aVarA.a(new InterruptedException("canceled"));
                return aVarA.a();
            }
            httpURLConnection = (HttpURLConnection) new URL(iVar.a).openConnection();
            try {
                String str = iVar.b;
                if (TextUtils.isEmpty(str)) {
                    str = "GET";
                }
                httpURLConnection.setRequestMethod(str);
                if ("POST".equals(str)) {
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setUseCaches(false);
                } else if ("GET".equals(str)) {
                    httpURLConnection.setInstanceFollowRedirects(false);
                }
                httpURLConnection.setConnectTimeout((int) this.a.e);
                httpURLConnection.setReadTimeout((int) this.a.a);
                if (iVar.e != null && !iVar.e.isEmpty()) {
                    for (Map.Entry<String, String> entry : iVar.e.entrySet()) {
                        httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection.connect();
                if ("POST".equals(str) && (bArr = iVar.c) != null) {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    outputStream.write(bArr);
                    outputStream.flush();
                    outputStream.close();
                }
                int responseCode = httpURLConnection.getResponseCode();
                aVarA.a(responseCode);
                if (responseCode != 200) {
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        if (!this.d) {
                            String headerField = httpURLConnection.getHeaderField("Location");
                            if (headerField != null && headerField.toLowerCase().startsWith("http")) {
                                iVar.a = headerField;
                                httpURLConnection.disconnect();
                                return b(iVar);
                            }
                        } else {
                            aVarA.a(new InterruptedException("canceled"));
                        }
                    } else {
                        aVarA.a(httpURLConnection.getHeaderFields());
                    }
                    httpURLConnection.disconnect();
                    return aVarA.a();
                }
                if (this.d) {
                    aVarA.a(new InterruptedException("canceled"));
                    httpURLConnection.disconnect();
                    return aVarA.a();
                }
                aVarA.a(new c(httpURLConnection, a(httpURLConnection)));
                return aVarA.a();
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        inputStream.close();
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (Throwable unused) {
                        aVarA.a(th);
                        return aVarA.a();
                    }
                } else if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                aVarA.a(th);
            }
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
        }
    }

    private static InputStream a(HttpURLConnection httpURLConnection) {
        InputStream inputStream = null;
        if (httpURLConnection == null) {
            return null;
        }
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (Exception unused) {
        }
        if (!Constants.CP_GZIP.equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"))) {
            return inputStream;
        }
        try {
            byte[] bArr = new byte[2];
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedInputStream.mark(2);
            int i = bufferedInputStream.read(bArr);
            bufferedInputStream.reset();
            return (i == -1 || (((bArr[1] & UByte.MAX_VALUE) << 8) | (bArr[0] & UByte.MAX_VALUE)) != 35615) ? bufferedInputStream : new GZIPInputStream(bufferedInputStream);
        } catch (Exception unused2) {
            return inputStream;
        }
    }
}
