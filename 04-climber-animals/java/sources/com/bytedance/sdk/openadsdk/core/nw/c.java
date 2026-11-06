package com.bytedance.sdk.openadsdk.core.nw;

import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    private String ab;
    private String ah;
    private String c;
    private String ch;
    private String d;
    private String hi;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f3037ms;
    private JSONArray ny;
    private float sl;
    private HashMap<String, String> u = new HashMap<>();
    private String x;
    private String xr;
    private JSONArray zb;

    public void ms(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.u.put(str, str2);
    }

    public HashMap<String, String> ms() {
        return this.u;
    }

    public String xr() {
        return this.ka;
    }

    public void ms(String str) {
        this.ka = str;
    }

    public float ah() {
        return this.sl;
    }

    public void ms(float f) {
        this.sl = f;
    }

    public JSONArray d() {
        return this.zb;
    }

    public void ms(JSONArray jSONArray) {
        this.zb = jSONArray;
    }

    public String ka() {
        return this.f3037ms;
    }

    public void xr(String str) {
        this.f3037ms = str;
    }

    public String c() {
        return this.xr;
    }

    public void ah(String str) {
        this.xr = str;
    }

    public String ab() {
        return this.ah;
    }

    public void d(String str) {
        this.ah = str;
    }

    public String x() {
        return this.d;
    }

    public void ka(String str) {
        this.d = str;
    }

    public String ny() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public String ch() {
        return this.ab;
    }

    public void ab(String str) {
        this.ab = str;
    }

    public String hi() {
        return this.x;
    }

    public void x(String str) {
        this.x = str;
    }

    public JSONArray sl() {
        return this.ny;
    }

    public void xr(JSONArray jSONArray) {
        this.ny = jSONArray;
    }

    public String zb() {
        return this.ch;
    }

    public void ny(String str) {
        this.ch = str;
    }

    public String u() {
        return this.hi;
    }

    public void ch(String str) {
        this.hi = str;
    }
}
