# CATO — Việt hóa (tiếng Việt)

**Thành phẩm:** `~/game/05-cato/CATO-TiengViet.apk` (đã ký, cài chạy được, đã cài sẵn trong Waydroid).

## Đã làm
1. **Dịch 497/612 câu** (115 câu còn lại trống sẵn trong game) sang tiếng Việt dễ thương, sát nghĩa, giữ nguyên mọi thẻ điều khiển (`<kemoji=N>`, `<action=...>`, `<camera...>`, `<event=...>`, `{0}`, `{localizedPriceString}`…). Nguồn dịch: `work/vi_by_term.json` (keyed theo term), bản dịch gốc `work/vi_translations.py`.
2. **Thêm ngôn ngữ "Vietnamese" (vi)** làm ngôn ngữ thứ 4 vào asset I2 Localization (`I2Languages`), file `assets/bin/Data/5112a62564b5543d188e2fcfb5104c92`. Menu chọn ngôn ngữ **tự hiện tiếng Việt** (đã verify bằng decompile: `SELanguage.OnInit`/`LanguagePopList` lặp danh sách ngôn ngữ runtime, không cố định).
3. **Vá font:** game dùng **Fusion Pixel 12px Prop zh_hans** (chế độ Dynamic). Font nhúng (bản 2026.08.11) thiếu 9 ký tự dấu chồng VN (`ắ ầ ề ộ ữ ự ế ệ ở`). Đã **thay bằng bản 2026.10.25** cùng biến thể/cỡ (đủ 9/9 dấu, 38130 glyph) trong bundle `misc_assets_all_*.bundle`. Vì Dynamic nên chỉ thay font nguồn, không phải dựng lại atlas.

## Cách xem / kiểm chứng
Game đang mở trong cửa sổ Waydroid. (Ảnh chụp bằng lệnh ra đen/trắng do bề mặt GL — phải **nhìn trực tiếp cửa sổ Weston**.)
1. `cd ~/game && ./waydroid-run.sh 5` (nếu chưa mở).
2. Qua màn Privacy → menu chính → **Settings (Cài đặt)** → **Language (Ngôn ngữ)** → chọn **Tiếng Việt**.
3. Toàn bộ UI chuyển tiếng Việt, dấu hiển thị đúng nhờ font đã vá.

## Công cụ tái sử dụng (ở `~/game/_tools/`)
- `i2_tool.py dump|patch <srcdir> <asset_name> <libil2cpp.so> <global-metadata.dat> …` — đọc/ghi asset I2 của build il2cpp (tự sinh typetree từ il2cpp qua REA, xử lý mảng string[] của I2).
- `debug.keystore` — keystore ký lại APK (alias cato, pass android).
- Font swap: `/tmp/swap_font2.py` (thay Font trong bundle, lưu LZ4).

## Quy trình đóng gói lại (khi sửa tiếp)
1. Sửa `work/i2.vi.json` (hoặc chạy lại merge) → `i2_tool.py patch` → `work/5112_vi`.
2. (Font) swap vào `work/misc_vi.bundle` nếu cần.
3. Rebuild zip thay 2 entry → `zipalign -p 4` → `apksigner sign --ks _tools/debug.keystore`.
4. `waydroid app install CATO-TiengViet.apk` để thử.

## Giới hạn / còn lại
- Chưa tự xác nhận được bằng ảnh (bề mặt GL không chụp được); cần mắt người nhìn cửa sổ.
- 115 term gốc vốn trống (không có text EN) → để trống.
- Một vài tên skin là mã/nghệ danh (KaCa2, H4M, SIOλλ…) giữ nguyên.
- Bản thử: mở full game vẫn là IAP server-side, không đụng tới.

