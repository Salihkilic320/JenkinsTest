package com;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * This is a depot from postnl it distributes the packages to the deliverer.
 */
public class Depot
{
    private int depotNumber;
    private String depotName;
    private HashSet<Deliverer> deliverers;
    private HashSet<Package> packages;

    public Depot(int depotNumber, String depotName)
    {
        this.depotNumber = depotNumber;
        this.depotName = depotName;
        this.packages = new HashSet<>();
        this.deliverers = new HashSet<>();
    }

    public int getDepotNumber()
    {
        return depotNumber;
    }

    public void setDepotNumber(int depotNumber)
    {
        this.depotNumber = depotNumber;
    }

    public String getDepotName()
    {
        return depotName;
    }

    public void setDepotName(String depotName)
    {
        this.depotName = depotName;
    }

    public HashSet<Deliverer> getDeliverers()
    {
        return deliverers;
    }

    public HashSet<Package> getPackages()
    {
        return packages;
    }

    /**
     * Adds a deliverer to the depot.
     * @param deliverer The deliverer to be added.
     */
    public void addDeliverer(Deliverer deliverer)
    {
        this.deliverers.add(deliverer);
    }

    /**
     * Deletes a deliverer from the depot and return all the packages to the depot the deliverer was carying.
     * @param deliverer the deliverer to be removed.
     */
    public void fireDeliverer(Deliverer deliverer)
    {
        for(Package packageLoop : deliverer.getPackages())
        {
            this.packages.add(packageLoop);
        }
        deliverer.getPackages().clear();
        this.deliverers.remove(deliverer);
    }

    /**
     * Adds a package to the depot
     * @param packageToAdd package to add
     */
    public void addPackage(Package packageToAdd)
    {
        this.packages.add(packageToAdd);
    }

    /**
     * removes a package from the depot.
     * @param packageToRemove package to be removed.
     */
    public void removePackage(Package packageToRemove)
    {
        this.packages.remove(packageToRemove);
    }

    /**
     * distributes all the packages to the deliverers who work at the depot.
     * When a package is added to a deliverer it is removed from the depot.
     * A package can only be added to the deliverer if the max weight the deliverer can carry isn't exceeded when the package is added.
     */
    public void distributePackagesToDeliverers()
    {
        for(Deliverer deliverer : this.deliverers)
        {
            Iterator<Package> it = this.packages.iterator();
            while(it.hasNext())
            {
                Package currentPackage = it.next();
                // if the weight of a remainingweight of the deliverer is higher than te weight of the package
                // it will be added to the deliverer and removed from the depot.
                if(deliverer.getRemainingWeight() > currentPackage.getWeight())
                {
                    deliverer.addPackage(currentPackage);
                    it.remove();
                }
            }
        }
    }

    /**
     * Returns all the packages which are still in the depot.
     * @return All the packages in the depot.
     */
    public HashSet<Package> getTotalRemainingPackages()
    {
        return this.packages;
    }

    /**
     * Checks if there are extra deliverers needed.
     * returns true or false depended on how many packages are in the depot.
     * If there are 0 packages it return false else it return true.
     * @return If there are extra deliverers needed (true or false).
     */
    public boolean getExtraDeliverers()
    {
        return this.packages.size() > 0;
    }

    /**
     * Returns the a hashmap with the packagenumber and the deliverer who is carying the package.
     * @return A hashmap with the packagenumber and the deliverer is carying.
     */
    public HashMap<Integer, String> getPackageNumberWithDeliverer()
    {
        HashMap<Integer, String> packageNumberWithDeliverer = new HashMap<>();
        for(Deliverer deliverer : this.deliverers)
        {
            for(Package packageLoop : deliverer.getPackages())
            {
                packageNumberWithDeliverer.put(packageLoop.getPackageNumber(), deliverer.getDelivererName());
            }
        }

        return packageNumberWithDeliverer;
    }
}
