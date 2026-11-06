package com.anythink.core.common.res;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.common.d.t;
import com.anythink.core.common.h.x;
import com.anythink.core.common.v.o;
import com.anythink.core.common.v.w;
import com.baidu.mobads.sdk.internal.bn;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static final String a = "about:blank";
    public static final String d = "foldername";
    private static final String f = "anythink_internal_resouce";
    private static final String g = "anythink_custom_resouce";
    private static final String h = "anythink_internal_extra_resource";
    private static final String i = "anythink_internal_video_resource";
    private static final String j = "anythink_internal_html_resouce";
    private static final String k = "anythink_internal_html_template";
    private static volatile d l;
    private Context m;
    private File n;
    private final String e = getClass().getSimpleName();
    ConcurrentHashMap<Integer, a> b = new ConcurrentHashMap<>();
    final long c = bn.e;

    private d(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.m = applicationContext;
        this.n = w.a(applicationContext);
    }

    public static d a(Context context) {
        if (l == null) {
            synchronized (d.class) {
                if (l == null) {
                    l = new d(context);
                }
            }
        }
        return l;
    }

    public final String a() {
        return this.n.getAbsolutePath();
    }

    public final String a(String str, x xVar, com.anythink.core.common.h.w wVar) {
        FileOutputStream fileOutputStream;
        File file = new File(this.n, j);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, xVar.d + "_" + wVar.v() + ".html");
        try {
            byte[] bytes = str.getBytes("utf-8");
            fileOutputStream = new FileOutputStream(file2);
            try {
                fileOutputStream.write(bytes, 0, bytes.length);
                String string = file2.toURI().toString();
                try {
                    fileOutputStream.close();
                    return string;
                } catch (Throwable unused) {
                    return string;
                }
            } catch (Throwable unused2) {
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable unused3) {
                    }
                }
                return "";
            }
        } catch (Throwable unused4) {
            fileOutputStream = null;
        }
    }

    public final void a(x xVar, com.anythink.core.common.h.w wVar) {
        try {
            File file = new File(new File(this.n, j), xVar.d + "_" + wVar.v() + ".html");
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable unused) {
        }
    }

    public final void b() {
        File[] fileArrListFiles;
        try {
            File file = new File(this.n, j);
            if (!file.exists() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length <= 0) {
                return;
            }
            for (File file2 : fileArrListFiles) {
                try {
                    if (file2.isFile() && System.currentTimeMillis() - file2.lastModified() > 86400000) {
                        file2.delete();
                    }
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }

    public static void c() {
        try {
            long jD = t.b().d(1);
            String strA = a(t.b().g()).a(1);
            long jA = w.a(strA);
            if (jA <= 0 || jA <= jD * 1.5d) {
                return;
            }
            File[] fileArrListFiles = new File(strA).listFiles();
            ArrayList arrayList = new ArrayList();
            if (fileArrListFiles != null) {
                Collections.addAll(arrayList, fileArrListFiles);
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (arrayList.size() > 0) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    File file = (File) arrayList.get(i2);
                    if (jCurrentTimeMillis - file.lastModified() > bn.e) {
                        try {
                            file.delete();
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final File b(x xVar, com.anythink.core.common.h.w wVar) {
        File file = new File(new File(this.n, j), xVar.d + "_" + wVar.v() + ".html");
        if (file.exists()) {
            return file;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:58:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final boolean a(int i2, String str, InputStream inputStream) throws Throwable {
        OutputStream outputStream;
        if (str == null || inputStream == null) {
            return false;
        }
        String strA = a(i2);
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        File file = new File(strA);
        if (!file.exists()) {
            file.mkdirs();
        }
        a aVarA = a(i2, file);
        if (aVarA == null) {
            return false;
        }
        a.C0095a c0095a = null;
        outputStreamA = null;
        outputStreamA = null;
        OutputStream outputStreamA = null;
        OutputStream outputStream2 = null;
        try {
            try {
                a.c cVarA = aVarA.a(str);
                if (cVarA == null) {
                    a.C0095a c0095aB = aVarA.b(str);
                    if (c0095aB != null) {
                        try {
                            outputStreamA = c0095aB.a(0);
                            byte[] bArr = new byte[2048];
                            while (true) {
                                int i3 = inputStream.read(bArr);
                                if (i3 == -1) {
                                    break;
                                }
                                outputStreamA.write(bArr, 0, i3);
                            }
                            c0095aB.a();
                            outputStreamA.close();
                        } catch (Exception e) {
                            e = e;
                            OutputStream outputStream3 = outputStreamA;
                            c0095a = c0095aB;
                            outputStream = outputStream3;
                            try {
                                new StringBuilder("writeToDiskLruCache - ").append(e);
                                if (c0095a != null) {
                                    try {
                                        c0095a.b();
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                if (outputStream == null) {
                                    return false;
                                }
                                try {
                                    outputStream.close();
                                    return false;
                                } catch (IOException unused) {
                                    return false;
                                }
                            } catch (Throwable th) {
                                outputStream2 = outputStream;
                                th = th;
                                if (outputStream2 != null) {
                                    try {
                                        outputStream2.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                                throw th;
                            }
                        }
                    }
                } else {
                    cVarA.a().close();
                }
                if (outputStreamA != null) {
                    try {
                        outputStreamA.close();
                    } catch (IOException unused3) {
                    }
                }
                return true;
            } catch (Throwable th2) {
                th = th2;
                if (outputStream2 != null) {
                    outputStream2.close();
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            outputStream = null;
        }
    }

    public final FileInputStream a(int i2, String str) {
        InputStream inputStreamA;
        if (i2 != 4) {
            String strA = a(i2);
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            File file = new File(strA);
            if (!file.exists()) {
                file.mkdirs();
            }
            a aVarA = a(i2, file);
            if (aVarA != null) {
                try {
                    a.c cVarA = aVarA.a(str);
                    if (cVarA != null && (inputStreamA = cVarA.a()) != null) {
                        return (FileInputStream) inputStreamA;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        try {
            return new FileInputStream(new File(c(4, str)));
        } catch (Throwable unused) {
            return null;
        }
    }

    private synchronized a a(int i2, File file) {
        a aVarA;
        aVarA = this.b.get(Integer.valueOf(i2));
        if (aVarA == null) {
            try {
                aVarA = a.a(file, t.b().d(i2));
                this.b.put(Integer.valueOf(i2), aVarA);
            } catch (Throwable th) {
                if (t.b().F()) {
                    Log.e(this.e, "Create DiskCache error.");
                    th.printStackTrace();
                }
            }
        }
        return aVarA;
    }

    public final String a(int i2) {
        String str;
        if (i2 == 1) {
            str = f;
        } else if (i2 == 3) {
            str = h;
        } else if (i2 != 4) {
            str = (i2 == 5 || i2 == 6) ? k : g;
        } else {
            str = i;
        }
        return new File(this.n, str).getAbsolutePath();
    }

    public final boolean b(int i2, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(c(i2, str)).exists();
    }

    public final String c(int i2, String str) {
        return a(i2) + File.separator + d(i2, str);
    }

    private static String d(int i2, String str) {
        if (i2 == 4) {
            return str;
        }
        if (i2 != 5) {
            return i2 != 6 ? str + ".0" : str;
        }
        return str + ".zip";
    }

    public final void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            new File(a(3) + File.separator + str + ".0").delete();
        } catch (Throwable unused) {
        }
    }

    public final String a(String str) {
        String strC = c(6, o.a(str));
        try {
            if (!new File(strC).exists()) {
                return "";
            }
            String str2 = strC + File.separator + "index.html";
            return !new File(str2).exists() ? "" : str2;
        } catch (Throwable unused) {
            return "";
        }
    }
}
