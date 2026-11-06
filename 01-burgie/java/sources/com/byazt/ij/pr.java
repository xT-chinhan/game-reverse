package com.byazt.ij;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.mar.sdk.MARCode;
import com.uc.crashsdk.export.LogType;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, LogType.UNEXP_OTHER, 37})
public class pr {
    public final SparseArray<Object> hn;
    public PluginValueSet x;
    public static final PluginValueSet pr = pr(0).hw();
    public static final Function<SparseArray<Object>, Object> hw = new C0096pr();

    private pr(SparseArray<Object> sparseArray, PluginValueSet pluginValueSet) {
        this.hn = sparseArray;
        this.x = pluginValueSet;
    }

    private pr(SparseArray<Object> sparseArray) {
        this.hn = sparseArray == null ? new SparseArray<>() : sparseArray;
    }

    public static final pr pr() {
        return new pr(new SparseArray());
    }

    public static final pr pr(int i) {
        return new pr(new SparseArray(i));
    }

    public static final pr pr(SparseArray<Object> sparseArray) {
        return new pr(sparseArray);
    }

    public static final pr pr(PluginValueSet pluginValueSet) {
        return new pr(new SparseArray(), pluginValueSet);
    }

    public pr pr(int i, Object obj) {
        this.hn.put(i, obj);
        return this;
    }

    public pr pr(int i, String str) {
        this.hn.put(i, str);
        return this;
    }

    public pr pr(int i, int i2) {
        this.hn.put(i, Integer.valueOf(i2));
        return this;
    }

    public pr pr(int i, double d) {
        this.hn.put(i, Double.valueOf(d));
        return this;
    }

    public pr pr(int i, boolean z) {
        this.hn.put(i, Boolean.valueOf(z));
        return this;
    }

    public pr pr(int i, float f) {
        this.hn.put(i, Float.valueOf(f));
        return this;
    }

    public PluginValueSet hw() {
        return new hw(this.hn, this.x);
    }

