package com.bytedance.sdk.component.xr.ms.ms.xr;

import com.bytedance.sdk.component.xr.ms.ch;
import com.bytedance.sdk.component.xr.ms.h;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes2.dex */
public class ab extends h {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    HttpURLConnection f1609ms;
    InputStream xr;

    ab(HttpURLConnection httpURLConnection) throws IOException {
        this.f1609ms = httpURLConnection;
        this.xr = new ka(httpURLConnection.getInputStream(), httpURLConnection);
    }

    @Override // com.bytedance.sdk.component.xr.ms.h
    public long ms() {
        try {
            return this.f1609ms.getContentLength();
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.bytedance.sdk.component.xr.ms.h
    public String xr() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.xr));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    stringBuffer.append(line + "\n");
                } else {
                    String string = stringBuffer.toString();
                    close();
                    return string;
                }
            }
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.bytedance.sdk.component.xr.ms.h, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.xr.close();
            this.f1609ms.disconnect();
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.xr.ms.h
    public InputStream ah() {
        return this.xr;
    }

    @Override // com.bytedance.sdk.component.xr.ms.h
    public byte[] d() throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            while (true) {
                try {
                    int i = this.xr.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    byteArrayOutputStream2.write(bArr, 0, i);
                } catch (Exception unused) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    return new byte[0];
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    throw th;
                }
            }
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            try {
                byteArrayOutputStream2.close();
            } catch (Throwable unused4) {
            }
            return byteArray;
        } catch (Exception unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.bytedance.sdk.component.xr.ms.h
    public ch ka() {
        if (this.f1609ms.getContentType() != null) {
            return ch.ms(this.f1609ms.getContentType());
        }
        return null;
    }
}
