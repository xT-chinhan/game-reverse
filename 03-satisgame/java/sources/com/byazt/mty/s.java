package com.byazt.mty;

import android.content.SharedPreferences;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.byazt.qit.fs;
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
@com.byazt.cp.n(n = {0, 1, 669, 8})
public class s implements com.byazt.eau.l {
    public static ThreadPoolExecutor n = null;
    public static int qg = 3;
    public long cp;
    public final com.byazt.uyg.qg d;
    public volatile boolean fs;
    public final File q;
    public long rv;
    public final File s;
    public final boolean sz;
    public final Object l = new Object();
    public final Map<String, Object> w = new ConcurrentHashMap();
    public Map<String, Object> x = new HashMap();
    public final List<Runnable> tj = new ArrayList();
    public AtomicBoolean oa = new AtomicBoolean(false);

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    public static /* synthetic */ long s(s sVar) {
        long j = sVar.rv;
        sVar.rv = 1 + j;
        return j;
    }

    public s(File file, com.byazt.uyg.n nVar, com.byazt.uyg.qg qgVar, boolean z) {
        this.fs = false;
        this.sz = z;
        File file2 = new File(file.getParent(), file.getName() + ".prop");
        if (file2.exists() && file2.length() > 0) {
            nVar = new com.byazt.mty.n(null);
            file = file2;
        }
        this.s = file;
        this.q = new File(file.getPath() + ".bak");
        this.fs = false;
        nVar = nVar == null ? new com.byazt.mty.n(null) : nVar;
        if (qgVar == null) {
            this.d = new com.byazt.mty.n(null);
        } else {
            this.d = qgVar;
        }
        n(nVar);
    }

