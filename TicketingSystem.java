
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class SupportTicket {
    private int ticketId;
    private String customerName;
    private String issueDescription;
    private boolean isProcessed;

    public SupportTicket(int ticketId, String customerName, String issueDescription) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.issueDescription = issueDescription;
        this.isProcessed = false;
    }

    public int getTicketId() {
        return ticketId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public boolean isProcessed() {
        return isProcessed;
    }

    public void markAsProcessed() {
        this.isProcessed = true;
    }

    @Override
    public String toString() {
        return "Ticket ID  : " + ticketId + "\nCustomer Name: " + customerName +
                "\nIssue      : " + issueDescription + "\nStatus     : " + (isProcessed ? "Processed" : "Pending");
    }
}

class TicketQueue {
    private Queue<SupportTicket> ticketQueue;

    public TicketQueue() {
        ticketQueue = new LinkedList<>();
    }

    public void addTicket(SupportTicket ticket) {
        ticketQueue.offer(ticket);
        System.out.println(" Ticket added successfully. ");
        System.out.println(" You are number " + ticketQueue.size() + " in the queue.");
        System.out.println();
    }

    public void processTicket() {
        if (ticketQueue.isEmpty()) {
            System.out.println(" No tickets to process.");
            return;
        }
        SupportTicket ticket = ticketQueue.poll();
        ticket.markAsProcessed();
        System.out.println(" Processing Ticket:");
        System.out.println(ticket);
    }

    public void displayTickets() {
        if (ticketQueue.isEmpty()) {
            System.out.println("No pending tickets.");
            return;
        }
        System.out.println();
        System.out.println(" Current Tickets in the Queue:");
        for (SupportTicket ticket : ticketQueue) {
            System.out.println("================================================");
            System.out.println(ticket);
        }
    }
}

public class TicketingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketQueue ticketQueue = new TicketQueue();

        System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        System.out.println("+                                                   +");
        System.out.println("+        Customer Support Ticketing System          +");
        System.out.println("+                                                   +");
        System.out.println("+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+");
        System.out.println();


        while (true) {
            System.out.println(" Choose an option (1/2/3/4)");
            System.out.println(" 1. Add a Ticket");
            System.out.println(" 2. Handle Ticket");
            System.out.println(" 3. Display All Tickets");
            System.out.println(" 4. Exit");
            System.out.print("--> ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print(" Enter Ticket ID        : ");
                    int ticketId = Integer.parseInt(scanner.nextLine());
                    System.out.print(" Enter Customer Name    : ");
                    String name = scanner.nextLine();
                    System.out.print(" Enter Issue Description: ");
                    String issue = scanner.nextLine();
                    SupportTicket newTicket = new SupportTicket(ticketId, name, issue);
                    ticketQueue.addTicket(newTicket);
                    break;
                case "2":
                    ticketQueue.processTicket();
                    break;
                case "3":
                    ticketQueue.displayTickets();
                    break;
                case "4":
                    System.out.println(" Exiting the system.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println(" Invalid option. Please try again.");
            }
        }
    }
}