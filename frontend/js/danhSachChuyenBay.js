const searchFormData = JSON.parse(sessionStorage.getItem('search-form-data'));
window.addEventListener('load', function () {

  if (searchFormData) {
    const days = ['Chủ Nhật', 'Thứ Hai', 'Thứ Ba', 'Thứ Tư', 'Thứ Năm', 'Thứ Sáu', 'Thứ Bảy'];
    const departureDate = new Date(searchFormData.departureDate);
    const formattedDate = `${days[departureDate.getDay()]}, ${departureDate.getDate()} Tháng ${departureDate.getMonth() + 1}, ${departureDate.getFullYear()}`;

    const passengerCount = Number(searchFormData.adultNumber) + Number(searchFormData.childNumber) + Number(searchFormData.infantNumber);

    document.querySelector('.route').textContent = `${searchFormData.beginLocation.name} (${searchFormData.beginLocation.nameCode}) → ${searchFormData.endLocation.name} (${searchFormData.beginLocation.nameCode})`;
    document.querySelector('.details div').textContent = `${formattedDate} | ${passengerCount} Hành khách`;
  }
}
)


window.addEventListener('load', async function selectFightHandleChange() {

  await loadDataForCard(searchFormData.beginLocation.id, searchFormData.endLocation.id, searchFormData.departureDate);
  let departureFlightASeat = await selectFlight();
  let returnFlightASeat = null
  if (searchFormData.isRoundTrip) {
    //truyền lại các giá trị mới
    await loadDataForCard(searchFormData.beginLocation.id, searchFormData.endLocation.id, searchFormData.returnDate);
    returnFlightASeat = await selectFight();
  }
  sessionStorage.setItem('customerSelectedFight', JSON.stringify({ departureFlightASeat, returnFlightASeat }))
})
function selectFlight() {
  return new Promise((resolve) => {
    document.querySelectorAll('.flight-card').forEach(card => {
      card.querySelectorAll('[stylebutton="buttonCard"]').forEach(btCard => {
        btCard.addEventListener('click', () => {
          resolve({
            flight: JSON.parse(card.dataset.flight),
            styleSeat: btCard.getAttribute("styleSeat")
          });
        }, { once: true });
      });
    });
  });
}

async function loadDataForCard(fromLocationId, toLocationId, departureDate) {
  const bEUrl = localStorage.getItem('bEUrl') + 'flight/find_flight';
  const params = {
    fromLocationId,
    toLocationId,
    departureDate,
  };
  const queryString = new URLSearchParams(params).toString();
  const finalUrl = `${bEUrl}?${queryString}`;

  try {
    const response = await fetch(finalUrl, {
      method: "GET",
      headers: {
        'Content-Type': 'application/json',
      },
    });

    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }

    const data = await response.json();
    const container = document.querySelector('.flight-list');

    // Clear existing content
    container.innerHTML = '';

    data.forEach(f => {
      const card = document.createElement('div');
      card.dataset.flight = JSON.stringify(f);
      card.className = 'flight-card';
      card.innerHTML = `
        <div class="flight-info">
          <div class="airline-logo">${f.airline}</div>
          <div class="flight-times">
            <div class="time">${f.departureTime}</div>
            <div class="airport">${f.fromLocation.nameCode}</div>
          </div>
          <div class="flight-times">
            <div class="time">${f.estimatedArrivalTime}</div>
            <div class="airport">${f.toLocation.nameCode}</div>
          </div>
        </div>
        <div class="duration">
          <div class="direct">Bay thẳng</div>
        </div>
        <div class="button-card-1" stylebutton="buttonCard" styleSeat="common">
          <div class="price">
            <p>PHỔ THÔNG</p>
            <div class="price-amount">${f.priceEconomy}</div>
            <p>VND</p>
          </div>
        </div>
        <div class="button-card-2" stylebutton="buttonCard" styleSeat="vip">
          <div class="price">
            <p>THƯƠNG GIA</p>
            <div class="price-amount">${f.priceBusiness}</div>
            <p>VND</p>
          </div>
        </div>
      `;
      container.appendChild(card);
    });

  } catch (error) {
    console.error('Error fetching flight data:', error);
  }
}

