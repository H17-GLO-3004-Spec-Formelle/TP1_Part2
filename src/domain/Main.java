package domain;

import java.util.HashMap;

public class Main {
	
	private static HashMap<String, Integer> configs;

	public static void main(String[] args) {
		configs = new HashMap<>();
		
		for (int i = 0; i < args.length - 1; i++) {
			switch (args[i].charAt(0)) {
				case '-':
					String key = args[i].substring(1, args[i].length());
					int value = Integer.parseInt(args[i+1]);
					configs.put(key, value);
					break;
			}
		}
		
	}

}
