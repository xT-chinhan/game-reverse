package ms.bz.bd.c.Pgl;

import android.os.Build;
import com.umeng.analytics.pro.cc;
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
    private SSLSocketFactory pr;

    /* JADX WARN: Code duplicated, block: B:111:0x056a A[Catch: all -> 0x05e7, TryCatch #2 {all -> 0x05e7, blocks: (B:109:0x053c, B:111:0x056a, B:113:0x05b0), top: B:135:0x053c }] */
    /* JADX WARN: Code duplicated, block: B:112:0x05af  */
    /* JADX WARN: Code duplicated, block: B:141:0x05bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:145:0x05f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:161:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v47 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.DataOutputStream] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r8v29 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v52 */
    /* JADX WARN: Type inference failed for: r8v53 */
    /* JADX WARN: Type inference failed for: r8v54 */
    /* JADX WARN: Type inference failed for: r8v55 */
    private Object[] pr(String str, byte[] bArr, String str2, String str3, String str4, boolean z) throws Throwable {
        Throwable th;
        ?? r8;
        ?? r12;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        int responseCode;
        DataOutputStream dataOutputStream;
        BufferedInputStream bufferedInputStream;
        ?? r9;
        ?? r2;
        String headerField;
        byte[] bArr2;
        ?? r15;
        Throwable th2;
        Object objA;
        byte[] byteArray;
        BufferedInputStream bufferedInputStream2;
        pbla.pgla pglaVar = new pbla.pgla();
        char c = 7;
        int i = -1;
        try {
            httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection2 instanceof HttpsURLConnection) {
                try {
                    try {
                        if (this.pr == null) {
                            try {
                                try {
                                    synchronized (l1.class) {
                                        try {
                                            if (this.pr == null) {
                                                if (Build.VERSION.SDK_INT >= 20) {
                                                    try {
                                                        objA = com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3c5c80", new byte[]{22, 77, 117});
                                                    } catch (Throwable th3) {
                                                        th2 = th3;
                                                        r15 = 0;
                                                        throw th2;
                                                    }
                                                } else {
                                                    objA = com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e3505e", new byte[]{64, 29, 117, 82, 91, 60, 52});
                                                }
                                                SSLContext sSLContext = SSLContext.getInstance((String) objA);
                                                sSLContext.init(null, null, null);
                                                this.pr = sSLContext.getSocketFactory();
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            c = 0;
                                            th2 = th;
                                            r15 = c;
                                        }
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                r15 = 0;
                                th = th;
                                httpURLConnection = httpURLConnection2;
                                ?? r10 = r15;
                                r12 = r10;
                                r8 = r10;
                                r2 = r12;
                                httpURLConnection2 = httpURLConnection;
                                r9 = r8;
                                pblr.pr((BufferedInputStream) r9);
                                pblr.pr((DataOutputStream) r2);
                                if (httpURLConnection2 == null) {
                                    throw th;
                                }
                                try {
                                    httpURLConnection2.disconnect();
                                    throw th;
                                } catch (Exception e) {
                                    com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b58599", new byte[]{96, 63, 72, 126, cc.l, 63, 51});
                                    throw th;
                                }
                            }
                            try {
                                throw th2;
                            } catch (Throwable th7) {
                                th = th7;
                                th = th;
                                httpURLConnection = httpURLConnection2;
                                ?? r11 = r15;
                                r12 = r11;
                                r8 = r11;
                                r2 = r12;
                                httpURLConnection2 = httpURLConnection;
                                r9 = r8;
                                pblr.pr((BufferedInputStream) r9);
                                pblr.pr((DataOutputStream) r2);
                                if (httpURLConnection2 == null) {
                                    throw th;
                                }
                                httpURLConnection2.disconnect();
                                throw th;
                            }
                        }
                        SSLSocketFactory n1Var = this.pr;
                        if (n1Var != null) {
                            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection2;
                            if (Build.VERSION.SDK_INT < 20) {
                                n1Var = new n1(this.pr);
                            }
                            httpsURLConnection.setSSLSocketFactory(n1Var);
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        httpURLConnection = httpURLConnection2;
                        r8 = 0;
                        r12 = 0;
                    }
                } catch (Exception e2) {
                }
            }
            try {
                httpURLConnection2.setConnectTimeout(10000);
                httpURLConnection2.setReadTimeout(5000);
                httpURLConnection2.setRequestProperty((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e5ba31", new byte[]{85, 52, 18, cc.n, 28, 50}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "99af7b", new byte[]{98, 116, 88}));
                httpURLConnection2.setRequestProperty((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "69bfeb", new byte[]{4, 52, 31, 28, 95, 118, 33, 17, 60, 56}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "89ea2b", new byte[]{2, 62, 19, 5, 64, 84, 55, 17, 34, 52}));
                httpURLConnection2.setRequestProperty((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c8ba12", new byte[]{71, 41, 20, 7, 67, 4, 103, 28, 61, 37}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b72591", new byte[]{81, 44, 85, 68, 34, 39, 111, 21, 102, 40, 94, 6, 114, 101, 45}));
                httpURLConnection2.setRequestProperty((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "01ff86", new byte[]{2, 60, 27, 6, 2, 47, 39, 93, 3, 47, 49, 54}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c3ffb2", new byte[]{115, 33, 5, 30, 84, 38, 97, 6, 62, 57, 124, 126, 26, 17, 73, 32, 116, 95, 36, 34, 96, 52, 20, 31}));
                if (str2 != null && str2.trim().length() > 0) {
                    httpURLConnection2.setRequestProperty((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2cc815", new byte[]{0, 110, 31, 71, 7, 39}), String.format((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "522c6f", new byte[]{55, 53, 82, 4, 0, 126, 56, 26, 103, 110, 97, 35}), str2));
                }
                if (str3 != null && str3.trim().length() > 0) {
                    httpURLConnection2.setRequestProperty((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1449ba", new byte[]{56, 123, 83, 89, cc.n, 100, 55, 4, 112, 108, 51, 34, 10, 89, 92, 113}), str3);
                }
                pglaVar.pr(str);
                if (z) {
                    httpURLConnection2.setRequestMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0af7c7", new byte[]{17, 76, 38, 119}));
                    httpURLConnection2.setDoOutput(true);
                    dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                    try {
                        try {
                            dataOutputStream.write(bArr);
                            dataOutputStream.flush();
                            dataOutputStream = dataOutputStream;
                        } catch (Exception e3) {
                            responseCode = i;
                            dataOutputStream = dataOutputStream;
                            bufferedInputStream = null;
                            try {
                                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f2b06d", new byte[]{100, 56, 18, 123, 1, 98});
                                if (httpURLConnection2 != null) {
                                    headerField = httpURLConnection2.getHeaderField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1bcdf0", new byte[]{56, 45, 4, 4, 20, 43, 61, 68, 59, 48}));
                                } else {
                                    headerField = null;
                                }
                                pglaVar.hw(headerField, responseCode);
                                pblr.pr(bufferedInputStream);
                                pblr.pr(dataOutputStream);
                                if (httpURLConnection2 != null) {
                                    try {
                                        httpURLConnection2.disconnect();
                                    } catch (Exception e4) {
                                        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7f9c47", new byte[]{53, 108, 73, 40, 3, 49, 102});
                                    }
                                }
                                bArr2 = null;
                                return new Object[]{String.valueOf(responseCode), bArr2};
                            } catch (Throwable th9) {
                                th = th9;
                                httpURLConnection = httpURLConnection2;
                                r12 = dataOutputStream;
                                r8 = bufferedInputStream;
                                r2 = r12;
                                httpURLConnection2 = httpURLConnection;
                                r9 = r8;
                                pblr.pr((BufferedInputStream) r9);
                                pblr.pr((DataOutputStream) r2);
                                if (httpURLConnection2 == null) {
                                    throw th;
                                }
                                httpURLConnection2.disconnect();
                                throw th;
                            }
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        r9 = 0;
                        r2 = dataOutputStream;
                        pblr.pr((BufferedInputStream) r9);
                        pblr.pr((DataOutputStream) r2);
                        if (httpURLConnection2 == null) {
                            throw th;
                        }
                        httpURLConnection2.disconnect();
                        throw th;
                    }
                } else {
                    dataOutputStream = null;
                }
                responseCode = httpURLConnection2.getResponseCode();
                try {
                    pglaVar.pr(httpURLConnection2.getHeaderField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7c064c", new byte[]{62, 44, 87, 86, 70, 120, 59, 69, 104, 98})), responseCode);
                    if (responseCode == 200) {
                        bufferedInputStream = new BufferedInputStream(httpURLConnection2.getInputStream());
                        try {
                            OutputStream fileOutputStream = str4 != null ? new FileOutputStream(str4) : new ByteArrayOutputStream();
                            byte[] bArr3 = new byte[256];
                            while (true) {
                                int i2 = bufferedInputStream.read(bArr3);
                                if (i2 <= 0) {
                                    break;
                                }
                                fileOutputStream.write(bArr3, 0, i2);
                            }
                            fileOutputStream.flush();
                            byteArray = fileOutputStream instanceof ByteArrayOutputStream ? ((ByteArrayOutputStream) fileOutputStream).toByteArray() : null;
                            fileOutputStream.close();
                            bufferedInputStream2 = bufferedInputStream;
                        } catch (Exception e5) {
                            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f2b06d", new byte[]{100, 56, 18, 123, 1, 98});
                            if (httpURLConnection2 != null) {
                                headerField = httpURLConnection2.getHeaderField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1bcdf0", new byte[]{56, 45, 4, 4, 20, 43, 61, 68, 59, 48}));
                            } else {
                                headerField = null;
                            }
                            pglaVar.hw(headerField, responseCode);
                            pblr.pr(bufferedInputStream);
                            pblr.pr(dataOutputStream);
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                            }
                            bArr2 = null;
                        } catch (Throwable th11) {
                            th = th11;
                            r2 = dataOutputStream;
                            r9 = bufferedInputStream;
                            pblr.pr((BufferedInputStream) r9);
                            pblr.pr((DataOutputStream) r2);
                            if (httpURLConnection2 == null) {
                                throw th;
                            }
                            httpURLConnection2.disconnect();
                            throw th;
                        }
                    } else {
                        byteArray = null;
                        bufferedInputStream2 = null;
                    }
                    pblr.pr(bufferedInputStream2);
                    pblr.pr(dataOutputStream);
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Exception e6) {
                        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d28a4d", new byte[]{102, 56, 72, 42, 3, 98, 53});
                    }
                    bArr2 = byteArray;
                } catch (Exception e7) {
                    i = responseCode;
                    responseCode = i;
                    dataOutputStream = dataOutputStream;
                    bufferedInputStream = null;
                    com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f2b06d", new byte[]{100, 56, 18, 123, 1, 98});
                    if (httpURLConnection2 != null) {
                        headerField = httpURLConnection2.getHeaderField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1bcdf0", new byte[]{56, 45, 4, 4, 20, 43, 61, 68, 59, 48}));
                    } else {
                        headerField = null;
                    }
                    pglaVar.hw(headerField, responseCode);
                    pblr.pr(bufferedInputStream);
                    pblr.pr(dataOutputStream);
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    bArr2 = null;
                    return new Object[]{String.valueOf(responseCode), bArr2};
                }
            } catch (Exception e8) {
                responseCode = -1;
                dataOutputStream = null;
                bufferedInputStream = null;
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f2b06d", new byte[]{100, 56, 18, 123, 1, 98});
                if (httpURLConnection2 != null) {
                    headerField = httpURLConnection2.getHeaderField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1bcdf0", new byte[]{56, 45, 4, 4, 20, 43, 61, 68, 59, 48}));
                } else {
                    headerField = null;
                }
                pglaVar.hw(headerField, responseCode);
                pblr.pr(bufferedInputStream);
                pblr.pr(dataOutputStream);
                if (httpURLConnection2 != null) {
                    httpURLConnection2.disconnect();
                }
                bArr2 = null;
                return new Object[]{String.valueOf(responseCode), bArr2};
            }
        } catch (Exception e9) {
            httpURLConnection2 = null;
        } catch (Throwable th12) {
            th = th12;
            r8 = 0;
            r12 = 0;
            httpURLConnection = null;
        }
        return new Object[]{String.valueOf(responseCode), bArr2};
    }

    @Override // ms.bz.bd.c.Pgl.pblr
    public final Object[] hw(String str, String str2, String str3) {
        return pr(str, null, null, str3, str2, false);
    }

    @Override // ms.bz.bd.c.Pgl.pblr
    public final Object[] pr(String str, String str2, String str3) {
        return pr(str, null, str2, str3, null, false);
    }

    @Override // ms.bz.bd.c.Pgl.pblr
    public final Object[] pr(String str, byte[] bArr, String str2, String str3) {
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "362732", new byte[]{17, 45, 82, 87, 9, 40, 24, 3, 119, 119, 1, 56, 72, 70, 2, 49, 112, 2, 113, 107, 98, 121, 12, cc.l, 76});
        return pr(str, bArr, str2, str3, null, true);
    }
}
