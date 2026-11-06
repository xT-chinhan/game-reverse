package com.byazt.jv;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ho {
    public static final ho pr = new ho() { // from class: com.byazt.jv.ho.1
        @Override // com.byazt.jv.ho
        public List<InetAddress> pr(String str) throws UnknownHostException {
            if (str == null) {
                throw new UnknownHostException("hostname == null");
            }
            try {
                return Arrays.asList(InetAddress.getAllByName(str));
            } catch (Throwable th) {
                return new ArrayList();
            }
        }
    };

    List<InetAddress> pr(String str) throws UnknownHostException;
}
