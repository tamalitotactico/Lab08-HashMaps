package Laboratorio8;

import java.util.*;
public class Main {
	public static void main(String [] args){
		
		Scanner sc = new Scanner(System.in);
		
		HashMap<Integer, Paquete> paquetes = new HashMap<Integer,Paquete>();
		HashMap<Integer, ArrayList<String>> estadosPaquetes = new HashMap<Integer,ArrayList<String>>();
		llenarHash1(paquetes);

		for (int i=0;;) {
			
			System.out.println("MENÚ: ¿Que desea hacer? (Mostrar todos los paquetes = 0 ; "
					+ "Registrar un estado = 1 ; Mostrar los paquetes segun estado = 2)");
			int num1 = sc.nextInt();
			
			switch (num1) {
				case 0:{
					for (Integer j : paquetes.keySet()) {
						ImprimirPaquete(paquetes,estadosPaquetes,j);
					}
				}
				break;
				case 1: {
					llenarHash2(estadosPaquetes);
				}
				break;
				case 2:{
					ImprimirPaquetesPorTipo(paquetes,estadosPaquetes);
				}
			}
		}
	}
	
	public static void llenarHash1(HashMap<Integer,Paquete> paquetes) {
		
		for (int i=0;i<20;i++) {
			Paquete pack = new Paquete();
			pack.setName("Paquete"+i);
			pack.setCosto((double)(Math.round((Math.random()*100+1)*100))/100);
			pack.setKilo((int)(Math.random()*20+1));
			paquetes.put(i, pack);
		}
	}
	
	public static void llenarHash2(HashMap<Integer,ArrayList<String>> estadosPaquetes) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<String> status = new ArrayList<String>();

		System.out.println("\nIngrese el identificador del paquete:");
		int i = sc.nextInt();
		
		System.out.println("Ingresar el estado del paquete (Recibido=0 ; EnProgreso=1 ; Entregado=2 ; FalloEntrega=3):");
		int estado = sc.nextInt();
		switch(estado) {
			case 0: {
				status.add("Recibido");
				estadosPaquetes.put(i,status);
			}
			break;
			case 1: {
				status.add("EnProgreso");
				estadosPaquetes.put(i,status);
			}
			break;
			case 2: {
				status.add("Entregado");
				estadosPaquetes.put(i,status);
			}
			break;
			case 3: {
				status.add("FalloEntrega");
				estadosPaquetes.put(i,status);
			}
			break;
		}
		
		System.out.println(estadosPaquetes.get(i));

	}
	
	public static void ImprimirPaquete(HashMap<Integer, Paquete> paquetes,HashMap<Integer, ArrayList<String>> estadosPaquetes,int j) {
		System.out.println("Identificador: "+j);
		System.out.println("Nombre: "+paquetes.get(j).getName());
		System.out.println("Costo: "+paquetes.get(j).getCosto());
		System.out.println("Peso: "+paquetes.get(j).getKilo());
		System.out.println("Estado: "+estadosPaquetes.get(j)+"\n");
		
	}
	
	public static void ImprimirPaquetesPorTipo(HashMap<Integer, Paquete> paquetes,HashMap<Integer, ArrayList<String>> estadosPaquetes) {
		
		System.out.println("\nPaquetes Recibidos: ");
		for (Integer k : paquetes.keySet()) {
			FiltrarRecibido(paquetes,estadosPaquetes,k);
		}

		System.out.println("\nPaquetes En Progreso: ");
		for (Integer k : paquetes.keySet()) {
			FiltrarEnProgreso(paquetes,estadosPaquetes,k);
		}
		
		System.out.println("\nPaquetes Entregados: ");
		for (Integer k : paquetes.keySet()) {
			FiltrarEntregado(paquetes,estadosPaquetes,k);
		}
		
		System.out.println("\nFallo de Entrega: ");
		for (Integer k : paquetes.keySet()) {
			FalloEntrega(paquetes,estadosPaquetes,k);
		}
	}
	
	public static void FiltrarRecibido(HashMap<Integer, Paquete> paquetes,HashMap<Integer, ArrayList<String>> estadosPaquetes,int k) {
		ArrayList<String> busqueda;
		busqueda = estadosPaquetes.get(k);
		
		for (int i=0;estadosPaquetes.get(k)!=null && i<estadosPaquetes.get(k).size();i++) {
			if (busqueda.get(i).equals("Recibido")) {
				ImprimirPaquete(paquetes,estadosPaquetes,k);
			}	
		}
	}
	
	public static void FiltrarEnProgreso(HashMap<Integer, Paquete> paquetes,HashMap<Integer, ArrayList<String>> estadosPaquetes,int k) {
		ArrayList<String> busqueda;
		busqueda = estadosPaquetes.get(k);
		
		for (int i=0;estadosPaquetes.get(k)!=null && i<estadosPaquetes.get(k).size();i++) {
			if (busqueda.get(i).equals("EnProgreso")) {
				ImprimirPaquete(paquetes,estadosPaquetes,k);
			}	
		}
	}
	
	public static void FiltrarEntregado(HashMap<Integer, Paquete> paquetes,HashMap<Integer, ArrayList<String>> estadosPaquetes,int k) {
		ArrayList<String> busqueda;
		busqueda = estadosPaquetes.get(k);
		
		for (int i=0;estadosPaquetes.get(k)!=null && i<estadosPaquetes.get(k).size();i++) {
			if (busqueda.get(i).equals("Entregado")) {
				ImprimirPaquete(paquetes,estadosPaquetes,k);
			}	
		}
	}
	
	public static void FalloEntrega(HashMap<Integer, Paquete> paquetes,HashMap<Integer, ArrayList<String>> estadosPaquetes,int k) {

		for (int i=0;estadosPaquetes!=null;i++) {
			if (paquetes.get(i)!=null) {
				ImprimirPaquete(paquetes,estadosPaquetes,i);
			}
		}
	}
}