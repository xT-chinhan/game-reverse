package com.byazt.qvu;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 781, 19})
public class n {
    public static final PluginValueSet n = n(0).qg();
    public static final Function<SparseArray<Object>, Object> qg = new C0317n();
    public PluginValueSet q;
    public final SparseArray<Object> s;

    private n(SparseArray<Object> sparseArray, PluginValueSet pluginValueSet) {
        this.s = sparseArray;
        this.q = pluginValueSet;
    }

    private n(SparseArray<Object> sparseArray) {
        this.s = sparseArray == null ? new SparseArray<>() : sparseArray;
    }

    public static final n n() {
        return new n(new SparseArray());
    }

    public static final n n(int i) {
        return new n(new SparseArray(i));
    }

    public static final n n(SparseArray<Object> sparseArray) {
        return new n(sparseArray);
    }

    public static final n n(PluginValueSet pluginValueSet) {
        return new n(new SparseArray(), pluginValueSet);
    }

    public n n(int i, Object obj) {
        this.s.put(i, obj);
        return this;
    }

    public n n(int i, String str) {
        this.s.put(i, str);
        return this;
    }

    public n n(int i, int i2) {
        this.s.put(i, Integer.valueOf(i2));
        return this;
    }

    public n n(int i, double d) {
        this.s.put(i, Double.valueOf(d));
        return this;
    }

    public n n(int i, boolean z) {
        this.s.put(i, Boolean.valueOf(z));
        return this;
    }

    public n n(int i, float f) {
        this.s.put(i, Float.valueOf(f));
        return this;
    }

    public PluginValueSet qg() {
        return new qg(this.s, this.q);
    }

    /* JADX INFO: renamed from: com.byazt.qvu.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 781, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private static final class C0317n<T, R> implements Function<T, R> {
        private C0317n() {
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

    @com.byazt.cp.n(n = {0, 1, 781, 226})
    private static final class qg implements PluginValueSet {
        public final SparseArray<Object> n;
        public PluginValueSet qg;
        public int s;

        private qg(SparseArray<Object> sparseArray, PluginValueSet pluginValueSet) {
            this.s = -1;
            this.n = sparseArray;
            this.qg = pluginValueSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public <T> T[] arrayValue(int i, Class<T> cls) {
            Object obj = this.n.get(i);
            if (obj == null) {
                PluginValueSet pluginValueSet = this.qg;
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

        private boolean n() {
            return com.byazt.mlu.n.n().qg() >= 6803 && com.byazt.mlu.n.n().qg() < 7000;
        }

        private boolean n(Object obj) {
            if (n()) {
                return (!(obj instanceof Supplier) || (obj instanceof Function) || (obj instanceof ValueSet)) ? false : true;
            }
            return (obj instanceof Supplier) && !(obj instanceof Function);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public <T> T objectValue(int i, Class<T> cls) {
            Supplier supplier = (T) this.n.get(i);
            if (supplier == null) {
                PluginValueSet pluginValueSet = this.qg;
                if (pluginValueSet != null) {
                    return (T) pluginValueSet.objectValue(i, cls);
                }
                return null;
            }
            if (n(supplier)) {
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
            Object obj = this.n.get(i);
            if (obj == null && (pluginValueSet = this.qg) != null) {
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
            Object obj = this.n.get(i);
            if (obj == null && (pluginValueSet = this.qg) != null) {
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
            Object obj = this.n.get(i);
            if (obj == null && (pluginValueSet = this.qg) != null) {
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
            Object obj = this.n.get(i);
            if (obj == null && (pluginValueSet = this.qg) != null) {
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
            Object obj = this.n.get(i);
            if (obj == null && (pluginValueSet = this.qg) != null) {
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
            Object obj = this.n.get(i);
            if (obj == null && (pluginValueSet = this.qg) != null) {
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
            int iIndexOfKey = this.n.indexOfKey(i);
            if (iIndexOfKey >= 0 || (pluginValueSet = this.qg) == null) {
                return iIndexOfKey >= 0;
            }
            return pluginValueSet.containsKey(i);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public Set<Integer> keys() {
            int size = this.n.size();
            HashSet hashSet = new HashSet();
            for (int i = 0; i < size; i++) {
                hashSet.add(Integer.valueOf(this.n.keyAt(i)));
            }
            PluginValueSet pluginValueSet = this.qg;
            if (pluginValueSet != null) {
                hashSet.addAll(pluginValueSet.keys());
            }
            this.s = hashSet.size();
            return hashSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public boolean isEmpty() {
            return size() <= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public int size() {
            if (this.s < 0) {
                keys();
            }
            return this.s;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public SparseArray<Object> sparseArray() {
            SparseArray<Object> sparseArray;
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            PluginValueSet pluginValueSet = this.qg;
            if (pluginValueSet != null && (sparseArray = pluginValueSet.sparseArray()) != null && sparseArray.size() > 0) {
                for (int i = 0; i < sparseArray.size(); i++) {
                    sparseArray2.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
                }
            }
            SparseArray<Object> sparseArray3 = this.n;
            if (sparseArray3 != null && sparseArray3.size() > 0) {
                for (int i2 = 0; i2 < this.n.size(); i2++) {
                    sparseArray2.put(this.n.keyAt(i2), this.n.valueAt(i2));
                }
            }
            return sparseArray2;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public void remove(int i) {
            this.n.remove(i);
        }
    }
}
