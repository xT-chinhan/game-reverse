package com.byazt.bbo;

import com.byazt.ca.ho;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 2017, 20})
public class hn<K, V> {
    public int c;
    public int fw;
    public int hn;
    public int hw;
    public final LinkedHashMap<K, SoftReference<V>> pr;
    public int uc;
    public int x;
    public int zo;

    public hn(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.hn = i;
        this.pr = new LinkedHashMap<>(0, 0.75f, true);
    }

    public final V pr(K k) {
        V v;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            SoftReference<V> softReference = this.pr.get(k);
            if (softReference == null) {
                v = null;
            } else {
                v = softReference.get();
                if (v != null) {
                    this.fw++;
                    return v;
                }
                this.pr.remove(k);
            }
            this.zo++;
            V vHw = hw(k);
            if (vHw == null) {
                return null;
            }
            synchronized (this) {
                this.c++;
                SoftReference<V> softReferencePut = this.pr.put(k, new SoftReference<>(vHw));
                if (softReferencePut != null) {
                    v = softReferencePut.get();
                }
                if (v != null) {
                    this.pr.put(k, softReferencePut);
                } else {
                    this.hw += hn(k, vHw);
                }
            }
            if (v != null) {
                return v;
            }
            pr(this.hn);
            return vHw;
        }
    }

    public final V pr(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        V v2 = null;
        synchronized (this) {
            this.x++;
            this.hw += hn(k, v);
            SoftReference<V> softReferencePut = this.pr.put(k, new SoftReference<>(v));
            if (softReferencePut != null && (v2 = softReferencePut.get()) != null) {
                this.hw -= hn(k, v2);
            }
        }
        pr(this.hn);
        return v2;
    }

    public void pr(int i) {
        while (true) {
            synchronized (this) {
                if (this.hw < 0 || (this.pr.isEmpty() && this.hw != 0)) {
                    break;
                    break;
                }
                if (this.hw <= i) {
                    return;
                }
                Map.Entry<K, SoftReference<V>> next = this.pr.entrySet().iterator().next();
                if (next == null) {
                    return;
                }
                K key = next.getKey();
                SoftReference<V> value = next.getValue();
                this.pr.remove(key);
                if (value != null) {
                    this.hw -= hn(key, value.get());
                }
                this.uc++;
            }
        }
        ho.hw("LruCache", "oom maybe occured, clear cache. size= " + this.hw + ", maxSize: " + i);
        this.hw = 0;
        this.pr.clear();
    }

    public V hw(K k) {
        return null;
    }

    private int hn(K k, V v) {
        int iHw = hw(k, v);
        if (iHw < 0) {
            throw new IllegalStateException("Negative size: " + k + "=" + v);
        }
        return iHw;
    }

    public int hw(K k, V v) {
        return 1;
    }

    public final void pr() {
        pr(-1);
    }

    public final synchronized String toString() {
        int i;
        int i2;
        i = this.fw;
        i2 = this.zo + i;
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.hn), Integer.valueOf(this.fw), Integer.valueOf(this.zo), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }
}
