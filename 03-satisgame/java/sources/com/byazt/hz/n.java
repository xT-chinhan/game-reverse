package com.byazt.hz;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.byazt.jm.qg;
import com.byazt.tk.sz;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 2059, 19})
public class n extends com.byazt.kk.n {
    public n(Context context) {
        super(context);
    }

    @Override // com.byazt.kk.n
    public String d(String str) {
        str.hashCode();
        switch (str) {
            case "unmuted":
                return "tt_ugen_unmuted";
            case "back":
                return "tt_ugen_back";
            case "logo":
                return "tt_ugen_logo";
            case "close":
                return "tt_ugen_close";
            case "muted":
                return "tt_ugen_muted";
            default:
                return "";
        }
    }

    @Override // com.byazt.jm.s
    public void n(final ImageView imageView, String str) {
        sz.n(this.qg, str, new com.byazt.qyj.n<Bitmap>() { // from class: com.byazt.hz.n.1
            @Override // com.byazt.qyj.n
            public void n(Bitmap bitmap) {
                imageView.setImageDrawable(qg.n(bitmap));
            }
        }, 160);
    }
}
