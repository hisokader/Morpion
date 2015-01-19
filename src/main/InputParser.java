
public class InputParser {

	public String getPlayerName(String string2) {
		final String[] nameAndCode=string2.split(":");
		return nameAndCode[0];
	}

	public String getPlayerCode(String string2) {
		final String[] nameAndCode=string2.split(":");
		return nameAndCode[1];
	}
	
	public int getCardDimention(String string2) {
		final char dimention=string2.charAt(0);
		return Integer.parseInt(dimention+"");
	}
	
	public int getX(String position){
		final String[] xAndY=position.split("x");
		return Integer.parseInt(xAndY[0]);
	}
	
	public int getY(String position){
		final String[] xAndY=position.split("x");
		return Integer.parseInt(xAndY[1]);
	}

}