    private void n(final com.byazt.uyg.n nVar) {
        synchronized (this.l) {
            this.fs = false;
        }
        try {
            try {
                w().execute(new Runnable() { // from class: com.byazt.mty.s.1
                    @Override // java.lang.Runnable
                    public void run() {
                        s.this.qg(nVar);
                    }
                });
            } catch (Throwable unused) {
                qg(nVar);
            }
        } catch (Throwable unused2) {
            synchronized (this.l) {
                this.fs = true;
                this.l.notifyAll();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qg(com.byazt.uyg.n nVar) {
        Map<String, Object> mapN;
        synchronized (this.l) {
            if (this.fs) {
                return;
            }
            if (this.q.exists()) {
                this.s.delete();
                this.q.renameTo(this.s);
            }
            try {
                mapN = nVar.n(this.s);
            } catch (Throwable th) {
                n("loadFromDisk error", th);
                mapN = null;
            }
            synchronized (this.l) {
                try {
                    this.fs = true;
                    if (mapN != null) {
                        try {
                            for (Map.Entry<String, Object> entry : mapN.entrySet()) {
                                Object value = entry.getValue();
                                if (value != null) {
                                    String key = entry.getKey();
                                    if (key == null) {
                                        key = "";
                                    }
                                    this.w.put(key, value);
                                }
                            }
                        } catch (Throwable th2) {
                            this.l.notifyAll();
                            throw th2;
                        }
                    }
                    this.l.notifyAll();
                } catch (Throwable th3) {
                    throw th3;
                }
            }
            synchronized (this.tj) {
                Iterator<Runnable> it = this.tj.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
                this.tj.clear();
            }
        }
    }

    private void l() {
        while (!this.fs) {
            try {
                this.l.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    private static ThreadPoolExecutor w() {
        ThreadPoolExecutor threadPoolExecutor = n;
        if (threadPoolExecutor != null) {
            return threadPoolExecutor;
        }
        synchronized (s.class) {
            ThreadPoolExecutor threadPoolExecutor2 = n;
            if (threadPoolExecutor2 != null) {
                return threadPoolExecutor2;
            }
            int i = qg;
            com.byazt.xis.q qVar = new com.byazt.xis.q(i, i, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new fs("SharedPreferencesImpl"));
            n = qVar;
            return qVar;
        }
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        Map<String, ?> mapX;
        if (this.sz) {
            synchronized (this.l) {
                l();
                mapX = x();
            }
            return mapX;
        }
        return x();
    }

    private Map<String, ?> x() {
        HashMap map = new HashMap(this.w);
        map.putAll(this.x);
        return map;
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public String getString(String str, String str2) {
        String strS;
        if (str == null) {
            str = "";
        }
        if (this.sz) {
            synchronized (this.l) {
                l();
                strS = s(str, str2);
            }
            return strS;
        }
        return s(str, str2);
    }

    private String s(String str, String str2) {
        try {
            Object obj = this.x.get(str);
            if (obj == null) {
                obj = this.w.get(str);
            }
            return obj != null ? String.valueOf(obj) : str2;
        } catch (Exception e) {
            n("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return str2;
        }
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> setS;
        if (str == null) {
            str = "";
        }
        if (this.sz) {
            synchronized (this.l) {
                l();
                setS = s(str, set);
            }
            return setS;
        }
        return s(str, set);
    }

    private Set<String> s(String str, Set<String> set) {
        try {
            Set<String> set2 = (Set) this.x.get(str);
            if (set2 == null) {
                set2 = (Set) this.w.get(str);
            }
            return set2 != null ? set2 : set;
        } catch (Exception e) {
            n("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return set;
        }
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public int getInt(String str, int i) {
        int iS;
        if (str == null) {
            str = "";
        }
        if (this.sz) {
            synchronized (this.l) {
                l();
                iS = s(str, i);
            }
            return iS;
        }
        return s(str, i);
    }

    private int s(String str, int i) {
        try {
            Object obj = this.x.get(str);
            if (obj == null) {
                obj = this.w.get(str);
            }
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            if (obj instanceof Float) {
                return ((Float) obj).intValue();
            }
            return obj != null ? ((Integer) obj).intValue() : i;
        } catch (Exception e) {
            n("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return i;
        }
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public long getLong(String str, long j) {
        long jS;
        if (str == null) {
            str = "";
        }
        if (this.sz) {
            synchronized (this.l) {
                l();
                jS = s(str, j);
            }
            return jS;
        }
        return s(str, j);
    }

    private long s(String str, long j) {
        try {
            Long l = (Long) this.x.get(str);
            if (l == null) {
                l = (Long) this.w.get(str);
            }
            return l != null ? l.longValue() : j;
        } catch (Exception e) {
            n("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return j;
        }
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        float fS;
        if (str == null) {
            str = "";
        }
        if (this.sz) {
            synchronized (this.l) {
                l();
                fS = s(str, f);
            }
            return fS;
        }
        return s(str, f);
    }

    private float s(String str, float f) {
        try {
            Object obj = this.x.get(str);
            if (obj == null) {
                obj = this.w.get(str);
            }
            if (obj instanceof Integer) {
                return ((Integer) obj).floatValue();
            }
            if (obj instanceof Float) {
                return ((Float) obj).floatValue();
            }
            return obj != null ? ((Float) obj).floatValue() : f;
        } catch (Exception e) {
            n("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return f;
        }
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        boolean zS;
        if (str == null) {
            str = "";
        }
        if (this.sz) {
            synchronized (this.l) {
                l();
                zS = s(str, z);
            }
            return zS;
        }
        return s(str, z);
    }

    private boolean s(String str, boolean z) {
        try {
            Boolean bool = (Boolean) this.x.get(str);
            if (bool == null) {
                bool = (Boolean) this.w.get(str);
            }
            return bool != null ? bool.booleanValue() : z;
        } catch (Exception e) {
            n("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return z;
        }
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    public boolean contains(String str) {
        boolean zContainsKey;
        if (str == null) {
            str = "";
        }
        synchronized (this.l) {
            l();
            zContainsKey = this.w.containsKey(str);
        }
        return zContainsKey;
    }

    @Override // com.byazt.eau.l, android.content.SharedPreferences
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public n edit() {
        synchronized (this.l) {
            l();
        }
        return new n();
    }

    private void n(Runnable runnable) {
        synchronized (this.tj) {
            if (this.fs) {
                runnable.run();
            } else {
                this.tj.add(runnable);
            }
        }
    }

    @Override // com.byazt.eau.l
    public int qg(String str, int i) {
        return getInt(str, i);
    }

    @Override // com.byazt.eau.l
    public long qg(String str, long j) {
        return getLong(str, j);
    }

    @Override // com.byazt.eau.l
    public float qg(String str, float f) {
        return getFloat(str, f);
    }

    @Override // com.byazt.eau.l
    public boolean qg(String str, boolean z) {
        return getBoolean(str, z);
    }

    @Override // com.byazt.eau.l
    public String qg(String str, String str2) {
        return getString(str, str2);
    }

    @Override // com.byazt.eau.l
    public Set<String> qg(String str, Set<String> set) {
        return getStringSet(str, set);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void n(String str, T t) {
        if (str == null) {
            str = "";
        }
        synchronized ("SharedPreferencesImpl") {
            this.x.put(str, t);
            this.rv++;
        }
    }

    @Override // com.byazt.eau.l
    public void n(String str, int i) {
        n(str, Integer.valueOf(i));
    }

    @Override // com.byazt.eau.l
    public void n(String str, long j) {
        n(str, Long.valueOf(j));
    }

    @Override // com.byazt.eau.l
    public void n(String str, float f) {
        n(str, Float.valueOf(f));
    }

    @Override // com.byazt.eau.l
    public void n(String str, boolean z) {
        n(str, Boolean.valueOf(z));
    }

    @Override // com.byazt.eau.l
    public void n(String str, String str2) {
        n(str, str2);
    }

    @Override // com.byazt.eau.l
    public void n(String str, Set<String> set) {
        n(str, set);
    }

    @Override // com.byazt.eau.l
    public void n(String str) {
        synchronized ("SharedPreferencesImpl") {
            this.x.put(str, null);
            this.rv++;
        }
    }

    @Override // com.byazt.eau.l
    public void n() {
        if (this.fs) {
            this.w.clear();
            synchronized ("SharedPreferencesImpl") {
                this.x.clear();
                this.rv++;
            }
            return;
        }
        n(new Runnable() { // from class: com.byazt.mty.s.2
            @Override // java.lang.Runnable
            public void run() {
                s.this.w.clear();
                synchronized ("SharedPreferencesImpl") {
                    s.this.x.clear();
                    s.s(s.this);
                }
            }
        });
    }

    @Override // com.byazt.eau.l
    public void qg() {
        if (!this.fs) {
            if (this.oa.compareAndSet(false, true)) {
                n(new Runnable() { // from class: com.byazt.mty.s.3
                    @Override // java.lang.Runnable
                    public void run() {
                        s.this.oa.set(false);
                        s.this.qg();
                    }
                });
            }
        } else if (this.cp != this.rv && this.oa.compareAndSet(false, true)) {
            w().execute(new Runnable() { // from class: com.byazt.mty.s.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            Map<String, Object> mapFs = s.this.fs();
                            if (mapFs != null) {
                                s.this.d.n(mapFs, s.this.s);
                            }
                        } catch (Exception e) {
                            s.this.n("apply write error", (Throwable) e);
                        }
                    } finally {
                        s.this.oa.set(false);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> fs() {
        HashMap map;
        synchronized ("SharedPreferencesImpl") {
            map = new HashMap(this.x);
            this.x = new HashMap();
        }
        HashMap map2 = new HashMap(this.w);
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
    public void n(String str, final Throwable th) {
        com.byazt.sf.s sVar = (com.byazt.sf.s) com.byazt.qp.q.n("ad_log", com.byazt.qp.q.qg(null));
        if (sVar != null) {
            final JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("file", this.s.getAbsolutePath());
                jSONObject.put(NotificationCompat.CATEGORY_MESSAGE, str);
                jSONObject.put("class", "SharedPreferencesImpl");
            } catch (JSONException unused) {
            }
            sVar.n("exception", (byte) 1, new com.byazt.rs.n() { // from class: com.byazt.mty.s.5
                @Override // com.byazt.rs.n
                public JSONObject n(JSONObject jSONObject2) throws JSONException {
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

    @Override // com.byazt.eau.l
    public void s() {
        if (!this.fs) {
            if (this.oa.compareAndSet(false, true)) {
                n(new Runnable() { // from class: com.byazt.mty.s.6
                    @Override // java.lang.Runnable
                    public void run() {
                        s.this.oa.set(false);
                        s.this.s();
                    }
                });
                return;
            }
            return;
        }
        try {
            if (this.oa.compareAndSet(false, true)) {
                try {
                    Map<String, Object> mapFs = fs();
                    if (mapFs != null) {
                        this.d.n(mapFs, this.s);
                    }
                } catch (Exception e) {
                    n("applySync write error", (Throwable) e);
                }
            }
        } finally {
            this.oa.set(false);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 669, 546})
    public final class n implements SharedPreferences.Editor {
        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return true;
        }

        public n() {
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            s.this.n(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            s.this.n(str, set);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            s.this.n(str, Integer.valueOf(i));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            s.this.n(str, Long.valueOf(j));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f) {
            s.this.n(str, Float.valueOf(f));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            s.this.n(str, Boolean.valueOf(z));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            s.this.n(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            try {
                s.s(s.this);
                s.this.x.clear();
            } catch (Exception unused) {
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            s.this.qg();
        }
    }
}
