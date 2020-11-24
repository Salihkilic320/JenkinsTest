import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DepotTest {

    Deliverer thomas;
    Deliverer tom;
    Deliverer henk;
    Depot depot;

    @BeforeEach
    void init()
    {
        // construct deliverers
        this.thomas = new Deliverer(1, "Thomas", 60);
        this.henk = new Deliverer(2, "Henk", 80);
        this.tom = new Deliverer(3, "Tom", 80);

        // construct Depot
        this.depot = new Depot(1, "Depot");

        // Add packages to the depot
        this.depot.addPackage(new Package(1, 50000, "Henk", "Jumbo"));
        this.depot.addPackage(new Package(2, 40000, "Thomas", "Bol"));
        this.depot.addPackage(new Package(3, 50000, "Mark", "Mediamarkt"));
        this.depot.addPackage(new Package(4, 4000, "Tom", "Praxis"));
        this.depot.addPackage(new Package(5, 10000, "Harrie", "Thomas"));
        this.depot.addPackage(new Package(6, 20000, "Henk", "Bol"));
        this.depot.addPackage(new Package(7, 100000, "Henk", "Mediamarkt"));
        this.depot.addPackage(new Package(8, 8000, "Henk", "BCC"));
        this.depot.addPackage(new Package(9, 200000, "Thomas", "Bol"));
        this.depot.addPackage(new Package(10, 20000, "Henk", "Bol"));
        this.depot.addPackage(new Package(11, 100000, "Henk", "Mediamarkt"));
        this.depot.addPackage(new Package(12, 8000, "Henk", "BCC"));
        this.depot.addPackage(new Package(13, 200000, "Thomas", "Bol"));

        // Add letters to the depot
        this.depot.addPackage(new Letter(14, "Henk", "Henk"));
        this.depot.addPackage(new Letter(15, "Thomas", "Belanstingsdienst"));
        this.depot.addPackage(new Letter(16, "Mark", "Bank"));
        this.depot.addPackage(new Letter(17, "Tom", "Gemeente"));

        // add deliverer to the depot
        this.depot.addDeliverer(this.thomas);
    }

    @Test
    void distributePackagesToDeliverersAndGetTotalRemainingPackages_1deliverer()
    {
        this.depot.distributePackagesToDeliverers();
        assertTrue(this.depot.getTotalRemainingPackages().size() > 0 && this.thomas.getPackages().size() > 0);
        assertTrue(this.thomas.getPackages().size() > 0);
    }

    @Test
    void distributePackagesToDeliverersAndGetTotalRemainingPackages_2deliverers()
    {
        this.depot.addDeliverer(this.tom);
        this.depot.distributePackagesToDeliverers();
        assertTrue(this.depot.getTotalRemainingPackages().size() > 0);
        assertTrue(this.thomas.getPackages().size() > 0);
        assertTrue(this.tom.getPackages().size() > 0);
    }

    @Test
    void distributePackagesToDeliverersAndGetTotalRemainingPackages_3deliverers()
    {
        this.depot.addDeliverer(this.tom);
        this.depot.addDeliverer(this.henk);
        this.depot.distributePackagesToDeliverers();
        assertTrue(this.depot.getTotalRemainingPackages().size() == 0);
        assertTrue(this.thomas.getPackages().size() > 0);
        assertTrue(this.tom.getPackages().size() > 0);
        assertTrue(this.henk.getPackages().size() > 0);
    }


    @Test
    void getExtraDeliverers_false()
    {
        this.depot.addDeliverer(tom);
        this.depot.addDeliverer(henk);
        this.depot.distributePackagesToDeliverers();
        assertFalse(this.depot.getExtraDeliverers());
    }

    @Test
    void getExtraDeliverers_true()
    {
        assertTrue(this.depot.getExtraDeliverers());
    }

    @Test
    void fireDeliverer()
    {
        this.depot.addDeliverer(tom);
        this.depot.addDeliverer(henk);
        this.depot.distributePackagesToDeliverers();
        assertTrue(this.depot.getTotalRemainingPackages().size() == 0);
        assertTrue(this.tom.getPackages().size() > 0);
        this.depot.fireDeliverer(tom);
        assertTrue(this.depot.getTotalRemainingPackages().size() > 0);
        assertTrue(this.tom.getPackages().size() == 0);
    }

    @Test
    void getPackageNumberWithDeliverer()
    {
        this.depot.addDeliverer(tom);
        this.depot.addDeliverer(henk);
        this.depot.distributePackagesToDeliverers();
        HashMap<Integer, String> packageNumberWithDeliverer = this.depot.getPackageNumberWithDeliverer();
        for(Deliverer deliverer : this.depot.getDeliverers())
        {
            for(Package packageLoop : deliverer.getPackages())
            {
                assertTrue(packageNumberWithDeliverer.containsKey(packageLoop.getPackageNumber()) && packageNumberWithDeliverer.containsValue(deliverer.getDelivererName()));
            }
        }

        assertEquals(packageNumberWithDeliverer.size(), 17);
    }
}