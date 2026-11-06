package com.byazt.xhd;

import android.os.Process;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.anythink.core.common.d.i;
import com.byazt.nf.rv;
import com.byazt.qk.oa;
import com.byazt.qk.x;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 504, 19})
public final class n {
    public static final String n = com.byazt.tka.qg.qg("3fc9d92afe951d5c9c48c4a6715489f10a92492eabd3c612a/ol8CJox9V/smObhSQ9mIwHhjia02D08qHL0TycLa5WO03qiDQoqke+ZbRPhHLxOKqnCvAEszjzXzP+HFGIKTS6DNuef6cnVnVkPFbilyZg=");
    public static volatile int q;
    public static final Map<String, String> qg;
    public static final Map<String, String> s;

    static {
        HashMap map = new HashMap();
        qg = map;
        HashMap map2 = new HashMap();
        s = map2;
        q = 0;
        map.put("pangleflipped", "e66734361c539acf7b68012cced6ac46");
        map2.put("pangleflipped", "a04e988be0c0f2c896d8c04f2727df91");
        map2.put("panglearmor", "c2370107f7ee4d22ecd273f1c4f75823");
        map2.put("tt_ugen_layout", "fe9e015a6132b0d18eb1367ab436effb");
        map2.put("avmdl_lite", "fb68074426398737e50cd5ffbf8691e1");
        map2.put("Pglbizssdk_ml", "b2daffeb842e5654a9475517e9601f23");
        map2.put("tobEmbedEncrypt", "b56fc04645141887a4b2eb4c20aabb69");
        map2.put("ttmplayer_lite", "19cbcab212641551ea7efa8f814f02df");
    }

    private static boolean n() {
        if (q == 0) {
            q = Process.is64Bit() ? 1 : 2;
        }
        return q == 1;
    }

    public static int n(String str) {
        String str2 = (n() ? s : qg).get(str);
        if (TextUtils.isEmpty(str2)) {
            return 1;
        }
        String strConcat = "lib".concat(String.valueOf(str));
        String str3 = n + "7814/" + strConcat + "/" + str2 + ".so";
        File fileN = com.byazt.qyu.qg.n(rv.getContext(), ".so", 0);
        if (!fileN.exists()) {
            fileN.mkdirs();
        }
        File file = new File(fileN, strConcat + ".so");
        File file2 = new File(fileN, strConcat + ".lock");
        String str4 = file.getName() + ".tmp." + Process.myPid() + i.E + System.currentTimeMillis();
        int iN = n(file, file2, str2);
        if (iN != 5 && iN != 4) {
            return iN;
        }
        n(str, str3, fileN, file, file2, str4, str2);
        return iN;
    }

