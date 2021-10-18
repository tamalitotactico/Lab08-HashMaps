package Laboratorio8;

import java.util.*;

public class Main {
	public static void main(String [] args){
		
		
		HashMap<Integer, Paquete> paquetes = new HashMap<Integer,Paquete>();
		llenarHash1(paquetes);
		HashMap<Integer, String[]> estados = new HashMap<Integer,String[]>();
		llenarHash2(paquetes);

/*
		for (Integer i : paquetes.keySet()) {
			System.out.print("edad: "+i+" valor: \n");
			ImprimirArreglo(paquetes.get(i));
		} */
	}
	
	public static void llenarHash1(HashMap<Integer,Paquete> paquetes) {
		for (int i=0;i<20;i++) {
			Paquete pack = new Paquete();
			pack.setName("Paquete"+i);
			pack.setCosto((Math.random()*100+1));
			pack.setKilo((int)(Math.random()*20+1));
			paquetes.put(i, pack);
		}
	}
	
	public static void llenarHash2(HashMap<Integer,String[]> estados,int i,int j) {

		System.out.print("Ingresar el estado del paquete (Recibido=0 ; EnProgreso=1 ; Entregado=2 ; FalloEntrega=3):");
		Scanner sc = new Scanner(System.in);
		String [] estado;
		estado [j] = sc.next();
		switch(estado) {
			case 0: estados.put(i, estado);
			case 1: ;
			case 2: ;
			case 3: ;
		}
	}
	
	public static void ImprimirArreglo(String[]arreglo) {
		for(int i=0;i< arreglo.length;i++) {
			System.out.println(arreglo[i]);
		}
	}
}