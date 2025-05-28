// package com.pbl.flightapp.DTO;

// import com.pbl.flightapp.Enum.TicketType;
// import com.pbl.flightapp.Model.Ticket;

// public class TicketDTO {
//     private int idTicket;
//     private UserDTO user;
//     private FlightDTO flight;
//     private TicketType ticketType;
//     private String SeatName;
//     private Long price;
//     private int baggageId;
//     private ReturnTicketDTO returnTicket;
//     private int bookingId;
//     private Long createdAt;

//     public TicketDTO() {
//     }

//     public TicketDTO(int idTicket, int userId, int flightId, String ticketType, int flightSeatId, int seatFlightId, Long price, int baggageId, int returnTicketId, int bookingId, Long createdAt) {
//         this.idTicket = idTicket;
//         this.userId = userId;
//         this.flightId = flightId;
//         this.ticketType = ticketType;
//         this.flightSeatId = flightSeatId;
//         this.seatFlightId = seatFlightId;
//         this.price = price;
//         this.baggageId = baggageId;
//         this.returnTicket = returnTicket;
//         this.bookingId = bookingId;
//         this.createdAt = createdAt;
//     }

//     public int getIdTicket() {
//         return idTicket;
//     }

//     public void setIdTicket(int idTicket) {
//         this.idTicket = idTicket;
//     }

//     public int getUserId() {
//         return userId;
//     }

//     public void setUserId(int userId) {
//         this.userId = userId;
//     }

//     public int getFlightId() {
//         return flightId;
//     }

//     public void setFlightId(int flightId) {
//         this.flightId = flightId;
//     }

//     public String getTicketType() {
//         return ticketType;
//     }

//     public void setTicketType(String ticketType) {
//         this.ticketType = ticketType;
//     }

//     public int getFlightSeatId() {
//         return flightSeatId;
//     }

//     public void setFlightSeatId(int flightSeatId) {
//         this.flightSeatId = flightSeatId;
//     }

//     public int getSeatFlightId() {
//         return seatFlightId;
//     }

//     public void setSeatFlightId(int seatFlightId) {
//         this.seatFlightId = seatFlightId;
//     }

//     public Long getPrice() {
//         return price;
//     }

//     public void setPrice(Long price) {
//         this.price = price;
//     }

//     public int getBaggageId() {
//         return baggageId;
//     }

//     public void setBaggageId(int baggageId) {
//         this.baggageId = baggageId;
//     }

//     public ReturnTicketDTO getReturnTicket() {
//         return returnTicket;
//     }

//     public void setReturnTicket(ReturnTicketDTO returnTicket) {
//         this.returnTicket = returnTicket;
//     }

//     public int getBookingId() {
//         return bookingId;
//     }

//     public void setBookingId(int bookingId) {
//         this.bookingId = bookingId;
//     }

//     public Long getCreatedAt() {
//         return createdAt;
//     }

//     public void setCreatedAt(Long createdAt) {
//         this.createdAt = createdAt;
//     }
// }
