import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class DelivererTest
{
    private Deliverer thomas;
    private Deliverer henk;
    private Deliverer tom;
    private HashSet<Package> packages;
    private Depot depot;

    @BeforeEach
    void init()
    {
        // construct deliverers
        this.thomas = new Deliverer(1, "Thomas", 60);
        this.thomas.addPackage(new Package(1, 50000, "Henk", "Jumbo"));
        this.thomas.addPackage(new Package(2, 40000, "Thomas", "Bol"));
        this.thomas.addPackage(new Package(3, 50000, "Mark", "Mediamarkt"));
        this.packages = new HashSet<>();
    }

    @Test
    void getMaxWeight_Weight60()
    {
        assertEquals(this.thomas.getMaxWeight(), 300000);
    }

    @Test
    void getWeightFromAllPackages_DelivererThomas()
    {
        assertEquals(this.thomas.getWeightFromAllPackages(), 140000);
    }

    @Test
    void getRemainingWeight()
    {
        assertEquals(this.thomas.getRemainingWeight(), 160000);
    }
}