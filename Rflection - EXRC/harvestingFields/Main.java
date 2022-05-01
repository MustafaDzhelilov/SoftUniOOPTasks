package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.function.Consumer;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Field> tokens = Arrays.asList(RichSoilLand.class.getDeclaredFields());

		Map<Commands, List<Field>> modifierFileMap = getMap(tokens);

		Consumer<Field> printer = field -> {
			StringBuilder builder = new StringBuilder();
			builder.append(Modifier.toString(field.getModifiers())).append(" ").append(field.getType().getSimpleName()).append(" ").append(field.getName());
			System.out.println(builder.toString());
		};

		fillMapWithFields(tokens, modifierFileMap);

		String input = sc.nextLine();

		while (!input.equals("HARVEST")){

			switch (input){
				case "private":
					modifierFileMap.get(Commands.PRIVATE).forEach(field -> printer.accept(field));
					break;
				case "public":
					modifierFileMap.get(Commands.PUBLIC).forEach(field -> printer.accept(field));
					break;
				case "protected":
					modifierFileMap.get(Commands.PROTECTED).forEach(field -> printer.accept(field));
					break;
				case "all":
					modifierFileMap.get(Commands.ALL).forEach(field -> printer.accept(field));

			}

			input = sc.nextLine();
		}


	}

	private static void fillMapWithFields(List<Field> tokens, Map<Commands, List<Field>> modifierFileMap) {
		for (Field field : tokens) {
			String modifier = Modifier.toString(field.getModifiers());
			switch (modifier){
				case "public":
					modifierFileMap.get(Commands.PUBLIC).add(field);
					break;
				case "private":
					modifierFileMap.get(Commands.PRIVATE).add(field);
					break;
				case "protected":
					modifierFileMap.get(Commands.PROTECTED).add(field);
					break;
			}
		}
	}

	private static Map<Commands, List<Field>> getMap(List<Field> tokens) {
		Map<Commands, List<Field>> modifierFileMap = new LinkedHashMap<>();
		modifierFileMap.put(Commands.PRIVATE,new ArrayList<>());
		modifierFileMap.put(Commands.PROTECTED, new ArrayList<>());
		modifierFileMap.put(Commands.PUBLIC, new ArrayList<>());
		modifierFileMap.put(Commands.ALL, tokens);
		return modifierFileMap;
	}
}
