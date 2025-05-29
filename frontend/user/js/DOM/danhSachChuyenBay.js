import { findFlight } from "../../../APIs/flight.js";

const searchFormData = JSON.parse(sessionStorage.getItem('search-form-data'));
function renderRouteInfo(data, direction) {
  const days = ['Chủ Nhật', 'Thứ Hai', 'Thứ Ba', 'Thứ Tư', 'Thứ Năm', 'Thứ Sáu', 'Thứ Bảy'];

  let date;
  let beginLocation;
  let endLocation;

  if (direction === 'departure') {
    date = new Date(data.departureDate);
    beginLocation = data.beginLocation;
    endLocation = data.endLocation;
  } else if (direction === 'return') {
    date = new Date(data.returnDate);
    beginLocation = data.endLocation;
    endLocation = data.beginLocation;
  } else {
    console.error('Direction must be "departure" or "return"');
    return;
  }

  const formattedDate = `${days[date.getDay()]}, ${date.getDate()} Tháng ${date.getMonth() + 1}, ${date.getFullYear()}`;
  const passengerCount = Number(data.adultNumber);

  document.querySelector('.route').textContent = `${beginLocation.name} (${beginLocation.nameCode}) → ${endLocation.name} (${endLocation.nameCode})`;
  document.querySelector('.details div').textContent = `${formattedDate} | ${passengerCount} Hành khách`;
}


window.addEventListener('load', async function selectFightHandleChange() {

  //set thông báo biển hiệu
  if (searchFormData) {
    renderRouteInfo(searchFormData, 'departure'); // Chiều đi
  }
  await loadDataForCard(searchFormData.beginLocation.id, searchFormData.endLocation.id, searchFormData.departureDate);
  let departureFlightASeat = await selectFlight();
  let returnFlightASeat = null
  if (searchFormData.isRoundTrip) {
    //set thông báo chọn chuyến về
    window.scrollTo(0, 0);
    if (searchFormData) {
      renderRouteInfo(searchFormData, 'return'); // chiều về
    }
    //truyền lại các giá trị mới
    await loadDataForCard(searchFormData.endLocation.id, searchFormData.beginLocation.id, searchFormData.returnDate);
    returnFlightASeat = await selectFlight();
  }
  sessionStorage.setItem('customerSelectedFight', JSON.stringify({ departureFlightASeat, returnFlightASeat }))

  window.location.href = 'nhapThongTin.html';

})
function selectFlight() {
  return new Promise((resolve) => {
    document.querySelectorAll('.flight-card').forEach(card => {
      card.querySelectorAll('[stylebutton="buttonCard"]').forEach(btCard => {
        if(btCard.getAttribute("disabled") === "disabled"){
          return;
        }
        btCard.addEventListener('click', () => {
          resolve({
            flight: JSON.parse(card.dataset.flight),
            TicketType: btCard.getAttribute("TicketType")
          });
        }, { once: true });
      });
    });
  });
}

async function loadDataForCard(fromLocationId, toLocationId, departureDate) {

  const data = await findFlight(fromLocationId, toLocationId, departureDate);
  const container = document.querySelector('.flight-list');

  // Clear existing content
  container.innerHTML = '';

  data.forEach(f => {
    const fullDateTimeString = `${f.departureDate}T${f.departureTime}`; // "2025-05-15T14:36:00"
    const departure = new Date(fullDateTimeString);
    let arrival = null;
    if (!isNaN(departure.getTime())) {
      arrival = new Date(departure.getTime() + f.durationMinutes * 60000);
      console.log("Arrival time:", arrival.toISOString());
    } else {
      console.error("Thời gian không hợp lệ:", fullDateTimeString);
    }

    const card = document.createElement('div');
    card.dataset.flight = JSON.stringify(f);
    card.className = 'flight-card';
    card.innerHTML = `
        <div class="flight-info">
          <div class="airline-logo">${f.plane.namePlane}</div>
          <div class="flight-times">
            <div class="time">${f.departureTime}</div>
            <div class="airport">${f.fromLocation.nameCode}</div>
          </div>
          <div class="flight-times">
            <div class="time">${arrival.toTimeString().split(' ')[0]}</div>
            <div class="airport">${f.toLocation.nameCode}</div>
          </div>
        </div>
        <div class="duration">
          <div class="direct">Bay thẳng</div>
        </div>
        <div class="button-card-1" stylebutton="buttonCard" TicketType="ECONOMY">
          <div class="price">
            <div class="seat-left">${f.availableEconomyTicket} ghế còn lại</div>
            <p>PHỔ THÔNG</p>
            <div class="price-amount">${f.commonFare}</div>
            <p>VND</p>
          </div>
        </div>
        <div class="button-card-2" stylebutton="buttonCard" TicketType="BUSINESS">
          <div class="price">
            <div class="seat-left">${f.availableBusinessTicket} ghế còn lại</div>
            <p>THƯƠNG GIA</p>
            <div class="price-amount">${f.vipFare}</div>
            <p>VND</p>
          </div>
        </div>
      `;
      if(searchFormData.adultNumber > f.availableEconomyTicket){
        card.querySelector('.button-card-1').style.backgroundColor = 'gray';
        card.querySelector('.button-card-1').style.color = 'black';
        card.querySelector('.button-card-1').style.cursor = 'not-allowed';
        card.querySelector('.button-card-1').setAttribute('disabled', 'disabled');
      }
      if(searchFormData.adultNumber > f.availableBusinessTicket){
        card.querySelector('.button-card-2').style.backgroundColor = 'gray';
        card.querySelector('.button-card-2').style.color = 'black';
        card.querySelector('.button-card-2').style.cursor = 'not-allowed';
        card.querySelector('.button-card-2').setAttribute('disabled', 'disabled');
      }    
    container.appendChild(card);
  });
}

/*
{
    "idFlight": 8,
    "planeId": 5,
    "departureDate": "2025-05-30",
    "departureTime": "13:14:00",
    "durationMinutes": 120,
    "commonFare": 12030,
    "vipFare": 222333,
    "fromLocation": {
        "id": 1,
        "name": "Noi Bai International Airport",
        "nameCode": "HAN"
    },
    "toLocation": {
        "id": 3,
        "name": "Da Nang International Airport",
        "nameCode": "DAD"
    },
    "createdAt": null,
    "bookedEconomyCustomerNumber": 0,
    "bookedVipCustomerNumber": 0,
    "economySeats": 0,
    "vipSeats": 0,
    "plane": {
        "idPlane": 5,
        "namePlane": "Mitsubishi SpaceJet",
        "status": "ACTIVE",
        "flightHours": 121,
        "seatCount": 0
    },
    "availableEconomyTicket": 34,
    "availableBusinessTicket": 4
}
*/