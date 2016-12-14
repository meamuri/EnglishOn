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
    public void wordLengthTest() {
        Assert.notNull(translator.springApiTranslate("feel"));
        //Assert.notEmpty("message", translator.springApiTranslate("feel"));

    }
}
