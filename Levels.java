public class Levels {

    private int level;
    private int[][] desktop;
    private String path;

    Levels() {
	level = 0; 
    }

    public int[][] nextLevel() {

	desktop = null;
	switch(level) {

		case 1:
			desktop = firstLevel();
		break;
		
		case 2:
			desktop = secondLevel();
		break;

		case 3:
			desktop = thridLevel();
		break;

		case 4:
			desktop = level4();
		break;

		case 5:
			desktop = level5();
		break;

		case 6:
			desktop = loadLevel("levels/level6.txt");
		break;

		case 7:
			desktop = loadLevel("levels/level7.txt");
		break;

		case 8:
			desktop = loadLevel("levels/level8.txt");
		break;

		case 100:
			path = Model.getLevelPath();
			desktop = loadNewLevel(path);
			level--;
		break;

		default:
		level = 1;
		desktop = firstLevel();
	} 
	level++;
	return desktop;

    }

    public int[][] selectLevel(int chooseLevel) {  
	switch(chooseLevel) {
		case 1:
			level = 2;
			desktop = firstLevel();
		break;

		case 2:
			level = 3;
			desktop = secondLevel();
		break;

		case 3:
			level = 4;
			desktop = thridLevel();
		break;

		case 4:
			level = 5;
			desktop = level4();
		break;

		case 5:
			level = 6;
			desktop = level5();
		break;

		case 6:
			level = 7;
			desktop = loadLevel("levels/level6.txt");
		break;

		case 7:
			level = 8;
			desktop = loadLevel("levels/level7.txt");
		break;
		case 8:
			level = 9;
			desktop = loadLevel("levels/level8.txt");
		break;
	}
	return desktop;
	}

    public int[][] restart() {
    level--;
    nextLevel();
    return desktop;
	}

    private int[][] firstLevel() {
	int[][] newDesktop = 
				{
				{7, 6, 6, 6, 6, 6, 6, 6, 6, 9},
				{5, 1, 0, 3, 0, 4, 0, 0, 0, 5},
				{5, 0, 0, 3, 0, 4, 0, 0, 0, 5},
				{5, 0, 0, 0, 0, 0, 0, 0, 0, 5},
				{5, 0, 0, 0, 0, 0, 0, 0, 0, 5},
				{5, 0, 0, 0, 0, 0, 0, 0, 0, 5},
				{5, 0, 0, 0, 0, 0, 0, 0, 0, 5},
				{5, 0, 0, 0, 0, 0, 0, 0, 0, 5},
				{5, 0, 0, 0, 0, 0, 0, 0, 0, 5},
				{8, 6, 6, 6, 6, 6, 6, 6, 6,10}
				};

	return newDesktop;

    }

    private int[][] secondLevel() {
	int[][] newDesktop = 
				{
				{7, 6, 6, 6, 6, 6, 6, 6, 6, 9},
				{5, 0, 0, 0, 0, 0, 0, 0, 0, 5},
				{5, 0, 0, 0, 0, 0, 0, 0, 0, 5},
				{5, 0, 0, 0, 0, 0, 0, 0, 0, 5},
				{5, 0, 0, 0, 0, 0, 0, 0, 0, 5},
				{5, 0, 0, 0, 0, 0, 0, 0, 0, 5},
				{5, 0, 0, 0, 0, 0, 0, 0, 0, 5},
				{5, 0, 0, 0, 0, 0, 0, 0, 0, 5},
				{5, 1, 0, 0, 0, 0, 3, 4, 0, 5},
				{8, 6, 6, 6, 6, 6, 6, 6, 6, 10}
				};

	return newDesktop;



    }


    private int[][] thridLevel() {
	int[][] newDesktop = 
				{
				{7, 6, 6, 6, 6, 6, 6, 6, 6, 9},
				{5, 1, 0, 3, 0, 4, 0, 0, 0, 5},
				{5, 0, 0, 3, 0, 4, 0, 0, 0, 5},
				{8, 6, 6, 6, 6, 6, 6, 6, 6, 10}
				};

	return newDesktop;

    }


    private int[][] level4() {
	int[][] newDesktop =  
		{
		{-1,-1,-1,-1, 7, 6, 6, 6, 9,-1},	
		{-1,-1,-1,-1, 5, 0, 0, 0, 5,-1},
		{-1,-1,-1,-1, 5, 3, 0, 0, 5,-1},
		{-1,-1, 7, 6,10, 0, 0, 3, 8, 9},
		{-1,-1, 5, 0, 0, 3, 0, 3, 0, 5},
		{ 7, 6,10, 0, 2, 0, 2, 2, 0, 5,-1,-1,-1, 7, 6, 6, 6, 6, 9},
		{ 5, 0, 0, 0, 2, 0, 2, 2, 0, 8, 6, 6, 6,10, 0, 0, 4, 4, 5},
		{ 5, 0, 3, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 5},
		{ 8, 6, 6, 6, 9, 0, 2, 2, 2, 0, 2, 1, 2, 2, 0, 0, 4, 4, 5},
		{-1,-1,-1,-1, 5, 0, 0, 0, 0, 0, 7, 6, 6, 6, 6, 6, 6, 6,10},
		{-1,-1,-1,-1, 8, 6, 6, 6, 6, 6, 10},
		};

	return newDesktop;

    }

    private int[][] level5() {
	int[][] newDesktop =  
		{
		{7, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 9},
		{5, 4, 4, 0, 0, 2, 0, 0, 0, 0, 0, 8, 6, 9},
		{5, 4, 4, 0, 0, 2, 0, 3, 0, 0, 3, 0, 0, 5},
		{5, 4, 4, 0, 0, 2, 3, 2, 2, 2, 2, 0, 0, 5},
		{5, 4, 4, 0, 0, 0, 0, 1, 0, 2, 2, 0, 0, 5},
		{5, 4, 4, 0, 0, 2, 0, 2, 0, 0, 3, 0, 2, 5},
		{8, 6, 9, 2, 2, 2, 0, 2, 2, 3, 0, 3, 0, 5},
		{-1,-1,5, 0, 3, 0, 0, 3, 0, 3, 0, 3, 0, 5},
		{-1,-1,5, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 5},
		{-1,-1,8, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 10}
		};

	return newDesktop;

    }

    public int[][] loadLevel(String path) {

    		String renat = OpenAndReadFile.readFile(path);
			String egor = Analyze.parseText(renat);

			int[][] newDesktop = Array.createDesktop(egor);

			return newDesktop;
    }

        public int[][] loadNewLevel(String path) {
    		
    		String renat = OpenAndReadFile.readFile(path);
			String egor = Analyze.parseText(renat);

			int[][] newDesktop = Array.createDesktop(egor);

			level = 101;

			return newDesktop;
    }

}

