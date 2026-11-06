package com.smartdigimkt.i3;

import android.text.TextUtils;
import com.smartdigimkt.r4.q;
import com.smartdigimkt.sdk.core.SDKContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class n {
    public static volatile n d;
    public final ConcurrentHashMap b = new ConcurrentHashMap();
    public final Object[] c = new Object[64];
    public final File a = q.a(SDKContext.getInstance().d());

    public n() {
        for (int i = 0; i < 64; i++) {
            this.c[i] = new Object();
        }
    }

    public static n a() {
        if (d == null) {
            synchronized (n.class) {
                if (d == null) {
                    d = new n();
                }
            }
        }
        return d;
    }

    public final String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String strB = b(6, com.smartdigimkt.r4.i.b(str));
        try {
            if (!new File(strB).exists()) {
                return "";
            }
            String str2 = strB + File.separator + "index.html";
            return !new File(str2).exists() ? "" : str2;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static long a(int i) {
        long j = 204800;
        if (i == 1 || i == 4) {
            com.smartdigimkt.o4.e eVarC = com.smartdigimkt.o4.e.c();
            if (eVarC.b != null && eVarC.b.q != 0) {
                j = eVarC.b.q;
            }
            return j * com.anythink.china.a.c.k;
        }
        if (i != 5) {
            return 26214400L;
        }
        com.smartdigimkt.o4.e eVarC2 = com.smartdigimkt.o4.e.c();
        if (eVarC2.b != null && eVarC2.b.q != 0) {
            j = eVarC2.b.q;
        }
        return j * com.anythink.china.a.c.k;
    }

    /* JADX WARN: Code duplicated, block: B:60:0x0092 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x0089 A[EXC_TOP_SPLITTER, PHI: r0 r2
      0x0089: PHI (r0v1 boolean) = (r0v0 boolean), (r0v3 boolean) binds: [B:44:0x0088, B:31:0x0070] A[DONT_GENERATE, DONT_INLINE]
      0x0089: PHI (r2v10 com.smartdigimkt.i3.b) = (r2v9 com.smartdigimkt.i3.b), (r2v14 com.smartdigimkt.i3.b) binds: [B:44:0x0088, B:31:0x0070] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public final boolean a(int i, String str, InputStream inputStream) {
        b bVar;
        boolean z = false;
        if (str == null || inputStream == null) {
            return false;
        }
        String strB = b(i);
        if (TextUtils.isEmpty(strB)) {
            return false;
        }
        File file = new File(strB);
        if (!file.exists()) {
            file.mkdirs();
        }
        f fVarA = a(i, file);
        if (fVarA == null) {
            return false;
        }
        synchronized (this.c[(Integer.MAX_VALUE & (str.hashCode() + (i * 31))) % 64]) {
            c cVar = null;
            bVarB = null;
            bVarB = null;
            b bVarB = null;
            b bVar2 = null;
            try {
                try {
                    try {
                        e eVarB = fVarA.b(str);
                        if (eVarB != null) {
                            eVarB.a[0].close();
                        } else {
                            c cVarA = fVarA.a(str);
                            if (cVarA != null) {
                                try {
                                    bVarB = cVarA.b();
                                    byte[] bArr = new byte[2048];
                                    while (true) {
                                        int i2 = inputStream.read(bArr);
                                        if (i2 == -1) {
                                            break;
                                        }
                                        bVarB.write(bArr, 0, i2);
                                    }
                                    cVarA.a();
                                    bVarB.close();
                                } catch (Exception e) {
                                    b bVar3 = bVarB;
                                    cVar = cVarA;
                                    e = e;
                                    bVar = bVar3;
                                    try {
                                        e.toString();
                                        if (cVar != null) {
                                            try {
                                                f.a(cVar.c, cVar, false);
                                            } catch (Exception e2) {
                                                e2.printStackTrace();
                                            }
                                        }
                                        if (bVar != null) {
                                            bVarB = bVar;
                                            try {
                                                bVarB.close();
                                            } catch (IOException unused) {
                                            }
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        bVar2 = bVar;
                                        if (bVar2 != null) {
                                            try {
                                                bVar2.close();
                                            } catch (IOException unused2) {
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            } else if (bVarB != null) {
                                bVarB.close();
                            }
                        }
                        z = true;
                        if (bVarB != null) {
                            bVarB.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (bVar2 != null) {
                            bVar2.close();
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    bVar = null;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return z;
    }

    public final String b(int i) {
        String str;
        if (i == 1) {
            str = "sdm_internal_resouce";
        } else if (i == 3) {
            str = "sdm_internal_extra_resource";
        } else if (i != 4) {
            str = (i == 5 || i == 6) ? "sdm_internal_html_template" : "sdm_custom_resouce";
        } else {
            str = "sdm_internal_video_resource";
        }
        return new File(this.a, str).getAbsolutePath();
    }

    public final String b(int i, String str) {
        StringBuilder sbAppend = new StringBuilder().append(b(i)).append(File.separator);
        if (i == 5) {
            str = com.smartdigimkt.p.a.a(str, ".zip");
        } else if (i != 6) {
            str = com.smartdigimkt.p.a.a(str, ".0");
        }
        return sbAppend.append(str).toString();
    }

    public final FileInputStream a(int i, String str) {
        InputStream inputStream;
        if (i != 4) {
            String strB = b(i);
            if (TextUtils.isEmpty(strB)) {
                return null;
            }
            File file = new File(strB);
            if (!file.exists()) {
                file.mkdirs();
            }
            f fVarA = a(i, file);
            if (fVarA != null) {
                try {
                    e eVarB = fVarA.b(str);
                    if (eVarB != null && (inputStream = eVarB.a[0]) != null) {
                        return (FileInputStream) inputStream;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        try {
            return new FileInputStream(new File(b(4, str)));
        } catch (Throwable unused) {
            return null;
        }
    }

    public final synchronized f a(int i, File file) {
        f fVarA;
        fVarA = (f) this.b.get(Integer.valueOf(i));
        if (fVarA == null) {
            try {
                fVarA = f.a(file, a(i));
                this.b.put(Integer.valueOf(i), fVarA);
            } catch (Throwable th) {
                if (SDKContext.getInstance().j()) {
                    th.printStackTrace();
                }
            }
        }
        return fVarA;
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            new File(b(3) + File.separator + str + ".0").delete();
        } catch (Throwable unused) {
        }
    }
}
