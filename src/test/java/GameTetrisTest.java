import org.junit.Assert;
import org.junit.Test;

public class GameTetrisTest {
    @Test
    public void isComplexCalculations1WorksCorrectly(){
        Assert.assertEquals(125, GameTetris.complexCalculations1(125));
    }
    @Test
    public void isComplexCalculations2WorksCorrectly(){
        Assert.assertEquals(125, GameTetris.complexCalculations2(125));
    }
    @Test
    public void isComplexCalculations3WorksCorrectly(){
        Assert.assertEquals(125, GameTetris.complexCalculations3(125));
    }
    @Test
    public void isComplexCalculations4WorksCorrectly(){
        Assert.assertEquals(125, GameTetris.complexCalculations4(125));
    }
}
