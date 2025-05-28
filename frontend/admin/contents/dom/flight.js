import {
    getFlightById,
    addFlight,
    updateFlight,
    deleteFlight,
    getAllFlights,
    getFlightSeatsByFlightId,
    getFlightInformation
} from '../../../APIs/flight.js';

import {
    getAllLocation
} from '../../../APIs/location.js'

import {
    getAllPlanes,
    getPlaneById,
    addPlane,
    updatePlane,
    deletePlane
} from '../../../APIs/plane.js';


let selectedFlight;

export default async function loadFlightJS() {
    selectedFlight = null;
    let locationList = await getAllLocation(); // <-- lấy dữ liệu

    populateLocationSelect("from", locationList);
    populateLocationSelect("to", locationList);
    planesSelect("mayBay", await getAllPlanes());

    const addBtn = document.getElementById("add-flight-btn");
    const editBtn = document.getElementById("edit-flight-btn");
    const removeBtn = document.getElementById("remove-flight-btn");
    const viewFlightBtn = document.getElementById("view-flight-btn");
    const formContainer = document.getElementById("plane-form-container");
    const flightForm = document.getElementById("plane-form");
    const viewSeatMapBtn = document.getElementById("view-seat-map-btn");

    addBtn.addEventListener("click", () => {
        selectedFlight = null;
        showForm("Thêm chuyến bay", "Lưu chuyến bay");
        clearForm();
    });

    editBtn.addEventListener("click", () => {
        if (!selectedFlight) return;
        showForm("Chỉnh sửa chuyến bay", "Hoàn tất chỉnh sửa");
        fillForm(selectedFlight);
    });

    //show sơ đồ ghế
    viewSeatMapBtn.addEventListener("click", async () => {
        console.log(selectedFlight);
        if (!selectedFlight) return;
        showSeatMap(await getFlightSeatsByFlightId(selectedFlight.idFlight));
    });

    removeBtn.addEventListener("click", async () => {
        if (!selectedFlight) return;
        await deleteFlight(selectedFlight.idFlight);
        selectedFlight = null;
        loadFlightsTable(await getAllFlights());
    });


    flightForm.addEventListener("submit", async (e) => {
        e.preventDefault();
        const flightData = getFlightFromForm(e);

        if (selectedFlight) {
            await updateFlight(selectedFlight.idFlight, flightData);
        } else {
            await addFlight(flightData);
        }
        selectedFlight = null;
        formContainer.classList.add("hidden");
        loadFlightsTable(await getAllFlights());
    });

    formContainer.addEventListener("click", (e) => {
        if (!flightForm.contains(e.target)) {
            formContainer.classList.add("hidden");
        }
    });

    viewFlightBtn.addEventListener("click", async () => {
        if (!selectedFlight) return;
        await showFlight(selectedFlight);
    });
    const viewFlightContainer = document.getElementById("view-flight-container");
    const viewFlightContent = document.getElementById("view-flight-content");
    viewFlightContainer.addEventListener("click", (e) => {
        if (!viewFlightContent.contains(e.target)) {
            viewFlightContainer.classList.add("hidden");
        }
    });

    //tat xem sơ đồ ghế
    const seat_map_view_container = document.getElementById('view-map-seat-container');
    const seat_map_parent_container = document.getElementById('view-map-seat-content-container');
    seat_map_view_container.addEventListener('click', (e) => {
        if (!seat_map_parent_container.contains(e.target)) {
            seat_map_view_container.classList.add("hidden");
        }
    });

    loadFlightsTable(await getAllFlights());
}

