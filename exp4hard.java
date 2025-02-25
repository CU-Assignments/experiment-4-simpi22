class TicketBookingSystem {
    private final boolean[] seats;
    private final int totalSeats;
    public TicketBookingSystem(int totalSeats) {
        this.totalSeats = totalSeats;
        seats = new boolean[totalSeats];
    }
    public synchronized boolean bookSeat(int seatNumber, boolean isVIP) {
        if (seatNumber < 0 || seatNumber >= totalSeats) {
            System.out.println("Invalid seat number!");
            return false;
        }
        if (seats[seatNumber]) {
            System.out.println("Seat " + seatNumber + " is already booked.");
            return false;
        }
        seats[seatNumber] = true;
        String bookingType = isVIP ? "VIP" : "Regular";
        System.out.println(bookingType + " Booking Confirmed for Seat " + seatNumber);
        return true;
    }
    static class RegularBookingThread extends Thread {
        private final TicketBookingSystem system;
        private final int seatNumber;
        public RegularBookingThread(TicketBookingSystem system, int seatNumber) {
            this.system = system;
            this.seatNumber = seatNumber;
        }
        @Override
        public void run() {
            system.bookSeat(seatNumber, false);
        }
    }
    static class VIPBookingThread extends Thread {
        private final TicketBookingSystem system;
        private final int seatNumber;
        public VIPBookingThread(TicketBookingSystem system, int seatNumber) {
            this.system = system;
            this.seatNumber = seatNumber;
        }
        @Override
        public void run() {
            system.bookSeat(seatNumber, true);
        }
    }
    public static void main(String[] args) {
        int totalSeats = 10;
        TicketBookingSystem bookingSystem = new TicketBookingSystem(totalSeats);
        Thread vipThread1 = new VIPBookingThread(bookingSystem, 2);
        Thread vipThread2 = new VIPBookingThread(bookingSystem, 5);
        Thread regularThread1 = new RegularBookingThread(bookingSystem, 2);
        Thread regularThread2 = new RegularBookingThread(bookingSystem, 5);
        Thread regularThread3 = new RegularBookingThread(bookingSystem, 3);
        vipThread1.setPriority(Thread.MAX_PRIORITY);
        vipThread2.setPriority(Thread.MAX_PRIORITY);
        regularThread1.setPriority(Thread.NORM_PRIORITY);
        regularThread2.setPriority(Thread.NORM_PRIORITY);
        regularThread3.setPriority(Thread.NORM_PRIORITY);
        vipThread1.start();
        vipThread2.start();
        regularThread1.start();
        regularThread2.start();
        regularThread3.start();
    }
}
