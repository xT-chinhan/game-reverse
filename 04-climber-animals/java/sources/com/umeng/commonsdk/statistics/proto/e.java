package com.umeng.commonsdk.statistics.proto;

import com.anythink.core.common.e.f;
import com.umeng.analytics.pro.db;
import com.umeng.analytics.pro.de;
import com.umeng.analytics.pro.dk;
import com.umeng.analytics.pro.dl;
import com.umeng.analytics.pro.dq;
import com.umeng.analytics.pro.dr;
import com.umeng.analytics.pro.dx;
import com.umeng.analytics.pro.dy;
import com.umeng.analytics.pro.ed;
import com.umeng.analytics.pro.eg;
import com.umeng.analytics.pro.ei;
import com.umeng.analytics.pro.ej;
import com.umeng.analytics.pro.el;
import com.umeng.analytics.pro.em;
import com.umeng.analytics.pro.en;
import com.umeng.analytics.pro.eo;
import com.umeng.analytics.pro.ep;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: ImprintValue.java */
/* JADX INFO: loaded from: classes4.dex */
public class e implements de<e, EnumC0677e>, Serializable, Cloneable {
    public static final Map<EnumC0677e, dq> d;
    private static final long e = 7501688097813630241L;
    private static final ei f = new ei("ImprintValue");
    private static final dy g = new dy(f.a.d, (byte) 11, 1);
    private static final dy h = new dy("ts", (byte) 10, 2);
    private static final dy i = new dy("guid", (byte) 11, 3);
    private static final Map<Class<? extends el>, em> j;
    private static final int k = 0;
    public String a;
    public long b;
    public String c;
    private byte l;
    private EnumC0677e[] m;

    public void k() throws dk {
    }

