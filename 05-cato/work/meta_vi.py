#!/usr/bin/env python3
"""Vá chuỗi Trung cứng trong global-metadata.dat (il2cpp v31) sang tiếng Việt.

  meta_vi.py <in global-metadata.dat> <out global-metadata.dat>

Chuỗi mới được ghi nối vào cuối file; bảng stringLiteral chỉ đổi (length, dataIndex)
nên không dịch chuyển bất kỳ section nào khác. Mỗi mục kiểm tra chuỗi gốc trước khi vá.
"""
import struct, sys

AGE_NOTICE = (
    "1. Đây là trò chơi giải đố đi cảnh, phù hợp với người chơi từ 8 tuổi trở lên.\n"
    "2. Trò chơi có phong cách hoạt hình dễ thương, cốt truyện nhẹ nhàng, bối cảnh là thế giới tưởng tượng, không gây nhầm lẫn với đời thực.\n"
    "3. Trò chơi có hệ thống xác minh danh tính; người chơi chưa thành niên sẽ chịu các giới hạn sau:\n"
    "    - Trò chơi có nội dung trả phí (mua bản đầy đủ trong ứng dụng). Người dưới 8 tuổi không thể thanh toán; "
    "từ 8 đến dưới 16 tuổi: mỗi lần nạp tối đa 50 NDT, tối đa 200 NDT mỗi tháng; "
    "từ 16 tuổi đến dưới 18 tuổi: mỗi lần nạp tối đa 100 NDT, tối đa 400 NDT mỗi tháng;\n"
    "    - Theo quy định, người chưa thành niên chỉ được chơi từ 20h đến 21h vào thứ Sáu, thứ Bảy, Chủ nhật và ngày lễ.\n"
    "4. Lối chơi giải đố giúp rèn luyện phối hợp tay mắt, khả năng quan sát, trí tưởng tượng và tư duy logic."
)

