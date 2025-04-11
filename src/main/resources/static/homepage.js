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
    const size = document.querySelector(".Find_Flights_Form");
    const a = document.querySelector(".Text_From");
    const b = document.querySelector(".List_Location");
    const e = document.querySelector(".Start_Infor");
    if (!a || !b || !size) return;
    const c = a.getBoundingClientRect();
    const d = size.getBoundingClientRect();
    b.style.height = d.height + "px";
    b.style.width = d.width + "px";
    b.style.position = "absolute";
    b.style.top = (c.top + c.height) + "px";
    b.style.left = (e.getBoundingClientRect().left) + "px";
    b.style.display = "block";
    // click ra ngoài thì ẩn đi
    document.addEventListener("click", function (event) {
        if (!a.contains(event.target) && !b.contains(event.target)) {
            b.style.display = "none";
        }
    });
}

