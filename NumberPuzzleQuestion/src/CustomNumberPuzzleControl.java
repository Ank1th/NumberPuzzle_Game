import java.awt.*;

class CustomNumberPuzzleControl extends NumberPuzzleControl {
	public int getWidth() {
		return 200;
	}
	public int getHeight() {
		return 250;
	}
	public int getXPosition() {
		return 200;
	}
	public int getYPosition() {
		return 200;
	}
	public String getTitle(){
		return "Number Puzzle";
	}
	public int getShuffleButtonFontSize() {
		return 12;
	}
	public int getNumbersFontSize() {
		return 12;
	}
	public Color getEmptyButtonColor() {
		return Color.WHITE;
	}
	public String getWinnerMessage() {
		return "Congrats, you have won!";
	}

	// The following three methods have to be written by the participants...

	public int handleButtonClicked(NumberPuzzleGame game){
		int emptyCellId = game.getEmptyCellId();
		Button buttonClicked = game.getButtonClicked();
		Button[] buttons = game.getButtons();
		
		//Your logic here		
		Button emptyButton = new Button();
		int count = 0;
		for(Button i : buttons) {
			if(i == buttonClicked) {
				break;
			}
			count++;
		}
		if(count + 1 == emptyCellId && (count+1)%4 !=0 ||
				count -1 == emptyCellId && (count-1)%4 !=3 ||
				count + 4 == emptyCellId ||
				count - 4 == emptyCellId) {
			
			swapButton(buttons[emptyCellId], buttonClicked);
			emptyCellId = count;
		}
		return emptyCellId;

	}
	public int[] getRandomNumbersForGrid() {
		int arr[] = new int[15];
		
		int num = 0;
		while(num<15) {
			int a = getRandomNumber();
			boolean x = false;
			if(a<16 && a>0) {
				for(int i=0;i<=num;i++) {
					if(arr[i]==a) {
						x = true;
						break;
					}									
				}
				if(x==false) {
					arr[num]=a;
					num++;
				}
			}
		}
		
		
		return arr;
	}
	public boolean checkForWinner(Button[] buttons)
	{
		boolean winner = true;
		
		// Your Logic here
		int arr[]=getIntegerArrayOfButtonIds(buttons);
		for(int i=1; i<= 15; i++)
			if (arr[i] == i)
				return false;
		return winner;
	}
}