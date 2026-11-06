package com.byazt.yn;

import android.text.TextUtils;
import android.util.Pair;
import com.byazt.hcx.aj;
import com.byazt.hcx.fw;
import com.byazt.hcx.m;
import com.byazt.vkw.ve;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MIN_JITTER_BUFFER, 20})
public class hn implements aj {
    public Map<String, Pair<String, byte[]>> aj;
    public Map<String, String> c;
    public byte[] fw;
    public Map<String, Object> g;
    public int hn;
    public JSONObject ho;
    public final com.byazt.tf.hw hw;
    public fw k;
    public Map<String, String> m;
    public File nt;
    public final ve pr;
    public String uc;
    public Pair<String, byte[]> vk;
    public com.byazt.hcx.pr w;
    public String x;
    public boolean yb;
    public Map<String, String> zo;

    public hn(ve veVar, com.byazt.tf.hw hwVar) {
        this.pr = veVar;
        this.hw = hwVar;
    }

    @Override // com.byazt.hcx.aj
    public aj pr(int i) {
        this.hn = i;
        return this;
    }

    @Override // com.byazt.hcx.aj
    public aj pr(String str) {
        this.x = str;
        return this;
    }

    @Override // com.byazt.hcx.aj
    public aj pr(String str, String str2) {
        if (this.c == null) {
            this.c = new HashMap();
        }
        this.c.put(str, str2);
        return this;
    }

    @Override // com.byazt.hcx.aj
    public aj hw(String str) {
        this.uc = str;
        return this;
    }

    @Override // com.byazt.hcx.aj
    public aj pr(byte[] bArr) {
        this.fw = bArr;
        return this;
    }

    @Override // com.byazt.hcx.aj
    public aj hw(String str, String str2) {
        if (str == null) {
            return this;
        }
        if (this.m == null) {
            this.m = new HashMap();
        }
        this.m.put(str, str2);
        return this;
    }

    @Override // com.byazt.hcx.aj
    public aj hn(String str, String str2) {
        if (this.hn != 2) {
            throw new IllegalArgumentException("Only POST method support multipart body");
        }
        if (this.zo == null) {
            this.zo = new HashMap();
        }
        this.zo.put(str, str2);
        return this;
    }

    @Override // com.byazt.hcx.aj
    public aj pr(String str, String str2, byte[] bArr) {
        if (this.hn != 2) {
            throw new IllegalArgumentException("Only POST method support multipart body");
        }
        if (this.aj == null) {
            this.aj = new HashMap();
        }
        this.aj.put(str2, new Pair<>(str2, bArr));
        return this;
    }

    @Override // com.byazt.hcx.aj
    public aj pr(String str, byte[] bArr) {
        if (this.hn != 2) {
            throw new IllegalArgumentException("Only POST method support multipart body");
        }
        this.vk = new Pair<>(str, bArr);
        return this;
    }

    @Override // com.byazt.hcx.aj
    public aj pr(com.byazt.hcx.pr prVar) {
        this.w = prVar;
        return this;
    }

    private com.byazt.fm.hn uc() {
        com.byazt.fm.hn hnVarFw;
        int i = this.hn;
        if (i == 2) {
            hnVarFw = fw();
        } else if (i == 1) {
            final com.byazt.fm.hw hwVar = new com.byazt.fm.hw(this.hw.pr());
            Map<String, String> map = this.m;
            if (map != null) {
                map.forEach(new BiConsumer<String, String>() { // from class: com.byazt.yn.hn.1
                    @Override // java.util.function.BiConsumer
                    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
                    public void accept(String str, String str2) {
                        hwVar.pr(str, str2);
                    }
                });
            }
            hwVar.pr(this.yb);
            hnVarFw = hwVar;
        } else if (i == 3) {
            com.byazt.fm.pr prVar = new com.byazt.fm.pr(this.hw.pr());
            prVar.pr(this.nt.getParent(), this.nt.getName());
            hnVarFw = prVar;
        } else {
            throw new IllegalArgumentException("method " + this.hn + " is not supported");
        }
        hnVarFw.pr(this.x);
        Map<String, String> map2 = this.c;
        if (map2 != null) {
            hnVarFw.x(map2);
        }
        hnVarFw.c(this.g);
        return hnVarFw;
    }

    private com.byazt.fm.hn fw() {
        com.byazt.fm.x xVar = new com.byazt.fm.x(this.hw.pr());
        pr(xVar);
        return xVar;
    }

    private void pr(com.byazt.fm.x xVar) {
        JSONObject jSONObject = this.ho;
        if (jSONObject != null) {
            xVar.hn(jSONObject.toString());
            return;
        }
        Pair<String, byte[]> pair = this.vk;
        if (pair != null) {
            xVar.pr((String) pair.first, (byte[]) this.vk.second);
            return;
        }
        Map<String, String> map = this.m;
        if (map != null) {
            xVar.pr(map);
            return;
        }
        String str = this.uc;
        if (str != null) {
            xVar.hn(str);
        } else if (this.fw != null) {
            xVar.pr(true);
            xVar.pr("application/octet-stream", this.fw);
        }
    }

    @Override // com.byazt.hcx.aj
    public m pr() {
        return new x(uc().pr());
    }

    @Override // com.byazt.hcx.aj
    public void pr(fw fwVar) {
        this.k = fwVar;
        uc().pr(new com.byazt.elv.pr() { // from class: com.byazt.yn.hn.2
            @Override // com.byazt.elv.pr
            public void pr(com.byazt.fm.hn hnVar, com.byazt.tf.x xVar) {
                if (hn.this.k != null) {
                    hn.this.k.pr(new x(xVar));
                }
            }

            @Override // com.byazt.elv.pr
            public void pr(com.byazt.fm.hn hnVar, IOException iOException) {
                if (hn.this.k != null) {
                    hn.this.k.pr(0, "onFailure", iOException);
                }
            }
        });
    }

    @Override // com.byazt.hcx.aj
    public void hw() {
        com.byazt.fm.hn hnVarUc = uc();
        if (hnVarUc != null) {
            hnVarUc.hn();
        }
    }

    @Override // com.byazt.hcx.aj
    public byte[] hn() {
        if (!TextUtils.isEmpty(this.uc)) {
            return this.uc.getBytes();
        }
        byte[] bArr = this.fw;
        if (bArr != null) {
            return bArr;
        }
        return new byte[0];
    }

    @Override // com.byazt.hcx.aj
    public aj pr(Map<String, Object> map) {
        this.g = map;
        return this;
    }

    @Override // com.byazt.hcx.aj
    public Map<String, Object> x() {
        return this.g;
    }

    @Override // com.byazt.hcx.aj
    public aj pr(JSONObject jSONObject) {
        this.ho = jSONObject;
        return this;
    }

    @Override // com.byazt.hcx.aj
    public aj x(String str, String str2) {
        this.nt = new File(str, str2);
        return this;
    }

    @Override // com.byazt.hcx.aj
    public aj c() {
        this.yb = true;
        return this;
    }
}