async function showFlight(flight) {
    const viewFlightContainer = document.getElementById("view-flight-container");
    const viewFlightContent = document.getElementById("view-flight-content");
    viewFlightContainer.classList.remove("hidden");
    // viewFlightContent.innerHTML = '';
    // Điền thông tin máy bay
    viewFlightContainer.querySelector("#mayBay").textContent = flight.plane?.namePlane;

    // Điền thông tin điểm đi/đến
    viewFlightContainer.querySelector("#from").textContent = flight.fromLocation.name;
    viewFlightContainer.querySelector("#to").textContent = flight.toLocation.name;

    // Điền thông tin thời gian bay
    const departureDate = new Date(flight.departureDate);
    viewFlightContainer.querySelector("#departureDate").textContent = departureDate.toLocaleString('vi-VN');

    // Điền thông tin thời lượng và giá vé
    viewFlightContainer.querySelector("#durationMinutes").textContent = flight.durationMinutes;
    viewFlightContainer.querySelector("#commonFare").textContent = flight.commonFare.toLocaleString('vi-VN') + ' VND';
    viewFlightContainer.querySelector("#vipFare").textContent = flight.vipFare.toLocaleString('vi-VN') + ' VND';

    // Thống kê số ghế
    const flightInformation = await getFlightInformation(flight.idFlight);

    console.log(flightInformation);
    
    // Đếm số vé đã đặt theo loại
    const bookedEconomyTickets = flightInformation.bookedTickets.filter(ticket => ticket.ticketType === "ECONOMY");
    const bookedBusinessTickets = flightInformation.bookedTickets.filter(ticket => ticket.ticketType === "BUSINESS");
    flightInformation.bookedEconomyTickets = bookedEconomyTickets;
    flightInformation.bookedBusinessTickets = bookedBusinessTickets;

    viewFlightContainer.querySelector("#vip-booked").textContent = flightInformation.bookedBusinessTickets.length;
    viewFlightContainer.querySelector("#vip-available").textContent = flightInformation.businessSeatNumber - flightInformation.bookedBusinessTickets.length;
    viewFlightContainer.querySelector("#economy-booked").textContent = flightInformation.bookedEconomyTickets.length;
    viewFlightContainer.querySelector("#economy-available").textContent = flightInformation.economySeatNumber - flightInformation.bookedEconomyTickets.length;

}
/*
{
    "flight": {
        "idFlight": 7,
        "planeId": 3,
        "departureDate": "2025-06-08",
        "departureTime": "16:54:00",
        "durationMinutes": 100,
        "commonFare": 323,
        "vipFare": 2321,
        "fromLocationId": 1,
        "toLocationId": 16,
        "createdAt": null,
        "bookedEconomyCustomerNumber": 0,
        "bookedVipCustomerNumber": 0,
        "economySeats": 0,
        "vipSeats": 0
    },
    "bookedTickets": [
        {
            "Customer": {
                "idUser": 12,
                "fullName": "Nguy?n Van A",
                "phone": "0123456789",
                "address": "123 Ðu?ng ABC, Qu?n XYZ, TP.HCM",
                "email": "nguyenvana@example.com",
                "dateOfBirth": "1990-01-01 07:00:00.0",
                "userType": "CUSTOMER"
            },
            "ticketType": "ECONOMY"
        },
        {
            "Customer": {
                "idUser": 13,
                "fullName": "Tr?n Th? B",
                "phone": "0987654321",
                "address": "456 Ðu?ng XYZ, Qu?n ABC, TP.HCM",
                "email": "tranthib@example.com",
                "dateOfBirth": "1992-02-02 07:00:00.0",
                "userType": "CUSTOMER"
            },
            "ticketType": "ECONOMY"
        }
    ],
    "businessSeatNumber": 0,
    "economySeatNumber": 60
}
*/

function showSeatMap(flight_seats) {
    //show sơ đồ ghế
    const seat_map_view_container = document.getElementById('view-map-seat-container');
    seat_map_view_container.classList.remove("hidden");


    const seat_map = document.getElementById('seat-map-container');
    seat_map.innerHTML = '';

    const head_seat_map = document.createElement('div');
    head_seat_map.className = "flex w-full mb-4";
    head_seat_map.innerHTML = `
        <div class="w-10"></div>
    `;
    const seat_map_row = document.createElement('div');
    seat_map_row.className = "flex justify-around flex-1 w-full";
    head_seat_map.appendChild(seat_map_row);
    seat_map.appendChild(head_seat_map);

    //tìm số hàng lơn nhất và số ghế lớn nhất
    const seatNumbers = flight_seats.map(flight_seat => flight_seat.seat.seatNumber);

    // seatNumbers.sort((a, b) => {
    //     const [numA, charA] = [parseInt(a), a.match(/[A-Z]/i)[0]];
    //     const [numB, charB] = [parseInt(b), b.match(/[A-Z]/i)[0]];

    //     if (numA === numB) {
    //         return charA.localeCompare(charB); // so sánh chữ cái
    //     }
    //     return numA - numB; // so sánh số
    // });
    let maxNumber = 0;
    let maxLetter = '';

    seatNumbers.forEach(sn => {
        const number = parseInt(sn.match(/\d+/)[0]); // lấy phần số
        const letter = sn.match(/[A-Z]/i)[0];        // lấy phần chữ cái

        if (number > maxNumber) {
            maxNumber = number;
        }

        if (letter > maxLetter) {
            maxLetter = letter;
        }
    });
    const rowNumber = maxNumber;
    const rowSeat = maxLetter.charCodeAt(0) - 'A'.charCodeAt(0) + 1;

    for (let i = 0; i < rowSeat; i++) {
        const column = document.createElement('div');
        column.className = "text-center font-semibold";
        column.innerHTML = String.fromCharCode(65 + i);
        seat_map_row.appendChild(column);
    }

    for (let i = 0; i < rowNumber; i++) {
        const row = document.createElement('div');
        row.className = "flex mt-3 w-full";
        row.innerHTML = `
                <div class="w-10 text-center font-semibold">${i + 1}</div> 
                <div id="seat-map-row-${i}" class="flex justify-around flex-1 w-full">
                </div>`;
        seat_map.appendChild(row);
        const current_row_seat = row.querySelector(`#seat-map-row-${i}`);
        for (let j = 0; j < rowSeat; j++) {
            const seat = document.createElement('div');
            seat.className = "text-center font-semibold bg-blue-500 hover:bg-white text-white px-4 py-2 rounded-md";
            seat.setAttribute('seat', 'economy-seat');
            seat.setAttribute('seat-number', `${i}${String.fromCharCode(65 + j)}`);

            const seatObject = getSeatByNumber(flight_seats, `${i}${String.fromCharCode(65 + j)}`);
            if (seatObject) {
                if (seatObject.seatType == 'BUSINESS') {
                    seat.className = "text-center font-semibold bg-yellow-500 hover:bg-white text-white px-4 py-2 rounded-md";
                }
                else if (seatObject.seatType == 'ECONOMY') {
                    seat.className = "text-center font-semibold bg-blue-400 hover:bg-white text-white px-4 py-2 rounded-md";
                }

                seat.setAttribute('seat', seatObject);

            } else {
                seat.className = "text-center font-semibold bg-amber-100 hover:bg-white text-white px-4 py-2 rounded-md";
            }
            current_row_seat.appendChild(seat);
        }
    }
}
function getSeatByNumber(flight_seats, seatNumber) {
    const result = flight_seats.find(
        flight_seat => flight_seat.seat.seatNumber === seatNumber
    );
    return result ? result.seat : null;
}


