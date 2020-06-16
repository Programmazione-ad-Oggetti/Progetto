package esame.EsameProgrammazione.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import esame.EsameProgrammazione.model.Instruction;

/**
 * Classe che legge il file "Instruction.txt" e crea una lista di istruzioni
 * 
 * @author Colucci Antonio
 * @author Andreozzi Carmen
 */
public class InstructionReader extends Instruction {
	
	private static ArrayList<Instruction> listaIstruzioni = new ArrayList<Instruction>();

	/**
	 * Costruttore che legge il file "Instruction.txt" e riempie la lista di istruzioni
	 */
	public InstructionReader() {
		Instruction istruzione;
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Instruction.txt"));
			
			String[] istruzioni = reader.readLine().split("&");
			int i = 0;
			while(i < istruzioni.length) {
				
				istruzione = new Instruction(); 
				istruzione.setIntroduzione(istruzioni[i]);
				i++;
				
				String[] array = istruzioni[i].split(";");
				istruzione.setScelta(array);
				i++;
				listaIstruzioni.add(istruzione);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException s) {
			s.printStackTrace();
		}
	}

	/**
	 * @return La lista delle istruzioni
	 */
	public static ArrayList<Instruction> getInstructions() {
		return listaIstruzioni;
	}
}
