import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Morpion {

	public static final String LINE_SEPARATOR = System
			.getProperty("line.separator");
	private final Map<String, Player> players;
	private final Player[][] playCard;

	public Morpion(String string, String string2, String string3) {
		final InputParser inputParser = new InputParser();
		players = new HashMap<String, Player>();
		final String player1Name = inputParser.getPlayerName(string2);
		final String player1Code = inputParser.getPlayerCode(string2);
		final String player2Name = inputParser.getPlayerName(string3);
		final String player2Code = inputParser.getPlayerCode(string3);
		final int dimenssion = inputParser.getCardDimention(string);
		int maxPlayCount = 0;
		maxPlayCount = (dimenssion*dimenssion) / 2;
		if (dimenssion % 2 == 0)
			players.put(player1Name, new Player(player1Name, player1Code,maxPlayCount));
		else
			players.put(player1Name, new Player(player1Name, player1Code,maxPlayCount + 1));
		players.put(player2Name, new Player(player2Name, player2Code,
				maxPlayCount));

		playCard = new Player[dimenssion][dimenssion];
	}

	public void play(String string, String string2) {
		final InputParser inputParser = new InputParser();
		final int x = inputParser.getX(string2);
		final int y = inputParser.getY(string2);
		if (playCard[x][y] != null)
			throw new BoxAlreadySelectedException();
		playCard[x][y] = players.get(string);
		players.get(string).discountPlayCount();
	}

	public String report() {
		if (isThereAnyRoundToPlay()) {
			return reportBeforeEnd();
		}else{
			return reportEquality();
		}
	}

	private String reportEquality() {
		MorpionRepotere reporter = new MorpionRepotere();
		return reporter.reportEquality();
	}

	private String reportBeforeEnd() {
		final MorpionRepotere reporter = new MorpionRepotere();
		final Collection<Player> playersInformation = players.values();
		for (Player player : playersInformation) {
			player.reportState(reporter);
		}
		return reporter.reportGameUntileNow();
	}

	private boolean isThereAnyRoundToPlay() {
		final Collection<Player> playersInformation = players.values();
		for (Player player : playersInformation) {
			if (player.isPlayCountOver())
				return false;
		}
		return true;
	}

	public String display() {
		final MorpionRepotere reporter = new MorpionRepotere();
		for (Player[] line : playCard) {
			reporter.addLine(line);
		}
		return reporter.report();
	}

}
