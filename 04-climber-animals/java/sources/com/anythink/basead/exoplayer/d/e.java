package com.anythink.basead.exoplayer.d;

import android.os.Parcel;
import android.os.Parcelable;
import com.anythink.basead.exoplayer.k.af;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Parcelable, Comparator<a> {
    public static final Parcelable.Creator<e> CREATOR = new Parcelable.Creator<e>() { // from class: com.anythink.basead.exoplayer.d.e.1
        private static e a(Parcel parcel) {
            return new e(parcel);
        }

        private static e[] a(int i) {
            return new e[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ e[] newArray(int i) {
            return new e[i];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }
    };
    public final String a;
    public final int b;
    private final a[] c;
    private int d;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(a aVar, a aVar2) {
        a aVar3 = aVar;
        a aVar4 = aVar2;
        if (com.anythink.basead.exoplayer.b.bh.equals(aVar3.f)) {
            return com.anythink.basead.exoplayer.b.bh.equals(aVar4.f) ? 0 : 1;
        }
        return aVar3.f.compareTo(aVar4.f);
    }

    public static e a(e eVar, e eVar2) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (eVar != null) {
            str = eVar.a;
            for (a aVar : eVar.c) {
                if (aVar.a()) {
                    arrayList.add(aVar);
                }
            }
        } else {
            str = null;
        }
        if (eVar2 != null) {
            if (str == null) {
                str = eVar2.a;
            }
            int size = arrayList.size();
            for (a aVar2 : eVar2.c) {
                if (aVar2.a() && !a(arrayList, size, aVar2.f)) {
                    arrayList.add(aVar2);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new e(str, arrayList);
    }

    public e(List<a> list) {
        this(null, false, (a[]) list.toArray(new a[list.size()]));
    }

    private e(String str, List<a> list) {
        this(str, false, (a[]) list.toArray(new a[list.size()]));
    }

    private e(a... aVarArr) {
        this((String) null, aVarArr);
    }

    private e(String str, a... aVarArr) {
        this(str, true, aVarArr);
    }

    private e(String str, boolean z, a... aVarArr) {
        this.a = str;
        aVarArr = z ? (a[]) aVarArr.clone() : aVarArr;
        Arrays.sort(aVarArr, this);
        this.c = aVarArr;
        this.b = aVarArr.length;
    }

    e(Parcel parcel) {
        this.a = parcel.readString();
        a[] aVarArr = (a[]) parcel.createTypedArray(a.CREATOR);
        this.c = aVarArr;
        this.b = aVarArr.length;
    }

    @Deprecated
    private a a(UUID uuid) {
        for (a aVar : this.c) {
            if (aVar.a(uuid)) {
                return aVar;
            }
        }
        return null;
    }

    public final a a(int i) {
        return this.c[i];
    }

    public final e a(String str) {
        return af.a((Object) this.a, (Object) str) ? this : new e(str, false, this.c);
    }

    public final int hashCode() {
        if (this.d == 0) {
            String str = this.a;
            this.d = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.c);
        }
        return this.d;
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            e eVar = (e) obj;
            if (af.a((Object) this.a, (Object) eVar.a) && Arrays.equals(this.c, eVar.c)) {
                return true;
            }
        }
        return false;
    }

    private static int a(a aVar, a aVar2) {
        if (com.anythink.basead.exoplayer.b.bh.equals(aVar.f)) {
            return com.anythink.basead.exoplayer.b.bh.equals(aVar2.f) ? 0 : 1;
        }
        return aVar.f.compareTo(aVar2.f);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeTypedArray(this.c, 0);
    }

    private static boolean a(ArrayList<a> arrayList, int i, UUID uuid) {
        for (int i2 = 0; i2 < i; i2++) {
            if (arrayList.get(i2).f.equals(uuid)) {
                return true;
            }
        }
        return false;
    }

    public static final class a implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.anythink.basead.exoplayer.d.e.a.1
            private static a a(Parcel parcel) {
                return new a(parcel);
            }

            private static a[] a(int i) {
                return new a[i];
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ a[] newArray(int i) {
                return new a[i];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }
        };
        public final String a;
        public final String b;
        public final byte[] c;
        public final boolean d;
        private int e;
        private final UUID f;

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public a(UUID uuid, String str, byte[] bArr) {
            this(uuid, str, bArr, (byte) 0);
        }

        private a(UUID uuid, String str, byte[] bArr, byte b) {
            this(uuid, (String) null, str, bArr);
        }

        private a(UUID uuid, String str, String str2, byte[] bArr) {
            this.f = (UUID) com.anythink.basead.exoplayer.k.a.a(uuid);
            this.a = str;
            this.b = (String) com.anythink.basead.exoplayer.k.a.a(str2);
            this.c = bArr;
            this.d = false;
        }

        a(Parcel parcel) {
            this.f = new UUID(parcel.readLong(), parcel.readLong());
            this.a = parcel.readString();
            this.b = parcel.readString();
            this.c = parcel.createByteArray();
            this.d = parcel.readByte() != 0;
        }

        public final boolean a(UUID uuid) {
            return com.anythink.basead.exoplayer.b.bh.equals(this.f) || uuid.equals(this.f);
        }

        private boolean b(a aVar) {
            return a() && !aVar.a() && a(aVar.f);
        }

        public final boolean a() {
            return this.c != null;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            a aVar = (a) obj;
            return af.a((Object) this.a, (Object) aVar.a) && af.a((Object) this.b, (Object) aVar.b) && af.a(this.f, aVar.f) && Arrays.equals(this.c, aVar.c);
        }

        public final int hashCode() {
            if (this.e == 0) {
                int iHashCode = this.f.hashCode() * 31;
                String str = this.a;
                this.e = ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.b.hashCode()) * 31) + Arrays.hashCode(this.c);
            }
            return this.e;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.f.getMostSignificantBits());
            parcel.writeLong(this.f.getLeastSignificantBits());
            parcel.writeString(this.a);
            parcel.writeString(this.b);
            parcel.writeByteArray(this.c);
            parcel.writeByte(this.d ? (byte) 1 : (byte) 0);
        }
    }
}
