package com.byazt.dl;

import com.byazt.tk.k;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 202, 8})
public class s<K, V> {
    public int fs;
    public int l;
    public final LinkedHashMap<K, SoftReference<V>> n;
    public int q;
    public int qg;
    public int s;
    public int w;
    public int x;

    public int qg(K k, V v) {
        return 1;
    }

    public V qg(K k) {
        return null;
    }

    public s(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.s = i;
        this.n = new LinkedHashMap<>(0, 0.75f, true);
    }

    public final V n(K k) {
        V v;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            SoftReference<V> softReference = this.n.get(k);
            if (softReference != null) {
                v = softReference.get();
                if (v != null) {
                    this.x++;
                    return v;
                }
                this.n.remove(k);
            } else {
                v = null;
            }
            this.fs++;
            V vQg = qg(k);
            if (vQg == null) {
                return null;
            }
            synchronized (this) {
                this.l++;
                SoftReference<V> softReferencePut = this.n.put(k, new SoftReference<>(vQg));
                if (softReferencePut != null) {
                    v = softReferencePut.get();
                }
                if (v != null) {
                    this.n.put(k, softReferencePut);
                } else {
                    this.qg += s(k, vQg);
                }
            }
            if (v != null) {
                return v;
            }
            n(this.s);
            return vQg;
        }
    }

    public final V n(K k, V v) {
        V v2;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.q++;
            this.qg += s(k, v);
            SoftReference<V> softReferencePut = this.n.put(k, new SoftReference<>(v));
            if (softReferencePut != null) {
                v2 = softReferencePut.get();
                if (v2 != null) {
                    this.qg -= s(k, v2);
                }
            } else {
                v2 = null;
            }
        }
        n(this.s);
        return v2;
    }

    public void n(int i) {
        while (true) {
            synchronized (this) {
                if (this.qg < 0 || (this.n.isEmpty() && this.qg != 0)) {
                    break;
                    break;
                }
                if (this.qg <= i) {
                    return;
                }
                Map.Entry<K, SoftReference<V>> next = this.n.entrySet().iterator().next();
                if (next == null) {
                    return;
                }
                K key = next.getKey();
                SoftReference<V> value = next.getValue();
                this.n.remove(key);
                if (value != null) {
                    this.qg -= s(key, value.get());
                }
                this.w++;
            }
        }
        k.qg("LruCache", "oom maybe occured, clear cache. size= " + this.qg + ", maxSize: " + i);
        this.qg = 0;
        this.n.clear();
    }

    private int s(K k, V v) {
        int iQg = qg(k, v);
        if (iQg >= 0) {
            return iQg;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    public final void n() {
        n(-1);
    }

    public final synchronized String toString() {
        int i;
        int i2;
        i = this.x;
        i2 = this.fs + i;
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.s), Integer.valueOf(this.x), Integer.valueOf(this.fs), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }
}