VI = {
    49:    ("\n\n请求已取消", "\n\nĐã hủy yêu cầu"),
    1324:  ("-关卡", " - Màn "),
    1542:  (None, AGE_NOTICE),
    2357:  ("<size=115%><b>云存档上传成功</b></size>", "<size=115%><b>Tải lưu trữ đám mây lên thành công</b></size>"),
    2358:  ("<size=115%><b>云存档恢复成功</b></size>", "<size=115%><b>Khôi phục lưu trữ đám mây thành công</b></size>"),
    2359:  ("<size=115%><b>云存档（手动）</b></size>", "<size=115%><b>Lưu trữ đám mây (thủ công)</b></size>"),
    9337:  ("QQ群：813119157", "Nhóm QQ: 813119157"),
    10899: ("TapTap 实名认证服务异常", "Dịch vụ xác minh danh tính TapTap gặp lỗi"),
    10900: ("TapTap 实名认证服务暂时无法连接，请稍后重试。\n\n错误码：{0}",
            "Tạm thời không kết nối được dịch vụ xác minh danh tính TapTap, vui lòng thử lại sau.\n\nMã lỗi: {0}"),
    20467: (None, "• Chạm vào mã để sao chép và đồng bộ tiến trình sang thiết bị khác\n"
                  "• Mã này đồng bộ được giữa bản di động và bản máy tính\n"
                  "• Chỉ đồng bộ tiến trình màn chơi và skin đã mở khóa; cài đặt và kỷ lục mini-game không được đồng bộ.\n"
                  "• Mã có thời hạn, đừng dùng làm bản sao lưu!"),
    20525: ("上传存档失败，请重试。", "Tải lưu trữ lên thất bại, vui lòng thử lại."),
    20526: ("上传过于频繁，请稍后重试。", "Tải lên quá thường xuyên, vui lòng thử lại sau."),
    20527: ("上报 BUG", "Báo lỗi"),
    20528: ("不支持的存档口令格式：{0}", "Định dạng mã lưu trữ không được hỗ trợ: {0}"),
    20529: ("世界", "Vùng "),
    20532: ("主线", "Cốt truyện chính"),
    20533: ("云存档中没有可恢复的槽位。", "Lưu trữ đám mây không có ô nào để khôi phục."),
    20534: ("云存档格式不兼容。", "Định dạng lưu trữ đám mây không tương thích."),
    20535: ("云存档需要在 TapTap 支持平台运行。", "Lưu trữ đám mây cần chạy trên nền tảng hỗ trợ TapTap."),
    20536: ("云端存档更新时间：{cloudUpdateTime}", "Lưu trữ đám mây cập nhật lúc: {cloudUpdateTime}"),
    20538: ("今天的可玩时长已经用尽，暂时无法继续游戏。", "Hôm nay đã hết thời gian chơi, tạm thời không thể chơi tiếp."),
    20539: ("今日可玩时长已用尽", "Đã hết thời gian chơi hôm nay"),
    20542: ("优化前: {0}, 优化后: {1}", "Trước tối ưu: {0}, sau tối ưu: {1}"),
    20543: ("优惠 {0}%", "Giảm {0}%"),
    20544: ("元", " tệ"),
    20545: ("关卡状态不一致：", "Trạng thái màn chơi không khớp: "),
    20546: ("关注我们", "Theo dõi chúng tôi"),
    20547: ("关闭", "Đóng"),
    20549: ("删除", "Xóa"),
    20550: ("删除连线", "Xóa đường nối"),
    20551: ("前往 TapTap 查看", "Xem trên TapTap"),
    20552: ("前往 iOS App Store 查看", "Xem trên iOS App Store"),
    20553: ("前往查看", "Đi tới xem"),
    20554: ("剧情", "Cốt truyện"),
    20555: ("加入愿望单！", "Thêm vào danh sách mong muốn!"),
    20556: ("加载中", "Đang tải"),
    20557: ("包含 {bundle.slots.Count} 个槽位，上传时间 {FormatIsoTime(bundle.uploadedAt)}",
            "Gồm {bundle.slots.Count} ô lưu, tải lên lúc {FormatIsoTime(bundle.uploadedAt)}"),
    20558: ("单独游玩", "Chơi một mình"),
    20559: ("发送", "Gửi"),
    20560: ("发送失败", "Gửi thất bại"),
    20561: ("发送成功", "Gửi thành công"),
    20562: ("取消", "Hủy"),
    20563: ("口令时效：{0} 分钟", "Thời hạn mã: {0} phút"),
    20564: ("只能把存档口令接收到空槽位", "Chỉ có thể nhận mã lưu trữ vào ô trống"),
    20565: ("右", "Phải"),
    20566: ("合并关卡", "Gộp màn"),
    20567: ("周边", "Hàng lưu niệm"),
    20568: ("商品价格尚未准备好，请检查网络后重试。", "Chưa lấy được giá sản phẩm, vui lòng kiểm tra mạng rồi thử lại."),
    20569: ("复制", "Sao chép"),
    20572: ("存档口令 Base62 数据不规范", "Dữ liệu Base62 của mã lưu trữ không hợp chuẩn"),
    20573: ("存档口令 Base62 数据无效", "Dữ liệu Base62 của mã lưu trữ không hợp lệ"),
    20574: ("存档口令不是规范编码", "Mã lưu trữ không đúng chuẩn mã hóa"),
    20575: ("存档口令包含非法字符", "Mã lưu trữ chứa ký tự không hợp lệ"),
    20576: ("存档口令匹配到多个时间窗口", "Mã lưu trữ khớp với nhiều khung thời gian"),
    20577: ("存档口令已过期", "Mã lưu trữ đã hết hạn"),
    20578: ("存档口令无效", "Mã lưu trữ không hợp lệ"),
    20579: ("存档口令校验失败", "Kiểm tra mã lưu trữ thất bại"),
    20580: ("存档口令格式错误", "Mã lưu trữ sai định dạng"),
    20581: ("存档口令载荷无效", "Nội dung mã lưu trữ không hợp lệ"),
    20582: ("存档口令载荷过长", "Nội dung mã lưu trữ quá dài"),
    20583: ("存档口令载荷长度无效", "Độ dài nội dung mã lưu trữ không hợp lệ"),
    20584: ("存档口令过短", "Mã lưu trữ quá ngắn"),
    20585: ("存档同步失败，请注意口令的字母大小写与时效！", "Đồng bộ lưu trữ thất bại, hãy chú ý chữ hoa/thường và thời hạn của mã!"),
    20586: ("存档同步成功！", "Đồng bộ lưu trữ thành công!"),
    20587: ("存档缺少主进度数据", "Lưu trữ thiếu dữ liệu tiến trình chính"),
    20588: ("实名认证尚未完成，请完成认证后再进入游戏。", "Chưa hoàn tất xác minh danh tính, vui lòng xác minh rồi vào game."),
    20589: ("实名认证服务连接失败，请检查网络后重试。", "Không kết nối được dịch vụ xác minh danh tính, vui lòng kiểm tra mạng rồi thử lại."),
    20590: ("实名认证校验中，请稍候。", "Đang xác minh danh tính, vui lòng chờ."),
    20591: ("实名认证状态已失效，请重新认证后再进入游戏。", "Xác minh danh tính đã hết hiệu lực, vui lòng xác minh lại rồi vào game."),
    20592: ("对齐 X", "Căn X"),
    20593: ("对齐 Y", "Căn Y"),
    20594: ("对齐网格", "Căn lưới"),
    20595: ("左", "Trái"),
    20596: ("已复制", "Đã sao chép"),
    20597: ("已有一笔购买正在处理中，请稍后重试。", "Đang có một giao dịch được xử lý, vui lòng thử lại sau."),
    20601: ("当前不在未成年人允许游玩的时间段内，请在规定时段再进入游戏。", "Hiện không trong khung giờ người chưa thành niên được phép chơi, vui lòng quay lại đúng khung giờ."),
    20602: ("当前实名账号不满足本次支付条件。", "Tài khoản hiện tại không đủ điều kiện cho giao dịch này."),
    20603: ("当前平台不支持文件式存档口令导入", "Nền tảng này không hỗ trợ nhập mã lưu trữ dạng tệp"),
    20604: ("当前时段无法游玩", "Không thể chơi trong khung giờ này"),
    20605: ("恢复存档失败，请重试。", "Khôi phục lưu trữ thất bại, vui lòng thử lại."),
    20606: ("恢复购买", "Khôi phục giao dịch"),
    20607: (None, "Tài khoản của bạn là tài khoản chưa thành niên và thuộc hệ thống chống nghiện game. "
                  "Theo quy định hiện hành, độ tuổi hiện tại (dưới 8 tuổi) không thể chơi. Dưới đây là thông tin độ tuổi phù hợp của trò chơi.\n\n" + AGE_NOTICE),
    20608: ("截图", "Chụp màn hình"),
    20609: ("手机", "Điện thoại"),
    20610: ("损坏或待恢复的存档不能生成口令", "Lưu trữ bị hỏng hoặc đang chờ khôi phục thì không tạo được mã"),
    20611: ("接收存档口令", "Nhận mã lưu trữ"),
    20612: ("提示", "Thông báo"),
    20613: ("支付处理中", "Đang xử lý thanh toán"),
    20614: ("支付异常", "Thanh toán gặp lỗi"),
    20615: ("支付成功", "Thanh toán thành công"),
    20616: ("支付限制校验失败，请检查网络后重试。", "Kiểm tra giới hạn thanh toán thất bại, vui lòng kiểm tra mạng rồi thử lại."),
    20617: ("支线", "Nhánh phụ"),
    20618: ("新建关卡", "Tạo màn mới"),
    20619: ("新建空节点", "Tạo nút trống"),
    20620: ("新建笔记", "Tạo ghi chú"),
    20621: ("无", "Không"),
    20623: ("日志上传", "Tải nhật ký lên"),
    20629: ("是否上传并覆盖原存档？", "Tải lên và ghi đè lưu trữ cũ?"),
    20630: ("是否恢复存档并覆盖本地存档？", "Khôi phục và ghi đè lưu trữ trên máy?"),
    20631: ("显示", "Hiện"),
    20632: ("显示: {0}", "Hiện: {0}"),
    20634: ("暂无云存档", "Chưa có lưu trữ đám mây"),
    20635: ("暂时无法支付", "Tạm thời không thể thanh toán"),
    20636: ("暂时无法确认购买状态", "Tạm thời không xác nhận được trạng thái mua"),
    20638: ("有 bug!", "Báo lỗi!"),
    20639: ("未完成支付", "Chưa hoàn tất thanh toán"),
    20640: ("未满 8 周岁无法游玩", "Dưới 8 tuổi không thể chơi"),
    20641: ("未知", "Không rõ"),
    20642: ("本地没有可上传的存档。", "Trên máy không có lưu trữ để tải lên."),
    20643: ("本次操作将上传您的用户日志与存档，方便我们 Debug。\n请在上传后通过邮箱联系我们：",
            "Thao tác này sẽ tải nhật ký và lưu trữ của bạn lên để chúng tôi tìm lỗi.\nSau khi tải lên, hãy liên hệ chúng tôi qua email:"),
    20644: ("标签", "Nhãn"),
    20645: ("根据防沉迷要求，未满 8 周岁的用户无法进入游戏。", "Theo quy định chống nghiện game, người dưới 8 tuổi không thể vào game."),
    20646: ("桌游", "Board Game"),
    20647: ("槽位 {slot.slotIndex} 游玩时长：{FormatPlayTime(slot.totalPlayTimeSeconds)}",
            "Ô {slot.slotIndex} thời gian chơi: {FormatPlayTime(slot.totalPlayTimeSeconds)}"),
    20648: ("槽位 {slot.slotIndex} 解锁：猫咪皮肤x{slot.unlockedKittySkinCount}，吐司皮肤x{slot.unlockedToastSkinCount}，世界x{slot.unlockedWorldCount}",
            "Ô {slot.slotIndex} đã mở: skin mèo x{slot.unlockedKittySkinCount}, skin bánh mì x{slot.unlockedToastSkinCount}, vùng x{slot.unlockedWorldCount}"),
    20649: ("槽位存在未完成的存档恢复数据", "Ô lưu có dữ liệu khôi phục chưa hoàn tất"),
    20650: ("正在上传存档...", "Đang tải lưu trữ lên..."),
    20651: ("正在发送中...", "Đang gửi..."),
    20652: ("正在向商店确认是否已购买完整版，请稍候。", "Đang kiểm tra với cửa hàng xem bạn đã mua bản đầy đủ chưa, vui lòng chờ."),
    20653: ("正在恢复存档...", "Đang khôi phục lưu trữ..."),
    20654: ("正在确认购买状态", "Đang xác nhận trạng thái mua"),
    20655: ("正在获取云存档...", "Đang lấy lưu trữ đám mây..."),
    20656: ("源文件不存在", "Tệp nguồn không tồn tại"),
    20657: ("生成存档口令", "Tạo mã lưu trữ"),
    20658: ("生成的本地存档缺少地图：", "Lưu trữ tạo ra thiếu bản đồ: "),
    20659: ("生成的本地存档缺少必要数据", "Lưu trữ tạo ra thiếu dữ liệu cần thiết"),
    20660: ("用户取消登录", "Người dùng đã hủy đăng nhập"),
    20661: ("电子邮箱或 QQ", "Email hoặc QQ"),
    20662: ("登录失败，出现异常：{0}", "Đăng nhập thất bại, có lỗi: {0}"),
    20663: ("目标存档槽不再为空", "Ô lưu đích không còn trống"),
    20664: ("目标文件已存在", "Tệp đích đã tồn tại"),
    20665: ("确定", "OK"),
    20666: ("确认", "Xác nhận"),
    20668: ("空存档槽不能生成口令", "Ô lưu trống không tạo được mã"),
    20669: ("空节点", "Nút trống"),
    20670: ("笔记", "Ghi chú"),
    20671: ("笔记: {0}", "Ghi chú: {0}"),
    20673: ("类型", "Loại"),
    20674: ("粘贴", "Dán"),
    20675: ("给我们好评！", "Đánh giá cho chúng tôi!"),
    20676: ("编号{0}", "Số {0}"),
    20677: ("编辑", "Sửa"),
    20678: ("缺少地图设置：", "Thiếu thiết lập bản đồ: "),
    20679: ("网络不太行啊💦", "Mạng hơi yếu rồi💦"),
    20680: ("网络连接异常", "Lỗi kết nối mạng"),
    20681: ("节点", "Nút"),
    20682: ("获取云存档失败，请重试。", "Lấy lưu trữ đám mây thất bại, vui lòng thử lại."),
    20683: ("获取用户信息失败 ", "Lấy thông tin người dùng thất bại "),
    20684: ("请先完成实名认证，再进入游戏。", "Vui lòng hoàn tất xác minh danh tính trước khi vào game."),
    20685: ("请先登录 TapTap。", "Vui lòng đăng nhập TapTap trước."),
    20686: ("请先获取云存档。", "Vui lòng lấy lưu trữ đám mây trước."),
    20687: ("请检查网络连接后重试。已购买玩家在验证成功后即可进入。", "Vui lòng kiểm tra mạng rồi thử lại. Người đã mua có thể vào sau khi xác minh thành công."),
    20688: ("请留下你的联系方式", "Hãy để lại thông tin liên hệ của bạn"),
    20689: ("请购买完整版后使用此功能", "Hãy mua bản đầy đủ để dùng tính năng này"),
    20690: ("请输入存档口令", "Nhập mã lưu trữ"),
    20691: ("调查问卷", "Khảo sát"),
    20692: ("账号已切换，请重新登录并完成实名认证。", "Tài khoản đã thay đổi, vui lòng đăng nhập lại và xác minh danh tính."),
    20693: ("购买完整版", "Mua bản đầy đủ"),
    20694: ("起始点", "Điểm bắt đầu"),
    20695: ("跳", "Nhảy"),
    20696: ("连续游玩", "Chơi liên tục"),
    20697: ("退出游戏", "Thoát game"),
    20698: ("重命名", "Đổi tên"),
    20699: ("重试", "Thử lại"),
    20700: ("镜头: {0}", "Camera: {0}"),
    20701: ("镜头框数：{0}", "Số khung camera: {0}"),
    20702: ("隐藏", "Ẩn"),
    20703: ("隐藏物品", "Vật phẩm ẩn"),
    20704: ("隐藏路口", "Lối rẽ ẩn"),
    20705: ("需要实名认证", "Cần xác minh danh tính"),
    20706: ("额外内容", "Nội dung thêm"),
    20707: ("验证口令", "Xác minh mã"),
    20708: (None, "CATO bản di động đã ra mắt! Mang CATO theo bạn mọi lúc mọi nơi!\n"
                  "Độc quyền có hạn: 3 mini-game mới và nhiều skin mới!\n\n"
                  "- Tải miễn phí để chơi thử, mua để mở bản đầy đủ, nội dung giống hệt bản PC\n"
                  "- Hỗ trợ quay chậm, bỏ qua màn, tùy chỉnh nút ảo và nhiều tính năng hỗ trợ khác\n"
                  "- Hỗ trợ tay cầm phổ biến, chơi đôi 2 người\n"
                  "- Hỗ trợ thành tựu Game Center\n"
                  "- Lưu trữ đám mây dùng chung giữa bản iOS và Mac App Store"),
}


