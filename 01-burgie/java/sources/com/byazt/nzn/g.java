package com.byazt.nzn;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.kit.internal.http.TapHttp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public abstract class g {
    public k pr;

    public abstract com.byazt.nzn.pr c();

    public abstract String hn();

    public abstract fw hw();

    public abstract Object pr();

    public abstract Map<String, List<String>> x();

    public ho uc() {
        return null;
    }

    public void pr(k kVar) {
        this.pr = kVar;
    }

    public pr fw() {
        return new pr(this);
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE, MediaPlayer.MEDIA_PLAYER_OPTION_MOOV_POS})
    public static class pr {
        public Object c;
        public uc.pr fw;
        public fw hn;
        public Map<String, List<String>> hw;
        public com.byazt.nzn.pr pr;
        public ho uc;
        public String x;

        public pr() {
            this.hw = new HashMap();
            this.fw = new uc.pr();
        }

        public pr pr(com.byazt.nzn.pr prVar) {
            this.pr = prVar;
            return this;
        }

        public pr(g gVar) {
            this.hn = gVar.hw();
            this.x = gVar.hn();
            this.hw = gVar.x();
            this.c = gVar.pr();
            this.uc = gVar.uc();
            this.pr = gVar.c();
        }

        public pr pr(Object obj) {
            this.c = obj;
            return this;
        }

        public pr pr(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            fw fwVarHn = fw.hn(str);
            if (fwVarHn == null) {
                throw new IllegalArgumentException("unexpected url: ".concat(String.valueOf(str)));
            }
            return pr(fwVarHn);
        }

        public pr pr(fw fwVar) {
            this.hn = fwVar;
            return this;
        }

        public pr pr(String str, String str2) {
            return hw(str, str2);
        }

        public pr pr(uc ucVar) {
            if (ucVar != null) {
                this.hw = ucVar.hw();
            }
            return this;
        }

        public pr hw(String str, String str2) {
            if (!this.hw.containsKey(str)) {
                this.hw.put(str, new ArrayList());
            }
            this.hw.get(str).add(str2);
            return this;
        }

        public pr pr() {
            return pr(TapHttp.METHOD_GET, (ho) null);
        }

        public pr pr(String str, ho hoVar) {
            this.x = str;
            this.uc = hoVar;
            return this;
        }

        public pr pr(ho hoVar) {
            return pr(TapHttp.METHOD_POST, hoVar);
        }

        public g hw() {
            return new g() { // from class: com.byazt.nzn.g.pr.1
                @Override // com.byazt.nzn.g
                public Object pr() {
                    return pr.this.c;
                }

                @Override // com.byazt.nzn.g
                public fw hw() {
                    return pr.this.hn;
                }

                @Override // com.byazt.nzn.g
                public String hn() {
                    return pr.this.x;
                }

                @Override // com.byazt.nzn.g
                public Map x() {
                    return pr.this.hw;
                }

                @Override // com.byazt.nzn.g
                public com.byazt.nzn.pr c() {
                    return pr.this.pr;
                }

                public String toString() {
                    return "";
                }

                @Override // com.byazt.nzn.g
                public ho uc() {
                    return pr.this.uc;
                }
            };
        }
    }
}
