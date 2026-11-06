package com.mcto.sspsdk.internal;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import com.bumptech.glide.load.Key;
import com.tapsdk.tapad.internal.ionia.IoniaAdWindowTracker;
import com.umeng.analytics.pro.an;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class v4 {
    public static final Object j = new Object();
    public static volatile v4 k;
    public final File a;
    public final AtomicInteger b;
    public final ConcurrentHashMap c;
    public final ConcurrentHashMap d;
    public volatile long e;
    public volatile long f;
    public final ScheduledExecutorService g;
    public final AtomicBoolean h;
    public final AtomicBoolean i;

    public v4(Context context) {
        long epochMilli;
        String string;
        int i;
        AtomicInteger atomicInteger = new AtomicInteger(0);
        this.b = atomicInteger;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.c = concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        this.d = concurrentHashMap2;
        this.e = 0L;
        this.f = 0L;
        this.g = Executors.newSingleThreadScheduledExecutor();
        this.h = new AtomicBoolean(false);
        this.i = new AtomicBoolean(false);
        File file = new File(context.getFilesDir(), ".issp_DCount");
        this.a = file;
        if (Build.VERSION.SDK_INT >= 26) {
            epochMilli = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        } else {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long offset = TimeZone.getDefault().getOffset(jCurrentTimeMillis);
            epochMilli = (((jCurrentTimeMillis + offset) / 86400000) * 86400000) - offset;
        }
        this.e = epochMilli;
        atomicInteger.set(0);
        concurrentHashMap.clear();
        concurrentHashMap2.clear();
        if (file.exists()) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), Key.STRING_CHARSET_NAME), 32768);
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        String[] strArrSplit = line.split("\t");
                        if (strArrSplit.length >= 3 && "v4".equals(strArrSplit[0])) {
                            try {
                                if (Long.parseLong(strArrSplit[1]) == this.e) {
                                    try {
                                        atomicInteger.set(Integer.parseInt(strArrSplit[2]));
                                        while (true) {
                                            String line2 = bufferedReader.readLine();
                                            if (line2 == null) {
                                                break;
                                            }
                                            if (!line2.isEmpty()) {
                                                String[] strArrSplit2 = line2.split("\t");
                                                if (strArrSplit2.length >= 3 && an.aB.equals(strArrSplit2[0])) {
                                                    try {
                                                        byte[] bArrDecode = Base64.decode(strArrSplit2[1], 10);
                                                        string = (bArrDecode == null || bArrDecode.length == 0) ? null : new BigInteger(1, bArrDecode).toString(10);
                                                    } catch (Throwable th) {
                                                    }
                                                    if (string != null) {
                                                        try {
                                                            i = Integer.parseInt(strArrSplit2[2]);
                                                        } catch (Throwable th2) {
                                                            i = 0;
                                                        }
                                                        if (i > 0) {
                                                            this.c.put(string, new AtomicInteger(i));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        this.b.set(0);
                                    }
                                    bufferedReader.close();
                                    return;
                                }
                            } catch (Throwable th4) {
                            }
                        }
                    }
                    bufferedReader.close();
                } catch (Throwable th5) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th6) {
                        th5.addSuppressed(th6);
                    }
                    throw th5;
                }
            } catch (Throwable th7) {
            }
        }
    }

    public static v4 a(Context context) {
        v4 v4Var;
        if (k != null) {
            return k;
        }
        synchronized (j) {
            if (k == null) {
                k = new v4(context);
            }
            v4Var = k;
        }
        return v4Var;
    }

    public final int b() {
        int iMax;
        synchronized (j) {
            a();
            iMax = Math.max(1, this.b.get());
        }
        return iMax;
    }

    public final void c() {
        this.h.set(true);
        if (this.i.compareAndSet(false, true)) {
            this.g.schedule(new u4(this), IoniaAdWindowTracker.BANNER_WINDOW_IDLE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
        }
    }

    public final void d() {
        synchronized (j) {
            a();
            if (this.f == 0) {
                this.f = System.currentTimeMillis();
            }
            this.b.incrementAndGet();
            c();
        }
    }

    public final int b(String str) {
        int iIncrementAndGet;
        if (str == null) {
            str = "";
        }
        synchronized (j) {
            a();
            AtomicInteger atomicInteger = (AtomicInteger) this.c.get(str);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger(0);
                AtomicInteger atomicInteger2 = (AtomicInteger) this.c.putIfAbsent(str, atomicInteger);
                if (atomicInteger2 != null) {
                    atomicInteger = atomicInteger2;
                }
            }
            iIncrementAndGet = atomicInteger.incrementAndGet();
            c();
        }
        return iIncrementAndGet;
    }

    public final void a() {
        long epochMilli;
        if (Build.VERSION.SDK_INT >= 26) {
            epochMilli = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        } else {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long offset = TimeZone.getDefault().getOffset(jCurrentTimeMillis);
            epochMilli = (((jCurrentTimeMillis + offset) / 86400000) * 86400000) - offset;
        }
        if (epochMilli == this.e) {
            return;
        }
        this.e = epochMilli;
        this.b.set(0);
        this.c.clear();
        this.d.clear();
        c();
    }

    public final void a(long j2, int i, HashMap map) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.a, false), Key.STRING_CHARSET_NAME), 32768);
        try {
            bufferedWriter.write("v4\t");
            bufferedWriter.write(String.valueOf(j2));
            bufferedWriter.write("\t");
            bufferedWriter.write(String.valueOf(i));
            bufferedWriter.write("\n");
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                Integer num = (Integer) entry.getValue();
                if (str != null && num != null && num.intValue() > 0) {
                    bufferedWriter.write("s\t");
                    bufferedWriter.write(a(str));
                    bufferedWriter.write("\t");
                    bufferedWriter.write(String.valueOf(num));
                    bufferedWriter.write("\n");
                }
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Throwable th) {
            try {
                bufferedWriter.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final String a(String str) {
        byte[] byteArray;
        String str2 = (String) this.d.get(str);
        if (str2 != null) {
            return str2;
        }
        BigInteger bigInteger = new BigInteger(str, 10);
        if (bigInteger.signum() >= 0) {
            if (BigInteger.ZERO.equals(bigInteger)) {
                byteArray = new byte[]{0};
            } else {
                byteArray = bigInteger.toByteArray();
                if (byteArray.length > 1 && byteArray[0] == 0) {
                    int length = byteArray.length - 1;
                    byte[] bArr = new byte[length];
                    System.arraycopy(byteArray, 1, bArr, 0, length);
                    byteArray = bArr;
                }
            }
            String strEncodeToString = Base64.encodeToString(byteArray, 10);
            String str3 = (String) this.d.putIfAbsent(str, strEncodeToString);
            return str3 != null ? str3 : strEncodeToString;
        }
        throw new IllegalArgumentException("codeId must be non-negative");
    }
}
