package com.bykv.vk.openvk.component.video.api.ah;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d implements Serializable {
    private int ab;
    private long ao;
    private String c;
    private ah d;
    private boolean h;
    private String hi;
    private ah ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public String f16ms;
    private boolean qv;
    private int sl;
    private int t;
    private List<String> u;
    private String ub;
    public int xr;
    private int y;
    private int zb;
    private int x = 204800;
    private int ny = 0;
    private int ch = 0;
    public final HashMap<String, Object> ah = new HashMap<>();
    private int nw = 10000;
    private int b = 10000;
    private int re = 10000;
    private int i = 0;
    private JSONObject w = new JSONObject();

    public d(String str, ah ahVar, ah ahVar2, int i, int i2) {
        this.y = 0;
        this.t = 0;
        this.c = str;
        this.d = ahVar;
        this.ka = ahVar2;
        this.y = i;
        this.t = i2;
    }

    public JSONObject ms() {
        return this.w;
    }

    public int xr() {
        return this.w.optInt("pitaya_cache_size", 0);
    }

    public int ah() {
        return this.w.optInt("pitaya_code", 0);
    }

    public String d() {
        return this.w.optString("pitaya_msg");
    }

    public String ka() {
        return this.c;
    }

    public void ms(String str) {
        this.c = str;
    }

    public void ms(int i) {
        this.ab = i;
    }

    public int c() {
        if (u()) {
            return this.ka.ao();
        }
        ah ahVar = this.d;
        if (ahVar != null) {
            return ahVar.ao();
        }
        return 0;
    }

    public boolean ab() {
        return this.qv;
    }

    public void ms(boolean z) {
        this.qv = z;
    }

    public void xr(String str) {
        this.hi = str;
    }

    public int x() {
        return this.sl;
    }

    public void xr(int i) {
        this.sl = i;
    }

    public int ny() {
        return this.zb;
    }

    public void ah(int i) {
        this.zb = i;
    }

    public void ms(List<String> list) {
        this.u = list;
    }

    public void ah(String str) {
        this.ub = str;
    }

    public long ch() {
        return this.ao;
    }

    public void ms(long j) {
        this.ao = j;
    }

    public boolean hi() {
        return this.h;
    }

    public void xr(boolean z) {
        this.h = z;
    }

    public long sl() {
        if (u()) {
            return this.ka.ka();
        }
        ah ahVar = this.d;
        if (ahVar != null) {
            return ahVar.ka();
        }
        return 0L;
    }

    public boolean zb() {
        if (u()) {
            return this.ka.re();
        }
        ah ahVar = this.d;
        if (ahVar != null) {
            return ahVar.re();
        }
        return true;
    }

    public void d(String str) {
        this.f16ms = str;
    }

    public void d(int i) {
        this.xr = i;
    }

    public boolean u() {
        ah ahVar;
        return this.t == 1 && (ahVar = this.ka) != null && !TextUtils.isEmpty(ahVar.sl()) && (com.bykv.vk.openvk.component.video.api.ah.ka() == 2 || this.y == 1);
    }

    public float ub() {
        if (u()) {
            return this.ka.x();
        }
        ah ahVar = this.d;
        if (ahVar != null) {
            return ahVar.x();
        }
        return -1.0f;
    }

    public String ao() {
        if (u()) {
            return this.ka.sl();
        }
        ah ahVar = this.d;
        if (ahVar != null) {
            return ahVar.sl();
        }
        return null;
    }

    public String h() {
        if (u()) {
            return this.ka.ub();
        }
        ah ahVar = this.d;
        if (ahVar != null) {
            return ahVar.ub();
        }
        return null;
    }

    public int qv() {
        return this.y;
    }

    public void ka(int i) {
        this.y = i;
    }

    public synchronized void ms(String str, Object obj) {
        this.ah.put(str, obj);
    }

    public synchronized Object ka(String str) {
        return this.ah.get(str);
    }

    public int y() {
        return this.nw;
    }

    public void c(int i) {
        this.nw = i;
    }

    public int t() {
        return this.b;
    }

    public void ab(int i) {
        this.b = i;
    }

    public int nw() {
        return this.re;
    }

    public void x(int i) {
        this.re = i;
    }

    public int b() {
        return this.i;
    }

    public void ny(int i) {
        this.i = i;
    }

    public ah re() {
        return this.d;
    }

    public ah i() {
        return this.ka;
    }

    public ah w() {
        if (u()) {
            return this.ka;
        }
        ah ahVar = this.d;
        if (ahVar != null) {
            return ahVar;
        }
        return null;
    }
}
