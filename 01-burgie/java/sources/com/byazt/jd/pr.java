package com.byazt.jd;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.id.UGTextView;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 93, 37})
public class pr extends com.byazt.id.hw {
    public String ks;
    public String sr;
    public String wz;

    public pr(Context context) {
        super(context);
    }

    @Override // com.byazt.id.hw, com.byazt.ik.hn
    public void hw() {
        super.hw();
        if (TextUtils.isEmpty(this.wz) || TextUtils.equals(this.wz, AbstractJsonLexerKt.NULL)) {
            this.wz = "";
        }
        if (TextUtils.isEmpty(this.sr) || TextUtils.equals(this.sr, AbstractJsonLexerKt.NULL)) {
            this.sr = "";
        }
        this.pr = "";
        w(this.pr);
        ((UGTextView) this.c).setGravity(17);
    }

    public void pr(int i, int i2, int i3) {
        if (i <= 0 && !TextUtils.isEmpty(this.ks)) {
            this.pr = this.ks;
            w(this.pr);
            return;
        }
        if (TextUtils.isEmpty(this.wz) || TextUtils.equals(this.wz, AbstractJsonLexerKt.NULL)) {
            this.wz = "";
        }
        if (TextUtils.isEmpty(this.sr) || TextUtils.equals(this.sr, AbstractJsonLexerKt.NULL)) {
            this.sr = "";
        }
        this.pr = this.sr + i + this.wz;
        w(this.pr);
    }

    public void w(String str) {
        ((UGTextView) this.c).setText(str);
        try {
            float fMeasureText = ((UGTextView) this.c).getPaint().measureText(str);
            if (fMeasureText >= 0.0f) {
                x((int) fMeasureText);
            }
        } catch (Throwable th) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:14:0x0029  */
    @Override // com.byazt.id.hw, com.byazt.ik.hn
    public void pr(String str, String str2) {
        super.pr(str, str2);
        switch (str) {
            case "before":
                this.sr = str2;
                break;
            case "after":
                this.wz = str2;
                break;
            case "finish":
                this.ks = str2;
                break;
        }
    }
}
