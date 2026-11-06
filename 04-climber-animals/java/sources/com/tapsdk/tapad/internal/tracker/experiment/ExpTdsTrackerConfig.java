package com.tapsdk.tapad.internal.tracker.experiment;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tapsdk.tapad.internal.utils.GUIDHelper;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class ExpTdsTrackerConfig implements Parcelable {
    public static final Parcelable.Creator<ExpTdsTrackerConfig> CREATOR = new a();
    private static final int u = 5;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final int f;
    public final String g;
    public final Map<String, String> h;
    public final String i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;
    public final String q;
    public final String r;
    public final String s;
    public final String t;

    static class a implements Parcelable.Creator<ExpTdsTrackerConfig> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ExpTdsTrackerConfig createFromParcel(Parcel parcel) {
            return new ExpTdsTrackerConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ExpTdsTrackerConfig[] newArray(int i) {
            return new ExpTdsTrackerConfig[i];
        }
    }

    public static class b {
        private String a;
        private String b;
        private String c;
        private String d;
        private String e;
        private int g;
        private String j;
        private String k;
        private String l;
        private String m;
        private String n;
        private String o;
        private String p;
        private String q;
        private int f = 5;
        private int h = -1;
        private String i = "";

        public b a(int i) {
            this.f = i;
            return this;
        }

        public b a(String str) {
            this.d = str;
            return this;
        }

        public ExpTdsTrackerConfig a(Context context) {
            String str;
            String strA = g.a(this.g);
            if (TextUtils.isEmpty(strA)) {
                throw new RuntimeException("trackerType is invalid");
            }
            if (context != null) {
                GUIDHelper.INSTANCE.init(context.getApplicationContext());
            }
            if (TextUtils.isEmpty(this.d)) {
                str = "accessKeyId";
            } else if (TextUtils.isEmpty(this.e)) {
                str = "accessKeySecret";
            } else if (TextUtils.isEmpty(this.a)) {
                str = "project";
            } else if (TextUtils.isEmpty(this.b)) {
                str = "endPoint";
            } else {
                str = TextUtils.isEmpty(this.c) ? "logStore" : "";
            }
            if (context != null && !TextUtils.isEmpty(str)) {
                throw new RuntimeException("lack of parameter [" + str + "]");
            }
            if (context != null) {
                this.j = "";
            }
            if (context != null) {
                this.k = com.tapsdk.tapad.internal.tracker.experiment.j.b.d(context);
            }
            if (context != null) {
                this.l = context.getFilesDir() + "/" + strA;
            }
            if (context != null) {
                this.m = context.getPackageName();
            }
            if (context != null) {
                this.n = com.tapsdk.tapad.internal.tracker.experiment.j.b.f(context);
            }
            if (context != null) {
                this.o = com.tapsdk.tapad.internal.tracker.experiment.j.b.h();
            }
            if (context != null) {
                this.p = com.tapsdk.tapad.internal.tracker.experiment.j.f.a(context);
            }
            if (context != null) {
                this.q = com.tapsdk.tapad.internal.tracker.experiment.j.f.c(context);
            }
            return new ExpTdsTrackerConfig(this);
        }

        public b b(int i) {
            this.h = i;
            return this;
        }

        public b b(String str) {
            this.e = str;
            return this;
        }

        public b c(int i) {
            this.g = i;
            return this;
        }

        public b c(String str) {
            this.b = str;
            return this;
        }

        public b d(String str) {
            this.c = str;
            return this;
        }

        public b e(String str) {
            this.a = str;
            return this;
        }

        public b f(String str) {
            this.i = str;
            return this;
        }
    }

    private ExpTdsTrackerConfig() {
        this.a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = 0;
        this.g = "";
        this.h = new HashMap();
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = "";
        this.s = "";
        this.t = "";
    }

    protected ExpTdsTrackerConfig(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readInt();
        this.g = parcel.readString();
        HashMap map = new HashMap();
        this.h = map;
        parcel.readMap(map, ExpTdsTrackerConfig.class.getClassLoader());
        this.i = parcel.readString();
        this.j = parcel.readString();
        this.k = parcel.readString();
        this.l = parcel.readString();
        this.m = parcel.readString();
        this.n = parcel.readString();
        this.o = parcel.readString();
        this.p = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readString();
        this.s = parcel.readString();
        this.t = parcel.readString();
    }

    public ExpTdsTrackerConfig(b bVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = bVar.f;
        this.g = g.a(bVar.g);
        HashMap map = new HashMap();
        this.h = map;
        map.put("Android", com.tapsdk.tapad.internal.tracker.experiment.j.b.g());
        if (TextUtils.isEmpty(bVar.i)) {
            this.j = "";
        } else {
            this.j = bVar.i;
        }
        if (bVar.h != -1) {
            this.i = String.valueOf(bVar.h);
        } else {
            this.i = "";
        }
        this.k = com.tapsdk.tapad.internal.tracker.experiment.j.b.g();
        this.l = com.tapsdk.tapad.internal.tracker.experiment.j.b.f();
        this.m = bVar.j;
        this.n = bVar.k;
        this.o = bVar.l;
        this.p = bVar.m;
        this.q = bVar.n;
        this.r = bVar.o;
        this.s = bVar.p;
        this.t = bVar.q;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeMap(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.j);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeString(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        parcel.writeString(this.t);
    }
}
