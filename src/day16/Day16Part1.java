package day16;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day16Part1 {

	public long execute() throws FileNotFoundException {
		ArrayList<String> inputList = readInput("resources/day16/input.txt");
		List<Sample> sampleList = initializeSamples(inputList);

		sampleList.forEach(this::testSample);

		return sampleList.stream()
				.filter(s -> s.possibleOpCodesList.size() >= 3)
				.count();

	}

	private ArrayList<String> readInput(String path) throws FileNotFoundException {
		ArrayList<String> inputList = new ArrayList<>();
		try (Scanner s = new Scanner(new FileReader(path))) {
			while (s.hasNext()) {
				inputList.add(s.nextLine());
			}
			return inputList;
		}
	}

	private List<Sample> initializeSamples(ArrayList<String> inputList) {

		List<Sample> sampleList = new ArrayList<>();
		for(int i = 0; i <inputList.size(); i+=4) {
			Device before = new Device(Stream.of(inputList.get(i).split(",")).map(Integer::parseInt).collect(Collectors.toList()));
			Instruct instruct = new Instruct(Stream.of(inputList.get(i+1).split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
			Device after = new Device(Stream.of(inputList.get(i+2).split(",")).map(Integer::parseInt).collect(Collectors.toList()));
			Sample sample = new Sample(before, instruct, after);
			sampleList.add(sample);
		}
		return sampleList;
	}

	private void testSample(Sample sample) {

		List<Integer> before = new ArrayList<>(sample.before.registers);
		opcodeOperations.addr(sample.instruct, before);
		if(before.equals(sample.after.registers))
			sample.possibleOpCodesList.add(opcodeOperation.addr);

		before = new ArrayList<>(sample.before.registers);
		opcodeOperations.addi(sample.instruct, before);
		if(before.equals(sample.after.registers))
			sample.possibleOpCodesList.add(opcodeOperation.addi);

		before = new ArrayList<>(sample.before.registers);
		opcodeOperations.mulr(sample.instruct, before);
		if(before.equals(sample.after.registers))
			sample.possibleOpCodesList.add(opcodeOperation.mulr);

		before = new ArrayList<>(sample.before.registers);
		opcodeOperations.muli(sample.instruct, before);
		if(before.equals(sample.after.registers))
			sample.possibleOpCodesList.add(opcodeOperation.muli);

		before = new ArrayList<>(sample.before.registers);
		opcodeOperations.banr(sample.instruct, before);
		if(before.equals(sample.after.registers))
			sample.possibleOpCodesList.add(opcodeOperation.banr);

		before = new ArrayList<>(sample.before.registers);
		opcodeOperations.bani(sample.instruct, before);
		if(before.equals(sample.after.registers))
			sample.possibleOpCodesList.add(opcodeOperation.bani);

		before = new ArrayList<>(sample.before.registers);
		opcodeOperations.borr(sample.instruct, before);
		if(before.equals(sample.after.registers))
			sample.possibleOpCodesList.add(opcodeOperation.borr);

		before = new ArrayList<>(sample.before.registers);
		opcodeOperations.bori(sample.instruct, before);
		if(before.equals(sample.after.registers))
			sample.possibleOpCodesList.add(opcodeOperation.bori);

		before = new ArrayList<>(sample.before.registers);
		opcodeOperations.setr(sample.instruct, before);
		if(before.equals(sample.after.registers))
			sample.possibleOpCodesList.add(opcodeOperation.setr);

		before = new ArrayList<>(sample.before.registers);
		opcodeOperations.seti(sample.instruct, before);
		if(before.equals(sample.after.registers))
			sample.possibleOpCodesList.add(opcodeOperation.seti);

		before = new ArrayList<>(sample.before.registers);
		opcodeOperations.gtir(sample.instruct, before);
		if(before.equals(sample.after.registers))
			sample.possibleOpCodesList.add(opcodeOperation.gtir);

		before = new ArrayList<>(sample.before.registers);
		opcodeOperations.gtri(sample.instruct, before);
		if(before.equals(sample.after.registers))
			sample.possibleOpCodesList.add(opcodeOperation.gtri);

		before = new ArrayList<>(sample.before.registers);
		opcodeOperations.gtrr(sample.instruct, before);
		if(before.equals(sample.after.registers))
			sample.possibleOpCodesList.add(opcodeOperation.gtrr);

		before = new ArrayList<>(sample.before.registers);
		opcodeOperations.eqir(sample.instruct, before);
		if(before.equals(sample.after.registers))
			sample.possibleOpCodesList.add(opcodeOperation.eqir);

		before = new ArrayList<>(sample.before.registers);
		opcodeOperations.eqri(sample.instruct, before);
		if(before.equals(sample.after.registers))
			sample.possibleOpCodesList.add(opcodeOperation.eqri);

		before = new ArrayList<>(sample.before.registers);
		opcodeOperations.eqrr(sample.instruct, before);
		if(before.equals(sample.after.registers))
			sample.possibleOpCodesList.add(opcodeOperation.eqrr);
	}

	private static class opcodeOperations {

		public static void addr(Instruct instruction, List<Integer> registers) {
			registers.set(instruction.outputC, registers.get(instruction.inputA) + registers.get(instruction.inputB));
		}

		public static void addi(Instruct instruction, List<Integer> registers) {
			registers.set(instruction.outputC, registers.get(instruction.inputA) + instruction.inputB);

		}

		public static void mulr(Instruct instruction, List<Integer> registers) {
			registers.set(instruction.outputC, registers.get(instruction.inputA) * registers.get(instruction.inputB));
		}

		public static void muli(Instruct instruction, List<Integer> registers) {
			registers.set(instruction.outputC, registers.get(instruction.inputA) * instruction.inputB);

		}

		public static void banr(Instruct instruction, List<Integer> registers) {
			registers.set(instruction.outputC, registers.get(instruction.inputA) & registers.get(instruction.inputB));
		}

		public static void bani(Instruct instruction, List<Integer> registers) {
			registers.set(instruction.outputC, registers.get(instruction.inputA) & instruction.inputB);
		}

		public static void borr(Instruct instruction, List<Integer> registers) {
			registers.set(instruction.outputC, registers.get(instruction.inputA) | registers.get(instruction.inputB));
		}

		public static void bori(Instruct instruction, List<Integer> registers) {
			registers.set(instruction.outputC, registers.get(instruction.inputA) | instruction.inputB);
		}

		public static void setr(Instruct instruction, List<Integer> registers) {
			registers.set(instruction.outputC, registers.get(instruction.inputA));
		}

		public static void seti(Instruct instruction, List<Integer> registers) {
			registers.set(instruction.outputC, instruction.inputA);
		}

		public static void gtir(Instruct instruction, List<Integer> registers) {
			if(instruction.inputA > registers.get(instruction.inputB))
				registers.set(instruction.outputC, 1);
			else
				registers.set(instruction.outputC, 0);
		}

		public static void gtri(Instruct instruction, List<Integer> registers) {
			if(registers.get(instruction.inputA) > instruction.inputB)
				registers.set(instruction.outputC, 1);
			else
				registers.set(instruction.outputC, 0);
		}

		public static void gtrr(Instruct instruction, List<Integer> registers) {
			if(registers.get(instruction.inputA) > registers.get(instruction.inputB))
				registers.set(instruction.outputC, 1);
			else
				registers.set(instruction.outputC, 0);
		}

		public static void eqir(Instruct instruction, List<Integer> registers) {
			if(instruction.inputA.equals(registers.get(instruction.inputB)))
				registers.set(instruction.outputC, 1);
			else
				registers.set(instruction.outputC, 0);
		}

		public static void eqri(Instruct instruction, List<Integer> registers) {
			if(registers.get(instruction.inputA).equals(instruction.inputB))
				registers.set(instruction.outputC, 1);
			else
				registers.set(instruction.outputC, 0);
		}

		public static void eqrr(Instruct instruction, List<Integer> registers) {
			if(registers.get(instruction.inputA).equals(registers.get(instruction.inputB)))
				registers.set(instruction.outputC, 1);
			else
				registers.set(instruction.outputC, 0);
		}

	}

	private class Device {
		public List<Integer> registers = new ArrayList<>();

		public Device(List<Integer> registers) {
			this.registers = registers;
		}
	}

	private class Instruct {

		public Integer opcode;

		public Integer inputA;

		public Integer inputB;

		public Integer outputC;

		public Instruct(List<Integer> instructList) {
			this.opcode = instructList.get(0);
			this.inputA = instructList.get(1);
			this.inputB = instructList.get(2);
			this.outputC = instructList.get(3);
		}

	}

	private class Sample {

		public Device before;

		public Instruct instruct;

		public Device after;

		public List<opcodeOperation> possibleOpCodesList = new ArrayList<>();

		public Sample(Device before, Instruct instruct, Device after) {
			this.before = before;
			this.instruct = instruct;
			this.after = after;
		}

		public Sample(Sample sample) {
			this.before = sample.before;
			this.instruct = sample.instruct;
			this.after = sample.after;
		}
	}

	enum opcodeOperation{
		addr,
		addi,
		mulr,
		muli,
		banr,
		bani,
		borr,
		bori,
		setr,
		seti,
		gtir,
		gtri,
		gtrr,
		eqir,
		eqri,
		eqrr;

	}

}


