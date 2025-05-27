import { BASE_URL } from "./init.js";

const API_BASE = BASE_URL + '/flight';


// Lấy thông tin 1 chuyến bay theo ID
export async function getFlightById(id) {
  const res = await fetch(`${API_BASE}/${id}`, {
    credentials: 'include'
  });
  return await res.json();
}

// Thêm chuyến bay mới
export async function addFlight(flight) {
  await fetch(API_BASE, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(flight),
    credentials: 'include'
  });
}

// Cập nhật chuyến bay theo ID
export async function updateFlight(id, flight) {
  await fetch(`${API_BASE}/${id}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(flight),
    credentials: 'include'
  });
}

// Xoá chuyến bay theo ID
export async function deleteFlight(id) {
  await fetch(`${API_BASE}/${id}`, {
    method: "DELETE",
    credentials: 'include'
  });
}


export async function getAllFlights() {
  const res = await fetch(API_BASE + '/all_flights', {
    credentials: 'include'
  });
  return await res.json();
}

export async function getFlightSeatsByFlightId(flightId) {
  const response = await fetch(API_BASE + '/flight_seats?flightId=' + flightId, {
    method: "GET",
    headers: {
      'Content-Type': 'application/json',
    },
    credentials: 'include'
  });
  return await response.json();
}
//tìm tat cac cac chuyen bayy
export async function findFlight(fromLocationId, toLocationId, departureDate) {
  const bEUrl = API_BASE + '/find_flight';
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
      credentials: 'include'
    });

    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }

    const data = await response.json();
    return data;

  } catch (e) {
    console.error('error: of get flight');
  }
  return [];

}