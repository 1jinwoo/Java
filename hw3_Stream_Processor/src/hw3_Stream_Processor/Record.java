
/**
 * @author Jin Woo Won - jw3580
 * Interface for two record classes that store records.
 */
public interface Record {
	public java.util.Iterator<String> createIterator();
	public int getSize();
}
