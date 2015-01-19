public class MorpionRepotere {
	private final StringBuilder value;
	
	public MorpionRepotere() {
		this.value = new StringBuilder();
	}

	public void addLine(Player[] line) {
		for (Player player : line) {
			player.printCode(value);
			value.append("|");
		}	
		value.deleteCharAt(value.length()-1).append(Morpion.LINE_SEPARATOR);	
	}

	public String report() {
		return value.toString();
	}

	public void printCurrentResult(String playerName, String code, int playCount) {
		value.append(", ");
		value.append(playCount+"games for "+playerName);	
	}

}
