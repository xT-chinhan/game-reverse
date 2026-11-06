package com.mcto.sspsdk.internal;

import com.taptap.sdk.update.download.core.Util;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c6 {
    /* JADX WARN: Code duplicated, block: B:102:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x00f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x00ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static int a(a6 a6Var, String str, String str2) throws Throwable {
        InputStream inputStream;
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        InputStream inputStream2;
        RandomAccessFile randomAccessFile3;
        Throwable th;
        long length;
        InputStream inputStream3;
        InputStream inputStream4;
        RandomAccessFile randomAccessFile4;
        int i = -1;
        long j = -1;
        try {
            File file = new File(a6Var.b, str2.concat(".cdf"));
            if (file.exists()) {
                file.toString();
                length = file.length() < 0 ? 0L : file.length();
            } else {
                length = 0;
            }
            HashMap map = new HashMap(1);
            map.put(Util.RANGE, "bytes=" + length + "-");
            HttpURLConnection httpURLConnectionA = e7.a(5000, str, map);
            if (httpURLConnectionA == null) {
                a6Var.e = length;
                return -1;
            }
            int responseCode = httpURLConnectionA.getResponseCode();
            if (responseCode == 200 || responseCode == 206) {
                randomAccessFile3 = new RandomAccessFile(file, "rwd");
                try {
                    if (responseCode == 206) {
                        randomAccessFile3.seek(length);
                        j = length;
                    } else {
                        randomAccessFile3.seek(0L);
                    }
                    byte[] bArr = new byte[1048576];
                    inputStream4 = httpURLConnectionA.getInputStream();
                    while (true) {
                        try {
                            int i2 = inputStream4.read(bArr);
                            if (i2 == -1) {
                                break;
                            }
                            randomAccessFile3.write(bArr, 0, i2);
                            j += (long) i2;
                        } catch (Exception e) {
                            e = e;
                            inputStream3 = inputStream4;
                            inputStream2 = inputStream3;
                            randomAccessFile2 = randomAccessFile3;
                            try {
                                r9.a("ssp_sdk", "ssp_file_download", e);
                                if (randomAccessFile2 != null) {
                                    try {
                                        randomAccessFile2.close();
                                    } catch (Exception e2) {
                                        r9.a("ssp_sdk", "ssp_file_download", e2);
                                    }
                                }
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Exception e3) {
                                        e = e3;
                                        r9.a("ssp_sdk", "ssp_file_download", e);
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                InputStream inputStream5 = inputStream2;
                                randomAccessFile = randomAccessFile2;
                                inputStream = inputStream5;
                                th = th;
                                randomAccessFile3 = randomAccessFile;
                                if (randomAccessFile3 != null) {
                                    try {
                                        randomAccessFile3.close();
                                    } catch (Exception e4) {
                                        r9.a("ssp_sdk", "ssp_file_download", e4);
                                    }
                                }
                                if (inputStream == null) {
                                    throw th;
                                }
                                try {
                                    inputStream.close();
                                    throw th;
                                } catch (Exception e5) {
                                    r9.a("ssp_sdk", "ssp_file_download", e5);
                                    throw th;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = inputStream4;
                            th = th;
                            if (randomAccessFile3 != null) {
                                randomAccessFile3.close();
                            }
                            if (inputStream == null) {
                                throw th;
                            }
                            inputStream.close();
                            throw th;
                        }
                    }
                    randomAccessFile4 = randomAccessFile3;
                } catch (Exception e6) {
                    e = e6;
                    inputStream3 = null;
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                }
            } else {
                randomAccessFile4 = null;
                inputStream4 = null;
            }
            if (randomAccessFile4 != null) {
                try {
                    randomAccessFile4.close();
                } catch (Exception e7) {
                    r9.a("ssp_sdk", "ssp_file_download", e7);
                }
            }
            if (inputStream4 != null) {
                try {
                    inputStream4.close();
                } catch (Exception e8) {
                    e = e8;
                    i = responseCode;
                    r9.a("ssp_sdk", "ssp_file_download", e);
                }
            }
            i = responseCode;
            a6Var.e = j;
            return i;
        } catch (Exception e9) {
            e = e9;
            randomAccessFile2 = null;
            inputStream2 = null;
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
            randomAccessFile = null;
            th = th;
            randomAccessFile3 = randomAccessFile;
            if (randomAccessFile3 != null) {
                randomAccessFile3.close();
            }
            if (inputStream == null) {
                throw th;
            }
            inputStream.close();
            throw th;
        }
    }
}
