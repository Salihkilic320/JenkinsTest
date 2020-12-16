package com;

/**
 * A package which can be delivered to the depot and then added to a deliverer.
 */
public class Package
{
    private int packageNumber;
    private double weight;
    private String sender;
    private String receiver;

    /**
     *
     * @param packageNumber The number of the package.
     * @param weight The weight of the package.
     * @param sender The sender of the package.
     * @param receiver The receiver of the package.
     */
    public Package(int packageNumber, double weight, String sender, String receiver)
    {
        this.packageNumber = packageNumber;
        this.weight = weight;
        this.sender = sender;
        this.receiver = receiver;
    }

    public int getPackageNumber()
    {
        return packageNumber;
    }

    public void setPackageNumber(int packageNumber)
    {
        this.packageNumber = packageNumber;
    }

    public double getWeight()
    {
        return weight;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public String getSender()
    {
        return sender;
    }

    public void setSender(String sender)
    {
        this.sender = sender;
    }

    public String getReceiver()
    {
        return receiver;
    }

    public void setReceiver(String receiver)
    {
        this.receiver = receiver;
    }
}
