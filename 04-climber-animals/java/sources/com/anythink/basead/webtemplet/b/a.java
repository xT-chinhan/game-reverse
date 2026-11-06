package com.anythink.basead.webtemplet.b;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static InterfaceC0069a a;

    /* JADX INFO: renamed from: com.anythink.basead.webtemplet.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0069a {
        boolean a();
    }

    public static abstract class b {

        /* JADX INFO: renamed from: com.anythink.basead.webtemplet.b.a$b$a, reason: collision with other inner class name */
        public static class C0070a extends Throwable {
            private static final long d = 1;
            private Class<?> a;
            private String b;
            private String c;

            public C0070a(String str) {
                super(str);
            }

            public C0070a(Exception exc) {
                super(exc);
            }

            @Override // java.lang.Throwable
            public final String toString() {
                return getCause() != null ? getClass().getName() + ": " + getCause() : super.toString();
            }

            private Class<?> a() {
                return this.a;
            }

            public final void a(Class<?> cls) {
                this.a = cls;
            }

            private String b() {
                return this.c;
            }

            public final void a(String str) {
                this.c = str;
            }

            private String c() {
                return this.b;
            }

            public final void b(String str) {
                this.b = str;
            }
        }
    }

    public static class e<C, T> {
        private Object a;
        private final Field b;

        /* JADX WARN: Multi-variable type inference failed */
        private <T2> e<C, T2> a(Class<?> cls) throws b.C0070a {
            Field field = this.b;
            if (field != null && !cls.isAssignableFrom(field.getType())) {
                a.b(new b.C0070a(new ClassCastException(this.b + " is not of type " + cls)));
            }
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private <T2> e<C, T2> b(Class<T2> cls) throws b.C0070a {
            Field field = this.b;
            if (field != null && !cls.isAssignableFrom(field.getType())) {
                a.b(new b.C0070a(new ClassCastException(this.b + " is not of type " + cls)));
            }
            return this;
        }

        private e<C, T> a(String str) throws b.C0070a {
            try {
                Class<?> cls = Class.forName(str);
                Field field = this.b;
                if (field != null && !cls.isAssignableFrom(field.getType())) {
                    a.b(new b.C0070a(new ClassCastException(this.b + " is not of type " + cls)));
                }
                return this;
            } catch (ClassNotFoundException e) {
                a.b(new b.C0070a(e));
                return this;
            }
        }

        private T a() {
            try {
                return (T) this.b.get(this.a);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }

        private void a(Object obj) {
            try {
                this.b.set(this.a, obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        private e<C, T> b(C c) {
            this.a = c;
            return this;
        }

        e(Class<C> cls, String str, int i) {
            Field declaredField = null;
            if (cls != null) {
                try {
                    this.a = null;
                    declaredField = cls.getDeclaredField(str);
                    if (i > 0 && (declaredField.getModifiers() & i) != i) {
                        a.b(new b.C0070a(declaredField + " does not match modifiers: " + i));
                    }
                    declaredField.setAccessible(true);
                    return;
                } catch (NoSuchFieldException e) {
                    b.C0070a c0070a = new b.C0070a(e);
                    c0070a.a((Class<?>) cls);
                    c0070a.b(str);
                    a.b(c0070a);
                    return;
                } finally {
                    this.b = declaredField;
                }
            }
            this.b = null;
        }

        private Field b() {
            return this.b;
        }
    }

    public static class f {
        protected final Method a;

        public final Object a(Object obj, Object... objArr) {
            Method method = this.a;
            if (method == null) {
                return null;
            }
            try {
                return method.invoke(obj, objArr);
            } catch (Exception e) {
                e.getMessage();
                return null;
            }
        }

        f(Class<?> cls, String str, Class<?>[] clsArr, int i) throws NoSuchMethodException {
            Method declaredMethod = null;
            if (cls != null) {
                while (cls != Object.class && cls != null) {
                    try {
                        try {
                            declaredMethod = cls.getDeclaredMethod(str, clsArr);
                            break;
                        } catch (NoSuchMethodException | SecurityException unused) {
                            cls = cls.getSuperclass();
                        }
                    } catch (Exception e) {
                        b.C0070a c0070a = new b.C0070a(e);
                        c0070a.a(cls);
                        c0070a.a(str);
                        a.b(c0070a);
                        return;
                    } finally {
                        this.a = declaredMethod;
                    }
                }
                if (declaredMethod != null) {
                    if (i > 0 && (declaredMethod.getModifiers() & i) != i) {
                        a.b(new b.C0070a(declaredMethod + " does not match modifiers: " + i));
                    }
                    declaredMethod.setAccessible(true);
                }
                return;
            }
            this.a = null;
        }

        public final Method a() {
            return this.a;
        }
    }

    public static class d {
        protected Constructor<?> a;

        d(Class<?> cls, Class<?>[] clsArr) throws b.C0070a {
            if (cls == null) {
                return;
            }
            try {
                this.a = cls.getDeclaredConstructor(clsArr);
            } catch (NoSuchMethodException e) {
                b.C0070a c0070a = new b.C0070a(e);
                c0070a.a(cls);
                a.b(c0070a);
            }
        }

        private Object a(Object... objArr) {
            this.a.setAccessible(true);
            try {
                return this.a.newInstance(objArr);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static class c<C> {
        protected Class<C> a;

        private e<C, Object> a(String str) {
            return new e<>(this.a, str, 8);
        }

        private e<C, Object> b(String str) {
            return new e<>(this.a, str, 0);
        }

        private f b(String str, Class<?>... clsArr) {
            return new f(this.a, str, clsArr, 8);
        }

        public final f a(String str, Class<?>... clsArr) {
            return new f(this.a, str, clsArr, 0);
        }

        private d a(Class<?>... clsArr) {
            return new d(this.a, clsArr);
        }

        public c(Class<C> cls) {
            this.a = cls;
        }

        private Class<C> a() {
            return this.a;
        }
    }

    private static <T> c<T> a(Class<T> cls) {
        return new c<>(cls);
    }

    private static <T> c<T> a(String str) throws b.C0070a {
        try {
            return new c<>(Class.forName(str));
        } catch (ClassNotFoundException e2) {
            b(new b.C0070a(e2));
            return new c<>(null);
        }
    }

    public static <T> c<T> a(ClassLoader classLoader, String str) throws b.C0070a {
        try {
            return new c<>(classLoader.loadClass(str));
        } catch (Exception e2) {
            b(new b.C0070a(e2));
            return new c<>(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(b.C0070a c0070a) throws b.C0070a {
        InterfaceC0069a interfaceC0069a = a;
        if (interfaceC0069a == null || !interfaceC0069a.a()) {
            throw c0070a;
        }
    }

    private static void a(InterfaceC0069a interfaceC0069a) {
        a = interfaceC0069a;
    }

    private a() {
    }
}
