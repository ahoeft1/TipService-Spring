package tipservice;

/**
 * The general contract for all TipCalculator sub-classes (the
 * low-level classes in the DIP). Notice only common methods are
 * declared here so we can use the sub-class instances polymorphically.
 *
 * The DIP says that both high-level and low-level classes should be
 * dependent only on abstractions. Nothing is more abstract than an
 * Interface.
 *
 * @author Jim Lombardo, instructor
 */
public interface TipCalculator {

    public abstract TipService.ServiceQuality getServiceQuality();

    public abstract double getTip();

    public abstract void setServiceRating(TipService.ServiceQuality q);

}