    /* JADX INFO: renamed from: com.byazt.ij.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, LogType.UNEXP_OTHER, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    private static final class C0096pr<T, R> implements Function<T, R> {
        private C0096pr() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.function.Function
        public R apply(T t) {
            if (!(t instanceof SparseArray)) {
                return null;
            }
            Class cls = (Class) ((SparseArray) t).get(-99999985);
            if (cls != Boolean.class && cls != Boolean.TYPE) {
                if (cls != Integer.TYPE && cls != Integer.class) {
                    if (cls != Long.TYPE && cls != Long.class) {
                        if (cls != Double.TYPE && cls != Double.class) {
                            if (cls == Float.TYPE || cls == Float.class) {
                                return (R) Float.valueOf(0.0f);
                            }
                            return null;
                        }
                        return (R) Double.valueOf(0.0d);
                    }
                    return (R) 0L;
                }
                return (R) 0;
            }
            return (R) Boolean.FALSE;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, LogType.UNEXP_OTHER, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE})
    private static final class hw implements PluginValueSet {
        public int hn;
        public PluginValueSet hw;
        public final SparseArray<Object> pr;

        private hw(SparseArray<Object> sparseArray, PluginValueSet pluginValueSet) {
            this.hn = -1;
            this.pr = sparseArray;
            this.hw = pluginValueSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public <T> T[] arrayValue(int i, Class<T> cls) {
            Object obj = this.pr.get(i);
            if (obj == null) {
                PluginValueSet pluginValueSet = this.hw;
                if (pluginValueSet != null) {
                    return (T[]) pluginValueSet.arrayValue(i, cls);
                }
                return null;
            }
            Class<?> cls2 = obj.getClass();
            if (cls2.isArray() && cls.isAssignableFrom(cls2.getComponentType())) {
                return (T[]) ((Object[]) obj);
            }
            return null;
        }

        private boolean pr() {
            return com.byazt.q.pr.pr().hw() >= 6803 && com.byazt.q.pr.pr().hw() < 7000;
        }

        private boolean pr(Object obj) {
            if (pr()) {
                return (!(obj instanceof Supplier) || (obj instanceof Function) || (obj instanceof ValueSet)) ? false : true;
            }
            return (obj instanceof Supplier) && !(obj instanceof Function);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public <T> T objectValue(int i, Class<T> cls) {
            Supplier supplier = (T) this.pr.get(i);
            if (supplier == null) {
                PluginValueSet pluginValueSet = this.hw;
                if (pluginValueSet != null) {
                    return (T) pluginValueSet.objectValue(i, cls);
                }
                return null;
            }
            if (pr(supplier)) {
                supplier = (T) supplier.get();
            }
            if (cls.isInstance(supplier)) {
                return (T) supplier;
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public String stringValue(int i) {
            return stringValue(i, null);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public int intValue(int i) {
            return intValue(i, 0);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public boolean booleanValue(int i) {
            return booleanValue(i, false);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public long longValue(int i) {
            return longValue(i, 0L);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public float floatValue(int i) {
            return floatValue(i, 0.0f);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public double doubleValue(int i) {
            PluginValueSet pluginValueSet;
            Object obj = this.pr.get(i);
            if (obj == null && (pluginValueSet = this.hw) != null) {
                return pluginValueSet.doubleValue(i);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            if (obj instanceof Double) {
                return ((Double) obj).doubleValue();
            }
            return 0.0d;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public String stringValue(int i, String str) {
            PluginValueSet pluginValueSet;
            Object obj = this.pr.get(i);
            if (obj == null && (pluginValueSet = this.hw) != null) {
                return pluginValueSet.stringValue(i, str);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof String ? obj.toString() : str;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public int intValue(int i, int i2) {
            PluginValueSet pluginValueSet;
            Object obj = this.pr.get(i);
            if (obj == null && (pluginValueSet = this.hw) != null) {
                return pluginValueSet.intValue(i, i2);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Integer ? ((Integer) obj).intValue() : i2;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public boolean booleanValue(int i, boolean z) {
            PluginValueSet pluginValueSet;
            Object obj = this.pr.get(i);
            if (obj == null && (pluginValueSet = this.hw) != null) {
                return pluginValueSet.booleanValue(i, z);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public long longValue(int i, long j) {
            PluginValueSet pluginValueSet;
            Object obj = this.pr.get(i);
            if (obj == null && (pluginValueSet = this.hw) != null) {
                return pluginValueSet.longValue(i, j);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Long ? ((Long) obj).longValue() : j;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public float floatValue(int i, float f) {
            PluginValueSet pluginValueSet;
            Object obj = this.pr.get(i);
            if (obj == null && (pluginValueSet = this.hw) != null) {
                return pluginValueSet.floatValue(i, f);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Float ? ((Float) obj).floatValue() : f;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public boolean containsKey(int i) {
            PluginValueSet pluginValueSet;
            int iIndexOfKey = this.pr.indexOfKey(i);
            if (iIndexOfKey >= 0 || (pluginValueSet = this.hw) == null) {
                return iIndexOfKey >= 0;
            }
            return pluginValueSet.containsKey(i);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public Set<Integer> keys() {
            int size = this.pr.size();
            HashSet hashSet = new HashSet();
            for (int i = 0; i < size; i++) {
                hashSet.add(Integer.valueOf(this.pr.keyAt(i)));
            }
            PluginValueSet pluginValueSet = this.hw;
            if (pluginValueSet != null) {
                hashSet.addAll(pluginValueSet.keys());
            }
            this.hn = hashSet.size();
            return hashSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public boolean isEmpty() {
            return size() <= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public int size() {
            if (this.hn < 0) {
                keys();
            }
            return this.hn;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public SparseArray<Object> sparseArray() {
            SparseArray<Object> sparseArray;
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            PluginValueSet pluginValueSet = this.hw;
            if (pluginValueSet != null && (sparseArray = pluginValueSet.sparseArray()) != null && sparseArray.size() > 0) {
                for (int i = 0; i < sparseArray.size(); i++) {
                    sparseArray2.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
                }
            }
            SparseArray<Object> sparseArray3 = this.pr;
            if (sparseArray3 != null && sparseArray3.size() > 0) {
                for (int i2 = 0; i2 < this.pr.size(); i2++) {
                    sparseArray2.put(this.pr.keyAt(i2), this.pr.valueAt(i2));
                }
            }
            return sparseArray2;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public void remove(int i) {
            this.pr.remove(i);
        }
    }
}
