package esame.EsameProgrammazione.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import esame.EsameProgrammazione.model.Instruction;

public class InstructionReader extends Instruction {
	
	private static ArrayList<Instruction> listaIstruzioni = new ArrayList<Instruction>();

	public InstructionReader() {
		Instruction istruzione;
		try {
			BufferedReader reader = new BufferedReader(new FileReader("Instruction.txt"));
			
			String[] istruzioni = reader.readLine().split("&");
			for(int i = 0; i < istruzioni.length; i++) {
				
				istruzione = new Instruction(); 
				istruzione.setIntroduzione(istruzioni[i]);
				i++;
				
				String[] array = istruzioni[i].split(";");
				istruzione.setScelta(array);
				listaIstruzioni.add(istruzione);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException s) {
			s.printStackTrace();
		}
	}

	public static ArrayList<Instruction> getInstructions() {
		return listaIstruzioni;
	}
}
