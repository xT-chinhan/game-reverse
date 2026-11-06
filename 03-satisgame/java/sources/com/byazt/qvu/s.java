package com.byazt.qvu;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 781, 8})
public class s {
    public static final ValueSet n = n(0).qg();
    public static final Function<SparseArray<Object>, Object> qg = new n();
    public ValueSet q;
    public final SparseArray<Object> s;

    private s(SparseArray<Object> sparseArray) {
        this.s = sparseArray == null ? new SparseArray<>() : sparseArray;
    }

    public static final s n() {
        return new s(new SparseArray());
    }

    public static final s n(int i) {
        return new s(new SparseArray(i));
    }

    public static final s n(SparseArray<Object> sparseArray) {
        return new s(sparseArray);
    }

    public s n(int i, Object obj) {
        this.s.put(i, obj);
        return this;
    }

    public s n(int i, String str) {
        this.s.put(i, str);
        return this;
    }

    public s n(int i, int i2) {
        this.s.put(i, Integer.valueOf(i2));
        return this;
    }

    public s n(int i, double d) {
        this.s.put(i, Double.valueOf(d));
        return this;
    }

    public s n(int i, boolean z) {
        this.s.put(i, Boolean.valueOf(z));
        return this;
    }

    public s n(int i, long j) {
        this.s.put(i, Long.valueOf(j));
        return this;
    }

    public s n(int i, float f) {
        this.s.put(i, Float.valueOf(f));
        return this;
    }

    public ValueSet qg() {
        return new qg(this.s, this.q);
    }

    @com.byazt.cp.n(n = {0, 1, 781, 782})
    private static final class qg implements ValueSet {
        public final SparseArray<Object> n;
        public ValueSet qg;
        public int s;

        private qg(SparseArray<Object> sparseArray, ValueSet valueSet) {
            this.s = -1;
            this.n = sparseArray;
            this.qg = valueSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T[] arrayValue(int i, Class<T> cls) {
            Object obj = this.n.get(i);
            if (obj == null) {
                ValueSet valueSet = this.qg;
                if (valueSet != null) {
                    return (T[]) valueSet.arrayValue(i, cls);
                }
                return null;
            }
            Class<?> cls2 = obj.getClass();
            if (cls2.isArray() && cls.isAssignableFrom(cls2.getComponentType())) {
                return (T[]) ((Object[]) obj);
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T objectValue(int i, Class<T> cls) {
            Supplier supplier = (T) this.n.get(i);
            if (supplier == null) {
                ValueSet valueSet = this.qg;
                if (valueSet != null) {
                    return (T) valueSet.objectValue(i, cls);
                }
                return null;
            }
            if (supplier instanceof Supplier) {
                supplier = (T) supplier.get();
            }
            if (cls.isInstance(supplier)) {
                return (T) supplier;
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i) {
            return stringValue(i, null);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i) {
            return intValue(i, 0);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i) {
            return booleanValue(i, false);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i) {
            return longValue(i, 0L);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i) {
            return floatValue(i, 0.0f);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public double doubleValue(int i) {
            ValueSet valueSet;
            Object obj = this.n.get(i);
            if (obj == null && (valueSet = this.qg) != null) {
                return valueSet.doubleValue(i);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            if (obj instanceof Double) {
                return ((Double) obj).doubleValue();
            }
            return 0.0d;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i, String str) {
            ValueSet valueSet;
            Object obj = this.n.get(i);
            if (obj == null && (valueSet = this.qg) != null) {
                return valueSet.stringValue(i, str);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof String ? obj.toString() : str;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i, int i2) {
            ValueSet valueSet;
            Object obj = this.n.get(i);
            if (obj == null && (valueSet = this.qg) != null) {
                return valueSet.intValue(i, i2);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Integer ? ((Integer) obj).intValue() : i2;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i, boolean z) {
            ValueSet valueSet;
            Object obj = this.n.get(i);
            if (obj == null && (valueSet = this.qg) != null) {
                return valueSet.booleanValue(i, z);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i, long j) {
            ValueSet valueSet;
            Object obj = this.n.get(i);
            if (obj == null && (valueSet = this.qg) != null) {
                return valueSet.longValue(i, j);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Long ? ((Long) obj).longValue() : j;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i, float f) {
            ValueSet valueSet;
            Object obj = this.n.get(i);
            if (obj == null && (valueSet = this.qg) != null) {
                return valueSet.floatValue(i, f);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Float ? ((Float) obj).floatValue() : f;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean containsKey(int i) {
            ValueSet valueSet;
            int iIndexOfKey = this.n.indexOfKey(i);
            if (iIndexOfKey >= 0 || (valueSet = this.qg) == null) {
                return iIndexOfKey >= 0;
            }
            return valueSet.containsKey(i);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public Set<Integer> keys() {
            int size = this.n.size();
            HashSet hashSet = new HashSet();
            for (int i = 0; i < size; i++) {
                hashSet.add(Integer.valueOf(this.n.keyAt(i)));
            }
            ValueSet valueSet = this.qg;
            if (valueSet != null) {
                hashSet.addAll(valueSet.keys());
            }
            this.s = hashSet.size();
            return hashSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean isEmpty() {
            return size() <= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int size() {
            if (this.s < 0) {
                keys();
            }
            return this.s;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public SparseArray<Object> sparseArray() {
            SparseArray<Object> sparseArray;
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            ValueSet valueSet = this.qg;
            if (valueSet != null && (sparseArray = valueSet.sparseArray()) != null && sparseArray.size() > 0) {
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

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public void remove(int i) {
            this.n.remove(i);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 781, 546})
    private static final class n<T, R> implements Function<T, R> {
        private n() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.function.Function
        public R apply(T t) {
            if (!(t instanceof SparseArray)) {
                return null;
            }
            Class cls = (Class) ((SparseArray) t).get(-99999985);
            if (cls == Boolean.class || cls == Boolean.TYPE) {
                return (R) Boolean.FALSE;
            }
            if (cls == Integer.TYPE || cls == Integer.class) {
                return (R) 0;
            }
            if (cls == Long.TYPE || cls == Long.class) {
                return (R) 0L;
            }
            if (cls == Double.TYPE || cls == Double.class) {
                return (R) Double.valueOf(0.0d);
            }
            if (cls == Float.TYPE || cls == Float.class) {
                return (R) Float.valueOf(0.0f);
            }
            return null;
        }
    }
}
