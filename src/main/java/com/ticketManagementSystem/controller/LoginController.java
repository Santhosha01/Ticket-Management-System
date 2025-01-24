package com.ticketManagementSystem.controller;

import com.ticketManagementSystem.model.Ticket;
import com.ticketManagementSystem.model.User;
import com.ticketManagementSystem.service.ServiceLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class LoginController {

    @Autowired
    private ServiceLogin serviceLogin;

    private String name;

    private List<User> memberList;

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password) {

        String isValidUser = serviceLogin.validateUser(name, password);

        if (isValidUser.equals("admin")) {
            model.put("username", name);
            return "admin";
        }
        else if (isValidUser.equals("user")) {
            model.put("username", name);
            return "user";
        }
        else if (isValidUser.equals("member")) {
            model.put("username", name);
            return "member";
        }
        else {
            model.put("errorMessage", "Invalid Credentials");
            return "login";
        }
    }
    @GetMapping("/addUser")
    public String addNewUser() {
        return "addUser";
    }
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addNewUser(ModelMap model, @RequestParam String name, @RequestParam String password, @RequestParam String role) {
    	serviceLogin.addUser(name,password,role);
    	model.put("username", name);
    	return "admin";
    }

    @GetMapping("/createTicket")
    public String createTicket(@RequestParam String username) {
        System.out.println(username);
        name=username;
        return "createticket";
    }

    @RequestMapping(value = "/createTicket", method = RequestMethod.POST)
    public String createTicket(@RequestParam("problemType") String problemType,
                               @RequestParam("problemDescription") String problemDescription,
                               ModelMap model) {
        serviceLogin.storeTicket(name,problemType,problemDescription);
        model.put("username", name);
        return "user";
    }

    @GetMapping("/viewTicket")
    public String ViewTicket(@RequestParam String username, Model model) {
        System.out.println(username);
        name=username;
        List<Ticket> usertickets= serviceLogin.gettickets(username);
        for(Ticket t:usertickets) {
        	System.out.println(t.getProblemType()+" "+t.getProblemDescription()+" "+t.getStatus());
        }
        model.addAttribute("ticketList", usertickets);
        return "viewtickets";
    }

      @GetMapping("/viewall")
      public String ViewAll(Model model) {
          List<Ticket> usertickets=new ArrayList<>();
          for(Ticket t:serviceLogin.getAllTicket()) {
              if(!(t.getStatus().equals("Solved"))){
                  usertickets.add(t);
                  System.out.println(t.getId()+" "+t.getProblemType()+" "+t.getProblemDescription()+" "+t.getStatus());
              }
          }
    	  model.addAttribute("ticketList", usertickets);
          memberList =  (serviceLogin.getAllmembers()).stream().toList();
          model.addAttribute("memberList", memberList);
    	  return "viewall";
      }

    @PostMapping("/assignTicket")
    public String assignTicket(@RequestParam("ticketId") Long ticketId,
                               @RequestParam("role") String role,
                               Model model) {

        Ticket ticket = serviceLogin.getTicketById(ticketId);

        System.out.println(role);
        System.out.println(ticketId);
        ticket.setAssignedby(role);
        ticket.setStatus("assigned");
        serviceLogin.saveTicket(ticket);

        return "admin";
    }


    @GetMapping("/solvedticket")
    public String solveTickets(Model model) {
        List<Ticket> solvetickets=serviceLogin.getSolvedTickets();
        model.addAttribute("ticketList", solvetickets);
        return "solvedticket";
    }



    @GetMapping("/memberTicket")
    public String memberTickets(@RequestParam String username, @RequestParam("role") String role,Model model) {
        name=username;
        System.out.println(name);
        List<Ticket> membertickets=serviceLogin.getMemberTickets(name);
        for(Ticket t:membertickets){
            System.out.println(t.getId()+" "+t.getProblemType()+" "+t.getProblemDescription()+" "+t.getStatus()+" "+t.getAssignedby());
        }
        model.addAttribute("ticketList", membertickets);
        return "membertickets";
    }

    @PostMapping("/memberTicket")
    public String solveTicket(@RequestParam String raisedBy,
                               @RequestParam String problemType,
                               @RequestParam String problemDescription,
                               @RequestParam Long ticketId,
                               @RequestParam String solution,
                               @RequestParam String role,ModelMap model) {

        System.out.println(role);

        System.out.println("Solved");

        Ticket ticket = serviceLogin.getTicketById(ticketId);

        ticket.setSolution(solution);
        ticket.setStatus("Solved");

        serviceLogin.saveTicket(ticket);
        model.put("username", role);
        return "member";
    }




}
