package uf1;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class VeureInfo {
	public static void main(String[] args) {
		 System.out.println("INFORMACIÓ SOBRE EL FITXER");
		 File f = new File(args[0]);
		 
		 if(f.exists()){
			 Calendar dataModificacio = new GregorianCalendar();
			 dataModificacio.setTimeInMillis(f.lastModified());
			 String data = "" + dataModificacio.get(Calendar.DATE) + "/" + dataModificacio.get(Calendar.MONTH)+1 + "/"
			 + dataModificacio.get(Calendar.YEAR);
			 System.out.println("Es un directori: "+f.isDirectory());
			 System.out.println("Es un fitxer: "+f.isFile());
			 System.out.println("Es un fitxer ocult: "+f.isHidden());
			 System.out.println("Darrera modificació: "+ data);
			 if (modificacio(f, dataModificacio)) {
				System.out.println("Modificat en els últims 3 dies"  );
			}
			 

		 } else {
			 System.out.println("El directori o fitxer no existeix.");
		 }
	}
	
	// Metode que comprovara si el fitxer s'ha modificat en els últims 3 dies
	public static boolean modificacio(File f, Calendar dataModificacio) {
		
		Calendar dataActual = new GregorianCalendar();
		boolean modidicacio = false;
		// Comprovem si el fitxer ha estat modificat en els últims 3 dies
		if (dataActual.get(Calendar.YEAR) == dataModificacio.get(Calendar.YEAR)) {
			if (dataActual.get(Calendar.MONTH) == dataModificacio.get(Calendar.MONTH)) {
				if (dataActual.get(Calendar.DATE)-3 <= dataModificacio.get(Calendar.DATE)) {
					modidicacio = true;
				}
			}
		}
		
		return modidicacio;
	}
	
}
