package ms.bz.bd.c.Pgl;

import android.content.Context;
import com.bytedance.sdk.openadsdk.api.plugin.xr;
import com.umeng.analytics.pro.ek;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes4.dex */
public final class pblm {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final String f4853ms;

    static {
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8330b7", new byte[]{18, 109, 1, 26, 96});
        f4853ms = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6ae92f", new byte[]{51, 119, 41, 67, 9});
    }

    public static synchronized String ms(Context context) {
        String strMs;
        String strMs2;
        try {
            StringBuilder sbAppend = new StringBuilder().append(xr.ms(context).getAbsolutePath()).append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "26fba9", new byte[]{108}));
            String str = f4853ms;
            String string = sbAppend.append(str).toString();
            if (new File(string).exists() && (strMs2 = ms(string)) != null && strMs2.length() > 0) {
                return strMs2;
            }
            InputStream inputStreamOpen = context.getResources().getAssets().open(str);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[4096];
            while (true) {
                int i = inputStreamOpen.read(bArr, 0, 4096);
                if (i == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
            FileOutputStream fileOutputStream = new FileOutputStream(string);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.close();
            ms(((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c6eb0c", new byte[]{113, 60, 27, 25, 11, 52, 55, com.anythink.core.common.s.a.c.b, 99, 114})) + string);
            strMs = ms(string);
            if (strMs == null || strMs.length() == 0) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(string, (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f34ff1", new byte[]{101, 38}));
                randomAccessFile.seek(16L);
                randomAccessFile.write(new byte[]{2});
                randomAccessFile.close();
                strMs = ms(string);
            }
        } catch (Throwable unused) {
            strMs = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "3deedf", new byte[]{114, 93, 74, 80, 5, 76, 21, 125, 23, ek.n, 18, 82, com.anythink.core.common.s.a.c.c, 62, 117, 74, 108, 4, 106, 8});
        }
        if (strMs == null || strMs.length() == 0) {
            strMs = (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "229af4", new byte[]{115, 11, 22, 84, 7, 30, 20, 33, 90, 30, 17, 11, 22, 84, 7, 30});
        }
        return strMs;
    }

    private static String ms(BufferedInputStream bufferedInputStream) {
        int i;
        byte[] bArr = new byte[4096];
        StringBuilder sb = new StringBuilder();
        do {
            try {
                i = bufferedInputStream.read(bArr);
                if (i > 0) {
                    sb.append(new String(bArr, 0, i));
                }
            } catch (Exception unused) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1b8e78", new byte[]{37, 105, 72});
            }
        } while (i >= 4096);
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:52:0x011b  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:62:0x00ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x00cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x0103 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:? A[SYNTHETIC] */
    private static String ms(String str) throws Throwable {
        Process processExec;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        BufferedInputStream bufferedInputStream2 = null;
        bufferedOutputStream2 = null;
        str = null;
        String str2 = null;
        try {
            processExec = Runtime.getRuntime().exec((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fe4459", new byte[]{100, 111}));
            try {
                bufferedOutputStream = new BufferedOutputStream(processExec.getOutputStream());
                try {
                    bufferedInputStream = new BufferedInputStream(processExec.getInputStream());
                    try {
                        bufferedOutputStream.write(str.getBytes());
                        bufferedOutputStream.write(10);
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                        processExec.waitFor();
                        String strMs = ms(bufferedInputStream);
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException unused) {
                            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e2a702", new byte[]{113, 57, 17, 124, 10});
                        }
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused2) {
                            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "eabd39", new byte[]{113, 106, 18, 47, 9});
                        }
                        str2 = strMs;
                    } catch (Exception unused3) {
                        try {
                            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "df9d07", new byte[]{112, 109, 73, 47, 10});
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException unused4) {
                                    com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "62a51d", new byte[]{34, 57, 17, 126, 11});
                                }
                            }
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException unused5) {
                                    com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "ccdce4", new byte[]{119, 104, 20, 40, 95});
                                }
                            }
                            if (processExec != null) {
                            }
                            return str2;
                        } catch (Throwable th) {
                            th = th;
                            bufferedOutputStream2 = bufferedOutputStream;
                            bufferedOutputStream = bufferedOutputStream2;
                            bufferedInputStream2 = bufferedInputStream;
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException unused6) {
                                    com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fd72da", new byte[]{114, 111, 71, 121, 94});
                                }
                            }
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (IOException unused7) {
                                    com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8b44fe", new byte[]{44, 105, 68, 127, 92});
                                }
                            }
                            if (processExec != null) {
                                throw th;
                            }
                            processExec.destroy();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream2 = bufferedInputStream;
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        if (bufferedInputStream2 != null) {
                            bufferedInputStream2.close();
                        }
                        if (processExec != null) {
                            throw th;
                        }
                        processExec.destroy();
                        throw th;
                    }
                } catch (Exception unused8) {
                    bufferedInputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    if (bufferedInputStream2 != null) {
                        bufferedInputStream2.close();
                    }
                    if (processExec != null) {
                        throw th;
                    }
                    processExec.destroy();
                    throw th;
                }
            } catch (Exception unused9) {
                bufferedOutputStream = null;
                bufferedInputStream = null;
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "df9d07", new byte[]{112, 109, 73, 47, 10});
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (processExec != null) {
                    processExec.destroy();
                }
                return str2;
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
                bufferedOutputStream = bufferedOutputStream2;
                bufferedInputStream2 = bufferedInputStream;
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                if (processExec != null) {
                    throw th;
                }
                processExec.destroy();
                throw th;
            }
        } catch (Exception unused10) {
            processExec = null;
        } catch (Throwable th5) {
            th = th5;
            processExec = null;
            bufferedInputStream = null;
        }
        processExec.destroy();
        return str2;
    }
}
