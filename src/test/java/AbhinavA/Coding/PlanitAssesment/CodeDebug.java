package AbhinavA.Coding.PlanitAssesment;

import java.text.DecimalFormat;
import java.util.HashMap;

public class CodeDebug {

	public static HashMap<String,String> Session;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String a="$10.0147";
//		System.out.println(a.replace("$", ""));
//		float f;
//		f=Float.parseFloat(a.replace("$", ""));
//		System.out.println(a);
//		System.out.println(f);
//		DecimalFormat df_obj = new DecimalFormat("#.##");
//		System.out.println(df_obj.format(f*f));
		
		setsessionParameter("ABCd", "abcde");
		System.out.println("Session Value :" + getsessionParameter("ABCd"));
		
		setsessionParameter("Quantity", "2");
		int frogQuantity = Integer.parseInt(getsessionParameter("Quantity"));
		System.out.println("Quantity Session Value :" + frogQuantity);
		

	}
	
	
	public static void setsessionParameter(String ParameterName, String ParameterValue) {
		Session = new HashMap<String, String>();

		Session.put(ParameterName,ParameterValue);
		}
	
	public static String getsessionParameter(String ParameterName) {
		
		if(Session.get(ParameterName)== null)
			return "'" + ParameterName + "' does not exist in session";
		
		else
		return Session.get(ParameterName);
	}

}
