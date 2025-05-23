package com.pbl.flightapp.Repository;

import com.pbl.flightapp.Model.Ticket;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 * Id_Ticket string [primary key]
  Id_Flight string
  Id_Flight_Return string [default: null]
  Id_Card string
  Id_Seat string
  Id_Return_Flight_Seat string [default: null]
  Ticket_Price string
  Booking_Day string
  Id_Baggage string 
 */
@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> {
    // Ticket findByIdTicket(int idTicket);
    //
    List<Ticket> findByFlight_IdFlight(Integer flightId);
    //
    // List<Ticket> findByFlightReturn(Flight flightReturnId);
    //
    // List<Ticket> findByCustomer(Customer customer);
    //
    // List<Ticket> findBySeat(Seat seat);
    //
    // List<Ticket> findByReturnFlightSeat(Seat returnFlightSeatId);
    //
    // List<Ticket> findByBookingDay(Date bookingDay);
    //
    // List<Ticket> findByBaggage(Baggage Id_Baggage);

}
