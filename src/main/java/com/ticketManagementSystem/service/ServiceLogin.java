package com.ticketManagementSystem.service;

import com.ticketManagementSystem.model.Ticket;
import com.ticketManagementSystem.model.User;
import com.ticketManagementSystem.repository.TicketRepository;
import com.ticketManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ServiceLogin {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;

    private List<User> users;
    private List<Ticket> tickets;

    public List<User> getAllUsers(){
         return userRepository.findAll();
    }

    public String validateUser(String name, String password) {
        users=getAllUsers();
        for(User u:users){
            if(name.equals(u.getName())&&password.equals(u.getPassword())){
                return u.getRole();
            }
        }
        return "Incorrect";
    }

    public void storeTicket(String name, String problemType, String problemDescription) {
       Ticket ticket=new Ticket(name,problemType,problemDescription);
        ticketRepository.save(ticket);
    }

    public void saveTicket(Ticket t){
        ticketRepository.save(t);
    }



    public void addUser(String name, String password, String role) {
        User newuser=new User(name,password,role);
         userRepository.save(newuser);
     }

    public List<Ticket> gettickets(String username) {
       tickets=getAllTicket();
       List<Ticket> usertickets=new ArrayList<>();
       for(Ticket t:tickets){
           if(username.equals(t.getRaisedby())){
               usertickets.add(t);
               System.out.println(t.getProblemType()+" ");
           }
       }
        return usertickets;
    }
    public List<Ticket> getAllTicket(){
    	return ticketRepository.findAll();
    }

    public Set<User> getAllmembers(){
        users=getAllUsers();
        Set<User> members=new HashSet<>();
        for(User u:users){
            if((u.getRole()).equals("member")){
                members.add(u);
            }
        }
        System.out.println("members"+members);
        return members;
    }

    public Ticket getTicketById(Long ticketId) {
        tickets=getAllTicket();
        for(Ticket t:tickets){
            if ((t.getId()) == ticketId) {
                return t;
            }
        }
        return null;
    }

    public List<Ticket> getMemberTickets(String name) {
        tickets=getAllTicket();
        List<Ticket> membertickets=new ArrayList<>();
        for(Ticket t:tickets){
            if(name.equals(t.getAssignedby())&&(!((t.getStatus()).equals("Solved")))){
                membertickets.add(t);
            }
        }
        return membertickets;
    }

    public List<Ticket> getSolvedTickets() {
        tickets=getAllTicket();
        List<Ticket> solvedtickets=new ArrayList<>();
        for(Ticket t:tickets){
            if((t.getStatus()).equals("Solved")){
                solvedtickets.add(t);
            }
        }
        return solvedtickets;
    }
}
