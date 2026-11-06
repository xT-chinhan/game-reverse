package ms.bz.bd.c.Pgl;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes3.dex */
public final class l1 extends pblr {
    private SSLSocketFactory n;

    /* JADX WARN: Code duplicated, block: B:119:0x0579 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:0x053f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x04f0 A[Catch: all -> 0x056a, TryCatch #5 {all -> 0x056a, blocks: (B:78:0x04c6, B:80:0x04f0, B:82:0x0534), top: B:114:0x04c6 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x0533  */
    private Object[] n(String str, byte[] bArr, String str2, String str3, String str4, boolean z) throws Throwable {
        HttpURLConnection httpURLConnection;
        int responseCode;
        DataOutputStream dataOutputStream;
        BufferedInputStream bufferedInputStream;
        BufferedInputStream bufferedInputStream2;
        BufferedInputStream bufferedInputStream3;
        String headerField;
        byte[] bArr2;
        byte[] byteArray;
        BufferedInputStream bufferedInputStream4;
        pbla.pgla pglaVar = new pbla.pgla();
        int i = -1;
        DataOutputStream dataOutputStream2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection instanceof HttpsURLConnection) {
                try {
                    try {
                        if (this.n == null) {
                            try {
                                synchronized (l1.class) {
                                    if (this.n == null) {
                                        SSLContext sSLContext = SSLContext.getInstance((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3c5c80", new byte[]{22, 77, 117}));
                                        sSLContext.init(null, null, null);
                                        this.n = sSLContext.getSocketFactory();
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                bufferedInputStream = null;
                                dataOutputStream = dataOutputStream2;
                                bufferedInputStream3 = bufferedInputStream;
                                pblr.n(bufferedInputStream3);
                                pblr.n(dataOutputStream);
                                if (httpURLConnection != null) {
                                    try {
                                        httpURLConnection.disconnect();
                                    } catch (Exception unused) {
                                        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b58599", new byte[]{96, com.anythink.core.common.r.a.c.c, 72, 126, 14, com.anythink.core.common.r.a.c.c, 51});
                                    }
                                }
                                throw th;
                            }
                        }
                        SSLSocketFactory sSLSocketFactory = this.n;
                        if (sSLSocketFactory != null) {
                            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
                        }
                    } catch (Exception unused2) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    dataOutputStream2 = null;
                    bufferedInputStream = null;
                    dataOutputStream = dataOutputStream2;
                    bufferedInputStream3 = bufferedInputStream;
                    pblr.n(bufferedInputStream3);
                    pblr.n(dataOutputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            }
            try {
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setRequestProperty((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e5ba31", new byte[]{85, 52, 18, 16, 28, 50}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "99af7b", new byte[]{98, 116, 88}));
                httpURLConnection.setRequestProperty((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "69bfeb", new byte[]{4, 52, 31, 28, 95, 118, 33, 17, 60, 56}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "89ea2b", new byte[]{2, 62, 19, 5, com.anythink.core.common.r.a.c.b, 84, 55, 17, 34, 52}));
                httpURLConnection.setRequestProperty((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c8ba12", new byte[]{71, 41, 20, 7, 67, 4, 103, 28, 61, 37}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b72591", new byte[]{81, 44, 85, 68, 34, 39, 111, 21, 102, 40, 94, 6, 114, 101, 45}));
                httpURLConnection.setRequestProperty((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "01ff86", new byte[]{2, 60, 27, 6, 2, 47, 39, 93, 3, 47, 49, 54}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c3ffb2", new byte[]{115, 33, 5, 30, 84, 38, 97, 6, 62, 57, 124, 126, 26, 17, 73, 32, 116, 95, 36, 34, 96, 52, 20, 31}));
                if (str2 != null && str2.trim().length() > 0) {
                    httpURLConnection.setRequestProperty((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2cc815", new byte[]{0, 110, 31, 71, 7, 39}), String.format((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "522c6f", new byte[]{55, 53, 82, 4, 0, 126, 56, 26, 103, 110, 97, 35}), str2));
                }
                if (str3 != null && str3.trim().length() > 0) {
                    httpURLConnection.setRequestProperty((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1449ba", new byte[]{56, 123, 83, 89, 16, 100, 55, 4, 112, 108, 51, 34, 10, 89, 92, 113}), str3);
                }
                pglaVar.n(str);
                if (z) {
                    httpURLConnection.setRequestMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0af7c7", new byte[]{17, 76, 38, 119}));
                    httpURLConnection.setDoOutput(true);
                    dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                    try {
                        try {
                            dataOutputStream.write(bArr);
                            dataOutputStream.flush();
                        } catch (Exception unused3) {
                            responseCode = i;
                            bufferedInputStream2 = null;
                            try {
                                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f2b06d", new byte[]{100, 56, 18, 123, 1, 98});
                                if (httpURLConnection != null) {
                                    headerField = httpURLConnection.getHeaderField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1bcdf0", new byte[]{56, 45, 4, 4, 20, 43, 61, 68, 59, 48}));
                                } else {
                                    headerField = null;
                                }
                                pglaVar.qg(headerField, responseCode);
                                pblr.n(bufferedInputStream2);
                                pblr.n(dataOutputStream);
                                if (httpURLConnection != null) {
                                    try {
                                        httpURLConnection.disconnect();
                                    } catch (Exception unused4) {
                                        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7f9c47", new byte[]{53, 108, 73, 40, 3, 49, 102});
                                    }
                                }
                                bArr2 = null;
                                return new Object[]{String.valueOf(responseCode), bArr2};
                            } catch (Throwable th3) {
                                th = th3;
                                dataOutputStream2 = dataOutputStream;
                                bufferedInputStream = bufferedInputStream2;
                                dataOutputStream = dataOutputStream2;
                                bufferedInputStream3 = bufferedInputStream;
                                pblr.n(bufferedInputStream3);
                                pblr.n(dataOutputStream);
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedInputStream3 = null;
                        pblr.n(bufferedInputStream3);
                        pblr.n(dataOutputStream);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } else {
                    dataOutputStream = null;
                }
                responseCode = httpURLConnection.getResponseCode();
                try {
                    pglaVar.n(httpURLConnection.getHeaderField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7c064c", new byte[]{62, 44, 87, 86, 70, 120, 59, 69, 104, 98})), responseCode);
                    if (responseCode == 200) {
                        bufferedInputStream2 = new BufferedInputStream(httpURLConnection.getInputStream());
                        try {
                            OutputStream fileOutputStream = str4 != null ? new FileOutputStream(str4) : new ByteArrayOutputStream();
                            byte[] bArr3 = new byte[256];
                            while (true) {
                                int i2 = bufferedInputStream2.read(bArr3);
                                if (i2 <= 0) {
                                    break;
                                }
                                fileOutputStream.write(bArr3, 0, i2);
                            }
                            fileOutputStream.flush();
                            byteArray = fileOutputStream instanceof ByteArrayOutputStream ? ((ByteArrayOutputStream) fileOutputStream).toByteArray() : null;
                            fileOutputStream.close();
                            bufferedInputStream4 = bufferedInputStream2;
                        } catch (Exception unused5) {
                            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f2b06d", new byte[]{100, 56, 18, 123, 1, 98});
                            if (httpURLConnection != null) {
                                headerField = httpURLConnection.getHeaderField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1bcdf0", new byte[]{56, 45, 4, 4, 20, 43, 61, 68, 59, 48}));
                            } else {
                                headerField = null;
                            }
                            pglaVar.qg(headerField, responseCode);
                            pblr.n(bufferedInputStream2);
                            pblr.n(dataOutputStream);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            bArr2 = null;
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedInputStream3 = bufferedInputStream2;
                            pblr.n(bufferedInputStream3);
                            pblr.n(dataOutputStream);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    } else {
                        byteArray = null;
                        bufferedInputStream4 = null;
                    }
                    pblr.n(bufferedInputStream4);
                    pblr.n(dataOutputStream);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception unused6) {
                        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d28a4d", new byte[]{102, 56, 72, 42, 3, 98, 53});
                    }
                    bArr2 = byteArray;
                } catch (Exception unused7) {
                    i = responseCode;
                    responseCode = i;
                    bufferedInputStream2 = null;
                    com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f2b06d", new byte[]{100, 56, 18, 123, 1, 98});
                    if (httpURLConnection != null) {
                        headerField = httpURLConnection.getHeaderField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1bcdf0", new byte[]{56, 45, 4, 4, 20, 43, 61, 68, 59, 48}));
                    } else {
                        headerField = null;
                    }
                    pglaVar.qg(headerField, responseCode);
                    pblr.n(bufferedInputStream2);
                    pblr.n(dataOutputStream);
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    bArr2 = null;
                    return new Object[]{String.valueOf(responseCode), bArr2};
                }
            } catch (Exception unused8) {
                responseCode = -1;
                dataOutputStream = null;
                bufferedInputStream2 = null;
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f2b06d", new byte[]{100, 56, 18, 123, 1, 98});
                if (httpURLConnection != null) {
                    headerField = httpURLConnection.getHeaderField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1bcdf0", new byte[]{56, 45, 4, 4, 20, 43, 61, 68, 59, 48}));
                } else {
                    headerField = null;
                }
                pglaVar.qg(headerField, responseCode);
                pblr.n(bufferedInputStream2);
                pblr.n(dataOutputStream);
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                bArr2 = null;
                return new Object[]{String.valueOf(responseCode), bArr2};
            }
        } catch (Exception unused9) {
            httpURLConnection = null;
        } catch (Throwable th6) {
            th = th6;
            httpURLConnection = null;
        }
        return new Object[]{String.valueOf(responseCode), bArr2};
    }

    @Override // ms.bz.bd.c.Pgl.pblr
    public final Object[] n(String str, String str2, String str3) {
        return n(str, null, str2, str3, null, false);
    }

    @Override // ms.bz.bd.c.Pgl.pblr
    public final Object[] n(String str, byte[] bArr, String str2, String str3) {
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "362732", new byte[]{17, 45, 82, 87, 9, 40, 24, 3, 119, 119, 1, 56, 72, 70, 2, 49, 112, 2, 113, 107, 98, 121, 12, 14, 76});
        return n(str, bArr, str2, str3, null, true);
    }

    @Override // ms.bz.bd.c.Pgl.pblr
    public final Object[] qg(String str, String str2, String str3) {
        return n(str, null, null, str3, str2, false);
    }
}