    static {
        HashMap map = new HashMap();
        j = map;
        map.put(en.class, new b());
        map.put(eo.class, new d());
        EnumMap enumMap = new EnumMap(EnumC0677e.class);
        enumMap.put(EnumC0677e.VALUE, new dq(f.a.d, (byte) 2, new dr((byte) 11)));
        enumMap.put(EnumC0677e.TS, new dq("ts", (byte) 2, new dr((byte) 10)));
        enumMap.put(EnumC0677e.GUID, new dq("guid", (byte) 2, new dr((byte) 11)));
        Map<EnumC0677e, dq> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        d = mapUnmodifiableMap;
        dq.a(e.class, mapUnmodifiableMap);
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ImprintValue.java */
    public enum EnumC0677e implements dl {
        VALUE(1, f.a.d),
        TS(2, "ts"),
        GUID(3, "guid");

        private static final Map<String, EnumC0677e> d = new HashMap();
        private final short e;
        private final String f;

        static {
            for (EnumC0677e enumC0677e : EnumSet.allOf(EnumC0677e.class)) {
                d.put(enumC0677e.b(), enumC0677e);
            }
        }

        public static EnumC0677e a(int i) {
            if (i == 1) {
                return VALUE;
            }
            if (i == 2) {
                return TS;
            }
            if (i != 3) {
                return null;
            }
            return GUID;
        }

        public static EnumC0677e b(int i) {
            EnumC0677e enumC0677eA = a(i);
            if (enumC0677eA != null) {
                return enumC0677eA;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        public static EnumC0677e a(String str) {
            return d.get(str);
        }

        EnumC0677e(short s, String str) {
            this.e = s;
            this.f = str;
        }

        @Override // com.umeng.analytics.pro.dl
        public short a() {
            return this.e;
        }

        @Override // com.umeng.analytics.pro.dl
        public String b() {
            return this.f;
        }
    }

    public e() {
        this.l = (byte) 0;
        this.m = new EnumC0677e[]{EnumC0677e.VALUE, EnumC0677e.TS, EnumC0677e.GUID};
    }

    public e(long j2, String str) {
        this();
        this.b = j2;
        b(true);
        this.c = str;
    }

    public e(e eVar) {
        this.l = (byte) 0;
        this.m = new EnumC0677e[]{EnumC0677e.VALUE, EnumC0677e.TS, EnumC0677e.GUID};
        this.l = eVar.l;
        if (eVar.d()) {
            this.a = eVar.a;
        }
        this.b = eVar.b;
        if (eVar.j()) {
            this.c = eVar.c;
        }
    }

    @Override // com.umeng.analytics.pro.de
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e deepCopy() {
        return new e(this);
    }

    @Override // com.umeng.analytics.pro.de
    public void clear() {
        this.a = null;
        b(false);
        this.b = 0L;
        this.c = null;
    }

    public String b() {
        return this.a;
    }

    public e a(String str) {
        this.a = str;
        return this;
    }

    public void c() {
        this.a = null;
    }

    public boolean d() {
        return this.a != null;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    public long e() {
        return this.b;
    }

    public e a(long j2) {
        this.b = j2;
        b(true);
        return this;
    }

    public void f() {
        this.l = db.b(this.l, 0);
    }

    public boolean g() {
        return db.a(this.l, 0);
    }

    public void b(boolean z) {
        this.l = db.a(this.l, 0, z);
    }

    public String h() {
        return this.c;
    }

    public e b(String str) {
        this.c = str;
        return this;
    }

    public void i() {
        this.c = null;
    }

    public boolean j() {
        return this.c != null;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.c = null;
    }

    @Override // com.umeng.analytics.pro.de
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public EnumC0677e fieldForId(int i2) {
        return EnumC0677e.a(i2);
    }

    @Override // com.umeng.analytics.pro.de
    public void read(ed edVar) throws dk {
        j.get(edVar.D()).b().b(edVar, this);
    }

    @Override // com.umeng.analytics.pro.de
    public void write(ed edVar) throws dk {
        j.get(edVar.D()).b().a(edVar, this);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ImprintValue(");
        if (d()) {
            sb.append("value:");
            String str = this.a;
            if (str == null) {
                sb.append(AbstractJsonLexerKt.NULL);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("ts:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("guid:");
        String str2 = this.c;
        if (str2 == null) {
            sb.append(AbstractJsonLexerKt.NULL);
        } else {
            sb.append(str2);
        }
        sb.append(")");
        return sb.toString();
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new dx(new ep(objectOutputStream)));
        } catch (dk e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.l = (byte) 0;
            read(new dx(new ep(objectInputStream)));
        } catch (dk e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* JADX INFO: compiled from: ImprintValue.java */
    private static class b implements em {
        private b() {
        }

        @Override // com.umeng.analytics.pro.em
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: ImprintValue.java */
    private static class a extends en<e> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.el
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(ed edVar, e eVar) throws dk {
            edVar.j();
            while (true) {
                dy dyVarL = edVar.l();
                if (dyVarL.b != 0) {
                    short s = dyVarL.c;
                    if (s != 1) {
                        if (s != 2) {
                            if (s == 3) {
                                if (dyVarL.b == 11) {
                                    eVar.c = edVar.z();
                                    eVar.c(true);
                                } else {
                                    eg.a(edVar, dyVarL.b);
                                }
                            } else {
                                eg.a(edVar, dyVarL.b);
                            }
                        } else if (dyVarL.b == 10) {
                            eVar.b = edVar.x();
                            eVar.b(true);
                        } else {
                            eg.a(edVar, dyVarL.b);
                        }
                    } else if (dyVarL.b == 11) {
                        eVar.a = edVar.z();
                        eVar.a(true);
                    } else {
                        eg.a(edVar, dyVarL.b);
                    }
                    edVar.m();
                } else {
                    edVar.k();
                    eVar.k();
                    return;
                }
            }
        }

        @Override // com.umeng.analytics.pro.el
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ed edVar, e eVar) throws dk {
            eVar.k();
            edVar.a(e.f);
            if (eVar.a != null && eVar.d()) {
                edVar.a(e.g);
                edVar.a(eVar.a);
                edVar.c();
            }
            if (eVar.g()) {
                edVar.a(e.h);
                edVar.a(eVar.b);
                edVar.c();
            }
            if (eVar.c != null && eVar.j()) {
                edVar.a(e.i);
                edVar.a(eVar.c);
                edVar.c();
            }
            edVar.d();
            edVar.b();
        }
    }

    /* JADX INFO: compiled from: ImprintValue.java */
    private static class d implements em {
        private d() {
        }

        @Override // com.umeng.analytics.pro.em
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    /* JADX INFO: compiled from: ImprintValue.java */
    private static class c extends eo<e> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.el
        public void a(ed edVar, e eVar) throws dk {
            ej ejVar = (ej) edVar;
            BitSet bitSet = new BitSet();
            if (eVar.d()) {
                bitSet.set(0);
            }
            if (eVar.g()) {
                bitSet.set(1);
            }
            if (eVar.j()) {
                bitSet.set(2);
            }
            ejVar.a(bitSet, 3);
            if (eVar.d()) {
                ejVar.a(eVar.a);
            }
            if (eVar.g()) {
                ejVar.a(eVar.b);
            }
            if (eVar.j()) {
                ejVar.a(eVar.c);
            }
        }

        @Override // com.umeng.analytics.pro.el
        public void b(ed edVar, e eVar) throws dk {
            ej ejVar = (ej) edVar;
            BitSet bitSetB = ejVar.b(3);
            if (bitSetB.get(0)) {
                eVar.a = ejVar.z();
                eVar.a(true);
            }
            if (bitSetB.get(1)) {
                eVar.b = ejVar.x();
                eVar.b(true);
            }
            if (bitSetB.get(2)) {
                eVar.c = ejVar.z();
                eVar.c(true);
            }
        }
    }
}
