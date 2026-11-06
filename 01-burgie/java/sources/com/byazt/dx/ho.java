package com.byazt.dx;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 229, 19})
public class ho<K, V> {
    public int c;
    public int fw;
    public int hn;
    public int hw;
    public final LinkedHashMap<K, V> pr;
    public int uc;
    public int x;
    public int zo;

    public ho(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.hn = i;
        this.pr = new LinkedHashMap<>(0, 0.75f, true);
    }

    public void pr(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        synchronized (this) {
            this.hn = i;
        }
        hw(i);
    }

    public final V pr(K k) {
        V vPut;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v = this.pr.get(k);
            if (v != null) {
                this.fw++;
                return v;
            }
            this.zo++;
            V vHw = hw(k);
            if (vHw == null) {
                return null;
            }
            synchronized (this) {
                this.c++;
                vPut = this.pr.put(k, vHw);
                if (vPut != null) {
                    this.pr.put(k, vPut);
                } else {
                    this.hw += hn(k, vHw);
                }
            }
            if (vPut != null) {
                pr(false, k, vHw, vPut);
                return vPut;
            }
            hw(this.hn);
            return vHw;
        }
    }

    public final V pr(K k, V v) {
        V vPut;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.x++;
            this.hw += hn(k, v);
            vPut = this.pr.put(k, v);
            if (vPut != null) {
                this.hw -= hn(k, vPut);
            }
        }
        if (vPut != null) {
            pr(false, k, vPut, v);
        }
        hw(this.hn);
        return vPut;
    }

    public void hw(int i) {
        K key;
        V value;
        while (true) {
            synchronized (this) {
                if (this.hw < 0 || (this.pr.isEmpty() && this.hw != 0)) {
                    break;
                }
                if (this.hw > i && !this.pr.isEmpty()) {
                    Map.Entry<K, V> next = this.pr.entrySet().iterator().next();
                    key = next.getKey();
                    value = next.getValue();
                    this.pr.remove(key);
                    this.hw -= hn(key, value);
                    this.uc++;
                }
                return;
            }
            pr(true, key, value, null);
        }
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
    }

    public void pr(boolean z, K k, V v, V v2) {
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

    public final synchronized Map<K, V> pr() {
        return new LinkedHashMap(this.pr);
    }

    public final synchronized boolean pr(K k, int i) {
        if (k == null || i <= 0) {
            return false;
        }
        if (!this.pr.containsKey(k)) {
            return false;
        }
        int size = this.pr.size();
        if (size <= i) {
            return true;
        }
        Iterator<K> it = this.pr.keySet().iterator();
        int i2 = 0;
        while (it.hasNext() && !it.next().equals(k)) {
            i2++;
        }
        if (i2 < size - i) {
            return false;
        }
        return true;
    }

    public final synchronized String toString() {
        int i;
        int i2;
        i = this.fw;
        i2 = this.zo + i;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.hn), Integer.valueOf(this.fw), Integer.valueOf(this.zo), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }
}
