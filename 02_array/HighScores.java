public class HighScores {
    
    ListArray scores;

    public HighScores()
    {
        scores = new ListArray(10);
    }


    public void addScore(int score)
    {
        if(scores.size() < 10)
        {
            int index = 0;
            while(index < scores.size() && score <scores.get(index))
            {
                index++;
            }
            scores.add(index, score);
        }else
        {
            int lastScore = scores.get(9);
            if(score > lastScore)
            {
                scores.remove(lastScore);
                int index = 0;
                while(index < scores.size() && score <scores.get(index))
                {
                    index++;
                }
                scores.add(index, score);
            }
        }
    }

    public void listScores()
    {
        System.out.println(scores);
    }
    
}
