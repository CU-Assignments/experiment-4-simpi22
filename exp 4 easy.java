import java.util.ArrayList;
import java.util.Scanner;

class Worker {
    int workerId;
    String workerName;
    double workerSalary;
    public Worker(int workerId, String workerName, double workerSalary) {
        this.workerId = workerId;
        this.workerName = workerName;
        this.workerSalary = workerSalary;
    }
    public void showDetails() {
        System.out.println("ID: " + workerId + ", Name: " + workerName + ", Salary: " + workerSalary);
    }
}

public class WorkerManager {
    private ArrayList<Worker> workers;
    private Scanner input;
    public WorkerManager() {
        workers = new ArrayList<>();
        input = new Scanner(System.in);
    }
    public void addWorker() {
        System.out.print("Enter Worker ID: ");
        int workerId = input.nextInt();
        input.nextLine();
        System.out.print("Enter Worker Name: ");
        String workerName = input.nextLine();
        System.out.print("Enter Worker Salary: ");
        double workerSalary = input.nextDouble();
        Worker worker = new Worker(workerId, workerName, workerSalary);
        workers.add(worker);
        System.out.println("Worker added successfully!");
    }
    public void updateWorker() {
        System.out.print("Enter Worker ID to update: ");
        int workerId = input.nextInt();
        input.nextLine();
        Worker worker = findWorkerById(workerId);
        if (worker != null) {
            System.out.print("Enter new name: ");
            String workerName = input.nextLine();
            System.out.print("Enter new salary: ");
            double workerSalary = input.nextDouble();
            worker.workerName = workerName;
            worker.workerSalary = workerSalary;
            System.out.println("Worker updated successfully!");
        } else {
            System.out.println("Worker not found!");
        }
    }
    public void removeWorker() {
        System.out.print("Enter Worker ID to remove: ");
        int workerId = input.nextInt();
        Worker worker = findWorkerById(workerId);
        if (worker != null) {
            workers.remove(worker);
            System.out.println("Worker removed successfully!");
        } else {
            System.out.println("Worker not found!");
        }
    }
    public void searchWorker() {
        System.out.print("Enter Worker ID to search: ");
        int workerId = input.nextInt();
        Worker worker = findWorkerById(workerId);
        if (worker != null) {
            worker.showDetails();
        } else {
            System.out.println("Worker not found!");
        }
    }
    private Worker findWorkerById(int workerId) {
        for (Worker worker : workers) {
            if (worker.workerId == workerId) {
                return worker;
            }
        }
        return null;
    }
    public void showAllWorkers() {
        if (workers.isEmpty()) {
            System.out.println("No workers to display.");
        } else {
            System.out.println("Worker List:");
            for (Worker worker : workers) {
                worker.showDetails();
            }
        }
    }
    public static void main(String[] args) {
        WorkerManager manager = new WorkerManager();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Worker\n2. Update Worker\n3. Remove Worker\n4. Search Worker\n5. Display All Workers\n6. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    manager.addWorker();
                    break;
                case 2:
                    manager.updateWorker();
                    break;
                case 3:
                    manager.removeWorker();
                    break;
                case 4:
                    manager.searchWorker();
                    break;
                case 5:
                    manager.showAllWorkers();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
