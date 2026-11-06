package com.bytedance.adsdk.lottie;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class u<K, V> {
    private int ab;
    private int ah;
    private int c;
    private int d;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final LinkedHashMap<K, V> f273ms;
    private int x;
    private int xr;

    protected int xr(K k, V v) {
        return 1;
    }

    protected V xr(K k) {
        return null;
    }

    public u(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.ah = i;
        this.f273ms = new LinkedHashMap<>(0, 0.75f, true);
    }

    public final V ms(K k) {
        V vPut;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v = this.f273ms.get(k);
            if (v != null) {
                this.ab++;
                return v;
            }
            this.x++;
            V vXr = xr(k);
            if (vXr == null) {
                return null;
            }
            synchronized (this) {
                this.ka++;
                vPut = this.f273ms.put(k, vXr);
                if (vPut != null) {
                    this.f273ms.put(k, vPut);
                } else {
                    this.xr += ah(k, vXr);
                }
            }
            if (vPut != null) {
                return vPut;
            }
            ms(this.ah);
            return vXr;
        }
    }

    public final V ms(K k, V v) {
        V vPut;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.d++;
            this.xr += ah(k, v);
            vPut = this.f273ms.put(k, v);
            if (vPut != null) {
                this.xr -= ah(k, vPut);
            }
        }
        ms(this.ah);
        return vPut;
    }

    public void ms(int i) {
        while (true) {
            synchronized (this) {
                if (this.xr < 0 || (this.f273ms.isEmpty() && this.xr != 0)) {
                    break;
                }
                if (this.xr > i && !this.f273ms.isEmpty()) {
                    Map.Entry<K, V> next = this.f273ms.entrySet().iterator().next();
                    K key = next.getKey();
                    V value = next.getValue();
                    this.f273ms.remove(key);
                    this.xr -= ah(key, value);
                    this.c++;
                }
                return;
            }
        }
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
    }

    private int ah(K k, V v) {
        int iXr = xr(k, v);
        if (iXr >= 0) {
            return iXr;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    public final synchronized String toString() {
        int i;
        int i2;
        i = this.ab;
        i2 = this.x + i;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.ah), Integer.valueOf(this.ab), Integer.valueOf(this.x), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }
}
