package com.byazt.ox;

import android.util.Base64;
import com.bumptech.glide.load.Key;
import com.byazt.cr.hn;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1739, 37})
public class pr implements hn {
    @Override // com.byazt.cr.hn
    public String pr(String str) {
        return Base64.encodeToString(str.toString().getBytes(Charset.forName(Key.STRING_CHARSET_NAME)), 0);
    }

    @Override // com.byazt.cr.hn
    public String hw(String str) {
        return new String(Base64.decode(str.toString().getBytes(Charset.forName(Key.STRING_CHARSET_NAME)), 0), Charset.forName(Key.STRING_CHARSET_NAME));
    }

    @Override // com.byazt.cr.hn
    public int pr() {
        return 32;
    }
}
