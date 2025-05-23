package com.pbl.flightapp.requestObj;

import com.pbl.flightapp.Model.Customer;

public class TicketRequest {
  private Customer customer;
  private String seatId;
  private ReturnTicket returnTicket;

  public class ReturnTicket {
    private String seatId;

    public String getSeatId() {
      return seatId;
    }

    public void setSeatId(String seatId) {
      this.seatId = seatId;
    }
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }


  public String getSeatId() {
    return seatId;
  }

  public ReturnTicket getReturnTicket() {
    return returnTicket;
  }

  public void setReturnTicket(ReturnTicket returnTicketDTO) {
    this.returnTicket = returnTicketDTO;
  }

  public void setSeatId(String departureSeatId) {
    this.seatId = departureSeatId;
  }

}
