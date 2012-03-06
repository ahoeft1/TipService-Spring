package tipservice;

public class BaggageServiceTipCalculator implements TipCalculator {
    private static final double MIN_BILL = 0.00;
    private static final double MAX_BILL = 100.00;
    private static final String BILL_ENTRY_ERR =
            "Error: bill must be between " + MIN_BILL + " and "
            + MAX_BILL;
    private static final double GOOD_RATE = 0.20;
    private static final double FAIR_RATE = 0.15;
    private static final double POOR_RATE = 0.10;

    private double baseTipPerBag;
    private int bagCount;
    // Share the global enum from TipService
    private TipService.ServiceQuality serviceQuality;

    public BaggageServiceTipCalculator(TipService.ServiceQuality q, int bags) {
        this.setServiceRating(q); // perform validation
        this.setBagCount(bags);

        baseTipPerBag = 1.00; // set default value
    }

    /** renamed to match Interface contract (a common behavior) */
    public double getTip() {
        double tip = 0.00; // always initialize local variables

        switch(serviceQuality) {
            case GOOD:
                tip = baseTipPerBag * bagCount * (1 + GOOD_RATE);
                break;
            case FAIR:
                tip = baseTipPerBag * bagCount * (1 + FAIR_RATE);
                break;
            case POOR:
                tip = baseTipPerBag * bagCount * (1 + POOR_RATE);
                break;
        }

        return tip;
    }

    public final void setServiceRating(TipService.ServiceQuality q) {
        // No need to validate because enums provide type safety!
        serviceQuality = q;
    }

    public TipService.ServiceQuality getServiceQuality() {
        return serviceQuality;
    }

    public int getBagCount() {
        return bagCount;
    }

    public final void setBagCount(int bagCount) {
        if(bagCount <= 0 || bagCount >= 10) {
            throw new IllegalArgumentException(
                    "bag count must be between 0 and 10");
        }
        this.bagCount = bagCount;
    }

    public double getBaseTipPerBag() {
        return baseTipPerBag;
    }

    public void setBaseTipPerBag(double baseTipPerBag) {
        if(baseTipPerBag <= 0 || baseTipPerBag >= 5.00) {
            throw new IllegalArgumentException(
                    "error: base tip must be between 0 and 5.00");
        }
        this.baseTipPerBag = baseTipPerBag;
    }

}
