package com.mcto.sspsdk.internal;

import android.os.SystemClock;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class z6 implements Runnable {
    public final /* synthetic */ ba a;
    public final /* synthetic */ mj b;

    public z6(ba baVar, mj mjVar) {
        this.a = baVar;
        this.b = mjVar;
    }

    /* JADX WARN: Code duplicated, block: B:108:0x010b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:110:0x016c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:114:0x0123 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:116:0x0184 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:0x0117 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:124:0x0178 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:140:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:72:0x0136  */
    /* JADX WARN: Code duplicated, block: B:77:0x014e  */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        InputStream inputStream;
        BufferedOutputStream bufferedOutputStream;
        OutputStream outputStream;
        OutputStream outputStream2;
        InputStream inputStream2;
        InputStream inputStream3;
        BufferedOutputStream bufferedOutputStream2;
        Throwable th;
        int i;
        InputStream inputStream4;
        InputStream inputStream5;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        d7 d7Var = new d7();
        ba baVar = this.a;
        String string = "";
        try {
            String string2 = UUID.randomUUID().toString();
            byte[] bytes = string2.getBytes();
            URL url = new URL("https://api-feedback.iqiyi.com/feedbacks");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setRequestProperty("Host", url.getHost());
            httpURLConnection.setRequestProperty("User-Agent", y4.r.f());
            httpURLConnection.setRequestProperty("connection", "Keep-Alive");
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=".concat(string2));
            outputStream2 = httpURLConnection.getOutputStream();
            try {
                bufferedOutputStream2 = new BufferedOutputStream(outputStream2);
                try {
                    d7.a(bufferedOutputStream2, bytes, baVar.a);
                    d7.a(bufferedOutputStream2, bytes, baVar.b);
                    try {
                        byte[] bArr = d7.d;
                        bufferedOutputStream2.write(bArr);
                        bufferedOutputStream2.write(bytes);
                        bufferedOutputStream2.write(bArr);
                        bufferedOutputStream2.write(d7.c);
                        bufferedOutputStream2.flush();
                        int responseCode = httpURLConnection.getResponseCode();
                        d7Var.a = responseCode;
                        if (responseCode == 200) {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            byte[] bArr2 = new byte[1024];
                            InputStream inputStream6 = httpURLConnection.getInputStream();
                            while (true) {
                                try {
                                    int i2 = inputStream6.read(bArr2);
                                    if (i2 == -1) {
                                        break;
                                    } else {
                                        byteArrayOutputStream.write(bArr2, 0, i2);
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    inputStream4 = inputStream6;
                                    inputStream2 = inputStream4;
                                    bufferedOutputStream = bufferedOutputStream2;
                                    try {
                                        d7Var.a = -7;
                                        r9.a("ssp_sdk", "ssp_multi_post", e);
                                        if (bufferedOutputStream != null) {
                                            try {
                                                bufferedOutputStream.close();
                                            } catch (IOException e2) {
                                                r9.a("ssp_sdk", "ssp_multi_post", e2);
                                            }
                                        }
                                        if (outputStream2 != null) {
                                            try {
                                                outputStream2.close();
                                            } catch (IOException e3) {
                                                r9.a("ssp_sdk", "ssp_multi_post", e3);
                                            }
                                        }
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (IOException e4) {
                                                e = e4;
                                                r9.a("ssp_sdk", "ssp_multi_post", e);
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        inputStream = inputStream2;
                                        outputStream = outputStream2;
                                        bufferedOutputStream2 = bufferedOutputStream;
                                        outputStream2 = outputStream;
                                        inputStream3 = inputStream;
                                        th = th;
                                        if (bufferedOutputStream2 != null) {
                                            try {
                                                bufferedOutputStream2.close();
                                            } catch (IOException e5) {
                                                r9.a("ssp_sdk", "ssp_multi_post", e5);
                                            }
                                        }
                                        if (outputStream2 != null) {
                                            try {
                                                outputStream2.close();
                                            } catch (IOException e6) {
                                                r9.a("ssp_sdk", "ssp_multi_post", e6);
                                            }
                                        }
                                        if (inputStream3 == null) {
                                            throw th;
                                        }
                                        try {
                                            inputStream3.close();
                                            throw th;
                                        } catch (IOException e7) {
                                            r9.a("ssp_sdk", "ssp_multi_post", e7);
                                            throw th;
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    inputStream3 = inputStream6;
                                    th = th;
                                    if (bufferedOutputStream2 != null) {
                                        bufferedOutputStream2.close();
                                    }
                                    if (outputStream2 != null) {
                                        outputStream2.close();
                                    }
                                    if (inputStream3 == null) {
                                        throw th;
                                    }
                                    inputStream3.close();
                                    throw th;
                                }
                            }
                            string = byteArrayOutputStream.toString();
                            httpURLConnection.disconnect();
                            inputStream5 = inputStream6;
                        } else {
                            inputStream5 = null;
                        }
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e8) {
                            r9.a("ssp_sdk", "ssp_multi_post", e8);
                        }
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                            } catch (IOException e9) {
                                r9.a("ssp_sdk", "ssp_multi_post", e9);
                            }
                        }
                        if (inputStream5 != null) {
                            try {
                                inputStream5.close();
                            } catch (IOException e10) {
                                e = e10;
                                r9.a("ssp_sdk", "ssp_multi_post", e);
                            }
                        }
                    } catch (Exception e11) {
                        e = e11;
                        inputStream4 = null;
                    } catch (Throwable th4) {
                        th = th4;
                        inputStream3 = null;
                    }
                } catch (Exception e12) {
                    e = e12;
                    bufferedOutputStream = bufferedOutputStream2;
                    inputStream2 = null;
                    d7Var.a = -7;
                    r9.a("ssp_sdk", "ssp_multi_post", e);
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (outputStream2 != null) {
                        outputStream2.close();
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    i = d7Var.a;
                    if (i == 200) {
                        try {
                            this.b.a(string, new h7(i, (int) (SystemClock.elapsedRealtime() - jElapsedRealtime), 1));
                            return;
                        } catch (Throwable th5) {
                            r9.a("ssp_req", "callback: ", th5);
                            return;
                        }
                    }
                    mj mjVar = this.b;
                    SystemClock.elapsedRealtime();
                    try {
                        mjVar.a.a("feedback post error. Please try again!");
                    } catch (Throwable th6) {
                        r9.a("ssp_req", "callback: ", th6);
                        return;
                    }
                } catch (Throwable th7) {
                    th = th7;
                    inputStream3 = null;
                }
            } catch (Exception e13) {
                e = e13;
                bufferedOutputStream = null;
                inputStream2 = null;
                d7Var.a = -7;
                r9.a("ssp_sdk", "ssp_multi_post", e);
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (outputStream2 != null) {
                    outputStream2.close();
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                i = d7Var.a;
                if (i == 200) {
                    this.b.a(string, new h7(i, (int) (SystemClock.elapsedRealtime() - jElapsedRealtime), 1));
                    return;
                }
                mj mjVar2 = this.b;
                SystemClock.elapsedRealtime();
                mjVar2.a.a("feedback post error. Please try again!");
            } catch (Throwable th8) {
                th = th8;
                outputStream = outputStream2;
                inputStream = null;
                bufferedOutputStream = null;
                bufferedOutputStream2 = bufferedOutputStream;
                outputStream2 = outputStream;
                inputStream3 = inputStream;
                th = th;
                if (bufferedOutputStream2 != null) {
                    bufferedOutputStream2.close();
                }
                if (outputStream2 != null) {
                    outputStream2.close();
                }
                if (inputStream3 == null) {
                    throw th;
                }
                inputStream3.close();
                throw th;
            }
        } catch (Exception e14) {
            e = e14;
            outputStream2 = null;
        } catch (Throwable th9) {
            th = th9;
            inputStream = null;
            bufferedOutputStream = null;
            outputStream = null;
        }
        i = d7Var.a;
        if (i == 200) {
            this.b.a(string, new h7(i, (int) (SystemClock.elapsedRealtime() - jElapsedRealtime), 1));
            return;
        }
        mj mjVar3 = this.b;
        SystemClock.elapsedRealtime();
        mjVar3.a.a("feedback post error. Please try again!");
    }
}
