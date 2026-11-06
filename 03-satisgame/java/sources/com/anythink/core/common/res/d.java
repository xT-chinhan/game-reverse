package com.anythink.core.common.res;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.common.d.s;
import com.anythink.core.common.h.w;
import com.anythink.core.common.h.x;
import com.anythink.core.common.u.n;
import com.anythink.core.common.u.v;
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
    final long c = 172800000;

    private d(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.m = applicationContext;
        this.n = v.a(applicationContext);
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

    private String c() {
        return this.n.getAbsolutePath();
    }

    private String a(String str, x xVar, w wVar) {
        FileOutputStream fileOutputStream;
        File file = new File(this.n, j);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, xVar.f + "_" + wVar.h() + ".html");
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

    private void a(x xVar, w wVar) {
        try {
            File file = new File(new File(this.n, j), xVar.f + "_" + wVar.h() + ".html");
            if (file.exists()) {
                file.delete();
            }
        } catch (Throwable unused) {
        }
    }

    public final void a() {
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

    public static void b() {
        try {
            long jE = s.b().e(1);
            String strA = a(s.b().g()).a(1);
            long jA = v.a(strA);
            if (jA <= 0 || jA <= jE * 1.5d) {
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
                    if (jCurrentTimeMillis - file.lastModified() > 172800000) {
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

    private File b(x xVar, w wVar) {
        File file = new File(new File(this.n, j), xVar.f + "_" + wVar.h() + ".html");
        if (file.exists()) {
            return file;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x0073 A[EXC_TOP_SPLITTER, SYNTHETIC] */
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
        OutputStream outputStream2 = null;
        outputStreamA = null;
        outputStreamA = null;
        OutputStream outputStreamA = null;
        a.C0043a c0043a = null;
        try {
            try {
                a.c cVarA = aVarA.a(str);
                if (cVarA == null) {
                    a.C0043a c0043aB = aVarA.b(str);
                    if (c0043aB != null) {
                        try {
                            outputStreamA = c0043aB.a(0);
                            byte[] bArr = new byte[2048];
                            while (true) {
                                int i3 = inputStream.read(bArr);
                                if (i3 == -1) {
                                    break;
                                }
                                outputStreamA.write(bArr, 0, i3);
                            }
                            c0043aB.a();
                            outputStreamA.close();
                        } catch (Exception unused) {
                            OutputStream outputStream3 = outputStreamA;
                            c0043a = c0043aB;
                            outputStream = outputStream3;
                            if (c0043a != null) {
                                try {
                                    try {
                                        c0043a.b();
                                    } catch (Exception e) {
                                        e.printStackTrace();
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
                            if (outputStream == null) {
                                return false;
                            }
                            try {
                                outputStream.close();
                                return false;
                            } catch (IOException unused3) {
                                return false;
                            }
                        }
                    }
                } else {
                    cVarA.a().close();
                }
                if (outputStreamA != null) {
                    try {
                        outputStreamA.close();
                    } catch (IOException unused4) {
                    }
                }
                return true;
            } catch (Exception unused5) {
                outputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            if (outputStream2 != null) {
                outputStream2.close();
            }
            throw th;
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
            return new FileInputStream(new File(b(4, str)));
        } catch (Throwable unused) {
            return null;
        }
    }

    private synchronized a a(int i2, File file) {
        a aVarA;
        aVarA = this.b.get(Integer.valueOf(i2));
        if (aVarA == null) {
            try {
                aVarA = a.a(file, s.b().e(i2));
                this.b.put(Integer.valueOf(i2), aVarA);
            } catch (Throwable th) {
                if (s.b().G()) {
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

    private boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(b(5, str)).exists();
    }

    public final String b(int i2, String str) {
        return a(i2) + File.separator + c(i2, str);
    }

    private static String c(int i2, String str) {
        if (i2 == 4) {
            return str;
        }
        if (i2 != 5) {
            return i2 != 6 ? str + ".0" : str;
        }
        return str + ".zip";
    }

    private void d(int i2, String str) {
        File file;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (i2 != 4) {
                file = new File(a(i2) + File.separator + str + ".0");
            } else {
                file = new File(a(i2) + File.separator + str);
            }
            file.delete();
        } catch (Throwable unused) {
        }
    }

    public final String a(String str) {
        String strB = b(6, n.a(str));
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
}
