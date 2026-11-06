package com.byazt.qz;

import android.content.SharedPreferences;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import com.byazt.xlm.zo;
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
@com.byazt.vzx.pr(pr = {0, 1, 1192, 20})
public class hn implements com.byazt.cr.c {
    public long aj;
    public final boolean g;
    public final File hn;
    public final com.byazt.to.hw k;
    public long w;
    public final File x;
    public volatile boolean zo;
    public static ThreadPoolExecutor pr = null;
    public static int hw = 3;
    public final Object c = new Object();
    public final Map<String, Object> uc = new ConcurrentHashMap();
    public Map<String, Object> fw = new HashMap();
    public final List<Runnable> vk = new ArrayList();
    public AtomicBoolean m = new AtomicBoolean(false);

    public static /* synthetic */ long hn(hn hnVar) {
        long j = hnVar.aj;
        hnVar.aj = 1 + j;
        return j;
    }

    public hn(File file, com.byazt.to.pr prVar, com.byazt.to.hw hwVar, boolean z) {
        this.zo = false;
        this.g = z;
        File file2 = new File(file.getParent(), file.getName() + ".prop");
        if (file2.exists() && file2.length() > 0) {
            prVar = new com.byazt.qz.pr(null);
            file = file2;
        }
        this.hn = file;
        this.x = new File(file.getPath() + ".bak");
        this.zo = false;
        prVar = prVar == null ? new com.byazt.qz.pr(null) : prVar;
        if (hwVar == null) {
            this.k = new com.byazt.qz.pr(null);
        } else {
            this.k = hwVar;
        }
        pr(prVar);
    }

