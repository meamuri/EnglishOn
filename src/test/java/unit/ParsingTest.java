package unit;

import edu.jschool.enon.component.YaTranslator;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

public class ParsingTest {

    private YaTranslator translator;

    @Before
    public void setup() { translator = new YaTranslator(); }

    @Test
    public void notNullResTest() {
        String res = translator.springApiTranslate("feel");
        Assert.notNull(res);
    }

    @Test
    public void countOfWordsTest() {
        String[] words = {"this", "some", "little", "words"};
        Assert.isTrue(translator.springApiTranslateText(words).length == 4);
        String[] two = {"answer", "have to word"};
        Assert.isTrue(translator.springApiTranslateText(two).length == 2);
        String[] none = new String[0];
        Assert.isTrue(translator.springApiTranslateText(none).length == 0);
    }

    @Test
    public void splitWorkCorrectlyTest() {
        String words = "this is some words";
        Assert.isTrue(translator.springApiTranslateText(words).length == 4);
        String two = "answer now have five words";
        Assert.isTrue(translator.springApiTranslateText(two).length == 5);
    }

    @Test
    public void codeResTest() {
        String words = "Picture";
        Assert.isTrue(translator.getJsonResOfTranslating(words).getCode() == 200);

    }
}
