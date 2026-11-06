package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class n {
    public static final long a = System.currentTimeMillis();
    private static n b;
    private Context c;
    private SharedPreferences f;
    private Map<Integer, Map<String, m>> e = new HashMap();
    private String d = com.tencent.bugly.crashreport.common.info.a.b().d;

    private n(Context context) {
        this.c = context;
        this.f = context.getSharedPreferences("crashrecord", 0);
    }

    public static synchronized n a(Context context) {
        if (b == null) {
            b = new n(context);
        }
        return b;
    }

    public static synchronized n a() {
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean b(int i) {
        try {
            List<m> listC = c(i);
            if (listC == null) {
                return false;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (m mVar : listC) {
                if (mVar.b != null && mVar.b.equalsIgnoreCase(this.d) && mVar.d > 0) {
                    arrayList.add(mVar);
                }
                if (mVar.c + 86400000 < jCurrentTimeMillis) {
                    arrayList2.add(mVar);
                }
            }
            Collections.sort(arrayList);
            if (arrayList.size() >= 2) {
                if (arrayList.size() <= 0 || ((m) arrayList.get(arrayList.size() - 1)).c + 86400000 >= jCurrentTimeMillis) {
                    return true;
                }
                listC.clear();
                a(i, listC);
                return false;
            }
            listC.removeAll(arrayList2);
            a(i, listC);
            return false;
        } catch (Exception unused) {
            x.e("isFrequentCrash failed", new Object[0]);
            return false;
        }
    }

    public final synchronized void a(int i, final int i2) {
        final int i3 = 1004;
        w.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.n.1
            @Override // java.lang.Runnable
            public final void run() {
                m mVar;
                try {
                    if (TextUtils.isEmpty(n.this.d)) {
                        return;
                    }
                    List<m> listC = n.this.c(i3);
                    if (listC == null) {
                        listC = new ArrayList();
                    }
                    if (n.this.e.get(Integer.valueOf(i3)) == null) {
                        n.this.e.put(Integer.valueOf(i3), new HashMap());
                    }
                    if (((Map) n.this.e.get(Integer.valueOf(i3))).get(n.this.d) != null) {
                        mVar = (m) ((Map) n.this.e.get(Integer.valueOf(i3))).get(n.this.d);
                        mVar.d = i2;
                    } else {
                        mVar = new m();
                        mVar.a = i3;
                        mVar.g = n.a;
                        mVar.b = n.this.d;
                        mVar.f = com.tencent.bugly.crashreport.common.info.a.b().j;
                        com.tencent.bugly.crashreport.common.info.a.b().getClass();
                        mVar.e = "2.6.5";
                        mVar.c = System.currentTimeMillis();
                        mVar.d = i2;
                        ((Map) n.this.e.get(Integer.valueOf(i3))).put(n.this.d, mVar);
                    }
                    ArrayList arrayList = new ArrayList();
                    boolean z = false;
                    for (m mVar2 : listC) {
                        if (mVar2.g == mVar.g && mVar2.b != null && mVar2.b.equalsIgnoreCase(mVar.b)) {
                            mVar2.d = mVar.d;
                            z = true;
                        }
                        if ((mVar2.e != null && !mVar2.e.equalsIgnoreCase(mVar.e)) || ((mVar2.f != null && !mVar2.f.equalsIgnoreCase(mVar.f)) || mVar2.d <= 0)) {
                            arrayList.add(mVar2);
                        }
                    }
                    listC.removeAll(arrayList);
                    if (!z) {
                        listC.add(mVar);
                    }
                    n.this.a(i3, listC);
                } catch (Exception unused) {
                    x.e("saveCrashRecord failed", new Object[0]);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:18:0x0047 A[Catch: all -> 0x005d, Exception -> 0x005f, PHI: r6
      0x0047: PHI (r6v11 java.io.ObjectInputStream) = (r6v10 java.io.ObjectInputStream), (r6v12 java.io.ObjectInputStream) binds: [B:17:0x0045, B:22:0x0053] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x005f, blocks: (B:4:0x0003, B:10:0x0035, B:18:0x0047, B:26:0x0059, B:27:0x005c), top: B:37:0x0003, outer: #4 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r6v7 */
    public synchronized <T extends List<?>> T c(int i) {
        ObjectInputStream objectInputStream;
        try {
            File file = new File(this.c.getDir("crashrecord", 0), new StringBuilder().append(i).toString());
            ?? Exists = file.exists();
            try {
                if (Exists == 0) {
                    return null;
                }
                try {
                    objectInputStream = new ObjectInputStream(new FileInputStream(file));
                    try {
                        T t = (T) objectInputStream.readObject();
                        objectInputStream.close();
                        return t;
                    } catch (IOException unused) {
                        x.a("open record file error", new Object[0]);
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        return null;
                    } catch (ClassNotFoundException unused2) {
                        x.a("get object error", new Object[0]);
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        return null;
                    }
                } catch (IOException unused3) {
                    objectInputStream = null;
                } catch (ClassNotFoundException unused4) {
                    objectInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    Exists = 0;
                    if (Exists != 0) {
                        Exists.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused5) {
            x.e("readCrashRecord error", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:27:0x0050 A[Catch: all -> 0x0054, Exception -> 0x0056, TRY_ENTER, TryCatch #4 {Exception -> 0x0056, blocks: (B:7:0x0006, B:11:0x002e, B:21:0x0047, B:27:0x0050, B:28:0x0053), top: B:36:0x0006, outer: #2 }] */
    public synchronized <T extends List<?>> void a(int i, T t) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        IOException e;
        if (t == null) {
            return;
        }
        try {
            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(this.c.getDir("crashrecord", 0), new StringBuilder().append(i).toString())));
                try {
                    try {
                        objectOutputStream.writeObject(t);
                        objectOutputStream.close();
                    } catch (IOException e2) {
                        e = e2;
                        e.printStackTrace();
                        x.a("open record file error", new Object[0]);
                        if (objectOutputStream == null) {
                        } else {
                            objectOutputStream.close();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    throw th;
                }
            } catch (IOException e3) {
                objectOutputStream = null;
                e = e3;
            } catch (Throwable th3) {
                objectOutputStream = null;
                th = th3;
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                throw th;
            }
        } catch (Exception unused) {
            x.e("writeCrashRecord error", new Object[0]);
        }
    }

    public final synchronized boolean a(final int i) {
        boolean z;
        z = true;
        try {
            z = this.f.getBoolean(i + "_" + this.d, true);
            w.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.n.2
                @Override // java.lang.Runnable
                public final void run() {
                    n.this.f.edit().putBoolean(i + "_" + n.this.d, !n.this.b(i)).commit();
                }
            });
        } catch (Exception unused) {
            x.e("canInit error", new Object[0]);
            return z;
        }
        return z;
    }
}
