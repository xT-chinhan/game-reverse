package com.anythink.core.common.m.a.a;

import com.anythink.core.common.m.a.k;
import com.anythink.core.common.n.b.ag;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes.dex */
public final class f extends k {
    private final ag a;

    public f(ag agVar) {
        this.a = agVar;
    }

    @Override // com.anythink.core.common.m.a.k
    public final long a() {
        ag agVar = this.a;
        if (agVar != null) {
            return agVar.b();
        }
        return 0L;
    }

    private InputStream d() {
        ag agVar = this.a;
        if (agVar != null) {
            return agVar.c().i();
        }
        return null;
    }

    @Override // com.anythink.core.common.m.a.k
    public final String b() {
        try {
            ag agVar = this.a;
            return agVar != null ? agVar.d() : null;
        } finally {
            ag agVar2 = this.a;
            if (agVar2 != null) {
                agVar2.close();
            }
        }
    }

    @Override // com.anythink.core.common.m.a.k
    public final String c() {
        try {
            StringBuilder sb = new StringBuilder();
            ag agVar = this.a;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(agVar != null ? agVar.c().i() : null));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
                sb.append('\n');
            }
            return sb.toString();
        } finally {
            ag agVar2 = this.a;
            if (agVar2 != null) {
                agVar2.close();
            }
        }
    }
}
