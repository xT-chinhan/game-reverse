# 04 — Climber Animals (攀爬动物)  `com.dodofast.climberanimals` v9.0.0

## Engine
**Unity IL2CPP (2022.3.62f2) + HybridCLR hot-update + Addressables**. arm64-v8a. APK 626MB.
Game **nhiều người chơi** (networking **Mirror** + Telepathy/kcp2k/SimpleWebTransport/Edgegap relay + **PlayFab** backend). TapSDK (Core/Login/Compliance/Review).

## ⚠️ Khác biệt lớn: code game nằm trong DLL mã hoá (HybridCLR)
- il2cpp side **KHÔNG có `Assembly-CSharp.dll`** — chỉ có AOT + `HybridCLR.Runtime`, `__Generated`. Xem `out/NO-Assembly-CSharp.txt`.
- Code game thật = DLL **cập nhật nóng** nằm trong `assets/aa/Android/hybridclrlocal_assets_all_*.bundle`. Đã trích ra `hotupdate-dll/` (UnityPy):
  - `Assembly-CSharp.dll.bytes` (1.37MB) = **ĐÃ MÃ HOÁ** (header `88 e7 7a 59…`, không phải MZ). Đây là logic game chính.
  - 100+ file `AOT-*.dll` = DLL phụ trợ AOT (ILSpy đọc được nhưng **thân hàm bị rỗng** `throw null` — chỉ metadata).
- Muốn đọc code game → phải **giải mã `Assembly-CSharp.dll.bytes`** trước. Hai hướng:
  1. Tìm hàm giải mã trong libil2cpp (hook load HybridCLR / `Unity.UOS.Encrypt`) → giải offline.
  2. Dump DLL đã giải mã từ RAM lúc chạy (Frida, cần Android ARM).

## 🔑 Thuật toán mã hoá (đã moi từ libil2cpp bằng REA/Kuna)
`Unity.UOS.Encrypt.EncryptManager` (dùng cho save/chuỗi; RVA trong `out/script.json`):
- `Decrypt` @ `0x3514d50`, `Encrypt` @ `0x35153f4`, key @ `0x3515318`.
- **AES‑128‑CBC/PKCS7**. Khóa = **PBKDF2 (Rfc2898DeriveBytes)**: mật khẩu = `EncryptKey.m_EncryptKey`, **salt = `"202401121404"`**, **1000 vòng**, 16 byte. IV = mảng 16 byte hằng (`<PrivateImplementationDetails>`). Ciphertext base64.
- Lấy nốt mật khẩu `m_EncryptKey` + IV: decompile `EncryptKey..cctor` / đọc mảng static (Kuna tại RVA) — còn lại một bước.
- ⚠️ DLL hot-update có thể dùng scheme riêng (bytes không khớp AES-CBC+base64 ở trên); cần kiểm thêm hàm load.

## Dump (REA inspect_il2cpp_metadata) — phần AOT
- 110 assembly, 19.112 type, 152.457 method (138.849 RVA), 26.660 string literal.
- `evidence.json` (247MB, tích luỹ cả phiên — dùng SHA để lọc, xem _tools). `out/`: `dump.cs`, `script.json`, `strings.txt`.
- Java (jadx): `java/sources/` (14.926 class).
- AOT DLL đã ILSpy mẫu: `cs-aot/` (UOS.Encrypt/Common, animalsdemo, Project.RuntimeInput — thân rỗng, chỉ tham khảo API).

## Việt hóa — dùng Unity Localization
- Hệ **Unity Localization** (Addressables). 10 ngôn ngữ: zh-Hans, en, fr, de, ja, ko, pl, pt-BR, ru, es — **CHƯA có tiếng Việt**.
- Bảng chữ đã trích `localization/`: `GameTable_*` + `ChineseOnly_*` (zh-Hans 225 mục + en). Format StringTable: `{m_Id, m_Localized}`.
- Thêm tiếng Việt: tạo `GameTable_vi` + `ChineseOnly_vi` (cùng `m_Id`, dịch `m_Localized`), thêm Locale `vi`, đóng lại bundle Addressables. **Hoặc** dịch thẳng trong hot-update DLL sau khi giải mã (nếu text hard-code).
- Font: cần kiểm bundle font TMP có glyph tiếng Việt chưa (10 ngôn ngữ Latinh có dấu → nhiều khả năng đã đủ dấu Việt).

## Trạng thái
Reverse xong phần AOT + đã moi thuật toán mã hoá + trích DLL/bảng dịch. Còn 1 bước: giải mã hot-update DLL để xem logic game. Chưa sửa gì.
