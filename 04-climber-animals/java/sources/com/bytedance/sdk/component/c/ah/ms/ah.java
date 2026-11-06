package com.bytedance.sdk.component.c.ah.ms;

import com.bytedance.sdk.component.utils.sl;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ah<K, V> {
    private int ab;
    private int ah;
    private int c;
    private int d;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final LinkedHashMap<K, SoftReference<V>> f1166ms;
    private int x;
    private int xr;

    protected int xr(K k, V v) {
        return 1;
    }

    protected V xr(K k) {
        return null;
    }

    public ah(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.ah = i;
        this.f1166ms = new LinkedHashMap<>(0, 0.75f, true);
    }

    public final V ms(K k) {
        V v;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            SoftReference<V> softReference = this.f1166ms.get(k);
            if (softReference != null) {
                v = softReference.get();
                if (v != null) {
                    this.ab++;
                    return v;
                }
                this.f1166ms.remove(k);
            } else {
                v = null;
            }
            this.x++;
            V vXr = xr(k);
            if (vXr == null) {
                return null;
            }
            synchronized (this) {
                this.ka++;
                SoftReference<V> softReferencePut = this.f1166ms.put(k, new SoftReference<>(vXr));
                if (softReferencePut != null) {
                    v = softReferencePut.get();
                }
                if (v != null) {
                    this.f1166ms.put(k, softReferencePut);
                } else {
                    this.xr += ah(k, vXr);
                }
            }
            if (v != null) {
                return v;
            }
            ms(this.ah);
            return vXr;
        }
    }

    public final V ms(K k, V v) {
        V v2;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.d++;
            this.xr += ah(k, v);
            SoftReference<V> softReferencePut = this.f1166ms.put(k, new SoftReference<>(v));
            if (softReferencePut != null) {
                v2 = softReferencePut.get();
                if (v2 != null) {
                    this.xr -= ah(k, v2);
                }
            } else {
                v2 = null;
            }
        }
        ms(this.ah);
        return v2;
    }

    public void ms(int i) {
        while (true) {
            synchronized (this) {
                if (this.xr < 0 || (this.f1166ms.isEmpty() && this.xr != 0)) {
                    break;
                    break;
                }
                if (this.xr <= i) {
                    return;
                }
                Map.Entry<K, SoftReference<V>> next = this.f1166ms.entrySet().iterator().next();
                if (next == null) {
                    return;
                }
                K key = next.getKey();
                SoftReference<V> value = next.getValue();
                this.f1166ms.remove(key);
                if (value != null) {
                    this.xr -= ah(key, value.get());
                }
                this.c++;
            }
        }
        sl.d("LruCache", "oom maybe occured, clear cache. size= " + this.xr + ", maxSize: " + i);
        this.xr = 0;
        this.f1166ms.clear();
    }

    private int ah(K k, V v) {
        int iXr = xr(k, v);
        if (iXr >= 0) {
            return iXr;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    public final void ms() {
        ms(-1);
    }

    public final synchronized String toString() {
        int i;
        int i2;
        i = this.ab;
        i2 = this.x + i;
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.ah), Integer.valueOf(this.ab), Integer.valueOf(this.x), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }
}
