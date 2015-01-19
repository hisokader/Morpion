public class Player {
	private final String playerName;
	private final String code;
	private int playCount;

	public Player(String playerName, String code, int playCount) {
		this.playerName=playerName;
		this.code = code;
		this.playCount = playCount;
	}

	public void printCode(StringBuilder value) {
		value.append(code);
	}

	public void discountPlayCount() {
		playCount--;
	}

	public boolean isPlayCountOver() {
		return playCount > 0 ? false : true;
	}

	public void reportState(MorpionRepotere reporter) {
		reporter.printCurrentResult(playerName,code,playCount);
	}
}
