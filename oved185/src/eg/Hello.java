package eg;

import java.time.LocalDate;

import java.time.Month;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Hello {
	public static void main(String[] args) {
		System.out.println("Hello @" + LocalDate.of(2019, Month.JANUARY, 1));
		
		System.out.println("Single is: " + findSingle(new int[] {2,2,1,1,3}));
	}
	// metodo che usa il sorting
	 public static int findSingle(int[]data) {   
		if(data==null || data.length < 1){
		  throw new IllegalArgumentException("Not enough elements in input!");
		  }
		if(data.length % 2 == 0){
		throw new IllegalArgumentException("Unexpated number of elements");
		}
		
		if(data.length == 1)
		 return data[0];
		
	    Arrays.sort(data);
		 
		for(int i = 0; i < data.length; i++) {
		  if(i == data.length -1){
		   return data[i];
		   }
		 if(data[i] != data[i+1]){
		   return data[i];
		   }
		  i += 1;
		}
		
		throw new IllegalArgumentException("Can't find single element");
		
	}
 
	/* mio tentativo di farlo con HashTable ma non so la sintassi quindi viene un pasticcio
	 * public static int findSingle(int[]data) {
		for(int i = 0; i < data.length; i++) {
			HashTable<int[],int[]>  table = new HashTable<data[],i> ;
		}
	 
	 
	 una soluzione approssimativa di questo tipo proposta dal prof
	 però al posto di unarray grezzo devo usare una hashmap
	 
	 public static int findSingle(int[]data) {
	 if(data == null){
	 throw new IllegalArgumentsException("No input data");
	 }
	 int counters[] = new int[10];
	 for(int i = 0; i < data.length; i++){
	  int cur = data[i];
	  if(cur < 0 || cur > 9) {
	   throw new IllegalArgumentException("Unespected value: " + cur);
	   }
	  counters[cur] += 1;
	 } 
	 for(int i = 0; 1 < counters.length; i++){
	  if(counters[i] == 1){
	   return i;
	   }
	 }  
	   throw new IllegalArgumentException("Can't find any single value");
	 }
	*/
	
public static int findSingle1(int[]data) {
	 if(data == null){
	 throw new IllegalArgumentException("No input data");
	 }
	 Map<Integer, Integer> counters = new HashMap<>();
	
	 /* counters.put(5,42);                                 Inciso per capire come usare la sintassi con HashMap
	 counters.get(5); // mi ritorna 42
	 if(counters.containsKey(5)) {
		 counters.put(5, 43);
	 }
	 
	 counters.put(5, counters.getOrDefault(5, 0) + 1);  */
	 
	 for(int i = 0; i < data.length; i++){                    // qui ho popolato la mappa che avevo creato
	  int cur = data[i];
	  counters.put(cur, counters.getOrDefault(cur, 0) + 1);   //i numeri uguali hanno la stessa key e poi ogni volta che ne inserisco uno aumenta il value 
	 } 
	 
	 Iterator<Map.Entry<Integer, Integer>> it = counters.entrySet().iterator(); 
	 Iterator <Integer> it = counters.keySet().iterator();
	 while(it.hasNext()) {
		Map.Entry<Integer, Integer> entry = it.next(); 
		 if(entry.getValue() == 1) {
			 return entry.getKey();
		 }
	 }
	/* Iterator<Integer> it = counters.keySet().iterator();   metodo alternativo
	 while(it.hasNext()) {
		 Integer key = it.next();
		 if(counters.get(key) == 1) {
			 return key;
		 }
	 }  */
	   throw new IllegalArgumentException("Can't find any single value");
	 }

}