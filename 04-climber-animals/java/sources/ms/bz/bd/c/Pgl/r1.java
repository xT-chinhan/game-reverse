package ms.bz.bd.c.Pgl;

import com.umeng.analytics.pro.ek;
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

/* JADX INFO: loaded from: classes4.dex */
public final class r1 extends pblx {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private SSLSocketFactory f4867ms;

    /* JADX WARN: Code duplicated, block: B:113:0x0570 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:119:0x0536 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x04e2 A[Catch: all -> 0x0561, TryCatch #0 {all -> 0x0561, blocks: (B:78:0x04b6, B:80:0x04e2, B:82:0x052b), top: B:104:0x04b6 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x052a  */
    private Object[] ms(String str, byte[] bArr, String str2, String str3, String str4, boolean z) throws Throwable {
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
        pblw.pgla pglaVar = new pblw.pgla();
        int i = -1;
        DataOutputStream dataOutputStream2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection instanceof HttpsURLConnection) {
                try {
                    try {
                        if (this.f4867ms == null) {
                            try {
                                synchronized (r1.class) {
                                    if (this.f4867ms == null) {
                                        SSLContext sSLContext = SSLContext.getInstance((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3e4ac5", new byte[]{22, 75, 116}));
                                        sSLContext.init(null, null, null);
                                        this.f4867ms = sSLContext.getSocketFactory();
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                bufferedInputStream = null;
                                dataOutputStream = dataOutputStream2;
                                bufferedInputStream3 = bufferedInputStream;
                                pblx.ms(bufferedInputStream3);
                                pblx.ms(dataOutputStream);
                                if (httpURLConnection != null) {
                                    try {
                                        httpURLConnection.disconnect();
                                    } catch (Exception unused) {
                                        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "dc374a", new byte[]{102, 105, 67, 124, 3, 103, 53});
                                    }
                                }
                                throw th;
                            }
                        }
                        SSLSocketFactory sSLSocketFactory = this.f4867ms;
                        if (sSLSocketFactory != null) {
                            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        dataOutputStream2 = null;
                        bufferedInputStream = null;
                        dataOutputStream = dataOutputStream2;
                        bufferedInputStream3 = bufferedInputStream;
                        pblx.ms(bufferedInputStream3);
                        pblx.ms(dataOutputStream);
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Exception unused2) {
                }
            }
            try {
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setRequestProperty((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "36a09d", new byte[]{3, 55, 17, 65, 22, 103}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "deae9d", new byte[]{com.anythink.core.common.s.a.c.c, 40, 88}));
                httpURLConnection.setRequestProperty((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "701d4b", new byte[]{5, 61, 76, 30, ek.l, 118, 32, 24, 111, 58}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f8b17c", new byte[]{92, com.anythink.core.common.s.a.c.c, 20, 85, 69, 85, 105, ek.n, 37, 100}));
                httpURLConnection.setRequestProperty((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fcf88f", new byte[]{66, 114, ek.n, 94, 74, 80, 98, 71, 57, 124}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1d2c37", new byte[]{2, 127, 85, 18, 40, 33, 60, 70, 102, 126, ek.k, 85, 114, 51, 39}));
                httpURLConnection.setRequestProperty((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "094b71", new byte[]{2, 52, 73, 2, ek.k, 40, 39, 85, 81, 43, 49, 62}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "4d614b", new byte[]{36, 118, 85, 73, 2, 118, 54, 81, 110, 110, 43, 41, 74, 70, 31, 112, 35, 8, 116, 117, 55, 99, 68, 72}));
                if (str2 != null && str2.trim().length() > 0) {
                    httpURLConnection.setRequestProperty((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "017169", new byte[]{2, 60, 75, 78, 0, 43}), String.format((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c67a31", new byte[]{97, 49, 87, 6, 5, 41, 110, 30, 98, 108, 55, 39}), str2));
                }
                if (str3 != null && str3.trim().length() > 0) {
                    httpURLConnection.setRequestProperty((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b318aa", new byte[]{107, 124, 86, 88, 19, 100, 100, 3, 117, 109, 96, 37, ek.m, 88, 95, 113}), str3);
                }
                pglaVar.ms(str);
                if (z) {
                    httpURLConnection.setRequestMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f98dfe", new byte[]{71, 20, 120, 36}));
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
                                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d21f17", new byte[]{102, 56, 65, 45, 6, 49});
                                if (httpURLConnection != null) {
                                    headerField = httpURLConnection.getHeaderField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "09723e", new byte[]{57, 118, 80, 82, 65, 126, 60, 31, 111, 102}));
                                } else {
                                    headerField = null;
                                }
                                pglaVar.xr(headerField, responseCode);
                                pblx.ms(bufferedInputStream2);
                                pblx.ms(dataOutputStream);
                                if (httpURLConnection != null) {
                                    try {
                                        httpURLConnection.disconnect();
                                    } catch (Exception unused4) {
                                        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "61635a", new byte[]{52, 59, 70, 120, 2, 103, 103});
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
                                pblx.ms(bufferedInputStream3);
                                pblx.ms(dataOutputStream);
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedInputStream3 = null;
                        pblx.ms(bufferedInputStream3);
                        pblx.ms(dataOutputStream);
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
                    pglaVar.ms(httpURLConnection.getHeaderField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b18581", new byte[]{107, 126, 95, 85, 74, 42, 110, 23, 96, 97})), responseCode);
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
                            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d21f17", new byte[]{102, 56, 65, 45, 6, 49});
                            if (httpURLConnection != null) {
                                headerField = httpURLConnection.getHeaderField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "09723e", new byte[]{57, 118, 80, 82, 65, 126, 60, 31, 111, 102}));
                            } else {
                                headerField = null;
                            }
                            pglaVar.xr(headerField, responseCode);
                            pblx.ms(bufferedInputStream2);
                            pblx.ms(dataOutputStream);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            bArr2 = null;
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedInputStream3 = bufferedInputStream2;
                            pblx.ms(bufferedInputStream3);
                            pblx.ms(dataOutputStream);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    } else {
                        byteArray = null;
                        bufferedInputStream4 = null;
                    }
                    pblx.ms(bufferedInputStream4);
                    pblx.ms(dataOutputStream);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Exception unused6) {
                        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9496f8", new byte[]{59, 62, 73, 125, 81, 62, 104});
                    }
                    bArr2 = byteArray;
                } catch (Exception unused7) {
                    i = responseCode;
                    responseCode = i;
                    bufferedInputStream2 = null;
                    com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d21f17", new byte[]{102, 56, 65, 45, 6, 49});
                    if (httpURLConnection != null) {
                        headerField = httpURLConnection.getHeaderField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "09723e", new byte[]{57, 118, 80, 82, 65, 126, 60, 31, 111, 102}));
                    } else {
                        headerField = null;
                    }
                    pglaVar.xr(headerField, responseCode);
                    pblx.ms(bufferedInputStream2);
                    pblx.ms(dataOutputStream);
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
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d21f17", new byte[]{102, 56, 65, 45, 6, 49});
                if (httpURLConnection != null) {
                    headerField = httpURLConnection.getHeaderField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "09723e", new byte[]{57, 118, 80, 82, 65, 126, 60, 31, 111, 102}));
                } else {
                    headerField = null;
                }
                pglaVar.xr(headerField, responseCode);
                pblx.ms(bufferedInputStream2);
                pblx.ms(dataOutputStream);
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

    @Override // ms.bz.bd.c.Pgl.pblx
    public final Object[] ms(String str, String str2, String str3) {
        return ms(str, null, str2, str3, null, false);
    }

    @Override // ms.bz.bd.c.Pgl.pblx
    public final Object[] ms(String str, byte[] bArr, String str2, String str3) {
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "54b448", new byte[]{23, 47, 2, 84, ek.l, 34, 30, 1, 39, 116, 7, 58, 24, 69, 5, 59, 118, 0, 33, 104, 100, 123, 92, ek.k, 75});
        return ms(str, bArr, str2, str3, null, true);
    }

    @Override // ms.bz.bd.c.Pgl.pblx
    public final Object[] xr(String str, String str2, String str3) {
        return ms(str, null, null, str3, str2, false);
    }
}
