package com;

import java.util.HashSet;
/**
 * A deliverer works for postnl and can be added to a depot.
 */
public class Deliverer
{
    private int delivererNumber;
    private String delivererName;
    private double delivererWeight;
    private HashSet<Package> packages; // all the packages the deliverer is carying

    /**
     * Creates the instance of a deliverer.
     * @param delivererNumber The number of the deliverer.
     * @param delivererName The name of the deliverer.
     * @param delivererWeight The weight of the deliverer it is used to calculate the max weight the deliverer can carry.
     */
    public Deliverer(int delivererNumber, String delivererName, double delivererWeight)
    {
        this.delivererNumber = delivererNumber;
        this.delivererName = delivererName;
        this.delivererWeight = delivererWeight;
        this.packages = new HashSet<>();
    }

    /**
     * Returns the name of the deliverer.
     * @return The name of the deliverer.
     */
    public int getDelivererNumber()
    {
        return delivererNumber;
    }

    /**
     * Sets the number of the deliverer.
     * @param delivererNumber The number the delivererNumber is set to.
     */
    public void setDelivererNumber(int delivererNumber)
    {
        this.delivererNumber = delivererNumber;
    }

    /**
     * Returns the name of the deliverer.
     * @return The name of the deliverer.
     */
    public String getDelivererName()
    {
        return delivererName;
    }

    /**
     * Sets the name of the deliverer.
     * @param delivererName The name the delivererName is set to.
     */
    public void setDelivererName(String delivererName)
    {
        this.delivererName = delivererName;
    }

    /**
     * Returns the weight of the deliverer.
     * @return The weight of the deliverer.
     */
    public double getDelivererWeight()
    {
        return delivererWeight;
    }

    /**
     * Sets the weight of the deliverer.
     * @param delivererWeight the Weight the deliverer is set to.
     */
    public void setDelivererWeight(double delivererWeight)
    {
        this.delivererWeight = delivererWeight;
    }

    /**
     * Returns all the packages the deliverer is carying.
     * @return All the packages the deliverer is carying.
     */
    public HashSet<Package> getPackages()
    {
        return this.packages;
    }

    /**
     * Adds the given package to the packages the deliverer is carying.
     * @param packageToAdd The package to be added to the packages the deliverer is carying.
     */
    public void addPackage(Package packageToAdd)
    {
        this.packages.add(packageToAdd);
    }

    /**
     * Removes the given package from the packages the deliverer is currently carying.
     * @param packageToRemove The package to be removed from the packages the deliverer is carying.
     */
    public void removePackage(java.lang.Package packageToRemove)
    {
        this.packages.remove(packageToRemove);
    }

    /**
     * calculates the max weight the deliverer can carry. This is the weight of the deliverer times 5 and times 1000 to return it in grams
     * @return return the max weight the deliverer can carry
     */
    public double getMaxWeight()
    {
        return this.delivererWeight * 5 * 1000;
    }

    /**
     * Gets the weight of all the packages the deliverer is carying.
     * @return The weight of all packages the deliverer is carying.
     */
    public double getWeightFromAllPackages()
    {
        int totalWeight = 0;
        // Loop through all the packages and adds the weight of the packages to the totalWeight.
        for(Package packageLoop : this.packages)
        {
            totalWeight += packageLoop.getWeight();
        }
        return totalWeight;
    }

    /**
     * Gets the remaining weight the deliverer can carry.
     * @return The remaining weight the deliverer can carry.
     */
    public double getRemainingWeight()
    {
        return getMaxWeight() - getWeightFromAllPackages();
    }
}
