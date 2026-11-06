package com.byazt.ur;

import android.util.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1088, 29})
public class cp {
    public com.byazt.ccr.qg l;
    public com.byazt.ccr.n n;
    public com.byazt.ccr.qg q;
    public com.byazt.ccr.qg qg;
    public com.byazt.ccr.qg s;

    public tj n(JsonReader jsonReader, com.byazt.pp.w wVar) throws IOException {
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("ef")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    qg(jsonReader, wVar);
                }
                jsonReader.endArray();
            } else {
                jsonReader.skipValue();
            }
        }
        if (this.n == null || this.qg == null || this.s == null || this.q == null || this.l == null) {
            return null;
        }
        return new tj(this.n, this.qg, this.s, this.q, this.l);
    }

    private void qg(JsonReader jsonReader, com.byazt.pp.w wVar) throws IOException {
        jsonReader.beginObject();
        String strNextString = "";
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            if (strNextName.equals("v")) {
                strNextString.hashCode();
                switch (strNextString) {
                    case "Distance":
                        this.q = q.n(jsonReader, wVar);
                        break;
                    case "Opacity":
                        this.qg = q.n(jsonReader, wVar, false);
                        break;
                    case "Direction":
                        this.s = q.n(jsonReader, wVar, false);
                        break;
                    case "Shadow Color":
                        this.n = q.x(jsonReader, wVar);
                        break;
                    case "Softness":
                        this.l = q.n(jsonReader, wVar);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            } else if (strNextName.equals("nm")) {
                strNextString = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
    }
}
