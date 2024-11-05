import java.util.Scanner;

class fcfs {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        
        // Get number of processes from user
        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();
        
        // Initialize arrays
        String title[] = {"Processes", "BT", "WT", "TAT"};
        String process[] = new String[n];
        int BT[] = new int[n];
        int WT[] = new int[n];
        int TAT[] = new int[n];
        
        // Input process details
        for(int i = 0; i < n; i++) {
            System.out.print("\nEnter process name (e.g., p" + (i+1) + "): ");
            process[i] = scanner.next();
            
            System.out.print("Enter burst time for " + process[i] + ": ");
            BT[i] = scanner.nextInt();
        }
        
        // Calculate Waiting Time
        int Total_WT = 0;
        WT[0] = 0;  // First process has 0 waiting time
        
        for(int i = 1; i < n; i++) {
            WT[i] = BT[i-1] + WT[i-1];
            Total_WT += WT[i];
        }
        
        // Calculate Turn Around Time
        int Total_TAT = 0;
        for(int i = 0; i < n; i++) {
            TAT[i] = BT[i] + WT[i];
            Total_TAT += TAT[i];
        }
        
        // Calculate Averages
        float Avg_WT = (float)Total_WT/n;
        float Avg_TAT = (float)Total_TAT/n;
        
        // Print Results
        System.out.println("\n*** FCFS Scheduling ***\n");
        
        // Print Header
        for(int i = 0; i < 4; i++) {
            System.out.print(title[i] + "\t");
        }
        System.out.println("\n----------------------------------------");
        
        // Print Process Details
        for(int i = 0; i < n; i++) {
            System.out.println(process[i] + "\t\t" + BT[i] + "\t" + WT[i] + "\t" + TAT[i]);
        }
        
        // Print Summary
        System.out.println("\nSummary:");
        System.out.println("Total Waiting Time = " + Total_WT);
        System.out.println("Total Turn Around Time = " + Total_TAT);
        System.out.println("Average Waiting Time = " + String.format("%.2f", Avg_WT));
        System.out.println("Average Turn Around Time = " + String.format("%.2f", Avg_TAT));
        
        scanner.close();
    }
}