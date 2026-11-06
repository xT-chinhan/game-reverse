package com.byazt.ij;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.uc.crashsdk.export.LogType;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, LogType.UNEXP_OTHER, 20})
public class hn {
    public final SparseArray<Object> hn;
    public ValueSet x;
    public static final ValueSet pr = pr(0).hw();
    public static final Function<SparseArray<Object>, Object> hw = new pr();

    private hn(SparseArray<Object> sparseArray) {
        this.hn = sparseArray == null ? new SparseArray<>() : sparseArray;
    }

    public static final hn pr() {
        return new hn(new SparseArray());
    }

    public static final hn pr(int i) {
        return new hn(new SparseArray(i));
    }

    public static final hn pr(SparseArray<Object> sparseArray) {
        return new hn(sparseArray);
    }

    public hn pr(int i, Object obj) {
        this.hn.put(i, obj);
        return this;
    }

    public hn pr(int i, String str) {
        this.hn.put(i, str);
        return this;
    }

    public hn pr(int i, int i2) {
        this.hn.put(i, Integer.valueOf(i2));
        return this;
    }

    public hn pr(int i, double d) {
        this.hn.put(i, Double.valueOf(d));
        return this;
    }

    public hn pr(int i, boolean z) {
        this.hn.put(i, Boolean.valueOf(z));
        return this;
    }

    public hn pr(int i, long j) {
        this.hn.put(i, Long.valueOf(j));
        return this;
    }

    public hn pr(int i, float f) {
        this.hn.put(i, Float.valueOf(f));
        return this;
    }

    public ValueSet hw() {
        return new hw(this.hn, this.x);
    }

    @com.byazt.vzx.pr(pr = {0, 1, LogType.UNEXP_OTHER, 506})
    private static final class hw implements ValueSet {
        public int hn;
        public ValueSet hw;
        public final SparseArray<Object> pr;

        private hw(SparseArray<Object> sparseArray, ValueSet valueSet) {
            this.hn = -1;
            this.pr = sparseArray;
            this.hw = valueSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T[] arrayValue(int i, Class<T> cls) {
            Object obj = this.pr.get(i);
            if (obj == null) {
                ValueSet valueSet = this.hw;
                if (valueSet == null) {
                    return null;
                }
                return (T[]) valueSet.arrayValue(i, cls);
            }
            Class<?> cls2 = obj.getClass();
            if (cls2.isArray() && cls.isAssignableFrom(cls2.getComponentType())) {
                return (T[]) ((Object[]) obj);
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T objectValue(int i, Class<T> cls) {
            Supplier supplier = (T) this.pr.get(i);
            if (supplier == null) {
                ValueSet valueSet = this.hw;
                if (valueSet == null) {
                    return null;
                }
                return (T) valueSet.objectValue(i, cls);
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
            Object obj = this.pr.get(i);
            if (obj == null && (valueSet = this.hw) != null) {
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
            Object obj = this.pr.get(i);
            if (obj == null && (valueSet = this.hw) != null) {
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
            Object obj = this.pr.get(i);
            if (obj == null && (valueSet = this.hw) != null) {
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
            Object obj = this.pr.get(i);
            if (obj == null && (valueSet = this.hw) != null) {
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
            Object obj = this.pr.get(i);
            if (obj == null && (valueSet = this.hw) != null) {
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
            Object obj = this.pr.get(i);
            if (obj == null && (valueSet = this.hw) != null) {
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
            int iIndexOfKey = this.pr.indexOfKey(i);
            if (iIndexOfKey >= 0 || (valueSet = this.hw) == null) {
                return iIndexOfKey >= 0;
            }
            return valueSet.containsKey(i);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public Set<Integer> keys() {
            int size = this.pr.size();
            HashSet hashSet = new HashSet();
            for (int i = 0; i < size; i++) {
                hashSet.add(Integer.valueOf(this.pr.keyAt(i)));
            }
            ValueSet valueSet = this.hw;
            if (valueSet != null) {
                hashSet.addAll(valueSet.keys());
            }
            this.hn = hashSet.size();
            return hashSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean isEmpty() {
            return size() <= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int size() {
            if (this.hn < 0) {
                keys();
            }
            return this.hn;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public SparseArray<Object> sparseArray() {
            SparseArray<Object> sparseArray;
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            ValueSet valueSet = this.hw;
            if (valueSet != null && (sparseArray = valueSet.sparseArray()) != null && sparseArray.size() > 0) {
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

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public void remove(int i) {
            this.pr.remove(i);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, LogType.UNEXP_OTHER, 116})
    private static final class pr<T, R> implements Function<T, R> {
        private pr() {
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
