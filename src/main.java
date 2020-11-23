import java.util.HashMap;
import java.util.Map;

public class main
{
    public static void main(String[] args)
    {
        // construct deliverers
        Deliverer thomas = new Deliverer(1, "Thomas", 60);
        Deliverer henk = new Deliverer(2, "Henk", 80);
        Deliverer tom = new Deliverer(3, "Tom", 80);

        // construct Depot
        Depot depot = new Depot(1, "Depot");

        // Add packages to the depot
        depot.addPackage(new Package(1, 50000, "Henk", "Jumbo"));
        depot.addPackage(new Package(2, 40000, "Thomas", "Bol"));
        depot.addPackage(new Package(3, 50000, "Mark", "Mediamarkt"));
        depot.addPackage(new Package(4, 4000, "Tom", "Praxis"));
        depot.addPackage(new Package(5, 10000, "Harrie", "Thomas"));
        depot.addPackage(new Package(6, 20000, "Henk", "Bol"));
        depot.addPackage(new Package(7, 100000, "Henk", "Mediamarkt"));
        depot.addPackage(new Package(8, 8000, "Henk", "BCC"));
        depot.addPackage(new Package(9, 200000, "Thomas", "Bol"));
        depot.addPackage(new Package(10, 20000, "Henk", "Bol"));
        depot.addPackage(new Package(11, 100000, "Henk", "Mediamarkt"));
        depot.addPackage(new Package(12, 8000, "Henk", "BCC"));
        depot.addPackage(new Package(13, 200000, "Thomas", "Bol"));

        // Add letters to the depot
        depot.addPackage(new Letter(14, "Henk", "Henk"));
        depot.addPackage(new Letter(15, "Thomas", "Belanstingsdienst"));
        depot.addPackage(new Letter(16, "Mark", "Bank"));
        depot.addPackage(new Letter(17, "Tom", "Gemeente"));

        // Add deliverers to the depot.
        depot.addDeliverer(tom);
        depot.addDeliverer(thomas);
        depot.addDeliverer(henk);

        // Distribute the packages in depot to all available deliverers.
        depot.distributePackagesToDeliverers();

        // Determine if postnl needs more deliverers.
        System.out.println(depot.getExtraDeliverers());

        System.out.println("------------------------------------------------------");

        // Print all the packagenumbers with the deliverers it is carying.
        for(Map.Entry<Integer, String> entry : depot.getPackageNumberWithDeliverer().entrySet())
        {
            System.out.println("Packagenumber: " + entry.getKey() + " Deliverer: " + entry.getValue());
        }
    }
}