function planesSelect(selectId, planes) {
    const select = document.getElementById(selectId);
    select.innerHTML = `<option value="" disabled selected>Chọn máy bay</option>`;
    planes.forEach(plane => {
        const opt = document.createElement("option");
        opt.value = JSON.stringify(plane);
        opt.textContent = plane.namePlane;
        select.appendChild(opt);
    });
}

function populateLocationSelect(selectId, locations) {
    const select = document.getElementById(selectId);
    select.innerHTML = `<option value="" disabled selected>Chọn địa điểm</option>`;
    locations.forEach(loc => {
        const opt = document.createElement("option");
        opt.value = JSON.stringify(loc);
        opt.textContent = loc.name;
        select.appendChild(opt);
    });
}


function showForm(title, buttonLabel) {
    const container = document.getElementById("plane-form-container");

    container.querySelector('#form-title').textContent = title;
    container.querySelector('#submit-form-btn').textContent = buttonLabel;
    container.classList.remove("hidden");
}

function clearForm() {
    const form = document.getElementById("plane-form");
    form.reset();
}

function fillForm(flight) {
    const form = document.getElementById("plane-form");

    form["mayBay"].value = JSON.stringify(flight.plane);
    form["from"].value = JSON.stringify(flight.fromLocation);
    form["to"].value = JSON.stringify(flight.toLocation);

    // Ghép ngày và giờ để đổ vào datetime-local
    if (flight.departureDate && flight.departureTime) {
        const dateTimeStr = `${flight.departureDate}T${flight.departureTime.slice(0, 5)}`; // "yyyy-MM-ddTHH:mm"
        form["departureDate"].value = dateTimeStr;
    }

    form["durationMinutes"].value = flight.durationMinutes || "";
    form["commonFare"].value = flight.commonFare || "";
    form["vipFare"].value = flight.vipFare || "";
}


function getFlightFromForm(e) {
    const f = e.target.elements;
    const [datePart, rawTimePart] = f["departureDate"].value.split("T");
    const timePart = rawTimePart.length === 5 ? rawTimePart + ":00" : rawTimePart;
    return {
        plane: JSON.parse(f["mayBay"].value),
        fromLocation: JSON.parse(f['from'].value),
        toLocation: JSON.parse(f['to'].value),
        departureDate: datePart,
        departureTime: timePart,
        durationMinutes: parseInt(f["durationMinutes"].value, 10),
        commonFare: parseInt(f["commonFare"].value, 10),
        vipFare: parseInt(f["vipFare"].value, 10)
    };
}

function loadFlightsTable(flights) {
    const table = document.getElementById("plane-table-body");
    table.innerHTML = '';
    flights.forEach(flight => {
        const row = document.createElement("tr");
        row.className = "bg-gray-100 hover:bg-amber-100";
        row.setAttribute("flight", JSON.stringify(flight));

        row.innerHTML = `
            <td class="border px-2 py-1">${flight.plane?.namePlane || ""}</td>
            <td class="border px-2 py-1">${flight.fromLocation?.name || ""}</td>
            <td class="border px-2 py-1">${flight.toLocation?.name || ""}</td>
            <td class="border px-2 py-1">${flight.departureDate} | ${flight.departureTime}</td>
            <td class="border px-2 py-1">${flight.durationMinutes} phút</td>
            <td class="border px-2 py-1">${flight.vipFare}</td>
            <td class="border px-2 py-1">${flight.commonFare}</td>
        `;

        row.addEventListener("click", () => {
            table.querySelectorAll("tr").forEach(r => {
                r.classList.remove("bg-amber-300");
                r.classList.add("bg-gray-100");
            });
            selectedFlight = JSON.parse(row.getAttribute("flight"));
            row.classList.remove("bg-gray-100");
            row.classList.add("bg-amber-300");
        });

        table.appendChild(row);
    });
}