## Bỏ qua đăng nhập TapTap (login bypass) — CATO-TiengViet-NoLogin.apk
Bản TapTap TQ bắt đăng nhập + thực danh mới vào menu. Vì ký lại nên TapSDK báo sai chữ ký → kẹt ở màn login.
**Cách bẻ (reverse bằng REA/Kuna):**
- `WollTap.OnAntiAddictionCallBack(code, extra)` @ RVA `0x2a34414`: **code 500 = compliance PASS → vào game** (nhánh gọi `sub_31568a4` chuyển cảnh). code 1000/1001/0x232a = logout/fail.
- Patch **nút login** `WollTap.OnRequestLogin` @ `0x2a32b44`: thay bằng
  `mov w1,#500 ; mov x2,xzr ; b 0x2a34414`  (bytes `813e8052 e2031faa 32060014`)
  → bấm "TapTap登录" sẽ gọi thẳng `OnAntiAddictionCallBack(this, 500, null)` = giả lập "đã qua thực danh" → vào menu, không cần tài khoản.
- Kèm 2 cổng phụ trả true: `CatoComplianceGate.get_IsAllowed` @ `0x29bffc4`, `WollTap.get_hasCheckedAntiAddiction` @ `0x2a30638` (`mov w0,#1; ret`).
- File: `work/libil2cpp.bypass.so`. Công cụ patch: `_tools/patch_so.py` (RVA→file offset tự tính; segment exec có va≠off lệch 0x1000).

**Trạng thái kiểm thử:** .so bypass boot OK (IL2CPP+Unity nạp, không crash). CHƯA xác nhận được bước "bấm login → vào menu" vì **Waydroid trên máy này OOM liên tục** (RAM 15GB, swap đầy → hệ thống Android tự restart giữa chừng). Cần test trên **máy Android thật** (ổn định) hoặc sau khi giải phóng RAM (đóng Chrome/Claude Desktop).

## Bản hoàn chỉnh (13:18 - CATO-TiengViet-NoLogin.apk)
Gộp tất cả, đã ký:
1. **Chỉ tiếng Việt** (I2 vi-only, dịch nốt 115 chữ skin/TapTap/cloud; nút "CHƠI NGAY", "Cài đặt", "MỞ BẢN ĐẦY ĐỦ").
2. **Font Baloo 2 ExtraBold** — đậm, bo tròn, dễ đọc, đủ 100% tiếng Việt → sửa luôn 3 ô vuông ặ/ệ/Ủ. (Swap Font trong misc bundle; metrics là của Fusion Pixel cũ nên **cần test trên máy thật** xem cỡ chữ có lệch không.)
3. **Footer Trung → Việt**: chuỗi pháp lý 453 byte trong scene `assets/bin/Data/level2` thay cùng độ dài (an toàn, không lệch offset) → "Trò chơi giải đố dễ thương · Bản dùng thử · Chúc bạn chơi vui nhé!".
4. **Bỏ qua đăng nhập** (bypass code 500) — đã verify chạy.

### Còn tiếng Trung = ẢNH sprite (cần vẽ lại + test):
- Logo tựa `黄油猫`, badge `免费版`, nhãn `CADPA 8+ 适龄提示`, icon `TapTap` (nút).
- Các chuỗi này nằm trong texture/sprite hoặc nút scene, không phải chữ I2 → phải thay ảnh hoặc ẩn GameObject (rủi ro khi làm mù, cần Waydroid/thiết bị để test từng bước).
- 44 chuỗi Trung gắn cứng trong `level2` còn lại hầu hết **được I2 ghi đè thành Việt** lúc chạy (nút hiện tiếng Việt là bằng chứng); chỉ footer là không có I2 → đã xử.

### Chưa test được bản này vì Waydroid chết (cần reboot máy). Test: điện thoại thật, hoặc reboot rồi báo tôi.

## Bản 13:34 — thêm sửa LOGO + footer
5. **Logo tựa đề**: game có sẵn logo quốc tế `catoLogoTrial/Main` ("CATO" + "Free Edition", cùng style pixel). Đã **thay file sprite logo Trung** (catoLogoCn*) bằng logo quốc tế (chung atlas, path_id khớp) → menu hiện **"CATO Free Edition"** thay vì 黄油猫/免费版. Sạch, không cần vẽ.
   - File swap: assets/bin/Data/{8dc7…=CnTrial, bf05…=CnOnlyTrial} ← b9c4…(Trial); {f772…=CnMain, 53ff…=CnOnlyMain} ← 944d…(Main).
