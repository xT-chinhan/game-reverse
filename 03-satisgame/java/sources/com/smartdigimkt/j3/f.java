package com.smartdigimkt.j3;

import android.content.Context;
import android.text.TextUtils;
import com.smartdigimkt.i3.n;
import com.smartdigimkt.i3.o;
import com.smartdigimkt.r4.i;
import com.smartdigimkt.sdk.core.SDKContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static volatile f e;
    public final Context a;
    public final ConcurrentHashMap b = new ConcurrentHashMap();
    public final ConcurrentHashMap c = new ConcurrentHashMap();
    public final ConcurrentHashMap d = new ConcurrentHashMap();

    public f(Context context) {
        if (context != null) {
            this.a = context.getApplicationContext();
        } else {
            this.a = SDKContext.getInstance().d();
        }
    }

    public final void a(int i, String str, String str2) {
        synchronized (this.b) {
            String strB = i.b(str);
            File file = new File(n.a().b(5, strB));
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(n.a().b(6, strB));
            if (file2.exists()) {
                file2.delete();
            }
            LinkedList<com.smartdigimkt.d0.n> linkedList = (LinkedList) this.b.remove(str);
            if (linkedList != null) {
                for (com.smartdigimkt.d0.n nVar : linkedList) {
                    if (nVar != null) {
                        com.smartdigimkt.q3.f.a().a(new d(nVar, str, i, str2));
                    }
                }
            }
            this.d.remove(str);
            this.c.remove(str);
        }
    }

    /* JADX WARN: Code duplicated, block: B:129:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:131:0x01af  */
    /* JADX WARN: Code duplicated, block: B:133:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:137:0x01d7 A[Catch: all -> 0x0231, TRY_LEAVE, TryCatch #10 {, blocks: (B:135:0x01c0, B:137:0x01d7, B:154:0x022f, B:153:0x022c, B:138:0x01da, B:140:0x01e4, B:142:0x01ee, B:144:0x01fa, B:145:0x01ff, B:147:0x0205, B:149:0x020e, B:150:0x0220), top: B:182:0x01c0, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:140:0x01e4 A[Catch: all -> 0x022b, TryCatch #5 {all -> 0x022b, blocks: (B:138:0x01da, B:140:0x01e4, B:142:0x01ee, B:144:0x01fa, B:145:0x01ff, B:147:0x0205, B:149:0x020e, B:150:0x0220), top: B:172:0x01da, outer: #10 }] */
    /* JADX WARN: Code duplicated, block: B:142:0x01ee A[Catch: all -> 0x022b, TryCatch #5 {all -> 0x022b, blocks: (B:138:0x01da, B:140:0x01e4, B:142:0x01ee, B:144:0x01fa, B:145:0x01ff, B:147:0x0205, B:149:0x020e, B:150:0x0220), top: B:172:0x01da, outer: #10 }] */
    /* JADX WARN: Code duplicated, block: B:143:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:147:0x0205 A[Catch: all -> 0x022b, TryCatch #5 {all -> 0x022b, blocks: (B:138:0x01da, B:140:0x01e4, B:142:0x01ee, B:144:0x01fa, B:145:0x01ff, B:147:0x0205, B:149:0x020e, B:150:0x0220), top: B:172:0x01da, outer: #10 }] */
    /* JADX WARN: Code duplicated, block: B:159:0x0234  */
    /* JADX WARN: Code duplicated, block: B:160:0x023b  */
    /* JADX WARN: Code duplicated, block: B:166:0x0161 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:178:0x016c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:182:0x01c0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:214:0x020e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:216:0x01ff A[SYNTHETIC] */
    public final void a(String str) {
        long jCurrentTimeMillis;
        String str2;
        String strB;
        File file;
        LinkedList<com.smartdigimkt.d0.n> linkedList;
        Long l;
        long jCurrentTimeMillis2;
        long j;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        Throwable th;
        String canonicalPath;
        String strB2 = i.b(str);
        String strB3 = n.a().b(5, strB2);
        String strB4 = n.a().b(6, strB2);
        File file2 = new File(strB4);
        if (file2.exists()) {
            file2.delete();
        }
        long jCurrentTimeMillis3 = System.currentTimeMillis();
        byte b = -1;
        if (strB3 != null && strB4 != null) {
            if (!strB4.endsWith("/")) {
                strB4 = strB4.concat("/");
            }
            File file3 = new File(strB3);
            if (file3.exists()) {
                FileOutputStream fileOutputStream2 = null;
                InputStream inputStream2 = null;
                try {
                    ZipFile zipFile = new ZipFile(file3);
                    Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
                    FileOutputStream fileOutputStream3 = null;
                    while (true) {
                        try {
                            if (enumerationEntries.hasMoreElements()) {
                                ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                                try {
                                    if (zipEntryNextElement == null) {
                                        if (inputStream2 != null) {
                                            try {
                                                inputStream2.close();
                                            } catch (Throwable th2) {
                                                th2.getMessage();
                                            }
                                        }
                                        if (fileOutputStream3 != null) {
                                            fileOutputStream3.close();
                                        }
                                    } else {
                                        String name = zipEntryNextElement.getName();
                                        if (TextUtils.isEmpty(name) || name.startsWith("..") || name.startsWith("../")) {
                                            if (inputStream2 != null) {
                                                try {
                                                    inputStream2.close();
                                                } catch (Throwable th3) {
                                                    th3.getMessage();
                                                }
                                            }
                                            if (fileOutputStream3 != null) {
                                                fileOutputStream3.close();
                                            }
                                        } else {
                                            File file4 = new File(strB4 + name);
                                            try {
                                                canonicalPath = file4.getCanonicalPath();
                                            } catch (IOException unused) {
                                                canonicalPath = "";
                                            }
                                            if (!TextUtils.isEmpty(canonicalPath) && canonicalPath.startsWith(strB4) && !canonicalPath.startsWith("..") && !canonicalPath.startsWith("../")) {
                                                if (zipEntryNextElement.isDirectory()) {
                                                    file4.mkdirs();
                                                } else {
                                                    if (!file4.getParentFile().exists()) {
                                                        file4.getParentFile().mkdirs();
                                                    }
                                                    fileOutputStream = new FileOutputStream(file4);
                                                    try {
                                                        inputStream2 = zipFile.getInputStream(zipEntryNextElement);
                                                        byte[] bArr = new byte[1024];
                                                        while (true) {
                                                            int i = inputStream2.read(bArr, 0, 1024);
                                                            if (i == -1) {
                                                                break;
                                                            }
                                                            fileOutputStream.write(bArr, 0, i);
                                                            fileOutputStream.flush();
                                                        }
                                                        fileOutputStream3 = fileOutputStream;
                                                    } catch (Throwable th4) {
                                                        th = th4;
                                                        try {
                                                            th.getMessage();
                                                            if (inputStream2 != null) {
                                                                try {
                                                                    inputStream2.close();
                                                                } catch (Throwable th5) {
                                                                    th5.getMessage();
                                                                }
                                                            }
                                                            if (fileOutputStream != null) {
                                                                try {
                                                                    fileOutputStream.close();
                                                                } catch (Throwable th6) {
                                                                    th = th6;
                                                                    b = 3;
                                                                    th.getMessage();
                                                                }
                                                            }
                                                            b = 3;
                                                            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis3;
                                                            str2 = (String) this.d.get(str);
                                                            if (!TextUtils.isEmpty(str2)) {
                                                                com.smartdigimkt.n3.b.a().a(jCurrentTimeMillis, str2, "unzip");
                                                            }
                                                            if (b == 0) {
                                                                strB = n.a().b(str);
                                                                if (!TextUtils.isEmpty(strB)) {
                                                                    synchronized (this.b) {
                                                                        file = new File(n.a().b(5, i.b(str)));
                                                                        if (file.exists()) {
                                                                            file.delete();
                                                                        }
                                                                        try {
                                                                            linkedList = (LinkedList) this.b.remove(str);
                                                                            if (linkedList != null) {
                                                                                l = (Long) this.c.get(str);
                                                                                if (l != null) {
                                                                                    jCurrentTimeMillis2 = System.currentTimeMillis() - l.longValue();
                                                                                } else {
                                                                                    jCurrentTimeMillis2 = 0;
                                                                                }
                                                                                j = jCurrentTimeMillis2;
                                                                                for (com.smartdigimkt.d0.n nVar : linkedList) {
                                                                                    if (nVar != null) {
                                                                                        com.smartdigimkt.q3.f.a().a(new c(strB, nVar, str, j));
                                                                                    }
                                                                                }
                                                                            }
                                                                            this.d.remove(str);
                                                                            this.c.remove(str);
                                                                        } catch (Throwable th7) {
                                                                            th7.printStackTrace();
                                                                        }
                                                                        return;
                                                                    }
                                                                }
                                                                a(3, str, "h5temp html file not exist");
                                                                return;
                                                            }
                                                            a(2, str, "H5temp url unzip fail");
                                                        } catch (Throwable th8) {
                                                            if (inputStream2 != null) {
                                                                try {
                                                                    inputStream2.close();
                                                                } catch (Throwable th9) {
                                                                    th9.getMessage();
                                                                }
                                                            }
                                                            if (fileOutputStream != null) {
                                                                try {
                                                                    fileOutputStream.close();
                                                                    throw th8;
                                                                } catch (Throwable th10) {
                                                                    th10.getMessage();
                                                                    throw th8;
                                                                }
                                                            }
                                                            throw th8;
                                                        }
                                                    }
                                                }
                                            }
                                            if (inputStream2 != null) {
                                                try {
                                                    inputStream2.close();
                                                } catch (Throwable th11) {
                                                    th11.getMessage();
                                                }
                                            }
                                            if (fileOutputStream3 != null) {
                                                fileOutputStream3.close();
                                            }
                                        }
                                    }
                                    b = 2;
                                } catch (Throwable th12) {
                                    th = th12;
                                    b = 2;
                                    th.getMessage();
                                }
                            } else {
                                zipFile.close();
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (Throwable th13) {
                                        th13.getMessage();
                                    }
                                }
                                if (fileOutputStream3 != null) {
                                    try {
                                        fileOutputStream3.close();
                                    } catch (Throwable th14) {
                                        th14.getMessage();
                                    }
                                }
                                b = 0;
                            }
                        } catch (Throwable th15) {
                            th = th15;
                            inputStream = inputStream2;
                            fileOutputStream2 = fileOutputStream3;
                            InputStream inputStream3 = inputStream;
                            fileOutputStream = fileOutputStream2;
                            inputStream2 = inputStream3;
                            th.getMessage();
                            if (inputStream2 != null) {
                                inputStream2.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            b = 3;
                            jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis3;
                            str2 = (String) this.d.get(str);
                            if (!TextUtils.isEmpty(str2)) {
                                com.smartdigimkt.n3.b.a().a(jCurrentTimeMillis, str2, "unzip");
                            }
                            if (b == 0) {
                                strB = n.a().b(str);
                                if (!TextUtils.isEmpty(strB)) {
                                    synchronized (this.b) {
                                        file = new File(n.a().b(5, i.b(str)));
                                        if (file.exists()) {
                                            file.delete();
                                        }
                                        linkedList = (LinkedList) this.b.remove(str);
                                        if (linkedList != null) {
                                            l = (Long) this.c.get(str);
                                            if (l != null) {
                                                jCurrentTimeMillis2 = System.currentTimeMillis() - l.longValue();
                                            } else {
                                                jCurrentTimeMillis2 = 0;
                                            }
                                            j = jCurrentTimeMillis2;
                                            while (r12.hasNext()) {
                                                if (nVar != null) {
                                                    com.smartdigimkt.q3.f.a().a(new c(strB, nVar, str, j));
                                                }
                                            }
                                        }
                                        this.d.remove(str);
                                        this.c.remove(str);
                                        return;
                                    }
                                }
                                a(3, str, "h5temp html file not exist");
                                return;
                            }
                            a(2, str, "H5temp url unzip fail");
                        }
                    }
                } catch (Throwable th16) {
                    th = th16;
                    inputStream = null;
                }
            } else {
                b = 1;
            }
        }
        jCurrentTimeMillis = System.currentTimeMillis() - jCurrentTimeMillis3;
        str2 = (String) this.d.get(str);
        if (!TextUtils.isEmpty(str2)) {
            com.smartdigimkt.n3.b.a().a(jCurrentTimeMillis, str2, "unzip");
        }
        if (b == 0) {
            strB = n.a().b(str);
            if (!TextUtils.isEmpty(strB)) {
                synchronized (this.b) {
                    file = new File(n.a().b(5, i.b(str)));
                    if (file.exists()) {
                        file.delete();
                    }
                    linkedList = (LinkedList) this.b.remove(str);
                    if (linkedList != null) {
                        l = (Long) this.c.get(str);
                        if (l != null) {
                            jCurrentTimeMillis2 = System.currentTimeMillis() - l.longValue();
                        } else {
                            jCurrentTimeMillis2 = 0;
                        }
                        j = jCurrentTimeMillis2;
                        while (r12.hasNext()) {
                            if (nVar != null) {
                                com.smartdigimkt.q3.f.a().a(new c(strB, nVar, str, j));
                            }
                        }
                    }
                    this.d.remove(str);
                    this.c.remove(str);
                }
                return;
            }
            a(3, str, "h5temp html file not exist");
            return;
        }
        a(2, str, "H5temp url unzip fail");
    }

    public final void a(String str, String str2, com.smartdigimkt.d0.n nVar) {
        if (TextUtils.isEmpty(str)) {
            nVar.a(1, str, "No url info.");
            return;
        }
        if (!str.endsWith(".zip")) {
            nVar.a(1, str, "Not zip file url");
            return;
        }
        String strB = n.a().b(str);
        if (!TextUtils.isEmpty(strB)) {
            nVar.a(0L, str, strB);
            return;
        }
        String strA = b.a().a(this.a);
        if (!TextUtils.isEmpty(strA)) {
            String strB2 = n.a().b(strA);
            if (!TextUtils.isEmpty(strB2)) {
                nVar.a(0L, strA, strB2);
                nVar = null;
            }
        }
        synchronized (this.b) {
            if (!TextUtils.isEmpty(str2)) {
                this.d.put(str, str2);
            }
            if (!this.c.contains(str)) {
                this.c.put(str, Long.valueOf(System.currentTimeMillis()));
            }
            if (!this.b.containsKey(str)) {
                LinkedList linkedList = new LinkedList();
                if (nVar != null) {
                    linkedList.add(nVar);
                }
                this.b.put(str, linkedList);
                String strB3 = i.b(str);
                n nVarA = n.a();
                nVarA.getClass();
                if (!TextUtils.isEmpty(strB3) && new File(nVarA.b(5, strB3)).exists()) {
                    a(str);
                } else {
                    o oVar = new o(5, str);
                    g gVar = new g(oVar);
                    String str3 = (String) this.d.get(str);
                    if (!TextUtils.isEmpty(str3)) {
                        gVar.i = str3;
                        gVar.j = "h5zip";
                    }
                    gVar.l = new e(this, oVar);
                    gVar.c();
                }
                return;
            }
            LinkedList linkedList2 = (LinkedList) this.b.get(str);
            if (linkedList2 != null && nVar != null && !linkedList2.contains(nVar)) {
                linkedList2.add(nVar);
            }
        }
    }
}
