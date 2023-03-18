import codemetropolis.toolchain.converter.control.ConverterLoader;
import codemetropolis.toolchain.converter.control.ConverterType;
import codemetropolis.toolchain.converter.sourcemeter.GraphConverter;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ConverterLoaderTest {

    @Test
    void demoTest() {
        Map<String, String> newMap = new HashMap<>();

        assertNotNull(ConverterLoader.load(ConverterType.SOURCEMETER, newMap));
    }

}
