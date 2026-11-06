package com.umeng.commonsdk.internal.utils;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: CpuUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {

    /* JADX INFO: compiled from: CpuUtil.java */
    public static class a {
        public String a;
        public String b;
        public int c;
        public String d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public String l;
    }

    /* JADX WARN: Code duplicated, block: B:146:0x0174 A[Catch: IOException -> 0x0142, TRY_ENTER, TRY_LEAVE, TryCatch #10 {IOException -> 0x0142, blocks: (B:109:0x013e, B:146:0x0174), top: B:165:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:156:0x016d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:161:0x0160 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:168:0x0159 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:183:? A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static a a() throws Throwable {
        int i;
        a aVar;
        FileReader fileReader;
        ?? bufferedReader;
        Throwable th;
        try {
            try {
                try {
                    aVar = new a();
                    try {
                        fileReader = new FileReader("/proc/cpuinfo");
                        if (fileReader == null) {
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException e) {
                                }
                            }
                            return null;
                        }
                        try {
                            bufferedReader = new BufferedReader(fileReader);
                            if (bufferedReader == 0) {
                                if (fileReader != null) {
                                    try {
                                        fileReader.close();
                                    } catch (IOException e2) {
                                    }
                                }
                                if (bufferedReader != 0) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e3) {
                                    }
                                }
                                return null;
                            }
                            try {
                                try {
                                    int i2 = 0;
                                    boolean z = true;
                                    i = 0;
                                    for (String line = bufferedReader.readLine(); !TextUtils.isEmpty(line) && (i2 = i2 + 1) < 30; line = bufferedReader.readLine()) {
                                        try {
                                            String[] strArrSplit = line.split(":\\s+", 2);
                                            if (z && strArrSplit != null && strArrSplit.length > 1) {
                                                aVar.a = strArrSplit[1];
                                                z = false;
                                            }
                                            if (strArrSplit != null && strArrSplit.length > 1 && strArrSplit[0].contains("processor")) {
                                                i++;
                                            }
                                            if (strArrSplit != null && strArrSplit.length > 1 && strArrSplit[0].contains("Features")) {
                                                aVar.d = strArrSplit[1];
                                            }
                                            if (strArrSplit != null && strArrSplit.length > 1 && strArrSplit[0].contains("implementer")) {
                                                aVar.e = strArrSplit[1];
                                            }
                                            if (strArrSplit != null && strArrSplit.length > 1 && strArrSplit[0].contains("architecture")) {
                                                aVar.f = strArrSplit[1];
                                            }
                                            if (strArrSplit != null && strArrSplit.length > 1 && strArrSplit[0].contains("variant")) {
                                                aVar.g = strArrSplit[1];
                                            }
                                            if (strArrSplit != null && strArrSplit.length > 1 && strArrSplit[0].contains("part")) {
                                                aVar.h = strArrSplit[1];
                                            }
                                            if (strArrSplit != null && strArrSplit.length > 1 && strArrSplit[0].contains("revision")) {
                                                aVar.i = strArrSplit[1];
                                            }
                                            if (strArrSplit != null && strArrSplit.length > 1 && strArrSplit[0].contains("Hardware")) {
                                                aVar.j = strArrSplit[1];
                                            }
                                            if (strArrSplit != null && strArrSplit.length > 1 && strArrSplit[0].contains("Revision")) {
                                                aVar.k = strArrSplit[1];
                                            }
                                            if (strArrSplit != null && strArrSplit.length > 1 && strArrSplit[0].contains("Serial")) {
                                                aVar.l = strArrSplit[1];
                                            }
                                            if (strArrSplit != null && strArrSplit.length > 1 && strArrSplit[0].contains("implementer")) {
                                                aVar.e = strArrSplit[1];
                                            }
                                        } catch (Exception e4) {
                                            if (fileReader != null) {
                                                try {
                                                    fileReader.close();
                                                } catch (IOException e5) {
                                                }
                                            }
                                            if (bufferedReader != 0) {
                                                bufferedReader.close();
                                            }
                                            aVar.c = i;
                                            return aVar;
                                        }
                                    }
                                    if (fileReader != null) {
                                        try {
                                            fileReader.close();
                                        } catch (IOException e6) {
                                        }
                                    }
                                    if (bufferedReader != 0) {
                                        bufferedReader.close();
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (fileReader != null) {
                                        try {
                                            fileReader.close();
                                        } catch (IOException e7) {
                                        }
                                    }
                                    if (bufferedReader != 0) {
                                        throw th;
                                    }
                                    try {
                                        bufferedReader.close();
                                        throw th;
                                    } catch (IOException e8) {
                                        throw th;
                                    }
                                }
                            } catch (Exception e9) {
                                i = 0;
                                if (fileReader != null) {
                                    fileReader.close();
                                }
                                if (bufferedReader != 0) {
                                    bufferedReader.close();
                                }
                                aVar.c = i;
                                return aVar;
                            }
                            aVar.c = i;
                            return aVar;
                        } catch (Exception e10) {
                            bufferedReader = 0;
                        } catch (Throwable th3) {
                            th = th3;
                            bufferedReader = 0;
                            th = th;
                            if (fileReader != null) {
                                fileReader.close();
                            }
                            if (bufferedReader != 0) {
                                throw th;
                            }
                            bufferedReader.close();
                            throw th;
                        }
                    } catch (Exception e11) {
                        fileReader = null;
                        bufferedReader = fileReader;
                        i = 0;
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        if (bufferedReader != 0) {
                            bufferedReader.close();
                        }
                        aVar.c = i;
                        return aVar;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    fileReader = null;
                    bufferedReader = 0;
                }
            } catch (Exception e12) {
                aVar = null;
                fileReader = null;
            }
        } catch (IOException e13) {
        }
    }

    public static String b() {
        String str = "";
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (Exception e) {
        }
        return str.trim();
    }

    public static String c() {
        String str = "";
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (Exception e) {
        }
        return str.trim();
    }

    public static String d() throws Throwable {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq"));
            try {
                String strTrim = bufferedReader2.readLine().trim();
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Throwable th) {
                    }
                }
                return strTrim;
            } catch (Exception e) {
                bufferedReader = bufferedReader2;
                if (bufferedReader == null) {
                    return "";
                }
                try {
                    bufferedReader.close();
                    return "";
                } catch (Throwable th2) {
                    return "";
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th4) {
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
        } catch (Throwable th5) {
            th = th5;
        }
    }
}