    private static int n(File file, File file2, String str) {
        int i = 5;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                try {
                    FileLock fileLockTryLock = fileOutputStream.getChannel().tryLock();
                    if (fileLockTryLock == null) {
                        fileOutputStream.close();
                        return 2;
                    }
                    try {
                        if (file.exists()) {
                            if (TextUtils.equals(com.byazt.nl.n.n(file), str)) {
                                int iS = s(file.getAbsolutePath());
                                try {
                                    fileLockTryLock.release();
                                } catch (IOException unused) {
                                }
                                fileOutputStream.close();
                                return iS;
                            }
                            i = 4;
                            file.delete();
                        }
                        try {
                            fileLockTryLock.release();
                        } catch (IOException unused2) {
                        }
                        fileOutputStream.close();
                        return i;
                    } catch (Throwable th) {
                        try {
                            fileLockTryLock.release();
                        } catch (IOException unused3) {
                        }
                        throw th;
                    }
                } catch (Exception unused4) {
                    fileOutputStream.close();
                    return 2;
                }
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th4) {
                        th2.addSuppressed(th4);
                    }
                    throw th3;
                }
            }
        } catch (Throwable unused5) {
        }
        return i;
    }

    private static void n(final String str, String str2, File file, final File file2, final File file3, String str3, final String str4) {
        com.byazt.phf.s.n(str2, file.getAbsolutePath(), str3).n(new x() { // from class: com.byazt.xhd.n.1
            /* JADX WARN: Code duplicated, block: B:92:0x0134  */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r5v0 */
            /* JADX WARN: Type inference failed for: r5v1 */
            /* JADX WARN: Type inference failed for: r5v10 */
            /* JADX WARN: Type inference failed for: r5v11, types: [java.io.File] */
            /* JADX WARN: Type inference failed for: r5v12 */
            /* JADX WARN: Type inference failed for: r5v16, types: [java.nio.channels.FileLock] */
            /* JADX WARN: Type inference failed for: r5v17 */
            /* JADX WARN: Type inference failed for: r5v19 */
            /* JADX WARN: Type inference failed for: r5v2 */
            /* JADX WARN: Type inference failed for: r5v21 */
            /* JADX WARN: Type inference failed for: r5v22 */
            /* JADX WARN: Type inference failed for: r5v23 */
            /* JADX WARN: Type inference failed for: r5v24 */
            /* JADX WARN: Type inference failed for: r5v25 */
            /* JADX WARN: Type inference failed for: r5v26 */
            /* JADX WARN: Type inference failed for: r5v3 */
            /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r5v5 */
            /* JADX WARN: Type inference failed for: r5v6 */
            /* JADX WARN: Type inference failed for: r5v7 */
            /* JADX WARN: Type inference failed for: r5v8 */
            @Override // com.byazt.qk.x
            public void n(oa oaVar) {
                Exception exc;
                boolean zX;
                boolean z;
                ?? r5;
                ?? r6;
                String str5;
                String str6;
                ?? r7;
                ?? r8;
                String str7;
                boolean z2 = false;
                File file4 = null;
                IOException e = null;
                try {
                    zX = oaVar.x();
                    try {
                        File fileTj = oaVar.tj();
                        if (!zX || fileTj == null) {
                            r5 = "file not exists";
                            exc = null;
                            z = true;
                            if (fileTj != null && fileTj.exists() && !TextUtils.equals(fileTj.getAbsolutePath(), file2.getAbsolutePath())) {
                                fileTj.delete();
                            }
                            str5 = str;
                            r6 = r5;
                            str6 = str4;
                            r7 = r6;
                        } else {
                            try {
                                if (fileTj.exists()) {
                                    try {
                                        ?? TryLock = file3;
                                        FileOutputStream fileOutputStream = new FileOutputStream((File) TryLock);
                                        try {
                                            try {
                                                try {
                                                    TryLock = fileOutputStream.getChannel().tryLock();
                                                    if (TryLock == 0) {
                                                        String str8 = "file lock is null";
                                                        fileOutputStream.close();
                                                        if (fileTj != null && fileTj.exists() && !TextUtils.equals(fileTj.getAbsolutePath(), file2.getAbsolutePath())) {
                                                            fileTj.delete();
                                                        }
                                                        str5 = str;
                                                        z = false;
                                                        str6 = str4;
                                                        exc = null;
                                                        r7 = str8;
                                                    } else {
                                                        try {
                                                            if (file2.exists()) {
                                                                if (TextUtils.equals(com.byazt.nl.n.n(file2), str4)) {
                                                                    file2.setReadOnly();
                                                                    z2 = n.s(file2.getAbsolutePath()) == 3;
                                                                    try {
                                                                        TryLock.release();
                                                                    } catch (IOException unused) {
                                                                    }
                                                                    fileOutputStream.close();
                                                                    if (fileTj != null && fileTj.exists() && !TextUtils.equals(fileTj.getAbsolutePath(), file2.getAbsolutePath())) {
                                                                        fileTj.delete();
                                                                    }
                                                                    str5 = str;
                                                                    r7 = 0;
                                                                    str6 = str4;
                                                                    exc = null;
                                                                    z = z2;
                                                                } else {
                                                                    file2.delete();
                                                                }
                                                            }
                                                            if (!TextUtils.equals(com.byazt.nl.n.n(fileTj), str4)) {
                                                                str7 = "file md5 mismatch";
                                                            } else if (fileTj.renameTo(file2)) {
                                                                file2.setReadOnly();
                                                                z2 = n.s(file2.getAbsolutePath()) == 3;
                                                                str7 = null;
                                                            } else {
                                                                str7 = "rename failed";
                                                            }
                                                            try {
                                                                TryLock.release();
                                                            } catch (IOException unused2) {
                                                            } catch (Throwable th) {
                                                                th = th;
                                                                try {
                                                                    throw th;
                                                                } catch (Throwable th2) {
                                                                    try {
                                                                        fileOutputStream.close();
                                                                    } catch (Throwable th3) {
                                                                        th.addSuppressed(th3);
                                                                    }
                                                                    throw th2;
                                                                }
                                                            }
                                                            try {
                                                                fileOutputStream.close();
                                                            } catch (IOException e2) {
                                                                e = e2;
                                                                str7 = "file lock close failed";
                                                            } catch (Throwable th4) {
                                                                z = z2;
                                                                exc = th4;
                                                                r8 = str7;
                                                                file4 = fileTj;
                                                                r5 = r8;
                                                                if (file4 != null) {
                                                                    file4.delete();
                                                                }
                                                                str5 = str;
                                                                r6 = r5;
                                                                str6 = str4;
                                                                r7 = r6;
                                                                n.qg(str5, zX, z, r7, str6, exc);
                                                            }
                                                            z = z2;
                                                            exc = e;
                                                            r5 = str7;
                                                        } catch (Throwable th5) {
                                                            try {
                                                                TryLock.release();
                                                            } catch (IOException unused3) {
                                                            }
                                                            throw th5;
                                                        }
                                                    }
                                                } catch (Exception e3) {
                                                    exc = e3;
                                                    String str9 = "file lock failed";
                                                    fileOutputStream.close();
                                                    if (fileTj != null && fileTj.exists() && !TextUtils.equals(fileTj.getAbsolutePath(), file2.getAbsolutePath())) {
                                                        fileTj.delete();
                                                    }
                                                    str5 = str;
                                                    z = false;
                                                    r6 = str9;
                                                }
                                            } catch (Throwable th6) {
                                                th = th6;
                                            }
                                        } catch (IOException e4) {
                                            e = e4;
                                        } catch (Throwable th7) {
                                            z = false;
                                            exc = th7;
                                            r8 = TryLock;
                                        }
                                    } catch (IOException e5) {
                                        e = e5;
                                    }
                                } else {
                                    r5 = "file not exists";
                                    exc = null;
                                    z = true;
                                }
                                if (fileTj != null) {
                                    fileTj.delete();
                                }
                            } catch (Throwable th8) {
                                z = false;
                                r8 = 0;
                                exc = th8;
                            }
                            str5 = str;
                            r6 = r5;
                            str6 = str4;
                            r7 = r6;
                        }
                    } catch (Throwable th9) {
                        exc = th9;
                        z = false;
                        r5 = 0;
                        if (file4 != null && file4.exists() && !TextUtils.equals(file4.getAbsolutePath(), file2.getAbsolutePath())) {
                            file4.delete();
                        }
                        str5 = str;
                        r6 = r5;
                        str6 = str4;
                        r7 = r6;
                        n.qg(str5, zX, z, r7, str6, exc);
                    }
                } catch (Throwable th10) {
                    exc = th10;
                    zX = false;
                    z = false;
                }
                n.qg(str5, zX, z, r7, str6, exc);
            }

            @Override // com.byazt.qk.x
            public void n(int i, String str5, Throwable th) {
                n.qg(str, false, false, str5, str4, th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void qg(String str, boolean z, boolean z2, String str2, String str3, Throwable th) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("lib", str);
            jSONObject.putOpt(NotificationCompat.CATEGORY_MESSAGE, str2);
            jSONObject.putOpt("is_load", Boolean.valueOf(z2));
            jSONObject.putOpt("success", Boolean.valueOf(z));
            jSONObject.putOpt("md5", str3);
            if (th != null) {
                jSONObject.putOpt("error", th.getMessage());
            }
        } catch (Exception unused) {
        }
        com.byazt.eji.s.n().n("so_download", jSONObject, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int s(String str) {
        try {
            System.class.getDeclaredMethod("load", String.class).invoke(null, str);
            return 3;
        } catch (Throwable unused) {
            return 6;
        }
    }
}
