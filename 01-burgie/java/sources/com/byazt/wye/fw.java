package com.byazt.wye;

import com.byazt.nzn.vk;
import com.byazt.nzn.yb;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1008, 62})
public class fw extends yb {
    public InputStream hw;
    public HttpURLConnection pr;

    public fw(HttpURLConnection httpURLConnection) throws IOException {
        this.pr = httpURLConnection;
        this.hw = new c(httpURLConnection.getInputStream(), httpURLConnection);
    }

    @Override // com.byazt.nzn.yb
    public long pr() {
        try {
            return this.pr.getContentLength();
        } catch (Exception e) {
            return 0L;
        }
    }

    @Override // com.byazt.nzn.yb
    public String hw() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.hw));
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
        } catch (Exception e) {
            return "";
        }
    }

    @Override // com.byazt.nzn.yb, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.hw.close();
            this.pr.disconnect();
        } catch (Exception e) {
        }
    }

    @Override // com.byazt.nzn.yb
    public InputStream hn() {
        return this.hw;
    }

    @Override // com.byazt.nzn.yb
    public byte[] x() throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            while (true) {
                try {
                    int i = this.hw.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    byteArrayOutputStream2.write(bArr, 0, i);
                } catch (Exception e) {
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th) {
                        }
                    }
                    return new byte[0];
                } catch (Throwable th2) {
                    th = th2;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    if (byteArrayOutputStream != null) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th3) {
                        }
                    }
                    throw th;
                }
            }
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            try {
                byteArrayOutputStream2.close();
            } catch (Throwable th4) {
            }
            return byteArray;
        } catch (Exception e2) {
        } catch (Throwable th5) {
            th = th5;
        }
    }

    @Override // com.byazt.nzn.yb
    public vk c() {
        if (this.pr.getContentType() != null) {
            return vk.pr(this.pr.getContentType());
        }
        return null;
    }
}
