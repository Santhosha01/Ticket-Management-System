package com.ticketManagementSystem.repository;

import com.ticketManagementSystem.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {

}
