package com.smartdigimkt.i3;

import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class i {
    public final LinkedHashMap a;
    public int b;
    public final int c;
    public int d;
    public int e;
    public final /* synthetic */ m f;

    public i(m mVar, int i) {
        this.f = mVar;
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.c = i;
        this.a = new LinkedHashMap(0, 0.75f, true);
    }

    public final void a(int i) {
        Object key;
        Object value;
        while (true) {
            synchronized (this) {
                try {
                    if (this.b < 0 || (this.a.isEmpty() && this.b != 0)) {
                        break;
                    }
                    if (this.b <= i) {
                        return;
                    }
                    Map.Entry entry = this.a.entrySet().size() > 0 ? (Map.Entry) this.a.entrySet().iterator().next() : null;
                    if (entry == null) {
                        return;
                    }
                    key = entry.getKey();
                    value = entry.getValue();
                    this.a.remove(key);
                    this.b -= a(key, value);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            a(key, value, null);
        }
        this.b = 0;
        throw new IllegalStateException(i.class.getName() + ".sizeOf() is reporting inconsistent results! --> size: " + this.b + ", map.isEmpty(): " + this.a.isEmpty());
    }

    public final synchronized String toString() {
        int i;
        int i2;
        i = this.d;
        i2 = this.e + i;
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }

    public final void a(Object obj, Object obj2, com.smartdigimkt.k3.a aVar) {
        String str = (String) obj;
        com.smartdigimkt.k3.a aVar2 = (com.smartdigimkt.k3.a) obj2;
        if (aVar2 != null) {
            try {
            } catch (Exception unused) {
                return;
            }
        }
        Map map = this.f.a;
        if (map != null) {
            map.remove(str);
        }
    }

    public final int a(Object obj, Object obj2) {
        int iIntValue;
        String str = (String) obj;
        com.smartdigimkt.k3.a aVar = (com.smartdigimkt.k3.a) obj2;
        Bitmap bitmap = aVar != null ? (Bitmap) aVar.a.get() : null;
        m mVar = this.f;
        if (mVar.a == null) {
            mVar.a = new HashMap(8);
        }
        if (bitmap != null) {
            iIntValue = bitmap.getHeight() * bitmap.getRowBytes();
            this.f.a.put(str, Integer.valueOf(iIntValue));
        } else {
            Integer num = (Integer) this.f.a.get(str);
            iIntValue = num != null ? num.intValue() : 0;
        }
        if (iIntValue >= 0) {
            return iIntValue;
        }
        throw new IllegalStateException("Negative size: " + obj + "=" + obj2);
    }
}
