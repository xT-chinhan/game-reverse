package com.smartdigimkt.f;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class u {
    public static volatile u g;
    public Context e;
    public final ArrayList a = new ArrayList(Collections.singletonList("1"));
    public final HashMap d = new HashMap();
    public final ArrayList f = new ArrayList();
    public final AtomicBoolean b = new AtomicBoolean(false);
    public final AtomicBoolean c = new AtomicBoolean(false);

    /* JADX WARN: Code duplicated, block: B:15:0x0054  */
    public static void a(u uVar, ArrayList arrayList) {
        File file;
        uVar.getClass();
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        try {
            if (uVar.e == null) {
                return;
            }
            arrayList.size();
            HashMap map = new HashMap();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                q qVar = (q) it.next();
                String str = qVar.f;
                Context context = uVar.e;
                String str2 = qVar.a;
                try {
                    File fileA = j.a(context, str);
                    if (fileA != null) {
                        file = new File(fileA.getAbsolutePath(), str2 + ".jar");
                        if (!file.exists()) {
                            file = null;
                        }
                    } else {
                        file = null;
                    }
                } catch (Throwable unused) {
                }
                if (file != null) {
                    file.getName();
                }
                if (file != null) {
                    uVar.d.put(str, file);
                    if (qVar.g == 2) {
                        try {
                            if (Build.VERSION.SDK_INT < 34 || file.setReadOnly()) {
                                map.put(str, file);
                            }
                        } catch (Throwable th) {
                            th.getMessage();
                        }
                    }
                    j.a(uVar.e, String.valueOf(str), file);
                }
            }
            Objects.toString(uVar.d);
            map.toString();
            if (map.isEmpty()) {
                com.smartdigimkt.n3.k.a("0", "1", a(uVar.d), "2", "", jElapsedRealtime);
                return;
            }
            ClassLoader classLoader = uVar.e.getClassLoader();
            try {
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                if (contextClassLoader != null && contextClassLoader != classLoader) {
                    classLoader.hashCode();
                    contextClassLoader.hashCode();
                    classLoader = contextClassLoader;
                }
            } catch (Throwable unused2) {
            }
            try {
                a(classLoader, new ArrayList(map.values()), uVar.e.getCacheDir());
                com.smartdigimkt.n3.k.a("0", "0", a(map), "1", "", jElapsedRealtime);
                uVar.c.set(true);
                uVar.b();
            } catch (Throwable th2) {
                com.smartdigimkt.n3.k.a("0", "0", a(map), "2", Log.getStackTraceString(th2), jElapsedRealtime);
                Log.getStackTraceString(th2);
            }
        } catch (Throwable th3) {
            com.smartdigimkt.n3.k.a("0", "2", a(uVar.d), "2", th3.getMessage(), jElapsedRealtime);
            th3.printStackTrace();
        }
    }

    public final void b() {
        try {
            synchronized (this.f) {
                if (!this.f.isEmpty()) {
                    for (int i = 0; i < this.f.size(); i++) {
                        b bVar = (b) this.f.get(i);
                        if (bVar != null) {
                            h hVar = bVar.a.b;
                            String str = hVar.a;
                            hVar.e.set(true);
                            c cVar = bVar.a;
                            cVar.b.a(cVar.a);
                        }
                    }
                    this.f.clear();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String b(HashMap map) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry entry : map.entrySet()) {
                        File file = (File) entry.getValue();
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("cli_ver", file.getName().replaceAll(".jar", ""));
                            jSONObject2.put("adx_ver", "UA_6.5.90");
                            jSONArray.put(jSONObject2);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("pg_items", jSONArray);
                    }
                    return jSONObject.toString();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return "";
    }

    public static u a() {
        if (g == null) {
            synchronized (u.class) {
                if (g == null) {
                    g = new u();
                }
            }
        }
        return g;
    }

    public final void a(b bVar) {
        if (this.c.get()) {
            h hVar = bVar.a.b;
            String str = hVar.a;
            hVar.e.set(true);
            c cVar = bVar.a;
            cVar.b.a(cVar.a);
            return;
        }
        synchronized (this.f) {
            if (!this.f.contains(bVar)) {
                this.f.add(bVar);
            }
        }
    }

    public final void a(Context context) {
        if (this.b.get()) {
            return;
        }
        this.b.set(true);
        this.e = context;
        for (String str : this.a) {
            File file = null;
            try {
                File fileA = j.a(this.e, String.valueOf(str));
                if (fileA.exists() && fileA.isDirectory()) {
                    File[] fileArrListFiles = fileA.listFiles();
                    if (fileArrListFiles != null && fileArrListFiles.length != 0) {
                        File file2 = null;
                        for (File file3 : fileArrListFiles) {
                            if (file3.isFile() && file3.getName().endsWith("jar") && (file2 == null || file3.lastModified() > file2.lastModified())) {
                                file2 = file3;
                            }
                        }
                        if (file2 != null) {
                            file2.getName();
                        }
                        file = file2;
                    }
                } else {
                    fileA.getAbsolutePath();
                }
            } catch (Throwable unused) {
            }
            if (file != null) {
                this.d.put(str, file);
                j.a(this.e, String.valueOf(str), file);
                file.getName();
            }
        }
        if (r.f == null) {
            synchronized (r.class) {
                if (r.f == null) {
                    r.f = new r();
                }
            }
        }
        r rVar = r.f;
        Context context2 = this.e;
        s sVar = new s(this);
        rVar.d = context2;
        rVar.a = sVar;
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            rVar.a();
            String.valueOf(com.anythink.core.common.g.c.a);
            com.smartdigimkt.n3.k.a("1", "0", "", "", "", jElapsedRealtime);
        } catch (Throwable unused2) {
        }
    }

    public static String a(HashMap map) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry entry : map.entrySet()) {
                        String str = (String) entry.getKey();
                        File file = (File) entry.getValue();
                        JSONObject jSONObject3 = new JSONObject();
                        try {
                            jSONObject3.put("cli_ver", file.getName().replaceAll(".jar", ""));
                            jSONObject3.put("adn_ver", "UA_6.5.90");
                            jSONObject3.put("md5", j.a(file.getAbsolutePath()));
                            jSONObject3.put("dl_ts", file.lastModified());
                            jSONObject3.put("file_size", file.length());
                            jSONObject2.put(String.valueOf(str), jSONObject3);
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

    public static void a(ClassLoader classLoader, ArrayList arrayList, File file) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, IOException {
        Object[] objArrA;
        Method methodA;
        Object obj = m.a(classLoader, "pathList").get(classLoader);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(arrayList);
        try {
            try {
                methodA = m.a(obj, "makePathElements", List.class, File.class, List.class);
            } catch (NoSuchMethodException unused) {
                methodA = m.a(obj, "makePathElements", ArrayList.class, File.class, ArrayList.class);
            }
            objArrA = (Object[]) methodA.invoke(obj, arrayList3, file, arrayList2);
        } catch (NoSuchMethodException unused2) {
            objArrA = t.a(obj, arrayList3, file, arrayList2);
        }
        m.a(obj, objArrA);
        if (arrayList2.size() > 0) {
            Iterator it = arrayList2.iterator();
            if (it.hasNext()) {
                throw ((IOException) it.next());
            }
        }
    }
}
