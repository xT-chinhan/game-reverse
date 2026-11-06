package com.tapadn.protobuf;

/* JADX INFO: loaded from: classes3.dex */
interface MutabilityOracle {
    public static final MutabilityOracle IMMUTABLE = new MutabilityOracle() { // from class: com.tapadn.protobuf.MutabilityOracle.1
        @Override // com.tapadn.protobuf.MutabilityOracle
        public void ensureMutable() {
            throw new UnsupportedOperationException();
        }
    };

    void ensureMutable();
}
