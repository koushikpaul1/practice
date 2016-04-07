package setGroupingComparator;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

/**
 * Compares the composite key, {@link StockKey}.
 * We sort by symbol ascendingly and timestamp
 * descendingly.
 * @author Jee Vang
 *
 */
public class CompositeKeyComparator extends WritableComparator {

	/**
	 * Constructor.
	 */
	protected CompositeKeyComparator() {
		super(StockKey.class, true);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public int compare(WritableComparable w1, WritableComparable w2) {
		StockKey k1 = (StockKey)w1;
		StockKey k2 = (StockKey)w2;
		
		int result = k1.getSymbol().compareTo(k2.getSymbol());
		if(0 == result) {
			result = -1* k1.getTimestamp().compareTo(k2.getTimestamp());
		}
		return result;
	}
}

