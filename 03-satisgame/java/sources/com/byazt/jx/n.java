package com.byazt.jx;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.ud.UGTextView;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 508, 19})
public class n extends com.byazt.ud.qg {
    public String dm;
    public String o;
    public String vo;

    public n(Context context) {
        super(context);
    }

    @Override // com.byazt.ud.qg, com.byazt.ih.s
    public void qg() {
        super.qg();
        if (TextUtils.isEmpty(this.o) || TextUtils.equals(this.o, AbstractJsonLexerKt.NULL)) {
            this.o = "";
        }
        if (TextUtils.isEmpty(this.vo) || TextUtils.equals(this.vo, AbstractJsonLexerKt.NULL)) {
            this.vo = "";
        }
        this.n = "";
        d(this.n);
        ((UGTextView) this.l).setGravity(17);
    }

    public void n(int i, int i2, int i3) {
        if (i <= 0 && !TextUtils.isEmpty(this.dm)) {
            this.n = this.dm;
            d(this.n);
            return;
        }
        if (TextUtils.isEmpty(this.o) || TextUtils.equals(this.o, AbstractJsonLexerKt.NULL)) {
            this.o = "";
        }
        if (TextUtils.isEmpty(this.vo) || TextUtils.equals(this.vo, AbstractJsonLexerKt.NULL)) {
            this.vo = "";
        }
        this.n = this.vo + i + this.o;
        d(this.n);
    }

    public void d(String str) {
        ((UGTextView) this.l).setText(str);
        try {
            float fMeasureText = ((UGTextView) this.l).getPaint().measureText(str);
            if (fMeasureText >= 0.0f) {
                q((int) fMeasureText);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.ud.qg, com.byazt.ih.s
    public void n(String str, String str2) {
        super.n(str, str2);
        str.hashCode();
        switch (str) {
            case "before":
                this.vo = str2;
                break;
            case "finish":
                this.dm = str2;
                break;
            case "after":
                this.o = str2;
                break;
        }
    }
}
