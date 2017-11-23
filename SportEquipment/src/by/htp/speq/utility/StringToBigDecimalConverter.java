package by.htp.speq.utility;

import java.math.BigDecimal;

public class StringToBigDecimalConverter {

	public static BigDecimal convertStringToBigDecimal(String string) {
		BigDecimal bigDecimal = BigDecimal.valueOf(Double.parseDouble(string));
		return bigDecimal;
	}

}