    private void pr(final com.byazt.to.pr prVar) {
        synchronized (this.c) {
            this.zo = false;
        }
        uc().execute(new Runnable() { // from class: com.byazt.qz.hn.1
            @Override // java.lang.Runnable
            public void run() {
                hn.this.hw(prVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(com.byazt.to.pr prVar) {
        synchronized (this.c) {
            if (this.zo) {
                return;
            }
            if (this.x.exists()) {
                this.hn.delete();
                this.x.renameTo(this.hn);
            }
            Map<String, Object> mapPr = null;
            try {
                mapPr = prVar.pr(this.hn);
            } catch (Throwable th) {
                pr("loadFromDisk error", th);
            }
            synchronized (this.c) {
                this.zo = true;
                if (mapPr != null) {
                    try {
                        for (Map.Entry<String, Object> entry : mapPr.entrySet()) {
                            Object value = entry.getValue();
                            if (value != null) {
                                String key = entry.getKey();
                                if (key == null) {
                                    key = "";
                                }
                                this.uc.put(key, value);
                            }
                        }
                    } catch (Throwable th2) {
                        this.c.notifyAll();
                        throw th2;
                    }
                }
                this.c.notifyAll();
            }
            synchronized (this.vk) {
                Iterator<Runnable> it = this.vk.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
                this.vk.clear();
            }
        }
    }

    private void c() {
        while (!this.zo) {
            try {
                this.c.wait();
            } catch (InterruptedException e) {
            }
        }
    }

    private static ThreadPoolExecutor uc() {
        ThreadPoolExecutor threadPoolExecutor = pr;
        if (threadPoolExecutor != null) {
            return threadPoolExecutor;
        }
        synchronized (hn.class) {
            ThreadPoolExecutor threadPoolExecutor2 = pr;
            if (threadPoolExecutor2 != null) {
                return threadPoolExecutor2;
            }
            int i = hw;
            com.byazt.fr.x xVar = new com.byazt.fr.x(i, i, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new zo("SharedPreferencesImpl"));
            pr = xVar;
            return xVar;
        }
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        Map<String, ?> mapFw;
        if (this.g) {
            synchronized (this.c) {
                c();
                mapFw = fw();
            }
            return mapFw;
        }
        return fw();
    }

    private Map<String, ?> fw() {
        HashMap map = new HashMap(this.uc);
        map.putAll(this.fw);
        return map;
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public String getString(String str, String str2) {
        String strHn;
        if (str == null) {
            str = "";
        }
        if (this.g) {
            synchronized (this.c) {
                c();
                strHn = hn(str, str2);
            }
            return strHn;
        }
        return hn(str, str2);
    }

    private String hn(String str, String str2) {
        try {
            Object obj = this.fw.get(str);
            if (obj == null) {
                obj = this.uc.get(str);
            }
            return obj != null ? String.valueOf(obj) : str2;
        } catch (Exception e) {
            pr("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return str2;
        }
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> setHn;
        if (str == null) {
            str = "";
        }
        if (this.g) {
            synchronized (this.c) {
                c();
                setHn = hn(str, set);
            }
            return setHn;
        }
        return hn(str, set);
    }

    private Set<String> hn(String str, Set<String> set) {
        try {
            Set<String> set2 = (Set) this.fw.get(str);
            if (set2 == null) {
                set2 = (Set) this.uc.get(str);
            }
            return set2 != null ? set2 : set;
        } catch (Exception e) {
            pr("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return set;
        }
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public int getInt(String str, int i) {
        int iHn;
        if (str == null) {
            str = "";
        }
        if (this.g) {
            synchronized (this.c) {
                c();
                iHn = hn(str, i);
            }
            return iHn;
        }
        return hn(str, i);
    }

    private int hn(String str, int i) {
        try {
            Object obj = this.fw.get(str);
            if (obj == null) {
                obj = this.uc.get(str);
            }
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            if (obj instanceof Float) {
                return ((Float) obj).intValue();
            }
            return obj != null ? ((Integer) obj).intValue() : i;
        } catch (Exception e) {
            pr("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return i;
        }
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public long getLong(String str, long j) {
        long jHn;
        if (str == null) {
            str = "";
        }
        if (this.g) {
            synchronized (this.c) {
                c();
                jHn = hn(str, j);
            }
            return jHn;
        }
        return hn(str, j);
    }

    private long hn(String str, long j) {
        try {
            Long l = (Long) this.fw.get(str);
            if (l == null) {
                l = (Long) this.uc.get(str);
            }
            return l != null ? l.longValue() : j;
        } catch (Exception e) {
            pr("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return j;
        }
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        float fHn;
        if (str == null) {
            str = "";
        }
        if (this.g) {
            synchronized (this.c) {
                c();
                fHn = hn(str, f);
            }
            return fHn;
        }
        return hn(str, f);
    }

    private float hn(String str, float f) {
        try {
            Object obj = this.fw.get(str);
            if (obj == null) {
                obj = this.uc.get(str);
            }
            if (obj instanceof Integer) {
                return ((Integer) obj).floatValue();
            }
            if (obj instanceof Float) {
                return ((Float) obj).floatValue();
            }
            return obj != null ? ((Float) obj).floatValue() : f;
        } catch (Exception e) {
            pr("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return f;
        }
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        boolean zHn;
        if (str == null) {
            str = "";
        }
        if (this.g) {
            synchronized (this.c) {
                c();
                zHn = hn(str, z);
            }
            return zHn;
        }
        return hn(str, z);
    }

    private boolean hn(String str, boolean z) {
        try {
            Boolean bool = (Boolean) this.fw.get(str);
            if (bool == null) {
                bool = (Boolean) this.uc.get(str);
            }
            return bool != null ? bool.booleanValue() : z;
        } catch (Exception e) {
            pr("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return z;
        }
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public boolean contains(String str) {
        boolean zContainsKey;
        if (str == null) {
            str = "";
        }
        synchronized (this.c) {
            c();
            zContainsKey = this.uc.containsKey(str);
        }
        return zContainsKey;
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public pr edit() {
        synchronized (this.c) {
            c();
        }
        return new pr();
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // com.byazt.cr.c, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    private void pr(Runnable runnable) {
        synchronized (this.vk) {
            if (this.zo) {
                runnable.run();
            } else {
                this.vk.add(runnable);
            }
        }
    }

    @Override // com.byazt.cr.c
    public int hw(String str, int i) {
        return getInt(str, i);
    }

    @Override // com.byazt.cr.c
    public long hw(String str, long j) {
        return getLong(str, j);
    }

    @Override // com.byazt.cr.c
    public float hw(String str, float f) {
        return getFloat(str, f);
    }

    @Override // com.byazt.cr.c
    public boolean hw(String str, boolean z) {
        return getBoolean(str, z);
    }

    @Override // com.byazt.cr.c
    public String hw(String str, String str2) {
        return getString(str, str2);
    }

    @Override // com.byazt.cr.c
    public Set<String> hw(String str, Set<String> set) {
        return getStringSet(str, set);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void pr(String str, T t) {
        if (str == null) {
            str = "";
        }
        synchronized ("SharedPreferencesImpl") {
            this.fw.put(str, t);
            this.aj++;
        }
    }

    @Override // com.byazt.cr.c
    public void pr(String str, int i) {
        pr(str, Integer.valueOf(i));
    }

    @Override // com.byazt.cr.c
    public void pr(String str, long j) {
        pr(str, Long.valueOf(j));
    }

    @Override // com.byazt.cr.c
    public void pr(String str, float f) {
        pr(str, Float.valueOf(f));
    }

    @Override // com.byazt.cr.c
    public void pr(String str, boolean z) {
        pr(str, Boolean.valueOf(z));
    }

    @Override // com.byazt.cr.c
    public void pr(String str, String str2) {
        pr(str, str2);
    }

    @Override // com.byazt.cr.c
    public void pr(String str, Set<String> set) {
        pr(str, set);
    }

    @Override // com.byazt.cr.c
    public void pr(String str) {
        synchronized ("SharedPreferencesImpl") {
            this.fw.put(str, null);
            this.aj++;
        }
    }

    @Override // com.byazt.cr.c
    public void pr() {
        if (this.zo) {
            this.uc.clear();
            synchronized ("SharedPreferencesImpl") {
                this.fw.clear();
                this.aj++;
            }
            return;
        }
        pr(new Runnable() { // from class: com.byazt.qz.hn.2
            @Override // java.lang.Runnable
            public void run() {
                hn.this.uc.clear();
                synchronized ("SharedPreferencesImpl") {
                    hn.this.fw.clear();
                    hn.hn(hn.this);
                }
            }
        });
    }

    @Override // com.byazt.cr.c
    public void hw() {
        if (!this.zo) {
            if (this.m.compareAndSet(false, true)) {
                pr(new Runnable() { // from class: com.byazt.qz.hn.3
                    @Override // java.lang.Runnable
                    public void run() {
                        hn.this.m.set(false);
                        hn.this.hw();
                    }
                });
            }
        } else if (this.w != this.aj && this.m.compareAndSet(false, true)) {
            uc().execute(new Runnable() { // from class: com.byazt.qz.hn.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            Map<String, Object> mapZo = hn.this.zo();
                            if (mapZo != null) {
                                hn.this.k.pr(mapZo, hn.this.hn);
                            }
                        } catch (Exception e) {
                            hn.this.pr("apply write error", (Throwable) e);
                        }
                    } finally {
                        hn.this.m.set(false);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> zo() {
        HashMap map;
        synchronized ("SharedPreferencesImpl") {
            map = new HashMap(this.fw);
            this.fw = new HashMap();
        }
        HashMap map2 = new HashMap(this.uc);
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
    public void pr(String str, final Throwable th) {
        com.byazt.fu.hn hnVar = (com.byazt.fu.hn) com.byazt.zs.uc.pr("ad_log", com.byazt.zs.uc.hw(null));
        if (hnVar != null) {
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("file", this.hn.getAbsolutePath());
                jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
                jSONObject.put("class", "SharedPreferencesImpl");
            } catch (JSONException e) {
            }
            hnVar.pr("exception", (byte) 1, new com.byazt.ttf.pr() { // from class: com.byazt.qz.hn.5
                @Override // com.byazt.ttf.pr
                public JSONObject pr(JSONObject jSONObject2) throws JSONException {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("scene", "kv");
                    jSONObject3.put("object", jSONObject);
                    Throwable th2 = th;
                    if (th2 != null) {
                        jSONObject3.put("exception", Log.getStackTraceString(th2));
                    }
                    return jSONObject3;
                }
            });
        }
    }

    @Override // com.byazt.cr.c
    public void hn() {
        if (!this.zo) {
            if (this.m.compareAndSet(false, true)) {
                pr(new Runnable() { // from class: com.byazt.qz.hn.6
                    @Override // java.lang.Runnable
                    public void run() {
                        hn.this.m.set(false);
                        hn.this.hn();
                    }
                });
                return;
            }
            return;
        }
        try {
            if (this.m.compareAndSet(false, true)) {
                try {
                    Map<String, Object> mapZo = zo();
                    if (mapZo != null) {
                        this.k.pr(mapZo, this.hn);
                    }
                } catch (Exception e) {
                    pr("applySync write error", (Throwable) e);
                }
            }
        } finally {
            this.m.set(false);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 1192, 116})
    public final class pr implements SharedPreferences.Editor {
        public pr() {
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            hn.this.pr(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            hn.this.pr(str, set);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            hn.this.pr(str, Integer.valueOf(i));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            hn.this.pr(str, Long.valueOf(j));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f) {
            hn.this.pr(str, Float.valueOf(f));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            hn.this.pr(str, Boolean.valueOf(z));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            hn.this.pr(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            try {
                hn.hn(hn.this);
                hn.this.fw.clear();
            } catch (Exception e) {
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            hn.this.hw();
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return true;
        }
    }
}
