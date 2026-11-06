package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.aw;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bj;
import com.umeng.analytics.pro.bk;
import com.umeng.analytics.pro.bl;
import com.umeng.analytics.pro.bn;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.bq;
import com.umeng.analytics.pro.br;
import com.umeng.analytics.pro.bs;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bw;
import com.umeng.analytics.pro.by;
import com.umeng.analytics.pro.ca;
import com.umeng.analytics.pro.cb;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.cf;
import com.umeng.analytics.pro.cg;
import com.umeng.analytics.pro.ch;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: IdTracking.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements aw<c, e>, Serializable, Cloneable {
    public static final Map<e, bi> d;
    private static final long e = -5764118265293965743L;
    private static final ca f = new ca("IdTracking");
    private static final bq g = new bq("snapshots", cc.k, 1);
    private static final bq h = new bq("journals", cc.m, 2);
    private static final bq i = new bq("checksum", (byte) 11, 3);
    private static final Map<Class<? extends cd>, ce> j = new HashMap();
    public Map<String, com.umeng.commonsdk.statistics.proto.b> a;
    public List<com.umeng.commonsdk.statistics.proto.a> b;
    public String c;
    private e[] k;

    static {
        j.put(cf.class, new b());
        j.put(cg.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.SNAPSHOTS, new bi("snapshots", (byte) 1, new bl(cc.k, new bj((byte) 11), new bn((byte) 12, com.umeng.commonsdk.statistics.proto.b.class))));
        enumMap.put(e.JOURNALS, new bi("journals", (byte) 2, new bk(cc.m, new bn((byte) 12, com.umeng.commonsdk.statistics.proto.a.class))));
        enumMap.put(e.CHECKSUM, new bi("checksum", (byte) 2, new bj((byte) 11)));
        d = Collections.unmodifiableMap(enumMap);
        bi.a(c.class, d);
    }

    /* JADX INFO: compiled from: IdTracking.java */
    public enum e implements bd {
        SNAPSHOTS(1, "snapshots"),
        JOURNALS(2, "journals"),
        CHECKSUM(3, "checksum");

        private static final Map<String, e> d = new HashMap();
        private final short e;
        private final String f;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                d.put(eVar.b(), eVar);
            }
        }

        public static e a(int i) {
            switch (i) {
                case 1:
                    return SNAPSHOTS;
                case 2:
                    return JOURNALS;
                case 3:
                    return CHECKSUM;
                default:
                    return null;
            }
        }

        public static e b(int i) {
            e eVarA = a(i);
            if (eVarA == null) {
                throw new IllegalArgumentException("Field " + i + " doesn't exist!");
            }
            return eVarA;
        }

        public static e a(String str) {
            return d.get(str);
        }

        e(short s, String str) {
            this.e = s;
            this.f = str;
        }

        @Override // com.umeng.analytics.pro.bd
        public short a() {
            return this.e;
        }

        @Override // com.umeng.analytics.pro.bd
        public String b() {
            return this.f;
        }
    }

    public c() {
        this.k = new e[]{e.JOURNALS, e.CHECKSUM};
    }

    public c(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this();
        this.a = map;
    }

    public c(c cVar) {
        this.k = new e[]{e.JOURNALS, e.CHECKSUM};
        if (cVar.e()) {
            HashMap map = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.a.entrySet()) {
                map.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.b(entry.getValue()));
            }
            this.a = map;
        }
        if (cVar.j()) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.b.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.umeng.commonsdk.statistics.proto.a(it.next()));
            }
            this.b = arrayList;
        }
        if (cVar.m()) {
            this.c = cVar.c;
        }
    }

    @Override // com.umeng.analytics.pro.aw
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public c deepCopy() {
        return new c(this);
    }

    @Override // com.umeng.analytics.pro.aw
    public void clear() {
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public int b() {
        if (this.a == null) {
            return 0;
        }
        return this.a.size();
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.b bVar) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, bVar);
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.b> c() {
        return this.a;
    }

    public c a(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this.a = map;
        return this;
    }

    public void d() {
        this.a = null;
    }

    public boolean e() {
        return this.a != null;
    }

    public void a(boolean z) {
        if (!z) {
            this.a = null;
        }
    }

    public int f() {
        if (this.b == null) {
            return 0;
        }
        return this.b.size();
    }

    public Iterator<com.umeng.commonsdk.statistics.proto.a> g() {
        if (this.b == null) {
            return null;
        }
        return this.b.iterator();
    }

    public void a(com.umeng.commonsdk.statistics.proto.a aVar) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(aVar);
    }

    public List<com.umeng.commonsdk.statistics.proto.a> h() {
        return this.b;
    }

    public c a(List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.b = list;
        return this;
    }

    public void i() {
        this.b = null;
    }

    public boolean j() {
        return this.b != null;
    }

    public void b(boolean z) {
        if (!z) {
            this.b = null;
        }
    }

    public String k() {
        return this.c;
    }

    public c a(String str) {
        this.c = str;
        return this;
    }

    public void l() {
        this.c = null;
    }

    public boolean m() {
        return this.c != null;
    }

    public void c(boolean z) {
        if (!z) {
            this.c = null;
        }
    }

    @Override // com.umeng.analytics.pro.aw
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    @Override // com.umeng.analytics.pro.aw
    public void read(bv bvVar) throws bc {
        j.get(bvVar.D()).b().b(bvVar, this);
    }

    @Override // com.umeng.analytics.pro.aw
    public void write(bv bvVar) throws bc {
        j.get(bvVar.D()).b().a(bvVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdTracking(");
        sb.append("snapshots:");
        if (this.a == null) {
            sb.append(AbstractJsonLexerKt.NULL);
        } else {
            sb.append(this.a);
        }
        if (j()) {
            sb.append(", ");
            sb.append("journals:");
            if (this.b == null) {
                sb.append(AbstractJsonLexerKt.NULL);
            } else {
                sb.append(this.b);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("checksum:");
            if (this.c == null) {
                sb.append(AbstractJsonLexerKt.NULL);
            } else {
                sb.append(this.c);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void n() throws bc {
        if (this.a == null) {
            throw new bw("Required field 'snapshots' was not present! Struct: " + toString());
        }
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bp(new ch(objectOutputStream)));
        } catch (bc e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            read(new bp(new ch(objectInputStream)));
        } catch (bc e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* JADX INFO: compiled from: IdTracking.java */
    private static class b implements ce {
        private b() {
        }

        @Override // com.umeng.analytics.pro.ce
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: IdTracking.java */
    private static class a extends cf<c> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(bv bvVar, c cVar) throws bc {
            bvVar.j();
            while (true) {
                bq bqVarL = bvVar.l();
                if (bqVarL.b != 0) {
                    int i = 0;
                    switch (bqVarL.c) {
                        case 1:
                            if (bqVarL.b == 13) {
                                bs bsVarN = bvVar.n();
                                cVar.a = new HashMap(bsVarN.c * 2);
                                while (i < bsVarN.c) {
                                    String strZ = bvVar.z();
                                    com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                                    bVar.read(bvVar);
                                    cVar.a.put(strZ, bVar);
                                    i++;
                                }
                                bvVar.o();
                                cVar.a(true);
                            } else {
                                by.a(bvVar, bqVarL.b);
                            }
                            break;
                        case 2:
                            if (bqVarL.b == 15) {
                                br brVarP = bvVar.p();
                                cVar.b = new ArrayList(brVarP.b);
                                while (i < brVarP.b) {
                                    com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                                    aVar.read(bvVar);
                                    cVar.b.add(aVar);
                                    i++;
                                }
                                bvVar.q();
                                cVar.b(true);
                            } else {
                                by.a(bvVar, bqVarL.b);
                            }
                            break;
                        case 3:
                            if (bqVarL.b == 11) {
                                cVar.c = bvVar.z();
                                cVar.c(true);
                            } else {
                                by.a(bvVar, bqVarL.b);
                            }
                            break;
                        default:
                            by.a(bvVar, bqVarL.b);
                            break;
                    }
                    bvVar.m();
                } else {
                    bvVar.k();
                    cVar.n();
                    return;
                }
            }
        }

        @Override // com.umeng.analytics.pro.cd
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(bv bvVar, c cVar) throws bc {
            cVar.n();
            bvVar.a(c.f);
            if (cVar.a != null) {
                bvVar.a(c.g);
                bvVar.a(new bs((byte) 11, (byte) 12, cVar.a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.a.entrySet()) {
                    bvVar.a(entry.getKey());
                    entry.getValue().write(bvVar);
                }
                bvVar.e();
                bvVar.c();
            }
            if (cVar.b != null && cVar.j()) {
                bvVar.a(c.h);
                bvVar.a(new br((byte) 12, cVar.b.size()));
                Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.b.iterator();
                while (it.hasNext()) {
                    it.next().write(bvVar);
                }
                bvVar.f();
                bvVar.c();
            }
            if (cVar.c != null && cVar.m()) {
                bvVar.a(c.i);
                bvVar.a(cVar.c);
                bvVar.c();
            }
            bvVar.d();
            bvVar.b();
        }
    }

    /* JADX INFO: compiled from: IdTracking.java */
    private static class d implements ce {
        private d() {
        }

        @Override // com.umeng.analytics.pro.ce
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0291c b() {
            return new C0291c();
        }
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IdTracking.java */
    private static class C0291c extends cg<c> {
        private C0291c() {
        }

        @Override // com.umeng.analytics.pro.cd
        public void a(bv bvVar, c cVar) throws bc {
            cb cbVar = (cb) bvVar;
            cbVar.a(cVar.a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.a.entrySet()) {
                cbVar.a(entry.getKey());
                entry.getValue().write(cbVar);
            }
            BitSet bitSet = new BitSet();
            if (cVar.j()) {
                bitSet.set(0);
            }
            if (cVar.m()) {
                bitSet.set(1);
            }
            cbVar.a(bitSet, 2);
            if (cVar.j()) {
                cbVar.a(cVar.b.size());
                Iterator<com.umeng.commonsdk.statistics.proto.a> it = cVar.b.iterator();
                while (it.hasNext()) {
                    it.next().write(cbVar);
                }
            }
            if (cVar.m()) {
                cbVar.a(cVar.c);
            }
        }

        @Override // com.umeng.analytics.pro.cd
        public void b(bv bvVar, c cVar) throws bc {
            cb cbVar = (cb) bvVar;
            bs bsVar = new bs((byte) 11, (byte) 12, cbVar.w());
            cVar.a = new HashMap(bsVar.c * 2);
            for (int i = 0; i < bsVar.c; i++) {
                String strZ = cbVar.z();
                com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                bVar.read(cbVar);
                cVar.a.put(strZ, bVar);
            }
            cVar.a(true);
            BitSet bitSetB = cbVar.b(2);
            if (bitSetB.get(0)) {
                br brVar = new br((byte) 12, cbVar.w());
                cVar.b = new ArrayList(brVar.b);
                for (int i2 = 0; i2 < brVar.b; i2++) {
                    com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                    aVar.read(cbVar);
                    cVar.b.add(aVar);
                }
                cVar.b(true);
            }
            if (bitSetB.get(1)) {
                cVar.c = cbVar.z();
                cVar.c(true);
            }
        }
    }
}
