package com.byazt.fm;

import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.byazt.nzn.fw;
import com.byazt.nzn.g;
import com.byazt.nzn.k;
import com.byazt.nzn.nt;
import com.byazt.nzn.uc;
import com.byazt.nzn.yb;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VIDEO_TIMESTAMP_MONOTONIC, 13})
public class hw extends hn {
    public boolean aj;
    public Map<String, String> vk;
    public com.byazt.nzn.pr zo;
    public static final com.byazt.nzn.pr pr = new com.byazt.nzn.pr.C0150pr().pr().hw();
    public static final com.byazt.nzn.pr hw = new com.byazt.nzn.pr.C0150pr().hw();

    public hw(k kVar) {
        super(kVar);
        this.zo = pr;
        this.aj = false;
        this.vk = new HashMap();
    }

    public void pr(String str, String str2) {
        if (str == null) {
            return;
        }
        this.vk.put(str, str2);
    }

    @Override // com.byazt.fm.hn
    public void pr(final com.byazt.elv.pr prVar) {
        try {
            g.pr prVar2 = new g.pr();
            if (this.aj) {
                prVar2.pr(this.uc);
            } else {
                fw.pr prVar3 = new fw.pr();
                Uri uri = Uri.parse(this.uc);
                prVar3.pr(uri.getScheme());
                prVar3.hw(uri.getHost());
                String encodedPath = uri.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith("/")) {
                        encodedPath = encodedPath.substring(1);
                    }
                    prVar3.hn(encodedPath);
                }
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.vk.put(str, uri.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.vk.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String strEncode = URLEncoder.encode(key, Key.STRING_CHARSET_NAME);
                        if (value == null) {
                            value = "";
                        }
                        prVar3.pr(strEncode, URLEncoder.encode(value, Key.STRING_CHARSET_NAME));
                    }
                }
                prVar2.pr(prVar3.hw());
            }
            pr(prVar2);
            prVar2.pr(this.zo);
            prVar2.pr((Object) hw());
            this.hn.pr(prVar2.pr().hw()).pr(new com.byazt.nzn.hn() { // from class: com.byazt.fm.hw.1
                @Override // com.byazt.nzn.hn
                public void onFailure(com.byazt.nzn.hw hwVar, IOException iOException) {
                    com.byazt.elv.pr prVar4 = prVar;
                    if (prVar4 != null) {
                        prVar4.pr(hw.this, iOException);
                    }
                }

                @Override // com.byazt.nzn.hn
                public void onResponse(com.byazt.nzn.hw hwVar, nt ntVar) throws IOException {
                    if (prVar != null) {
                        HashMap map = new HashMap();
                        if (ntVar != null) {
                            prVar.pr(hw.this, hw.this.pr(ntVar, map));
                        }
                    }
                }
            });
        } catch (Throwable th) {
            if (prVar != null) {
                prVar.pr(this, new IOException(th.getMessage()));
            }
        }
    }

    @Override // com.byazt.fm.hn
    public com.byazt.tf.x pr() {
        try {
            g.pr prVar = new g.pr();
            if (this.aj) {
                prVar.pr(this.uc);
            } else {
                fw.pr prVar2 = new fw.pr();
                Uri uri = Uri.parse(this.uc);
                prVar2.pr(uri.getScheme());
                prVar2.hw(uri.getHost());
                String encodedPath = uri.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith("/")) {
                        encodedPath = encodedPath.substring(1);
                    }
                    prVar2.hn(encodedPath);
                }
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.vk.put(str, uri.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.vk.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String strEncode = URLEncoder.encode(key, Key.STRING_CHARSET_NAME);
                        if (value == null) {
                            value = "";
                        }
                        prVar2.pr(strEncode, URLEncoder.encode(value, Key.STRING_CHARSET_NAME));
                    }
                }
                prVar.pr(prVar2.hw());
            }
            pr(prVar);
            prVar.pr(this.zo);
            prVar.pr((Object) hw());
            nt ntVarHw = this.hn.pr(prVar.pr().hw()).hw();
            if (ntVarHw != null) {
                return pr(ntVarHw, new HashMap());
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.tf.x pr(nt ntVar, Map<String, String> map) throws IOException {
        uc ucVarFw = ntVar.fw();
        if (ucVarFw != null) {
            int iPr = ucVarFw.pr();
            for (int i = 0; i < iPr; i++) {
                String strPr = ucVarFw.pr(i);
                String strHw = ucVarFw.hw(i);
                map.put(strPr, strHw);
                if (strPr != null && strPr.equalsIgnoreCase("content-type")) {
                    map.put("content-type", strHw == null ? "" : strHw.toLowerCase());
                }
            }
        }
        yb ybVarUc = ntVar.uc();
        if (!this.fw && !com.byazt.am.pr.pr(map)) {
            return new com.byazt.tf.x(ntVar.x(), ntVar.hn(), ntVar.c(), map, ybVarUc != null ? ybVarUc.hw() : "", ntVar.hw(), ntVar.pr());
        }
        byte[] bArrX = ybVarUc == null ? new byte[0] : ybVarUc.x();
        com.byazt.tf.x xVar = new com.byazt.tf.x(ntVar.x(), ntVar.hn(), ntVar.c(), map, null, ntVar.hw(), ntVar.pr());
        xVar.pr(bArrX);
        return xVar;
    }
}
