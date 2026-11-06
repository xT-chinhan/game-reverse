package com.byazt.pq;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface k {
    public static final k n = new k() { // from class: com.byazt.pq.k.1
        @Override // com.byazt.pq.k
        public List<InetAddress> n(String str) throws UnknownHostException {
            if (str == null) {
                throw new UnknownHostException("hostname == null");
            }
            try {
                return Arrays.asList(InetAddress.getAllByName(str));
            } catch (Throwable unused) {
                return new ArrayList();
            }
        }
    };

    List<InetAddress> n(String str) throws UnknownHostException;
}
