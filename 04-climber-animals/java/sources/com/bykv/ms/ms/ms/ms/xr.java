package com.bykv.ms.ms.ms.ms;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
public class xr {
    public static final Function<SparseArray<Object>, Object> ah;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static final ValueSet f12ms = ms(0).xr();
    public static final Bridge xr;
    private final SparseArray<Object> d;
    private ValueSet ka;

    public interface ah extends ValueSet.ValueGetter<Integer> {
    }

    static {
        xr = new ms();
        ah = new C0173xr();
    }

    private xr(SparseArray<Object> sparseArray, ValueSet valueSet) {
        this.d = sparseArray;
        this.ka = valueSet;
    }

    private xr(SparseArray<Object> sparseArray) {
        this.d = sparseArray == null ? new SparseArray<>() : sparseArray;
    }

    public static final xr ms() {
        return new xr(new SparseArray());
    }

    public static final xr ms(int i) {
        return new xr(new SparseArray(i));
    }

    public static final xr ms(SparseArray<Object> sparseArray) {
        return new xr(sparseArray);
    }

    public static final xr ms(ValueSet valueSet) {
        return new xr(new SparseArray(), valueSet);
    }

    public xr ms(int i, Object obj) {
        this.d.put(i, obj);
        return this;
    }

    public xr ms(int i, String str) {
        this.d.put(i, str);
        return this;
    }

    public xr ms(int i, int i2) {
        this.d.put(i, Integer.valueOf(i2));
        return this;
    }

    public xr ms(int i, double d2) {
        this.d.put(i, Double.valueOf(d2));
        return this;
    }

    public xr ms(int i, boolean z) {
        this.d.put(i, Boolean.valueOf(z));
        return this;
    }

    public xr ms(int i, long j) {
        this.d.put(i, Long.valueOf(j));
        return this;
    }

    public xr ms(int i, float f) {
        this.d.put(i, Float.valueOf(f));
        return this;
    }

    public xr ms(int i, ah ahVar) {
        this.d.put(i, ahVar);
        return this;
    }

    public ValueSet xr() {
        return new d(this.d, this.ka);
    }

    private static final class d implements ValueSet {
        private int ah;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        private final SparseArray<Object> f13ms;
        private ValueSet xr;

        private d(SparseArray<Object> sparseArray, ValueSet valueSet) {
            this.ah = -1;
            this.f13ms = sparseArray;
            this.xr = valueSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T[] arrayValue(int i, Class<T> cls) {
            Object obj = this.f13ms.get(i);
            if (obj == null) {
                ValueSet valueSet = this.xr;
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
            ValueSet.ValueGetter valueGetter = (T) this.f13ms.get(i);
            if (valueGetter == null) {
                ValueSet valueSet = this.xr;
                if (valueSet != null) {
                    return (T) valueSet.objectValue(i, cls);
                }
                return null;
            }
            if (valueGetter instanceof ValueSet.ValueGetter) {
                valueGetter = (T) valueGetter.get();
            }
            if (cls.isInstance(valueGetter)) {
                return (T) valueGetter;
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
            Object obj = this.f13ms.get(i);
            if (obj == null && (valueSet = this.xr) != null) {
                return valueSet.doubleValue(i);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            if (obj instanceof Double) {
                return ((Double) obj).doubleValue();
            }
            return 0.0d;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i, String str) {
            ValueSet valueSet;
            Object obj = this.f13ms.get(i);
            if (obj == null && (valueSet = this.xr) != null) {
                return valueSet.stringValue(i, str);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof String ? obj.toString() : str;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i, int i2) {
            ValueSet valueSet;
            Object obj = this.f13ms.get(i);
            if (obj == null && (valueSet = this.xr) != null) {
                return valueSet.intValue(i, i2);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Integer ? ((Integer) obj).intValue() : i2;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i, boolean z) {
            ValueSet valueSet;
            Object obj = this.f13ms.get(i);
            if (obj == null && (valueSet = this.xr) != null) {
                return valueSet.booleanValue(i, z);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i, long j) {
            ValueSet valueSet;
            Object obj = this.f13ms.get(i);
            if (obj == null && (valueSet = this.xr) != null) {
                return valueSet.longValue(i, j);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Long ? ((Long) obj).longValue() : j;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i, float f) {
            ValueSet valueSet;
            Object obj = this.f13ms.get(i);
            if (obj == null && (valueSet = this.xr) != null) {
                return valueSet.floatValue(i, f);
            }
            if (obj instanceof ValueSet.ValueGetter) {
                obj = ((ValueSet.ValueGetter) obj).get();
            }
            return obj instanceof Float ? ((Float) obj).floatValue() : f;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean containsKey(int i) {
            ValueSet valueSet;
            int iIndexOfKey = this.f13ms.indexOfKey(i);
            if (iIndexOfKey >= 0 || (valueSet = this.xr) == null) {
                return iIndexOfKey >= 0;
            }
            return valueSet.containsKey(i);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public Set<Integer> keys() {
            int size = this.f13ms.size();
            HashSet hashSet = new HashSet();
            for (int i = 0; i < size; i++) {
                hashSet.add(Integer.valueOf(this.f13ms.keyAt(i)));
            }
            ValueSet valueSet = this.xr;
            if (valueSet != null) {
                hashSet.addAll(valueSet.keys());
            }
            this.ah = hashSet.size();
            return hashSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean isEmpty() {
            return size() <= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int size() {
            if (this.ah < 0) {
                keys();
            }
            return this.ah;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public SparseArray<Object> sparseArray() {
            SparseArray<Object> sparseArray;
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            ValueSet valueSet = this.xr;
            if (valueSet != null && (sparseArray = valueSet.sparseArray()) != null && sparseArray.size() > 0) {
                for (int i = 0; i < sparseArray.size(); i++) {
                    sparseArray2.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
                }
            }
            SparseArray<Object> sparseArray3 = this.f13ms;
            if (sparseArray3 != null && sparseArray3.size() > 0) {
                for (int i2 = 0; i2 < this.f13ms.size(); i2++) {
                    sparseArray2.put(this.f13ms.keyAt(i2), this.f13ms.valueAt(i2));
                }
            }
            return sparseArray2;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public void remove(int i) {
            this.f13ms.remove(i);
        }

        @Override // java.util.function.Supplier
        /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
        public Boolean get() {
            return Boolean.TRUE;
        }
    }

    private static final class ms implements Bridge {
        private ms() {
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return xr.f12ms;
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            if (cls == Boolean.class || cls == Boolean.TYPE) {
                return (T) Boolean.FALSE;
            }
            if (cls == Integer.TYPE || cls == Integer.class) {
                return (T) 0;
            }
            if (cls == Long.TYPE || cls == Long.class) {
                return (T) 0L;
            }
            if (cls == Double.TYPE || cls == Double.class) {
                return (T) Double.valueOf(0.0d);
            }
            if (cls == Float.TYPE || cls == Float.class) {
                return (T) Float.valueOf(0.0f);
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: com.bykv.ms.ms.ms.ms.xr$xr, reason: collision with other inner class name */
    private static final class C0173xr<T, R> implements Function<T, R> {
        private C0173xr() {
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