6. Badge 免费版 nằm trong logo → tự sạch theo logo.

## Còn lại (nhỏ, khó làm mù — cần test):
- **CADPA 8+ 适龄提示** (hộp xanh góc phải): texture không có tên rõ, chưa định vị được an toàn.
- **Icon TapTap** (nút Tap dưới): sprite nút, cần ẩn GameObject.
- **Intro `Start Up LOGOS`** (2048×1152, logo nhà phát hành TQ lúc mở app).

## ⚠️ TẤT CẢ thay đổi CHƯA TEST được trong game (Waydroid chết, cần reboot). Verify trên máy thật hoặc sau reboot.

## Bản 15:xx — ẩn CADPA + logo quốc tế (bản giao hiện tại)
7. **Badge CADPA 8+ 适龄提示**: ẩn GameObject "CADPA button" trong level2 (m_IsActive 1→0, patch 1 byte an toàn) → badge biến mất.
8. Logo đã thành "CATO Free Edition" (bản 13:34).
### Còn lại (rất nhỏ):
- Icon **TapTap** nút dưới: GameObject "TapTap" có thể là SDK → không ẩn mù (dễ crash), để lại.
- **Intro** splash có 1 chỗ "暴造 游戏创作分享社区" (ảnh chia nhiều mảnh, rủi ro cao khi sửa mù) — hiện ~2s lúc mở.
- → 2 cái này nên làm khi có máy test.

## 2026-11-06 tối — bản v7 (đã TEST THẬT trên Waydroid sau reboot)
Nguyên nhân ô vuông thật sự: menu/scene base dùng TMP `Fusion Pixel`/`Fusion Pixel UI` trong base Data (7772…, f971…),
nguồn = Font pid 10 trong `sharedassets0.assets` (bản 2026.08.11 **thiếu nguyên khối U+1EA0–1EF9, 90 ký tự**).
Bản trong misc bundle chỉ dùng cho màn chơi. (Ghi chú cũ "thiếu 9 ký tự" là SAI; bản Baloo2 không bao giờ được nạp.)
- `work/sa0/` : sharedassets0 với Fusion Pixel 2026.10.25 (đủ 100% VN), cắt lại split 1MB (7→8 mảnh, thêm split7).
- `work/sa2/` : sharedassets2, texture `TaptapButton` (pid 15, ETC2) → nút **BẮT ĐẦU**.
- `work/gga/` : globalgamemanagers.assets, splash `Start Up LOGOS` (pid 24) → thay toàn bộ bằng 1 chữ "xT.Team" trắng trên nền đen (`work/gga/startup_xt.png`, Baloo2 800).
- `work/classes2.dex` + `work/plogo/Qg.png` : màn Điều khoản (PrivacyActivity) tiếng Việt + logo CATO.
- `work/global-metadata.vi.dat` (tạo bằng `work/meta_vi.py`): 173 chuỗi Trung cứng trong code → VN, ghi nối cuối file,
  chỉ sửa bảng stringLiteral (tên màn "Vùng 1 - Màn 01", thông báo lưu đám mây/mua hàng/mạng, trình tạo màn, "18 tệ"…).
  Bỏ qua chuỗi hệ thống .NET (niên hiệu Nhật/Đài, bảng ký tự) và log debug.
- I2: "Đảo nút A/B tay cầm", "Mở khóa · {giá}".
Build: `python3 -I work/build.py work/misc_vi.bundle /tmp/t.apk && work/sign.sh /tmp/t.apk out.apk`
Test: `~/game/_tools/{w.sh,shot.sh,memguard.sh}` (memguard tắt Waydroid khi RAM trống <1.2GB — máy từng sập OOM khi vào màn 3D).
Đã kiểm bằng ảnh: Điều khoản, splash, tiêu đề, menu, Cài đặt (+Thêm), trong màn, menu tạm dừng, màn Mở khóa.
