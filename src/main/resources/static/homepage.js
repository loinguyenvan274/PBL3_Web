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
// function selectLocation() {
//     const select = document.getElementsByClassName("Strt_Location");
//     locationOption.forEach(lct => {
//         const option = document.createElement("option");
//         option.value = lct.toLowerCase();
//         option.textContent = lct;
//         select.appendChild(option);
//     });
// };

document.addEventListener("DOMContentLoaded", function () {
    const dropdown = document.querySelector(".List_Location_arrive");
    dropdown.style.display = "none"; // Đảm bảo danh sách bị ẩn khi tải trang
});
document.addEventListener("DOMContentLoaded", function () {
    const dropdown = document.querySelector(".List_Location");
    dropdown.style.display = "none"; // Đảm bảo danh sách bị ẩn khi tải trang
});

function populateList_start() {
    console.log("populateList_start");
    const dropdown = document.querySelector(".List_Location");
    dropdown.style.display = "none";

    if (!dropdown) return;
    dropdown.innerHTML = "";

    locationOption.forEach(location => {
        if (location === document.querySelector(".Text_To").textContent) {
            return; // Bỏ qua nếu địa điểm đã được chọn
        }
        const item = document.createElement("div");

        item.className = "location-item";
        item.innerHTML = `
            <strong>${location}</strong>
        `;
        item.addEventListener("click", function () {
            const a = document.querySelector(".Text_From");
            a.textContent = location;
            dropdown.style.display = "none";
        });
        dropdown.appendChild(item);
    });
}
function populateList_arrive() {
    console.log("populateList_arrive");

    const dropdown = document.querySelector(".List_Location_arrive");
    dropdown.style.display = "none";

    if (!dropdown) return;
    dropdown.innerHTML = "";
    locationOption.forEach(location => {
        if (location === document.querySelector(".Text_From").textContent) {

            return; // Bỏ qua nếu địa điểm đã được chọn

        }
        const item = document.createElement("div");
        item.className = "location-item";
        item.innerHTML = `
            <strong>${location}</strong>
        `;
        item.addEventListener("click", function () {
            const a = document.querySelector(".Text_To");
            a.textContent = location;
            dropdown.style.display = "none";
        });
        dropdown.appendChild(item);
    });
}

function Show_list_location() {
    populateList_start();
    const a = document.querySelector(".Text_From");
    const b = document.querySelector(".List_Location");

    a.textContent = ""; // Xóa nội dung văn bản
    b.style.width = document.querySelector(".Start_Infor").getBoundingClientRect().width + "px";
    b.style.display = "block";
    // click ra ngoài thì ẩn đi


    document.addEventListener("click", function (event) {
        if (!a.contains(event.target) && !b.contains(event.target)) {
            b.style.display = "none";
            if (a.textContent === "") {

                a.textContent = "Điểm khởi hành"; // Đặt lại nội dung văn bản
            }
        }
    });

}
// const locations = [
//     { name: "Tp. Hồ Chí Minh", code: "SGN", description: "Sân bay Tân Sơn Nhất" },
//     { name: "Hà Nội", code: "HAN", description: "Sân bay Nội Bài" },
//     { name: "Buôn Ma Thuột", code: "BMV", description: "Sân bay Buôn Ma Thuột" },
//     // Thêm các địa điểm khác...
// ];
function Show_list_location_arrive() {
    populateList_arrive();
    const a = document.querySelector(".Text_To");
    const b = document.querySelector(".List_Location_arrive");

    a.textContent = ""; // Xóa nội dung văn bản
    b.style.width = document.querySelector(".Start_Infor").getBoundingClientRect().width + "px";
    b.style.display = "block";
    // click ra ngoài thì ẩn đi


    document.addEventListener("click", function (event) {
        if (!a.contains(event.target) && !b.contains(event.target)) {
            b.style.display = "none";
            if (a.textContent === "") {

                a.textContent = "Điểm đến"; // Đặt lại nội dung văn bản
            }
        }
    });
}

