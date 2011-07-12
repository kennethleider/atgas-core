package org.atgas.store;

public class StandardUtils {
	public static final String FieldSeperator = "~";
	
	public enum Multiplicity {
		Single,
		Multiple,
		Ordered
	}
	
	public enum Requirement {
		Required, 
		Optional
	}
	
	public enum Type {
		String,
		Integer,
		Date
	}
	
	public static String joinFields(String...fields) {
		StringBuffer retval = new StringBuffer();
		for (String field : fields) {
			retval.append(field).append(FieldSeperator);
		}
		retval.deleteCharAt(retval.length() - 1);
		
		return retval.toString();
	}
	
	public static String formatField(String fieldName, Type type, Requirement requirement, Multiplicity multiplicity) {
		StringBuffer retval = new StringBuffer();
		retval.append(fieldName);
		
		switch (type) {
		case String:			
			retval.append("(s)");
			break;
		case Integer:
			retval.append("(i)");			
			break;
		case Date:
			retval.append("(d)");			
			break;			
		default:
			throw new IllegalStateException("Type has been updated without updating the formatField() method");
		}
	
		switch (requirement) {
		case Required:
			retval.append("(r)");
			break;
		case Optional:
			retval.append("(o)");
			break;
		default:
			throw new IllegalStateException("Requirement has been updated without updating the formatField() method");
		}
		
		switch (multiplicity) {
		case Single:
			retval.append("(s)");
			break;
		case Ordered:
			retval.append("(o)");
			break;
		case Multiple:
			retval.append("(m)");
			break;			
		default:
			throw new IllegalStateException("Multiplicity has been updated without updating the formatField() method");		
		}
		
		return retval.toString();		
	}
}