def main(src, dst):
    b = bytearray(open(src, 'rb').read())
    sanity, ver = struct.unpack_from('<Ii', b, 0)
    assert sanity == 0xFAB11BAF and ver == 31, (hex(sanity), ver)
    lit_off, lit_size, dat_off, _ = struct.unpack_from('<iiii', b, 8)
    n = lit_size // 8
    tail = bytearray()
    base = len(b)
    for i, (orig, new) in sorted(VI.items()):
        assert i < n
        L, idx = struct.unpack_from('<Ii', b, lit_off + i * 8)
        cur = b[dat_off + idx:dat_off + idx + L].decode('utf-8')
        if orig is not None:
            assert cur == orig, (i, cur, orig)
        else:
            assert any('一' <= c <= '鿿' for c in cur), (i, cur[:30])
        for ph in __import__('re').findall(r'\{[^}]*\}', cur):
            assert ph in new, (i, ph)
        enc = new.encode('utf-8')
        new_idx = base + len(tail) - dat_off
        tail += enc
        struct.pack_into('<Ii', b, lit_off + i * 8, len(enc), new_idx)
    b += tail
    while len(b) % 4:
        b += b'\0'
    open(dst, 'wb').write(b)
    print(f'patched {len(VI)} literals, +{len(tail)} bytes -> {dst}')


if __name__ == '__main__':
    main(sys.argv[1], sys.argv[2])
