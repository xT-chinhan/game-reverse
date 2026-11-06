package com.bytedance.sdk.component.ab.ah;

import android.content.SharedPreferences;
import com.bytedance.sdk.component.ch.ch;
import com.bytedance.sdk.openadsdk.ats.AutoService;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ah implements com.bytedance.sdk.component.d.ms.xr {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static ThreadPoolExecutor f734ms = null;
    private static int xr = 3;
    private final File ah;
    private final File d;
    private long hi;
    private long ny;
    private final com.bytedance.sdk.component.ab.xr sl;
    private final boolean u;
    private volatile boolean x;
    private final Object ka = new Object();
    private final Map<String, Object> c = new ConcurrentHashMap();
    private Map<String, Object> ab = new HashMap();
    private final List<Runnable> ch = new ArrayList();
    private AtomicBoolean zb = new AtomicBoolean(false);

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    static /* synthetic */ long ah(ah ahVar) {
        long j = ahVar.ny;
        ahVar.ny = 1 + j;
        return j;
    }

    public ah(File file, com.bytedance.sdk.component.ab.ms msVar, com.bytedance.sdk.component.ab.xr xrVar, boolean z) {
        this.x = false;
        this.u = z;
        File file2 = new File(file.getParent(), file.getName() + ".prop");
        if (file2.exists() && file2.length() > 0) {
            msVar = new com.bytedance.sdk.component.ab.ah.ms(null);
            file = file2;
        }
        this.ah = file;
        this.d = new File(file.getPath() + ".bak");
        this.x = false;
        msVar = msVar == null ? new com.bytedance.sdk.component.ab.ah.ms(null) : msVar;
        if (xrVar == null) {
            this.sl = new com.bytedance.sdk.component.ab.ah.ms(null);
        } else {
            this.sl = xrVar;
        }
        ms(msVar);
    }

    private void ms(final com.bytedance.sdk.component.ab.ms msVar) {
        synchronized (this.ka) {
            this.x = false;
        }
        ka().execute(new Runnable() { // from class: com.bytedance.sdk.component.ab.ah.ah.1
            @Override // java.lang.Runnable
            public void run() {
                ah.this.xr(msVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(com.bytedance.sdk.component.ab.ms msVar) {
        Map<String, Object> mapMs;
        synchronized (this.ka) {
            if (this.x) {
                return;
            }
            if (this.d.exists()) {
                this.ah.delete();
                this.d.renameTo(this.ah);
            }
            try {
                mapMs = msVar.ms(this.ah);
            } catch (Throwable th) {
                ms("loadFromDisk error", th);
                mapMs = null;
            }
            synchronized (this.ka) {
                this.x = true;
                if (mapMs != null) {
                    try {
                        for (Map.Entry<String, Object> entry : mapMs.entrySet()) {
                            Object value = entry.getValue();
                            if (value != null) {
                                String key = entry.getKey();
                                if (key == null) {
                                    key = "";
                                }
                                this.c.put(key, value);
                            }
                        }
                    } catch (Throwable th2) {
                        this.ka.notifyAll();
                        throw th2;
                    }
                }
                this.ka.notifyAll();
            }
            synchronized (this.ch) {
                Iterator<Runnable> it = this.ch.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
                this.ch.clear();
            }
        }
    }

    private void d() {
        while (!this.x) {
            try {
                this.ka.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    private static ThreadPoolExecutor ka() {
        ThreadPoolExecutor threadPoolExecutor = f734ms;
        if (threadPoolExecutor != null) {
            return threadPoolExecutor;
        }
        synchronized (ah.class) {
            ThreadPoolExecutor threadPoolExecutor2 = f734ms;
            if (threadPoolExecutor2 != null) {
                return threadPoolExecutor2;
            }
            int i = xr;
            com.bytedance.sdk.component.ch.d.d dVar = new com.bytedance.sdk.component.ch.d.d(i, i, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ch("SharedPreferencesImpl"));
            f734ms = dVar;
            return dVar;
        }
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        Map<String, ?> mapC;
        if (this.u) {
            synchronized (this.ka) {
                d();
                mapC = c();
            }
            return mapC;
        }
        return c();
    }

    private Map<String, ?> c() {
        HashMap map = new HashMap(this.c);
        map.putAll(this.ab);
        return map;
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        String strAh;
        if (str == null) {
            str = "";
        }
        if (this.u) {
            synchronized (this.ka) {
                d();
                strAh = ah(str, str2);
            }
            return strAh;
        }
        return ah(str, str2);
    }

    private String ah(String str, String str2) {
        try {
            Object obj = this.ab.get(str);
            if (obj == null) {
                obj = this.c.get(str);
            }
            return obj != null ? String.valueOf(obj) : str2;
        } catch (Exception e) {
            ms("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return str2;
        }
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> setAh;
        if (str == null) {
            str = "";
        }
        if (this.u) {
            synchronized (this.ka) {
                d();
                setAh = ah(str, set);
            }
            return setAh;
        }
        return ah(str, set);
    }

    private Set<String> ah(String str, Set<String> set) {
        try {
            Set<String> set2 = (Set) this.ab.get(str);
            if (set2 == null) {
                set2 = (Set) this.c.get(str);
            }
            return set2 != null ? set2 : set;
        } catch (Exception e) {
            ms("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return set;
        }
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        int iAh;
        if (str == null) {
            str = "";
        }
        if (this.u) {
            synchronized (this.ka) {
                d();
                iAh = ah(str, i);
            }
            return iAh;
        }
        return ah(str, i);
    }

    private int ah(String str, int i) {
        try {
            Object obj = this.ab.get(str);
            if (obj == null) {
                obj = this.c.get(str);
            }
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            if (obj instanceof Float) {
                return ((Float) obj).intValue();
            }
            return obj != null ? ((Integer) obj).intValue() : i;
        } catch (Exception e) {
            ms("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return i;
        }
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        long jAh;
        if (str == null) {
            str = "";
        }
        if (this.u) {
            synchronized (this.ka) {
                d();
                jAh = ah(str, j);
            }
            return jAh;
        }
        return ah(str, j);
    }

    private long ah(String str, long j) {
        try {
            Long l = (Long) this.ab.get(str);
            if (l == null) {
                l = (Long) this.c.get(str);
            }
            return l != null ? l.longValue() : j;
        } catch (Exception e) {
            ms("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return j;
        }
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        float fAh;
        if (str == null) {
            str = "";
        }
        if (this.u) {
            synchronized (this.ka) {
                d();
                fAh = ah(str, f);
            }
            return fAh;
        }
        return ah(str, f);
    }

    private float ah(String str, float f) {
        try {
            Object obj = this.ab.get(str);
            if (obj == null) {
                obj = this.c.get(str);
            }
            if (obj instanceof Integer) {
                return ((Integer) obj).floatValue();
            }
            if (obj instanceof Float) {
                return ((Float) obj).floatValue();
            }
            return obj != null ? ((Float) obj).floatValue() : f;
        } catch (Exception e) {
            ms("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return f;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        boolean zAh;
        if (str == null) {
            str = "";
        }
        if (this.u) {
            synchronized (this.ka) {
                d();
                zAh = ah(str, z);
            }
            return zAh;
        }
        return ah(str, z);
    }

    private boolean ah(String str, boolean z) {
        try {
            Boolean bool = (Boolean) this.ab.get(str);
            if (bool == null) {
                bool = (Boolean) this.c.get(str);
            }
            return bool != null ? bool.booleanValue() : z;
        } catch (Exception e) {
            ms("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return z;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        boolean zContainsKey;
        if (str == null) {
            str = "";
        }
        synchronized (this.ka) {
            d();
            zContainsKey = this.c.containsKey(str);
        }
        return zContainsKey;
    }

    @Override // android.content.SharedPreferences
    /* JADX INFO: renamed from: ah, reason: merged with bridge method [inline-methods] */
    public ms edit() {
        synchronized (this.ka) {
            d();
        }
        return new ms();
    }

    private void ms(Runnable runnable) {
        synchronized (this.ch) {
            if (this.x) {
                runnable.run();
            } else {
                this.ch.add(runnable);
            }
        }
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(final com.bytedance.sdk.component.d.ms.xr.ms<Map<String, ?>> msVar) {
        if (this.x) {
            msVar.ms(this.c);
        } else {
            ms(new Runnable() { // from class: com.bytedance.sdk.component.ab.ah.ah.4
                @Override // java.lang.Runnable
                public void run() {
                    msVar.ms(ah.this.c);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public int xr(String str, int i) {
        return getInt(str, i);
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public long xr(String str, long j) {
        return getLong(str, j);
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public float xr(String str, float f) {
        return getFloat(str, f);
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public boolean xr(String str, boolean z) {
        return getBoolean(str, z);
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public String xr(String str, String str2) {
        return getString(str, str2);
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public Set<String> xr(String str, Set<String> set) {
        return getStringSet(str, set);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void ms(String str, T t) {
        if (str == null) {
            str = "";
        }
        synchronized ("SharedPreferencesImpl") {
            this.ab.put(str, t);
            this.ny++;
        }
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(String str, int i) {
        ms(str, Integer.valueOf(i));
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(String str, long j) {
        ms(str, Long.valueOf(j));
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(String str, float f) {
        ms(str, Float.valueOf(f));
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(String str, boolean z) {
        ms(str, Boolean.valueOf(z));
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(String str, String str2) {
        ms(str, str2);
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(String str, Set<String> set) {
        ms(str, set);
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms(String str) {
        synchronized ("SharedPreferencesImpl") {
            this.ab.put(str, null);
            this.ny++;
        }
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void ms() {
        if (this.x) {
            this.c.clear();
            synchronized ("SharedPreferencesImpl") {
                this.ab.clear();
                this.ny++;
            }
            return;
        }
        ms(new Runnable() { // from class: com.bytedance.sdk.component.ab.ah.ah.5
            @Override // java.lang.Runnable
            public void run() {
                ah.this.c.clear();
                synchronized ("SharedPreferencesImpl") {
                    ah.this.ab.clear();
                    ah.ah(ah.this);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.d.ms.xr
    public void xr() {
        if (!this.x) {
            if (this.zb.compareAndSet(false, true)) {
                ms(new Runnable() { // from class: com.bytedance.sdk.component.ab.ah.ah.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ah.this.zb.set(false);
                        ah.this.xr();
                    }
                });
            }
        } else if (this.hi != this.ny && this.zb.compareAndSet(false, true)) {
            ka().execute(new Runnable() { // from class: com.bytedance.sdk.component.ab.ah.ah.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Map<String, Object> mapAb = ah.this.ab();
                        if (mapAb != null) {
                            ah.this.sl.ms(mapAb, ah.this.ah);
                        }
                        ah.this.zb.set(false);
                    } catch (Exception e) {
                        ah.this.ms("apply write error", (Throwable) e);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> ab() {
        HashMap map;
        synchronized ("SharedPreferencesImpl") {
            map = new HashMap(this.ab);
            this.ab = new HashMap();
        }
        HashMap map2 = new HashMap(this.c);
        if (map.isEmpty() && map2.isEmpty()) {
            return map2;
        }
        int i = 0;
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            Object obj = map2.get(str);
            if (value == null) {
                if (obj != null) {
                    map2.remove(str);
                    i++;
                }
            } else if (!value.equals(obj)) {
                map2.put(str, value);
                i++;
            }
        }
        if (i > 0) {
            return map2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(String str, Throwable th) {
        com.bytedance.sdk.component.d.ms msVar = (com.bytedance.sdk.component.d.ms) AutoService.ms(com.bytedance.sdk.component.d.ms.class);
        if (msVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("file", this.ah.getAbsolutePath());
                jSONObject.put("msg", str);
                jSONObject.put("class", "SharedPreferencesImpl");
            } catch (JSONException unused) {
            }
            msVar.ms("kv", jSONObject, th);
        }
    }

    public final class ms implements SharedPreferences.Editor {
        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return true;
        }

        public ms() {
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            ah.this.ms(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            ah.this.ms(str, set);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            ah.this.ms(str, Integer.valueOf(i));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            ah.this.ms(str, Long.valueOf(j));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f) {
            ah.this.ms(str, Float.valueOf(f));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            ah.this.ms(str, Boolean.valueOf(z));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            ah.this.ms(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            try {
                ah.ah(ah.this);
                ah.this.ab.clear();
            } catch (Exception unused) {
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            ah.this.xr();
        }
    }
}
