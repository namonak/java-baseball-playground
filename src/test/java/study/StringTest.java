package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] values = "1".split(",");
        assertThat(values).contains("1");
        values = "1,2".split(",");
        assertThat(values).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("입력값 범위 밖일 경우 StringIndexOutOfBoundsException 확인")
    public void charAt() throws Exception {
        String input = "abc";
        int index = 5;
        assertThatThrownBy(() -> input.charAt(index))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining(String.format("String index out of range: %d", index));
    }
}
