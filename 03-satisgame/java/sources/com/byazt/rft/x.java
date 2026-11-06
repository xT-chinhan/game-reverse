package com.byazt.rft;

import com.byazt.tbt.hd;
import com.byazt.tbt.tj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVPH_PARAMS, 21})
public class x extends hd {
    public HttpURLConnection n;
    public InputStream qg;

    public x(HttpURLConnection httpURLConnection) throws IOException {
        this.n = httpURLConnection;
        this.qg = new l(httpURLConnection.getInputStream(), httpURLConnection);
    }

    @Override // com.byazt.tbt.hd
    public long n() {
        try {
            return this.n.getContentLength();
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.byazt.tbt.hd
    public String qg() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.qg));
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

    @Override // com.byazt.tbt.hd, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.qg.close();
            this.n.disconnect();
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.tbt.hd
    public InputStream s() {
        return this.qg;
    }

    @Override // com.byazt.tbt.hd
    public byte[] q() throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byte[] bArr = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            while (true) {
                try {
                    int i = this.qg.read(bArr);
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

    @Override // com.byazt.tbt.hd
    public tj l() {
        if (this.n.getContentType() != null) {
            return tj.n(this.n.getContentType());
        }
        return null;
    }
}
