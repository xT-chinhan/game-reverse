package com.ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.content.Context;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.i;
import com.ss.android.socialbase.downloader.depend.of;
import com.ss.android.socialbase.downloader.depend.qv;
import com.ss.android.socialbase.downloader.depend.u;
import com.ss.android.socialbase.downloader.depend.zb;
import com.ss.android.socialbase.downloader.downloader.y;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class c {
    private String ab;
    private String ah;
    private JSONObject am;
    private boolean b;
    private String c;
    private int cv;
    private List<String> d;
    private i e;
    private com.ss.android.socialbase.appdownloader.ah.ka eg;
    private boolean f;
    private IDownloadFileUriProvider fm;
    private boolean g;
    private boolean h;
    private String i;
    private boolean il;
    private boolean jw;
    private u k;
    private String ka;
    private boolean l;
    private int m;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private Activity f4559ms;
    private com.ss.android.socialbase.downloader.notification.ms nw;
    private String of;
    private boolean op;
    private boolean pc;
    private of qf;
    private boolean qk;
    private com.ss.android.socialbase.downloader.downloader.ab qv;
    private boolean re;
    private long s;
    private String sa;
    private int[] sk;
    private y t;
    private int ti;
    private IDownloadListener u;
    private String ub;
    private int v;
    private String vy;
    private String w;
    private List<com.ss.android.socialbase.downloader.model.ah> x;
    private qv xn;
    private Context xr;
    private com.ss.android.socialbase.downloader.downloader.x y;
    private long yu;
    private IDownloadListener zb;
    private String zf;
    private boolean ny = true;
    private boolean ch = false;
    private boolean hi = true;
    private boolean sl = false;
    private String ao = "application/vnd.android.package-archive";
    private int le = 5;
    private boolean p = true;
    private EnqueueType ul = EnqueueType.ENQUEUE_NONE;
    private int az = 150;
    private boolean lm = true;
    private List<zb> tz = new ArrayList();
    private boolean vm = true;
    private boolean rt = true;

    public c(Context context, String str) {
        this.xr = context.getApplicationContext();
        this.ah = str;
    }

    public Activity getActivity() {
        return this.f4559ms;
    }

    public Context getContext() {
        return this.xr;
    }

    public String ms() {
        return this.ah;
    }

    public String xr() {
        return this.ka;
    }

    public String ah() {
        return this.ab;
    }

    public List<com.ss.android.socialbase.downloader.model.ah> d() {
        return this.x;
    }

    public boolean ka() {
        return this.ny;
    }

    public boolean c() {
        return this.ch;
    }

    public boolean ab() {
        return this.hi;
    }

    public boolean x() {
        return this.sl;
    }

    public IDownloadListener ny() {
        return this.zb;
    }

    public IDownloadListener ch() {
        return this.u;
    }

    public String hi() {
        return this.ub;
    }

    public String sl() {
        return this.ao;
    }

    public boolean zb() {
        return this.h;
    }

    public com.ss.android.socialbase.downloader.notification.ms u() {
        return this.nw;
    }

    public com.ss.android.socialbase.downloader.downloader.x ub() {
        return this.y;
    }

    public com.ss.android.socialbase.downloader.downloader.ab ao() {
        return this.qv;
    }

    public boolean h() {
        return this.b;
    }

    public boolean qv() {
        return this.re;
    }

    public int y() {
        return this.v;
    }

    public void ms(int i) {
        this.v = i;
    }

    public String t() {
        return this.i;
    }

    public String nw() {
        return this.w;
    }

    public long b() {
        return this.yu;
    }

    public int re() {
        return this.le;
    }

    public int i() {
        return this.cv;
    }

    public boolean w() {
        return this.g;
    }

    public String yu() {
        return this.of;
    }

    public boolean op() {
        return this.p;
    }

    public boolean le() {
        return this.pc;
    }

    public y cv() {
        return this.t;
    }

    public int g() {
        return this.az;
    }

    public int of() {
        return this.m;
    }

    public boolean p() {
        return this.jw;
    }

    public boolean pc() {
        return this.f;
    }

    public boolean jw() {
        return this.lm;
    }

    public boolean f() {
        return this.il;
    }

    public EnqueueType ul() {
        return this.ul;
    }

    public boolean az() {
        return this.op;
    }

    public String m() {
        return this.c;
    }

    public i lm() {
        return this.e;
    }

    public u e() {
        return this.k;
    }

    public com.ss.android.socialbase.appdownloader.ah.ka k() {
        return this.eg;
    }

    public IDownloadFileUriProvider eg() {
        return this.fm;
    }

    public of fm() {
        return this.qf;
    }

    public List<zb> xn() {
        return this.tz;
    }

    public String il() {
        return this.zf;
    }

    public boolean qf() {
        return this.l;
    }

    public int l() {
        return this.ti;
    }

    public long am() {
        return this.s;
    }

    public boolean sa() {
        return this.rt;
    }

    public String tz() {
        return this.vy;
    }

    public int[] ti() {
        return this.sk;
    }

    public boolean s() {
        return this.qk;
    }

    public boolean v() {
        return this.vm;
    }

    public c ms(String str) {
        this.ka = str;
        return this;
    }

    public c xr(String str) {
        this.c = str;
        return this;
    }

    public c ah(String str) {
        this.ab = str;
        return this;
    }

    public c ms(List<com.ss.android.socialbase.downloader.model.ah> list) {
        this.x = list;
        return this;
    }

    public c ms(boolean z) {
        this.ny = z;
        return this;
    }

    public c d(String str) {
        this.zf = str;
        return this;
    }

    public c xr(boolean z) {
        this.ch = z;
        return this;
    }

    public c ah(boolean z) {
        this.sl = z;
        return this;
    }

    public c ms(IDownloadListener iDownloadListener) {
        this.zb = iDownloadListener;
        return this;
    }

    public c ka(String str) {
        this.ub = str;
        return this;
    }

    public c c(String str) {
        this.ao = str;
        return this;
    }

    public c d(boolean z) {
        this.h = z;
        return this;
    }

    public c ka(boolean z) {
        this.b = z;
        return this;
    }

    public c c(boolean z) {
        this.re = z;
        return this;
    }

    public c ab(String str) {
        this.i = str;
        return this;
    }

    public c x(String str) {
        this.w = str;
        return this;
    }

    public c ms(long j) {
        this.yu = j;
        return this;
    }

    public c xr(int i) {
        this.le = i;
        return this;
    }

    public c ah(int i) {
        this.cv = i;
        return this;
    }

    public c ab(boolean z) {
        this.g = z;
        return this;
    }

    public c ny(String str) {
        this.of = str;
        return this;
    }

    public c x(boolean z) {
        this.il = z;
        return this;
    }

    public c ny(boolean z) {
        this.p = z;
        return this;
    }

    public c ch(boolean z) {
        this.pc = z;
        return this;
    }

    public c hi(boolean z) {
        this.jw = z;
        return this;
    }

    public c sl(boolean z) {
        this.f = z;
        return this;
    }

    public c d(int i) {
        this.az = i;
        return this;
    }

    public c ka(int i) {
        this.m = i;
        return this;
    }

    public c zb(boolean z) {
        this.lm = z;
        return this;
    }

    public c ms(EnqueueType enqueueType) {
        this.ul = enqueueType;
        return this;
    }

    public c u(boolean z) {
        this.op = z;
        return this;
    }

    public c ms(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.fm = iDownloadFileUriProvider;
        return this;
    }

    public c ch(String str) {
        this.vy = str;
        return this;
    }

    public c hi(String str) {
        this.sa = str;
        return this;
    }

    public String qk() {
        return this.sa;
    }

    public c c(int i) {
        this.ti = i;
        return this;
    }

    public List<String> vm() {
        return this.d;
    }

    public c xr(List<String> list) {
        this.d = list;
        return this;
    }

    public qv zf() {
        return this.xn;
    }

    public c ms(qv qvVar) {
        this.xn = qvVar;
        return this;
    }

    public JSONObject rt() {
        return this.am;
    }

    public c ms(JSONObject jSONObject) {
        this.am = jSONObject;
        return this;
    }

    public c ms(zb zbVar) {
        synchronized (this.tz) {
            if (zbVar != null) {
                if (!this.tz.contains(zbVar)) {
                    this.tz.add(zbVar);
                    return this;
                }
            }
            return this;
        }
    }

    public c ub(boolean z) {
        this.qk = z;
        return this;
    }

    public c ao(boolean z) {
        this.vm = z;
        return this;
    }
}
