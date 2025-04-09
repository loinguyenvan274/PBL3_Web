const locationOption = [
    "Hà Nội",
    "TP. Hồ Chí Minh",
    "Đà Nẵng",
    "Hải Phòng",
    "Cần Thơ",
    "Nha Trang (Khánh Hòa)",
    "Huế (Thừa Thiên Huế)",
    "Vinh (Nghệ An)",
    "Thanh Hóa",
    "Quảng Ninh (Vân Đồn)",
    "Quy Nhơn (Bình Định)",
    "Buôn Ma Thuột (Đắk Lắk)",
    "Pleiku (Gia Lai)",
    "Đà Lạt (Lâm Đồng)",
    "Phú Quốc (Kiên Giang)",
    "Cà Mau",
    "Điện Biên",
    "Rạch Giá (Kiên Giang)",
    "Tuy Hòa (Phú Yên)"
];
function selectLocation() {
    const select = document.getElementsByClassName("Strt_Location");
    locationOption.forEach(lct => {
        const option = document.createElement("option");
        option.value = lct.toLowerCase();
        option.textContent = lct;
        select.appendChild(option);
    });
};

function Show_list_location() {
    const a = document.getElementsByClassName("Text_From");
    const b = document.getElementsByClassName("List_Location");
    a.addEventListener('click', () => {
        const position = a.getBoundingClientRect();
        b.style.right = `&{position.right + window.scrollX}px`;
        b.style.top = `&{position.bottom + window.scrollY}py`;
        b.style.display = (b.style.display == 'block') ? 'none' : 'block';
    });
    document.addEventListener('click', (e) => {
        if (!a.contains(e.target) && !b.contains(e.target)) {
            b.style.display = 'none';
        }
    });
}