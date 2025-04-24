// Chức năng chuyển đổi giữa các tab hạng vé
const classTabs = document.querySelectorAll('.class-tab');

classTabs.forEach(tab => {
    tab.addEventListener('click', () => {
        // Xóa class active khỏi tất cả các tab
        classTabs.forEach(t => t.classList.remove('active'));
        // Thêm class active vào tab được chọn
        tab.classList.add('active');
        
        // Ở đây có thể thêm logic để tải danh sách chuyến bay tương ứng
    });
});
