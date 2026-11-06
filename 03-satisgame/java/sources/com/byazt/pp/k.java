package com.byazt.pp;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, 210})
public class k<K, V> {
    public int fs;
    public int l;
    public final LinkedHashMap<K, V> n;
    public int q;
    public int qg;
    public int s;
    public int w;
    public int x;

    public void n(boolean z, K k, V v, V v2) {
    }

    public int qg(K k, V v) {
        return 1;
    }

    public V qg(K k) {
        return null;
    }

    public k(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.s = i;
        this.n = new LinkedHashMap<>(0, 0.75f, true);
    }

    public void n(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        synchronized (this) {
            this.s = i;
        }
        qg(i);
    }

    public final V n(K k) {
        V vPut;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v = this.n.get(k);
            if (v != null) {
                this.x++;
                return v;
            }
            this.fs++;
            V vQg = qg(k);
            if (vQg == null) {
                return null;
            }
            synchronized (this) {
                this.l++;
                vPut = this.n.put(k, vQg);
                if (vPut != null) {
                    this.n.put(k, vPut);
                } else {
                    this.qg += s(k, vQg);
                }
            }
            if (vPut != null) {
                n(false, k, vQg, vPut);
                return vPut;
            }
            qg(this.s);
            return vQg;
        }
    }

    public final V n(K k, V v) {
        V vPut;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.q++;
            this.qg += s(k, v);
            vPut = this.n.put(k, v);
            if (vPut != null) {
                this.qg -= s(k, vPut);
            }
        }
        if (vPut != null) {
            n(false, k, vPut, v);
        }
        qg(this.s);
        return vPut;
    }

    public void qg(int i) {
        K key;
        V value;
        while (true) {
            synchronized (this) {
                if (this.qg < 0 || (this.n.isEmpty() && this.qg != 0)) {
                    break;
                }
                if (this.qg > i && !this.n.isEmpty()) {
                    Map.Entry<K, V> next = this.n.entrySet().iterator().next();
                    key = next.getKey();
                    value = next.getValue();
                    this.n.remove(key);
                    this.qg -= s(key, value);
                    this.w++;
                }
                return;
            }
            n(true, key, value, null);
        }
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
    }

    private int s(K k, V v) {
        int iQg = qg(k, v);
        if (iQg >= 0) {
            return iQg;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    public final synchronized Map<K, V> n() {
        return new LinkedHashMap(this.n);
    }

    public final synchronized boolean n(K k, int i) {
        if (k == null || i <= 0) {
            return false;
        }
        if (!this.n.containsKey(k)) {
            return false;
        }
        int size = this.n.size();
        if (size <= i) {
            return true;
        }
        Iterator<K> it = this.n.keySet().iterator();
        int i2 = 0;
        while (it.hasNext() && !it.next().equals(k)) {
            i2++;
        }
        return i2 >= size - i;
    }

    public final synchronized String toString() {
        int i;
        int i2;
        i = this.x;
        i2 = this.fs + i;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.s), Integer.valueOf(this.x), Integer.valueOf(this.fs), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }
}
