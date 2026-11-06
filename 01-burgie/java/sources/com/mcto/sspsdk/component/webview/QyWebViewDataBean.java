package com.mcto.sspsdk.component.webview;

import android.os.Parcel;
import android.os.Parcelable;
import com.mcto.sspsdk.internal.j;
import com.mcto.sspsdk.internal.p;
import com.mcto.sspsdk.internal.rd;

/* JADX INFO: loaded from: classes2.dex */
public class QyWebViewDataBean implements Parcelable {
    public static final Parcelable.Creator<QyWebViewDataBean> CREATOR = new a();
    private boolean a;
    private boolean b;
    private boolean c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private int m;
    private boolean n;

    public QyWebViewDataBean() {
        this.a = true;
        this.b = true;
        this.c = false;
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.n = false;
    }

    public final String a() {
        return this.g;
    }

    public final String b() {
        return this.h;
    }

    public final String c() {
        return this.i;
    }

    public final String d() {
        return this.j;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f;
    }

    public final String f() {
        return this.e;
    }

    public final String g() {
        return this.l;
    }

    public final String h() {
        return this.k;
    }

    public final boolean i() {
        return this.c;
    }

    public final String j() {
        return this.d;
    }

    public final int k() {
        return this.m;
    }

    public final boolean l() {
        return this.a;
    }

    public final boolean m() {
        return this.n;
    }

    public final boolean n() {
        return this.b;
    }

    public final void o() {
        this.a = false;
    }

    public final void p() {
        this.n = true;
    }

    public final void q() {
        this.c = false;
    }

    public final void r() {
        this.b = false;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a ? 1 : 0);
        parcel.writeInt(this.c ? 1 : 0);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeString(this.i);
        parcel.writeString(this.k);
        parcel.writeString(this.l);
        parcel.writeString(this.j);
        parcel.writeInt(this.m);
        parcel.writeInt(this.n ? 1 : 0);
    }

    public final void a(String str) {
        this.k = str;
    }

    public static QyWebViewDataBean a(String str, p pVar) {
        QyWebViewDataBean qyWebViewDataBean = new QyWebViewDataBean();
        qyWebViewDataBean.k = str;
        qyWebViewDataBean.a = true;
        if (j.b(3, pVar.S0)) {
            qyWebViewDataBean.c = !rd.a() && pVar.d0;
            qyWebViewDataBean.f = pVar.E;
            qyWebViewDataBean.b = true;
        }
        qyWebViewDataBean.l = pVar.z;
        qyWebViewDataBean.e = pVar.D;
        qyWebViewDataBean.d = pVar.d();
        qyWebViewDataBean.i = pVar.P;
        qyWebViewDataBean.h = pVar.Q;
        qyWebViewDataBean.g = pVar.i().optString("apkName");
        qyWebViewDataBean.j = pVar.i().optString("deeplink");
        qyWebViewDataBean.m = pVar.p0;
        return qyWebViewDataBean;
    }

    protected QyWebViewDataBean(Parcel parcel) {
        boolean z;
        boolean z2;
        this.a = true;
        this.b = true;
        this.c = false;
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.n = false;
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.a = z;
        if (parcel.readInt() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.c = z2;
        this.d = parcel.readString();
        this.e = parcel.readString();
        this.f = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        this.i = parcel.readString();
        this.k = parcel.readString();
        this.l = parcel.readString();
        this.j = parcel.readString();
        this.m = parcel.readInt();
        this.n = parcel.readInt() == 1;
    }
}
