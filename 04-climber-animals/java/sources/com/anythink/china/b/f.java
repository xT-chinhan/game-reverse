package com.anythink.china.b;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.common.d.j;
import com.anythink.core.common.d.t;
import com.anythink.core.common.d.u;
import com.anythink.core.common.e.g;
import com.anythink.core.common.v.af;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f {
    private static volatile f a;
    private Context e;
    private final List<Integer> b = new ArrayList(Collections.singletonList(46));
    private final Map<Integer, File> d = new HashMap();
    private final List<com.anythink.core.common.k.d> f = new ArrayList();
    private long g = e.a;
    private final AtomicBoolean c = new AtomicBoolean(true);

    public static f a() {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f();
                }
            }
        }
        return a;
    }

    public final Map<Integer, File> b() {
        return this.d;
    }

    private f() {
    }

    private boolean c() {
        return this.c.get();
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0155 A[Catch: all -> 0x01de, TRY_LEAVE, TryCatch #2 {all -> 0x01de, blocks: (B:3:0x0011, B:6:0x0017, B:8:0x0031, B:9:0x0037, B:10:0x003d, B:12:0x0044, B:14:0x005a, B:16:0x0066, B:18:0x008b, B:20:0x0095, B:22:0x00a4, B:24:0x00b2, B:27:0x00c0, B:28:0x00cf, B:30:0x00db, B:32:0x00e3, B:34:0x00f0, B:35:0x00fa, B:37:0x0100, B:44:0x0121, B:46:0x0135, B:43:0x011e, B:47:0x0139, B:49:0x0155, B:58:0x01a9, B:59:0x01c5, B:55:0x017f, B:38:0x0113, B:40:0x0119), top: B:71:0x0011, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x01c5 A[Catch: all -> 0x01de, TRY_LEAVE, TryCatch #2 {all -> 0x01de, blocks: (B:3:0x0011, B:6:0x0017, B:8:0x0031, B:9:0x0037, B:10:0x003d, B:12:0x0044, B:14:0x005a, B:16:0x0066, B:18:0x008b, B:20:0x0095, B:22:0x00a4, B:24:0x00b2, B:27:0x00c0, B:28:0x00cf, B:30:0x00db, B:32:0x00e3, B:34:0x00f0, B:35:0x00fa, B:37:0x0100, B:44:0x0121, B:46:0x0135, B:43:0x011e, B:47:0x0139, B:49:0x0155, B:58:0x01a9, B:59:0x01c5, B:55:0x017f, B:38:0x0113, B:40:0x0119), top: B:71:0x0011, inners: #0, #1 }] */
    public final void a(Context context) {
        ClassLoader classLoader;
        ClassLoader contextClassLoader;
        this.e = context;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            if (this.e != null) {
                char c2 = 0;
                this.c.set(false);
                com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(this.e).b(t.b().p());
                if (bVarB != null) {
                    this.g = bVarB.a();
                }
                for (Integer num : this.b) {
                    String strB = com.anythink.china.b.a.b(this.e, String.valueOf(num));
                    if (!TextUtils.isEmpty(strB)) {
                        String[] strArrSplit = strB.replaceAll(".jar", "").split("-");
                        if (strArrSplit.length == 3) {
                            File fileB = com.anythink.china.b.a.b(this.e, String.valueOf(num), strArrSplit[c2] + "-" + strArrSplit[1]);
                            if (fileB != null) {
                                if (!fileB.getName().equals(strB)) {
                                    String[] strArrSplit2 = fileB.getName().replaceAll(".jar", "").split("-");
                                    if (strArrSplit2.length == 3) {
                                        if (Integer.parseInt(strArrSplit[2]) > Integer.parseInt(strArrSplit2[2])) {
                                            fileB = com.anythink.china.b.a.a(this.e, String.valueOf(num), strB);
                                        }
                                    } else {
                                        fileB = null;
                                    }
                                }
                                if (fileB != null) {
                                    this.d.put(num, fileB);
                                    com.anythink.china.b.a.a(this.e, String.valueOf(num), fileB);
                                }
                            } else {
                                File fileA = com.anythink.china.b.a.a(this.e, String.valueOf(num), strB);
                                if (fileA != null) {
                                    this.d.put(num, fileA);
                                }
                            }
                        }
                    }
                    c2 = 0;
                }
                HashMap map = new HashMap();
                if (!this.d.isEmpty()) {
                    for (Map.Entry<Integer, File> entry : this.d.entrySet()) {
                        Integer key = entry.getKey();
                        File value = entry.getValue();
                        try {
                            if (Build.VERSION.SDK_INT >= 34) {
                                value.setReadOnly();
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        if (af.b(this.e, u.b.a, u.a.D.concat(String.valueOf(key)), 2) != 1) {
                            map.put(key, value);
                        }
                    }
                    new StringBuilder("pluginFiles:").append(this.d);
                    new StringBuilder("realFiles:").append(map);
                    if (!map.isEmpty()) {
                        classLoader = this.e.getClassLoader();
                        try {
                            contextClassLoader = Thread.currentThread().getContextClassLoader();
                            if (contextClassLoader != null && contextClassLoader != classLoader) {
                                new StringBuilder("replace class loader:").append(classLoader.hashCode()).append(":");
                                contextClassLoader.hashCode();
                                classLoader = contextClassLoader;
                            }
                        } catch (Throwable unused) {
                        }
                        try {
                            c.a(classLoader, new ArrayList(map.values()), this.e.getCacheDir());
                            com.anythink.core.common.u.e.a("0", "0", a(map), "1", "", String.valueOf(this.g), jElapsedRealtime);
                        } catch (Throwable th2) {
                            com.anythink.core.common.u.e.a("0", "0", a(map), "2", th2.getMessage(), String.valueOf(this.g), jElapsedRealtime);
                            th2.printStackTrace();
                        }
                    } else {
                        com.anythink.core.common.u.e.a("0", "1", a(this.d), "2", "", String.valueOf(this.g), jElapsedRealtime);
                    }
                } else {
                    new StringBuilder("pluginFiles:").append(this.d);
                    new StringBuilder("realFiles:").append(map);
                    if (!map.isEmpty()) {
                        classLoader = this.e.getClassLoader();
                        contextClassLoader = Thread.currentThread().getContextClassLoader();
                        if (contextClassLoader != null) {
                            new StringBuilder("replace class loader:").append(classLoader.hashCode()).append(":");
                            contextClassLoader.hashCode();
                            classLoader = contextClassLoader;
                        }
                        c.a(classLoader, new ArrayList(map.values()), this.e.getCacheDir());
                        com.anythink.core.common.u.e.a("0", "0", a(map), "1", "", String.valueOf(this.g), jElapsedRealtime);
                    } else {
                        com.anythink.core.common.u.e.a("0", "1", a(this.d), "2", "", String.valueOf(this.g), jElapsedRealtime);
                    }
                }
                this.c.set(true);
            }
        } catch (Throwable th3) {
            com.anythink.core.common.u.e.a("0", "2", a(this.d), "2", th3.getMessage(), String.valueOf(this.g), jElapsedRealtime);
            th3.printStackTrace();
        }
        d();
        e.a().b();
    }

    private void d() {
        try {
            synchronized (this.f) {
                if (!this.f.isEmpty()) {
                    for (int i = 0; i < this.f.size(); i++) {
                        com.anythink.core.common.k.d dVar = this.f.get(i);
                        if (dVar != null) {
                            dVar.a();
                        }
                    }
                    this.f.clear();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0150 A[Catch: all -> 0x01d9, TRY_LEAVE, TryCatch #2 {all -> 0x01d9, blocks: (B:3:0x000d, B:6:0x0012, B:8:0x002c, B:9:0x0032, B:10:0x0038, B:12:0x003f, B:14:0x0055, B:16:0x0061, B:18:0x0086, B:20:0x0090, B:22:0x009f, B:24:0x00ad, B:27:0x00bb, B:28:0x00ca, B:30:0x00d6, B:32:0x00de, B:34:0x00eb, B:35:0x00f5, B:37:0x00fb, B:44:0x011c, B:46:0x0130, B:43:0x0119, B:47:0x0134, B:49:0x0150, B:58:0x01a4, B:59:0x01c0, B:55:0x017a, B:38:0x010e, B:40:0x0114), top: B:70:0x000d, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x01c0 A[Catch: all -> 0x01d9, TRY_LEAVE, TryCatch #2 {all -> 0x01d9, blocks: (B:3:0x000d, B:6:0x0012, B:8:0x002c, B:9:0x0032, B:10:0x0038, B:12:0x003f, B:14:0x0055, B:16:0x0061, B:18:0x0086, B:20:0x0090, B:22:0x009f, B:24:0x00ad, B:27:0x00bb, B:28:0x00ca, B:30:0x00d6, B:32:0x00de, B:34:0x00eb, B:35:0x00f5, B:37:0x00fb, B:44:0x011c, B:46:0x0130, B:43:0x0119, B:47:0x0134, B:49:0x0150, B:58:0x01a4, B:59:0x01c0, B:55:0x017a, B:38:0x010e, B:40:0x0114), top: B:70:0x000d, inners: #0, #1 }] */
    private void e() {
        ClassLoader classLoader;
        ClassLoader contextClassLoader;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            if (this.e == null) {
                return;
            }
            char c2 = 0;
            this.c.set(false);
            com.anythink.core.d.b bVarB = com.anythink.core.d.d.a(this.e).b(t.b().p());
            if (bVarB != null) {
                this.g = bVarB.a();
            }
            for (Integer num : this.b) {
                String strB = com.anythink.china.b.a.b(this.e, String.valueOf(num));
                if (!TextUtils.isEmpty(strB)) {
                    String[] strArrSplit = strB.replaceAll(".jar", "").split("-");
                    if (strArrSplit.length == 3) {
                        File fileB = com.anythink.china.b.a.b(this.e, String.valueOf(num), strArrSplit[c2] + "-" + strArrSplit[1]);
                        if (fileB != null) {
                            if (!fileB.getName().equals(strB)) {
                                String[] strArrSplit2 = fileB.getName().replaceAll(".jar", "").split("-");
                                if (strArrSplit2.length == 3) {
                                    if (Integer.parseInt(strArrSplit[2]) > Integer.parseInt(strArrSplit2[2])) {
                                        fileB = com.anythink.china.b.a.a(this.e, String.valueOf(num), strB);
                                    }
                                } else {
                                    fileB = null;
                                }
                            }
                            if (fileB != null) {
                                this.d.put(num, fileB);
                                com.anythink.china.b.a.a(this.e, String.valueOf(num), fileB);
                            }
                        } else {
                            File fileA = com.anythink.china.b.a.a(this.e, String.valueOf(num), strB);
                            if (fileA != null) {
                                this.d.put(num, fileA);
                            }
                        }
                    }
                }
                c2 = 0;
            }
            HashMap map = new HashMap();
            if (!this.d.isEmpty()) {
                for (Map.Entry<Integer, File> entry : this.d.entrySet()) {
                    Integer key = entry.getKey();
                    File value = entry.getValue();
                    try {
                        if (Build.VERSION.SDK_INT >= 34) {
                            value.setReadOnly();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    if (af.b(this.e, u.b.a, u.a.D.concat(String.valueOf(key)), 2) != 1) {
                        map.put(key, value);
                    }
                }
                new StringBuilder("pluginFiles:").append(this.d);
                new StringBuilder("realFiles:").append(map);
                if (!map.isEmpty()) {
                    classLoader = this.e.getClassLoader();
                    try {
                        contextClassLoader = Thread.currentThread().getContextClassLoader();
                        if (contextClassLoader != null && contextClassLoader != classLoader) {
                            new StringBuilder("replace class loader:").append(classLoader.hashCode()).append(":");
                            contextClassLoader.hashCode();
                            classLoader = contextClassLoader;
                        }
                    } catch (Throwable unused) {
                    }
                    try {
                        c.a(classLoader, new ArrayList(map.values()), this.e.getCacheDir());
                        com.anythink.core.common.u.e.a("0", "0", a(map), "1", "", String.valueOf(this.g), jElapsedRealtime);
                    } catch (Throwable th2) {
                        com.anythink.core.common.u.e.a("0", "0", a(map), "2", th2.getMessage(), String.valueOf(this.g), jElapsedRealtime);
                        th2.printStackTrace();
                    }
                } else {
                    com.anythink.core.common.u.e.a("0", "1", a(this.d), "2", "", String.valueOf(this.g), jElapsedRealtime);
                }
            } else {
                new StringBuilder("pluginFiles:").append(this.d);
                new StringBuilder("realFiles:").append(map);
                if (!map.isEmpty()) {
                    classLoader = this.e.getClassLoader();
                    contextClassLoader = Thread.currentThread().getContextClassLoader();
                    if (contextClassLoader != null) {
                        new StringBuilder("replace class loader:").append(classLoader.hashCode()).append(":");
                        contextClassLoader.hashCode();
                        classLoader = contextClassLoader;
                    }
                    c.a(classLoader, new ArrayList(map.values()), this.e.getCacheDir());
                    com.anythink.core.common.u.e.a("0", "0", a(map), "1", "", String.valueOf(this.g), jElapsedRealtime);
                } else {
                    com.anythink.core.common.u.e.a("0", "1", a(this.d), "2", "", String.valueOf(this.g), jElapsedRealtime);
                }
            }
        } catch (Throwable th3) {
            com.anythink.core.common.u.e.a("0", "2", a(this.d), "2", th3.getMessage(), String.valueOf(this.g), jElapsedRealtime);
            th3.printStackTrace();
        }
        this.c.set(true);
    }

    public final String a(Map<Integer, File> map) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry<Integer, File> entry : map.entrySet()) {
                        Integer key = entry.getKey();
                        File value = entry.getValue();
                        JSONObject jSONObject3 = new JSONObject();
                        try {
                            jSONObject3.put("cli_ver", value.getName().replaceAll(".jar", ""));
                            jSONObject3.put("adn_ver", a().a(key));
                            jSONObject3.put("md5", com.anythink.china.b.a.a(value.getAbsolutePath()));
                            jSONObject3.put("dl_ts", value.lastModified());
                            jSONObject3.put(g.a.D, value.length());
                            Context context = this.e;
                            if (context != null) {
                                jSONObject3.put("forbid", af.b(context, u.b.a, u.a.D.concat(String.valueOf(key)), 2));
                            }
                            jSONObject2.put(String.valueOf(key), jSONObject3);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    jSONObject.put("hf_items", jSONObject2);
                    return jSONObject.toString();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return "";
    }

    private static void a(ClassLoader classLoader, List<File> list, File file) throws IllegalAccessException, NoSuchFieldException, IOException {
        c.a(classLoader, list, file);
    }

    private String a(Integer num) {
        if (num == null || !this.b.contains(num) || num.intValue() != 46) {
            return "";
        }
        try {
            Class<?> cls = Class.forName("com.bytedance.sdk.openadsdk.TTAdSdk");
            Method method = cls.getMethod("getAdManager", new Class[0]);
            method.setAccessible(true);
            Object objInvoke = method.invoke(cls, new Object[0]);
            if (objInvoke == null) {
                return "";
            }
            Method method2 = objInvoke.getClass().getMethod("getSDKVersion", new Class[0]);
            method2.setAccessible(true);
            return (String) method2.invoke(objInvoke, new Object[0]);
        } catch (Exception unused) {
            return "";
        }
    }

    private static final class c {
        private c() {
        }

        private static void b(ClassLoader classLoader, List<File> list, File file) throws IllegalAccessException, NoSuchFieldException, IOException {
            Object obj = com.anythink.china.b.c.a(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            com.anythink.china.b.c.a(obj, "dexElements", a(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    IOException iOException = (IOException) it.next();
                    Log.w(j.r, "Exception in makePathElement", iOException);
                    throw iOException;
                }
            }
        }

        private static Object[] a(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws NoSuchMethodException {
            Method methodA;
            try {
                methodA = com.anythink.china.b.c.a(obj, "makePathElements", (Class<?>[]) new Class[]{List.class, File.class, List.class});
            } catch (NoSuchMethodException unused) {
                Log.e(j.r, "NoSuchMethodException: makePathElements(List,File,List) failure");
                try {
                    methodA = com.anythink.china.b.c.a(obj, "makePathElements", (Class<?>[]) new Class[]{ArrayList.class, File.class, ArrayList.class});
                } catch (NoSuchMethodException unused2) {
                    Log.e(j.r, "NoSuchMethodException: makeDexElements(ArrayList,File,ArrayList) failure");
                    try {
                        Log.e(j.r, "NoSuchMethodException: try use v19 instead");
                        return b.b(obj, arrayList, file, arrayList2);
                    } catch (NoSuchMethodException e) {
                        Log.e(j.r, "NoSuchMethodException: makeDexElements(List,File,List) failure");
                        throw e;
                    }
                }
            }
            return (Object[]) methodA.invoke(obj, arrayList, file, arrayList2);
        }

        static /* synthetic */ void a(ClassLoader classLoader, List list, File file) throws IllegalAccessException, NoSuchFieldException, IOException {
            Object obj = com.anythink.china.b.c.a(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            com.anythink.china.b.c.a(obj, "dexElements", a(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    IOException iOException = (IOException) it.next();
                    Log.w(j.r, "Exception in makePathElement", iOException);
                    throw iOException;
                }
            }
        }
    }

    private static final class b {
        private b() {
        }

        private static void b(ClassLoader classLoader, List<File> list, File file) throws IllegalAccessException, NoSuchFieldException, IOException {
            Object obj = com.anythink.china.b.c.a(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            com.anythink.china.b.c.a(obj, "dexElements", b(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    IOException iOException = (IOException) it.next();
                    Log.w(j.r, "Exception in makeDexElement", iOException);
                    throw iOException;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Object[] b(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws NoSuchMethodException {
            Method methodA;
            try {
                methodA = com.anythink.china.b.c.a(obj, "makeDexElements", (Class<?>[]) new Class[]{ArrayList.class, File.class, ArrayList.class});
            } catch (NoSuchMethodException unused) {
                Log.e(j.r, "NoSuchMethodException: makeDexElements(ArrayList,File,ArrayList) failure");
                try {
                    methodA = com.anythink.china.b.c.a(obj, "makeDexElements", (Class<?>[]) new Class[]{List.class, File.class, List.class});
                } catch (NoSuchMethodException e) {
                    Log.e(j.r, "NoSuchMethodException: makeDexElements(List,File,List) failure");
                    throw e;
                }
            }
            return (Object[]) methodA.invoke(obj, arrayList, file, arrayList2);
        }

        static /* synthetic */ void a(ClassLoader classLoader, List list, File file) throws IllegalAccessException, NoSuchFieldException, IOException {
            Object obj = com.anythink.china.b.c.a(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            com.anythink.china.b.c.a(obj, "dexElements", b(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    IOException iOException = (IOException) it.next();
                    Log.w(j.r, "Exception in makeDexElement", iOException);
                    throw iOException;
                }
            }
        }
    }

    private static final class a {
        private a() {
        }

        private static void b(ClassLoader classLoader, List<File> list, File file) throws IllegalAccessException, NoSuchFieldException {
            Object obj = com.anythink.china.b.c.a(classLoader, "pathList").get(classLoader);
            com.anythink.china.b.c.a(obj, "dexElements", (Object[]) com.anythink.china.b.c.a(obj, "makeDexElements", (Class<?>[]) new Class[]{ArrayList.class, File.class}).invoke(obj, new ArrayList(list), file));
        }

        private static Object[] a(Object obj, ArrayList<File> arrayList, File file) {
            return (Object[]) com.anythink.china.b.c.a(obj, "makeDexElements", (Class<?>[]) new Class[]{ArrayList.class, File.class}).invoke(obj, arrayList, file);
        }

        static /* synthetic */ void a(ClassLoader classLoader, List list, File file) throws IllegalAccessException, NoSuchFieldException {
            Object obj = com.anythink.china.b.c.a(classLoader, "pathList").get(classLoader);
            com.anythink.china.b.c.a(obj, "dexElements", (Object[]) com.anythink.china.b.c.a(obj, "makeDexElements", (Class<?>[]) new Class[]{ArrayList.class, File.class}).invoke(obj, new ArrayList(list), file));
        }
    }

    public final void a(com.anythink.core.common.k.d dVar) {
        if (dVar != null) {
            if (this.c.get()) {
                dVar.a();
                return;
            }
            synchronized (this.f) {
                if (!this.f.contains(dVar)) {
                    this.f.add(dVar);
                }
            }
        }
    }
}
